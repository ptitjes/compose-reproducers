CC = g++
CFLAGS = -Wall -fPIC -shared
TARGET = libnative.so
SRC = native.cc

all: $(TARGET)

$(TARGET): $(SRC)
	$(CC) $(CFLAGS) -o $(TARGET) $(SRC)

clean:
	rm -f $(TARGET)
