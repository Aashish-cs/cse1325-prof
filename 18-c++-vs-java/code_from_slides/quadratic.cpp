#include <iostream>
#include <cmath>

int main(int argc, char* argv[]) {
    if(argc != 4) {
        std::cerr << "usage: " << argv[0] << " <a> <b> <c>\n" 
                  << "       for ax^2 + bx + c" << std::endl;
        return -1;
    }

    double a, b, c;
    try {
        a = std::stod(std::string(argv[1]));
        b = std::stod(std::string(argv[2]));
        c = std::stod(std::string(argv[3]));
    } catch(std::exception e) {
        std::cerr << "arguments must be 3 doubles: " << e.what() << std::endl;
        return -2;
    }

    double discriminant = b*b - 4*a*c;

    if (discriminant > 0) {
        double x1 = (-b + sqrt(discriminant)) / (2*a);
        double x2 = (-b - sqrt(discriminant)) / (2*a);
        std::cout << "Roots are " << x1 << " and " << x2 << std::endl;

    } else if (discriminant == 0) {
        double x = -b/(2*a);
        std::cout << "Roots are both " << x << std::endl;
    } else {
        double real = -b/(2*a);
        double imag = sqrt(-discriminant)/(2*a);
        std::cout << std::showpos 
                  << "Roots are " << real <<  imag << "i and "
                                  << real << -imag << "i" << std::endl;
    }
}
