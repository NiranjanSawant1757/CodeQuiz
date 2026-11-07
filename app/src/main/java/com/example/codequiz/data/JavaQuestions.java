package com.example.codequiz.data;

import com.example.codequiz.model.Question;
import com.example.codequiz.util.AppConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaQuestions {

    public static List<Question> get() {
        List<Question> list = new ArrayList<>();
        String cat = AppConstants.CAT_JAVA;
        loadEasy(list, cat);
        loadMedium(list, cat);
        loadHard(list, cat);
        return list;
    }

    private static void loadEasy(List<Question> list, String cat) {
        list.add(new Question("JAVA_E_01", cat, "Easy",
                "Which keyword is used to define a class in Java?",
                Arrays.asList("class", "struct", "define", "object"),
                "class",
                "The 'class' keyword is used to declare a class in Java."));
        list.add(new Question("JAVA_E_02", cat, "Easy",
                "What is the correct entry point method signature for a standard Java console application?",
                Arrays.asList("public void main(String[] args)", "public static void main(String[] args)", "public static int main(String[] args)", "static void main(String[] args)"),
                "public static void main(String[] args)",
                "The standard entry point is 'public static void main(String[] args)'."));
        list.add(new Question("JAVA_E_03", cat, "Easy",
                "Which of the following is NOT a primitive data type in Java?",
                Arrays.asList("int", "boolean", "String", "double"),
                "String",
                "String is an object/class type, not a primitive type in Java."));
        list.add(new Question("JAVA_E_04", cat, "Easy",
                "What is the size of an int variable in Java?",
                Arrays.asList("16 bits", "32 bits", "64 bits", "Varies by operating system"),
                "32 bits",
                "In Java, an int is always 32 bits signed integer regardless of the underlying OS."));
        list.add(new Question("JAVA_E_05", cat, "Easy",
                "What is the default value of a boolean instance variable in Java?",
                Arrays.asList("true", "false", "0", "null"),
                "false",
                "The default value for boolean instance variables is false."));
        list.add(new Question("JAVA_E_06", cat, "Easy",
                "What is the correct way to declare a constant variable in Java?",
                Arrays.asList("const int MAX = 100;", "final int MAX = 100;", "static int MAX = 100;", "immutable int MAX = 100;"),
                "final int MAX = 100;",
                "The 'final' keyword is used in Java to make a variable unmodifiable."));
        list.add(new Question("JAVA_E_07", cat, "Easy",
                "What is the result of 10 % 3 in Java?",
                Arrays.asList("3", "1", "3.33", "0"),
                "1",
                "The '%' operator computes the remainder of integer division, so 10 % 3 = 1."));
        list.add(new Question("JAVA_E_08", cat, "Easy",
                "What is the value of result after executing: int a = 5; int result = a++ + ++a;",
                Arrays.asList("10", "11", "12", "13"),
                "12",
                "a++ evaluates to 5 (a becomes 6), ++a increments a to 7 and evaluates to 7. 5 + 7 = 12."));
        list.add(new Question("JAVA_E_09", cat, "Easy",
                "Which operator is used for string concatenation in Java?",
                Arrays.asList("&", "+", ".", "concat"),
                "+",
                "The '+' operator is overloaded for string concatenation in Java."));
        list.add(new Question("JAVA_E_10", cat, "Easy",
                "Which conditional statement executes code based on multiple possible values of a single primitive variable?",
                Arrays.asList("switch", "if-else", "while", "for"),
                "switch",
                "The 'switch' statement allows multi-way branching based on discrete values."));
        list.add(new Question("JAVA_E_11", cat, "Easy",
                "What is the output of:\nboolean x = true;\nif (x = false) {\n    System.out.println(\"A\");\n} else {\n    System.out.println(\"B\");\n}",
                Arrays.asList("A", "B", "Compilation error", "Runtime error"),
                "B",
                "'x = false' assigns false to x and evaluates to false, so the else branch prints 'B'."));
        list.add(new Question("JAVA_E_12", cat, "Easy",
                "Which loop is guaranteed to execute its body at least once?",
                Arrays.asList("for loop", "while loop", "do-while loop", "for-each loop"),
                "do-while loop",
                "The do-while loop evaluates its condition after executing the loop body."));
        list.add(new Question("JAVA_E_13", cat, "Easy",
                "What is the output of the following code?\nfor (int i = 0; i < 3; i++) {\n    System.out.print(i + \" \");\n}",
                Arrays.asList("0 1 2 ", "1 2 3 ", "0 1 2 3 ", "0 1 "),
                "0 1 2 ",
                "The loop runs for i = 0, 1, 2. When i reaches 3, i < 3 becomes false."));
        list.add(new Question("JAVA_E_14", cat, "Easy",
                "Which keyword is used to immediately exit a loop in Java?",
                Arrays.asList("continue", "break", "return", "exit"),
                "break",
                "The 'break' statement terminates the execution of the nearest enclosing loop."));
        list.add(new Question("JAVA_E_15", cat, "Easy",
                "Which keyword skips the rest of the current loop iteration and proceeds to the next iteration?",
                Arrays.asList("skip", "break", "continue", "next"),
                "continue",
                "The 'continue' statement skips the remaining statements in the current iteration."));
        list.add(new Question("JAVA_E_16", cat, "Easy",
                "How do you obtain the number of elements in an array named 'arr'?",
                Arrays.asList("arr.length()", "arr.length", "arr.size()", "arr.size"),
                "arr.length",
                "In Java, array length is accessed via the 'length' field, not a method call."));
        list.add(new Question("JAVA_E_17", cat, "Easy",
                "What is the valid syntax to initialize an array of integers with 3 elements?",
                Arrays.asList("int[] arr = {1, 2, 3};", "int arr = new int(3);", "Array arr = [1, 2, 3];", "int arr[] = (1, 2, 3);"),
                "int[] arr = {1, 2, 3};",
                "'int[] arr = {1, 2, 3};' is a valid array literal initialization."));
        list.add(new Question("JAVA_E_18", cat, "Easy",
                "What happens if you access an array index out of bounds, such as arr[5] on an array of length 5?",
                Arrays.asList("Returns null", "Returns 0", "Throws ArrayIndexOutOfBoundsException", "Compilation error"),
                "Throws ArrayIndexOutOfBoundsException",
                "Accessing index 5 on array of size 5 throws an ArrayIndexOutOfBoundsException at runtime."));
        list.add(new Question("JAVA_E_19", cat, "Easy",
                "Strings in Java are immutable. What does this mean?",
                Arrays.asList("String objects cannot be inherited.", "String objects cannot be changed once created.", "String references cannot be reassigned.", "String objects cannot be printed."),
                "String objects cannot be changed once created.",
                "Immutability means once a String object is instantiated, its contents cannot be altered."));
        list.add(new Question("JAVA_E_20", cat, "Easy",
                "What is the result of string equality check: \"hello\".equals(\"HELLO\")?",
                Arrays.asList("true", "false", "Compilation error", "NullPointerException"),
                "false",
                "equals() is case-sensitive, so \"hello\" does not equal \"HELLO\"."));
        list.add(new Question("JAVA_E_21", cat, "Easy",
                "Which String method returns the character at a specific index?",
                Arrays.asList("getChar(int index)", "charAt(int index)", "indexOf(int index)", "substring(int index)"),
                "charAt(int index)",
                "charAt(int index) returns the char value at the specified index."));
        list.add(new Question("JAVA_E_22", cat, "Easy",
                "What is the output of \"Java\".length()?",
                Arrays.asList("3", "4", "5", "0"),
                "4",
                "The length() method of String returns the count of characters, which is 4 for \"Java\"."));
        list.add(new Question("JAVA_E_23", cat, "Easy",
                "What keyword is used when a method does not return any value?",
                Arrays.asList("null", "empty", "void", "static"),
                "void",
                "The 'void' return type specifies that a method returns no value."));
        list.add(new Question("JAVA_E_24", cat, "Easy",
                "What is method overloading in Java?",
                Arrays.asList("Methods in child class having same signature as parent class", "Multiple methods in the same class with the same name but different parameters", "A method calling itself recursively", "A method declared as private"),
                "Multiple methods in the same class with the same name but different parameters",
                "Overloading occurs when multiple methods in a class share the same name but have different parameter lists."));
        list.add(new Question("JAVA_E_25", cat, "Easy",
                "Which keyword is used to create an instance of a class?",
                Arrays.asList("create", "new", "alloc", "instance"),
                "new",
                "The 'new' operator allocates memory for a new object."));
        list.add(new Question("JAVA_E_26", cat, "Easy",
                "What is the purpose of a constructor in Java?",
                Arrays.asList("To destroy objects", "To initialize new objects", "To inherit from a class", "To handle runtime exceptions"),
                "To initialize new objects",
                "Constructors are special methods called when an object is instantiated to initialize its state."));
        list.add(new Question("JAVA_E_27", cat, "Easy",
                "Does a class constructor in Java have a return type?",
                Arrays.asList("Yes, void", "Yes, int", "No, not even void", "Yes, Object"),
                "No, not even void",
                "Constructors do not specify any return type, not even void."));
        list.add(new Question("JAVA_E_28", cat, "Easy",
                "If no constructor is defined in a Java class, what happens?",
                Arrays.asList("Compilation fails", "Java provides a default no-argument constructor", "Runtime error occurs", "The class becomes abstract"),
                "Java provides a default no-argument constructor",
                "The compiler automatically provides a default no-arg constructor if no constructors are explicitly declared."));
        list.add(new Question("JAVA_E_29", cat, "Easy",
                "Which block is used to catch and handle exceptions in Java?",
                Arrays.asList("try-catch", "try-finally", "throw-catch", "catch-finally"),
                "try-catch",
                "The 'try-catch' structure is used to enclose exception-prone code and handle caught exceptions."));
        list.add(new Question("JAVA_E_30", cat, "Easy",
                "Which block always executes regardless of whether an exception is thrown or caught?",
                Arrays.asList("catch", "finally", "try", "throws"),
                "finally",
                "The 'finally' block is executed after try/catch blocks, whether an exception occurred or not."));
        list.add(new Question("JAVA_E_31", cat, "Easy",
                "Which extension is used for compiled Java bytecode files?",
                Arrays.asList(".java", ".class", ".jar", ".exe"),
                ".class",
                "Java source code file compiles into '.class' bytecode files."));
        list.add(new Question("JAVA_E_32", cat, "Easy",
                "Which single-line comment syntax is valid in Java?",
                Arrays.asList("# comment", "// comment", "<!-- comment -->", "% comment"),
                "// comment",
                "'//' is used for single-line comments in Java."));
        list.add(new Question("JAVA_E_33", cat, "Easy",
                "Which primitive data type is used to store fractional numbers up to 15-17 decimal digits precision?",
                Arrays.asList("float", "double", "long", "int"),
                "double",
                "double is a 64-bit IEEE 754 double precision floating-point number."));
        list.add(new Question("JAVA_E_34", cat, "Easy",
                "What is the output of System.out.println(5 / 2);?",
                Arrays.asList("2.5", "2", "2.0", "3"),
                "2",
                "Integer division in Java truncates the fractional part, yielding 2."));
        list.add(new Question("JAVA_E_35", cat, "Easy",
                "Which operator is used to check for logical AND without evaluating the second condition if the first is false?",
                Arrays.asList("&", "&&", "|", "||"),
                "&&",
                "'&&' is the short-circuit logical AND operator."));
        list.add(new Question("JAVA_E_36", cat, "Easy",
                "What is the output of: System.out.println(10 > 5 ? \"Yes\" : \"No\");?",
                Arrays.asList("Yes", "No", "true", "false"),
                "Yes",
                "The ternary operator evaluates 10 > 5 (true), returning \"Yes\"."));
        list.add(new Question("JAVA_E_37", cat, "Easy",
                "How many times will the following loop run?\nint i = 5;\nwhile (i > 0) {\n    i--;\n}",
                Arrays.asList("4 times", "5 times", "6 times", "Infinite times"),
                "5 times",
                "i starts at 5 and decrements until i reaches 0 (values: 5, 4, 3, 2, 1), running 5 times."));
        list.add(new Question("JAVA_E_38", cat, "Easy",
                "What is the index of the first element in a Java array?",
                Arrays.asList("1", "0", "-1", "Depends on the array type"),
                "0",
                "Java arrays are zero-indexed, starting at 0."));
        list.add(new Question("JAVA_E_39", cat, "Easy",
                "What does the trim() method do on a String?",
                Arrays.asList("Removes spaces between words", "Removes leading and trailing white spaces", "Converts string to lowercase", "Truncates string to 10 characters"),
                "Removes leading and trailing white spaces",
                "trim() removes leading and trailing white space characters."));
        list.add(new Question("JAVA_E_40", cat, "Easy",
                "Which keyword is used by an object to refer to itself?",
                Arrays.asList("super", "this", "self", "me"),
                "this",
                "The 'this' keyword refers to the current object instance."));
        list.add(new Question("JAVA_E_41", cat, "Easy",
                "Which keyword is used to explicitly throw an exception object in Java?",
                Arrays.asList("throws", "throw", "raise", "catch"),
                "throw",
                "'throw' is used to explicitly throw an exception object."));
        list.add(new Question("JAVA_E_42", cat, "Easy",
                "Which keyword is used in a method signature to declare exceptions that might be thrown?",
                Arrays.asList("throw", "throws", "catch", "try"),
                "throws",
                "'throws' is declared in method signatures for checked exceptions."));
        list.add(new Question("JAVA_E_43", cat, "Easy",
                "Can a method in Java return multiple values directly without wrapping them in an object or array?",
                Arrays.asList("Yes, using commas", "No", "Yes, using tuples", "Yes, using pointers"),
                "No",
                "Java methods can return only a single value or object/array reference."));
        list.add(new Question("JAVA_E_44", cat, "Easy",
                "What is the wrapper class for the primitive type 'int'?",
                Arrays.asList("Int", "Integer", "Number", "Long"),
                "Integer",
                "java.lang.Integer is the wrapper class for the primitive type int."));
        list.add(new Question("JAVA_E_45", cat, "Easy",
                "Which access modifier makes a class member visible only within its own class?",
                Arrays.asList("public", "protected", "private", "default"),
                "private",
                "'private' restricts visibility strictly to within the enclosing class."));
        list.add(new Question("JAVA_E_46", cat, "Easy",
                "Which access modifier makes a class member accessible within the same package and subclasses?",
                Arrays.asList("private", "protected", "public", "package-private"),
                "protected",
                "'protected' allows access within the same package and by child classes."));
        list.add(new Question("JAVA_E_47", cat, "Easy",
                "What is the result of expression: true || false && false?",
                Arrays.asList("false", "true", "Compilation error", "Undefined"),
                "true",
                "&& has higher precedence than ||. false && false is false. true || false is true."));
        list.add(new Question("JAVA_E_48", cat, "Easy",
                "What is the result of \"Java\".toUpperCase()?",
                Arrays.asList("java", "JAVA", "Java", "J"),
                "JAVA",
                "toUpperCase() converts all characters in the string to uppercase."));
        list.add(new Question("JAVA_E_49", cat, "Easy",
                "How do you declare a 2D array of integers in Java?",
                Arrays.asList("int[][] arr;", "int arr[2][2];", "Array2D arr;", "int[] arr[];"),
                "int[][] arr;",
                "'int[][] arr;' is the standard syntax to declare a 2D array."));
        list.add(new Question("JAVA_E_50", cat, "Easy",
                "Which package is automatically imported in every Java program?",
                Arrays.asList("java.util", "java.io", "java.lang", "java.net"),
                "java.lang",
                "java.lang package is automatically imported by default in Java."));
    }

    private static void loadMedium(List<Question> list, String cat) {
        list.add(new Question("JAVA_M_01", cat, "Medium",
                "Which OOP principle allows a subclass to provide a specific implementation of a method already defined in its parent class?",
                Arrays.asList("Abstraction", "Encapsulation", "Method Overriding", "Composition"),
                "Method Overriding",
                "Method overriding allows a subclass to provide a specific implementation of a method declared in its superclass."));
        list.add(new Question("JAVA_M_02", cat, "Medium",
                "Which keyword is used by a class to inherit from another class in Java?",
                Arrays.asList("implements", "extends", "inherits", "super"),
                "extends",
                "The 'extends' keyword establishes an inheritance relationship between classes."));
        list.add(new Question("JAVA_M_03", cat, "Medium",
                "Which keyword is used by a class to use an interface in Java?",
                Arrays.asList("extends", "implements", "uses", "interface"),
                "implements",
                "The 'implements' keyword is used by classes to implement interface contracts."));
        list.add(new Question("JAVA_M_04", cat, "Medium",
                "Starting in Java 8, can interfaces contain default methods with concrete implementations?",
                Arrays.asList("No, interface methods must all be abstract", "Yes, using the 'default' keyword", "Yes, using the 'static' keyword only", "Only private methods were allowed in Java 8"),
                "Yes, using the 'default' keyword",
                "Java 8 introduced default methods in interfaces to allow adding new capabilities without breaking backward compatibility."));
        list.add(new Question("JAVA_M_05", cat, "Medium",
                "Which of the following is true about abstract classes in Java?",
                Arrays.asList("An abstract class can be directly instantiated with 'new'", "An abstract class cannot contain constructors", "An abstract class cannot be instantiated directly", "All methods in an abstract class must be abstract"),
                "An abstract class cannot be instantiated directly",
                "Abstract classes cannot be instantiated directly with 'new'; they must be extended by concrete subclasses."));
        list.add(new Question("JAVA_M_06", cat, "Medium",
                "What type of polymorphism is achieved through Method Overloading?",
                Arrays.asList("Compile-time polymorphism", "Run-time polymorphism", "Dynamic polymorphism", "Late binding polymorphism"),
                "Compile-time polymorphism",
                "Method overloading is resolved by the compiler based on method signatures (compile-time/static polymorphism)."));
        list.add(new Question("JAVA_M_07", cat, "Medium",
                "What type of polymorphism is achieved through Method Overriding?",
                Arrays.asList("Compile-time polymorphism", "Run-time polymorphism", "Static polymorphism", "Parametric polymorphism"),
                "Run-time polymorphism",
                "Method overriding is resolved at runtime based on the actual object type (run-time/dynamic polymorphism)."));
        list.add(new Question("JAVA_M_08", cat, "Medium",
                "Which Collection interface allows fast lookup by key and does not allow duplicate keys?",
                Arrays.asList("List", "Set", "Map", "Queue"),
                "Map",
                "Map stores key-value pairs where keys are unique."));
        list.add(new Question("JAVA_M_09", cat, "Medium",
                "What is the primary advantage of ArrayList over a standard Java array?",
                Arrays.asList("ArrayList holds primitive types directly", "ArrayList automatically resizes dynamically as elements are added", "ArrayList is synchronized by default", "ArrayList elements are fixed in size"),
                "ArrayList automatically resizes dynamically as elements are added",
                "ArrayList grows dynamically when elements are added beyond its current capacity."));
        list.add(new Question("JAVA_M_10", cat, "Medium",
                "How does HashMap handle key collisions in Java 8 and later when a bucket capacity exceeds a threshold?",
                Arrays.asList("Throws HashCollisionException", "Converts the bucket from a linked list to a balanced tree (Red-Black tree)", "Replaces old value with new value automatically", "Expands array size immediately"),
                "Converts the bucket from a linked list to a balanced tree (Red-Black tree)",
                "When a bucket linked list exceeds 8 elements (and total table capacity >= 64), Java 8 converts it to a balanced red-black tree."));
        list.add(new Question("JAVA_M_11", cat, "Medium",
                "What is Type Erasure in Java Generics?",
                Arrays.asList("Removing generic type information at compile time so bytecode maintains backward compatibility", "Erasing unused objects from heap memory", "Casting primitive types to wrapper classes", "Converting interfaces into abstract classes"),
                "Removing generic type information at compile time so bytecode maintains backward compatibility",
                "Type erasure removes generic type parameters during compilation, inserting necessary casts for type safety."));
        list.add(new Question("JAVA_M_12", cat, "Medium",
                "Which wildcard syntax allows accepting a List of Integer or any of its superclasses?",
                Arrays.asList("List<? extends Integer>", "List<? super Integer>", "List<T extends Integer>", "List<?>"),
                "List<? super Integer>",
                "<? super Integer> specifies a lower-bounded wildcard accepting Integer or its superclasses."));
        list.add(new Question("JAVA_M_13", cat, "Medium",
                "What happens if a recursive function does not have a proper base condition?",
                Arrays.asList("NullPointerException", "StackOverflowError", "OutOfMemoryError", "ArithmeticException"),
                "StackOverflowError",
                "Infinite recursion exhausts call stack space, leading to StackOverflowError."));
        list.add(new Question("JAVA_M_14", cat, "Medium",
                "Which class in java.nio.file package provides utility methods to read all lines from a text file conveniently?",
                Arrays.asList("FileReader", "FileInputStream", "Files", "BufferedReader"),
                "Files",
                "java.nio.file.Files provides static methods like Files.readAllLines()."));
        list.add(new Question("JAVA_M_15", cat, "Medium",
                "Which of the following is a checked exception in Java?",
                Arrays.asList("NullPointerException", "ArrayIndexOutOfBoundsException", "IOException", "IllegalArgumentException"),
                "IOException",
                "IOException is a checked exception derived from Exception, requiring explicit try-catch or throws."));
        list.add(new Question("JAVA_M_16", cat, "Medium",
                "What class is the root of the exception hierarchy in Java?",
                Arrays.asList("java.lang.Exception", "java.lang.Throwable", "java.lang.Error", "java.lang.Object"),
                "java.lang.Throwable",
                "java.lang.Throwable is the superclass of all errors and exceptions in Java."));
        list.add(new Question("JAVA_M_17", cat, "Medium",
                "Which statement accurately describes a Functional Interface in Java?",
                Arrays.asList("An interface with no methods", "An interface with exactly one abstract method", "An interface containing only static methods", "An interface with multiple abstract methods"),
                "An interface with exactly one abstract method",
                "A functional interface contains exactly one abstract method (annotated optionally with @FunctionalInterface)."));
        list.add(new Question("JAVA_M_18", cat, "Medium",
                "Which standard functional interface takes one argument and returns a boolean?",
                Arrays.asList("Function<T, R>", "Supplier<T>", "Consumer<T>", "Predicate<T>"),
                "Predicate<T>",
                "Predicate<T> defines boolean test(T t)."));
        list.add(new Question("JAVA_M_19", cat, "Medium",
                "Which functional interface takes no parameters and produces/returns a result?",
                Arrays.asList("Consumer<T>", "Supplier<T>", "Predicate<T>", "Function<T,R>"),
                "Supplier<T>",
                "Supplier<T> defines T get() which accepts no arguments and produces a result."));
        list.add(new Question("JAVA_M_20", cat, "Medium",
                "Which Stream operation is terminal and reduces elements to a single value or performs a side-effect?",
                Arrays.asList("filter", "map", "forEach", "sorted"),
                "forEach",
                "forEach is a terminal operation that triggers stream processing; filter, map, and sorted are intermediate."));
        list.add(new Question("JAVA_M_21", cat, "Medium",
                "What is the result of the following stream code?\nList<Integer> nums = List.of(1, 2, 3, 4);\nlong count = nums.stream().filter(n -> n % 2 == 0).count();",
                Arrays.asList("1", "2", "3", "4"),
                "2",
                "The filter keeps even numbers (2, 4), so count() returns 2."));
        list.add(new Question("JAVA_M_22", cat, "Medium",
                "What does the Stream map() method do?",
                Arrays.asList("Filters elements based on a condition", "Transforms each element into another element using a function", "Sorts the elements of a stream", "Groups elements into a Map object"),
                "Transforms each element into another element using a function",
                "map() applies a mapping function to transform elements in the stream."));
        list.add(new Question("JAVA_M_23", cat, "Medium",
                "Encapsulation is best demonstrated by which of the following practices?",
                Arrays.asList("Making fields public for direct access", "Making instance variables private and providing public getter and setter methods", "Using multiple inheritance with interfaces", "Overriding the toString() method"),
                "Making instance variables private and providing public getter and setter methods",
                "Hiding internal data behind private access modifiers and exposing safe access via public methods embodies encapsulation."));
        list.add(new Question("JAVA_M_24", cat, "Medium",
                "Can a class in Java extend multiple concrete classes directly (Multiple Inheritance)?",
                Arrays.asList("Yes", "No", "Yes, using super keyword", "Yes, if both parent classes are abstract"),
                "No",
                "Java does not support multiple class inheritance to avoid ambiguity (the diamond problem)."));
        list.add(new Question("JAVA_M_25", cat, "Medium",
                "What is the super keyword used for in a constructor of a child class?",
                Arrays.asList("To call the superclass constructor", "To create a super-sized object", "To reference the child class instance", "To declare a method static"),
                "To call the superclass constructor",
                "super(...) invokes the constructor of the direct parent class."));
        list.add(new Question("JAVA_M_26", cat, "Medium",
                "Which Set implementation in Java maintains elements in insertion order?",
                Arrays.asList("HashSet", "TreeSet", "LinkedHashSet", "ConcurrentSkipListSet"),
                "LinkedHashSet",
                "LinkedHashSet maintains a doubly-linked list running through its entries to preserve insertion order."));
        list.add(new Question("JAVA_M_27", cat, "Medium",
                "Which Set implementation automatically sorts its elements in natural ascending order?",
                Arrays.asList("HashSet", "LinkedHashSet", "TreeSet", "CopyOnWriteArraySet"),
                "TreeSet",
                "TreeSet is backed by a Red-Black tree and stores elements in natural sorted order or via a custom Comparator."));
        list.add(new Question("JAVA_M_28", cat, "Medium",
                "What is a custom unchecked exception in Java?",
                Arrays.asList("A class extending java.lang.Throwable directly", "A class extending java.lang.Exception", "A class extending java.lang.RuntimeException", "A class implementing ExceptionListener"),
                "A class extending java.lang.RuntimeException",
                "Unchecked exceptions extend RuntimeException (or Throwable/Error, but custom exceptions extend RuntimeException)."));
        list.add(new Question("JAVA_M_29", cat, "Medium",
                "What is the correct syntax for a lambda expression taking two integers 'a' and 'b' and returning their sum?",
                Arrays.asList("(a, b) -> a + b", "lambda(a, b) { return a + b; }", "(int a, b) => a + b", "a, b -> { a + b }"),
                "(a, b) -> a + b",
                "(a, b) -> a + b is valid Java lambda syntax."));
        list.add(new Question("JAVA_M_30", cat, "Medium",
                "Which method is used to convert a Stream back into a List in Java 16 or later?",
                Arrays.asList("stream.asList()", "stream.toList()", "stream.collectList()", "stream.toArrayList()"),
                "stream.toList()",
                "Java 16 introduced Stream.toList() as an unmodifiable convenience method."));
        list.add(new Question("JAVA_M_31", cat, "Medium",
                "Can an abstract class have concrete (implemented) methods in Java?",
                Arrays.asList("No, all methods in an abstract class must be abstract", "Yes, an abstract class can contain both abstract and concrete methods", "Only if the class is declared static", "Only if methods are marked final"),
                "Yes, an abstract class can contain both abstract and concrete methods",
                "Abstract classes can feature both fully implemented methods and abstract methods."));
        list.add(new Question("JAVA_M_32", cat, "Medium",
                "Can an interface have instance fields (non-static, non-final fields)?",
                Arrays.asList("Yes", "No, fields in interfaces are implicitly public static final", "Yes, if declared private", "Yes, in Java 11+"),
                "No, fields in interfaces are implicitly public static final",
                "All fields declared in interfaces are implicitly public, static, and final."));
        list.add(new Question("JAVA_M_33", cat, "Medium",
                "What is the primary benefit of using Generics in Java collections?",
                Arrays.asList("Faster execution speed at runtime", "Compile-time type checking and elimination of explicit type casting", "Automatic synchronization of collections", "Reduced heap memory footprint"),
                "Compile-time type checking and elimination of explicit type casting",
                "Generics enforce type safety at compile time, eliminating manual casting and preventing ClassCastException."));
        list.add(new Question("JAVA_M_34", cat, "Medium",
                "Which Java class is best suited for writing low-level binary data to a file?",
                Arrays.asList("FileWriter", "FileOutputStream", "PrintWriter", "BufferedWriter"),
                "FileOutputStream",
                "FileOutputStream writes raw bytes/binary data to files."));
        list.add(new Question("JAVA_M_35", cat, "Medium",
                "Which class is designed for reading characters and text efficiently with buffering?",
                Arrays.asList("FileInputStream", "BufferedReader", "DataInputStream", "ObjectInputStream"),
                "BufferedReader",
                "BufferedReader reads text efficiently from a character-input stream by buffering characters."));
        list.add(new Question("JAVA_M_36", cat, "Medium",
                "What happens if a catch block catches a broad Exception before a specific SubException block?",
                Arrays.asList("SubException block executes first", "Compilation error occurs due to unreachable code", "Both blocks execute sequentially", "Runtime error occurs"),
                "Compilation error occurs due to unreachable code",
                "The Java compiler reports an error because the lower catch block for SubException would be unreachable."));
        list.add(new Question("JAVA_M_37", cat, "Medium",
                "What happens when a subclass object calls an overridden method using a superclass reference? (e.g., Animal a = new Dog(); a.makeSound();)",
                Arrays.asList("Animal's version is called", "Dog's version is called", "Compilation error", "Runtime exception"),
                "Dog's version is called",
                "Dynamic method dispatch invokes the implementation corresponding to the actual object type (Dog) at runtime."));
        list.add(new Question("JAVA_M_38", cat, "Medium",
                "Which interface does Map extend in the Java Collections Framework?",
                Arrays.asList("Collection", "Iterable", "Map does not extend Collection interface", "List"),
                "Map does not extend Collection interface",
                "Map is part of the Java Collections Framework, but it does NOT extend Collection or Iterable."));
        list.add(new Question("JAVA_M_39", cat, "Medium",
                "What is the underlying data structure of dynamic sizing for ArrayList?",
                Arrays.asList("Singly Linked List", "Resizable Array", "Binary Search Tree", "Hash Table"),
                "Resizable Array",
                "ArrayList uses a contiguous internal array that expands when capacity is reached."));
        list.add(new Question("JAVA_M_40", cat, "Medium",
                "In recursion, what is the 'base case'?",
                Arrays.asList("The line where function calls itself", "The terminating condition that stops further recursive calls", "The initial value passed to the root call", "The memory stack frame allocated"),
                "The terminating condition that stops further recursive calls",
                "The base case prevents infinite recursion by providing a stopping condition."));
        list.add(new Question("JAVA_M_41", cat, "Medium",
                "Which concept refers to binding data members and methods into a single unit?",
                Arrays.asList("Abstraction", "Encapsulation", "Polymorphism", "Inheritance"),
                "Encapsulation",
                "Encapsulation bundles data and methods together and protects internal state."));
        list.add(new Question("JAVA_M_42", cat, "Medium",
                "What is the difference between intermediate and terminal operations in Java Streams?",
                Arrays.asList("Intermediate operations trigger stream processing; terminal operations return streams", "Intermediate operations return a new Stream and are lazy; terminal operations produce a result or side-effect", "Terminal operations can be chained together", "There is no functional difference"),
                "Intermediate operations return a new Stream and are lazy; terminal operations produce a result or side-effect",
                "Intermediate operations return streams lazily; terminal operations execute the pipeline."));
        list.add(new Question("JAVA_M_43", cat, "Medium",
                "Which functional interface accepts two arguments and returns no result?",
                Arrays.asList("BiFunction<T, U, R>", "BiConsumer<T, U>", "BiPredicate<T, U>", "BinaryOperator<T>"),
                "BiConsumer<T, U>",
                "BiConsumer<T, U> accepts two input arguments and performs an operation without returning a result."));
        list.add(new Question("JAVA_M_44", cat, "Medium",
                "What is a Method Reference in Java?",
                Arrays.asList("A pointer to C++ native code", "A compact lambda expression for invoking an existing method by name (e.g., System.out::println)", "A reflective reflection object", "An abstract method in an interface"),
                "A compact lambda expression for invoking an existing method by name (e.g., System.out::println)",
                "Method references provide readable, concise syntax using :: to refer directly to existing methods."));
        list.add(new Question("JAVA_M_45", cat, "Medium",
                "What is the key difference between Vector and ArrayList?",
                Arrays.asList("Vector is dynamic; ArrayList is fixed", "Vector methods are synchronized (thread-safe); ArrayList is not", "ArrayList allows duplicate values; Vector does not", "Vector is faster than ArrayList in single-threaded environments"),
                "Vector methods are synchronized (thread-safe); ArrayList is not",
                "Vector synchronizes its operations, making it thread-safe but slower than unsynchronized ArrayList."));
        list.add(new Question("JAVA_M_46", cat, "Medium",
                "Which principle of OOP focuses on showing only essential features and hiding internal complexity?",
                Arrays.asList("Abstraction", "Inheritance", "Polymorphism", "Cohesion"),
                "Abstraction",
                "Abstraction hides background implementation details and shows essential features."));
        list.add(new Question("JAVA_M_47", cat, "Medium",
                "Can an interface extend multiple interfaces in Java?",
                Arrays.asList("No, interfaces can only extend one interface", "Yes, using comma-separated list of interfaces", "Only if all interfaces have no default methods", "Interfaces implement other interfaces, not extend"),
                "Yes, using comma-separated list of interfaces",
                "Interfaces support multiple inheritance from other interfaces (e.g. interface C extends A, B)."));
        list.add(new Question("JAVA_M_48", cat, "Medium",
                "What is try-with-resources introduced in Java 7?",
                Arrays.asList("A try block that automatically closes resources implementing AutoCloseable", "A try block with multiple catch clauses", "A try block that rethrows exceptions automatically", "A try block for managing memory allocation"),
                "A try block that automatically closes resources implementing AutoCloseable",
                "Try-with-resources ensures that each resource implementing AutoCloseable is closed at the end of the statement."));
        list.add(new Question("JAVA_M_49", cat, "Medium",
                "What does the symbol <?> represent in Java Generics?",
                Arrays.asList("Unbounded wildcard", "Object type only", "Primitive parameter", "Syntax error"),
                "Unbounded wildcard",
                "<?> represents an unbounded wildcard, standing for any unknown type."));
        list.add(new Question("JAVA_M_50", cat, "Medium",
                "Which class provides static utility methods to sort, search, and reverse Collections?",
                Arrays.asList("Collection", "Collections", "Arrays", "ListUtils"),
                "Collections",
                "java.util.Collections contains static helper methods operating on Collections."));
    }

    private static void loadHard(List<Question> list, String cat) {
        list.add(new Question("JAVA_H_01", cat, "Hard",
                "What is the exact order of initialization when a Java class with a superclass is instantiated?",
                Arrays.asList("Child static blocks -> Parent static blocks -> Parent instance blocks/constructors -> Child instance blocks/constructors", "Parent static blocks -> Child static blocks -> Parent instance blocks/constructors -> Child instance blocks/constructors", "Parent instance blocks -> Child instance blocks -> Parent static blocks -> Child static blocks", "Parent constructor -> Child constructor -> Parent static blocks -> Child static blocks"),
                "Parent static blocks -> Child static blocks -> Parent instance blocks/constructors -> Child instance blocks/constructors",
                "Static initializers run top-down from parent to child class loading; then parent instance blocks/constructor run before child instance blocks/constructor."));
        list.add(new Question("JAVA_H_02", cat, "Hard",
                "What is the output of the following code?\nclass Parent {\n    void show(Object o) { System.out.println(\"Object\"); }\n}\nclass Child extends Parent {\n    void show(String s) { System.out.println(\"String\"); }\n}\n// In main:\nParent p = new Child();\np.show(\"hello\");",
                Arrays.asList("String", "Object", "Compilation Error", "Runtime Exception"),
                "Object",
                "Method overloading resolution happens at compile time based on reference type (Parent), which only sees show(Object). Subclass method show(String) overloads, not overrides, so p.show(\"hello\") calls show(Object)."));
        list.add(new Question("JAVA_H_03", cat, "Hard",
                "Given the generic method declaration:\npublic <T extends Number> void process(T arg) {}\nWhat is the upper bound type of T after type erasure in the generated bytecode?",
                Arrays.asList("Object", "Number", "Integer", "T is preserved in bytecode"),
                "Number",
                "In bounded generic parameters (<T extends Number>), type erasure replaces T with its first bound (Number) in the compiled bytecode."));
        list.add(new Question("JAVA_H_04", cat, "Hard",
                "If two objects are equal according to the equals(Object) method, what MUST be true regarding their hashCode() values?",
                Arrays.asList("Their hash codes must be different.", "Their hash codes must be equal.", "Their hash codes may or may not be equal.", "Their hash codes must both be zero."),
                "Their hash codes must be equal.",
                "The equals/hashCode contract states that if two objects are equal, calling hashCode() on each must produce the same integer result."));
        list.add(new Question("JAVA_H_05", cat, "Hard",
                "What happens if an object's hashCode() changes while it is stored as a key in a HashMap?",
                Arrays.asList("The HashMap automatically updates its bucket index.", "The key becomes unretrievable via map.get() because it hashes to a different bucket.", "HashMap throws ConcurrentModificationException.", "The entry is moved to the rehash list."),
                "The key becomes unretrievable via map.get() because it hashes to a different bucket.",
                "HashMap computes bucket index from hashCode(). Mutating a key's field that affects hashCode makes map.get() search the wrong bucket, rendering it unretrievable."));
        list.add(new Question("JAVA_H_06", cat, "Hard",
                "What is the effect of calling Thread.yield() in Java?",
                Arrays.asList("It causes the thread to sleep for a specified duration.", "It gives a hint to the thread scheduler that the current thread is willing to yield its current use of a processor.", "It terminates thread execution immediately.", "It releases all acquired object locks."),
                "It gives a hint to the thread scheduler that the current thread is willing to yield its current use of a processor.",
                "Thread.yield() signals the scheduler that the calling thread is willing to yield processor time, though the scheduler may ignore this hint."));
        list.add(new Question("JAVA_H_07", cat, "Hard",
                "What lock is acquired when a thread executes a static synchronized method?",
                Arrays.asList("The lock on 'this' instance", "The lock on the Class object (Class.class)", "A global JVM lock", "No lock is acquired for static methods"),
                "The lock on the Class object (Class.class)",
                "Static synchronized methods acquire the monitor lock associated with the Class object for that class."));
        list.add(new Question("JAVA_H_08", cat, "Hard",
                "Which four conditions are necessary for a deadlock to occur in a multithreaded application?",
                Arrays.asList("Mutual exclusion, Hold and wait, No preemption, Circular wait", "Atomicity, Consistency, Isolation, Durability", "Race condition, Livelock, Starvation, Priority inversion", "Volatile, Synchronized, ReentrantLock, Semaphore"),
                "Mutual exclusion, Hold and wait, No preemption, Circular wait",
                "Coffman's four conditions for deadlock are Mutual Exclusion, Hold and Wait, No Preemption, and Circular Wait."));
        list.add(new Question("JAVA_H_09", cat, "Hard",
                "What visibility guarantee does the 'volatile' keyword provide in Java?",
                Arrays.asList("It guarantees atomic execution of multi-step operations like count++", "It guarantees that reads and writes to the volatile variable go directly to main memory, establishing a happens-before relationship", "It prevents a variable from being Garbage Collected", "It locks the object instance whenever accessed"),
                "It guarantees that reads and writes to the volatile variable go directly to main memory, establishing a happens-before relationship",
                "Volatile ensures visible updates across threads by forcing reads/writes directly from/to main memory and preventing reordering."));
        list.add(new Question("JAVA_H_10", cat, "Hard",
                "Which JVM memory region is shared across all threads and stores object instances?",
                Arrays.asList("Program Counter (PC) Register", "JVM Stack", "Heap Memory", "Native Method Stack"),
                "Heap Memory",
                "Heap memory is shared by all threads and stores all Java object instances and arrays."));
        list.add(new Question("JAVA_H_11", cat, "Hard",
                "What is Metaspace in Java 8 and later?",
                Arrays.asList("The garbage collector region for young generation", "Off-heap native memory used to store class metadata, replacing PermGen", "Thread stack space allocated for local variables", "A cached pool for String literals"),
                "Off-heap native memory used to store class metadata, replacing PermGen",
                "Metaspace replaced PermGen in Java 8 to store class metadata in off-heap native memory."));
        list.add(new Question("JAVA_H_12", cat, "Hard",
                "What is the difference between map() and flatMap() in Java Streams?",
                Arrays.asList("map() is for parallel streams; flatMap() is for sequential streams", "map() produces one output element per input element; flatMap() flattens streams of streams into a single stream", "map() is terminal; flatMap() is intermediate", "flatMap() sorts elements before mapping"),
                "map() produces one output element per input element; flatMap() flattens streams of streams into a single stream",
                "flatMap() applies a 1-to-many mapping function that returns streams, then flattens those streams into a single composite stream."));
        list.add(new Question("JAVA_H_13", cat, "Hard",
                "Is a Java Stream reusable after a terminal operation has executed on it?",
                Arrays.asList("Yes, as many times as needed", "No, an IllegalStateException will be thrown if operated upon again", "Yes, but only for read-only operations", "Yes, if mark() and reset() are used"),
                "No, an IllegalStateException will be thrown if operated upon again",
                "Streams are single-use; calling any operation after a terminal operation throws IllegalStateException."));
        list.add(new Question("JAVA_H_14", cat, "Hard",
                "Which of the following describes a 'pure function' in functional programming?",
                Arrays.asList("A function that modifies global static variables", "A function whose return value depends only on its arguments and has no side effects", "A function that throws checked exceptions", "A function marked as synchronized"),
                "A function whose return value depends only on its arguments and has no side effects",
                "A pure function produces identical outputs for identical inputs without mutating state or causing side effects."));
        list.add(new Question("JAVA_H_15", cat, "Hard",
                "What is the worst-case time complexity of inserting elements into a standard HashMap?",
                Arrays.asList("O(1)", "O(log N) in Java 8+ when buckets treeify, or O(N) prior to treeification", "O(N log N)", "O(N^2)"),
                "O(log N) in Java 8+ when buckets treeify, or O(N) prior to treeification",
                "In Java 8+, hash collisions turn buckets into Red-Black trees with O(log N) worst-case, whereas linked list buckets were O(N)."));
        list.add(new Question("JAVA_H_16", cat, "Hard",
                "What is the result of adding duplicate elements to a HashSet in Java?",
                Arrays.asList("Throws DuplicateKeyException", "The add() method returns false and the collection remains unchanged", "The existing element is overwritten", "Compilation error"),
                "The add() method returns false and the collection remains unchanged",
                "HashSet.add() returns false if the element was already present, leaving the set unchanged."));
        list.add(new Question("JAVA_H_17", cat, "Hard",
                "What is the fundamental difference between Callable<V> and Runnable in Java?",
                Arrays.asList("Runnable can return a result; Callable cannot", "Callable can return a result and throw checked exceptions; Runnable returns void and cannot throw checked exceptions", "Runnable runs on a new thread; Callable runs on the main thread", "Callable was deprecated in Java 5"),
                "Callable can return a result and throw checked exceptions; Runnable returns void and cannot throw checked exceptions",
                "Callable's call() method returns V and throws Exception; Runnable's run() returns void and cannot throw checked exceptions."));
        list.add(new Question("JAVA_H_18", cat, "Hard",
                "What does CompletableFuture.thenCombine() do in Java asynchronous programming?",
                Arrays.asList("Executes two futures sequentially", "Combines results of two independent CompletableFutures when both complete using a BiFunction", "Returns whichever future completes first", "Cancels both futures if one fails"),
                "Combines results of two independent CompletableFutures when both complete using a BiFunction",
                "thenCombine executes two independent futures in parallel and applies a function when both finish."));
        list.add(new Question("JAVA_H_19", cat, "Hard",
                "What is the purpose of the Java Virtual Machine (JVM) Execution Engine JIT (Just-In-Time) compiler?",
                Arrays.asList("To check syntax errors at compile time", "To compile frequently executed bytecode (hotspots) directly into native machine code at runtime", "To compress bytecode into JAR files", "To verify bytecode safety before execution"),
                "To compile frequently executed bytecode (hotspots) directly into native machine code at runtime",
                "JIT compiles heavily executed bytecode into native machine code to boost runtime performance."));
        list.add(new Question("JAVA_H_20", cat, "Hard",
                "Why is 'new T()' invalid in Java Generics?",
                Arrays.asList("Generics are private by default", "Type erasure removes type information T at runtime, making exact type instantiation impossible without reflection", "T must implement Allocatable", "Constructors cannot be generic"),
                "Type erasure removes type information T at runtime, making exact type instantiation impossible without reflection",
                "Due to type erasure, the exact class of T is unknown at runtime, preventing direct instantiation via 'new T()'."));
        list.add(new Question("JAVA_H_21", cat, "Hard",
                "What is the output of the code below?\nclass Test {\n    static int x = 10;\n    static {\n        x += 5;\n    }\n    Test() {\n        x += 2;\n    }\n}\n// In main:\nTest t1 = new Test();\nTest t2 = new Test();\nSystem.out.println(Test.x);",
                Arrays.asList("17", "19", "15", "12"),
                "19",
                "Static block runs once (x = 10 + 5 = 15). Constructor for t1 adds 2 (x = 17). Constructor for t2 adds 2 (x = 19)."));
        list.add(new Question("JAVA_H_22", cat, "Hard",
                "If you override equals() in a custom class, why MUST you also override hashCode()?",
                Arrays.asList("To allow the object to be garbage collected", "To satisfy contract required by hash-based collections like HashMap and HashSet", "To enable comparison using the == operator", "To implement Comparable interface"),
                "To satisfy contract required by hash-based collections like HashMap and HashSet",
                "Failing to override hashCode causes equal objects to produce different hash codes, breaking Hash-based collections."));
        list.add(new Question("JAVA_H_23", cat, "Hard",
                "What is the difference between ReentrantLock and the synchronized keyword?",
                Arrays.asList("ReentrantLock supports lock polling, fairness policies, and interruptible locks, whereas synchronized is a block-level keyword", "synchronized is faster in all cases", "ReentrantLock cannot lock across methods", "synchronized requires explicit unlock() call"),
                "ReentrantLock supports lock polling, fairness policies, and interruptible locks, whereas synchronized is a block-level keyword",
                "ReentrantLock provides advanced features like trylock(), fairness, and condition variables."));
        list.add(new Question("JAVA_H_24", cat, "Hard",
                "How does CopyOnWriteArrayList achieve thread safety?",
                Arrays.asList("By locking the whole array for every read and write", "By creating a fresh copy of the underlying array upon every write operation", "By using lock-free CAS atomic integers for indexing", "By wrapping all methods in synchronized blocks"),
                "By creating a fresh copy of the underlying array upon every write operation",
                "Mutative operations (add, set, remove) make a underlying array copy, allowing lock-free reads."));
        list.add(new Question("JAVA_H_25", cat, "Hard",
                "What will happen when evaluating an infinite stream using reduce() without a limiting operation?",
                Arrays.asList("It returns Optional.empty()", "It hangs indefinitely or results in OutOfMemoryError / StackOverflowError", "It throws StreamCorruptedException", "It automatically limits evaluation to 1000 items"),
                "It hangs indefinitely or results in OutOfMemoryError / StackOverflowError",
                "Terminal operations like reduce() attempt to process all stream elements; on an infinite stream without limit(), it runs indefinitely."));
        list.add(new Question("JAVA_H_26", cat, "Hard",
                "What is a 'happens-before' relationship in the Java Memory Model (JMM)?",
                Arrays.asList("A guarantee that memory writes by one thread are visible to another thread's reads under specific synchronization actions", "A constraint forcing threads to run synchronously", "An order of thread creation", "A garbage collection prioritization scheme"),
                "A guarantee that memory writes by one thread are visible to another thread's reads under specific synchronization actions",
                "Happens-before guarantees that memory writes made by one statement are visible to another statement across threads."));
        list.add(new Question("JAVA_H_27", cat, "Hard",
                "Which method of Thread is safe to stop thread execution without corrupting shared lock states?",
                Arrays.asList("Thread.stop()", "Setting a volatile flag / calling Thread.interrupt()", "Thread.suspend()", "Thread.destroy()"),
                "Setting a volatile flag / calling Thread.interrupt()",
                "Thread.stop(), suspend(), and resume() are deprecated due to lock leaks; flag/interrupt cooperative cancellation is safe."));
        list.add(new Question("JAVA_H_28", cat, "Hard",
                "What is Garbage Collection 'PhantomReference' used for?",
                Arrays.asList("To keep an object strongly reachable in memory", "To perform post-mortem cleanup actions after an object has been finalized and reclaimed", "To create soft caches for bitmap graphics", "To prevent garbage collection from reclaiming the object"),
                "To perform post-mortem cleanup actions after an object has been finalized and reclaimed",
                "PhantomReferences are enqueued after memory reclamation to schedule post-mortem resource cleanups safely."));
        list.add(new Question("JAVA_H_29", cat, "Hard",
                "What is the worst-case time complexity for search in a ConcurrentHashMap in Java 8?",
                Arrays.asList("O(1)", "O(log N)", "O(N)", "O(N log N)"),
                "O(log N)",
                "In Java 8, treeified buckets ensure logarithmic search complexity O(log N) even under high hash collision rates."));
        list.add(new Question("JAVA_H_30", cat, "Hard",
                "What is the purpose of Sealed Classes introduced in Java 17?",
                Arrays.asList("To make all methods in a class final by default", "To restrict which other classes or interfaces may extend or implement them", "To prevent class loading over network protocols", "To automatically implement Singleton pattern"),
                "To restrict which other classes or interfaces may extend or implement them",
                "Sealed classes (and interfaces) specify explicitly via 'permits' which subclasses are allowed to extend them."));
        list.add(new Question("JAVA_H_31", cat, "Hard",
                "Which Garbage Collector is designed for low latency by performing almost all concurrent GC work in Java 11+?",
                Arrays.asList("Serial GC", "Parallel GC", "ZGC (Z Garbage Collector)", "CMS (Concurrent Mark Sweep)"),
                "ZGC (Z Garbage Collector)",
                "ZGC is a scalable low-latency garbage collector performing concurrent marking and compaction with sub-millisecond pause times."));
        list.add(new Question("JAVA_H_32", cat, "Hard",
                "What is the key purpose of ForkJoinPool in Java 7+?",
                Arrays.asList("To manage database connection pools", "To execute divide-and-conquer tasks using work-stealing algorithms", "To schedule cron jobs", "To replace standard HTTP connection handlers"),
                "To execute divide-and-conquer tasks using work-stealing algorithms",
                "ForkJoinPool uses work-stealing where idle threads steal tasks from busy thread queues for parallel divide-and-conquer tasks."));
        list.add(new Question("JAVA_H_33", cat, "Hard",
                "What occurs if you attempt to modify a collection while iterating through it using a standard Iterator (without Iterator's own remove method)?",
                Arrays.asList("NullPointerException", "ConcurrentModificationException", "IllegalStateException", "No error occurs"),
                "ConcurrentModificationException",
                "Fail-fast iterators detect structural modification via modCount and throw ConcurrentModificationException."));
        list.add(new Question("JAVA_H_34", cat, "Hard",
                "Which Java 8 feature allows composing multiple Function instances together sequentially?",
                Arrays.asList("Function.andThen() and Function.compose()", "Function.join()", "Function.pipe()", "Function.concat()"),
                "Function.andThen() and Function.compose()",
                "Function.andThen() and compose() allow chaining mathematical/functional transformations."));
        list.add(new Question("JAVA_H_35", cat, "Hard",
                "Which statement regarding PECS (Producer Extends, Consumer Super) rule is correct?",
                Arrays.asList("Use ? extends T if you only read (produce) from a generic structure, and ? super T if you only write (consume) into it", "Use ? super T to read elements and ? extends T to insert elements", "PECS applies only to Arrays, not Generics", "PECS is a memory allocation optimization strategy"),
                "Use ? extends T if you only read (produce) from a generic structure, and ? super T if you only write (consume) into it",
                "Producer Extends, Consumer Super governs wildcard bounds for reading vs writing generic collections."));
        list.add(new Question("JAVA_H_36", cat, "Hard",
                "What is the output of:\nList.of(\"a\", \"b\", \"c\").stream()\n    .peek(System.out::print)\n    .findFirst();",
                Arrays.asList("a", "abc", "Nothing is printed", "abcabc"),
                "a",
                "Streams are evaluated short-circuiting; findFirst() requests only 1 element, so peek() processes only \"a\"."));
        list.add(new Question("JAVA_H_37", cat, "Hard",
                "What is an AtomicInteger and how does it achieve thread safety without traditional locking?",
                Arrays.asList("It uses hardware-level Compare-And-Swap (CAS) instructions", "It synchronizes all methods internally", "It uses volatile arrays", "It creates thread-local copies"),
                "It uses hardware-level Compare-And-Swap (CAS) instructions",
                "Atomic classes utilize lock-free CPU primitives like Compare-And-Swap (CAS) for atomic operations."));
        list.add(new Question("JAVA_H_38", cat, "Hard",
                "What happens when a subclass constructor calls super() implicitly or explicitly?",
                Arrays.asList("It creates two separate objects in heap memory", "It initializes superclass fields within the same memory instance being constructed", "It throws InstantiationException if the superclass is concrete", "It resets static variables of the parent class"),
                "It initializes superclass fields within the same memory instance being constructed",
                "super() delegates construction of inherited state on the same object reference currently being instantiated."));
        list.add(new Question("JAVA_H_39", cat, "Hard",
                "What is a Race Condition in multithreaded Java applications?",
                Arrays.asList("A situation where threads execute too quickly for memory writeback", "A condition where correctness depends on relative timing or interleaving of multiple threads accessing shared mutable state", "When two threads hold locks and wait for each other", "When a thread runs out of stack space"),
                "A condition where correctness depends on relative timing or interleaving of multiple threads accessing shared mutable state",
                "Race conditions occur when concurrent execution without synchronization produces unintended outcomes dependent on timing."));
        list.add(new Question("JAVA_H_40", cat, "Hard",
                "What is the purpose of Java ClassLoader hierarchy (Bootstrap, Platform/Extension, Application)?",
                Arrays.asList("To optimize array allocation", "To delegate class loading upwards first (Parent Delegation Model) to ensure core runtime security and avoid duplicate loading", "To execute bytecode in parallel", "To manage garbage collection generations"),
                "To delegate class loading upwards first (Parent Delegation Model) to ensure core runtime security and avoid duplicate loading",
                "The Parent Delegation Model ensures system classes (like java.lang.Object) are loaded by bootstrap loaders rather than untrusted custom loaders."));
        list.add(new Question("JAVA_H_41", cat, "Hard",
                "What is the capacity growth behavior of Vector when it reaches capacity compared to ArrayList?",
                Arrays.asList("Vector doubles its size (100% growth by default), while ArrayList grows by 50% (1.5x)", "Vector grows by 50%, ArrayList doubles", "Both double their size", "Both grow by fixed 10 elements"),
                "Vector doubles its size (100% growth by default), while ArrayList grows by 50% (1.5x)",
                "ArrayList grows by 50% (newCapacity = oldCapacity + (oldCapacity >> 1)); Vector doubles capacity by default."));
        list.add(new Question("JAVA_H_42", cat, "Hard",
                "What are Record classes introduced in Java 16?",
                Arrays.asList("Mutable data carrier classes with public fields", "Immutable data-carrier classes that automatically generate getters, equals(), hashCode(), and toString()", "Database mapping entities in standard JDK", "Classes that cannot be instantiated"),
                "Immutable data-carrier classes that automatically generate getters, equals(), hashCode(), and toString()",
                "Records serve as transparent, immutable data carriers with auto-generated constructor, accessors, equals, hashCode, and toString."));
        list.add(new Question("JAVA_H_43", cat, "Hard",
                "What happens if a class implements two interfaces containing identical default methods without overriding that method?",
                Arrays.asList("The first interface's method is picked automatically", "The second interface's method is picked automatically", "Compilation error due to method conflict", "Runtime exception upon method invocation"),
                "Compilation error due to method conflict",
                "Multiple default methods with identical signatures cause a compile-time conflict that must be resolved by overriding in the class."));
        list.add(new Question("JAVA_H_44", cat, "Hard",
                "What is the ThreadLocal class used for in Java?",
                Arrays.asList("Sharing data safely across threads without synchronization", "Providing thread-scoped variables where each thread accesses its own isolated instance", "Creating native operating system threads", "Managing thread priorities in thread pools"),
                "Providing thread-scoped variables where each thread accesses its own isolated instance",
                "ThreadLocal maintains independent variable instances per thread, avoiding synchronization overhead for thread-isolated state."));
        list.add(new Question("JAVA_H_45", cat, "Hard",
                "Which collector should be used with Stream collect() to partition elements into two groups based on a predicate?",
                Arrays.asList("Collectors.groupingBy()", "Collectors.partitioningBy()", "Collectors.toMap()", "Collectors.joining()"),
                "Collectors.partitioningBy()",
                "Collectors.partitioningBy() splits stream elements into Map<Boolean, List<T>> based on a given Predicate."));
        list.add(new Question("JAVA_H_46", cat, "Hard",
                "What does the JVM command line flag '-Xmx2g' specify?",
                Arrays.asList("Initial Java Heap Size of 2 Gigabytes", "Maximum Java Heap Size of 2 Gigabytes", "Metaspace size of 2 Gigabytes", "Thread Stack size of 2 Gigabytes"),
                "Maximum Java Heap Size of 2 Gigabytes",
                "-Xmx sets maximum heap memory limit; -Xms sets initial heap memory limit."));
        list.add(new Question("JAVA_H_47", cat, "Hard",
                "Which statement accurately describes 'Virtual Threads' introduced in Project Loom (Java 21)?",
                Arrays.asList("Lightweight user-mode threads managed by the JVM rather than OS-level kernel threads", "Threads executing exclusively in virtual machines outside the JVM", "Deprecated wrapper around Thread pool", "Threads designed exclusively for GPU processing"),
                "Lightweight user-mode threads managed by the JVM rather than OS-level kernel threads",
                "Virtual threads (Java 21) are lightweight, user-mode threads managed by the JVM that dramatically scale throughput for I/O bound workloads."));
        list.add(new Question("JAVA_H_48", cat, "Hard",
                "What is the function of a Semaphore in java.util.concurrent?",
                Arrays.asList("To coordinate barrier synchronization among a fixed set of threads", "To maintain a set of permits to restrict concurrent access to a resource pool", "To exchange data between two threads at a rendezvous point", "To execute scheduled periodic tasks"),
                "To maintain a set of permits to restrict concurrent access to a resource pool",
                "Semaphores manage permits to throttle/limit concurrent access to constrained resources."));
        list.add(new Question("JAVA_H_49", cat, "Hard",
                "Which class in Java standard library provides null-safe static utility methods for computing equals and hashCode?",
                Arrays.asList("java.util.Objects", "java.util.ObjectUtils", "java.lang.System", "java.util.Arrays"),
                "java.util.Objects",
                "java.util.Objects provides static methods like Objects.equals(a, b) and Objects.hash(...)"));
        list.add(new Question("JAVA_H_50", cat, "Hard",
                "What is the average time complexity of searching for an element in a balanced TreeSet / TreeMap in Java?",
                Arrays.asList("O(1)", "O(log N)", "O(N)", "O(N log N)"),
                "O(log N)",
                "TreeSet and TreeMap are implemented using Red-Black trees, providing O(log N) guaranteed time complexity for search, insertion, and deletion."));
    }
}
