CXXFLAGS = --std=c++20

people: people.o person.o student.o
	-$(CXX) $(CXXFLAGS) people.o person.o student.o -o people
	@printf "Now type ./people to execute the result\n\n"

people.o: person.cpp *.h
	-$(CXX) $(CXXFLAGS) -c people.cpp -o people.o

person.o: person.cpp *.h
	-$(CXX) $(CXXFLAGS) -c person.cpp -o person.o

student.o: student.cpp *.h
	-$(CXX) $(CXXFLAGS) -c student.cpp -o student.o

clean:
	rm -f *.o *.gch a.out people

