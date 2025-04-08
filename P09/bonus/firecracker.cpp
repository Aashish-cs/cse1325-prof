#include "firecracker.h"

Firecracker::Firecracker(int length) 
    : _length{length} {
    if(_length < 3) throw std::invalid_argument{"Fuse too short"};
}
Firecracker::~Firecracker() { }
bool Firecracker::tic() {
    if(_length > 0) --_length;
    return _length > 0;
}
std::string Firecracker::firecracker() {
    /*
      ------
     | BOOM |----*
      ------
    */
    std::string result = "  ------\n";
    result += " | BOOM |";// + std::string{_length, '-'} + "\n";
    for(int i=1; i<_length; ++i) result += "-";
    result += "*\n  ------\n";
    return result; 
}

