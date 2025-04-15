#include "font.h"

Font::Font(int font): _font{font} { }

void Font::output(std::ostream& ost) const {
    ost << ANSI::CSI << _font << 'm';
}

#ifndef __cpp_impl_three_way_comparison
int Font::compare(const Font& rhs) {
    return _font - rsh._font;
}
#endif

