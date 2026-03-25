#include <iostream>
#include <string>
#include <stdlib.h>

extern "C" {
    void native_stuff() {
        unsigned long val = 42;
        std::cout << val << std::endl;
    }
}
