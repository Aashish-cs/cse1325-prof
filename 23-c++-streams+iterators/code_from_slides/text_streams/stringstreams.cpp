#include <iostream>
#include <sstream>
#include <iomanip>

int main() {
    // Input string stream
    std::string phrase = "Now is the time";
    std::istringstream iss{phrase};
    std::string s;
    while(iss >> s) std::cout << s << std::endl;
    
    // Output string stream (format string with I/O manipulators)
    int age = 21;
    std::ostringstream oss;
    oss << "My age is " << std::setfill('0') << std::setw(4) << age;
    std::string rpt = oss.str(); // rpt = “My age is 0021”
    std::cout << '\n' << rpt << std::endl;
}
