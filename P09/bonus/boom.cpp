#include <iostream>
#include "puzzle.h"
#include "firecracker.h"

int main(int argc, char* argv[]) {
    if(argc != 2) {
        std::cerr << "usage: " << argv[0] << " <solution>" << std::endl;
        return -1;
    }
    
    Firecracker firecracker{8};
    Puzzle puzzle{std::string{argv[1]}};
    const std::string clear{100, '\n'};
    
    char guess;
    std::string guess_solution;
    bool is_winner = false;
    
    std::cout << clear
              << "         =================\n"
              << "             B O O M !\n"
              << "         =================\n\n"
              << "Enter lower case letters to guess,\n"
              << "! to propose a solution,\n"
              << "0 to exit.\n\n";

    while(true) {
        std::cout << '\n' << firecracker.firecracker() << '\n'
                  << "Guessed: " << puzzle.guesses() << '\n'
                  << puzzle.board() << ": ";
        std::cin >> guess; std::cin.ignore();
        
        if(guess == '0') return 0;
        if(guess == '!') {
            std::cout << "Disarming the firecracker - what is the solution? ";
            std::getline(std::cin, guess_solution);
            is_winner = puzzle.solve(guess_solution);
            break;
        }
        try {
            if(!puzzle.guess(guess)) 
                if(!firecracker.tic()) break;
        } catch(std::exception e) {
            std::cerr << "INVALID: " << e.what() << std::endl;
        }
    }
    
    if (is_winner) {
        std::cout << "\n"
                  << "    .-=========-.\n"
                  << "    |   BOOM™   |\n"
                  << "    \\'-=======-'/\n"
                  << "    _|   .=.   |_\n"
                  << "   ((|  {{1}}  |))\n"
                  << "    \\|   \\/|\\   |/\n"
                  << "     \\__ '`' __/\n"
                  << "       _`) (`_\n"
                  << "jgs  _/_______\\_\n"
                  << "    /___________\\\n"
                  << "\n"
                  << "*** W I N N E R ***\n" 
                  << std::endl;
    } else {
        std::cout << "\n"
                  << "   '.  \\ | /  ,'\n"
                  << "     `. `.' ,'\n"
                  << "    ( .`.|,' .)\n"
                  << "    - ~ -0- ~ -\n"
                  << "\n"
                  << "  #### BOOM™ ####\n" 
                  << std::endl;
    }
    std::cout << "The answer was: '" << puzzle.solution() << "'\n" << std::endl;
}
