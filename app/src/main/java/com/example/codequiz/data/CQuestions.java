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
        loadEasy(list, cat);
        loadMedium(list, cat);
        loadHard(list, cat);
        return list;
    }

    private static void loadEasy(List<Question> list, String cat) {
        list.add(new Question("C_E_01", cat, "Easy",
                "Which function is the mandatory entry point for a standard C program?",
                Arrays.asList("start()", "main()", "init()", "run()"),
                "main()",
                "Every standard C program must have a main() function which serves as the execution entry point."));
        list.add(new Question("C_E_02", cat, "Easy",
                "Which preprocessor directive is used to include standard input-output header file in C?",
                Arrays.asList("#import <stdio.h>", "#include <stdio.h>", "#use <stdio.h>", "#include <iostream>"),
                "#include <stdio.h>",
                "The '#include <stdio.h>' directive tells the preprocessor to insert the contents of stdio.h header file."));
        list.add(new Question("C_E_03", cat, "Easy",
                "What is the correct format specifier for printing a double value using printf?",
                Arrays.asList("%d", "%c", "%lf", "%s"),
                "%lf",
                "%lf (or %f in C99+) is used as the format specifier for double floating-point numbers in printf/scanf."));
        list.add(new Question("C_E_04", cat, "Easy",
                "Which of the following is a valid C identifier name?",
                Arrays.asList("2total", "total_sum", "int", "total-sum"),
                "total_sum",
                "Identifiers in C can contain letters, digits, and underscores, but cannot start with a digit or use reserved keywords/hyphens."));
        list.add(new Question("C_E_05", cat, "Easy",
                "How many keywords are reserved in standard C89/C90?",
                Arrays.asList("32", "48", "64", "25"),
                "32",
                "Standard ANSI C (C89) defines 32 reserved keywords."));
        list.add(new Question("C_E_06", cat, "Easy",
                "What is the typical size of a 'char' data type in standard C?",
                Arrays.asList("1 byte", "2 bytes", "4 bytes", "8 bytes"),
                "1 byte",
                "In C standard, sizeof(char) is strictly defined to be 1 byte."));
        list.add(new Question("C_E_07", cat, "Easy",
                "What is the result of the integer division expression 7 / 2 in C?",
                Arrays.asList("3.5", "3", "4", "3.0"),
                "3",
                "Integer division in C truncates the fractional part towards zero, yielding 3."));
        list.add(new Question("C_E_08", cat, "Easy",
                "Which operator is used to find the remainder of integer division in C?",
                Arrays.asList("/", "\\", "%", "#"),
                "%",
                "The modulus operator '%' computes the remainder after integer division."));
        list.add(new Question("C_E_09", cat, "Easy",
                "What is the value of x after evaluating: int x = 5; x += 3 * 2;",
                Arrays.asList("16", "11", "13", "10"),
                "11",
                "Multiplication has higher precedence than addition. 3 * 2 = 6, and x += 6 results in 5 + 6 = 11."));
        list.add(new Question("C_E_10", cat, "Easy",
                "Which statement is true regarding the condition evaluation in an 'if' statement in C?",
                Arrays.asList("Only 1 is true", "Any non-zero value is treated as true", "Only positive numbers are true", "Only true keyword is supported"),
                "Any non-zero value is treated as true",
                "In C, any non-zero numeric value evaluates to logical true, while zero evaluates to false."));
        list.add(new Question("C_E_11", cat, "Easy",
                "What is the output of the following C code snippet?\n\n#include <stdio.h>\nint main(void) {\n    int a = 0;\n    if (a = 5)\n        printf(\"True\");\n    else\n        printf(\"False\");\n    return 0;\n}",
                Arrays.asList("False", "True", "Compilation Error", "Nothing is printed"),
                "True",
                "The expression (a = 5) assigns 5 to 'a' and evaluates to 5, which is non-zero (true). Thus 'True' is printed."));
        list.add(new Question("C_E_12", cat, "Easy",
                "Which loop guarantees that its loop body will execute at least once?",
                Arrays.asList("for loop", "while loop", "do-while loop", "foreach loop"),
                "do-while loop",
                "A do-while loop evaluates its condition at the end of the loop body, guaranteeing at least one execution."));
        list.add(new Question("C_E_13", cat, "Easy",
                "What is the output of this loop?\n\nfor (int i = 0; i < 3; i++) {\n    printf(\"%d \", i);\n}",
                Arrays.asList("0 1 2 ", "1 2 3 ", "0 1 2 3 ", "0 1 "),
                "0 1 2 ",
                "The loop initializes i to 0 and iterates while i < 3 (i = 0, 1, 2), printing '0 1 2 '."));
        list.add(new Question("C_E_14", cat, "Easy",
                "What is the function of the 'continue' statement in a loop?",
                Arrays.asList("Terminates the loop entirely", "Skips the rest of current iteration and jumps to next iteration", "Exits the current function", "Restarts program execution"),
                "Skips the rest of current iteration and jumps to next iteration",
                "The continue statement skips remaining statements in current iteration and moves execution to loop condition test/increment."));
        list.add(new Question("C_E_15", cat, "Easy",
                "Which keyword is used to exit immediately from a switch statement or loop in C?",
                Arrays.asList("exit", "return", "break", "stop"),
                "break",
                "The 'break' keyword forces immediate termination of the innermost enclosing loop or switch statement."));
        list.add(new Question("C_E_16", cat, "Easy",
                "How is an array indexed in C?",
                Arrays.asList("1-based indexing (1 to N)", "0-based indexing (0 to N-1)", "-1-based indexing", "Implementation dependent"),
                "0-based indexing (0 to N-1)",
                "Arrays in C use zero-based indexing, where the first element is at index 0."));
        list.add(new Question("C_E_17", cat, "Easy",
                "What is the correct declaration of an array of 10 integers in C?",
                Arrays.asList("int arr[10];", "array int arr[10];", "int arr(10);", "integer arr[10];"),
                "int arr[10];",
                "In C, 'int arr[10];' declares an array named arr storing 10 contiguous integers."));
        list.add(new Question("C_E_18", cat, "Easy",
                "In C, how are strings terminated in memory?",
                Arrays.asList("With a space character ' '", "With a newline character '\\n'", "With a null terminator '\\0'", "With EOF"),
                "With a null terminator '\\0'",
                "C strings are arrays of characters terminated by the null character '\\0' (ASCII 0)."));
        list.add(new Question("C_E_19", cat, "Easy",
                "Which standard header file declares functions like strlen(), strcpy(), and strcat()?",
                Arrays.asList("<stdio.h>", "<stdlib.h>", "<string.h>", "<ctype.h>"),
                "<string.h>",
                "The <string.h> header file contains prototypes for C string manipulation functions."));
        list.add(new Question("C_E_20", cat, "Easy",
                "What does the strlen() function return for string \"Hello\"?",
                Arrays.asList("5", "6", "4", "Indeterminate value"),
                "5",
                "strlen() counts characters excluding the null terminator '\\0'. 'Hello' contains 5 characters."));
        list.add(new Question("C_E_21", cat, "Easy",
                "What keyword is used to specify that a function does not return any value?",
                Arrays.asList("null", "empty", "void", "static"),
                "void",
                "The 'void' return type specifies that a function returns no value to the caller."));
        list.add(new Question("C_E_22", cat, "Easy",
                "What parameter passing mechanism is used by default for primitive types in C?",
                Arrays.asList("Pass by reference", "Pass by value", "Pass by name", "Pass by pointer reference"),
                "Pass by value",
                "C exclusively uses pass-by-value for function arguments (copying values)."));
        list.add(new Question("C_E_23", cat, "Easy",
                "What is recursion in C programming?",
                Arrays.asList("A function calling another function", "A function calling itself directly or indirectly", "A loop executing infinitely", "A macro calling a function"),
                "A function calling itself directly or indirectly",
                "Recursion occurs when a function calls itself until reaching a defined base termination condition."));
        list.add(new Question("C_E_24", cat, "Easy",
                "Which operator is used to obtain the memory address of a variable in C?",
                Arrays.asList("*", "&", "->", "%"),
                "&",
                "The address-of operator '&' returns the memory address of a variable."));
        list.add(new Question("C_E_25", cat, "Easy",
                "Which operator is used to dereference a pointer (access value at address) in C?",
                Arrays.asList("&", "*", "->", "."),
                "*",
                "The dereference operator '*' accesses the value stored at the memory address held by a pointer."));
        list.add(new Question("C_E_26", cat, "Easy",
                "What is a NULL pointer in C?",
                Arrays.asList("A pointer pointing to garbage memory location", "A pointer initialized to point to no valid memory location (0)", "A pointer pointing to main function", "An uninitialized pointer"),
                "A pointer initialized to point to no valid memory location (0)",
                "A NULL pointer is a pointer value reserved to indicate that it does not point to any valid object or memory location."));
        list.add(new Question("C_E_27", cat, "Easy",
                "Which keyword is used to define a user-defined composite data type containing multiple named members in C?",
                Arrays.asList("union", "struct", "class", "typedef"),
                "struct",
                "The 'struct' keyword defines a structure type grouping variables under one name."));
        list.add(new Question("C_E_28", cat, "Easy",
                "Which operator is used to access a structure member through a structure variable instance?",
                Arrays.asList("->", ".", "*", "::"),
                ".",
                "The dot operator '.' is used to access members directly from a structure variable."));
        list.add(new Question("C_E_29", cat, "Easy",
                "Which operator is used to access a structure member through a pointer to that structure?",
                Arrays.asList(".", "->", "*", "&"),
                "->",
                "The arrow operator '->' dereferences a structure pointer and accesses its member."));
        list.add(new Question("C_E_30", cat, "Easy",
                "What is the default integer value assigned to the first identifier in an enum in C if not explicitly set?",
                Arrays.asList("1", "0", "-1", "Null"),
                "0",
                "In C enumerations, the first constant defaults to integer value 0 unless explicitly initialized."));
        list.add(new Question("C_E_31", cat, "Easy",
                "What is explicit type casting in C?",
                Arrays.asList("Automatic conversion by the compiler", "Manual conversion forced by placing (type_name) before an expression", "Conversion happening during link time", "Conversion from string to float only"),
                "Manual conversion forced by placing (type_name) before an expression",
                "Explicit type casting uses cast operators like (int)var to manually convert expressions between types."));
        list.add(new Question("C_E_32", cat, "Easy",
                "Which storage class keyword makes a local variable retain its value across multiple function calls?",
                Arrays.asList("auto", "register", "static", "extern"),
                "static",
                "A local variable declared as 'static' retains its value between function invocations for program lifetime."));
        list.add(new Question("C_E_33", cat, "Easy",
                "What is the default storage class for local variables declared inside a function in C?",
                Arrays.asList("auto", "static", "extern", "register"),
                "auto",
                "Variables declared inside functions default to the 'auto' storage class with block scope and automatic duration."));
        list.add(new Question("C_E_34", cat, "Easy",
                "Which preprocessor directive is used to define a symbolic constant or macro in C?",
                Arrays.asList("#define", "#macro", "#constant", "#include"),
                "#define",
                "The '#define' directive creates macro substitutions and symbolic constants in C."));
        list.add(new Question("C_E_35", cat, "Easy",
                "What file extension is traditionally used for C source files?",
                Arrays.asList(".h", ".c", ".cpp", ".obj"),
                ".c",
                "C source code files use the '.c' file extension."));
        list.add(new Question("C_E_36", cat, "Easy",
                "Which standard library header file contains declarations for malloc(), calloc(), realloc(), and free()?",
                Arrays.asList("<stdio.h>", "<string.h>", "<stdlib.h>", "<memory.h>"),
                "<stdlib.h>",
                "The <stdlib.h> header file contains dynamic memory management functions in C."));
        list.add(new Question("C_E_37", cat, "Easy",
                "What does malloc() return if memory allocation fails?",
                Arrays.asList("-1", "0", "NULL", "Void"),
                "NULL",
                "When dynamic allocation fails, malloc() returns a NULL pointer."));
        list.add(new Question("C_E_38", cat, "Easy",
                "Which memory allocation function initializes all allocated bytes to zero?",
                Arrays.asList("malloc()", "calloc()", "realloc()", "alloc()"),
                "calloc()",
                "calloc() allocates memory and clears all bytes to zero, unlike malloc()."));
        list.add(new Question("C_E_39", cat, "Easy",
                "Which mode string is passed to fopen() to open a text file for reading?",
                Arrays.asList("\"w\"", "\"a\"", "\"r\"", "\"r+\""),
                "\"r\"",
                "Mode \"r\" opens an existing file for reading in text mode."));
        list.add(new Question("C_E_40", cat, "Easy",
                "What value does fopen() return if the specified file cannot be opened?",
                Arrays.asList("EOF", "NULL", "-1", "0"),
                "NULL",
                "If fopen() fails to open a file (e.g. file not found), it returns NULL."));
        list.add(new Question("C_E_41", cat, "Easy",
                "Which bitwise operator performs logical bitwise AND in C?",
                Arrays.asList("&&", "&", "|", "^"),
                "&",
                "The single ampersand '&' is the bitwise AND operator in C."));
        list.add(new Question("C_E_42", cat, "Easy",
                "What is the result of expression (5 & 3) in binary C arithmetic?",
                Arrays.asList("1", "7", "2", "0"),
                "1",
                "5 is binary 0101, 3 is 0011. Bitwise AND (0101 & 0011) yields 0001 (decimal 1)."));
        list.add(new Question("C_E_43", cat, "Easy",
                "Which operator shifts bits to the left in C?",
                Arrays.asList(">>", "<<", "<=", "<-"),
                "<<",
                "The '<<' operator performs left bit-shifting."));
        list.add(new Question("C_E_44", cat, "Easy",
                "In main(int argc, char *argv[]), what does argc represent?",
                Arrays.asList("Array of command line strings", "Count of command line arguments including program name", "Size of program memory", "Execution return code"),
                "Count of command line arguments including program name",
                "argc (argument count) holds the total number of command-line arguments passed to the program."));
        list.add(new Question("C_E_45", cat, "Easy",
                "What is the time complexity of accessing an element in an array by index?",
                Arrays.asList("O(1)", "O(N)", "O(log N)", "O(N^2)"),
                "O(1)",
                "Array indexing takes O(1) constant time because array elements are stored contiguously."));
        list.add(new Question("C_E_46", cat, "Easy",
                "What is the average time complexity of Linear Search on an array of size N?",
                Arrays.asList("O(1)", "O(N)", "O(log N)", "O(N log N)"),
                "O(N)",
                "Linear search checks elements sequentially, taking O(N) average time."));
        list.add(new Question("C_E_47", cat, "Easy",
                "What happens if an application accesses an array index out of bounds in C?",
                Arrays.asList("Throws ArrayIndexOutOfBoundsException", "Produces Undefined Behavior", "Returns 0 automatically", "Compiler prevents execution"),
                "Produces Undefined Behavior",
                "C does not perform array bound checking; out-of-bound access results in undefined behavior."));
        list.add(new Question("C_E_48", cat, "Easy",
                "What is a memory leak in C?",
                Arrays.asList("Accessing NULL pointer", "Failing to deallocate dynamically allocated memory with free() before losing reference", "Stack overflow error", "Reading uninitialized variable"),
                "Failing to deallocate dynamically allocated memory with free() before losing reference",
                "A memory leak occurs when heap memory allocated via malloc/calloc is no longer freed, wasting available RAM."));
        list.add(new Question("C_E_49", cat, "Easy",
                "What is the value of x after: int a = 10; int x = a++;",
                Arrays.asList("11", "10", "9", "Compilation Error"),
                "10",
                "Post-increment 'a++' yields the current value 10 to 'x' before incrementing 'a' to 11."));
        list.add(new Question("C_E_50", cat, "Easy",
                "Which function is used to read a single character from standard input in C?",
                Arrays.asList("putchar()", "getchar()", "puts()", "printf()"),
                "getchar()",
                "getchar() reads an unsigned char from standard input (stdin) and returns it as an int."));
    }

    private static void loadMedium(List<Question> list, String cat) {
        list.add(new Question("C_M_01", cat, "Medium",
                "What is the correct declaration and memory layout of a 2x3 2D array of integers in C?",
                Arrays.asList("int arr[2][3]; stored column-major", "int arr[2][3]; stored row-major in contiguous memory", "int arr[3][2]; stored row-major", "int arr(2,3); stored non-contiguously"),
                "int arr[2][3]; stored row-major in contiguous memory",
                "C multidimensional arrays are declared as arr[rows][cols] and stored in row-major order contiguously in memory."));
        list.add(new Question("C_M_02", cat, "Medium",
                "What is the output of the following program?\n\n#include <stdio.h>\n#include <string.h>\nint main(void) {\n    char str1[20] = \"Hello\";\n    char str2[] = \"World\";\n    strcat(str1, str2);\n    printf(\"%zu\", strlen(str1));\n    return 0;\n}",
                Arrays.asList("5", "10", "11", "20"),
                "10",
                "strcat appends 'World' to 'Hello', making str1 'HelloWorld'. strlen(\"HelloWorld\") is 10."));
        list.add(new Question("C_M_03", cat, "Medium",
                "What will be the output of this recursive function call print_rec(3)?\n\nvoid print_rec(int n) {\n    if (n <= 0) return;\n    print_rec(n - 1);\n    printf(\"%d \", n);\n}",
                Arrays.asList("3 2 1 ", "1 2 3 ", "3 3 3 ", "0 1 2 3 "),
                "1 2 3 ",
                "The recursive call happens before printing. So recursive unwinding prints 1, then 2, then 3."));
        list.add(new Question("C_M_04", cat, "Medium",
                "Given int arr[5] = {10, 20, 30, 40, 50}; int *p = arr + 2; what is the value of *(p + 1)?",
                Arrays.asList("20", "30", "40", "50"),
                "40",
                "arr+2 points to arr[2] (value 30). (p+1) points to arr[3], so dereferencing yields 40."));
        list.add(new Question("C_M_05", cat, "Medium",
                "Which of the following expressions is equivalent to arr[i] where arr is an array name?",
                Arrays.asList("*(arr + i)", "&arr + i", "*(arr * i)", "arr + *i"),
                "*(arr + i)",
                "In C, array indexing arr[i] is defined as exact syntactic sugar for dereferencing *(arr + i)."));
        list.add(new Question("C_M_06", cat, "Medium",
                "What is the fundamental difference in memory allocation between a struct and a union in C?",
                Arrays.asList("Struct members share memory; union members have separate memory", "Union members share the same memory location; struct members have distinct memory locations", "Structs can hold functions; unions cannot", "Unions cannot store integers"),
                "Union members share the same memory location; struct members have distinct memory locations",
                "A union allocates memory equal to its largest member so all members overlap, whereas struct allocates separate memory for each member."));
        list.add(new Question("C_M_07", cat, "Medium",
                "What is the output of the following program?\n\n#include <stdio.h>\nvoid count(void) {\n    static int c = 0;\n    c++;\n    printf(\"%d \", c);\n}\nint main(void) {\n    count();\n    count();\n    count();\n    return 0;\n}",
                Arrays.asList("1 1 1 ", "1 2 3 ", "0 0 0 ", "0 1 2 "),
                "1 2 3 ",
                "The static variable 'c' persists across calls. Increments produce output '1 2 3 '."));
        list.add(new Question("C_M_08", cat, "Medium",
                "What is the potential pitfall of macro definition #define SQUARE(x) x * x when called as SQUARE(2 + 3)?",
                Arrays.asList("Evaluates to 25", "Evaluates to 11 because of expansion 2 + 3 * 2 + 3", "Causes compilation error", "Evaluates to 10"),
                "Evaluates to 11 because of expansion 2 + 3 * 2 + 3",
                "SQUARE(2 + 3) expands strictly to 2 + 3 * 2 + 3 = 2 + 6 + 3 = 11. Parentheses around parameters are necessary to fix this."));
        list.add(new Question("C_M_09", cat, "Medium",
                "What is the difference between malloc(n * sizeof(int)) and calloc(n, sizeof(int))?",
                Arrays.asList("malloc clears memory to 0; calloc leaves uninitialized garbage", "calloc clears allocated memory to zero; malloc leaves memory contents uninitialized", "malloc is used for structs; calloc for primitives", "calloc cannot fail"),
                "calloc clears allocated memory to zero; malloc leaves memory contents uninitialized",
                "calloc initializes allocated heap bytes to zero, whereas malloc leaves memory unitialized."));
        list.add(new Question("C_M_10", cat, "Medium",
                "Which C file function is used to write formatted output directly to a file stream?",
                Arrays.asList("fwrite()", "fputs()", "fprintf()", "write()"),
                "fprintf()",
                "fprintf() works like printf() but outputs formatted text to a specified FILE pointer stream."));
        list.add(new Question("C_M_11", cat, "Medium",
                "What is the worst-case time complexity of Quick Sort algorithm?",
                Arrays.asList("O(N log N)", "O(N)", "O(N^2)", "O(1)"),
                "O(N^2)",
                "Quick sort degrades to O(N^2) worst-case time when pivot selection is poor (e.g. already sorted array with end pivot)."));
        list.add(new Question("C_M_12", cat, "Medium",
                "In a singly linked list node structure struct Node { int data; struct Node *next; }; what does 'next' store?",
                Arrays.asList("The next integer value", "The memory address of the next Node", "Size of the list", "Head pointer"),
                "The memory address of the next Node",
                "The 'next' member is a self-referential pointer storing the memory address of the subsequent list node."));
        list.add(new Question("C_M_13", cat, "Medium",
                "What is the output of the following C code?\n\n#include <stdio.h>\nint main(void) {\n    int x = 10, y = 20;\n    int *p = &x;\n    *p = 30;\n    p = &y;\n    *p = 40;\n    printf(\"%d %d\", x, y);\n    return 0;\n}",
                Arrays.asList("10 20", "30 40", "30 20", "10 40"),
                "30 40",
                "*p = 30 modifies x to 30. Then p is reassigned to y, and *p = 40 modifies y to 40."));
        list.add(new Question("C_M_14", cat, "Medium",
                "What is integer promotion in C expression evaluation?",
                Arrays.asList("Converting float to int automatically", "Automatic conversion of integer types smaller than int (like char or short) to int/unsigned int during expressions", "Promoting pointers to long int", "Casting long to long long"),
                "Automatic conversion of integer types smaller than int (like char or short) to int/unsigned int during expressions",
                "C automatically promotes small integer types (char, short) to int or unsigned int before evaluating expressions."));
        list.add(new Question("C_M_15", cat, "Medium",
                "Given int matrix[2][3] = {{1, 2, 3}, {4, 5, 6}}; what is the value of matrix[1][2]?",
                Arrays.asList("3", "5", "6", "4"),
                "6",
                "matrix[1] accesses the second row {4, 5, 6}, and matrix[1][2] accesses the 3rd element in that row, which is 6."));
        list.add(new Question("C_M_16", cat, "Medium",
                "Which standard function safely copies a string up to n characters preventing buffer overflow?",
                Arrays.asList("strcpy()", "strncpy()", "strcat()", "sprintf()"),
                "strncpy()",
                "strncpy() copies at most n characters from source to destination buffer."));
        list.add(new Question("C_M_17", cat, "Medium",
                "What does the 'extern' keyword signify in variable declarations?",
                Arrays.asList("Variable is stored in external disk", "Variable is declared here but defined in another translation unit/file", "Variable is constant", "Variable has function scope"),
                "Variable is declared here but defined in another translation unit/file",
                "'extern' specifies that a variable/function has external linkage and is defined in another file or scope."));
        list.add(new Question("C_M_18", cat, "Medium",
                "What is the effect of expression x ^ x for any integer variable x?",
                Arrays.asList("Produces x", "Produces 0", "Produces 1", "Produces -x"),
                "Produces 0",
                "XORing any number with itself results in 0 because matching bits cancel out (1^1=0, 0^0=0)."));
        list.add(new Question("C_M_19", cat, "Medium",
                "What is the output of the stringification operator '#' in macro #define STR(x) #x?",
                Arrays.asList("Converts macro argument x into a string literal \"x\"", "Calculates hash code of x", "Includes header x", "Syntax error"),
                "Converts macro argument x into a string literal \"x\"",
                "The single '#' operator converts the macro parameter into a quoted string literal."));
        list.add(new Question("C_M_20", cat, "Medium",
                "What happens if realloc(ptr, new_size) cannot expand memory in place and allocates a new memory block?",
                Arrays.asList("Original block remains active", "Copies old contents to new location, frees old block, and returns new pointer", "Throws runtime exception", "Fails without returning"),
                "Copies old contents to new location, frees old block, and returns new pointer",
                "realloc copies existing data to the newly allocated block, frees the old block memory automatically, and returns the new address."));
        list.add(new Question("C_M_21", cat, "Medium",
                "What does the fseek(fp, 0, SEEK_END) call do in C file handling?",
                Arrays.asList("Rewinds file pointer to beginning", "Positions file position indicator to the end of the file stream", "Deletes the file", "Reads last character"),
                "Positions file position indicator to the end of the file stream",
                "fseek with SEEK_END sets the file position indicator to the file end, useful for determining file size via ftell()."));
        list.add(new Question("C_M_22", cat, "Medium",
                "For command `./app input.txt 100`, what is argv[1]?",
                Arrays.asList("\"./app\"", "\"input.txt\"", "\"100\"", "NULL"),
                "\"input.txt\"",
                "argv[0] is executable name (\"./app\"), and argv[1] is the first argument string (\"input.txt\")."));
        list.add(new Question("C_M_23", cat, "Medium",
                "What precondition must be met before executing Binary Search on an array?",
                Arrays.asList("Array elements must be floating point", "Array must be sorted in order", "Array size must be even", "Array must contain positive numbers"),
                "Array must be sorted in order",
                "Binary search requires a pre-sorted array to eliminate half of the remaining elements at each step."));
        list.add(new Question("C_M_24", cat, "Medium",
                "What is the time complexity of pushing an item onto a stack implemented with a linked list?",
                Arrays.asList("O(1)", "O(N)", "O(log N)", "O(N^2)"),
                "O(1)",
                "Inserting at the head of a linked list stack takes constant O(1) time."));
        list.add(new Question("C_M_25", cat, "Medium",
                "What compiler warning or error occurs if a non-void function reaches the end without a return statement?",
                Arrays.asList("Control reaches end of non-void function", "Segmentation fault", "Stack overflow", "Linker error"),
                "Control reaches end of non-void function",
                "Compilers issue a warning 'control reaches end of non-void function' because returning without a value causes undefined behavior when caller uses return value."));
        list.add(new Question("C_M_26", cat, "Medium",
                "What is the result of evaluating recursive Fibonacci fib(4) where fib(0)=0, fib(1)=1?",
                Arrays.asList("2", "3", "5", "1"),
                "3",
                "fib(0)=0, fib(1)=1, fib(2)=1, fib(3)=2, fib(4)=3."));
        list.add(new Question("C_M_27", cat, "Medium",
                "If int *p = (int*)1000; on a system where sizeof(int) == 4, what is the value of p + 2?",
                Arrays.asList("1002", "1008", "1004", "1016"),
                "1008",
                "Pointer arithmetic scales increments by sizeof(*p). 1000 + 2 * 4 = 1008."));
        list.add(new Question("C_M_28", cat, "Medium",
                "What is typedef used for when defining a struct in C?",
                Arrays.asList("To create an alias name for the struct type avoiding mandatory 'struct' keyword in declarations", "To make struct fields constant", "To allocate memory dynamically", "To export struct to C++"),
                "To create an alias name for the struct type avoiding mandatory 'struct' keyword in declarations",
                "typedef creates a custom type alias (e.g. typedef struct Node Node;) so you can write 'Node n;' instead of 'struct Node n;'."));
        list.add(new Question("C_M_29", cat, "Medium",
                "What is the printed value in this code?\n\nenum State { LOW = 5, MEDIUM, HIGH = 10 };\nprintf(\"%d\", MEDIUM);",
                Arrays.asList("0", "1", "6", "5"),
                "6",
                "Enumeration values increment sequentially from the previous explicit assignment. LOW=5 makes MEDIUM=6."));
        list.add(new Question("C_M_30", cat, "Medium",
                "How can you check if an integer x is odd using bitwise operators?",
                Arrays.asList("(x & 1) != 0", "(x | 1) == 0", "(x ^ 1) == 0", "(x >> 1) == 1"),
                "(x & 1) != 0",
                "An integer is odd if its least significant bit (LSB) is 1. Bitwise AND with 1 tests the LSB."));
        list.add(new Question("C_M_31", cat, "Medium",
                "What is printed by printf(\"%c\", *(\"Programming\" + 3));?",
                Arrays.asList("P", "o", "g", "r"),
                "g",
                "\"Programming\" is char pointer to 'P' (index 0). Index + 3 points to 'g' (P=0, r=1, o=2, g=3)."));
        list.add(new Question("C_M_32", cat, "Medium",
                "How can a C function modify a caller variable's value?",
                Arrays.asList("By declaring variable global", "By passing pointer address of variable as argument", "By using return statement twice", "C functions cannot modify caller variables"),
                "By passing pointer address of variable as argument",
                "Passing a variable's memory address (pointer) allows the function to dereference and modify the caller's memory value."));
        list.add(new Question("C_M_33", cat, "Medium",
                "What issue is caused by calling free(ptr); twice on the same allocated pointer?",
                Arrays.asList("Dangling pointer", "Double Free vulnerability / Undefined Behavior", "Memory leak", "Nothing happens"),
                "Double Free vulnerability / Undefined Behavior",
                "Freeing the same pointer twice corrupts memory allocator internal structures resulting in undefined behavior or crash."));
        list.add(new Question("C_M_34", cat, "Medium",
                "What is the space complexity of an in-place Selection Sort algorithm?",
                Arrays.asList("O(N)", "O(1)", "O(log N)", "O(N^2)"),
                "O(1)",
                "In-place selection sort requires O(1) auxiliary memory space beyond the input array."));
        list.add(new Question("C_M_35", cat, "Medium",
                "Which sorting algorithm has a stable best, average, and worst-case time complexity of O(N log N)?",
                Arrays.asList("Quick Sort", "Bubble Sort", "Merge Sort", "Insertion Sort"),
                "Merge Sort",
                "Merge sort recursively divides array and merges, maintaining O(N log N) across all cases."));
        list.add(new Question("C_M_36", cat, "Medium",
                "What is a dangling pointer in C?",
                Arrays.asList("Pointer assigned to NULL", "Pointer pointing to memory that has been deallocated/freed", "Pointer pointing to invalid string", "Uninitialized pointer"),
                "Pointer pointing to memory that has been deallocated/freed",
                "A dangling pointer holds the address of a memory block that has already been deallocated or freed."));
        list.add(new Question("C_M_37", cat, "Medium",
                "What is the purpose of the valgrind tool in C development?",
                Arrays.asList("C code formatting", "Detecting memory leaks and invalid memory accesses", "Compiling C files faster", "Generating unit tests"),
                "Detecting memory leaks and invalid memory accesses",
                "Valgrind is a dynamic analysis tool used to detect memory leaks, uninitialized memory reads, and buffer overrides."));
        list.add(new Question("C_M_38", cat, "Medium",
                "How many times does loop execute?\n\nunsigned char i;\nfor (i = 0; i < 255; i++);",
                Arrays.asList("255 times", "256 times", "Infinite loop", "254 times"),
                "255 times",
                "i runs from 0 up to 254 (255 iterations). When i reaches 255, condition i < 255 fails."));
        list.add(new Question("C_M_39", cat, "Medium",
                "What happens if a switch case block lacks a 'break' statement?",
                Arrays.asList("Compilation Error", "Fall-through to subsequent case blocks until break or end is reached", "Infinite loop", "Default case executes immediately"),
                "Fall-through to subsequent case blocks until break or end is reached",
                "Lacking a break statement causes execution to fall through into subsequent switch case blocks."));
        list.add(new Question("C_M_40", cat, "Medium",
                "What is the return value of strcmp(\"apple\", \"banana\")?",
                Arrays.asList("0", "A negative integer value (< 0)", "A positive integer value (> 0)", "Undefined"),
                "A negative integer value (< 0)",
                "strcmp compares strings lexicographically. 'apple' precedes 'banana' in ASCII, returning a value less than 0."));
        list.add(new Question("C_M_41", cat, "Medium",
                "What is the size in bytes of array double arr[10] on a platform where sizeof(double) == 8?",
                Arrays.asList("10 bytes", "40 bytes", "80 bytes", "16 bytes"),
                "80 bytes",
                "Total array memory size is element count multiplied by sizeof(type): 10 * 8 = 80 bytes."));
        list.add(new Question("C_M_42", cat, "Medium",
                "Which macro conditional directive checks if a macro identifier is NOT defined?",
                Arrays.asList("#ifndef", "#ifdef", "#ifndef", "#if undef"),
                "#ifndef",
                "#ifndef (if not defined) checks whether a macro name has not been defined previously."));
        list.add(new Question("C_M_43", cat, "Medium",
                "Can C functions return a structure by value?",
                Arrays.asList("No, C functions can only return primitive types", "Yes, C supports returning structures by value", "Only if struct size is under 8 bytes", "Only with pointers"),
                "Yes, C supports returning structures by value",
                "C fully supports returning entire struct instances by value from functions."));
        list.add(new Question("C_M_44", cat, "Medium",
                "What is the output of printf(\"%d\", sizeof(void*)) on a 64-bit platform?",
                Arrays.asList("2", "4", "8", "16"),
                "8",
                "On a 64-bit architecture system, all object pointers (including void*) are 8 bytes (64 bits) wide."));
        list.add(new Question("C_M_45", cat, "Medium",
                "Which standard file open mode opens a binary file for appending data?",
                Arrays.asList("\"a\"", "\"ab\"", "\"wa\"", "\"wb+\""),
                "\"ab\"",
                "\"ab\" opens a file in binary mode for appending at end of file."));
        list.add(new Question("C_M_46", cat, "Medium",
                "Which data structure operates on a Last-In, First-Out (LIFO) order?",
                Arrays.asList("Queue", "Stack", "Array", "Binary Tree"),
                "Stack",
                "A Stack data structure stores and retrieves elements in Last-In, First-Out (LIFO) order."));
        list.add(new Question("C_M_47", cat, "Medium",
                "Which stage of C compilation expands macros and handles #include directives?",
                Arrays.asList("Linker", "Assembler", "Preprocessor", "Optimizer"),
                "Preprocessor",
                "The Preprocessor stage processes #include, #define macros, and conditional compilation directives before compilation."));
        list.add(new Question("C_M_48", cat, "Medium",
                "What is the main task of the Linker in C build pipeline?",
                Arrays.asList("Translating C code to assembly", "Combining compiled object files (.o/.obj) and library code into a single executable file", "Pre-parsing macro expressions", "Checking syntax errors"),
                "Combining compiled object files (.o/.obj) and library code into a single executable file",
                "The Linker resolves external symbols and combines object files into a single binary executable file."));
        list.add(new Question("C_M_49", cat, "Medium",
                "What type of error is caused by dividing an integer variable by zero at runtime in C?",
                Arrays.asList("Compilation Error", "Undefined Behavior / Floating-point exception (Runtime crash)", "Linker Error", "Syntax Warning"),
                "Undefined Behavior / Floating-point exception (Runtime crash)",
                "Division by zero is undefined behavior in C standard, typically triggering a runtime exception/signal."));
        list.add(new Question("C_M_50", cat, "Medium",
                "What is the result of expression ~0 in 32-bit two's complement integer arithmetic?",
                Arrays.asList("0", "-1", "1", "2147483647"),
                "-1",
                "Bitwise NOT (~0) flips all 32 zero bits to ones (0xFFFFFFFF), representing -1 in two's complement format."));
    }

    private static void loadHard(List<Question> list, String cat) {
        list.add(new Question("C_H_01", cat, "Hard",
                "In C, what does the declaration int (*(*fp)(int))[5]; represent?",
                Arrays.asList("A function taking int and returning array of 5 pointers", "A pointer to a function taking an int argument and returning a pointer to an array of 5 integers", "An array of 5 function pointers", "Invalid syntax"),
                "A pointer to a function taking an int argument and returning a pointer to an array of 5 integers",
                "Reading right-left rule: fp is a pointer (*) to a function (int) returning a pointer (*) to an array [5] of int."));
        list.add(new Question("C_H_02", cat, "Hard",
                "What is the output of the following C program?\n\n#include <stdio.h>\nvoid modify(int **pp) {\n    static int val = 50;\n    *pp = &val;\n}\nint main(void) {\n    int x = 10;\n    int *p = &x;\n    modify(&p);\n    printf(\"%d\", *p);\n    return 0;\n}",
                Arrays.asList("10", "50", "Garbage value", "Compilation error"),
                "50",
                "modify accepts address of pointer &p. *pp = &val updates p in main to point to static variable val (50)."));
        list.add(new Question("C_H_03", cat, "Hard",
                "How do you declare a function pointer named 'func' that points to a function taking two double parameters and returning an int?",
                Arrays.asList("int *func(double, double);", "int (*func)(double, double);", "int (func*)(double, double);", "double (*func)(int, int);"),
                "int (*func)(double, double);",
                "int (*func)(double, double); correctly declares a function pointer. Without parentheses, int *func(...) declares a function returning an int pointer."));
        list.add(new Question("C_H_04", cat, "Hard",
                "Given int arr[3][4]; what is the data type of the expression 'arr' when decayed in an expression?",
                Arrays.asList("int**", "int (*)[4]", "int*", "int[12]"),
                "int (*)[4]",
                "When a 2D array decays, it yields a pointer to its first row element, which has type pointer-to-array-of-4-ints: int (*)[4]."));
        list.add(new Question("C_H_05", cat, "Hard",
                "Assuming a standard 64-bit ABI with 4-byte int alignment and 8-byte double alignment, what is sizeof(struct Data) for struct Data { char c; int i; double d; };?",
                Arrays.asList("13", "16", "24", "20"),
                "16",
                "char c (1 byte) + 3 padding bytes -> int i (4 bytes at offset 4) -> double d (8 bytes at offset 8). Total size = 16 bytes."));
        list.add(new Question("C_H_06", cat, "Hard",
                "What is the function of token-pasting operator ## in C preprocessor macro #define CONCAT(a, b) a ## b?",
                Arrays.asList("Concatenates two strings", "Merges two tokens a and b into a single syntactical token during preprocessing", "Performs bitwise OR", "Compares tokens a and b"),
                "Merges two tokens a and b into a single syntactical token during preprocessing",
                "The ## operator pastes tokens together. CONCAT(var, 1) expands to the token var1."));
        list.add(new Question("C_H_07", cat, "Hard",
                "What constitutes a memory leak when using realloc() like ptr = realloc(ptr, new_size);?",
                Arrays.asList("realloc always leaks memory", "If realloc fails and returns NULL, assigning back to 'ptr' overwrites the original address, losing the reference to original block", "realloc frees original block twice", "Memory leaks only occur with calloc"),
                "If realloc fails and returns NULL, assigning back to 'ptr' overwrites the original address, losing the reference to original block",
                "Overwriting original pointer with NULL on realloc failure causes reference loss to original memory block, leaking it."));
        list.add(new Question("C_H_08", cat, "Hard",
                "What is the result of evaluating expression i = i++ + 1; in C17?",
                Arrays.asList("i increments by 2", "i increments by 1", "Undefined Behavior due to unsequenced side effect and value computation on 'i'", "Compilation error"),
                "i increments by 1",
                "In C11/C17 standard rules, modifying a scalar object more than once without intermediate sequence points yields Undefined Behavior."));
        list.add(new Question("C_H_09", cat, "Hard",
                "What is the Strict Aliasing Rule in C compiler optimization?",
                Arrays.asList("Pointers of different types cannot point to same memory address unless one is char* or void*", "Compiler assumes pointers of incompatible types do not alias the same memory location, enabling optimization", "Restricts pointer comparison", "Forces explicit dynamic casting"),
                "Compiler assumes pointers of incompatible types do not alias the same memory location, enabling optimization",
                "Strict aliasing allows compilers to assume pointers to incompatible types do not refer to the same memory object."));
        list.add(new Question("C_H_10", cat, "Hard",
                "What is the worst-case space complexity of recursive implementation of Depth-First Search (DFS) on a graph with V vertices due to call stack?",
                Arrays.asList("O(1)", "O(V)", "O(V^2)", "O(E log V)"),
                "O(V)",
                "In worst case (path graph), call stack recursion depth reaches O(V) frames."));
        list.add(new Question("C_H_11", cat, "Hard",
                "In Floyd's Cycle Detection Algorithm (Tortoise and Hare) on a linked list, why are cycle detected when fast pointer moves 2 steps and slow moves 1 step?",
                Arrays.asList("Fast pointer resets to head", "Relative distance between fast and slow pointers decreases by 1 in each loop iteration inside cycle", "Slow pointer stops at cycle entry", "List size is halved"),
                "Relative distance between fast and slow pointers decreases by 1 in each loop iteration inside cycle",
                "In a cycle, the loop gap shrinks by (2-1)=1 node per iteration, guaranteeing convergence without infinite loop."));
        list.add(new Question("C_H_12", cat, "Hard",
                "What operation does expression x & (x - 1) perform on a non-zero integer x?",
                Arrays.asList("Multiplies x by 2", "Clears the lowest set bit (rightmost 1-bit) in x", "Toggles all bits of x", "Sets the highest bit"),
                "Clears the lowest set bit (rightmost 1-bit) in x",
                "x & (x - 1) turns off the lowest set bit of x. It is frequently used to check if x is a power of 2 (x & (x - 1) == 0)."));
        list.add(new Question("C_H_13", cat, "Hard",
                "Why should file reading loops check feof() AFTER a read operation (like fread or fgetc) rather than in loop condition while(!feof(fp))?",
                Arrays.asList("feof() closes file stream", "feof() returns true only AFTER an attempted read past EOF fails, causing an extra loop iteration if checked first", "feof() works only for text files", "feof() resets file error indicator"),
                "feof() returns true only AFTER an attempted read past EOF fails, causing an extra loop iteration if checked first",
                "feof() is set only after a read operation attempts to read past EOF. Checking before reading processes the last byte twice."));
        list.add(new Question("C_H_14", cat, "Hard",
                "In executable memory layout (ELF), where are uninitialized global and static variables stored?",
                Arrays.asList("Text segment", "BSS (Block Started by Symbol) segment", "Stack segment", "Heap segment"),
                "BSS (Block Started by Symbol) segment",
                "Uninitialized global/static variables are placed in BSS segment and initialized to zero by operating system at launch."));
        list.add(new Question("C_H_15", cat, "Hard",
                "What is the output of the following C code?\n\n#include <stdio.h>\nint main(void) {\n    int a[] = {1, 2, 3, 4, 5};\n    int *p = (int*)(&a + 1);\n    printf(\"%d\", *(p - 1));\n    return 0;\n}",
                Arrays.asList("1", "5", "Garbage value", "Compilation error"),
                "5",
                "&a has type pointer-to-array int(*)[5]. &a + 1 moves pointer past the entire array. Casting to int* and (p-1) points to a[4] = 5."));
        list.add(new Question("C_H_16", cat, "Hard",
                "What is the value of expression (1U << 31) on 32-bit two's complement system?",
                Arrays.asList("2147483647", "-2147483648 (represented as INT_MIN)", "0", "Undefined"),
                "-2147483648 (represented as INT_MIN)",
                "Shifting 1U into 31st position sets the sign bit, representing 0x80000000 (-2147483648 in signed 32-bit context)."));
        list.add(new Question("C_H_17", cat, "Hard",
                "Given int add(int a, int b) { return a + b; }, what is the correct syntax to invoke this function via function pointer fp?",
                Arrays.asList("fp(a, b) or (*fp)(a, b)", "&fp(a, b)", "fp->(a, b)", "call fp(a, b)"),
                "fp(a, b) or (*fp)(a, b)",
                "In C, calling function pointer can use either explicit dereference (*fp)(a, b) or implicit syntax fp(a, b)."));
        list.add(new Question("C_H_18", cat, "Hard",
                "What does the expression 2[arr] evaluate to where arr is an array of integers?",
                Arrays.asList("Compilation Error", "arr[2] because a[b] is *(a + b) and addition is commutative", "Address of 2nd element", "Garbage value"),
                "arr[2] because a[b] is *(a + b) and addition is commutative",
                "In C, arr[2] is defined as *(arr + 2). Due to commutative property of addition, *(2 + arr) is 2[arr]."));
        list.add(new Question("C_H_19", cat, "Hard",
                "What happens if you dereference a pointer converted from an unaligned memory address on strict alignment architectures?",
                Arrays.asList("Compiler fixes alignment", "Bus Error / Alignment Fault leading to crash", "Returns 0", "Normal execution"),
                "Bus Error / Alignment Fault leading to crash",
                "Accessing misaligned addresses on hardware requiring strict alignment triggers a bus error or hardware fault exception."));
        list.add(new Question("C_H_20", cat, "Hard",
                "Where are local auto variables allocated during function calls?",
                Arrays.asList("Heap", "BSS Segment", "Call Stack", "Data Segment"),
                "Call Stack",
                "Local variables with automatic storage duration are allocated on the active execution call stack frame."));
        list.add(new Question("C_H_21", cat, "Hard",
                "What is the output of macro expansion for:\n#define PRINT(x) printf(#x \" = %d\\n\", x)\nint val = 10; PRINT(val);",
                Arrays.asList("val = 10", "\"val\" = 10", "10 = 10", "PRINT(10)"),
                "val = 10",
                "#x stringifies 'val' to \"val\". String literal concatenation joins \"val\" and \" = %d\\n\" into \"val = %d\\n\", printing 'val = 10'."));
        list.add(new Question("C_H_22", cat, "Hard",
                "What does char (*a[10])(int) declare?",
                Arrays.asList("A function returning array of 10 char pointers", "An array of 10 function pointers, each pointing to a function taking int and returning char", "Pointer to 10 chars", "Invalid declaration"),
                "An array of 10 function pointers, each pointing to a function taking int and returning char",
                "a[10] is an array of 10 pointers (*) to functions taking (int) parameter and returning char."));
        list.add(new Question("C_H_23", cat, "Hard",
                "What attribute or pragma is used in GCC/Clang to disable structure padding?",
                Arrays.asList("__attribute__((packed)) or #pragma pack(1)", "__attribute__((aligned))", "#pragma nopad", "volatile struct"),
                "__attribute__((packed)) or #pragma pack(1)",
                "__attribute__((packed)) forces the compiler to minimize space without inserting padding alignment bytes."));
        list.add(new Question("C_H_24", cat, "Hard",
                "Which function in C11 aligned dynamic memory allocation allocates 'size' bytes whose address is a multiple of 'alignment'?",
                Arrays.asList("aligned_alloc()", "malloc_aligned()", "memalign()", "posix_memalign()"),
                "aligned_alloc()",
                "C11 standard introduced aligned_alloc(alignment, size) in <stdlib.h> for aligned dynamic memory allocation."));
        list.add(new Question("C_H_25", cat, "Hard",
                "What is the time complexity of solving the Tower of Hanoi problem for N disks?",
                Arrays.asList("O(N^2)", "O(2^N)", "O(N log N)", "O(N!)"),
                "O(2^N)",
                "Tower of Hanoi recurrence T(N) = 2T(N-1) + 1 yields exponential time complexity O(2^N)."));
        list.add(new Question("C_H_26", cat, "Hard",
                "How do you swap two integer variables x and y without using a temporary variable via bitwise operations?",
                Arrays.asList("x = x ^ y; y = x ^ y; x = x ^ y;", "x = x & y; y = x & y; x = x & y;", "x = x | y; y = x | y; x = x | y;", "x = ~x; y = ~y;"),
                "x = x ^ y; y = x ^ y; x = x ^ y;",
                "The XOR swap algorithm uses three XOR operations to exchange values without extra memory."));
        list.add(new Question("C_H_27", cat, "Hard",
                "In C, what is the sequence point guarantee of logical AND (&&) operator?",
                Arrays.asList("No sequence point", "Left operand is fully evaluated and side effects applied before right operand is evaluated (short-circuiting)", "Right operand evaluates first", "Both evaluate concurrently"),
                "Left operand is fully evaluated and side effects applied before right operand is evaluated (short-circuiting)",
                "The && operator introduces a sequence point after evaluating left operand, guaranteeing left-to-right evaluation and short-circuiting."));
        list.add(new Question("C_H_28", cat, "Hard",
                "What is a Stack Overflow error caused by in C program execution?",
                Arrays.asList("Allocating too much memory via malloc", "Exceeding available stack memory limits, usually due to infinite recursion or huge stack arrays", "Freeing unallocated memory", "Dereferencing NULL pointer"),
                "Exceeding available stack memory limits, usually due to infinite recursion or huge stack arrays",
                "Stack overflow occurs when call stack memory limit is exceeded by excessive stack allocation or deep recursion."));
        list.add(new Question("C_H_29", cat, "Hard",
                "In a circular queue implemented using array of size N, what is the formula for next index after 'rear'?",
                Arrays.asList("(rear + 1) % N", "rear + 1", "(rear - 1) % N", "rear % N"),
                "(rear + 1) % N",
                "Modulo arithmetic (rear + 1) % N wraps index back to 0 when reaching array end."));
        list.add(new Question("C_H_30", cat, "Hard",
                "What happens when a negative signed integer is converted to an unsigned integer type of same width in C?",
                Arrays.asList("Runtime Exception", "Value is converted by adding 2^N (where N is bit width), resulting in large positive integer", "Value becomes 0", "Value remains negative"),
                "Value is converted by adding 2^N (where N is bit width), resulting in large positive integer",
                "Converting negative signed to unsigned performs modular reduction modulo 2^N in accordance with C standard binary representation."));
        list.add(new Question("C_H_31", cat, "Hard",
                "What is the average time complexity of Heap Sort?",
                Arrays.asList("O(N^2)", "O(N log N)", "O(N)", "O(log N)"),
                "O(N log N)",
                "Heap sort maintains heap structure and performs N extractions taking O(N log N) time in all cases."));
        list.add(new Question("C_H_32", cat, "Hard",
                "Which standard library function uses function pointers for custom sorting comparison callback?",
                Arrays.asList("qsort()", "bsearch()", "Both qsort() and bsearch()", "sort()"),
                "Both qsort() and bsearch()",
                "Both qsort() and bsearch() accept comparator function pointers int (*compar)(const void*, const void*)."));
        list.add(new Question("C_H_33", cat, "Hard",
                "What is the purpose of fflush(stdout) in C?",
                Arrays.asList("Clears input buffer", "Forces immediate flushing of stdout output stream buffer to terminal/destination", "Closes stdout file handle", "Resets stdout position"),
                "Forces immediate flushing of stdout output stream buffer to terminal/destination",
                "fflush(stdout) forces buffered pending output bytes to be written immediately to output file/device."));
        list.add(new Question("C_H_34", cat, "Hard",
                "What is guaranteed about argv[argc] in standard C main signature?",
                Arrays.asList("Contains program name", "It is strictly a NULL pointer", "Contains empty string", "It is undefined"),
                "It is strictly a NULL pointer",
                "The C standard mandates that argv[argc] must be a NULL pointer."));
        list.add(new Question("C_H_35", cat, "Hard",
                "Which pointer type is explicitly permitted by C standard to alias any object type without violating strict aliasing?",
                Arrays.asList("int*", "char* (and unsigned char*)", "float*", "void**"),
                "char* (and unsigned char*)",
                "Character types (char*, unsigned char*) are special target types allowed to inspect/alias raw bytes of any object."));
        list.add(new Question("C_H_36", cat, "Hard",
                "Which header file provides macros va_start, va_arg, and va_end for handling variadic functions in C?",
                Arrays.asList("<stdarg.h>", "<varargs.h>", "<stdlib.h>", "<stdio.h>"),
                "<stdarg.h>",
                "<stdarg.h> defines macros to step through variable argument lists in C variadic functions."));
        list.add(new Question("C_H_37", cat, "Hard",
                "What is the result of subtracting two pointers pointing to elements of the same array in C (p2 - p1)?",
                Arrays.asList("Difference in bytes", "Difference in number of array elements between them (ptrdiff_t)", "Sum of addresses", "Undefined behavior"),
                "Difference in number of array elements between them (ptrdiff_t)",
                "Pointer subtraction returns the element index difference between pointers as signed integer type ptrdiff_t."));
        list.add(new Question("C_H_38", cat, "Hard",
                "What is thread_local (or _Thread_local in C11) storage class specifier used for?",
                Arrays.asList("Making variable global across all threads", "Giving variable thread storage duration where each thread has its own distinct instance", "Locking thread execution", "Disabling multi-threading"),
                "Giving variable thread storage duration where each thread has its own distinct instance",
                "_Thread_local creates thread-specific storage instances isolated per execution thread."));
        list.add(new Question("C_H_39", cat, "Hard",
                "What is a flexible array member in a C structure (C99 feature)?",
                Arrays.asList("An array with negative size", "An array of unsized length char arr[] as last member of struct used for dynamic allocation payloads", "An array converted to pointer", "A pointer member"),
                "An array of unsized length char arr[] as last member of struct used for dynamic allocation payloads",
                "Flexible array members allow a structure's last member to have incomplete array type [] for variable-sized heap allocations."));
        list.add(new Question("C_H_40", cat, "Hard",
                "What is the result of accessing uninitialized local variable with automatic storage duration in C?",
                Arrays.asList("Guaranteed to be 0", "Undefined Behavior (contains indeterminate garbage value)", "Compilation error", "Null pointer error"),
                "Undefined Behavior (contains indeterminate garbage value)",
                "Reading uninitialized automatic variables yields indeterminate values, causing undefined behavior."));
        list.add(new Question("C_H_41", cat, "Hard",
                "How do you clear (set to 0) the k-th bit of an integer n (0-indexed)?",
                Arrays.asList("n = n & ~(1 << k)", "n = n | (1 << k)", "n = n ^ (1 << k)", "n = n >> k"),
                "n = n & ~(1 << k)",
                "Bitwise AND with bitwise NOT mask ~(1 << k) clears the k-th bit while preserving all other bits."));
        list.add(new Question("C_H_42", cat, "Hard",
                "What is the purpose of the 'const' qualifier on a variable declaration?",
                Arrays.asList("Makes variable volatile", "Informs compiler that variable value cannot be modified after initialization", "Allocates memory in stack", "Increases execution speed by 2x"),
                "Informs compiler that variable value cannot be modified after initialization",
                "'const' specifies read-only immutability for the qualified object."));
        list.add(new Question("C_H_43", cat, "Hard",
                "What is the average time complexity of searching in a balanced Binary Search Tree (BST)?",
                Arrays.asList("O(1)", "O(log N)", "O(N)", "O(N log N)"),
                "O(log N)",
                "A balanced BST halves search space at each tree level, yielding logarithmic O(log N) search time."));
        list.add(new Question("C_H_44", cat, "Hard",
                "What is a major advantage of a Doubly Linked List over a Singly Linked List?",
                Arrays.asList("Uses less memory", "Allows bidirectional traversal (forward and backward) and O(1) deletion of given node pointer", "Faster array access", "Automatic sorting"),
                "Allows bidirectional traversal (forward and backward) and O(1) deletion of given node pointer",
                "Doubly linked lists store previous node pointers, enabling reverse traversal and constant-time node removal."));
        list.add(new Question("C_H_45", cat, "Hard",
                "Which standard header file provides signal handling functions like signal() and raise() in C?",
                Arrays.asList("<signal.h>", "<sys/signal.h>", "<interrupt.h>", "<stdlib.h>"),
                "<signal.h>",
                "<signal.h> contains facility definitions for handling asynchronous signal conditions in C."));
        list.add(new Question("C_H_46", cat, "Hard",
                "What does the 'volatile' keyword inform the C compiler?",
                Arrays.asList("Variable should be stored in GPU memory", "Variable value may be modified by hardware or external threads, preventing compiler caching in registers", "Variable is constant", "Variable causes memory leaks"),
                "Variable value may be modified by hardware or external threads, preventing compiler caching in registers",
                "'volatile' prevents compiler optimizations that cache values in registers or reorder accesses to memory."));
        list.add(new Question("C_H_47", cat, "Hard",
                "What is printed by printf(\"%d\", sizeof('a')) in standard C (unlike C++)?",
                Arrays.asList("1", "Size of int (typically 4 bytes)", "2", "Undefined"),
                "Size of int (typically 4 bytes)",
                "In C, character constants like 'a' have type 'int' (sizeof('a') == sizeof(int)), whereas in C++ they have type 'char'."));
        list.add(new Question("C_H_48", cat, "Hard",
                "What is the result of expression (n & -n) for integer n?",
                Arrays.asList("Isolates the lowest set bit of n", "Negates n", "Clears all bits", "Swaps high and low bytes"),
                "Isolates the lowest set bit of n",
                "In two's complement, (n & -n) isolates and extracts the rightmost lowest 1-bit of n."));
        list.add(new Question("C_H_49", cat, "Hard",
                "What does the static analysis tool 'cppcheck' do for C applications?",
                Arrays.asList("Compiles code to object files", "Inspects source code without execution to identify bugs, memory leaks, and undefined behavior", "Measures code execution speed", "Formats source code"),
                "Inspects source code without execution to identify bugs, memory leaks, and undefined behavior",
                "Cppcheck is a static code analysis tool that analyzes C/C++ source code for potential bugs and security vulnerabilities without running the binary."));
        list.add(new Question("C_H_50", cat, "Hard",
                "What feature was introduced in C11 standard for type-generic macro expressions?",
                Arrays.asList("_Generic keyword", "auto keyword", "template keyword", "typeof keyword"),
                "_Generic keyword",
                "C11 introduced the _Generic keyword, enabling selection of expressions based on argument type at compile time."));
    }
}
