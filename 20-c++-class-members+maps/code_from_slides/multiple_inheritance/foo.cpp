#include <iostream>

class Foo {
    int* _val;
  public:
    Foo(int val) : _val{new int{val}} 
        {log("constructor");}                     // Non-default constructor
    Foo() : Foo(0) 
        {log("default constructor");}             // Default constructor
    Foo(const Foo &rhs) : _val{new int{rhs.get()}} 
        {log("copy constructor");}                // Copy constructor
    Foo& operator=(const Foo &rhs) {              // Copy assignment operator
      if (this != &rhs) _val = new int{rhs.get()};
      log("copy assignment operator");
      return *this;
    }
    virtual ~Foo() 
        {log("destructor"); delete _val;}         // Destructor
    int get() const 
        {log("getter"); return *_val;}            // Getter
    void set(int v) 
        {log("setter"); *_val = v;}               // Setter
  private:
    void log(std::string s) const
        {std::cerr << "[" << s << "] ";}
};

void print(Foo foo) {
    std::cout << "In method print, foo = " << foo.get();
}

int main() {
    {
        std::cout << "\n1: "; Foo foo1;
        {
            std::cout << "\n2: "; Foo foo2 = foo1;
            std::cout << "\n3: "; foo1.set(42);
            std::cout << "\n4: "; print(foo2);
            std::cout << "\n5: "; 
        }
        std::cout << "\n6: "; print(foo1);
        std::cout << "\n7: ";
    }
    std::cout << std::endl;
}
