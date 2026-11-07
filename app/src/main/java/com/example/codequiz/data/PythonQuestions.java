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
        loadEasy(list, cat);
        loadMedium(list, cat);
        loadHard(list, cat);
        return list;
    }

    private static void loadEasy(List<Question> list, String cat) {
        list.add(new Question("PYTHON_E_01", cat, "Easy",
                "Who developed the Python programming language?",
                Arrays.asList("Dennis Ritchie", "Guido van Rossum", "James Gosling", "Bjarne Stroustrup"),
                "Guido van Rossum",
                "Python was created by Guido van Rossum and released in 1991."));
        list.add(new Question("PYTHON_E_02", cat, "Easy",
                "Which character is used to start a single-line comment in Python?",
                Arrays.asList("//", "/*", "#", "--"),
                "#",
                "The # symbol is used for single-line comments in Python."));
        list.add(new Question("PYTHON_E_03", cat, "Easy",
                "What is the extension of Python source code files?",
                Arrays.asList(".py", ".python", ".pyt", ".p"),
                ".py",
                "Python source code files typically have the .py extension."));
        list.add(new Question("PYTHON_E_04", cat, "Easy",
                "Which of the following is an invalid variable name in Python?",
                Arrays.asList("my_var", "_myvar", "2myvar", "myVar2"),
                "2myvar",
                "Variable names cannot begin with a digit in Python."));
        list.add(new Question("PYTHON_E_05", cat, "Easy",
                "What is the output of the following code?\n\nx = 5\nprint(type(x).__name__)",
                Arrays.asList("int", "float", "str", "number"),
                "int",
                "The integer value 5 has the type 'int'."));
        list.add(new Question("PYTHON_E_06", cat, "Easy",
                "Which data type is immutable in Python?",
                Arrays.asList("list", "dict", "set", "tuple"),
                "tuple",
                "Tuples are immutable sequences in Python."));
        list.add(new Question("PYTHON_E_07", cat, "Easy",
                "What is the correct way to convert the float 3.14 to an integer in Python?",
                Arrays.asList("int(3.14)", "integer(3.14)", "(int)3.14", "parse_int(3.14)"),
                "int(3.14)",
                "The built-in int() function converts a float to an integer by truncating."));
        list.add(new Question("PYTHON_E_08", cat, "Easy",
                "What is the output of the expression type(True)?",
                Arrays.asList("<class 'bool'>", "<class 'int'>", "<class 'str'>", "<class 'boolean'>"),
                "<class 'bool'>",
                "True is a Boolean literal in Python, belonging to class 'bool'."));
        list.add(new Question("PYTHON_E_09", cat, "Easy",
                "Which of the following complex numbers is represented correctly in Python?",
                Arrays.asList("2 + 3i", "2 + 3j", "2 + 3k", "complex(2, 3i)"),
                "2 + 3j",
                "Python uses 'j' or 'J' to represent the imaginary part of complex numbers."));
        list.add(new Question("PYTHON_E_10", cat, "Easy",
                "What is the output of 10 // 3 in Python?",
                Arrays.asList("3.3333", "3.33", "3", "1"),
                "3",
                "The // operator performs floor division, returning the quotient 3."));
        list.add(new Question("PYTHON_E_11", cat, "Easy",
                "What is the result of 2 ** 3 ** 2?",
                Arrays.asList("64", "512", "36", "256"),
                "512",
                "Exponentiation ** is right-associative, so 3**2 = 9, then 2**9 = 512."));
        list.add(new Question("PYTHON_E_12", cat, "Easy",
                "Which operator is used to calculate the remainder of division in Python?",
                Arrays.asList("/", "%", "//", "rem"),
                "%",
                "The % modulo operator returns the remainder of division."));
        list.add(new Question("PYTHON_E_13", cat, "Easy",
                "What is the value of the expression: 5 + 3 * 2?",
                Arrays.asList("16", "11", "13", "10"),
                "11",
                "Multiplication has higher precedence than addition, so 3 * 2 = 6, then 5 + 6 = 11."));
        list.add(new Question("PYTHON_E_14", cat, "Easy",
                "Which keyword is used for 'else if' in Python?",
                Arrays.asList("elseif", "else if", "elif", "if else"),
                "elif",
                "Python uses 'elif' for conditional chain branches."));
        list.add(new Question("PYTHON_E_15", cat, "Easy",
                "What does the following code print?\n\nif 0:\n    print('A')\nelse:\n    print('B')",
                Arrays.asList("A", "B", "0", "SyntaxError"),
                "B",
                "In Python, 0 evaluates to False in a boolean context, executing the else block."));
        list.add(new Question("PYTHON_E_16", cat, "Easy",
                "Which statement is used as a placeholder when code is syntactically required?",
                Arrays.asList("continue", "break", "pass", "return"),
                "pass",
                "The 'pass' statement is a null statement used as a placeholder."));
        list.add(new Question("PYTHON_E_17", cat, "Easy",
                "What is the output of list(range(1, 5))?",
                Arrays.asList("[1, 2, 3, 4, 5]", "[1, 2, 3, 4]", "[0, 1, 2, 3, 4]", "[2, 3, 4, 5]"),
                "[1, 2, 3, 4]",
                "range(start, stop) generates integers from start up to (stop - 1)."));
        list.add(new Question("PYTHON_E_18", cat, "Easy",
                "Which statement is used to terminate a loop prematurely?",
                Arrays.asList("stop", "exit", "break", "end"),
                "break",
                "The 'break' statement terminates the current loop execution immediately."));
        list.add(new Question("PYTHON_E_19", cat, "Easy",
                "What does the 'continue' statement do inside a loop?",
                Arrays.asList("Exits the loop", "Skips the rest of the current iteration", "Restarts the entire loop", "Does nothing"),
                "Skips the rest of the current iteration",
                "The 'continue' statement skips the remaining statements of the current iteration and jumps to the next."));
        list.add(new Question("PYTHON_E_20", cat, "Easy",
                "What is the output of 'python'[1:4]?",
                Arrays.asList("pyt", "yth", "ytho", "pyth"),
                "yth",
                "Slicing [1:4] extracts characters from index 1 up to index 3 ('yth')."));
        list.add(new Question("PYTHON_E_21", cat, "Easy",
                "Which method converts a string to all uppercase letters?",
                Arrays.asList("to_upper()", "uppercase()", "upper()", "capital()"),
                "upper()",
                "The str.upper() method returns a copy of the string converted to uppercase."));
        list.add(new Question("PYTHON_E_22", cat, "Easy",
                "What is the result of 'Hello' + 'World'?",
                Arrays.asList("Hello World", "HelloWorld", "Hello+World", "Error"),
                "HelloWorld",
                "The + operator concatenates two strings directly without adding spaces."));
        list.add(new Question("PYTHON_E_23", cat, "Easy",
                "What is the length of the string 'Python\\n'?",
                Arrays.asList("6", "7", "8", "5"),
                "7",
                "The escape sequence '\\n' represents a single newline character, so length is 6 + 1 = 7."));
        list.add(new Question("PYTHON_E_24", cat, "Easy",
                "Which method adds an element to the end of a list?",
                Arrays.asList("add()", "insert()", "append()", "push()"),
                "append()",
                "The list.append() method adds a single item to the end of a list."));
        list.add(new Question("PYTHON_E_25", cat, "Easy",
                "How do you access the last item of a non-empty list 'lst' in Python?",
                Arrays.asList("lst[last]", "lst[-1]", "lst[end]", "lst[len(lst)]"),
                "lst[-1]",
                "Negative indexing lst[-1] accesses the last element of a sequence."));
        list.add(new Question("PYTHON_E_26", cat, "Easy",
                "Which of the following creates an empty dictionary?",
                Arrays.asList("{}", "set()", "[]", "dict[]"),
                "{}",
                "Curly braces {} create an empty dictionary. An empty set is created with set()."));
        list.add(new Question("PYTHON_E_27", cat, "Easy",
                "What is a key property of Python sets?",
                Arrays.asList("Elements are ordered", "Elements are indexed", "Elements are unique", "Elements are mutable"),
                "Elements are unique",
                "Sets are unordered collections that store unique elements."));
        list.add(new Question("PYTHON_E_28", cat, "Easy",
                "How do you access the value associated with key 'name' in dictionary 'd'?",
                Arrays.asList("d('name')", "d['name']", "d.name", "d->name"),
                "d['name']",
                "Dictionary values are accessed using square brackets d[key]."));
        list.add(new Question("PYTHON_E_29", cat, "Easy",
                "Which keyword is used to define a function in Python?",
                Arrays.asList("func", "function", "def", "define"),
                "def",
                "The 'def' keyword is used to start a function definition."));
        list.add(new Question("PYTHON_E_30", cat, "Easy",
                "What does a Python function return by default if no return statement is specified?",
                Arrays.asList("0", "False", "None", "Empty string"),
                "None",
                "Functions without an explicit return statement return None."));
        list.add(new Question("PYTHON_E_31", cat, "Easy",
                "What is a lambda function in Python?",
                Arrays.asList("A built-in module", "An anonymous single-expression function", "A recursive loop", "A class method"),
                "An anonymous single-expression function",
                "Lambda functions are small anonymous functions defined with the lambda keyword."));
        list.add(new Question("PYTHON_E_32", cat, "Easy",
                "What is the output of [x*2 for x in range(3)]?",
                Arrays.asList("[0, 2, 4]", "[2, 4, 6]", "[0, 1, 2]", "[1, 2, 3]"),
                "[0, 2, 4]",
                "range(3) produces 0, 1, 2. Multiplying each by 2 yields [0, 2, 4]."));
        list.add(new Question("PYTHON_E_33", cat, "Easy",
                "Which keyword is used to instantiate an object in Python?",
                Arrays.asList("new", "create", "instance", "No keyword is required"),
                "No keyword is required",
                "Python instantiates classes by calling the class name directly without 'new'."));
        list.add(new Question("PYTHON_E_34", cat, "Easy",
                "What is the purpose of the '__init__' method in a Python class?",
                Arrays.asList("To delete an object", "To serve as the constructor initializer", "To print class details", "To import modules"),
                "To serve as the constructor initializer",
                "The __init__ method acts as the class constructor to initialize attributes."));
        list.add(new Question("PYTHON_E_35", cat, "Easy",
                "What parameter represents the instance of the class in instance methods?",
                Arrays.asList("this", "self", "cls", "super"),
                "self",
                "By convention, 'self' is used as the first parameter of instance methods to refer to the current object."));
        list.add(new Question("PYTHON_E_36", cat, "Easy",
                "Which keyword is used to handle exceptions in Python?",
                Arrays.asList("catch", "except", "try", "handle"),
                "except",
                "Python uses try-except blocks to catch and handle exceptions."));
        list.add(new Question("PYTHON_E_37", cat, "Easy",
                "Which block in exception handling executes regardless of whether an exception occurred?",
                Arrays.asList("finally", "else", "except", "always"),
                "finally",
                "The 'finally' block always executes before exiting the try-except structure."));
        list.add(new Question("PYTHON_E_38", cat, "Easy",
                "Which mode parameter is used to open a file for writing, overwriting existing content?",
                Arrays.asList("'r'", "'a'", "'w'", "'x'"),
                "'w'",
                "'w' mode opens a file for writing and truncates/overwrites existing contents."));
        list.add(new Question("PYTHON_E_39", cat, "Easy",
                "What is the purpose of the 'with' statement when working with files?",
                Arrays.asList("To speed up file operations", "To automatically close the file when done", "To read binary files", "To encrypt file content"),
                "To automatically close the file when done",
                "The 'with' statement acts as a context manager that ensures files are properly closed."));
        list.add(new Question("PYTHON_E_40", cat, "Easy",
                "Which keyword is used to load a module in Python?",
                Arrays.asList("include", "import", "require", "load"),
                "import",
                "The 'import' statement is used to import modules into the script."));
        list.add(new Question("PYTHON_E_41", cat, "Easy",
                "What does len([1, [2, 3], 4]) evaluate to?",
                Arrays.asList("4", "3", "2", "5"),
                "3",
                "The top-level list has 3 elements: 1, [2, 3], and 4."));
        list.add(new Question("PYTHON_E_42", cat, "Easy",
                "What is the output of print(abs(-7.5))?",
                Arrays.asList("-7.5", "7.5", "7", "8"),
                "7.5",
                "abs() returns the absolute value of a number."));
        list.add(new Question("PYTHON_E_43", cat, "Easy",
                "What does min('python') return?",
                Arrays.asList("'p'", "'h'", "'y'", "'n'"),
                "'h'",
                "The character with the lowest ASCII value in 'python' is 'h' (ASCII 104)."));
        list.add(new Question("PYTHON_E_44", cat, "Easy",
                "Which built-in function returns an iterator of tuples containing index and value?",
                Arrays.asList("zip()", "enumerate()", "range()", "map()"),
                "enumerate()",
                "enumerate() yields tuples of (index, item) during iteration."));
        list.add(new Question("PYTHON_E_45", cat, "Easy",
                "What is the output of bool('')?",
                Arrays.asList("True", "False", "None", "Error"),
                "False",
                "An empty string '' is falsy in Python, so bool('') returns False."));
        list.add(new Question("PYTHON_E_46", cat, "Easy",
                "What does sum([1, 2, 3], 10) return?",
                Arrays.asList("6", "16", "10", "TypeError"),
                "16",
                "sum(iterable, start) adds the start value (10) to the sum of elements (6), resulting in 16."));
        list.add(new Question("PYTHON_E_47", cat, "Easy",
                "What is the output of str(10) + str(20)?",
                Arrays.asList("30", "1020", "10 20", "Error"),
                "1020",
                "String conversion produces '10' and '20'. Concatenation yields '1020'."));
        list.add(new Question("PYTHON_E_48", cat, "Easy",
                "Which function converts an integer to its binary string representation?",
                Arrays.asList("bin()", "binary()", "hex()", "to_bin()"),
                "bin()",
                "bin() converts an integer to a binary string prefixed with '0b'."));
        list.add(new Question("PYTHON_E_49", cat, "Easy",
                "What does any([False, 0, '', True]) evaluate to?",
                Arrays.asList("False", "True", "0", "None"),
                "True",
                "any() returns True if at least one element in the iterable is truthy."));
        list.add(new Question("PYTHON_E_50", cat, "Easy",
                "What does all([1, True, 'hello', []]) evaluate to?",
                Arrays.asList("True", "False", "None", "Error"),
                "False",
                "all() returns False because [] (empty list) is falsy."));
    }

    private static void loadMedium(List<Question> list, String cat) {
        list.add(new Question("PYTHON_M_01", cat, "Medium",
                "What is the output of the following code?\n\nfor i in range(1, 4):\n    for j in range(i):\n        print(i, end='')",
                Arrays.asList("122333", "112233", "123123", "123"),
                "122333",
                "i=1 prints '1' once; i=2 prints '2' twice; i=3 prints '3' three times -> '122333'."));
        list.add(new Question("PYTHON_M_02", cat, "Medium",
                "What is the output of this loop?\n\nfor i in range(3):\n    if i == 1:\n        break\nelse:\n    print('Loop Done')",
                Arrays.asList("Loop Done", "Nothing is printed", "0", "SyntaxError"),
                "Nothing is printed",
                "The else block of a loop is skipped if the loop is terminated by a break statement."));
        list.add(new Question("PYTHON_M_03", cat, "Medium",
                "What is the result of 'a,b,c'.split(',', 1)?",
                Arrays.asList("['a', 'b', 'c']", "['a', 'b,c']", "['a,b', 'c']", "['a', 'b']"),
                "['a', 'b,c']",
                "maxsplit=1 splits the string at the first comma only."));
        list.add(new Question("PYTHON_M_04", cat, "Medium",
                "What is the output of 'Python'.find('z')?",
                Arrays.asList("0", "False", "-1", "ValueError"),
                "-1",
                "str.find() returns -1 when the substring is not found."));
        list.add(new Question("PYTHON_M_05", cat, "Medium",
                "What is the result of '  hello  '.strip()?",
                Arrays.asList("'hello  '", "'  hello'", "'hello'", "'h e l l o'"),
                "'hello'",
                "strip() removes leading and trailing whitespace characters."));
        list.add(new Question("PYTHON_M_06", cat, "Medium",
                "What is the output of the following code?\n\na = [1, 2, 3]\nb = a\nb.append(4)\nprint(a)",
                Arrays.asList("[1, 2, 3]", "[1, 2, 3, 4]", "[4, 1, 2, 3]", "AttributeError"),
                "[1, 2, 3, 4]",
                "'a' and 'b' reference the same list object in memory, so modifying 'b' affects 'a'."));
        list.add(new Question("PYTHON_M_07", cat, "Medium",
                "What is the output of [1, 2, 3] + [4, 5]?",
                Arrays.asList("[5, 7]", "[1, 2, 3, 4, 5]", "[[1, 2, 3], [4, 5]]", "TypeError"),
                "[1, 2, 3, 4, 5]",
                "The + operator concatenates two lists into a single new list."));
        list.add(new Question("PYTHON_M_08", cat, "Medium",
                "What is the result of {1, 2, 3} & {2, 3, 4}?",
                Arrays.asList("{1, 2, 3, 4}", "{2, 3}", "{1, 4}", "{}"),
                "{2, 3}",
                "The & operator computes the set intersection, yielding common elements {2, 3}."));
        list.add(new Question("PYTHON_M_09", cat, "Medium",
                "What is the output of the following dict code?\n\nd = {'a': 1, 'b': 2}\nprint(d.get('c', 3))",
                Arrays.asList("None", "KeyError", "3", "2"),
                "3",
                "dict.get(key, default) returns default value (3) when key 'c' is not present."));
        list.add(new Question("PYTHON_M_10", cat, "Medium",
                "What happens when you execute d = {[1, 2]: 'val'}?",
                Arrays.asList("Key set to [1, 2]", "TypeError: unhashable type: 'list'", "KeyError", "SyntaxError"),
                "TypeError: unhashable type: 'list'",
                "Lists are mutable and unhashable, so they cannot be used as dictionary keys."));
        list.add(new Question("PYTHON_M_11", cat, "Medium",
                "What is the output of the following code?\n\ndef func(a, b=2, c=3):\n    return a + b + c\nprint(func(1, c=5))",
                Arrays.asList("6", "8", "9", "10"),
                "8",
                "a=1, b defaults to 2, c=5. 1 + 2 + 5 = 8."));
        list.add(new Question("PYTHON_M_12", cat, "Medium",
                "In *args and **kwargs, what types are args and kwargs inside the function?",
                Arrays.asList("list and dict", "tuple and dict", "tuple and list", "set and dict"),
                "tuple and dict",
                "*args packs positional arguments into a tuple, while **kwargs packs keyword arguments into a dict."));
        list.add(new Question("PYTHON_M_13", cat, "Medium",
                "What is the output of the following code?\n\ndef add_item(item, lst=[]):\n    lst.append(item)\n    return lst\nadd_item(1)\nprint(add_item(2))",
                Arrays.asList("[2]", "[1, 2]", "[[1], [2]]", "[1]"),
                "[1, 2]",
                "Default mutable argument lst is evaluated once at function definition and reused across calls."));
        list.add(new Question("PYTHON_M_14", cat, "Medium",
                "What is the output of the following code?\n\nx = 10\ndef foo():\n    global x\n    x = 20\nfoo()\nprint(x)",
                Arrays.asList("10", "20", "None", "UnboundLocalError"),
                "20",
                "The global keyword inside foo allows modification of global variable x."));
        list.add(new Question("PYTHON_M_15", cat, "Medium",
                "What is the return value of mystery(4)?\n\ndef mystery(n):\n    if n <= 1:\n        return 1\n    return n * mystery(n - 1)",
                Arrays.asList("10", "12", "24", "16"),
                "24",
                "mystery computes factorial: 4 * 3 * 2 * 1 = 24."));
        list.add(new Question("PYTHON_M_16", cat, "Medium",
                "What is the output of [x for x in range(10) if x % 2 == 0 and x % 3 == 0]?",
                Arrays.asList("[0, 6]", "[6]", "[0, 2, 4, 6, 8]", "[0, 3, 6, 9]"),
                "[0, 6]",
                "Numbers in range(10) divisible by both 2 and 3 are 0 and 6."));
        list.add(new Question("PYTHON_M_17", cat, "Medium",
                "What is the output of {x: x**2 for x in (1, 2, 3)}?",
                Arrays.asList("{1: 1, 2: 4, 3: 9}", "[(1,1), (2,4), (3,9)]", "{1, 4, 9}", "(1, 4, 9)"),
                "{1: 1, 2: 4, 3: 9}",
                "This dictionary comprehension maps each number to its square."));
        list.add(new Question("PYTHON_M_18", cat, "Medium",
                "What is the output of the following code?\n\nclass Parent:\n    def speak(self):\n        return 'Parent'\nclass Child(Parent):\n    def speak(self):\n        return 'Child'\nc = Child()\nprint(c.speak())",
                Arrays.asList("Parent", "Child", "ChildParent", "AttributeError"),
                "Child",
                "Method overriding in Child class overrides the parent implementation."));
        list.add(new Question("PYTHON_M_19", cat, "Medium",
                "How do you call a parent class method inside an overridden child method?",
                Arrays.asList("parent.method()", "super().method()", "base.method()", "this.method()"),
                "super().method()",
                "super() provides access to inherited methods overwritten in the subclass."));
        list.add(new Question("PYTHON_M_20", cat, "Medium",
                "What does private name mangling do to attribute __data in class Sample?",
                Arrays.asList("Deletes __data", "Renames it to _Sample__data", "Makes it public", "Throws AttributeError"),
                "Renames it to _Sample__data",
                "Python mangles attributes starting with double underscores to _ClassName__attribute."));
        list.add(new Question("PYTHON_M_21", cat, "Medium",
                "What is the output of the following code?\n\ntry:\n    res = 10 / 0\nexcept ZeroDivisionError:\n    res = 0\nelse:\n    res = 1\nprint(res)",
                Arrays.asList("10", "0", "1", "ZeroDivisionError"),
                "0",
                "Exception is caught by ZeroDivisionError, setting res to 0. The 'else' block executes only if no exception occurs."));
        list.add(new Question("PYTHON_M_22", cat, "Medium",
                "Which built-in exception is raised when an array index is out of range?",
                Arrays.asList("KeyError", "ValueError", "IndexError", "LookupError"),
                "IndexError",
                "IndexError is raised when a sequence subscript is out of range."));
        list.add(new Question("PYTHON_M_23", cat, "Medium",
                "What is the output of file.read(5) on a text file starting with 'Hello World'?",
                Arrays.asList("'Hello World'", "'Hello'", "'World'", "'H'"),
                "'Hello'",
                "read(n) reads at most n characters/bytes from the file."));
        list.add(new Question("PYTHON_M_24", cat, "Medium",
                "What special file (optional since Python 3.3) marks a directory as a Python package?",
                Arrays.asList("__main__.py", "__init__.py", "__package__.py", "setup.py"),
                "__init__.py",
                "An __init__.py file marks a directory as a Python package directory."));
        list.add(new Question("PYTHON_M_25", cat, "Medium",
                "What is the result of comparing a = [1, 2] and b = [1, 2] with 'a is b' and 'a == b'?",
                Arrays.asList("True, True", "False, True", "True, False", "False, False"),
                "False, True",
                "'is' checks identity (memory location, False), while '==' checks equality of values (True)."));
        list.add(new Question("PYTHON_M_26", cat, "Medium",
                "What is the output of list(zip([1, 2], ['a', 'b', 'c']))?",
                Arrays.asList("[(1, 'a'), (2, 'b')]", "[(1, 'a'), (2, 'b'), (None, 'c')]", "[(1, 2), ('a', 'b', 'c')]", "IndexError"),
                "[(1, 'a'), (2, 'b')]",
                "zip() stops at the shortest input iterable."));
        list.add(new Question("PYTHON_M_27", cat, "Medium",
                "What does list(map(lambda x: x*2, [1, 2, 3])) yield?",
                Arrays.asList("[1, 2, 3, 1, 2, 3]", "[2, 4, 6]", "[1, 4, 9]", "[2, 2, 2]"),
                "[2, 4, 6]",
                "map applies the lambda function to each element of the list, resulting in [2, 4, 6]."));
        list.add(new Question("PYTHON_M_28", cat, "Medium",
                "What does list(filter(lambda x: x > 2, [1, 2, 3, 4])) output?",
                Arrays.asList("[1, 2]", "[3, 4]", "[False, False, True, True]", "[1, 2, 3, 4]"),
                "[3, 4]",
                "filter keeps elements for which the function returns True."));
        list.add(new Question("PYTHON_M_29", cat, "Medium",
                "What is the output of print('a' < 'b' and 'B' < 'a')?",
                Arrays.asList("True", "False", "None", "TypeError"),
                "True",
                "ASCII value of 'a' (97) > 'b' (98) is False? No, 'a' < 'b' is True (97 < 98). ASCII 'B' (66) < 'a' (97) is True. True and True is True."));
        list.add(new Question("PYTHON_M_30", cat, "Medium",
                "What is the output of print(0.1 + 0.2 == 0.3)?",
                Arrays.asList("True", "False", "Error", "0.3"),
                "False",
                "Due to floating-point representation, 0.1 + 0.2 evaluates to 0.30000000000000004, which is not equal to 0.3."));
        list.add(new Question("PYTHON_M_31", cat, "Medium",
                "What is the result of sorted([3, '1', 2])?",
                Arrays.asList("['1', 2, 3]", "[1, 2, 3]", "TypeError", "[3, 2, '1']"),
                "TypeError",
                "In Python 3, comparing integers and strings directly raises a TypeError."));
        list.add(new Question("PYTHON_M_32", cat, "Medium",
                "What is the output of print(*[1, 2, 3])?",
                Arrays.asList("[1, 2, 3]", "1 2 3", "(1, 2, 3)", "1, 2, 3"),
                "1 2 3",
                "The unpack operator * passes list elements as positional arguments to print(), separated by spaces."));
        list.add(new Question("PYTHON_M_33", cat, "Medium",
                "What does bool([0]) return?",
                Arrays.asList("False", "True", "0", "TypeError"),
                "True",
                "A non-empty list, even containing 0, evaluates to True in boolean context."));
        list.add(new Question("PYTHON_M_34", cat, "Medium",
                "What is the output of print(round(2.5), round(3.5))?",
                Arrays.asList("2 3", "3 4", "2 4", "3 3"),
                "2 4",
                "Python 3 uses round-half-to-even: 2.5 rounds to 2 and 3.5 rounds to 4."));
        list.add(new Question("PYTHON_M_35", cat, "Medium",
                "What is the result of 'Python'.replace('P', '')?",
                Arrays.asList("ython", "Python", "P", "ValueError"),
                "ython",
                "replace('P', '') removes character 'P' from string."));
        list.add(new Question("PYTHON_M_36", cat, "Medium",
                "What is the output of print('Hello {name}'.format(name='Alice'))?",
                Arrays.asList("Hello name", "Hello Alice", "Hello {Alice}", "KeyError"),
                "Hello Alice",
                "str.format replaces positional or keyword placeholders with argument values."));
        list.add(new Question("PYTHON_M_37", cat, "Medium",
                "What is the output of [x if x % 2 == 0 else 0 for x in range(4)]?",
                Arrays.asList("[0, 2]", "[0, 0, 2, 0]", "[0, 1, 2, 3]", "[0, 2, 4]"),
                "[0, 0, 2, 0]",
                "For x in 0, 1, 2, 3: 0 is even -> 0; 1 is odd -> 0; 2 is even -> 2; 3 is odd -> 0. Result: [0, 0, 2, 0]."));
        list.add(new Question("PYTHON_M_38", cat, "Medium",
                "What is the value of d after d = {}; d.update({'a': 1}); d.update({'a': 2})?",
                Arrays.asList("{'a': 1}", "{'a': 2}", "{'a': [1, 2]}", "{'a': 1, 'a': 2}"),
                "{'a': 2}",
                "dict.update overwrites values for existing keys."));
        list.add(new Question("PYTHON_M_39", cat, "Medium",
                "What does list(range(5, 0, -1)) return?",
                Arrays.asList("[5, 4, 3, 2, 1]", "[5, 4, 3, 2, 1, 0]", "[4, 3, 2, 1, 0]", "[]"),
                "[5, 4, 3, 2, 1]",
                "range(start, stop, step) with start 5, stop 0, step -1 yields [5, 4, 3, 2, 1]."));
        list.add(new Question("PYTHON_M_40", cat, "Medium",
                "What is the result of 'abc'.join(['1', '2', '3'])?",
                Arrays.asList("123abc", "1abc2abc3", "abc123", "123"),
                "1abc2abc3",
                "'abc'.join(['1', '2', '3']) places 'abc' between each string element."));
        list.add(new Question("PYTHON_M_41", cat, "Medium",
                "What is the result of (1, 2) + (3, 4)?",
                Arrays.asList("(4, 6)", "(1, 2, 3, 4)", "((1, 2), (3, 4))", "TypeError"),
                "(1, 2, 3, 4)",
                "Concatenating two tuples produces a combined tuple."));
        list.add(new Question("PYTHON_M_42", cat, "Medium",
                "What is the output of min([], default=10)?",
                Arrays.asList("None", "ValueError", "10", "0"),
                "10",
                "min() returns the default argument when given an empty iterable."));
        list.add(new Question("PYTHON_M_43", cat, "Medium",
                "What is the output of print(f'{10+20}')?",
                Arrays.asList("10+20", "30", "f'30'", "SyntaxError"),
                "30",
                "f-strings evaluate expressions inside curly braces."));
        list.add(new Question("PYTHON_M_44", cat, "Medium",
                "What is the output of print(eval('2 * 3 + 4'))?",
                Arrays.asList("2 * 3 + 4", "10", "14", "Error"),
                "10",
                "eval() parses and executes the Python expression string '2 * 3 + 4' = 10."));
        list.add(new Question("PYTHON_M_45", cat, "Medium",
                "What is the output of '123'.isdigit(), '123a'.isdigit()?",
                Arrays.asList("(True, True)", "(True, False)", "(False, False)", "(False, True)"),
                "(True, False)",
                "isdigit() returns True if all characters in string are digits."));
        list.add(new Question("PYTHON_M_46", cat, "Medium",
                "What is the output of print(isinstance(True, int))?",
                Arrays.asList("False", "True", "TypeError", "None"),
                "True",
                "In Python, bool is a subclass of int, so isinstance(True, int) is True."));
        list.add(new Question("PYTHON_M_47", cat, "Medium",
                "What is the output of print(list(enumerate(['a'], start=1)))?",
                Arrays.asList("[(0, 'a')]", "[(1, 'a')]", "[('a', 1)]", "[(1)]"),
                "[(1, 'a')]",
                "enumerate with start=1 starts indexing at 1, returning [(1, 'a')]."));
        list.add(new Question("PYTHON_M_48", cat, "Medium",
                "What is the output of print(divmod(10, 3))?",
                Arrays.asList("(3.33, 1)", "(3, 1)", "[3, 1]", "(1, 3)"),
                "(3, 1)",
                "divmod(a, b) returns tuple (a // b, a % b), which is (3, 1)."));
        list.add(new Question("PYTHON_M_49", cat, "Medium",
                "What does dict.fromkeys(['a', 'b'], 0) return?",
                Arrays.asList("{'a': 0, 'b': 0}", "{0: 'a', 0: 'b'}", "['a', 'b']", "{'a': None, 'b': None}"),
                "{'a': 0, 'b': 0}",
                "fromkeys creates a dictionary with keys from sequence and specified value."));
        list.add(new Question("PYTHON_M_50", cat, "Medium",
                "What is the output of print(list(range(0, -5, -1)))?",
                Arrays.asList("[0, -1, -2, -3, -4]", "[0, -1, -2, -3, -4, -5]", "[-1, -2, -3, -4, -5]", "[]"),
                "[0, -1, -2, -3, -4]",
                "range(0, -5, -1) starts at 0 and decrements by 1 down to -4."));
    }

    private static void loadHard(List<Question> list, String cat) {
        list.add(new Question("PYTHON_H_01", cat, "Hard",
                "Given classes A, B(A), C(A), D(B, C), what is D.__mro__ order?",
                Arrays.asList("D, B, C, A, object", "D, B, A, C, object", "D, C, B, A, object", "D, A, B, C, object"),
                "D, B, C, A, object",
                "Python's C3 Linearization algorithm orders hierarchy as D -> B -> C -> A -> object."));
        list.add(new Question("PYTHON_H_02", cat, "Hard",
                "What happens when defining class Meta(type) and class A(metaclass=Meta)?",
                Arrays.asList("Meta instantiates instances of A", "Meta controls the creation and structure of class A itself", "SyntaxError", "A inherits methods from type"),
                "Meta controls the creation and structure of class A itself",
                "Metaclasses inherit from type and customize class creation at definition time."));
        list.add(new Question("PYTHON_H_03", cat, "Hard",
                "What does the @functools.wraps(func) decorator do inside a custom decorator?",
                Arrays.asList("Speeds up function execution", "Preserves original function name, docstring, and metadata", "Prevents recursion errors", "Validates argument types"),
                "Preserves original function name, docstring, and metadata",
                "wraps() copies attributes like __name__ and __doc__ from original function to wrapper."));
        list.add(new Question("PYTHON_H_04", cat, "Hard",
                "What is the behavior of calling next() on a generator that has completed execution?",
                Arrays.asList("Returns None", "Restarts generator", "Raises StopIteration exception", "Raises GeneratorExit exception"),
                "Raises StopIteration exception",
                "Iterators and generators raise StopIteration when there are no further items."));
        list.add(new Question("PYTHON_H_05", cat, "Hard",
                "What is the primary difference between yield and yield from in a generator?",
                Arrays.asList("yield from is faster than yield", "yield from delegates iteration to a sub-generator or iterable", "yield from returns a tuple", "yield from is used only in async functions"),
                "yield from delegates iteration to a sub-generator or iterable",
                "yield from delegates generator execution to another sub-iterable or generator."));
        list.add(new Question("PYTHON_H_06", cat, "Hard",
                "What is the output of the following code?\n\ndef outer():\n    x = 10\n    def inner():\n        nonlocal x\n        x += 5\n        return x\n    return inner\nf = outer()\nprint(f(), f())",
                Arrays.asList("15 15", "15 20", "10 15", "UnboundLocalError"),
                "15 20",
                "nonlocal binds x to outer scope. First call modifies x to 15, second call modifies x to 20."));
        list.add(new Question("PYTHON_H_07", cat, "Hard",
                "What is the key difference between copy.copy() and copy.deepcopy()?",
                Arrays.asList("copy() is faster; deepcopy() creates a shallow copy", "copy() creates a shallow copy; deepcopy() recursively copies nested objects", "deepcopy() works only on lists", "They perform identical operations"),
                "copy() creates a shallow copy; deepcopy() recursively copies nested objects",
                "Shallow copy constructs a new object inserting references; deepcopy recursively copies all nested objects."));
        list.add(new Question("PYTHON_H_08", cat, "Hard",
                "What does the sys.getrefcount(obj) function return?",
                Arrays.asList("Total memory used by obj", "Current reference count of obj plus one temporary reference", "Number of attributes in obj", "Number of instances of obj"),
                "Current reference count of obj plus one temporary reference",
                "getrefcount() returns current reference count, including temporary reference passed as argument."));
        list.add(new Question("PYTHON_H_09", cat, "Hard",
                "What is the output of the following code?\n\nfuncs = [lambda: i for i in range(3)]\nprint([f() for f in funcs])",
                Arrays.asList("[0, 1, 2]", "[2, 2, 2]", "[0, 0, 0]", "[3, 3, 3]"),
                "[2, 2, 2]",
                "Late binding in closures binds 'i' by reference; after loop completes, 'i' evaluates to 2 for all lambdas."));
        list.add(new Question("PYTHON_H_10", cat, "Hard",
                "How can late binding issue in lambdas inside loops be resolved?",
                Arrays.asList("Use funcs = [lambda i=i: i for i in range(3)]", "Use global i", "Use nonlocal i", "Convert loop to while loop"),
                "Use funcs = [lambda i=i: i for i in range(3)]",
                "Setting default argument i=i binds current loop value at definition time."));
        list.add(new Question("PYTHON_H_11", cat, "Hard",
                "What is the output of the following code?\n\na = [[]] * 3\na[0].append(1)\nprint(a)",
                Arrays.asList("[[1], [], []]", "[[1], [1], [1]]", "[[1], [0], [0]]", "[[1, 1, 1]]"),
                "[[1], [1], [1]]",
                "Multiplying list with mutable elements repeats references to the same inner list object."));
        list.add(new Question("PYTHON_H_12", cat, "Hard",
                "What is the average time complexity of key lookup in a Python dictionary?",
                Arrays.asList("O(n)", "O(1)", "O(log n)", "O(n log n)"),
                "O(1)",
                "Dictionaries in Python use hash tables, offering average O(1) time complexity for lookup."));
        list.add(new Question("PYTHON_H_13", cat, "Hard",
                "What algorithm does Python's built-in sorted() and list.sort() use?",
                Arrays.asList("Quicksort", "Mergesort", "Timsort", "Heapsort"),
                "Timsort",
                "Python uses Timsort, a hybrid stable sorting algorithm derived from merge sort and insertion sort."));
        list.add(new Question("PYTHON_H_14", cat, "Hard",
                "What is the role of GIL (Global Interpreter Lock) in CPython?",
                Arrays.asList("It speeds up multithreaded CPU-bound programs", "It prevents multiple native threads from executing Python bytecodes concurrently", "It handles garbage collection", "It compiles Python code to machine code"),
                "It prevents multiple native threads from executing Python bytecodes concurrently",
                "GIL ensures thread safety by allowing only one CPython thread to execute bytecode at a time."));
        list.add(new Question("PYTHON_H_15", cat, "Hard",
                "Which module is recommended for CPU-bound parallel execution in Python to bypass GIL?",
                Arrays.asList("threading", "asyncio", "multiprocessing", "concurrent.futures.ThreadPoolExecutor"),
                "multiprocessing",
                "multiprocessing spawns separate processes, each with its own Python interpreter and GIL instance."));
        list.add(new Question("PYTHON_H_16", cat, "Hard",
                "What is the output of the following code?\n\nclass A:\n    x = 1\nclass B(A):\n    pass\nclass C(A):\n    pass\nB.x = 2\nA.x = 3\nprint(A.x, B.x, C.x)",
                Arrays.asList("3 2 3", "3 3 3", "1 2 3", "3 2 1"),
                "3 2 3",
                "B.x sets attribute on B class. Changing A.x updates A and C (inheriting from A), but not B which has overriding attribute."));
        list.add(new Question("PYTHON_H_17", cat, "Hard",
                "What is the output of this function?\n\ndef test():\n    try:\n        return 1\n    finally:\n        return 2\nprint(test())",
                Arrays.asList("1", "2", "None", "SyntaxError"),
                "2",
                "A return statement in the finally block overrides any previous return statement in try/except."));
        list.add(new Question("PYTHON_H_18", cat, "Hard",
                "What is the result of print(bool(type(None)))?",
                Arrays.asList("False", "True", "None", "TypeError"),
                "True",
                "type(None) returns <class 'NoneType'>, which is a class object, and all class objects are truthy."));
        list.add(new Question("PYTHON_H_19", cat, "Hard",
                "What does the '__slots__' declaration in a Python class accomplish?",
                Arrays.asList("Restricts class inheritance", "Prevents creation of __dict__ and optimizes memory for instances", "Makes all attributes private", "Enforces type hints"),
                "Prevents creation of __dict__ and optimizes memory for instances",
                "__slots__ reserves space for specified attributes, eliminating per-instance __dict__ and saving memory."));
        list.add(new Question("PYTHON_H_20", cat, "Hard",
                "What is the output of print(isinstance(type, object)) and print(isinstance(object, type))?",
                Arrays.asList("True, False", "False, True", "True, True", "False, False"),
                "True, True",
                "In Python object-model, type is an instance of object, and object is an instance of type (both True)."));
        list.add(new Question("PYTHON_H_21", cat, "Hard",
                "What is the output of the following expression?\n\nprint(sum([True, True, False, True]))",
                Arrays.asList("TypeError", "3", "True", "4"),
                "3",
                "bool is a subclass of int (True=1, False=0), so sum is 1+1+0+1 = 3."));
        list.add(new Question("PYTHON_H_22", cat, "Hard",
                "What is the output of [x for x in (1, 2, 3) if (x := x + 1) > 2]?",
                Arrays.asList("[2, 3]", "[2, 3, 4]", "[1, 2, 3]", "SyntaxError"),
                "[2, 3]",
                "Walrus operator := increments x and evaluates condition. x=1 -> 2 (>2 False); x=2 -> 3 (>2 True); x=3 -> 4 (>2 True). Outputs evaluated x: [2, 3] or values selected."));
        list.add(new Question("PYTHON_H_23", cat, "Hard",
                "What is the output of print('a' is 'a', [1] is [1])?",
                Arrays.asList("(True, True)", "(True, False)", "(False, False)", "(False, True)"),
                "(True, False)",
                "String literals are interned/identical in CPython, but distinct list literals create new separate objects."));
        list.add(new Question("PYTHON_H_24", cat, "Hard",
                "What is the value of x after x, *y, z = [1, 2, 3, 4, 5]?",
                Arrays.asList("1", "[1]", "[2, 3, 4]", "5"),
                "1",
                "Extended unpacking assigns x=1, y=[2, 3, 4], and z=5."));
        list.add(new Question("PYTHON_H_25", cat, "Hard",
                "What is the result of dict(a=1, **{'b': 2, 'c': 3})?",
                Arrays.asList("{'a': 1, 'b': 2, 'c': 3}", "TypeError", "{'a': 1, 'bc': 23}", "SyntaxError"),
                "{'a': 1, 'b': 2, 'c': 3}",
                "dict keyword arguments and unpacked dictionary merge into a single dictionary."));
        list.add(new Question("PYTHON_H_26", cat, "Hard",
                "What is the output of list(bytes([65, 66, 67]))?",
                Arrays.asList("['A', 'B', 'C']", "[65, 66, 67]", "b'ABC'", "TypeError"),
                "[65, 66, 67]",
                "Iterating over a bytes object yields integer byte values [65, 66, 67]."));
        list.add(new Question("PYTHON_H_27", cat, "Hard",
                "What is the value of print(1_000_000 + 2_000)?",
                Arrays.asList("1_002_000", "1002000", "SyntaxError", "10000002000"),
                "1002000",
                "Underscores in numeric literals are ignored by Python parser for readability."));
        list.add(new Question("PYTHON_H_28", cat, "Hard",
                "What is the output of slice(1, 5, 2).indices(10)?",
                Arrays.asList("(1, 5, 2)", "(1, 10, 2)", "(0, 5, 2)", "AttributeError"),
                "(1, 5, 2)",
                "slice.indices(length) calculates start, stop, step tuple for sequence of given length."));
        list.add(new Question("PYTHON_H_29", cat, "Hard",
                "What is the output of print({1, 2} < {1, 2, 3})?",
                Arrays.asList("True", "False", "TypeError", "None"),
                "True",
                "The < operator between sets tests for strict proper subset."));
        list.add(new Question("PYTHON_H_30", cat, "Hard",
                "What is the result of print(hash((1, 2)), hash([1, 2]))?",
                Arrays.asList("Both succeed", "Raises TypeError on tuple", "Raises TypeError on list", "Both raise TypeError"),
                "Raises TypeError on list",
                "Lists are mutable and unhashable, raising TypeError when passed to hash()."));
        list.add(new Question("PYTHON_H_31", cat, "Hard",
                "What is the output of array slicing x = [0, 1, 2, 3, 4]; x[:: -1]?",
                Arrays.asList("[0, 1, 2, 3, 4]", "[4, 3, 2, 1, 0]", "[4, 3, 2, 1]", "IndexError"),
                "[4, 3, 2, 1, 0]",
                "Negative step -1 reverses sequence."));
        list.add(new Question("PYTHON_H_32", cat, "Hard",
                "What is the output of math.isclose(0.1 + 0.2, 0.3)?",
                Arrays.asList("False", "True", "TypeError", "None"),
                "True",
                "math.isclose checks floating point closeness within tolerance, returning True."));
        list.add(new Question("PYTHON_H_33", cat, "Hard",
                "What does sys.setrecursionlimit(1000) do?",
                Arrays.asList("Increases recursion speed by 1000x", "Sets maximum depth of Python interpreter stack", "Limits loop iterations to 1000", "Restricts memory usage"),
                "Sets maximum depth of Python interpreter stack",
                "sys.setrecursionlimit configures maximum call stack depth."));
        list.add(new Question("PYTHON_H_34", cat, "Hard",
                "What is the output of print(any([]), all([]))?",
                Arrays.asList("False True", "True False", "False False", "True True"),
                "False True",
                "any([]) is False (no true elements); all([]) is vacuously True."));
        list.add(new Question("PYTHON_H_35", cat, "Hard",
                "What is the output of print(chr(ord('A') + 2))?",
                Arrays.asList("'A2'", "'C'", "'B'", "67"),
                "'C'",
                "ord('A') is 65, + 2 = 67, chr(67) is 'C'."));
        list.add(new Question("PYTHON_H_36", cat, "Hard",
                "What does string.ascii_lowercase contain?",
                Arrays.asList("All letters a-z", "All letters A-Z", "Digits 0-9", "ASCII printable characters"),
                "All letters a-z",
                "string.ascii_lowercase is string constant 'abcdefghijklmnopqrstuvwxyz'."));
        list.add(new Question("PYTHON_H_37", cat, "Hard",
                "What is the result of print(10 and 20 or 30)?",
                Arrays.asList("10", "20", "30", "True"),
                "20",
                "'10 and 20' evaluates to 20; '20 or 30' short-circuits and evaluates to 20."));
        list.add(new Question("PYTHON_H_38", cat, "Hard",
                "What is the output of type(lambda: None)?",
                Arrays.asList("<class 'function'>", "<class 'lambda'>", "<class 'NoneType'>", "<class 'type'>"),
                "<class 'function'>",
                "Lambda functions are instances of standard function type."));
        list.add(new Question("PYTHON_H_39", cat, "Hard",
                "What happens when executing 'del x' where x is a variable name?",
                Arrays.asList("Frees memory immediately", "Unbinds name 'x' from current namespace", "Sets x to None", "Deletes definition from disk"),
                "Unbinds name 'x' from current namespace",
                "'del x' removes binding of name x from local/global namespace."));
        list.add(new Question("PYTHON_H_40", cat, "Hard",
                "What is the result of list(set([1, 2, 2, 3, 1]))?",
                Arrays.asList("[1, 2, 3] (order guaranteed)", "Set of unique elements converted to list (order not guaranteed)", "[1, 2, 2, 3, 1]", "TypeError"),
                "Set of unique elements converted to list (order not guaranteed)",
                "set removes duplicates; converting back to list gives list of unique items."));
        list.add(new Question("PYTHON_H_41", cat, "Hard",
                "What is the output of print(3 not in [1, 2, 3])?",
                Arrays.asList("True", "False", "TypeError", "3"),
                "False",
                "3 is present in list, so '3 not in [1, 2, 3]' evaluates to False."));
        list.add(new Question("PYTHON_H_42", cat, "Hard",
                "What is the result of list(reversed([1, 2, 3]))?",
                Arrays.asList("[3, 2, 1]", "[1, 2, 3]", "reversed object", "TypeError"),
                "[3, 2, 1]",
                "reversed() returns reverse iterator; list() turns it into [3, 2, 1]."));
        list.add(new Question("PYTHON_H_43", cat, "Hard",
                "What is the output of print(f'{12.3456:.2f}')?",
                Arrays.asList("12.3456", "12.35", "12.34", "12.3"),
                "12.35",
                "Format specifier .2f formats float to 2 decimal places with rounding (12.35)."));
        list.add(new Question("PYTHON_H_44", cat, "Hard",
                "What does collection Counter('aba') return?",
                Arrays.asList("{'a': 2, 'b': 1}", "3", "['a', 'b', 'a']", "{'a': 1, 'b': 1}"),
                "{'a': 2, 'b': 1}",
                "collections.Counter creates frequency mapping dictionary: {'a': 2, 'b': 1}."));
        list.add(new Question("PYTHON_H_45", cat, "Hard",
                "What is the result of list(zip(*[(1, 2), (3, 4)]))?",
                Arrays.asList("[(1, 3), (2, 4)]", "[(1, 2), (3, 4)]", "[(1, 4), (2, 3)]", "[(1, 2, 3, 4)]"),
                "[(1, 3), (2, 4)]",
                "Unpacking list into zip(*...) transposes nested sequence matrix."));
        list.add(new Question("PYTHON_H_46", cat, "Hard",
                "What is the output of print(sum([1, 2, 3], -6))?",
                Arrays.asList("0", "6", "-6", "12"),
                "0",
                "sum(iterable, start) adds the elements (1+2+3=6) to start (-6), returning 0."));
        list.add(new Question("PYTHON_H_47", cat, "Hard",
                "What is the result of isinstance(type, object) and isinstance(object, type)?",
                Arrays.asList("True, True", "True, False", "False, True", "False, False"),
                "True, True",
                "In CPython's object model, both type and object are instances of each other."));
        list.add(new Question("PYTHON_H_48", cat, "Hard",
                "What is the output of print(dict(a=1) | dict(b=2)) in Python 3.9+?",
                Arrays.asList("{'a': 1, 'b': 2}", "TypeError", "{'a': 1}, {'b': 2}", "SyntaxError"),
                "{'a': 1, 'b': 2}",
                "The union operator | merges two dictionaries in Python 3.9+."));
        list.add(new Question("PYTHON_H_49", cat, "Hard",
                "What happens when you evaluate x = (yield 1) inside a generator?",
                Arrays.asList("Suspends generator yielding 1, and x receives value sent via send()", "Assigns 1 to x", "SyntaxError", "Terminates generator"),
                "Suspends generator yielding 1, and x receives value sent via send()",
                "Yield expressions evaluate to the value passed into the generator via send()."));
        list.add(new Question("PYTHON_H_50", cat, "Hard",
                "What is the output of print(bool(type(None)))?",
                Arrays.asList("True", "False", "None", "TypeError"),
                "True",
                "type(None) is <class 'NoneType'>, which is a class object, and all class objects evaluate to True."));
    }
}
