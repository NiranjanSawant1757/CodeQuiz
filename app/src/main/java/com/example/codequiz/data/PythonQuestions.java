package com.example.codequiz.data;

import com.example.codequiz.model.Question;
import com.example.codequiz.util.AppConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PythonQuestions {

    public static List<Question> get() {
        List<Question> list = new ArrayList<>();
        String cat = AppConstants.CAT_PYTHON;

        // --- EASY (17) ---
        list.add(new Question("PY_01", cat, "Easy",
                "Which symbol is used for comments in Python?",
                Arrays.asList("#", "//", "/* */", "--"),
                "#", "In Python, the hash character (#) denotes the start of a single-line comment."));

        list.add(new Question("PY_02", cat, "Easy",
                "Which keyword is used to define a function in Python?",
                Arrays.asList("def", "function", "func", "define"),
                "def", "Functions in Python are defined with the 'def' keyword."));

        list.add(new Question("PY_03", cat, "Easy",
                "What is the output of 'type([])' in Python?",
                Arrays.asList("<class 'list'>", "<class 'array'>", "<class 'tuple'>", "<class 'set'>"),
                "<class 'list'>", "Square brackets define a Python list, so type([]) returns <class 'list'>."));

        list.add(new Question("PY_04", cat, "Easy",
                "Is Python an interpreted or compiled language?",
                Arrays.asList("Interpreted (bytecode executed by PVM)", "Purely compiled to machine code", "Only static typed", "Requires hardware assembly"),
                "Interpreted (bytecode executed by PVM)", "Python compiles source code to bytecode which is interpreted by the Python Virtual Machine."));

        list.add(new Question("PY_05", cat, "Easy",
                "Which function returns the number of items in an object or collection?",
                Arrays.asList("len()", "size()", "count()", "length()"),
                "len()", "The built-in len() function returns the length (the number of items) of an object."));

        list.add(new Question("PY_06", cat, "Easy",
                "Which of the following data types is immutable in Python?",
                Arrays.asList("tuple", "list", "dict", "set"),
                "tuple", "Tuples in Python cannot be modified once created; lists, dictionaries, and sets are mutable."));

        list.add(new Question("PY_07", cat, "Easy",
                "What is the correct syntax to output 'Hello World' in Python 3?",
                Arrays.asList("print('Hello World')", "echo 'Hello World'", "System.out.print('Hello World')", "printf('Hello World')"),
                "print('Hello World')", "In Python 3, print() is a built-in function requiring parentheses."));

        list.add(new Question("PY_08", cat, "Easy",
                "What is the output of 'bool(0)' in Python?",
                Arrays.asList("False", "True", "None", "Error"),
                "False", "In Python, integer 0 evaluates to False in boolean context."));

        list.add(new Question("PY_09", cat, "Easy",
                "Which operator is used for exponentiation (power) in Python?",
                Arrays.asList("**", "^", "^^", "exp()"),
                "**", "The double asterisk (**) is the exponentiation operator in Python (e.g. 2 ** 3 = 8)."));

        list.add(new Question("PY_10", cat, "Easy",
                "How are code blocks defined in Python instead of curly braces?",
                Arrays.asList("Indentation (whitespace)", "Brackets {}", "Begin / End", "Parentheses ()"),
                "Indentation (whitespace)", "Python uses indentation (standardly 4 spaces) to delimit blocks of code."));

        list.add(new Question("PY_11", cat, "Easy",
                "Which built-in function reads a line of text entered by the user?",
                Arrays.asList("input()", "read()", "scan()", "get_input()"),
                "input()", "The input() function pauses execution and reads a string from standard input."));

        list.add(new Question("PY_12", cat, "Easy",
                "What is the file extension for standard Python files?",
                Arrays.asList(".py", ".pyt", ".python", ".p"),
                ".py", "Python source code files use the .py file extension."));

        list.add(new Question("PY_13", cat, "Easy",
                "Which collection stores unique, unordered elements in Python?",
                Arrays.asList("set", "list", "tuple", "ordered_list"),
                "set", "A set is an unordered collection with no duplicate elements."));

        list.add(new Question("PY_14", cat, "Easy",
                "What does 'range(5)' generate in Python 3?",
                Arrays.asList("Sequence from 0 to 4", "Sequence from 1 to 5", "Sequence from 0 to 5", "A random integer below 5"),
                "Sequence from 0 to 4", "range(stop) produces integers starting at 0 up to stop-1."));

        list.add(new Question("PY_15", cat, "Easy",
                "Which statement is used to handle exceptions in Python?",
                Arrays.asList("try ... except", "try ... catch", "do ... catch", "try ... rescue"),
                "try ... except", "Python uses try and except blocks for structured exception handling."));

        list.add(new Question("PY_16", cat, "Easy",
                "What will '3 * 'ab'' return in Python?",
                Arrays.asList("'ababab'", "'ab3'", "Error", "['ab', 'ab', 'ab']"),
                "'ababab'", "Multiplying a sequence by an integer repeats the sequence n times."));

        list.add(new Question("PY_17", cat, "Easy",
                "What is the keyword used to return a value from a function?",
                Arrays.asList("return", "send", "give", "result"),
                "return", "The 'return' statement exits a function and passes a value back to the caller."));

        // --- MEDIUM (17) ---
        list.add(new Question("PY_18", cat, "Medium",
                "What is a lambda function in Python?",
                Arrays.asList("An anonymous inline function defined with the lambda keyword", "A function that runs asynchronously in background", "A built-in mathematical library", "A function that has no arguments"),
                "An anonymous inline function defined with the lambda keyword", "Lambda functions are single-expression anonymous functions created using the 'lambda' keyword."));

        list.add(new Question("PY_19", cat, "Medium",
                "What is the difference between 'append()' and 'extend()' on a list?",
                Arrays.asList("append() adds its argument as a single element; extend() iterates and adds elements", "append() adds to beginning, extend() adds to end", "They are identical aliases", "extend() can only add strings"),
                "append() adds its argument as a single element; extend() iterates and adds elements", "append([1, 2]) nests the list; extend([1, 2]) unpacks and appends each element individually."));

        list.add(new Question("PY_20", cat, "Medium",
                "What is list comprehension in Python?",
                Arrays.asList("A concise syntactic construct to generate lists from iterables", "A sorting algorithm for lists", "A memory compression tool for big data", "A type casting method"),
                "A concise syntactic construct to generate lists from iterables", "List comprehension syntax like [x**2 for x in range(10)] provides a compact way to construct lists."));

        list.add(new Question("PY_21", cat, "Medium",
                "What is the purpose of the '__init__' method in a Python class?",
                Arrays.asList("Constructor method invoked when creating an instance", "Destructor invoked when garbage collected", "Imports external modules", "Defines class inheritance"),
                "Constructor method invoked when creating an instance", "__init__ initializes attributes of an newly created object instance."));

        list.add(new Question("PY_22", cat, "Medium",
                "What does '*args' and '**kwargs' represent in a function definition?",
                Arrays.asList("Variable positional arguments and variable keyword arguments", "Pointer dereferencing and double pointers", "Multiplication and exponentiation", "Default argument initializers"),
                "Variable positional arguments and variable keyword arguments", "*args collects extra positional arguments into a tuple, while **kwargs collects keyword arguments into a dictionary."));

        list.add(new Question("PY_23", cat, "Medium",
                "What does the 'pass' statement do in Python?",
                Arrays.asList("It is a null operation; nothing happens", "It skips the current loop iteration", "It breaks out of the function", "It passes execution to another thread"),
                "It is a null operation; nothing happens", "pass is a placeholder statement when a statement is required syntactically but no code needs execution."));

        list.add(new Question("PY_24", cat, "Medium",
                "What is the output of 'bool([])' in Python?",
                Arrays.asList("False", "True", "None", "TypeError"),
                "False", "Empty sequences (lists, tuples, dicts, strings) evaluate to False in Python."));

        list.add(new Question("PY_25", cat, "Medium",
                "How does slicing with step work: 'my_list[::-1]'?",
                Arrays.asList("Reverses the list", "Sorts the list in ascending order", "Removes the last item", "Raises an IndexError"),
                "Reverses the list", "A step of -1 traverses the sequence from end to beginning, effectively reversing it."));

        list.add(new Question("PY_26", cat, "Medium",
                "What does the 'with' statement accomplish in Python file handling?",
                Arrays.asList("Manages context automatically closing the file even if exceptions occur", "Locks the file from other processes", "Opens files in binary mode only", "Encrypts file contents"),
                "Manages context automatically closing the file even if exceptions occur", "The 'with' statement utilizes Context Managers to guarantee cleanup (__enter__ and __exit__)."));

        list.add(new Question("PY_27", cat, "Medium",
                "What is a Python decorator?",
                Arrays.asList("A function that takes another function and extends its behavior without modifying it", "A GUI widget styling class", "A comment syntax for documentation", "A built-in class inheritance modifier"),
                "A function that takes another function and extends its behavior without modifying it", "Decorators wrap another function, allowing you to execute code before and after the wrapped function runs."));

        list.add(new Question("PY_28", cat, "Medium",
                "What is the Global Interpreter Lock (GIL) in CPython?",
                Arrays.asList("A mutex that protects Python object access, preventing multi-core thread parallelism in pure Python code", "A security firewall for web apps", "A compiler lock for bytecode optimization", "A database transaction lock"),
                "A mutex that protects Python object access, preventing multi-core thread parallelism in pure Python code", "CPython's GIL ensures only one native thread executes Python bytecode at a time."));

        list.add(new Question("PY_29", cat, "Medium",
                "What is the difference between a shallow copy and a deep copy?",
                Arrays.asList("Shallow copy copies references to nested objects; deep copy recursively copies nested objects", "Shallow copy converts types; deep copy does not", "Shallow copy operates on disk; deep copy in RAM", "They are identical in Python"),
                "Shallow copy copies references to nested objects; deep copy recursively copies nested objects", "A shallow copy constructs a new compound object but inserts references to original nested objects; deep copy duplicates everything recursively."));

        list.add(new Question("PY_30", cat, "Medium",
                "What is the output of '[1, 2] + [3, 4]'?",
                Arrays.asList("[1, 2, 3, 4]", "[4, 6]", "[[1, 2], [3, 4]]", "Error"),
                "[1, 2, 3, 4]", "The '+' operator concatenates two lists into a single new list."));

        list.add(new Question("PY_31", cat, "Medium",
                "Which module in Python is used for regular expressions?",
                Arrays.asList("re", "regex", "pyregex", "match"),
                "re", "The standard library module 're' provides regular expression matching operations."));

        list.add(new Question("PY_32", cat, "Medium",
                "What does 'is' operator test in Python compared to '=='?",
                Arrays.asList("'is' tests identity (memory address); '==' tests value equality", "'is' tests equality; '==' tests identity", "They are identical", "'is' only works for numbers"),
                "'is' tests identity (memory address); '==' tests value equality", "'is' verifies whether two variables reference the exact same memory object (id(a) == id(b))."));

        list.add(new Question("PY_33", cat, "Medium",
                "What is a generator function in Python and what keyword does it use?",
                Arrays.asList("A function that yields values lazily on demand using the 'yield' keyword", "A function that generates random keys using 'return'", "A class generator using 'class'", "A multi-process pool using 'fork'"),
                "A function that yields values lazily on demand using the 'yield' keyword", "Generators produce sequence values iteratively using 'yield', maintaining state across calls with minimal memory overhead."));

        list.add(new Question("PY_34", cat, "Medium",
                "What does 'dict.get(key, default)' do when the key does not exist?",
                Arrays.asList("Returns the specified default value without throwing a KeyError", "Throws a KeyError", "Adds the key with the default value", "Returns False"),
                "Returns the specified default value without throwing a KeyError", "Unlike dict[key] which raises KeyError on absent keys, .get(key, default) safely returns default."));

        // --- HARD (16) ---
        list.add(new Question("PY_35", cat, "Hard",
                "What is the Method Resolution Order (MRO) algorithm used by Python 3 for multiple inheritance?",
                Arrays.asList("C3 Linearization algorithm", "Depth-First Search (DFS)", "Breadth-First Search (BFS)", "Dijkstra's shortest path"),
                "C3 Linearization algorithm", "Python uses C3 linearization to produce a consistent and monotonic method resolution order in complex inheritance hierarchies."));

        list.add(new Question("PY_36", cat, "Hard",
                "What is a Metaclass in Python?",
                Arrays.asList("A class whose instances are classes themselves; defined by inheriting from 'type'", "A class that imports metadata from JSON", "A base class for all C extensions", "A class with only static methods"),
                "A class whose instances are classes themselves; defined by inheriting from 'type'", "In Python, classes are objects of metaclasses; 'type' is the default metaclass that constructs class definitions."));

        list.add(new Question("PY_37", cat, "Hard",
                "What is the danger of using a mutable default argument in a Python function, such as 'def func(a=[])'?",
                Arrays.asList("The default list is created once at function definition and shared across all subsequent invocations", "Python raises a SyntaxError at compile time", "The list is garbage collected after the first call", "It causes stack overflow"),
                "The default list is created once at function definition and shared across all subsequent invocations", "Default parameter expressions are evaluated once when the function is defined, causing mutable objects to persist state across calls."));

        list.add(new Question("PY_38", cat, "Hard",
                "How does Python garbage collection handle cyclic references?",
                Arrays.asList("Using a generational cyclic garbage collector in addition to reference counting", "It cannot collect cyclic references, causing permanent leaks", "Using mark-and-sweep on every instruction", "By forbidding circular pointers"),
                "Using a generational cyclic garbage collector in addition to reference counting", "Python primarily uses reference counting, supplemented by a cyclic GC that tracks objects in generations (0, 1, 2) to detect isolated cycles."));

        list.add(new Question("PY_39", cat, "Hard",
                "What is the difference between '__str__' and '__repr__' in Python?",
                Arrays.asList("'__str__' is for end-user readability; '__repr__' is unambiguous representation often usable in eval()", "'__str__' is used by debugger; '__repr__' is for print", "'__str__' is required; '__repr__' is deprecated", "There is no difference"),
                "'__str__' is for end-user readability; '__repr__' is unambiguous representation often usable in eval()", "__repr__ aims to be explicit and debug-friendly; __str__ is informal string display."));

        list.add(new Question("PY_40", cat, "Hard",
                "What does the '__slots__' attribute achieve in a Python class?",
                Arrays.asList("Restricts valid attributes and prevents the creation of an internal '__dict__', saving memory", "Protects private variables from being accessed", "Enables multithreading locking on the instance", "Automatically generates getters and setters"),
                "Restricts valid attributes and prevents the creation of an internal '__dict__', saving memory", "__slots__ replaces dynamic per-instance dictionary with fixed-size arrays, significantly reducing memory consumption."));

        list.add(new Question("PY_41", cat, "Hard",
                "What happens when calling 'sys.setrecursionlimit(n)'?",
                Arrays.asList("Modifies the maximum depth of the Python interpreter stack before RecursionError is raised", "Sets the maximum number of threads allowed", "Caps the amount of RAM Python can consume", "Enables infinite loops without crash"),
                "Modifies the maximum depth of the Python interpreter stack before RecursionError is raised", "sys.setrecursionlimit sets the maximum depth limit of the Python call stack to prevent C stack overflows."));

        list.add(new Question("PY_42", cat, "Hard",
                "What is an 'asyncio' event loop in Python?",
                Arrays.asList("A single-threaded loop that manages and distributes execution of asynchronous tasks and I/O callbacks", "A multi-threaded queue for background jobs", "A hardware timer for GPU computations", "A web server socket listener"),
                "A single-threaded loop that manages and distributes execution of asynchronous tasks and I/O callbacks", "The asyncio event loop coordinates non-blocking cooperative multitasking and I/O operations using coroutines."));

        list.add(new Question("PY_43", cat, "Hard",
                "What is the difference between a Function and a Method in Python?",
                Arrays.asList("A method is bound to an instance or class and receives 'self' or 'cls' as the first argument", "Functions cannot return values", "Methods can only be called from C code", "They are completely unrelated constructs"),
                "A method is bound to an instance or class and receives 'self' or 'cls' as the first argument", "Methods are functions bound to objects via the descriptor protocol, automatically passing the bound instance as the first argument."));

        list.add(new Question("PY_44", cat, "Hard",
                "How does the descriptor protocol work in Python?",
                Arrays.asList("Classes implementing __get__, __set__, or __delete__ customize attribute access when used as class attributes", "Decorates SQL tables with schema definitions", "Generates API documentation at runtime", "Transforms bytecode into C structs"),
                "Classes implementing __get__, __set__, or __delete__ customize attribute access when used as class attributes", "Descriptors govern how attributes are accessed, powering properties, methods, and classmethods."));

        list.add(new Question("PY_45", cat, "Hard",
                "What is monkey patching in Python?",
                Arrays.asList("Dynamically modifying or extending a module or class at runtime without altering original source code", "Writing test scripts using random inputs", "A memory leak debugging tool", "Running Python code on embedded hardware"),
                "Dynamically modifying or extending a module or class at runtime without altering original source code", "Monkey patching is the practice of replacing attributes or methods on classes/modules at runtime."));

        list.add(new Question("PY_46", cat, "Hard",
                "What does 'collections.defaultdict' do when a missing key is accessed?",
                Arrays.asList("Calls the provided default_factory callable to create and insert a new value automatically", "Raises a KeyError", "Deletes the dictionary", "Freezes dictionary mutation"),
                "Calls the provided default_factory callable to create and insert a new value automatically", "defaultdict calls its default_factory (e.g. list, int) to populate missing keys on access."));

        list.add(new Question("PY_47", cat, "Hard",
                "What does the '@staticmethod' decorator do in a class definition?",
                Arrays.asList("Defines a method that does not receive an implicit first argument ('self' or 'cls')", "Makes the method private", "Prevents subclass overriding", "Caches method return values"),
                "Defines a method that does not receive an implicit first argument ('self' or 'cls')", "Static methods do not receive 'self' or 'cls', behaving like plain functions placed in the class namespace."));

        list.add(new Question("PY_48", cat, "Hard",
                "What is the effect of 'from copy import copy, deepcopy' on custom classes?",
                Arrays.asList("Allows custom copying logic by implementing __copy__() and __deepcopy__() methods", "Forces class attributes to be read-only", "Converts class instances to JSON strings", "Serializes instances to pickle files"),
                "Allows custom copying logic by implementing __copy__() and __deepcopy__() methods", "Classes can override __copy__ and __deepcopy__ to define specialized copy behaviors for complex resources."));

        list.add(new Question("PY_49", cat, "Hard",
                "What is the difference between 'threading' and 'multiprocessing' modules in Python regarding CPU-bound work?",
                Arrays.asList("multiprocessing bypasses the GIL by spawning separate processes, utilizing multiple CPU cores efficiently", "threading uses separate memory spaces", "multiprocessing is limited to single thread", "threading is always faster for heavy computation"),
                "multiprocessing bypasses the GIL by spawning separate processes, utilizing multiple CPU cores efficiently", "Because of the CPython GIL, CPU-bound parallelism requires separate processes provided by multiprocessing."));

        list.add(new Question("PY_50", cat, "Hard",
                "What does the built-in 'eval()' function do, and why is it considered unsafe with untrusted inputs?",
                Arrays.asList("Parses and executes a string as Python code, allowing arbitrary code execution", "Calculates only math formulas", "Validates syntax without execution", "Formats strings safely"),
                "Parses and executes a string as Python code, allowing arbitrary code execution", "eval() executes any valid Python expression, making it a critical security vulnerability if executed on unverified inputs."));

        return list;
    }
}
