CXXFLAGS = --std=c++20

info:
	@echo
	@printf 'Type e.g., "make auto"  to create program "auto" from auto.cpp\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

book_bad: book_bad.cpp
	-$(CXX) $(CXXFLAGS) book_bad.cpp -o book_bad
	@printf "Now type ./book_bad to execute the result\n\n"

book: book.cpp
	-$(CXX) $(CXXFLAGS) book.cpp -o book
	@printf "Now type ./book to execute the result\n\n"

diamond_bad: diamond_bad.cpp
	@printf "=================================================\n"
	@printf "IMPORTANT: Expecting 'm is ambiguous' error here!\n\n"
	-$(CXX) $(CXXFLAGS) diamond_bad.cpp -o diamond_bad
	@printf "=================================================\n\n"

diamond: diamond.cpp
	-$(CXX) $(CXXFLAGS) diamond.cpp -o diamond
	@printf "Now type ./diamond to execute the result\n\n"

diamond_part_bad: diamond_part_bad.cpp
	@printf "=================================================\n"
	@printf "IMPORTANT: Expecting 'A is ambiguous base of D' error here!\n\n"
	-$(CXX) $(CXXFLAGS) diamond_part_bad.cpp -o diamond_part_bad
	@printf "=================================================\n\n"

diamond_part: diamond_part.cpp
	-$(CXX) $(CXXFLAGS) diamond_part.cpp -o diamond_part
	@printf "Now type ./diamond_part to execute the result\n\n"

multiple_inheritance: multiple_inheritance.cpp
	-$(CXX) $(CXXFLAGS) multiple_inheritance.cpp -o multiple_inheritance
	@printf "Now type ./multiple_inheritance to execute the result\n\n"

foo: foo.cpp
	-$(CXX) $(CXXFLAGS) foo.cpp -o foo
	@printf "Now type ./foo to execute the result\n\n"

all:  book_bad book diamond_bad diamond diamond_part_bad diamond_part multiple_inheritance foo

clean:
	rm -f *.o *.gch a.out  book_bad book diamond_bad diamond diamond_part_bad diamond_part multiple_inheritance foo

