import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import java.lang.foreign.Arena
import java.lang.foreign.FunctionDescriptor
import java.lang.foreign.Linker
import java.lang.foreign.SymbolLookup
import java.lang.foreign.ValueLayout

suspend fun runNativeStuff(): Unit = coroutineScope {
    withContext(Dispatchers.IO) {
        val cwd = System.getProperty("user.dir")
        val libPath = "$cwd/native/libnative.so"

        Arena.ofConfined().use { arena ->
            val linker = Linker.nativeLinker()
            val lib = SymbolLookup.libraryLookup(libPath, arena)

            val printfAddress = lib.find("native_stuff").get()

            val printfDescriptor = FunctionDescriptor.of(
                ValueLayout.JAVA_INT,
                ValueLayout.ADDRESS
            )

            val printf = linker.downcallHandle(printfAddress, printfDescriptor)

            val formatString = arena.allocateFrom("Hello from FFM native_stuff!\n")
            printf.invoke(formatString)
        }
    }
}
