package com.example.codequiz.data;

import com.example.codequiz.model.Question;
import com.example.codequiz.util.AppConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CQuestions {

    public static List<Question> get() {
        List<Question> list = new ArrayList<>();
        String cat = AppConstants.CAT_C;

        // --- EASY (17) ---
        list.add(new Question("C_01", cat, "Easy",
                "Who is credited with creating the C programming language?",
                Arrays.asList("Dennis Ritchie", "Bjarne Stroustrup", "James Gosling", "Guido van Rossum"),
                "Dennis Ritchie", "Dennis Ritchie created C between 1969 and 1973 at Bell Laboratories."));

        list.add(new Question("C_02", cat, "Easy",
                "Which header file is required to use printf() and scanf() in C?",
                Arrays.asList("<stdio.h>", "<stdlib.h>", "<conio.h>", "<string.h>"),
                "<stdio.h>", "Standard Input Output header (<stdio.h>) declares printf and scanf."));

        list.add(new Question("C_03", cat, "Easy",
                "What format specifier is used to print an integer using printf()?",
                Arrays.asList("%d", "%f", "%c", "%s"),
                "%d", "%d (or %i) represents signed decimal integers."));

        list.add(new Question("C_04", cat, "Easy",
                "Which operator is used to obtain the memory address of a variable in C?",
                Arrays.asList("&", "*", "->", "%"),
                "&", "The unary ampersand (&) is the address-of operator."));

        list.add(new Question("C_05", cat, "Easy",
                "Which operator is used to dereference a pointer in C?",
                Arrays.asList("*", "&", "->", "."),
                "*", "The asterisk (*) dereferences a pointer to access the value at the address."));

        list.add(new Question("C_06", cat, "Easy",
                "What is the size of a 'char' data type in C according to standard specifications?",
                Arrays.asList("1 byte", "2 bytes", "4 bytes", "8 bytes"),
                "1 byte", "By definition in C standards, sizeof(char) is always 1 byte."));

        list.add(new Question("C_07", cat, "Easy",
                "Every C program must contain which fundamental function to run?",
                Arrays.asList("main()", "start()", "init()", "run()"),
                "main()", "Execution in hosted C environments always begins with main()."));

        list.add(new Question("C_08", cat, "Easy",
                "How do strings terminate in C memory?",
                Arrays.asList("Null character '\\0'", "Newline '\\n'", "Space ' '", "EOF"),
                "Null character '\\0'", "C strings are null-terminated character arrays ending with byte value 0 ('\\0')."));

        list.add(new Question("C_09", cat, "Easy",
                "Which function is used to dynamically allocate memory in C?",
                Arrays.asList("malloc()", "new", "create()", "alloc()"),
                "malloc()", "malloc() from <stdlib.h> dynamically allocates uninitialized heap memory."));

        list.add(new Question("C_10", cat, "Easy",
                "Which function must be called to release dynamically allocated memory?",
                Arrays.asList("free()", "delete", "dealloc()", "release()"),
                "free()", "free() returns previously allocated heap memory back to the system."));

        list.add(new Question("C_11", cat, "Easy",
                "Which keyword defines an immutable or read-only variable in C?",
                Arrays.asList("const", "static", "volatile", "fixed"),
                "const", "The const qualifier indicates that a variable's value cannot be modified."));

        list.add(new Question("C_12", cat, "Easy",
                "What does 'sizeof()' operator return in C?",
                Arrays.asList("Size in bytes as size_t", "Size in bits", "Number of array elements", "Memory address"),
                "Size in bytes as size_t", "sizeof evaluates to the size in bytes of the operand."));

        list.add(new Question("C_13", cat, "Easy",
                "Which loop checks the condition after executing the loop body?",
                Arrays.asList("do-while", "while", "for", "goto"),
                "do-while", "do-while loops test their conditional expression after executing the loop body."));

        list.add(new Question("C_14", cat, "Easy",
                "Which preprocessor directive is used to define symbolic constants in C?",
                Arrays.asList("#define", "#include", "#pragma", "#ifdef"),
                "#define", "#define creates macro definitions and constant replacements before compilation."));

        list.add(new Question("C_15", cat, "Easy",
                "What is the return type of the standard main() function?",
                Arrays.asList("int", "void", "float", "char"),
                "int", "According to C99 and modern standards, main() returns an integer exit code."));

        list.add(new Question("C_16", cat, "Easy",
                "Which header file declares string handling functions like strlen() and strcpy()?",
                Arrays.asList("<string.h>", "<strings.h>", "<stdlib.h>", "<ctype.h>"),
                "<string.h>", "<string.h> contains string manipulation prototypes."));

        list.add(new Question("C_17", cat, "Easy",
                "What is the escape sequence for a horizontal tab in C?",
                Arrays.asList("\\t", "\\n", "\\r", "\\b"),
                "\\t", "\\t outputs a horizontal tab spacing."));

        // --- MEDIUM (17) ---
        list.add(new Question("C_18", cat, "Medium",
                "What is the difference between malloc() and calloc()?",
                Arrays.asList("calloc() initializes allocated memory to zero; malloc() leaves it uninitialized", "calloc() is faster than malloc()", "malloc() takes two arguments; calloc() takes one", "malloc() is for arrays; calloc() is for structs"),
                "calloc() initializes allocated memory to zero; malloc() leaves it uninitialized", "calloc(n, size) zeroes the allocated memory buffer, whereas malloc(size) contains indeterminate garbage values."));

        list.add(new Question("C_19", cat, "Medium",
                "What is a dangling pointer in C?",
                Arrays.asList("A pointer pointing to a memory location that has been deallocated or freed", "A pointer that points to NULL", "A pointer that points to an array", "An uninitialized pointer"),
                "A pointer pointing to a memory location that has been deallocated or freed", "Dangling pointers arise when an object is deleted or deallocated without modifying the pointer value."));

        list.add(new Question("C_20", cat, "Medium",
                "What is the difference between 'struct' and 'union' in C regarding memory allocation?",
                Arrays.asList("Struct allocates separate memory for all members; union allocates memory equal to its largest member", "Union allocates separate memory; struct shares memory", "There is no memory difference", "Struct is heap only; union is stack only"),
                "Struct allocates separate memory for all members; union allocates memory equal to its largest member", "In a union, all members share the same memory location, sized to fit the largest member."));

        list.add(new Question("C_21", cat, "Medium",
                "What does the 'static' keyword do to a local variable inside a function in C?",
                Arrays.asList("Preserves its value between function calls throughout program lifetime", "Prevents modification of the variable", "Makes it globally accessible in other files", "Allocates it on stack"),
                "Preserves its value between function calls throughout program lifetime", "Static local variables persist in the data segment across successive calls to that function."));

        list.add(new Question("C_22", cat, "Medium",
                "What is the meaning of 'int *ptr[10]' in C?",
                Arrays.asList("An array of 10 pointers to integers", "A pointer to an array of 10 integers", "A function returning 10 integers", "A 10-dimensional integer pointer"),
                "An array of 10 pointers to integers", "Subscript [] has higher precedence than *, so ptr is an array of 10 pointers to int."));

        list.add(new Question("C_23", cat, "Medium",
                "What does the 'realloc()' function do in C?",
                Arrays.asList("Resizes an existing dynamically allocated memory block, moving data if necessary", "Frees memory without deallocation", "Reverses array pointers", "Initializes pointer to NULL"),
                "Resizes an existing dynamically allocated memory block, moving data if necessary", "realloc changes the size of the memory block pointed to, preserving original content up to min(old_size, new_size)."));

        list.add(new Question("C_24", cat, "Medium",
                "What happens if you access an array out of bounds in C?",
                Arrays.asList("Undefined behavior (potential crash, data corruption, or silent bug)", "ArrayIndexOutOfBoundsException is thrown", "Compilation error occurs", "Array automatically expands"),
                "Undefined behavior (potential crash, data corruption, or silent bug)", "C performs no runtime bounds checking; out of bounds access invokes undefined behavior."));

        list.add(new Question("C_25", cat, "Medium",
                "What does the 'volatile' qualifier tell the C compiler?",
                Arrays.asList("Prevents the compiler from optimizing out reads/writes, as the value may change externally", "Makes the variable constant", "Forces variable storage in registers", "Synchronizes POSIX threads"),
                "Prevents the compiler from optimizing out reads/writes, as the value may change externally", "volatile informs the compiler that an object may be modified by hardware, ISRs, or concurrent threads."));

        list.add(new Question("C_26", cat, "Medium",
                "What is a segmentation fault (SIGSEGV) in C?",
                Arrays.asList("An OS signal raised when a program accesses an invalid or unauthorized memory address", "A syntax error in macro definition", "A stack overflow caused by loop", "A division by zero error"),
                "An OS signal raised when a program accesses an invalid or unauthorized memory address", "A segfault occurs when a program attempts to read or write memory it does not have permission to access."));

        list.add(new Question("C_27", cat, "Medium",
                "What is the output of 'printf(\"%d\", 5 >> 1);'?",
                Arrays.asList("2", "10", "1", "4"),
                "2", "Right shift (5 >> 1) performs integer division by 2: 5 / 2 = 2."));

        list.add(new Question("C_28", cat, "Medium",
                "Which standard function converts an ASCII string to an integer in C?",
                Arrays.asList("atoi()", "itoa()", "strcat()", "toint()"),
                "atoi()", "atoi() from <stdlib.h> converts string representations of numbers to int."));

        list.add(new Question("C_29", cat, "Medium",
                "What is the role of header guards like '#ifndef HEADER_H ... #endif'?",
                Arrays.asList("Prevent multiple inclusions of the same header file during compilation", "Enforce password protection on C files", "Speed up runtime execution", "Declare global variables"),
                "Prevent multiple inclusions of the same header file during compilation", "Header guards ensure that definitions in a header file are not parsed more than once in a translation unit."));

        list.add(new Question("C_30", cat, "Medium",
                "What does the arrow operator '->' represent in C?",
                Arrays.asList("Shorthand for dereferencing a struct pointer: (*ptr).member", "Bitwise right shift assignment", "Pointer multiplication", "Function pointer call"),
                "Shorthand for dereferencing a struct pointer: (*ptr).member", "ptr->member is syntactic sugar for (*ptr).member."));

        list.add(new Question("C_31", cat, "Medium",
                "What is the storage class that suggests storing a variable in a CPU register?",
                Arrays.asList("register", "auto", "extern", "static"),
                "register", "The register keyword hints to the compiler to store the variable in a fast register if available."));

        list.add(new Question("C_32", cat, "Medium",
                "What is the result of applying 'sizeof' to an array passed as a function argument: 'void f(int arr[])'?",
                Arrays.asList("Size of the pointer (e.g. 4 or 8 bytes), due to array decay", "Total size of the array elements", "Number of elements in array", "0"),
                "Size of the pointer (e.g. 4 or 8 bytes), due to array decay", "Array arguments decay into pointers, so sizeof(arr) returns the size of pointer, not the array size."));

        list.add(new Question("C_33", cat, "Medium",
                "What does 'enum' provide in C?",
                Arrays.asList("A user-defined type consisting of a set of named integer constants", "A floating point numeric vector", "A dynamic array structure", "A thread mutex"),
                "A user-defined type consisting of a set of named integer constants", "Enums define enumerated types with assigned integral values starting from 0 by default."));

        list.add(new Question("C_34", cat, "Medium",
                "What is the purpose of the 'extern' keyword in C?",
                Arrays.asList("Declares a variable or function defined in another source file or translation unit", "Makes a variable local to a block", "Allocates memory on the heap", "Converts code to C++"),
                "Declares a variable or function defined in another source file or translation unit", "extern extends the visibility of variables or functions across multiple files."));

        // --- HARD (16) ---
        list.add(new Question("C_35", cat, "Hard",
                "What is memory alignment and structure padding in C?",
                Arrays.asList("Compilers insert unused bytes between struct members to align data on hardware word boundaries", "Encrypting memory blocks", "Zeroing uninitialized variables", "Compressing struct fields"),
                "Compilers insert unused bytes between struct members to align data on hardware word boundaries", "CPUs access memory more efficiently when data types reside at addresses that are multiples of their size, requiring padding."));

        list.add(new Question("C_36", cat, "Hard",
                "What does the syntax 'int (*func)(int, int)' declare in C?",
                Arrays.asList("A pointer to a function that takes two ints and returns an int", "A function returning an array of two pointers", "A pointer to an array of 2 functions", "A macro function definition"),
                "A pointer to a function that takes two ints and returns an int", "Function pointers hold addresses of executable code blocks taking specified parameters and returning a type."));

        list.add(new Question("C_37", cat, "Hard",
                "What is sequence point in the C standard, and why is 'i = i++' undefined behavior?",
                Arrays.asList("A point in execution where all side effects of previous evaluations are complete; modifying a scalar twice without a sequence point is undefined", "A loop termination statement", "A break instruction", "A thread lock barrier"),
                "A point in execution where all side effects of previous evaluations are complete; modifying a scalar twice without a sequence point is undefined", "Modifying an object multiple times or reading its value and modifying it between consecutive sequence points invokes undefined behavior."));

        list.add(new Question("C_38", cat, "Hard",
                "What does the 'restrict' keyword signify in C99 pointer declarations?",
                Arrays.asList("Hints to the compiler that the pointer is the sole reference to the memory block, enabling aggressive optimizations", "Restricts read permissions", "Disallows pointer arithmetic", "Restricts thread access"),
                "Hints to the compiler that the pointer is the sole reference to the memory block, enabling aggressive optimizations", "restrict tells the compiler that during the lifetime of the pointer, only it (or values derived from it) will access the object."));

        list.add(new Question("C_39", cat, "Hard",
                "What is a flexible array member in C99 structs?",
                Arrays.asList("An incomplete array declaration at the end of a struct: 'int data[];' allocated with variable heap size", "An array that resizes automatically", "A linked list node", "A void pointer array"),
                "An incomplete array declaration at the end of a struct: 'int data[];' allocated with variable heap size", "A struct's last member can have an incomplete array type whose size is determined when malloc is called for the struct."));

        list.add(new Question("C_40", cat, "Hard",
                "What is the difference between little-endian and big-endian byte order?",
                Arrays.asList("Little-endian stores least significant byte at lowest memory address; big-endian stores MSB first", "Little-endian is for floats, big-endian for ints", "Little-endian uses 8 bits, big-endian uses 16 bits", "There is no difference in C"),
                "Little-endian stores least significant byte at lowest memory address; big-endian stores MSB first", "Endianness specifies the byte ordering of multi-byte words in digital computer memory."));

        list.add(new Question("C_41", cat, "Hard",
                "What causes a stack buffer overflow vulnerability in C?",
                Arrays.asList("Writing more data to a stack-allocated buffer than its capacity, overwriting adjacent stack memory and return addresses", "Calling malloc too many times", "Dereferencing NULL", "Running out of heap memory"),
                "Writing more data to a stack-allocated buffer than its capacity, overwriting adjacent stack memory and return addresses", "Unbounded input functions like gets() or strcpy() can overwrite stack frames and hijack control flow."));

        list.add(new Question("C_42", cat, "Hard",
                "What does 'setjmp' and 'longjmp' provide in standard C?",
                Arrays.asList("Non-local jumps that bypass regular function return stacks, often used for exception-like error recovery", "Thread synchronization", "Dynamic memory reallocation", "Heap defragmentation"),
                "Non-local jumps that bypass regular function return stacks, often used for exception-like error recovery", "setjmp saves the execution environment; longjmp restores it, jumping back across stack frames."));

        list.add(new Question("C_43", cat, "Hard",
                "What is the return value of 'printf()' in C?",
                Arrays.asList("The total number of characters successfully printed, or a negative value on error", "Always 0 on success", "A pointer to output stream", "The formatted string itself"),
                "The total number of characters successfully printed, or a negative value on error", "printf() returns the count of written characters, or negative on transmission error."));

        list.add(new Question("C_44", cat, "Hard",
                "What is memory aliasing in C?",
                Arrays.asList("When multiple pointers reference the same memory location, limiting compiler optimizations", "Assigning two names to one variable using typedef", "Duplicating array data", "Creating memory mirrors"),
                "When multiple pointers reference the same memory location, limiting compiler optimizations", "Aliasing happens when two pointers can access the same storage unit, preventing compilers from caching values in registers across writes."));

        list.add(new Question("C_45", cat, "Hard",
                "How can you check if a machine architecture is little-endian in C?",
                Arrays.asList("Cast an unsigned int with value 1 to a char pointer: '*(char*)&val == 1'", "Check sizeof(int)", "Call endian() system call", "Examine sizeof(void*)"),
                "Cast an unsigned int with value 1 to a char pointer: '*(char*)&val == 1'", "In an unsigned int 1 (0x00000001), if the lowest byte is 1, the architecture is little-endian."));

        list.add(new Question("C_46", cat, "Hard",
                "What is the difference between '#include <file.h>' and '#include \"file.h\"'?",
                Arrays.asList("\"file.h\" searches current directory first then system paths; <file.h> searches standard system include directories", "<file.h> is for C++ only", "\"file.h\" only searches system folders", "They are identical"),
                "\"file.h\" searches current directory first then system paths; <file.h> searches standard system include directories", "Quoted includes look in user source directory before compiler system search paths."));

        list.add(new Question("C_47", cat, "Hard",
                "What is the 'offsetof' macro in <stddef.h>?",
                Arrays.asList("Calculates the byte offset of a member within a struct type", "Calculates the total size of struct", "Finds the memory address of a global variable", "Offsets an array pointer by n"),
                "Calculates the byte offset of a member within a struct type", "offsetof(type, member) expands to an integer constant of type size_t indicating the byte distance of member from struct start."));

        list.add(new Question("C_48", cat, "Hard",
                "What does 'qsort()' from <stdlib.h> require to compare elements?",
                Arrays.asList("A comparator function pointer: int (*compar)(const void *, const void *)", "A boolean flag", "Array elements must be integers", "A lambda expression"),
                "A comparator function pointer: int (*compar)(const void *, const void *)", "qsort takes a comparison function returning negative, zero, or positive depending on order."));

        list.add(new Question("C_49", cat, "Hard",
                "What is the hazard of calling 'free(ptr)' twice on the same memory block (double free)?",
                Arrays.asList("Corrupts heap metadata, leading to undefined behavior or security vulnerabilities", "Compiler throws warning at build time", "Memory is freed twice cleanly", "System ignores the second call"),
                "Corrupts heap metadata, leading to undefined behavior or security vulnerabilities", "Double freeing damages allocator internal data structures, often exploitable by attackers."));

        list.add(new Question("C_50", cat, "Hard",
                "Why is 'gets()' deprecated and removed from C11 standard?",
                Arrays.asList("It has no buffer length parameter and inevitably causes buffer overflow", "It was slower than fgets()", "It only supported ASCII", "It conflicted with C++ streams"),
                "It has no buffer length parameter and inevitably causes buffer overflow", "gets() cannot know the target buffer capacity, making it fundamentally unsafe against buffer overflows."));

        return list;
    }
}
