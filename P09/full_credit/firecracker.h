#ifndef __FIRECRACKER_H_
#define __FIRECRACKER_H_

#include <string>
#include <stdexcept>

class Firecracker {
  public:
    Firecracker(int length);
    virtual ~Firecracker();
    bool tic();
    std::string firecracker();
  private:
    int _length;
};

#endif
