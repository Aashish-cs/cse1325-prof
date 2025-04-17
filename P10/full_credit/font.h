#ifndef __FONT_H__
#define __FONT_H__

#include "ansi.h"

#include <iostream>

class Font: public ANSI {
  public:
    Font(int font=0);
    void output(std::ostream& ost) const override;
#ifdef __cpp_impl_three_way_comparison
    auto operator<=>(const Font&) const = default;  // Operators ==, !=, <, <=, >, >=
#else // if the <=> spaceship isn't supported by this compiler
    inline bool operator==(const Font& rhs) {return (compare(rhs) == 0);}
    inline bool operator!=(const Font& rhs) {return (compare(rhs) != 0);}
    inline bool operator< (const Font& rhs) {return (compare(rhs) <  0);}
    inline bool operator<=(const Font& rhs) {return (compare(rhs) <= 0);}
    inline bool operator> (const Font& rhs) {return (compare(rhs) >  0);}
    inline bool operator>=(const Font& rhs) {return (compare(rhs) >= 0);}
#endif

  private:
    int _font;
    
#ifndef __cpp_impl_three_way_comparison
    int compare(const Font& rhs);
#endif
};

#endif
