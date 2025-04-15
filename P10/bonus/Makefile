CXXFLAGS = --std=c++20

demo: demo.o ansi.o color.o color_mode.o font.o *.h
	$(CXX) $(CXXFLAGS) demo.o ansi.o color.o color_mode.o font.o -o demo
	@printf "Now type ./demo to execute the result\n\n"

demo.o: demo.cpp *.h
	$(CXX) $(CXXFLAGS) -c demo.cpp -o demo.o

ansi.o: ansi.cpp *.h
	$(CXX) $(CXXFLAGS) -c ansi.cpp -o ansi.o

font.o: font.cpp *.h
	$(CXX) $(CXXFLAGS) -c font.cpp -o font.o

color: color.cpp *.h
	$(CXX) $(CXXFLAGS) -c color.cpp -o color.o

color_mode.o: color_mode.cpp *.h
	$(CXX) $(CXXFLAGS) -c color_mode.cpp -o color_mode.o

# Test code
test_font: test_font.o font.o ansi.o test_utils.o  *.h
	$(CXX) $(CXXFLAGS) test_font.o font.o ansi.o test_utils.o -o test_font
	@printf "Now type ./test_font to execute the result\n\n"

test_font.o: test_font.cpp *.h
	$(CXX) $(CXXFLAGS) -c test_font.cpp -o test_font.o

test_color: test_color.o ansi.o color.o test_utils.o  *.h
	$(CXX) $(CXXFLAGS) test_color.o color.o ansi.o test_utils.o -o test_color
	@printf "Now type ./test_color to execute the result\nor ./test_color bonus if testing the bonus level\n\n"

test_color.o: test_color.cpp *.h
	$(CXX) $(CXXFLAGS) -c test_color.cpp -o test_color.o

test_utils.o: test_utils.cpp *.h
	$(CXX) $(CXXFLAGS) -c test_utils.cpp -o test_utils.o

all: demo test_font test_color

clean:
	rm -f *.o *.gch a.out demo test_font test_color

