#ifndef __PUZZLE_H_
#define __PUZZLE_H_

#include <string>
#include <set>
#include <stdexcept>

class Puzzle {
  public:
    Puzzle(std::string solution);
    virtual ~Puzzle();
    bool guess(char c);
    bool solve(std::string phrase);
    std::string board();
    std::string solution();
    std::string guesses();
  private:
    std::string _solution;
    std::set<char> _guesses;
};

#endif
