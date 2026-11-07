package com.example.codequiz.data;

import com.example.codequiz.model.Question;
import com.example.codequiz.util.AppConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CppQuestions {

    public static List<Question> get() {
        List<Question> list = new ArrayList<>();
        String cat = AppConstants.CAT_CPP;
        loadEasy(list, cat);
        loadMedium(list, cat);
        loadHard(list, cat);
        return list;
    }

    private static void loadEasy(List<Question> list, String cat) {
        list.add(new Question("CPP_E_01", cat, "Easy",
                "Which header file is required to use std::cout and std::cin in C++?",
                Arrays.asList("<iostream>", "<stdio.h>", "<conio.h>", "<stream>"),
                "<iostream>",
                "The <iostream> header defines the standard input and output stream objects in C++."));
        list.add(new Question("CPP_E_02", cat, "Easy",
                "Which operator is used with std::cout for output insertion?",
                Arrays.asList(">>", "<<", "::", "->"),
                "<<",
                "The stream insertion operator << inserts formatted data into the output stream."));
        list.add(new Question("CPP_E_03", cat, "Easy",
                "Which of the following is the correct way to declare a constant integer in C++?",
                Arrays.asList("const int MAX = 100;", "constant int MAX = 100;", "int const MAX := 100;", "#define const MAX 100"),
                "const int MAX = 100;",
                "The 'const' keyword is used to declare read-only constant variables in C++."));
        list.add(new Question("CPP_E_04", cat, "Easy",
                "What is the size of the 'char' data type guaranteed to be in standard C++?",
                Arrays.asList("At least 1 byte (strictly 1 char length)", "2 bytes", "4 bytes", "Varies by system"),
                "At least 1 byte (strictly 1 char length)",
                "In C++, sizeof(char) is defined to be exactly 1."));
        list.add(new Question("CPP_E_05", cat, "Easy",
                "Which data type is used to store boolean values 'true' or 'false' in C++?",
                Arrays.asList("bool", "boolean", "bit", "IntBool"),
                "bool",
                "The 'bool' keyword represents boolean logical values true or false in C++."));
        list.add(new Question("CPP_E_06", cat, "Easy",
                "What is the result of 17 % 5 in C++?",
                Arrays.asList("3", "2", "3.4", "0"),
                "2",
                "The modulus operator % calculates the integer remainder of division (17 divided by 5 gives remainder 2)."));
        list.add(new Question("CPP_E_07", cat, "Easy",
                "What is the value of x after: int a = 5; int x = ++a;",
                Arrays.asList("5", "6", "7", "0"),
                "6",
                "The pre-increment operator ++a increments 'a' to 6 first, then assigns 6 to x."));
        list.add(new Question("CPP_E_08", cat, "Easy",
                "Which scope resolution operator is used to access global variables or namespace members?",
                Arrays.asList("::", "->", ".", ":"),
                "::",
                "The double colon :: is the scope resolution operator in C++."));
        list.add(new Question("CPP_E_09", cat, "Easy",
                "Which loop guarantees that its body will execute at least once?",
                Arrays.asList("for loop", "while loop", "do-while loop", "range-based for loop"),
                "do-while loop",
                "A do-while loop evaluates its condition at the end of the iteration, ensuring at least one execution."));
        list.add(new Question("CPP_E_10", cat, "Easy",
                "What is the output of the following C++ code?\n\n#include <iostream>\nint main() {\n    int a = 0;\n    if (a = 5)\n        std::cout << \"True\";\n    else\n        std::cout << \"False\";\n    return 0;\n}",
                Arrays.asList("False", "True", "Compilation Error", "Runtime Error"),
                "True",
                "The assignment expression (a = 5) evaluates to 5, which is non-zero (treated as true), so \"True\" is printed."));
        list.add(new Question("CPP_E_11", cat, "Easy",
                "What is the index of the first element in a standard C++ array?",
                Arrays.asList("0", "1", "-1", "User defined"),
                "0",
                "Arrays in C++ use zero-based indexing."));
        list.add(new Question("CPP_E_12", cat, "Easy",
                "How do you declare a 1D array of 5 integers in C++?",
                Arrays.asList("int arr[5];", "array<int, 5> arr;", "int arr(5);", "int arr[];"),
                "int arr[5];",
                "'int arr[5];' declares a C-style array of 5 integers."));
        list.add(new Question("CPP_E_13", cat, "Easy",
                "Which header file is required to use std::string class in C++?",
                Arrays.asList("<string>", "<cstring>", "<string.h>", "<strings>"),
                "<string>",
                "The <string> header declares std::string and std::wstring classes."));
        list.add(new Question("CPP_E_14", cat, "Easy",
                "Which member function returns the number of characters in std::string s?",
                Arrays.asList("s.length()", "s.size()", "Both s.length() and s.size()", "s.count()"),
                "Both s.length() and s.size()",
                "In std::string, length() and size() are synonyms that return the character count."));
        list.add(new Question("CPP_E_15", cat, "Easy",
                "Which keyword indicates that a function does not return any value?",
                Arrays.asList("null", "void", "empty", "static"),
                "void",
                "The 'void' return type specifies that a function returns no value."));
        list.add(new Question("CPP_E_16", cat, "Easy",
                "What happens when an argument is passed by value to a function in C++?",
                Arrays.asList("A copy of the argument is created", "The function receives the original variable address", "The original variable is modified directly", "A reference is created automatically"),
                "A copy of the argument is created",
                "Passing by value copies the argument's value into the function parameter."));
        list.add(new Question("CPP_E_17", cat, "Easy",
                "Which symbol is used to declare a reference variable in C++?",
                Arrays.asList("*", "&", "->", "@"),
                "&",
                "The ampersand symbol & is used to declare reference types in C++."));
        list.add(new Question("CPP_E_18", cat, "Easy",
                "Which symbol is used to dereference a pointer in C++?",
                Arrays.asList("&", "*", "->", "::"),
                "*",
                "The asterisk * dereferences a pointer, accessing the value stored at the memory address."));
        list.add(new Question("CPP_E_19", cat, "Easy",
                "What is a nullptr in modern C++?",
                Arrays.asList("An integer literal equal to 0", "A strongly-typed null pointer literal of type std::nullptr_t", "A macro defined as (void*)0", "A wild pointer"),
                "A strongly-typed null pointer literal of type std::nullptr_t",
                "Introduced in C++11, nullptr is a type-safe null pointer literal."));
        list.add(new Question("CPP_E_20", cat, "Easy",
                "Which keyword is used to declare a class in C++?",
                Arrays.asList("struct", "class", "object", "type"),
                "class",
                "The 'class' keyword defines a class type in C++."));
        list.add(new Question("CPP_E_21", cat, "Easy",
                "What is the default access specifier for members of a class declared with keyword 'class' in C++?",
                Arrays.asList("public", "private", "protected", "friend"),
                "private",
                "Members of a class are private by default, whereas members of a struct are public by default."));
        list.add(new Question("CPP_E_22", cat, "Easy",
                "What is the default access specifier for members of a C++ 'struct'?",
                Arrays.asList("public", "private", "protected", "internal"),
                "public",
                "Struct members in C++ default to public access."));
        list.add(new Question("CPP_E_23", cat, "Easy",
                "Does a constructor in C++ have a return type?",
                Arrays.asList("Yes, void", "No, constructors have no return type", "Yes, int", "Yes, auto"),
                "No, constructors have no return type",
                "Constructors in C++ do not specify any return type, not even void."));
        list.add(new Question("CPP_E_24", cat, "Easy",
                "What is the correct syntax for declaring a destructor for class 'Car'?",
                Arrays.asList("~Car();", "delete Car();", "void ~Car();", "Car::~Car(void);"),
                "~Car();",
                "Destructors are named with a tilde ~ followed by the class name."));
        list.add(new Question("CPP_E_25", cat, "Easy",
                "How many destructors can a C++ class have?",
                Arrays.asList("Multiple through overloading", "Exactly one", "As many as constructors", "None if constructor is private"),
                "Exactly one",
                "A class can have only one destructor as it takes no parameters and cannot be overloaded."));
        list.add(new Question("CPP_E_26", cat, "Easy",
                "Which keyword is used to establish inheritance between derived and base classes in C++?",
                Arrays.asList("extends", "implements", ":", "inherits"),
                ":",
                "The colon : operator is used to inherit from base classes in C++."));
        list.add(new Question("CPP_E_27", cat, "Easy",
                "In public inheritance, what access level do public members of base class have in derived class?",
                Arrays.asList("private", "protected", "public", "inaccessible"),
                "public",
                "Public inheritance preserves the access level of public base members as public in the derived class."));
        list.add(new Question("CPP_E_28", cat, "Easy",
                "Which access modifier restricts member visibility strictly to within its own class?",
                Arrays.asList("private", "protected", "public", "internal"),
                "private",
                "Private members can only be accessed by member functions and friends of the class."));
        list.add(new Question("CPP_E_29", cat, "Easy",
                "Which access modifier allows visibility within the class and its derived classes?",
                Arrays.asList("private", "protected", "public", "global"),
                "protected",
                "Protected members are accessible inside the class and by derived classes."));
        list.add(new Question("CPP_E_30", cat, "Easy",
                "Which operator is used to allocate dynamic memory on the heap in C++?",
                Arrays.asList("malloc", "alloc", "new", "create"),
                "new",
                "The 'new' operator allocates memory on the free store (heap) and initializes objects."));
        list.add(new Question("CPP_E_31", cat, "Easy",
                "Which operator is used to deallocate dynamic memory allocated with 'new[]' for arrays?",
                Arrays.asList("delete", "delete[]", "free", "free[]"),
                "delete[]",
                "Array dynamic memory allocated with new[] must be freed using delete[]."));
        list.add(new Question("CPP_E_32", cat, "Easy",
                "Which STL container header provides std::vector?",
                Arrays.asList("<vector>", "<array>", "<list>", "<container>"),
                "<vector>",
                "<vector> defines the std::vector dynamic array container."));
        list.add(new Question("CPP_E_33", cat, "Easy",
                "How do you add an element to the end of std::vector<int> v?",
                Arrays.asList("v.add_back(x);", "v.push_back(x);", "v.append(x);", "v.insert_last(x);"),
                "v.push_back(x);",
                "push_back() appends an element to the end of a vector."));
        list.add(new Question("CPP_E_34", cat, "Easy",
                "Which method checks if an STL container has zero elements?",
                Arrays.asList("v.size() == 0", "v.empty()", "Both v.empty() and v.size() == 0", "v.is_null()"),
                "Both v.empty() and v.size() == 0",
                "v.empty() returns true if the container has no elements, equivalent to checking size() == 0."));
        list.add(new Question("CPP_E_35", cat, "Easy",
                "Which block is used to enclose code that might throw an exception in C++?",
                Arrays.asList("catch", "try", "throw", "finally"),
                "try",
                "The 'try' block encloses code that may trigger runtime exceptions."));
        list.add(new Question("CPP_E_36", cat, "Easy",
                "Which keyword is used to signal/raise an exception in C++?",
                Arrays.asList("throw", "raise", "except", "error"),
                "throw",
                "The 'throw' statement raises an exception in C++."));
        list.add(new Question("CPP_E_37", cat, "Easy",
                "How is a static member variable initialized outside the class definition in C++?",
                Arrays.asList("Type ClassName::memberName = value;", "static Type ClassName::memberName = value;", "ClassName.memberName = value;", "Type ClassName.memberName = value;"),
                "Type ClassName::memberName = value;",
                "Static member variables are defined at namespace scope using scope resolution: Type ClassName::memberName = value;"));
        list.add(new Question("CPP_E_38", cat, "Easy",
                "Can a static member function access non-static instance variables of the class directly?",
                Arrays.asList("Yes", "No, because static member functions do not have a 'this' pointer", "Only if they are public", "Only if marked virtual"),
                "No, because static member functions do not have a 'this' pointer",
                "Static member functions lack a 'this' pointer and can only access static members or instance objects passed explicitly."));
        list.add(new Question("CPP_E_39", cat, "Easy",
                "Which standard algorithm sorts elements in a range [first, last) in C++?",
                Arrays.asList("std::sort", "std::order", "std::arrange", "std::qsort"),
                "std::sort",
                "std::sort from <algorithm> sorts elements in a given range."));
        list.add(new Question("CPP_E_40", cat, "Easy",
                "Which output stream object is used for unbuffered error reporting in standard C++?",
                Arrays.asList("std::cout", "std::cerr", "std::clog", "std::cin"),
                "std::cerr",
                "std::cerr is the standard unbuffered error output stream."));
        list.add(new Question("CPP_E_41", cat, "Easy",
                "What does 'auto' keyword do when declaring a variable in C++11 and later?",
                Arrays.asList("Specifies automatic storage duration", "Deduces the variable's type automatically from its initializer", "Makes the variable dynamic", "Declares an asynchronous thread"),
                "Deduces the variable's type automatically from its initializer",
                "In modern C++, auto enables compile-time type deduction based on the initialization expression."));
        list.add(new Question("CPP_E_42", cat, "Easy",
                "What is the result of expression: 5 + 3 * 2 in C++?",
                Arrays.asList("16", "11", "13", "10"),
                "11",
                "Multiplication has higher operator precedence than addition, so 3 * 2 = 6, and 5 + 6 = 11."));
        list.add(new Question("CPP_E_43", cat, "Easy",
                "What is a base condition in a recursive function?",
                Arrays.asList("The line where recursive function calls itself", "The terminating condition that stops recursion", "The initial parameter set", "The return type of function"),
                "The terminating condition that stops recursion",
                "The base condition stops further recursive calls and prevents call stack overflow."));
        list.add(new Question("CPP_E_44", cat, "Easy",
                "What is the result of string concatenation: std::string a = \"Hello \"; std::string b = \"World\"; std::string c = a + b;",
                Arrays.asList("\"Hello World\"", "\"HelloWorld\"", "Compilation Error", "Undefined"),
                "\"Hello World\"",
                "The + operator concatenates std::string objects, producing \"Hello World\"."));
        list.add(new Question("CPP_E_45", cat, "Easy",
                "What statement exits immediately from a loop or switch statement in C++?",
                Arrays.asList("continue", "break", "return", "exit"),
                "break",
                "The break statement terminates execution of the nearest enclosing loop or switch."));
        list.add(new Question("CPP_E_46", cat, "Easy",
                "What is function overloading in C++?",
                Arrays.asList("Defining multiple functions with the same name but different parameter lists in the same scope", "Redefining a base class function in a derived class", "A function calling itself", "Passing too many arguments to a function"),
                "Defining multiple functions with the same name but different parameter lists in the same scope",
                "Function overloading allows functions in the same scope to share a name if their parameter signatures differ."));
        list.add(new Question("CPP_E_47", cat, "Easy",
                "What is the time complexity of accessing an element in an array or std::vector by index?",
                Arrays.asList("O(1)", "O(N)", "O(log N)", "O(N^2)"),
                "O(1)",
                "Random access by index in contiguous arrays takes constant time O(1)."));
        list.add(new Question("CPP_E_48", cat, "Easy",
                "Can a C++ reference be rebound to refer to a different object after initialization?",
                Arrays.asList("Yes", "No, references are bound permanently upon initialization", "Only if declared const", "Only with pointers"),
                "No, references are bound permanently upon initialization",
                "A reference cannot be rebound to another object after its initialization."));
        list.add(new Question("CPP_E_49", cat, "Easy",
                "What privilege does a friend function have regarding a class in C++?",
                Arrays.asList("It can access private and protected members of that class", "It inherits all public members", "It becomes a member function automatically", "It overrides virtual functions"),
                "It can access private and protected members of that class",
                "Friend functions are granted full access to private and protected class members."));
        list.add(new Question("CPP_E_50", cat, "Easy",
                "What is the return type of the main() function in C++ standard?",
                Arrays.asList("void", "int", "bool", "double"),
                "int",
                "According to C++ standards, main() must return int."));
    }

    private static void loadMedium(List<Question> list, String cat) {
        list.add(new Question("CPP_M_01", cat, "Medium",
                "Which of the following function pairs will cause a compilation error due to ambiguous overloading when called with `foo(5)`?",
                Arrays.asList("void foo(int x); and void foo(double x);", "void foo(int x); and void foo(int x, int y = 10);", "void foo(int x); and void foo(std::string x);", "void foo(int x); and void foo(int x, int y);"),
                "void foo(int x); and void foo(int x, int y = 10);",
                "Calling foo(5) is ambiguous because it matches both void foo(int) and void foo(int, int = 10)."));
        list.add(new Question("CPP_M_02", cat, "Medium",
                "What is an initializer list in a C++ constructor used for?",
                Arrays.asList("To initialize member variables directly before the constructor body executes", "To allocate memory for objects", "To initialize local variables inside methods", "To call destructors automatically"),
                "To initialize member variables directly before the constructor body executes",
                "Constructor member initializer lists initialize class data members directly prior to constructor body execution."));
        list.add(new Question("CPP_M_03", cat, "Medium",
                "What is dynamic dispatch in C++?",
                Arrays.asList("Resolving function calls at compile time", "Resolving virtual function calls at runtime based on the actual object type", "Allocating memory dynamically for classes", "Overloading operators at runtime"),
                "Resolving virtual function calls at runtime based on the actual object type",
                "Dynamic dispatch resolves polymorphic virtual function calls at runtime via vtable mechanism."));
        list.add(new Question("CPP_M_04", cat, "Medium",
                "What is the primary function of the vptr (virtual pointer) in C++ objects with virtual functions?",
                Arrays.asList("Points to heap memory allocated for class", "Points to the Virtual Method Table (vtable) for the object's class", "Points to base class instance", "Points to the constructor function"),
                "Points to the Virtual Method Table (vtable) for the object's class",
                "Objects of classes with virtual functions contain a hidden pointer (vptr) pointing to the class's vtable."));
        list.add(new Question("CPP_M_05", cat, "Medium",
                "When is a copy constructor invoked in C++?",
                Arrays.asList("When an object is initialized with another object of the same class", "When an object is passed by value to a function", "When a function returns an object by value", "All of the above"),
                "All of the above",
                "Copy constructors are called when initializing an object from another instance, passing by value, or returning by value."));
        list.add(new Question("CPP_M_06", cat, "Medium",
                "What is the correct syntax to declare a generic function template in C++?",
                Arrays.asList("template <typename T> T maxVal(T a, T b);", "generic <class T> T maxVal(T a, T b);", "template <T> T maxVal(T a, T b);", "type <template T> T maxVal(T a, T b);"),
                "template <typename T> T maxVal(T a, T b);",
                "'template <typename T>' or 'template <class T>' declares a function template."));
        list.add(new Question("CPP_M_07", cat, "Medium",
                "What happens if an exception is thrown in C++ but not caught by any matching catch block in the call stack?",
                Arrays.asList("The exception is ignored silently", "std::terminate() is called automatically, ending execution", "The program retries execution", "Compilation fails"),
                "std::terminate() is called automatically, ending execution",
                "Uncaught exceptions cause the runtime to call std::terminate() (which calls std::abort())."));
        list.add(new Question("CPP_M_08", cat, "Medium",
                "What is the underlying data structure and search time complexity of std::map in standard C++?",
                Arrays.asList("Hash table with O(1) time", "Red-Black Tree (balanced BST) with O(log N) time", "Dynamic Array with O(N) time", "Linked List with O(N) time"),
                "Red-Black Tree (balanced BST) with O(log N) time",
                "std::map is typically implemented as a self-balancing Red-Black tree providing logarithmic O(log N) operations."));
        list.add(new Question("CPP_M_09", cat, "Medium",
                "What is the difference between std::map and std::unordered_map?",
                Arrays.asList("std::map is sorted O(log N); std::unordered_map is hash-based O(1) average time", "std::map uses hashing; std::unordered_map uses BST", "std::unordered_map allows duplicate keys; std::map does not", "There is no difference"),
                "std::map is sorted O(log N); std::unordered_map is hash-based O(1) average time",
                "std::map maintains sorted keys using trees (O(log N)), whereas std::unordered_map uses hash tables (O(1) average)."));
        list.add(new Question("CPP_M_10", cat, "Medium",
                "In C++11 lambda `[=](int x) { return x + a; }`, what does `[=]` signify?",
                Arrays.asList("Capture all outer local variables by value", "Capture all outer local variables by reference", "No variables captured", "Capture 'this' pointer only"),
                "Capture all outer local variables by value",
                "The [=] capture default captures outer local variables used in the lambda body by value."));
        list.add(new Question("CPP_M_11", cat, "Medium",
                "In C++ lambda `[&](int x) { return x + a; }`, what does `[&]` signify?",
                Arrays.asList("Capture outer variables by value", "Capture outer variables by reference", "Compare references", "Address-of operator"),
                "Capture outer variables by reference",
                "The [&] capture default captures outer variables by reference."));
        list.add(new Question("CPP_M_12", cat, "Medium",
                "Which standard stream class is used for reading input from a file in C++?",
                Arrays.asList("std::ofstream", "std::ifstream", "std::fstream", "std::stringstream"),
                "std::ifstream",
                "std::ifstream (input file stream) is used for reading files."));
        list.add(new Question("CPP_M_13", cat, "Medium",
                "What is the worst-case time complexity of Quick Sort algorithm?",
                Arrays.asList("O(N log N)", "O(N)", "O(N^2)", "O(1)"),
                "O(N^2)",
                "Quick sort degrades to O(N^2) in worst-case scenarios when pivot selection is unbalanced."));
        list.add(new Question("CPP_M_14", cat, "Medium",
                "Which of the following C++ operators CANNOT be overloaded?",
                Arrays.asList("+", ":: (Scope Resolution)", "[]", "()"),
                ":: (Scope Resolution)",
                "The scope resolution operator ::, member access operator ., direct pointer-to-member .*, and ternary operator ?: cannot be overloaded."));
        list.add(new Question("CPP_M_15", cat, "Medium",
                "When overloading operator+ as a non-member friend function taking two parameters (A, B), what is the correct declaration?",
                Arrays.asList("friend MyClass operator+(const MyClass& a, const MyClass& b);", "friend MyClass operator+(const MyClass& a);", "MyClass operator+(MyClass b);", "friend void operator+();"),
                "friend MyClass operator+(const MyClass& a, const MyClass& b);",
                "A non-member binary operator overload takes two arguments corresponding to left and right operands."));
        list.add(new Question("CPP_M_16", cat, "Medium",
                "Which algorithm header function searches for a value in a sorted range using binary search?",
                Arrays.asList("std::find", "std::binary_search", "std::search", "std::lower_bound"),
                "std::binary_search",
                "std::binary_search checks if an element exists in a sorted range in O(log N) time."));
        list.add(new Question("CPP_M_17", cat, "Medium",
                "Which STL container adapter implements First-In, First-Out (FIFO) behavior?",
                Arrays.asList("std::stack", "std::queue", "std::priority_queue", "std::vector"),
                "std::queue",
                "std::queue provides FIFO (First-In, First-Out) operations."));
        list.add(new Question("CPP_M_18", cat, "Medium",
                "What is the output of the following C++ program?\n\n#include <iostream>\nclass Test {\npublic:\n    static int count;\n    Test() { count++; }\n};\nint Test::count = 0;\nint main() {\n    Test t1, t2, t3;\n    std::cout << Test::count;\n    return 0;\n}",
                Arrays.asList("0", "1", "3", "Compilation Error"),
                "3",
                "Test::count is incremented by each constructor call. Creating 3 objects sets count to 3."));
        list.add(new Question("CPP_M_19", cat, "Medium",
                "What is a dangling pointer in C++?",
                Arrays.asList("A pointer assigned to nullptr", "A pointer pointing to a memory location that has been deallocated", "An uninitialized reference", "A smart pointer"),
                "A pointer pointing to a memory location that has been deallocated",
                "A dangling pointer stores the memory address of an object that has been freed or destroyed."));
        list.add(new Question("CPP_M_20", cat, "Medium",
                "What happens if you call `delete` on a pointer allocated with `new[]`?",
                Arrays.asList("Only the first element's destructor is called; undefined behavior occurs", "All destructors are called automatically", "Compilation Error", "Memory leak without side effects"),
                "Only the first element's destructor is called; undefined behavior occurs",
                "Mismatching new[] with scalar delete causes undefined behavior (destructors for array elements 1..N-1 are skipped)."));
        list.add(new Question("CPP_M_21", cat, "Medium",
                "What is an abstract class in C++?",
                Arrays.asList("A class with no member variables", "A class containing at least one pure virtual function", "A class marked with keyword 'abstract'", "A class that cannot have subclasses"),
                "A class containing at least one pure virtual function",
                "A class with at least one pure virtual function (virtual void foo() = 0;) is abstract and cannot be instantiated."));
        list.add(new Question("CPP_M_22", cat, "Medium",
                "Which keyword in C++11 explicitly specifies that a member function is intended to override a base class virtual function?",
                Arrays.asList("override", "overload", "virtual", "redefine"),
                "override",
                "The 'override' specifier verifies that a function overrides a base class virtual method at compile time."));
        list.add(new Question("CPP_M_23", cat, "Medium",
                "Which specifier in C++11 prevents a virtual function from being overridden in derived classes?",
                Arrays.asList("sealed", "final", "const", "static"),
                "final",
                "The 'final' specifier prevents further overriding of a virtual function or inheritance of a class."));
        list.add(new Question("CPP_M_24", cat, "Medium",
                "Which smart pointer in C++11 owns an object uniquely and prevents copy assignment?",
                Arrays.asList("std::shared_ptr", "std::unique_ptr", "std::weak_ptr", "std::auto_ptr"),
                "std::unique_ptr",
                "std::unique_ptr represents exclusive ownership; it cannot be copied, only moved."));
        list.add(new Question("CPP_M_25", cat, "Medium",
                "Which smart pointer is used to break cyclic reference dependencies created by std::shared_ptr?",
                Arrays.asList("std::unique_ptr", "std::weak_ptr", "std::scoped_ptr", "std::auto_ptr"),
                "std::weak_ptr",
                "std::weak_ptr holds a non-owning reference to an object managed by std::shared_ptr without incrementing reference count."));
        list.add(new Question("CPP_M_26", cat, "Medium",
                "What does a 'const' qualifier after a member function signature specify?\n`void display() const;`",
                Arrays.asList("The function returns a constant value", "The function cannot modify non-mutable data members of the object", "The function cannot be called on const objects", "The function is static"),
                "The function cannot modify non-mutable data members of the object",
                "Const member functions promise not to alter non-mutable member variables of the calling object."));
        list.add(new Question("CPP_M_27", cat, "Medium",
                "Which keyword allows a class member variable to be modified inside a const member function?",
                Arrays.asList("volatile", "mutable", "extern", "static"),
                "mutable",
                "Members declared 'mutable' can be modified even within const member functions."));
        list.add(new Question("CPP_M_28", cat, "Medium",
                "What is the correct syntax to declare a pure virtual function in C++?",
                Arrays.asList("virtual void draw() = 0;", "pure virtual void draw();", "virtual void draw() = null;", "abstract void draw();"),
                "virtual void draw() = 0;",
                "'virtual ReturnType FunctionName() = 0;' declares a pure virtual function."));
        list.add(new Question("CPP_M_29", cat, "Medium",
                "What is shallow copy versus deep copy in classes managing dynamic memory?",
                Arrays.asList("Shallow copy copies pointers directly (sharing memory); deep copy allocates new memory and copies contents", "Deep copy copies pointers; shallow copy allocates memory", "Shallow copy is for references; deep copy is for pointers", "There is no difference"),
                "Shallow copy copies pointers directly (sharing memory); deep copy allocates new memory and copies contents",
                "Shallow copying duplicates raw pointer addresses leading to shared state; deep copying creates distinct heap resources."));
        list.add(new Question("CPP_M_30", cat, "Medium",
                "Which STL container provides constant time O(1) insertions/deletions at both ends?",
                Arrays.asList("std::vector", "std::deque", "std::set", "std::array"),
                "std::deque",
                "std::deque (double-ended queue) supports O(1) push and pop at both head and tail."));
        list.add(new Question("CPP_M_31", cat, "Medium",
                "What is the output of the following program?\n\n#include <iostream>\nint main() {\n    int a = 10, b = 20;\n    int &ref = a;\n    ref = b;\n    std::cout << a << \" \" << b;\n    return 0;\n}",
                Arrays.asList("10 20", "20 20", "10 10", "Compilation Error"),
                "20 20",
                "ref is an alias for 'a'. Assigning ref = b assigns 20 to 'a', leaving a=20 and b=20."));
        list.add(new Question("CPP_M_32", cat, "Medium",
                "Which standard exception class in <stdexcept> is thrown when memory allocation fails with `new`?",
                Arrays.asList("std::bad_alloc", "std::out_of_range", "std::invalid_argument", "std::runtime_error"),
                "std::bad_alloc",
                "When dynamic memory allocation fails, operator new throws std::bad_alloc."));
        list.add(new Question("CPP_M_33", cat, "Medium",
                "What is the result of calling std::advance(it, 3) on an iterator 'it'?",
                Arrays.asList("Increments iterator 'it' by 3 positions", "Returns a new iterator 3 positions ahead without modifying 'it'", "Sorts 3 elements", "Deletes 3 elements"),
                "Increments iterator 'it' by 3 positions",
                "std::advance modifies the passed iterator in-place by advancing it N steps."));
        list.add(new Question("CPP_M_34", cat, "Medium",
                "Which C++ casting operator is used for safe downcasting in polymorphic class hierarchies at runtime?",
                Arrays.asList("static_cast", "dynamic_cast", "reinterpret_cast", "const_cast"),
                "dynamic_cast",
                "dynamic_cast safely converts pointers/references within class hierarchies using RTTI."));
        list.add(new Question("CPP_M_35", cat, "Medium",
                "Which casting operator removes const or volatile qualifiers from a variable?",
                Arrays.asList("static_cast", "const_cast", "reinterpret_cast", "dynamic_cast"),
                "const_cast",
                "const_cast is explicitly designed to cast away constness or volatility."));
        list.add(new Question("CPP_M_36", cat, "Medium",
                "What is the space complexity of a recursive implementation of depth N due to call stack memory?",
                Arrays.asList("O(1)", "O(N)", "O(N^2)", "O(log N)"),
                "O(N)",
                "Recursion of depth N allocates N stack frames, consuming O(N) auxiliary space."));
        list.add(new Question("CPP_M_37", cat, "Medium",
                "What is the average time complexity of Merge Sort?",
                Arrays.asList("O(N log N)", "O(N^2)", "O(N)", "O(log N)"),
                "O(N log N)",
                "Merge sort guarantees O(N log N) time complexity in best, average, and worst cases."));
        list.add(new Question("CPP_M_38", cat, "Medium",
                "What does RAII stand for in C++ core software engineering?",
                Arrays.asList("Resource Allocation Is Immediate", "Resource Acquisition Is Initialization", "Runtime Array Invalidation Initialization", "Reference Allocation In Inheritance"),
                "Resource Acquisition Is Initialization",
                "RAII (Resource Acquisition Is Initialization) ties resource lifetime to object scope/destruction."));
        list.add(new Question("CPP_M_39", cat, "Medium",
                "What is the purpose of `std::move` from <utility> in C++11?",
                Arrays.asList("Physically moves memory bytes across RAM", "Unconditionally casts an lvalue to an rvalue reference, enabling move semantics", "Copies an object asynchronously", "Deletes an object"),
                "Unconditionally casts an lvalue to an rvalue reference, enabling move semantics",
                "std::move casts an expression to an rvalue reference (T&&) allowing resource transfer."));
        list.add(new Question("CPP_M_40", cat, "Medium",
                "What is template specialization in C++?",
                Arrays.asList("Providing a custom implementation of a template for a specific data type", "Restricting templates to numeric types", "Compiling templates faster", "Inheriting from template classes"),
                "Providing a custom implementation of a template for a specific data type",
                "Template specialization defines tailored implementations for specific template argument types."));
        list.add(new Question("CPP_M_41", cat, "Medium",
                "In a Binary Search Tree (BST), which traversal visits nodes in ascending sorted order?",
                Arrays.asList("Pre-order traversal", "In-order traversal", "Post-order traversal", "Level-order traversal"),
                "In-order traversal",
                "In-order traversal (Left, Root, Right) processes BST nodes in sorted ascending order."));
        list.add(new Question("CPP_M_42", cat, "Medium",
                "What method is used to close an open file stream in C++?",
                Arrays.asList("file.end()", "file.close()", "file.exit()", "file.stop()"),
                "file.close()",
                "close() flushes stream buffers and detaches the stream from the file."));
        list.add(new Question("CPP_M_43", cat, "Medium",
                "What is the output of the following program?\n\n#include <iostream>\nint main() {\n    int arr[] = {10, 20, 30};\n    int *p = arr;\n    std::cout << *p++;\n    return 0;\n}",
                Arrays.asList("10", "20", "30", "Compilation Error"),
                "10",
                "*p++ dereferences current pointer p (10) and then increments pointer p to point to 20."));
        list.add(new Question("CPP_M_44", cat, "Medium",
                "How do you define a custom namespace named 'Physics' in C++?",
                Arrays.asList("namespace Physics { /* ... */ }", "package Physics { /* ... */ }", "using Physics { /* ... */ }", "module Physics { /* ... */ }"),
                "namespace Physics { /* ... */ }",
                "'namespace Physics { ... }' defines a scoped namespace."));
        list.add(new Question("CPP_M_45", cat, "Medium",
                "What is `constexpr` introduced in C++11?",
                Arrays.asList("Specifies that expression/function can be evaluated at compile time", "Makes variable constant at runtime only", "Forces dynamic thread evaluation", "Deprecates const"),
                "Specifies that expression/function can be evaluated at compile time",
                "constexpr guarantees compile-time evaluation for constant expressions and functions."));
        list.add(new Question("CPP_M_46", cat, "Medium",
                "What type of error is caused by accessing `vec[10]` on std::vector `vec` of size 5 using `vec.at(10)`?",
                Arrays.asList("Throws std::out_of_range exception", "Silent memory corruption", "Compilation error", "Returns 0"),
                "Throws std::out_of_range exception",
                "The at() method performs bounds checking and throws std::out_of_range on invalid index access."));
        list.add(new Question("CPP_M_47", cat, "Medium",
                "Which method removes the last element of std::vector in C++?",
                Arrays.asList("v.pop_back()", "v.remove_last()", "v.erase_back()", "v.delete_end()"),
                "v.pop_back()",
                "pop_back() removes the last element and decreases vector size by 1."));
        list.add(new Question("CPP_M_48", cat, "Medium",
                "In what order are object destructors called relative to their constructor invocation order in automatic scope?",
                Arrays.asList("Same order (FIFO)", "Reverse order (LIFO)", "Random order", "Alphabetical order"),
                "Reverse order (LIFO)",
                "Objects on the stack are destroyed in strict reverse order of construction (LIFO)."));
        list.add(new Question("CPP_M_49", cat, "Medium",
                "Can a derived class access private members of its base class directly?",
                Arrays.asList("Yes", "No, private base members are inaccessible to derived classes directly", "Only if using public inheritance", "Only with scope resolution"),
                "No, private base members are inaccessible to derived classes directly",
                "Private members of a base class are preserved private and inaccessible directly by derived classes."));
        list.add(new Question("CPP_M_50", cat, "Medium",
                "What is 'this' pointer in C++ member functions?",
                Arrays.asList("A pointer to the current object instance calling the non-static member function", "A reference to base class", "A static class pointer", "A global runtime pointer"),
                "A pointer to the current object instance calling the non-static member function",
                "The 'this' pointer is an implicit parameter passed to non-static member functions pointing to the invoking object."));
    }

    private static void loadHard(List<Question> list, String cat) {
        list.add(new Question("CPP_H_01", cat, "Hard",
                "Why should a base class destructor almost always be declared `virtual` if the class has virtual functions?",
                Arrays.asList("To allow private member destruction", "To ensure derived class destructors are called when deleting via base pointer", "To compile faster", "To prevent virtual table creation"),
                "To ensure derived class destructors are called when deleting via base pointer",
                "Deleting a derived object through a base class pointer without a virtual destructor causes undefined behavior (derived destructor skipped)."));
        list.add(new Question("CPP_H_02", cat, "Hard",
                "How does C++ solve the 'Diamond Problem' (duplicate base subobjects) in multiple inheritance?",
                Arrays.asList("By using virtual base classes (`class Derived : public virtual Base`)", "By marking destructors explicit", "By using override specifier", "C++ prohibits multiple inheritance"),
                "By using virtual base classes (`class Derived : public virtual Base`)",
                "Virtual base classes ensure that only one shared subobject instance of the base class exists in the inheritance hierarchy."));
        list.add(new Question("CPP_H_03", cat, "Hard",
                "What is the signature of a move constructor for class `Widget` in C++11?",
                Arrays.asList("Widget(const Widget& other);", "Widget(Widget&& other) noexcept;", "Widget(Widget* other);", "Widget(Widget& other);"),
                "Widget(Widget&& other) noexcept;",
                "Move constructors take an rvalue reference `Widget&&` and should be marked `noexcept` for STL optimization."));
        list.add(new Question("CPP_H_04", cat, "Hard",
                "According to the Rule of Five in modern C++, if a class defines a custom destructor, what four other special member functions should it also explicitly define or default/delete?",
                Arrays.asList("Copy constructor, copy assignment, move constructor, move assignment", "Default constructor, parameterized constructor, static constructor, friend function", "Virtual function, pure virtual function, override, final", "Getter, setter, toString, print"),
                "Copy constructor, copy assignment, move constructor, move assignment",
                "The Rule of Five covers Destructor, Copy Constructor, Copy Assignment, Move Constructor, and Move Assignment."));
        list.add(new Question("CPP_H_05", cat, "Hard",
                "What happens when `std::make_shared<T>()` is used instead of `std::shared_ptr<T>(new T())`?",
                Arrays.asList("Allocates object and control block in a single contiguous memory block", "Runs slower but uses less memory", "Prevents move operations", "Allows multiple pointers without reference counting"),
                "Allocates object and control block in a single contiguous memory block",
                "std::make_shared performs a single memory allocation for both object and control block, improving cache locality and efficiency."));
        list.add(new Question("CPP_H_06", cat, "Hard",
                "What is SFINAE in C++ template metaprogramming?",
                Arrays.asList("Substitution Failure Is An Error", "Substitution Failure Is Not An Error", "Static Function Initialization And Evaluation", "Sequential Function Instantiation And Execution"),
                "Substitution Failure Is Not An Error",
                "SFINAE (Substitution Failure Is Not An Error) ignores invalid template argument substitutions during overload resolution rather than failing compilation."));
        list.add(new Question("CPP_H_07", cat, "Hard",
                "Which operation on `std::vector<int>` invalidates ALL existing iterators and references to its elements?",
                Arrays.asList("push_back() when current capacity is exceeded (triggering reallocation)", "Accessing element via operator[]", "Calling v.size()", "Calling v.front()"),
                "push_back() when current capacity is exceeded (triggering reallocation)",
                "When vector capacity is exceeded, reallocation moves all elements to new memory, invalidating all outstanding iterators."));
        list.add(new Question("CPP_H_08", cat, "Hard",
                "What happens if a lambda captures a local automatic variable by reference `[&x]`, and outlives the lifetime of `x`?",
                Arrays.asList("The variable is kept alive automatically on heap", "Invoking the lambda results in undefined behavior (dangling reference)", "Compilation Error", "x converts to nullptr"),
                "Invoking the lambda results in undefined behavior (dangling reference)",
                "Capturing local variables by reference when the lambda outlives their scope produces dangling references and undefined behavior."));
        list.add(new Question("CPP_H_09", cat, "Hard",
                "In C++11 template deduction, what does `T&&` collapse to when instantiated with an lvalue of type `X&`? (Reference Collapsing Rules)",
                Arrays.asList("X&&", "X&", "X", "const X&"),
                "X&",
                "Reference collapsing rules state: & + & -> &, & + && -> &, && + & -> &, && + && -> &&. So X& + && collapses to X&."));
        list.add(new Question("CPP_H_10", cat, "Hard",
                "What is the status of reading an uninitialized local variable of primitive type `int x;` in C++?",
                Arrays.asList("Guaranteed to be 0", "Undefined Behavior (produces indeterminate value)", "Compilation Error", "Throws std::runtime_error"),
                "Undefined Behavior (produces indeterminate value)",
                "Reading uninitialized automatic scalar variables yields indeterminate values, causing undefined behavior."));
        list.add(new Question("CPP_H_11", cat, "Hard",
                "How do you distinguish between pre-increment `++obj` and post-increment `obj++` when overloading member operators in C++?",
                Arrays.asList("Post-increment accepts a dummy int parameter: `Type operator++(int);`", "Pre-increment accepts an int parameter", "Using different function names", "Post-increment returns void"),
                "Post-increment accepts a dummy int parameter: `Type operator++(int);`",
                "The dummy parameter `int` in `operator++(int)` distinguishes post-increment from pre-increment `operator++()`."));
        list.add(new Question("CPP_H_12", cat, "Hard",
                "What does the Strong Exception Safety Guarantee mandate for a function in C++?",
                Arrays.asList("The function never throws exceptions", "If the function throws an exception, program state is rolled back to exactly before the call (commit-or-rollback semantics)", "No memory leaks occur but state may change", "Program terminates safely"),
                "If the function throws an exception, program state is rolled back to exactly before the call (commit-or-rollback semantics)",
                "The strong exception guarantee ensures that if an exception occurs, object and program state remains completely unchanged."));
        list.add(new Question("CPP_H_13", cat, "Hard",
                "Why should move constructors and move assignment operators be marked `noexcept`?",
                Arrays.asList("To allow standard containers like std::vector to safely use move operations during reallocation", "To make them run on GPU", "To disable destructors", "They must not return values"),
                "To allow standard containers like std::vector to safely use move operations during reallocation",
                "std::vector reallocation uses std::move_if_noexcept; without noexcept, vector falls back to copying for strong exception safety."));
        list.add(new Question("CPP_H_14", cat, "Hard",
                "What is non-virtual interface (NVI) idiom in C++ software design?",
                Arrays.asList("Declaring all functions virtual", "Making public base functions non-virtual while delegating to private/protected virtual implementations", "Using templates instead of virtual functions", "Inheriting from abstract structs"),
                "Making public base functions non-virtual while delegating to private/protected virtual implementations",
                "NVI idiom exposes public non-virtual interface methods that enforce invariant checks before calling private/protected virtual implementation methods."));
        list.add(new Question("CPP_H_15", cat, "Hard",
                "What happens when two `std::shared_ptr` objects are created independently from the same raw pointer `int* raw = new int(10);`?",
                Arrays.asList("They share the reference counter correctly", "They create two separate control blocks, resulting in double deletion (undefined behavior)", "Compilation Error", "Second shared_ptr becomes nullptr"),
                "They create two separate control blocks, resulting in double deletion (undefined behavior)",
                "Creating multiple shared_ptrs from a raw pointer independently creates multiple control blocks leading to double free corruption upon destruction."));
        list.add(new Question("CPP_H_16", cat, "Hard",
                "What is Perfect Forwarding in C++11 and what standard function implements it?",
                Arrays.asList("Preserving value categories (lvalue/rvalue) of arguments when passing them using `std::forward<T>()` and forwarding references (`T&&`)", "Passing arguments by pointer using `std::move()`", "Forward declaring classes across headers", "Inlining functions at compile time"),
                "Preserving value categories (lvalue/rvalue) of arguments when passing them using `std::forward<T>()` and forwarding references (`T&&`)",
                "Perfect forwarding uses universal/forwarding references (`T&&`) and `std::forward<T>()` to preserve parameter lvalueness/rvalueness."));
        list.add(new Question("CPP_H_17", cat, "Hard",
                "What is memory alignment and structure padding in C++ classes?",
                Arrays.asList("Inserting unused padding bytes between data members to align variables to architecture memory boundaries", "Sorting class methods alphabetically", "Encapsulating private fields", "Clearing memory to zero"),
                "Inserting unused padding bytes between data members to align variables to architecture memory boundaries",
                "Compilers insert padding bytes between fields to align multi-byte types to CPU word boundaries for efficient bus access."));
        list.add(new Question("CPP_H_18", cat, "Hard",
                "What is the average and worst-case time complexity of lookup in `std::unordered_map`?",
                Arrays.asList("Average O(1), Worst-case O(N)", "Average O(log N), Worst-case O(log N)", "Average O(1), Worst-case O(log N)", "Average O(N), Worst-case O(N^2)"),
                "Average O(1), Worst-case O(N)",
                "std::unordered_map has average O(1) time complexity, but degrades to O(N) worst-case when high hash collisions occur."));
        list.add(new Question("CPP_H_19", cat, "Hard",
                "What does the `[[nodiscard]]` attribute in C++17 warn the developer about?",
                Arrays.asList("Function parameter cannot be null", "The return value of the function should not be discarded/ignored by caller", "The function is deprecated", "The function throws exceptions"),
                "The return value of the function should not be discarded/ignored by caller",
                "[[nodiscard]] issues a compiler warning if a function caller discards its return value."));
        list.add(new Question("CPP_H_20", cat, "Hard",
                "What is strict aliasing rule violation in C++?",
                Arrays.asList("Accessing an object through a pointer of an incompatible type that does not share its effective type (except char/unsigned char)", "Using multiple aliases for namespaces", "Assigning base pointer to derived pointer", "Deleting nullptr"),
                "Accessing an object through a pointer of an incompatible type that does not share its effective type (except char/unsigned char)",
                "Strict aliasing allows compiler optimizations assuming incompatible type pointers don't alias; violating it yields undefined behavior."));
        list.add(new Question("CPP_H_21", cat, "Hard",
                "What is fold expression introduced in C++17?",
                Arrays.asList("Compressing array elements into string", "Syntax for reducing variadic template parameter packs over binary operators", "Folding loops into single instruction", "Lambda capture folding"),
                "Syntax for reducing variadic template parameter packs over binary operators",
                "C++17 fold expressions simplify reductions over variadic template parameter packs (e.g., `(... + args)`)."));
        list.add(new Question("CPP_H_22", cat, "Hard",
                "What is the output of the following C++ code?\n\n#include <iostream>\nstruct A {\n    virtual void show() { std::cout << \"A\"; }\n};\nstruct B : A {\n    void show() { std::cout << \"B\"; }\n};\nint main() {\n    B b;\n    A a = b;\n    a.show();\n    return 0;\n}",
                Arrays.asList("A", "B", "AB", "Compilation Error"),
                "A",
                "Assigning derived object 'b' to base object 'a' causes Object Slicing. 'a' is a pure A object, calling A::show()."));
        list.add(new Question("CPP_H_23", cat, "Hard",
                "What is decltype in C++11?",
                Arrays.asList("Yields the declared type of an expression/variable at compile time", "Casts variables at runtime", "Declares templates", "Allocates dynamic variables"),
                "Yields the declared type of an expression/variable at compile time",
                "decltype inspects and yields the precise declared type of an entity or expression at compile time."));
        list.add(new Question("CPP_H_24", cat, "Hard",
                "Why does `std::make_unique` not allow custom deleters directly compared to `std::unique_ptr` constructor?",
                Arrays.asList("Custom deleters change the type signature of std::unique_ptr<T, Deleter>", "make_unique is deprecated", "Custom deleters require shared_ptr", "It is a bug in C++14"),
                "Custom deleters change the type signature of std::unique_ptr<T, Deleter>",
                "std::unique_ptr type parameter incorporates the Deleter type `unique_ptr<T, Deleter>`; custom deleters alter class type."));
        list.add(new Question("CPP_H_25", cat, "Hard",
                "What is copy elision and Return Value Optimization (RVO)?",
                Arrays.asList("Compiler optimization technique that eliminates unnecessary copying/moving of objects during return by constructing directly in caller target", "Deleting copy constructors manually", "Converting copy to assignment", "Throwing exceptions on copy"),
                "Compiler optimization technique that eliminates unnecessary copying/moving of objects during return by constructing directly in caller target",
                "RVO constructs return objects directly inside the caller's memory space, eliding copy/move constructor calls."));
        list.add(new Question("CPP_H_26", cat, "Hard",
                "Which member operator overload MUST return a reference to `*this` to support chained assignments `a = b = c;`?",
                Arrays.asList("Copy assignment operator `Class& operator=(const Class& rhs)`", "Equality operator `bool operator==(const Class& rhs)`", "Destructor `~Class()`", "Plus operator `Class operator+(const Class& rhs)`"),
                "Copy assignment operator `Class& operator=(const Class& rhs)`",
                "Returning `Class&` by reference allows chaining assignment calls `a = (b = c);`."));
        list.add(new Question("CPP_H_27", cat, "Hard",
                "What happens if an abstract class declares a pure virtual destructor `virtual ~Base() = 0;`?",
                Arrays.asList("The base class destructor must still be provided with a body definition outside class", "Derived classes cannot be instantiated", "Compilation error always", "Destructor is skipped"),
                "The base class destructor must still be provided with a body definition outside class",
                "Base class destructors are always called during derived destruction, so a pure virtual destructor MUST have a definition body."));
        list.add(new Question("CPP_H_28", cat, "Hard",
                "What is the time complexity of `std::vector::insert` at an arbitrary iterator position in the middle of a vector?",
                Arrays.asList("O(1)", "O(N) due to shifting subsequent elements", "O(log N)", "O(N^2)"),
                "O(N) due to shifting subsequent elements",
                "Inserting in the middle of a vector requires shifting all following elements to the right, taking linear time O(N)."));
        list.add(new Question("CPP_H_29", cat, "Hard",
                "What is structured binding introduced in C++17?",
                Arrays.asList("Syntax to unpack tuples, pairs, or structs into individual named variables `auto [x, y] = point;`", "Binding socket addresses", "Linking static libraries", "Overloading operators"),
                "Syntax to unpack tuples, pairs, or structs into individual named variables `auto [x, y] = point;`",
                "Structured bindings allow decomposing tuple-like types or structs into discrete local identifiers."));
        list.add(new Question("CPP_H_30", cat, "Hard",
                "What does `std::optional<T>` in C++17 represent?",
                Arrays.asList("A container that manages a value that may or may not be present", "An optional function parameter", "A dynamic pointer", "A thread handle"),
                "A container that manages a value that may or may not be present",
                "std::optional<T> represents a value wrapper that explicitly conveys presence or absence of a value without heap allocation."));
        list.add(new Question("CPP_H_31", cat, "Hard",
                "What is the average time complexity of `std::sort` in C++ standard library implementations (Introsort)?",
                Arrays.asList("O(N log N) worst-case and average guaranteed", "O(N^2)", "O(N)", "O(2^N)"),
                "O(N log N) worst-case and average guaranteed",
                "Introsort hybrid (Quick sort + Heap sort fallback + Insertion sort) guarantees O(N log N) worst-case time."));
        list.add(new Question("CPP_H_32", cat, "Hard",
                "What is `std::variant<Types...>` introduced in C++17?",
                Arrays.asList("A type-safe, discriminative union container holding one value from a set of alternative types", "An untyped void pointer", "A dynamic array", "A polymorphic base class"),
                "A type-safe, discriminative union container holding one value from a set of alternative types",
                "std::variant is a type-safe union that tracks its active type index."));
        list.add(new Question("CPP_H_33", cat, "Hard",
                "Which standard header file provides multi-threading primitives like `std::thread` in C++11?",
                Arrays.asList("<thread>", "<pthread.h>", "<concurrent>", "<process>"),
                "<thread>",
                "<thread> declares std::thread class for managing concurrent execution threads."));
        list.add(new Question("CPP_H_34", cat, "Hard",
                "What happens if a `std::thread` object is destroyed while still joinable (without calling `join()` or `detach()`)?",
                Arrays.asList("std::terminate() is called immediately", "Thread finishes in background safely", "Thread pauses execution", "Memory is leaked without termination"),
                "std::terminate() is called immediately",
                "Destroying a joinable thread object calls std::terminate(), ending program execution."));
        list.add(new Question("CPP_H_35", cat, "Hard",
                "Which RAII wrapper class automatically locks a `std::mutex` on construction and unlocks it on destruction?",
                Arrays.asList("std::lock_guard", "std::thread_lock", "std::mutex_holder", "std::atomic_lock"),
                "std::lock_guard",
                "std::lock_guard provides RAII-style scope locking for std::mutex."));
        list.add(new Question("CPP_H_36", cat, "Hard",
                "What is `std::string_view` introduced in C++17?",
                Arrays.asList("A non-owning read-only view/reference to a contiguous sequence of characters", "A mutable string buffer", "A thread-safe string", "A null-terminated string converter"),
                "A non-owning read-only view/reference to a contiguous sequence of characters",
                "std::string_view provides zero-copy read-only access to character sequences without allocation."));
        list.add(new Question("CPP_H_37", cat, "Hard",
                "Can a `constexpr` function in C++14 contain loops and conditional statements?",
                Arrays.asList("Yes, C++14 relaxed constexpr restrictions allowing local variables, loops, and branches", "No, constexpr functions can only contain a single return statement", "Only if marked inline", "Only with templates"),
                "Yes, C++14 relaxed constexpr restrictions allowing local variables, loops, and branches",
                "C++14 expanded constexpr capabilities to allow local variables, loops, if statements, and mutations."));
        list.add(new Question("CPP_H_38", cat, "Hard",
                "What is placement new in C++?",
                Arrays.asList("Overload of operator new that constructs an object in a pre-allocated memory buffer address: `new (ptr) Type(args)`", "Allocating memory on secondary storage", "Reallocating pointers", "Moving objects across threads"),
                "Overload of operator new that constructs an object in a pre-allocated memory buffer address: `new (ptr) Type(args)`",
                "Placement new constructs an object directly into a caller-supplied memory address without allocating heap memory."));
        list.add(new Question("CPP_H_39", cat, "Hard",
                "What occurs when signed integer overflow happens in standard C++ (`int x = INT_MAX + 1;`)?",
                Arrays.asList("Undefined Behavior", "Wraps around cleanly using two's complement", "Throws std::overflow_error", "Sets value to 0"),
                "Undefined Behavior",
                "Signed integer overflow is strictly Undefined Behavior in standard C++ (unlike unsigned integer overflow which wraps)."));
        list.add(new Question("CPP_H_40", cat, "Hard",
                "What is the behavior of unsigned integer overflow in C++ (`unsigned int x = UINT_MAX + 1;`)?",
                Arrays.asList("Defined behavior: modulo arithmetic reduction (wraps to 0)", "Undefined behavior", "Compilation Error", "Runtime Exception"),
                "Defined behavior: modulo arithmetic reduction (wraps to 0)",
                "Unsigned integer arithmetic is defined by C++ standard to obey modular arithmetic (2^N reduction)."));
        list.add(new Question("CPP_H_41", cat, "Hard",
                "What is the output of the following C++ code?\n\n#include <iostream>\nint main() {\n    int x = 5;\n    auto f = [x]() mutable { x += 10; return x; };\n    f();\n    std::cout << x;\n    return 0;\n}",
                Arrays.asList("5", "15", "10", "Compilation Error"),
                "5",
                "The lambda captured 'x' by value. 'mutable' allows modifying internal copy inside lambda, leaving outer x unchanged (5)."));
        list.add(new Question("CPP_H_42", cat, "Hard",
                "What is an rvalue reference in C++11 declared with `T&&`?",
                Arrays.asList("A reference that can bind to temporary objects (rvalues), enabling move semantics", "A double pointer reference", "A pointer to a reference", "A const reference to lvalues only"),
                "A reference that can bind to temporary objects (rvalues), enabling move semantics",
                "Rvalue references `T&&` bind to temporary objects, allowing resources to be moved rather than copied."));
        list.add(new Question("CPP_H_43", cat, "Hard",
                "What is Variadic Template in C++11?",
                Arrays.asList("A template that can accept a variable number of template arguments using parameter packs `typename... Args`", "A template with variable variable types", "A template for variadic functions only", "A macro template"),
                "A template that can accept a variable number of template arguments using parameter packs `typename... Args`",
                "Variadic templates accept arbitrary numbers of template parameters using parameter pack syntax `typename... Args`."));
        list.add(new Question("CPP_H_44", cat, "Hard",
                "What is the difference between `std::shared_ptr` and `std::unique_ptr` memory footprint?",
                Arrays.asList("std::unique_ptr has zero memory overhead (same size as raw pointer); std::shared_ptr stores extra control block pointer", "std::unique_ptr is twice as large", "std::shared_ptr has no overhead", "Both have identical sizes"),
                "std::unique_ptr has zero memory overhead (same size as raw pointer); std::shared_ptr stores extra control block pointer",
                "std::unique_ptr carries no overhead over a raw pointer, while std::shared_ptr contains two pointers (object pointer + control block pointer)."));
        list.add(new Question("CPP_H_45", cat, "Hard",
                "What happens if a class defines a move constructor but no copy constructor, and an object is copied?",
                Arrays.asList("Compilation Error (implicitly generated copy operations are deleted when a move operation is declared)", "Falls back to shallow copy", "Falls back to move constructor", "Runtime Exception"),
                "Compilation Error (implicitly generated copy operations are deleted when a move operation is declared)",
                "Declaring a move constructor suppresses the automatic generation of copy constructor/assignment operator."));
        list.add(new Question("CPP_H_46", cat, "Hard",
                "What does `typeid` operator return in C++ when RTTI is enabled?",
                Arrays.asList("A reference to a const `std::type_info` object representing the object's dynamic type", "An integer type code", "A string name directly", "A class pointer"),
                "A reference to a const `std::type_info` object representing the object's dynamic type",
                "typeid returns a const std::type_info& containing type metadata at runtime."));
        list.add(new Question("CPP_H_47", cat, "Hard",
                "Can a constructor be declared `virtual` in C++?",
                Arrays.asList("No, constructors cannot be virtual in C++", "Yes", "Only in abstract classes", "Only with virtual inheritance"),
                "No, constructors cannot be virtual in C++",
                "Constructors cannot be virtual because object dynamic type is established during construction, and vtable pointer is initialized during construction."));
        list.add(new Question("CPP_H_48", cat, "Hard",
                "Can a destructor be declared `virtual` in C++?",
                Arrays.asList("Yes, virtual destructors ensure proper cleanup in polymorphic inheritance hierarchies", "No", "Only if pure virtual", "Only in structs"),
                "Yes, virtual destructors ensure proper cleanup in polymorphic inheritance hierarchies",
                "Virtual destructors are essential in base classes to guarantee derived class destructor execution on dynamic deletion."));
        list.add(new Question("CPP_H_49", cat, "Hard",
                "In C++14, what is a Generic Lambda?",
                Arrays.asList("A lambda whose parameter list uses `auto` (`[](auto x, auto y) { return x + y; }`)", "A lambda declared inside template class", "A lambda returning void", "A lambda capturing templates"),
                "A lambda whose parameter list uses `auto` (`[](auto x, auto y) { return x + y; }`)",
                "C++14 introduced generic lambdas using `auto` parameters, turning the closure's `operator()` into a template method."));
        list.add(new Question("CPP_H_50", cat, "Hard",
                "What is the result of using `std::any` introduced in C++17?",
                Arrays.asList("A type-safe container for single values of any copy-constructible type", "A container for pointers only", "A macro expansion", "An untyped array"),
                "A type-safe container for single values of any copy-constructible type",
                "std::any can hold an instance of any copy-constructible type safely."));
    }
}
