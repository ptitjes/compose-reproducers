## Steps to reproduce:

1. build the library in `native/`

    ```shell
    make -C libstd-crash/native clean all
    ```

2. run the main in `src/`

    ```shell
    ./gradlew :libstd-crash:run --args="notCrashing"
    ```
    or
    ```shell
    ./gradlew :libstd-crash:run --args="crashing"
    ```