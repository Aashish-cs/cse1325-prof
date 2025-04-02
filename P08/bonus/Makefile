CXXFLAGS += --std=c++20

sorted: sorted.cpp *.h
	-$(CXX) $(CXXFLAGS)  sorted.cpp -o sorted
	@printf "Now type ./sorted and some words to execute the result\n\n"

clean:
	rm -f *.o *.gch *~ a.out sorted

