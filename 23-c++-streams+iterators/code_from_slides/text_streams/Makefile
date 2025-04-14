CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make read"  to create program "read" from read.cpp\n'
	@printf 'Type e.g., "make Read"  to create program "Read" from Read.java\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

read: read.cpp
	-$(CXX) $(CXXFLAGS) read.cpp -o read
	@printf "Now type './read read.cpp' to execute the result\n\n"

Read: Read.java
	-javac Read.java
	@printf "Now type 'java Read Read.java' to execute the result\n\n"

double_conversions: double_conversions.cpp
	-$(CXX) $(CXXFLAGS) double_conversions.cpp -o double_conversions
	@printf "Now type ./double_conversions to execute the result\n\n"

stringstreams: stringstreams.cpp
	-$(CXX) $(CXXFLAGS) stringstreams.cpp -o stringstreams
	@printf "Now type ./stringstreams to execute the result\n\n"

write: write.cpp
	-$(CXX) $(CXXFLAGS) -o write write.cpp
	@printf "Now type './write test.txt' to execute the result\n\n"

Write: Write.java
	-javac Write.java
	@printf "Now type 'java Write test.txt' to execute the result\n\n"

all:  read Read stringstreams double_conversions write Write

clean:
	rm -f *.class *.o *.gch a.out  read stringstreams double_conversions write test.txt

