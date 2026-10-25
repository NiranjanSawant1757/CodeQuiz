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

        // --- EASY (17) ---
        list.add(new Question("JAVA_01", cat, "Easy",
                "What is the default value of a boolean variable in Java when declared as an instance field?",
                Arrays.asList("false", "true", "0", "null"),
                "false", "Instance variables of type boolean default to false in Java."));

        list.add(new Question("JAVA_02", cat, "Easy",
                "Which component of Java is responsible for executing the bytecode?",
                Arrays.asList("JVM", "JDK", "JRE", "JDB"),
                "JVM", "The Java Virtual Machine (JVM) interprets and executes compiled Java bytecode."));

        list.add(new Question("JAVA_03", cat, "Easy",
                "What is the size of an 'int' data type in Java?",
                Arrays.asList("4 bytes", "2 bytes", "8 bytes", "1 byte"),
                "4 bytes", "An int in Java is a 32-bit signed two's complement integer, which equals 4 bytes."));

        list.add(new Question("JAVA_04", cat, "Easy",
                "Which keyword is used to create a subclass in Java?",
                Arrays.asList("extends", "implements", "inherits", "instanceof"),
                "extends", "The 'extends' keyword is used to inherit a class, whereas 'implements' is for interfaces."));

        list.add(new Question("JAVA_05", cat, "Easy",
                "Which method serves as the standard entry point of a Java standalone application?",
                Arrays.asList("public static void main(String[] args)", "public void main(String[] args)", "void main()", "static void start()"),
                "public static void main(String[] args)", "The JVM looks for public static void main(String[] args) to start execution."));

        list.add(new Question("JAVA_06", cat, "Easy",
                "Which package is automatically imported into every Java program?",
                Arrays.asList("java.lang", "java.util", "java.io", "java.net"),
                "java.lang", "The java.lang package contains core classes (Object, System, String) and is imported implicitly."));

        list.add(new Question("JAVA_07", cat, "Easy",
                "What is the base superclass for all classes in Java?",
                Arrays.asList("java.lang.Object", "java.lang.Class", "java.lang.System", "java.lang.Type"),
                "java.lang.Object", "All classes in Java implicitly inherit from java.lang.Object."));

        list.add(new Question("JAVA_08", cat, "Easy",
                "Which of the following is NOT a Java primitive data type?",
                Arrays.asList("String", "float", "char", "byte"),
                "String", "String is an immutable reference class, not a primitive type."));

        list.add(new Question("JAVA_09", cat, "Easy",
                "Which keyword prevents a class from being inherited in Java?",
                Arrays.asList("final", "const", "static", "sealed"),
                "final", "Marking a class as final prevents other classes from extending it."));

        list.add(new Question("JAVA_10", cat, "Easy",
                "What does 'write once, run anywhere' (WORA) represent in Java?",
                Arrays.asList("Platform independence via bytecode", "Automatic database connection", "Single-threaded execution", "No compiler required"),
                "Platform independence via bytecode", "Bytecode runs on any device containing a compatible JVM."));

        list.add(new Question("JAVA_11", cat, "Easy",
                "Which operator is used to allocate memory for objects at runtime in Java?",
                Arrays.asList("new", "malloc", "alloc", "create"),
                "new", "The 'new' operator dynamically allocates memory for an object on the heap."));

        list.add(new Question("JAVA_12", cat, "Easy",
                "What is the index of the first element in a Java array?",
                Arrays.asList("0", "1", "-1", "Depends on declaration"),
                "0", "Arrays in Java are zero-indexed."));

        list.add(new Question("JAVA_13", cat, "Easy",
                "Which keyword is used to access members of the parent class?",
                Arrays.asList("super", "this", "parent", "base"),
                "super", "'super' refers directly to the immediate parent class object."));

        list.add(new Question("JAVA_14", cat, "Easy",
                "What type of loop is guaranteed to execute at least once?",
                Arrays.asList("do-while", "while", "for", "for-each"),
                "do-while", "A do-while loop evaluates its exit condition at the bottom."));

        list.add(new Question("JAVA_15", cat, "Easy",
                "Which of the following creates a single-line comment in Java?",
                Arrays.asList("// Comment", "/* Comment */", "# Comment", "<!-- Comment -->"),
                "// Comment", "Double slashes (//) denote single-line comments in Java."));

        list.add(new Question("JAVA_16", cat, "Easy",
                "What is the output of 'System.out.println(10 % 3);'?",
                Arrays.asList("1", "3", "3.33", "0"),
                "1", "The modulus operator (%) returns the remainder of the division: 10 divided by 3 leaves 1."));

        list.add(new Question("JAVA_17", cat, "Easy",
                "Which keyword is used to define an interface in Java?",
                Arrays.asList("interface", "implements", "protocol", "abstract class"),
                "interface", "The 'interface' keyword defines a contract of methods."));

        // --- MEDIUM (17) ---
        list.add(new Question("JAVA_18", cat, "Medium",
                "Why are Strings immutable in Java?",
                Arrays.asList("Security, caching, and thread safety", "To increase memory consumption", "Because JVM cannot reallocate heap memory", "To support multiple inheritance"),
                "Security, caching, and thread safety", "String immutability enables String Pool caching, thread safety without synchronization, and secure class loading."));

        list.add(new Question("JAVA_19", cat, "Medium",
                "What is the difference between '==' and '.equals()' when comparing two String objects?",
                Arrays.asList("'==' checks reference identity, while '.equals()' checks content equality", "'==' checks content, '.equals()' checks reference", "Both are identical", "'.equals()' is only for primitives"),
                "'==' checks reference identity, while '.equals()' checks content equality", "'==' compares memory addresses, whereas String.equals() compares the sequence of characters."));

        list.add(new Question("JAVA_20", cat, "Medium",
                "Where are Java object instances created in memory?",
                Arrays.asList("Heap memory", "Stack memory", "Method Area", "Register"),
                "Heap memory", "All objects in Java are allocated on the Heap memory area."));

        list.add(new Question("JAVA_21", cat, "Medium",
                "Which collection class does NOT permit duplicate elements?",
                Arrays.asList("Set", "List", "ArrayList", "Vector"),
                "Set", "The Set interface models mathematical sets and disallows duplicate elements."));

        list.add(new Question("JAVA_22", cat, "Medium",
                "What is method overloading in Java?",
                Arrays.asList("Same method name with different parameter lists in the same class", "Same method name and signature in a subclass", "Calling two methods simultaneously", "Overriding private methods"),
                "Same method name with different parameter lists in the same class", "Method overloading involves methods in the same class sharing a name but having differing parameters."));

        list.add(new Question("JAVA_23", cat, "Medium",
                "What happens when an exception is thrown inside a try block with a finally block?",
                Arrays.asList("The finally block executes whether an exception was handled or not", "The finally block is skipped if an exception occurs", "The program crashes before finally", "The finally block only executes on success"),
                "The finally block executes whether an exception was handled or not", "The finally block always executes (unless System.exit() or JVM fatal crash occurs)."));

        list.add(new Question("JAVA_24", cat, "Medium",
                "What is the main advantage of StringBuilder over StringBuffer in single-threaded environments?",
                Arrays.asList("StringBuilder is not synchronized, making it faster", "StringBuilder is thread-safe", "StringBuilder is immutable", "StringBuilder uses less stack memory"),
                "StringBuilder is not synchronized, making it faster", "StringBuffer methods are synchronized (thread-safe), which incurs overhead compared to StringBuilder."));

        list.add(new Question("JAVA_25", cat, "Medium",
                "Which Java Collection class is synchronized and thread-safe by default?",
                Arrays.asList("Vector", "ArrayList", "LinkedList", "HashSet"),
                "Vector", "Vector is a legacy synchronized collection, whereas ArrayList is not synchronized."));

        list.add(new Question("JAVA_26", cat, "Medium",
                "Can an abstract class have constructors in Java?",
                Arrays.asList("Yes, called via super() from concrete subclasses", "No, abstract classes cannot have constructors", "Only default private constructors", "Only static constructors"),
                "Yes, called via super() from concrete subclasses", "Abstract classes can have constructors used to initialize their fields when a subclass instance is instantiated."));

        list.add(new Question("JAVA_27", cat, "Medium",
                "Which exception is thrown when attempting to divide an integer by zero in Java?",
                Arrays.asList("ArithmeticException", "NullPointerException", "NumberFormatException", "IllegalArgumentException"),
                "ArithmeticException", "Integer division by zero throws an unchecked java.lang.ArithmeticException."));

        list.add(new Question("JAVA_28", cat, "Medium",
                "What is the difference between checked and unchecked exceptions in Java?",
                Arrays.asList("Checked exceptions are verified at compile time; unchecked extend RuntimeException", "Checked exceptions crash JVM immediately", "Unchecked exceptions must be declared in throws", "Checked exceptions only occur in I/O"),
                "Checked exceptions are verified at compile time; unchecked extend RuntimeException", "Checked exceptions subclass Exception (excluding RuntimeException) and must be caught or declared."));

        list.add(new Question("JAVA_29", cat, "Medium",
                "What is the default initial capacity of an ArrayList in Java?",
                Arrays.asList("10", "16", "0", "32"),
                "10", "A new ArrayList instance default constructor allocates an initial capacity of 10 elements when the first element is added."));

        list.add(new Question("JAVA_30", cat, "Medium",
                "What does the 'transient' keyword indicate when applied to a variable in Java?",
                Arrays.asList("The variable will not be serialized", "The variable cannot be changed", "The variable is stored in register", "The variable is thread-local"),
                "The variable will not be serialized", "The 'transient' modifier tells the Java serialization mechanism to exclude the field."));

        list.add(new Question("JAVA_31", cat, "Medium",
                "Which Map implementation preserves the insertion order of elements?",
                Arrays.asList("LinkedHashMap", "HashMap", "TreeMap", "Hashtable"),
                "LinkedHashMap", "LinkedHashMap maintains a doubly-linked list running through all its entries for predictable iteration order."));

        list.add(new Question("JAVA_32", cat, "Medium",
                "What is the primary role of the Garbage Collector in Java?",
                Arrays.asList("Reclaiming heap memory occupied by unreferenced objects", "Clearing stack frames", "Compiling bytecode to machine code", "Managing network sockets"),
                "Reclaiming heap memory occupied by unreferenced objects", "Garbage collection automatically reclaims heap memory from unreachable objects."));

        list.add(new Question("JAVA_33", cat, "Medium",
                "What is Autoboxing in Java?",
                Arrays.asList("Automatic conversion of primitive types to wrapper objects", "Converting Java classes to XML", "Compressing JAR archives", "Encapsulating private fields"),
                "Automatic conversion of primitive types to wrapper objects", "Autoboxing is the automatic compilation-level conversion between primitive types (e.g. int) and corresponding wrappers (e.g. Integer)."));

        list.add(new Question("JAVA_34", cat, "Medium",
                "What does the 'volatile' keyword signify in Java multithreading?",
                Arrays.asList("Reads and writes go directly to main memory, ensuring visibility", "Locks the object exclusively", "Prevents class garbage collection", "Makes the variable immutable"),
                "Reads and writes go directly to main memory, ensuring visibility", "The volatile keyword guarantees memory visibility across threads and prevents compiler reordering."));

        // --- HARD (16) ---
        list.add(new Question("JAVA_35", cat, "Hard",
                "What is the contract between 'hashCode()' and 'equals()' in Java?",
                Arrays.asList("If two objects are equal by equals(), they must have the same hashCode", "If two objects have the same hashCode, they must be equal", "hashCode() must return distinct values for unequal objects", "There is no requirement between them"),
                "If two objects are equal by equals(), they must have the same hashCode", "According to the Java Object specification, if obj1.equals(obj2), then obj1.hashCode() == obj2.hashCode()."));

        list.add(new Question("JAVA_36", cat, "Hard",
                "How does HashMap handle hash collisions internally in Java 8 and above?",
                Arrays.asList("Uses linked lists that convert to balanced red-black trees when length exceeds 8", "Uses open addressing with linear probing", "Discards older keys", "Rehashes the entire table synchronously"),
                "Uses linked lists that convert to balanced red-black trees when length exceeds 8", "In Java 8, when a bucket's bin count exceeds TREEIFY_THRESHOLD (8), it transitions to a Red-Black TreeNode to improve search from O(n) to O(log n)."));

        list.add(new Question("JAVA_37", cat, "Hard",
                "What is a 'PhantomReference' in Java and when does it become enqueued?",
                Arrays.asList("Enqueued after object is finalized, used for post-mortem resource cleanup", "Prevents garbage collection forever", "Accessible before garbage collection", "Same as WeakReference"),
                "Enqueued after object is finalized, used for post-mortem resource cleanup", "Phantom references are enqueued after their referents have been finalized, providing a cleaner alternative to finalize()."));

        list.add(new Question("JAVA_38", cat, "Hard",
                "What is Type Erasure in Java Generics?",
                Arrays.asList("Type parameters are removed at compile time and replaced with bounds/Object", "Generics are kept as metadata in JVM bytecode execution", "All generic types are converted to primitive types", "Compiler prohibits casting generic objects"),
                "Type parameters are removed at compile time and replaced with bounds/Object", "Java generics are implemented via erasure: type parameters are replaced by their bounds or Object in bytecode for backward compatibility."));

        list.add(new Question("JAVA_39", cat, "Hard",
                "What is the effect of calling Thread.join() on a thread instance?",
                Arrays.asList("The calling thread pauses until the specified thread completes", "The target thread terminates immediately", "Both threads execute in parallel locked step", "It merges two thread stacks"),
                "The calling thread pauses until the specified thread completes", "join() causes the currently executing thread to wait until the thread on which join() was invoked finishes execution."));

        list.add(new Question("JAVA_40", cat, "Hard",
                "What is the difference between ConcurrentHashMap and Collections.synchronizedMap()?",
                Arrays.asList("ConcurrentHashMap uses lock striping/CAS; synchronizedMap locks on a single mutex", "synchronizedMap has faster concurrent reads", "ConcurrentHashMap allows null keys and values", "synchronizedMap is lock-free"),
                "ConcurrentHashMap uses lock striping/CAS; synchronizedMap locks on a single mutex", "ConcurrentHashMap achieves high concurrency by segmenting or using CAS operations rather than synchronizing the whole map."));

        list.add(new Question("JAVA_41", cat, "Hard",
                "What is the Double-Checked Locking pattern in a Java Singleton and why is volatile required?",
                Arrays.asList("Volatile prevents instruction reordering during instance construction", "Volatile ensures only one thread enters the method", "Double-checked locking does not work in Java", "Volatile forces garbage collection"),
                "Volatile prevents instruction reordering during instance construction", "Without volatile, the write to the singleton instance reference could be reordered before constructor completion, exposing a partially initialized object."));

        list.add(new Question("JAVA_42", cat, "Hard",
                "Which Garbage Collector was made the default in Java 9?",
                Arrays.asList("G1 (Garbage-First) GC", "Parallel GC", "CMS (Concurrent Mark Sweep)", "ZGC"),
                "G1 (Garbage-First) GC", "G1 GC replaced Parallel GC as the default garbage collector starting in Java 9."));

        list.add(new Question("JAVA_43", cat, "Hard",
                "What is the purpose of the 'fork/join' framework introduced in Java 7?",
                Arrays.asList("Parallelizing recursive divide-and-conquer tasks using work-stealing", "Running OS fork commands", "Joining network sockets across processes", "Creating thread pools with single threads"),
                "Parallelizing recursive divide-and-conquer tasks using work-stealing", "The ForkJoinPool executes tasks recursively split into subtasks using a work-stealing algorithm to maximize CPU core utilization."));

        list.add(new Question("JAVA_44", cat, "Hard",
                "Can an interface have concrete method implementations in Java 8 and beyond?",
                Arrays.asList("Yes, using 'default' and 'static' methods", "No, interfaces can only have abstract methods", "Only through inner classes", "Only if marked as final"),
                "Yes, using 'default' and 'static' methods", "Java 8 introduced default and static methods in interfaces with full method bodies."));

        list.add(new Question("JAVA_45", cat, "Hard",
                "What happens when calling 'System.gc()' in Java?",
                Arrays.asList("It suggests to the JVM to run garbage collection, but doesn't guarantee it", "It immediately forces complete memory purge", "It terminates all active background threads", "It throws UnsupportedOperationException in production"),
                "It suggests to the JVM to run garbage collection, but doesn't guarantee it", "System.gc() merely hints to the JVM that garbage collection effort might be beneficial."));

        list.add(new Question("JAVA_46", cat, "Hard",
                "What is the Java Memory Model (JMM) 'happens-before' relationship?",
                Arrays.asList("A formal guarantee that memory writes by one thread are visible to another", "A scheduling priority for OS threads", "A garbage collection threshold order", "A stack frame allocation rule"),
                "A formal guarantee that memory writes by one thread are visible to another", "Happens-before defines orderings in concurrent programming where memory updates from one operation are guaranteed visible to another."));

        list.add(new Question("JAVA_47", cat, "Hard",
                "What is the return type of a method declared as 'void'?",
                Arrays.asList("No return value", "null", "java.lang.Void", "0"),
                "No return value", "The 'void' keyword specifies that a method returns nothing to the caller."));

        list.add(new Question("JAVA_48", cat, "Hard",
                "How does the 'ReentrantLock' differ from the 'synchronized' keyword?",
                Arrays.asList("Provides fairness policies, interruptible lock acquisition, and timed lock attempts", "Is slower in all scenarios", "Cannot be used in loops", "Does not support mutual exclusion"),
                "Provides fairness policies, interruptible lock acquisition, and timed lock attempts", "ReentrantLock gives advanced capabilities like tryLock(timeout), fair scheduling, and multiple Condition variables."));

        list.add(new Question("JAVA_49", cat, "Hard",
                "In Java Streams, what is the key distinction between intermediate and terminal operations?",
                Arrays.asList("Intermediate operations are lazy and return a Stream; terminal operations trigger execution", "Intermediate operations consume the stream immediately", "Terminal operations can be chained endlessly", "There is no behavioral difference"),
                "Intermediate operations are lazy and return a Stream; terminal operations trigger execution", "Intermediate operations (filter, map) are lazy, while terminal operations (collect, forEach) produce a non-stream result and execute the pipeline."));

        list.add(new Question("JAVA_50", cat, "Hard",
                "What happens when you deserialize an object whose class serialVersionUID differs from the serialized stream?",
                Arrays.asList("InvalidClassException is thrown", "Fields default to null silently", "JVM automatically converts fields", "Compilation error occurs"),
                "InvalidClassException is thrown", "A serialVersionUID mismatch indicates class incompatibility and causes an InvalidClassException at runtime."));

        return list;
    }
}
