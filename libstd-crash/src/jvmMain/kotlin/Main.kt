import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.window.application
import kotlinx.coroutines.coroutineScope

suspend fun main(args: Array<String>): Unit = coroutineScope {
    if (args.isEmpty()) error("Please provide a command line argument: 'crashing' or 'notCrashing'")

    val arg = args[0]
    if (arg == "crashing") crashing()
    else notCrashing()
}

private suspend fun notCrashing() {
    runNativeStuff()
    application { }
}

private fun crashing() {
    application {
        LaunchedEffect(Unit) {
            runNativeStuff()
        }
    }
}
