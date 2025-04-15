#ifndef __ANSI__
#define __ANSI__


#include <iostream>

class ANSI {
  public:
    auto operator<=>(const ANSI&) const = default;  // Operators ==, !=, <, <=, >, >=
    friend std::ostream& operator<<(std::ostream& ost, const ANSI& ansi);
    virtual void output(std::ostream& ost) const = 0;
  protected:
    const static std::string CSI;
};

#endif
