all: bin/hello.o bin/main.o
	g++ bin/hello.o bin/main.o -o bin/hello.exe

bin/hello.o: source/hello.cpp
	g++ -c source/hello.cpp -o bin/hello.o

bin/main.o: source/main.cpp
	g++ -c source/main.cpp -o bin/main.o


clean:
	rm -f bin/*
	 
