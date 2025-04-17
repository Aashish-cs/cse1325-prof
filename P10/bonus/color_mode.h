#ifndef __COLORMODE_H__
#define __COLORMODE_H__

#include <iostream>

enum class Color_mode {FOREGROUND, BACKGROUND, RESET};

std::ostream& operator<<(std::ostream& ost, const Color_mode& cm);

#endif
