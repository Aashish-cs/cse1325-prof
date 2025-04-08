#include "puzzle.h"

Puzzle::Puzzle(std::string solution) 
    : _solution{solution} {
    if(solution.empty()) throw std::invalid_argument{"Empty puzzle"};
    _guesses.insert(' ');
}
Puzzle::~Puzzle() { }
bool Puzzle::guess(char c) {
    char g = tolower(c);
    if(!std::isalpha(static_cast<unsigned char>(g)))
        throw std::invalid_argument{"Must be alphabetic (a-z)"};
    if(_guesses.count(g) > 0) 
        throw std::invalid_argument{"Already guessed"};
    _guesses.insert(g);
    return _solution.find(g) != std::string::npos;
}
bool Puzzle::solve(std::string phrase) {
    return phrase == _solution;
}
std::string Puzzle::board() {
    std::string result = "";
    for(char c : _solution) 
        result += (_guesses.count(c) > 0) ? c : '_';
    return result;
}
std::string Puzzle::solution() {
    return _solution;
}
std::string Puzzle::guesses() {
    std::string result;
    for(char c : _guesses) result += c;
    return result;
}

