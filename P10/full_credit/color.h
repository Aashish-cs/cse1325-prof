#ifndef __COLOR_H__
#define __COLOR_H__

#include "ansi.h"
#include "color_mode.h"

#include <iostream>

class Color: public ANSI {
  public:
    Color(int red, int green, int blue, Color_mode mode = Color_mode::FOREGROUND);
    Color();
    Color operator+(const Color& c);
    
    void output(std::ostream& ost) const override;  // For Operator <<

  protected:
    const static std::string RGB;
  private:
    Color_mode _mode;
    int _red;
    int _green;
    int _blue;

};

#endif
