package com.example.codequiz.data;

import com.example.codequiz.model.Question;
import com.example.codequiz.util.AppConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaScriptQuestions {

    public static List<Question> get() {
        List<Question> list = new ArrayList<>();
        String cat = AppConstants.CAT_JAVASCRIPT;

        // --- EASY (17) ---
        list.add(new Question("JS_01", cat, "Easy",
                "Which keyword was introduced in ES6 to declare a block-scoped reassignable variable?",
                Arrays.asList("let", "var", "const", "def"),
                "let", "'let' declares block-scoped variables, unlike 'var' which is function-scoped."));

        list.add(new Question("JS_02", cat, "Easy",
                "What is the result of 'typeof null' in JavaScript?",
                Arrays.asList("'object'", "'null'", "'undefined'", "'boolean'"),
                "'object'", "Due to a historical legacy bug in JS, typeof null returns 'object'."));

        list.add(new Question("JS_03", cat, "Easy",
                "Which operator performs strict equality comparison without type coercion?",
                Arrays.asList("===", "==", "=", "!="),
                "===", "The strict equality operator (===) checks both value and data type without coercion."));

        list.add(new Question("JS_04", cat, "Easy",
                "How do you write a comment on a single line in JavaScript?",
                Arrays.asList("// This is a comment", "<!-- This is a comment -->", "# This is a comment", "/* This is a comment"),
                "// This is a comment", "Double forward slashes (//) indicate single-line comments in JS."));

        list.add(new Question("JS_05", cat, "Easy",
                "Which method writes informational messages to the browser developer console?",
                Arrays.asList("console.log()", "print()", "System.out.println()", "document.write()"),
                "console.log()", "console.log() outputs messages to the web debugging console."));

        list.add(new Question("JS_06", cat, "Easy",
                "Which built-in object represents an ordered list of values in JavaScript?",
                Arrays.asList("Array", "List", "Vector", "Collection"),
                "Array", "JavaScript Arrays are zero-indexed, ordered collections of values."));

        list.add(new Question("JS_07", cat, "Easy",
                "What will 'Boolean(\"\")' (empty string) return in JavaScript?",
                Arrays.asList("false", "true", "null", "undefined"),
                "false", "An empty string is a falsy value in JavaScript."));

        list.add(new Question("JS_08", cat, "Easy",
                "Which keyword declares a constant variable whose identifier cannot be reassigned?",
                Arrays.asList("const", "let", "static", "final"),
                "const", "'const' creates a block-scoped read-only reference to a value."));

        list.add(new Question("JS_09", cat, "Easy",
                "What is the output of '2 + \"2\"' in JavaScript?",
                Arrays.asList("\"22\"", "4", "NaN", "TypeError"),
                "\"22\"", "The binary plus operator concatenates when one operand is a string."));

        list.add(new Question("JS_10", cat, "Easy",
                "Which function parses a string and returns an integer?",
                Arrays.asList("parseInt()", "toInteger()", "Number.toInt()", "Integer.parse()"),
                "parseInt()", "parseInt(string, radix) parses a string argument and returns an integer."));

        list.add(new Question("JS_11", cat, "Easy",
                "What does 'NaN' stand for in JavaScript?",
                Arrays.asList("Not a Number", "New array Node", "Null and Negative", "Not Applicable Name"),
                "Not a Number", "NaN represents a computational result that is not a legal number."));

        list.add(new Question("JS_12", cat, "Easy",
                "What is the output of 'typeof NaN' in JavaScript?",
                Arrays.asList("'number'", "'NaN'", "'undefined'", "'object'"),
                "'number'", "In the IEEE 754 floating-point standard used by JS, NaN is of type 'number'."));

        list.add(new Question("JS_13", cat, "Easy",
                "Which array method removes the last element and returns it?",
                Arrays.asList("pop()", "push()", "shift()", "slice()"),
                "pop()", "pop() removes the last element from an array and returns that element."));

        list.add(new Question("JS_14", cat, "Easy",
                "Which array method adds one or more elements to the end of an array?",
                Arrays.asList("push()", "pop()", "unshift()", "concat()"),
                "push()", "push() appends new elements to the end of an array and returns its new length."));

        list.add(new Question("JS_15", cat, "Easy",
                "What is the file extension for JavaScript source code files?",
                Arrays.asList(".js", ".javascript", ".jvs", ".jsx"),
                ".js", "Standard JavaScript source code files use the .js extension."));

        list.add(new Question("JS_16", cat, "Easy",
                "Which method attaches an event handler function to a DOM element?",
                Arrays.asList("addEventListener()", "attachHandler()", "bindEvent()", "listen()"),
                "addEventListener()", "element.addEventListener(event, callback) sets up a function to be called when the specified event is delivered."));

        list.add(new Question("JS_17", cat, "Easy",
                "What is an arrow function syntax introduced in ES6?",
                Arrays.asList("() => {}", "function => ()", "-> {}", "def () => {}"),
                "() => {}", "Arrow functions (() => {}) provide concise syntax and lexically bind 'this'."));

        // --- MEDIUM (17) ---
        list.add(new Question("JS_18", cat, "Medium",
                "What is a Closure in JavaScript?",
                Arrays.asList("A function combined with its lexical environment, retaining access to outer scope variables", "A function that has no return value", "A way to close browser windows", "A private class constructor"),
                "A function combined with its lexical environment, retaining access to outer scope variables", "Closures give an inner function access to an outer function's scope even after the outer function has returned."));

        list.add(new Question("JS_19", cat, "Medium",
                "What is Hoisting in JavaScript?",
                Arrays.asList("Moving variable and function declarations to the top of their containing scope during compilation phase", "Elevating browser privileges", "Animating DOM elements upward", "Optimizing memory allocations"),
                "Moving variable and function declarations to the top of their containing scope during compilation phase", "Hoisting allows functions and var variables to be referenced before their lines of declaration in code."));

        list.add(new Question("JS_20", cat, "Medium",
                "What is the Temporal Dead Zone (TDZ) regarding let and const?",
                Arrays.asList("The time between entering scope and variable declaration where accessing let/const throws ReferenceError", "A garbage collection pause", "The time taken by an asynchronous AJAX call", "An inactive browser tab"),
                "The time between entering scope and variable declaration where accessing let/const throws ReferenceError", "Variables declared with let and const cannot be accessed before declaration; doing so raises a ReferenceError."));

        list.add(new Question("JS_21", cat, "Medium",
                "What does 'Array.prototype.map()' do?",
                Arrays.asList("Creates a new array populated with the results of calling a provided function on every element", "Filters elements matching a predicate", "Modifies the array in place", "Reduces array to a single value"),
                "Creates a new array populated with the results of calling a provided function on every element", "map() invokes a callback on each element and returns a new array of transformed values without mutating the original."));

        list.add(new Question("JS_22", cat, "Medium",
                "What is the difference between '==' and '==='?",
                Arrays.asList("'==' performs type coercion before comparison; '===' checks both value and type without coercion", "'===' coerces types; '==' does not", "There is no difference", "'===' is only for objects"),
                "'==' performs type coercion before comparison; '===' checks both value and type without coercion", "The abstract equality operator (==) converts operands to a common type; strict equality (===) requires identical types."));

        list.add(new Question("JS_23", cat, "Medium",
                "What does a JavaScript Promise represent?",
                Arrays.asList("An object representing the eventual completion (or failure) of an asynchronous operation and its resulting value", "A synchronous loop construct", "A thread lock", "A browser storage cookie"),
                "An object representing the eventual completion (or failure) of an asynchronous operation and its resulting value", "Promises handle asynchronous computations with states: pending, fulfilled, or rejected."));

        list.add(new Question("JS_24", cat, "Medium",
                "What is the purpose of the 'async/await' syntax in ES2017?",
                Arrays.asList("Allows writing asynchronous promise-based code in a readable synchronous-like style", "Spawns worker background threads", "Runs code on GPU", "Replaces try/catch blocks"),
                "Allows writing asynchronous promise-based code in a readable synchronous-like style", "async functions return promises, and await pauses execution until the promise settles."));

        list.add(new Question("JS_25", cat, "Medium",
                "How does 'this' behave in an arrow function compared to a standard function?",
                Arrays.asList("Arrow functions do not bind their own 'this'; they inherit 'this' from the enclosing lexical scope", "Arrow functions bind 'this' to the global object always", "Arrow functions make 'this' undefined", "Arrow functions can be rebound using .bind()"),
                "Arrow functions do not bind their own 'this'; they inherit 'this' from the enclosing lexical scope", "Arrow functions retain the 'this' value of the enclosing execution context, preventing common callback context bugs."));

        list.add(new Question("JS_26", cat, "Medium",
                "What is event bubbling in the DOM event flow?",
                Arrays.asList("Events propagate from the deepest target element upward through its ancestors in the DOM tree", "Events move from window down to target element", "Events execute randomly", "Events only fire on root html element"),
                "Events propagate from the deepest target element upward through its ancestors in the DOM tree", "During bubbling, the event triggers on the target first, then sequentially triggers handlers on parent nodes up to Document."));

        list.add(new Question("JS_27", cat, "Medium",
                "What method prevents the default browser behavior of an event (e.g. form submission)?",
                Arrays.asList("event.preventDefault()", "event.stopPropagation()", "event.stop()", "return false;"),
                "event.preventDefault()", "preventDefault() cancels the default action that belongs to the event."));

        list.add(new Question("JS_28", cat, "Medium",
                "What does the spread operator '...' do on an object: '{...obj}'?",
                Arrays.asList("Copies own enumerable properties from obj into a new object (shallow copy)", "Performs a deep clone of nested objects", "Deletes original object", "Freezes object properties"),
                "Copies own enumerable properties from obj into a new object (shallow copy)", "Object spread syntax creates a shallow copy of properties from source to target."));

        list.add(new Question("JS_29", cat, "Medium",
                "What is the difference between 'null' and 'undefined'?",
                Arrays.asList("'undefined' means a variable has been declared but not assigned; 'null' is an intentional assignment representing no value", "'null' is unassigned; 'undefined' is an object", "They are identical in all aspects", "'undefined' throws an error when checked"),
                "'undefined' means a variable has been declared but not assigned; 'null' is an intentional assignment representing no value", "undefined is the default primitive value of uninitialized variables; null is an intentional assignment representing absence of an object."));

        list.add(new Question("JS_30", cat, "Medium",
                "What does 'JSON.stringify()' do in JavaScript?",
                Arrays.asList("Converts a JavaScript object or value to a JSON formatted string", "Parses a JSON string into an object", "Encrypts JavaScript source code", "Prints object keys to console"),
                "Converts a JavaScript object or value to a JSON formatted string", "JSON.stringify() serializes objects, arrays, and primitives to standard JSON text."));

        list.add(new Question("JS_31", cat, "Medium",
                "What does 'Array.prototype.reduce()' do?",
                Arrays.asList("Executes a reducer function on each element, resulting in a single output value", "Reduces array size by deleting nulls", "Sorts the array descending", "Finds the minimum number in array"),
                "Executes a reducer function on each element, resulting in a single output value", "reduce() iterates over array elements accumulating them into a single resultant value (e.g. sum, object)."));

        list.add(new Question("JS_32", cat, "Medium",
                "What does 'Object.freeze()' do to an object?",
                Arrays.asList("Prevents adding, removing, or modifying properties on the object", "Encrypts the object in memory", "Makes the object immutable deeply", "Hides properties from iteration"),
                "Prevents adding, removing, or modifying properties on the object", "Object.freeze() makes an object shallowly immutable; properties cannot be modified, added, or deleted."));

        list.add(new Question("JS_33", cat, "Medium",
                "What is Debouncing in JavaScript frontend development?",
                Arrays.asList("Limiting the rate of function execution until a specified delay has elapsed since the last call", "Executing a function on every screen frame", "Splitting an array into equal chunks", "Removing duplicate elements from list"),
                "Limiting the rate of function execution until a specified delay has elapsed since the last call", "Debounce postpones execution until no new invocations happen for N milliseconds (e.g. search input suggestions)."));

        list.add(new Question("JS_34", cat, "Medium",
                "What is the difference between localStorage and sessionStorage?",
                Arrays.asList("localStorage data persists across browser sessions; sessionStorage data clears when the browser tab is closed", "sessionStorage persists forever; localStorage expires", "localStorage has 1KB limit; sessionStorage has 5MB", "sessionStorage is sent with HTTP headers"),
                "localStorage data persists across browser sessions; sessionStorage data clears when the browser tab is closed", "localStorage persists until explicitly cleared, while sessionStorage is scoped strictly to the current browser tab lifetime."));

        // --- HARD (16) ---
        list.add(new Question("JS_35", cat, "Hard",
                "How does the JavaScript Event Loop coordinate the Call Stack, Microtask Queue, and Macrotask Queue?",
                Arrays.asList("Microtasks (Promises, queueMicrotask) are completely drained before the next Macrotask (setTimeout, I/O) executes", "Macrotasks have higher priority than Microtasks", "They execute in parallel on multiple CPU cores", "The event loop executes tasks in random order"),
                "Microtasks (Promises, queueMicrotask) are completely drained before the next Macrotask (setTimeout, I/O) executes", "After each macrotask completes, the event loop empties the entire microtask queue before picking the next task."));

        list.add(new Question("JS_36", cat, "Hard",
                "What is Prototypal Inheritance and the prototype chain in JavaScript?",
                Arrays.asList("Objects have a hidden [[Prototype]] link (__proto__); property lookups walk up this chain until Object.prototype or null is reached", "Classes are compiled to native C++ vtables", "Inheritance is copied by value at instantiation", "Objects cannot inherit from other objects"),
                "Objects have a hidden [[Prototype]] link (__proto__); property lookups walk up this chain until Object.prototype or null is reached", "JS objects inherit properties and methods from other objects via an internal prototype chain reference."));

        list.add(new Question("JS_37", cat, "Hard",
                "What is a JavaScript Proxy object?",
                Arrays.asList("An object that wraps another target object and intercepts fundamental operations like get, set, and has via traps", "A network proxy client for HTTP requests", "A polyfill for ES6 classes", "A security sandbox for eval()"),
                "An object that wraps another target object and intercepts fundamental operations like get, set, and has via traps", "The Proxy object enables creating a proxy for another object to customize property lookup, assignment, enumeration, and invocation."));

        list.add(new Question("JS_38", cat, "Hard",
                "What is a Generator function in JavaScript and how is it declared?",
                Arrays.asList("A function declared with 'function*' that can yield multiple values pausing execution with 'yield'", "A function that generates random UUIDs", "A constructor function for Web Workers", "A compile-time macro"),
                "A function declared with 'function*' that can yield multiple values pausing execution with 'yield'", "Generator functions yield an iterator and can be entered and exited multiple times while preserving execution context."));

        list.add(new Question("JS_39", cat, "Hard",
                "What does 'Function.prototype.bind()' return?",
                Arrays.asList("A new function that, when called, has its 'this' keyword set to the provided value and preset initial arguments", "The return value of the function", "A boolean indicating success", "A Promise"),
                "A new function that, when called, has its 'this' keyword set to the provided value and preset initial arguments", "bind() returns a newly bound copy of the function with specified context and optional curried parameters."));

        list.add(new Question("JS_40", cat, "Hard",
                "What is the difference between 'WeakMap' and 'Map' in JavaScript?",
                Arrays.asList("WeakMap keys must be objects and are held weakly, allowing garbage collection if no other references exist", "WeakMap is slower than Map", "WeakMap can be iterated with for...of", "Map keys can only be strings"),
                "WeakMap keys must be objects and are held weakly, allowing garbage collection if no other references exist", "WeakMap holds weak references to key objects, preventing memory leaks and disallowing iteration (no size or keys() methods)."));

        list.add(new Question("JS_41", cat, "Hard",
                "What is the purpose of 'Symbol' primitive type introduced in ES6?",
                Arrays.asList("Creating unique, immutable identifiers often used as collision-free object property keys", "Formatting currency strings", "Mathematical equation solving", "Replacing String primitives"),
                "Creating unique, immutable identifiers often used as collision-free object property keys", "Symbols are guaranteed to be unique and can be used to add hidden/non-conflicting properties to objects."));

        list.add(new Question("JS_42", cat, "Hard",
                "What is Tail Call Optimization (TCO) in JavaScript engines?",
                Arrays.asList("A feature where a function call that is the final action reuses the current stack frame, preventing stack overflow", "Optimizing end of arrays", "Compressing code during bundling", "Executing cleanup callbacks"),
                "A feature where a function call that is the final action reuses the current stack frame, preventing stack overflow", "In ES6 strict mode, proper tail calls allow recursive functions to execute in constant stack space without overflowing."));

        list.add(new Question("JS_43", cat, "Hard",
                "What is Currying in functional JavaScript programming?",
                Arrays.asList("Transforming a function with multiple arguments into a sequence of nested functions each taking a single argument", "Adding spices to variable names", "Executing functions asynchronously", "Binding functions to DOM elements"),
                "Transforming a function with multiple arguments into a sequence of nested functions each taking a single argument", "Currying translates f(a, b, c) into f(a)(b)(c), facilitating higher-order function composition."));

        list.add(new Question("JS_44", cat, "Hard",
                "What does 'Object.defineProperty()' allow you to configure on a property?",
                Arrays.asList("value, writable, enumerable, configurable, get, and set descriptor attributes", "Only property color and font", "Memory address in V8 heap", "Thread affinity"),
                "value, writable, enumerable, configurable, get, and set descriptor attributes", "Object.defineProperty enables precise control over property accessors, enumeration in for..in, and mutation constraints."));

        list.add(new Question("JS_45", cat, "Hard",
                "What happens when you run 'Promise.all([p1, p2, p3])' if one promise rejects?",
                Arrays.asList("Immediately rejects with the error of the first rejected promise (fail-fast)", "Waits for all promises to settle regardless of errors", "Ignores the error and returns successful values", "Throws a fatal uncaught exception"),
                "Immediately rejects with the error of the first rejected promise (fail-fast)", "Promise.all rejects immediately upon any rejection; Promise.allSettled is required to wait for all completions."));

        list.add(new Question("JS_46", cat, "Hard",
                "What is the V8 engine's Hidden Classes (Shapes) optimization mechanism?",
                Arrays.asList("V8 assigns internal shapes to objects with identical property layouts to generate fast inline caches", "Encrypts variables from inspection", "Hides private methods from prototype", "Hides global window variables"),
                "V8 assigns internal shapes to objects with identical property layouts to generate fast inline caches", "V8 creates transition trees of hidden classes based on property addition order, enabling high-speed inline property caching."));

        list.add(new Question("JS_47", cat, "Hard",
                "What is the difference between synchronous execution and asynchronous execution in single-threaded JS?",
                Arrays.asList("Synchronous blocks the call stack until done; asynchronous offloads tasks to Web APIs / libuv and callbacks queue up", "Asynchronous creates new OS threads for JS code", "Synchronous is only for math operations", "There is no difference"),
                "Synchronous blocks the call stack until done; asynchronous offloads tasks to Web APIs / libuv and callbacks queue up", "JS executes on a single call stack; asynchronous tasks leverage runtime host APIs (timers, network) without blocking the thread."));

        list.add(new Question("JS_48", cat, "Hard",
                "What is the purpose of 'Reflect' API in JavaScript?",
                Arrays.asList("Provides interceptable methods corresponding 1-to-1 with Proxy traps for default reflection operations", "Draws mirror reflections on HTML5 canvas", "A compiler debugger tool", "An alternative to JSON.parse"),
                "Provides interceptable methods corresponding 1-to-1 with Proxy traps for default reflection operations", "Reflect simplifies forwarding operations from within Proxy traps and cleans up old Object reflection functions."));

        list.add(new Question("JS_49", cat, "Hard",
                "What is the distinction between 'call()' and 'apply()'?",
                Arrays.asList("'call()' accepts arguments individually separated by commas; 'apply()' accepts arguments as an array", "'call()' is asynchronous; 'apply()' is synchronous", "'call()' can only be used on arrows", "They are identical"),
                "'call()' accepts arguments individually separated by commas; 'apply()' accepts arguments as an array", "Both invoke the function with a given 'this', but fn.call(thisArg, arg1, arg2) takes a list, whereas fn.apply(thisArg, [args]) takes an array."));

        list.add(new Question("JS_50", cat, "Hard",
                "What is tree shaking in modern JavaScript module bundlers?",
                Arrays.asList("Dead-code elimination that removes unused exports from the final bundle using static ES6 import/export analysis", "Optimizing DOM tree nodes", "Scrambling JavaScript code for security", "Sorting CSS class names"),
                "Dead-code elimination that removes unused exports from the final bundle using static ES6 import/export analysis", "Tree shaking relies on static ES module structure to prune unused functions and dependencies from production builds."));

        return list;
    }
}
