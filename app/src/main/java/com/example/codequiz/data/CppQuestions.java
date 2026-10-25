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

        // --- EASY (17) ---
        list.add(new Question("CPP_01", cat, "Easy",
                "Who developed the C++ programming language?",
                Arrays.asList("Bjarne Stroustrup", "Dennis Ritchie", "Ken Thompson", "Linus Torvalds"),
                "Bjarne Stroustrup", "Bjarne Stroustrup developed C++ beginning in 1979 at Bell Labs as 'C with Classes'."));

        list.add(new Question("CPP_02", cat, "Easy",
                "Which standard stream object is used for output in C++?",
                Arrays.asList("std::cout", "std::cin", "std::cerr", "printf"),
                "std::cout", "std::cout (character output) in <iostream> sends formatted output to standard display."));

        list.add(new Question("CPP_03", cat, "Easy",
                "Which operator is called the stream insertion operator in C++?",
                Arrays.asList("<<", ">>", "::", "->"),
                "<<", "The << operator inserts data into output streams like std::cout."));

        list.add(new Question("CPP_04", cat, "Easy",
                "What is the operator used for dynamic memory allocation in C++?",
                Arrays.asList("new", "malloc()", "alloc", "create"),
                "new", "'new' allocates memory on the free store and calls object constructors."));

        list.add(new Question("CPP_05", cat, "Easy",
                "Which operator deallocates memory allocated with 'new'?",
                Arrays.asList("delete", "free()", "destroy", "remove"),
                "delete", "'delete' invokes the destructor and deallocates dynamic memory allocated by 'new'."));

        list.add(new Question("CPP_06", cat, "Easy",
                "What is the scope resolution operator in C++?",
                Arrays.asList("::", "->", ".", ":"),
                "::", "The double colon (::) is the scope resolution operator used to specify namespace or class scope."));

        list.add(new Question("CPP_07", cat, "Easy",
                "Which of the following is an access specifier in C++?",
                Arrays.asList("public", "global", "package", "internal"),
                "public", "C++ provides public, protected, and private access specifiers."));

        list.add(new Question("CPP_08", cat, "Easy",
                "What is the default access specifier for members of a 'class' in C++?",
                Arrays.asList("private", "public", "protected", "friend"),
                "private", "Class members are private by default, whereas struct members are public by default."));

        list.add(new Question("CPP_09", cat, "Easy",
                "What symbol precedes the destructor name in a C++ class?",
                Arrays.asList("~ (Tilde)", "! (Exclamation)", "* (Asterisk)", "# (Hash)"),
                "~ (Tilde)", "Destructors have the same name as the class preceded by a tilde (~)."));

        list.add(new Question("CPP_10", cat, "Easy",
                "Which header file must be included for std::cin and std::cout?",
                Arrays.asList("<iostream>", "<stdio.h>", "<stream.h>", "<conio.h>"),
                "<iostream>", "<iostream> provides definitions for standard input and output streams."));

        list.add(new Question("CPP_11", cat, "Easy",
                "What is the boolean data type keyword in C++?",
                Arrays.asList("bool", "boolean", "BOOL", "bit"),
                "bool", "In C++, 'bool' holds true or false values natively."));

        list.add(new Question("CPP_12", cat, "Easy",
                "What is a reference in C++?",
                Arrays.asList("An alias for an existing variable", "A copy of a variable", "A void pointer", "A macro constant"),
                "An alias for an existing variable", "A reference (declared with &) is an alias or alternative name for an existing object."));

        list.add(new Question("CPP_13", cat, "Easy",
                "Which keyword allows defining generic functions or classes in C++?",
                Arrays.asList("template", "generic", "typename", "interface"),
                "template", "The 'template' keyword enables generic programming and metaprogramming in C++."));

        list.add(new Question("CPP_14", cat, "Easy",
                "Which standard container represents a dynamic contiguous array in C++?",
                Arrays.asList("std::vector", "std::list", "std::map", "std::stack"),
                "std::vector", "std::vector provides dynamic array sizing with contiguous memory storage."));

        list.add(new Question("CPP_15", cat, "Easy",
                "What does 'std::endl' do in addition to printing a newline?",
                Arrays.asList("Flushes the output stream buffer", "Clears the screen", "Terminates the program", "Resets stream formatting"),
                "Flushes the output stream buffer", "std::endl inserts '\\n' and explicitly flushes the stream's buffer."));

        list.add(new Question("CPP_16", cat, "Easy",
                "What keyword prevents an object or member from being modified?",
                Arrays.asList("const", "static", "volatile", "frozen"),
                "const", "const qualifies an object as immutable after initialization."));

        list.add(new Question("CPP_17", cat, "Easy",
                "Can a C++ function have default arguments?",
                Arrays.asList("Yes, specified in the function declaration from right to left", "No, C++ prohibits default arguments", "Only in template functions", "Only for integer arguments"),
                "Yes, specified in the function declaration from right to left", "C++ supports default parameter values assigned starting from the rightmost parameter."));

        // --- MEDIUM (17) ---
        list.add(new Question("CPP_18", cat, "Medium",
                "What is the purpose of a 'virtual' function in C++?",
                Arrays.asList("Enables runtime polymorphism via dynamic dispatch", "Compiles the function into GPU assembly", "Makes the function static", "Prevents overriding in derived classes"),
                "Enables runtime polymorphism via dynamic dispatch", "Virtual functions allow derived classes to override methods called via base class pointers or references dynamically."));

        list.add(new Question("CPP_19", cat, "Medium",
                "What is a pure virtual function and what does it define?",
                Arrays.asList("A virtual function assigned '= 0'; makes the class an abstract base class", "A function with no arguments", "A function written in assembly", "A function with no return type"),
                "A virtual function assigned '= 0'; makes the class an abstract base class", "A pure virtual function has no definition in the base class and forces derived classes to implement it."));

        list.add(new Question("CPP_20", cat, "Medium",
                "What is RAII (Resource Acquisition Is Initialization) in C++?",
                Arrays.asList("A pattern where resource lifecycle is bound to object lifetime via constructor and destructor", "An algorithm for initial array sorting", "A compiler optimization flag", "A multi-threading mutex mechanism"),
                "A pattern where resource lifecycle is bound to object lifetime via constructor and destructor", "RAII guarantees resource release (memory, file handles, locks) when stack-allocated objects exit scope."));

        list.add(new Question("CPP_21", cat, "Medium",
                "Why should base class destructors almost always be declared 'virtual'?",
                Arrays.asList("To ensure the derived class destructor is called when deleting via a base pointer", "To improve compiler speed", "To make destructors private", "To allocate destructors on heap"),
                "To ensure the derived class destructor is called when deleting via a base pointer", "Deleting a derived object through a base pointer with a non-virtual destructor results in undefined behavior and memory leaks."));

        list.add(new Question("CPP_22", cat, "Medium",
                "What does 'std::unique_ptr' provide in C++11?",
                Arrays.asList("Exclusive-ownership smart pointer that automatically deletes the resource when out of scope", "A pointer that can be shared among multiple threads", "A raw pointer with no destructor", "A circular reference detector"),
                "Exclusive-ownership smart pointer that automatically deletes the resource when out of scope", "unique_ptr owns and manages another object through a pointer and disposes of that object when the unique_ptr goes out of scope."));

        list.add(new Question("CPP_23", cat, "Medium",
                "What is the difference between 'std::shared_ptr' and 'std::unique_ptr'?",
                Arrays.asList("shared_ptr retains reference counting for shared ownership; unique_ptr enforces unique ownership", "unique_ptr has higher memory overhead", "shared_ptr cannot be copied", "unique_ptr is deprecated"),
                "shared_ptr retains reference counting for shared ownership; unique_ptr enforces unique ownership", "shared_ptr maintains a control block with a reference count, freeing the object when count reaches zero."));

        list.add(new Question("CPP_24", cat, "Medium",
                "What is the diamond problem in C++ multiple inheritance?",
                Arrays.asList("Ambiguity and duplication when two classes inherit from a base, and a fourth class inherits from both", "A memory alignment crash", "A compilation error in template recursion", "A deadlock in thread pools"),
                "Ambiguity and duplication when two classes inherit from a base, and a fourth class inherits from both", "The diamond problem occurs when class D inherits from B and C, which both inherit from A, resolved via virtual inheritance."));

        list.add(new Question("CPP_25", cat, "Medium",
                "How is the diamond problem resolved in C++?",
                Arrays.asList("Using virtual base classes ('virtual public Base')", "Using friend classes", "Using static methods", "Multiple inheritance is prohibited"),
                "Using virtual base classes ('virtual public Base')", "Virtual inheritance ensures only one common base subobject is shared among derived classes."));

        list.add(new Question("CPP_26", cat, "Medium",
                "What is the Rule of Three in classical C++?",
                Arrays.asList("If a class defines Destructor, Copy Constructor, or Copy Assignment, it should define all three", "All classes must have 3 member variables", "Inheritance depth cannot exceed 3", "Functions can take at most 3 arguments"),
                "If a class defines Destructor, Copy Constructor, or Copy Assignment, it should define all three", "Managing manual resources necessitates explicit handling of destructor, copy constructor, and copy assignment operator."));

        list.add(new Question("CPP_27", cat, "Medium",
                "What does 'explicit' keyword on a constructor prevent?",
                Arrays.asList("Implicit conversions and copy-initialization from the argument type", "Direct instantiation", "Multiple inheritance", "Subclassing"),
                "Implicit conversions and copy-initialization from the argument type", "Marking single-argument constructors 'explicit' prevents unwanted implicit type coercion."));

        list.add(new Question("CPP_28", cat, "Medium",
                "What is an rvalue reference in C++11 syntax?",
                Arrays.asList("Type declared with '&&' that binds to temporary objects (rvalues)", "A constant pointer reference", "A reference to a member variable", "A reference to a thread handle"),
                "Type declared with '&&' that binds to temporary objects (rvalues)", "Rvalue references (T&&) allow detecting temporary objects to enable move semantics."));

        list.add(new Question("CPP_29", cat, "Medium",
                "What is move semantics in C++11?",
                Arrays.asList("Transferring ownership of internal resources from a temporary object rather than expensive deep copying", "Moving variables between CPU registers", "Migrating threads between CPU cores", "Moving code to shared libraries"),
                "Transferring ownership of internal resources from a temporary object rather than expensive deep copying", "Move semantics avoids unnecessary deep copies by stealing pointers from expendable temporaries."));

        list.add(new Question("CPP_30", cat, "Medium",
                "What does 'std::move' actually do?",
                Arrays.asList("Unconditionally casts its argument to an rvalue reference", "Moves memory bytes on the heap", "Copies the object to a temporary file", "Terminates the object lifetime"),
                "Unconditionally casts its argument to an rvalue reference", "std::move does not move anything by itself; it performs a static_cast to an rvalue reference (static_cast<T&&>(arg))."));

        list.add(new Question("CPP_31", cat, "Medium",
                "What does the 'friend' keyword allow in C++?",
                Arrays.asList("Grants a specified external function or class access to private and protected members", "Shares global variables with other processes", "Imports external DLL libraries", "Enables public inheritance automatically"),
                "Grants a specified external function or class access to private and protected members", "A friend function or class is granted full access to internal private/protected state."));

        list.add(new Question("CPP_32", cat, "Medium",
                "What is a 'vtable' (virtual method table)?",
                Arrays.asList("A lookup table of function pointers used by the compiler to resolve virtual function calls dynamically", "A database table in SQLite", "A visual rendering buffer", "A vector of template types"),
                "A lookup table of function pointers used by the compiler to resolve virtual function calls dynamically", "Classes with virtual functions contain a hidden pointer (_vptr) pointing to the class vtable for runtime dispatch."));

        list.add(new Question("CPP_33", cat, "Medium",
                "Which cast is used in C++ for safe downcasting in polymorphic class hierarchies?",
                Arrays.asList("dynamic_cast", "static_cast", "reinterpret_cast", "const_cast"),
                "dynamic_cast", "dynamic_cast relies on RTTI to safely cast pointers/references in polymorphic hierarchies, returning nullptr or throwing bad_cast on failure."));

        list.add(new Question("CPP_34", cat, "Medium",
                "What is the difference between 'std::map' and 'std::unordered_map'?",
                Arrays.asList("std::map is an ordered Red-Black tree O(log n); unordered_map is a hash table O(1) avg", "map uses hashing; unordered_map uses trees", "map cannot store strings", "unordered_map is always ordered alphabetically"),
                "std::map is an ordered Red-Black tree O(log n); unordered_map is a hash table O(1) avg", "std::map stores sorted keys using self-balancing BSTs; std::unordered_map stores buckets using hash functions."));

        // --- HARD (16) ---
        list.add(new Question("CPP_35", cat, "Hard",
                "What is SFINAE in C++ template metaprogramming?",
                Arrays.asList("Substitution Failure Is Not An Error; invalid template argument substitutions are discarded from overload sets", "Static Function Inlining And Execution", "Synchronized Fast Iteration And Evaluation", "Stream Formatting In Native Array Execution"),
                "Substitution Failure Is Not An Error; invalid template argument substitutions are discarded from overload sets", "SFINAE allows template overloads to be conditionally enabled/disabled based on type traits without causing compilation failures."));

        list.add(new Question("CPP_36", cat, "Hard",
                "What is perfect forwarding and which helper function enables it?",
                Arrays.asList("Preserving the value category (lvalue/rvalue) of arguments forwarded to another function using 'std::forward'", "Passing arguments in registers only", "Copying memory directly without constructor calls", "Calling a function in multiple threads simultaneously"),
                "Preserving the value category (lvalue/rvalue) of arguments forwarded to another function using 'std::forward'", "std::forward with forwarding references (universal references) preserves whether the original caller passed an lvalue or rvalue."));

        list.add(new Question("CPP_37", cat, "Hard",
                "What is the difference between 'constexpr' and 'const' in modern C++?",
                Arrays.asList("'constexpr' guarantees compile-time evaluation where possible; 'const' only guarantees runtime immutability", "'const' executes at compile time; 'constexpr' does not", "They are 100% interchangeable synonyms", "'constexpr' is only for floating point values"),
                "'constexpr' guarantees compile-time evaluation where possible; 'const' only guarantees runtime immutability", "constexpr expressions and functions can be computed completely during compilation, enabling zero-cost runtime execution."));

        list.add(new Question("CPP_38", cat, "Hard",
                "What does 'std::weak_ptr' solve when working with 'std::shared_ptr'?",
                Arrays.asList("Breaks cyclic reference cycles that would otherwise prevent memory deallocation", "Makes shared_ptr lock-free", "Increases pointer dereference speed", "Allows pointer creation without memory allocation"),
                "Breaks cyclic reference cycles that would otherwise prevent memory deallocation", "weak_ptr observes an object managed by shared_ptr without incrementing the reference count, preventing circular dependency leaks."));

        list.add(new Question("CPP_39", cat, "Hard",
                "What is Small String Optimization (SSO) in modern C++ standard libraries?",
                Arrays.asList("Storing short strings directly within the std::string object buffer rather than allocating heap memory", "Compressing strings using Huffman encoding", "Converting characters to ASCII", "Restricting string length to 16 bytes"),
                "Storing short strings directly within the std::string object buffer rather than allocating heap memory", "SSO avoids expensive dynamic heap allocation for short strings by utilizing the object's internal stack space."));

        list.add(new Question("CPP_40", cat, "Hard",
                "What is the Rule of Five introduced in C++11?",
                Arrays.asList("Destructor, Copy Constructor, Copy Assignment, Move Constructor, and Move Assignment Operator", "Rules for 5 design patterns in OOP", "Limit of 5 template parameters", "Guidelines for 5 CPU cache levels"),
                "Destructor, Copy Constructor, Copy Assignment, Move Constructor, and Move Assignment Operator", "When managing a resource, move semantics requires handling move constructor and move assignment alongside the original 3 special members."));

        list.add(new Question("CPP_41", cat, "Hard",
                "What is CRTP (Curiously Recurring Template Pattern) and what is its main benefit?",
                Arrays.asList("A class derives from a template instantiated with itself, providing static (compile-time) polymorphism without vtable overhead", "A recursive loop for linked lists", "A memory debugging pattern", "A factory pattern for plugins"),
                "A class derives from a template instantiated with itself, providing static (compile-time) polymorphism without vtable overhead", "CRTP avoids virtual function call overhead by resolving polymorphic method calls at compile time."));

        list.add(new Question("CPP_42", cat, "Hard",
                "What is the memory order 'std::memory_order_relaxed' in C++ atomics?",
                Arrays.asList("Guarantees atomicity of the operation, but provides no synchronization or happens-before ordering constraints", "Ensures sequential consistency across all threads", "Performs full memory fence", "Locks the thread mutex"),
                "Guarantees atomicity of the operation, but provides no synchronization or happens-before ordering constraints", "Relaxed memory order only guarantees that individual read/write operations on the atomic variable are atomic."));

        list.add(new Question("CPP_43", cat, "Hard",
                "What is Copy Elision and Return Value Optimization (RVO)?",
                Arrays.asList("Compiler optimization that omits copy and move constructors by constructing return values directly in the caller's storage", "Deleting duplicate classes at link time", "Converting values to pointers", "Garbage collection in C++"),
                "Compiler optimization that omits copy and move constructors by constructing return values directly in the caller's storage", "RVO eliminates temporary object construction, constructing the returned object directly at destination memory (mandatory in C++17)."));

        list.add(new Question("CPP_44", cat, "Hard",
                "What does 'noexcept' specifier communicate to the C++ compiler?",
                Arrays.asList("Declares that a function will not throw exceptions, enabling compiler optimizations like move operations in vector resizing", "Catches all exceptions automatically", "Throws bad_alloc if memory fails", "Forces function inlining"),
                "Declares that a function will not throw exceptions, enabling compiler optimizations like move operations in vector resizing", "noexcept informs the runtime that std::terminate should be called if an exception escapes, allowing containers to safely move objects."));

        list.add(new Question("CPP_45", cat, "Hard",
                "What is the difference between 'reinterpret_cast' and 'static_cast'?",
                Arrays.asList("reinterpret_cast treats bits as another type with no type checking; static_cast performs well-defined compile-time conversions", "static_cast is unsafe; reinterpret_cast is type-safe", "reinterpret_cast is only for strings", "There is no difference"),
                "reinterpret_cast treats bits as another type with no type checking; static_cast performs well-defined compile-time conversions", "reinterpret_cast reinterprets raw memory bit patterns without conversion logic; static_cast validates type relationships."));

        list.add(new Question("CPP_46", cat, "Hard",
                "What is Placement New in C++?",
                Arrays.asList("Constructing an object at a pre-allocated specific memory address: 'new (address) Type()'", "Allocating memory on GPU", "Placing objects in global data segment", "Assigning memory to CPU cache"),
                "Constructing an object at a pre-allocated specific memory address: 'new (address) Type()'", "Placement new initializes an object in a user-provided raw memory buffer without allocating new memory."));

        list.add(new Question("CPP_47", cat, "Hard",
                "How does 'std::atomic<T>' differ from volatile variables in C++?",
                Arrays.asList("std::atomic provides hardware-level atomic operations and thread synchronization; volatile does not guarantee thread safety in C++", "volatile is thread safe; atomic is not", "std::atomic only works for booleans", "They are identical in C++11"),
                "std::atomic provides hardware-level atomic operations and thread synchronization; volatile does not guarantee thread safety in C++", "In C++, volatile prevents compiler register caching but does not guarantee atomic access or memory fences for concurrent threads."));

        list.add(new Question("CPP_48", cat, "Hard",
                "What is Type Trait in <type_traits>?",
                Arrays.asList("Compile-time templates that inspect or transform properties of types (e.g. std::is_integral<T>::value)", "Runtime type introspection system", "A class for debugging memory leaks", "A graphics rendering trait"),
                "Compile-time templates that inspect or transform properties of types (e.g. std::is_integral<T>::value)", "Type traits query and transform type characteristics at compile-time, driving template metaprogramming."));

        list.add(new Question("CPP_49", cat, "Hard",
                "What are Concepts introduced in C++20?",
                Arrays.asList("Named compile-time predicates that constrain template arguments and improve compiler error messages", "New keywords replacing classes", "Runtime object validation checks", "Memory profiling abstractions"),
                "Named compile-time predicates that constrain template arguments and improve compiler error messages", "Concepts specify requirements on template parameters, giving clear compile-time error diagnostics when requirements are unsatisfied."));

        list.add(new Question("CPP_50", cat, "Hard",
                "What is Undefined Behavior (UB) in the C++ standard?",
                Arrays.asList("Code execution where the C++ standard imposes no requirements on program behavior", "A compilation warning", "A caught runtime exception", "A graceful application exit"),
                "Code execution where the C++ standard imposes no requirements on program behavior", "When UB occurs (e.g. out-of-bounds access, null dereference, data race), compilers can make arbitrary assumptions leading to crashes or unpredictable bugs."));

        return list;
    }
}
