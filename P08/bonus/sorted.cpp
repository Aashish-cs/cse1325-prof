#include <iostream>
#include <algorithm>

int main(int argc, char* argv[]) {
    std::string args[argc];
    
    for(int i=1; i<argc; ++i) {
        std::string s{argv[i]};
        args[i] = s;
    }
    
    std::sort(args, args + argc);
    
    for(auto s : args) std::cout << s << '\n';
}
    
