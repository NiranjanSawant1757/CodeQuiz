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
        loadEasy(list, cat);
        loadMedium(list, cat);
        loadHard(list, cat);
        return list;
    }

    private static void loadEasy(List<Question> list, String cat) {
        list.add(new Question("JS_E_01", cat, "Easy",
                "Which keyword declares a block-scoped variable that can be reassigned in modern JavaScript?",
                Arrays.asList("const", "let", "var", "static"),
                "let",
                "The 'let' keyword declares a reassignable, block-scoped local variable."));
        list.add(new Question("JS_E_02", cat, "Easy",
                "Which keyword declares a block-scoped variable that CANNOT be reassigned after initialization?",
                Arrays.asList("const", "let", "var", "fixed"),
                "const",
                "The 'const' keyword creates a read-only, block-scoped reference that cannot be reassigned."));
        list.add(new Question("JS_E_03", cat, "Easy",
                "Which of the following is NOT a primitive data type in JavaScript?",
                Arrays.asList("String", "Number", "Array", "Boolean"),
                "Array",
                "Arrays are reference objects in JavaScript, whereas String, Number, and Boolean are primitives."));
        list.add(new Question("JS_E_04", cat, "Easy",
                "What does the `typeof` operator return for `typeof 'Hello World'`?",
                Arrays.asList("string", "String", "text", "object"),
                "string",
                "The typeof operator returns lowercase 'string' for string primitive values."));
        list.add(new Question("JS_E_05", cat, "Easy",
                "What does `typeof 42` return in JavaScript?",
                Arrays.asList("integer", "number", "float", "Number"),
                "number",
                "JavaScript treats all numeric values under the 'number' primitive type."));
        list.add(new Question("JS_E_06", cat, "Easy",
                "What does `typeof true` return?",
                Arrays.asList("boolean", "Boolean", "bool", "flag"),
                "boolean",
                "The typeof operator returns 'boolean' for boolean primitive values."));
        list.add(new Question("JS_E_07", cat, "Easy",
                "What is the result of `typeof undefined`?",
                Arrays.asList("undefined", "object", "null", "void"),
                "undefined",
                "The typeof operator returns the string 'undefined' for uninitialized/undefined values."));
        list.add(new Question("JS_E_08", cat, "Easy",
                "How do you write a single-line comment in JavaScript?",
                Arrays.asList("<!-- This is a comment -->", "// This is a comment", "/* This is a comment */", "' This is a comment"),
                "// This is a comment",
                "Double slashes // indicate a single-line comment in JavaScript."));
        list.add(new Question("JS_E_09", cat, "Easy",
                "How do you write a multi-line comment in JavaScript?",
                Arrays.asList("/* This is a comment */", "// This is a comment", "<!-- This is a comment -->", "# This is a comment"),
                "/* This is a comment */",
                "/* ... */ delimits multi-line comments in JavaScript."));
        list.add(new Question("JS_E_10", cat, "Easy",
                "Which operator is used to assign a value to a variable?",
                Arrays.asList("=", "==", "===", ":="),
                "=",
                "The single equal sign '=' is the assignment operator."));
        list.add(new Question("JS_E_11", cat, "Easy",
                "Which operator checks both value AND type equality without performing type coercion?",
                Arrays.asList("==", "=", "===", "!="),
                "===",
                "The strict equality operator '===' compares both value and type without coercion."));
        list.add(new Question("JS_E_12", cat, "Easy",
                "What is the remainder of `10 % 3` in JavaScript?",
                Arrays.asList("1", "3", "0", "3.33"),
                "1",
                "The modulus operator % calculates the remainder of division (10 % 3 = 1)."));
        list.add(new Question("JS_E_13", cat, "Easy",
                "Which character is used to enclose template literals in ES6+?",
                Arrays.asList("Backticks (`)", "Single quotes (')", "Double quotes (\")", "Tildes (~)"),
                "Backticks (`)",
                "Template literals are enclosed by backticks (`) and support string interpolation with ${expression}."));
        list.add(new Question("JS_E_14", cat, "Easy",
                "What is the syntax for embedded expressions inside template literals?",
                Arrays.asList("${expression}", "{{expression}}", "%{expression}", "#{expression}"),
                "${expression}",
                "Template literals use `${expression}` to interpolate dynamic variables or statements."));
        list.add(new Question("JS_E_15", cat, "Easy",
                "Which method adds one or more elements to the END of an array and returns its new length?",
                Arrays.asList("push()", "pop()", "shift()", "unshift()"),
                "push()",
                "push() appends items to the end of an array."));
        list.add(new Question("JS_E_16", cat, "Easy",
                "Which method removes the LAST element from an array and returns that element?",
                Arrays.asList("pop()", "push()", "shift()", "splice()"),
                "pop()",
                "pop() removes and returns the last element of an array."));
        list.add(new Question("JS_E_17", cat, "Easy",
                "Which method removes the FIRST element from an array?",
                Arrays.asList("shift()", "unshift()", "pop()", "slice()"),
                "shift()",
                "shift() removes and returns the first element at index 0."));
        list.add(new Question("JS_E_18", cat, "Easy",
                "Which method adds one or more elements to the BEGINNING of an array?",
                Arrays.asList("unshift()", "shift()", "append()", "prepend()"),
                "unshift()",
                "unshift() inserts elements at index 0 of an array."));
        list.add(new Question("JS_E_19", cat, "Easy",
                "How do you access the length of an array named `items`?",
                Arrays.asList("items.length", "items.size()", "items.count", "items.getLength()"),
                "items.length",
                "The .length property returns the total element count in an array."));
        list.add(new Question("JS_E_20", cat, "Easy",
                "Which keyword starts a conditional block in JavaScript?",
                Arrays.asList("if", "when", "check", "condition"),
                "if",
                "The 'if' statement conditionally executes code if a test expression evaluates to truthy."));
        list.add(new Question("JS_E_21", cat, "Easy",
                "Which loop structure executes a block of code a set number of times using an initializer, condition, and final expression?",
                Arrays.asList("for loop", "while loop", "do-while loop", "for-in loop"),
                "for loop",
                "A standard 'for (init; condition; step)' loop repeats code while condition is true."));
        list.add(new Question("JS_E_22", cat, "Easy",
                "How do you declare a named function in JavaScript?",
                Arrays.asList("function myFunc() {}", "def myFunc() {}", "func myFunc() {}", "void myFunc() {}"),
                "function myFunc() {}",
                "The 'function' keyword is used to declare named function statements."));
        list.add(new Question("JS_E_23", cat, "Easy",
                "Which syntax represents an ES6 arrow function with no parameters returning `10`?",
                Arrays.asList("() => 10", "-> 10", "function() => 10", "() -> { return 10; }"),
                "() => 10",
                "`() => 10` is an arrow function expression with concise implicit return."));
        list.add(new Question("JS_E_24", cat, "Easy",
                "How do you create an empty object literal in JavaScript?",
                Arrays.asList("const obj = {};", "const obj = [];", "const obj = ();", "const obj = <>;"),
                "const obj = {};",
                "Curly braces `{}` create an empty object literal."));
        list.add(new Question("JS_E_25", cat, "Easy",
                "How do you access property `name` on object `user` using dot notation?",
                Arrays.asList("user.name", "user['name']", "both A and B work", "user->name"),
                "both A and B work",
                "Both dot notation `user.name` and bracket notation `user['name']` access object properties."));
        list.add(new Question("JS_E_26", cat, "Easy",
                "Which built-in method converts a JavaScript object into a JSON string?",
                Arrays.asList("JSON.stringify()", "JSON.parse()", "JSON.encode()", "JSON.toString()"),
                "JSON.stringify()",
                "JSON.stringify() serializes JavaScript values/objects into JSON formatted strings."));
        list.add(new Question("JS_E_27", cat, "Easy",
                "Which built-in method parses a valid JSON string into a JavaScript object?",
                Arrays.asList("JSON.parse()", "JSON.stringify()", "JSON.decode()", "JSON.toObject()"),
                "JSON.parse()",
                "JSON.parse() constructs JavaScript values/objects described by a JSON string."));
        list.add(new Question("JS_E_28", cat, "Easy",
                "What is the result of `'5' + 2` in JavaScript?",
                Arrays.asList("'52'", "7", "NaN", "TypeError"),
                "'52'",
                "The + operator concatenates string '5' and converted string '2', producing '52'."));
        list.add(new Question("JS_E_29", cat, "Easy",
                "What is the result of `'5' - 2` in JavaScript?",
                Arrays.asList("3", "'52'", "NaN", "'3'"),
                "3",
                "The subtraction operator - converts string '5' to number 5, yielding 3."));
        list.add(new Question("JS_E_30", cat, "Easy",
                "What is the boolean evaluation of `Boolean(0)` in JavaScript?",
                Arrays.asList("false", "true", "undefined", "null"),
                "false",
                "Numeric 0 is a falsy value in JavaScript, evaluating to false."));
        list.add(new Question("JS_E_31", cat, "Easy",
                "Which of the following values is TRUTHY in JavaScript?",
                Arrays.asList("'0'", "0", "null", "undefined"),
                "'0'",
                "Non-empty string `'0'` is truthy, whereas 0, null, and undefined are falsy."));
        list.add(new Question("JS_E_32", cat, "Easy",
                "What does the logical AND operator `&&` return if the first operand is falsy?",
                Arrays.asList("The first (falsy) operand", "The second operand", "Always false", "Always true"),
                "The first (falsy) operand",
                "Logical AND `&&` short-circuits and returns the first falsy operand value."));
        list.add(new Question("JS_E_33", cat, "Easy",
                "What does the logical OR operator `||` return if the first operand is truthy?",
                Arrays.asList("The first (truthy) operand", "The second operand", "Always true", "Boolean true"),
                "The first (truthy) operand",
                "Logical OR `||` short-circuits and returns the first truthy operand value."));
        list.add(new Question("JS_E_34", cat, "Easy",
                "In browser environments, which method selects a single DOM element by its unique ID?",
                Arrays.asList("document.getElementById()", "document.querySelectorID()", "document.getElementByClass()", "document.findId()"),
                "document.getElementById()",
                "document.getElementById('id') returns an Element object matching the specified ID string."));
        list.add(new Question("JS_E_35", cat, "Easy",
                "Which DOM method selects the FIRST element matching a specified CSS selector string?",
                Arrays.asList("document.querySelector()", "document.querySelectorAll()", "document.getElementsByTagName()", "document.select()"),
                "document.querySelector()",
                "document.querySelector() returns the first element matching the given CSS selector."));
        list.add(new Question("JS_E_36", cat, "Easy",
                "Which method registers an event listener callback function on a DOM element?",
                Arrays.asList("element.addEventListener()", "element.attachEvent()", "element.onEvent()", "element.listen()"),
                "element.addEventListener()",
                "addEventListener() sets up a function to be called whenever the target event is delivered."));
        list.add(new Question("JS_E_37", cat, "Easy",
                "Which Web Storage API mechanism persists stored key-value data across browser restarts until cleared?",
                Arrays.asList("localStorage", "sessionStorage", "cookieStorage", "tempStorage"),
                "localStorage",
                "localStorage persists data with no expiration time across browser sessions."));
        list.add(new Question("JS_E_38", cat, "Easy",
                "Which method stores a key-value pair in `localStorage`?",
                Arrays.asList("localStorage.setItem('key', 'value')", "localStorage.put('key', 'value')", "localStorage.add('key', 'value')", "localStorage.save('key', 'value')"),
                "localStorage.setItem('key', 'value')",
                "localStorage.setItem(key, value) saves string key-value pairs."));
        list.add(new Question("JS_E_39", cat, "Easy",
                "Which block catches runtime exceptions thrown inside a `try` block?",
                Arrays.asList("catch", "except", "finally", "handle"),
                "catch",
                "The `catch` block executes if an exception is thrown inside the preceding `try` block."));
        list.add(new Question("JS_E_40", cat, "Easy",
                "Which keyword is used to manually throw a user-defined exception in JavaScript?",
                Arrays.asList("throw", "raise", "error", "return"),
                "throw",
                "The `throw` statement throws a user-defined exception."));
        list.add(new Question("JS_E_41", cat, "Easy",
                "What are the three possible states of a JavaScript Promise?",
                Arrays.asList("pending, fulfilled, rejected", "started, running, finished", "waiting, resolved, failed", "open, active, closed"),
                "pending, fulfilled, rejected",
                "A Promise is always in one of three states: pending, fulfilled, or rejected."));
        list.add(new Question("JS_E_42", cat, "Easy",
                "Which method handles the successful fulfillment of a Promise?",
                Arrays.asList(".then()", ".catch()", ".finally()", ".done()"),
                ".then()",
                "The .then() method attaches callbacks for the resolution of a Promise."));
        list.add(new Question("JS_E_43", cat, "Easy",
                "An `async` function always returns which type of object?",
                Arrays.asList("Promise", "Generator", "Callback", "Observable"),
                "Promise",
                "Async functions always return a Promise implicitly or explicitly."));
        list.add(new Question("JS_E_44", cat, "Easy",
                "Which ES module keyword exports a single primary value or component from a module file?",
                Arrays.asList("export default", "export main", "export primary", "default send"),
                "export default",
                "export default specifies the default fallback export of an ES module."));
        list.add(new Question("JS_E_45", cat, "Easy",
                "Which directive string enables Strict Mode in a JavaScript file or function?",
                Arrays.asList("\"use strict\";", "\"strict mode\";", "\"enable strict\";", "\"use strictness\";"),
                "\"use strict\";",
                "The pragma string \"use strict\"; enforces strict parsing and error handling."));
        list.add(new Question("JS_E_46", cat, "Easy",
                "What is the result of `3 ** 2` in JavaScript?",
                Arrays.asList("9", "6", "8", "1.5"),
                "9",
                "The exponentiation operator ** raises the first operand to the power of the second operand (3^2 = 9)."));
        list.add(new Question("JS_E_47", cat, "Easy",
                "Which operator syntax `...` spreads array elements or merges objects?",
                Arrays.asList("Spread syntax", "Rest parameter", "Dot operator", "Concat operator"),
                "Spread syntax",
                "The spread operator `...` unpacks elements of an iterable array or object properties."));
        list.add(new Question("JS_E_48", cat, "Easy",
                "Which array method checks if at least one element in an array passes a test function?",
                Arrays.asList("some()", "every()", "find()", "includes()"),
                "some()",
                "some() tests whether at least one element in the array passes the provided callback test."));
        list.add(new Question("JS_E_49", cat, "Easy",
                "Which array method checks if ALL elements in an array pass a test function?",
                Arrays.asList("every()", "some()", "filter()", "map()"),
                "every()",
                "every() returns true if all array elements satisfy the test callback condition."));
        list.add(new Question("JS_E_50", cat, "Easy",
                "What type of object does `fetch(url)` return in modern browser environments?",
                Arrays.asList("Promise resolving to a Response object", "JSON string", "XMLHttpRequest object", "Text stream"),
                "Promise resolving to a Response object",
                "fetch() returns a Promise that fulfills with the Response object representing the HTTP response."));
    }

    private static void loadMedium(List<Question> list, String cat) {
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
    }

    private static void loadHard(List<Question> list, String cat) {
        list.add(new Question("JS_H_01", cat, "Hard",
                "What is the exact console output order of the following code?\n```js\nconsole.log(1);\nsetTimeout(() => console.log(2), 0);\nPromise.resolve().then(() => console.log(3));\nconsole.log(4);\n```",
                Arrays.asList("1, 4, 3, 2", "1, 2, 3, 4", "1, 3, 4, 2", "1, 4, 2, 3"),
                "1, 4, 3, 2",
                "Synchronous code runs first (1, 4), then Microtasks run (Promise .then: 3), then Macrotasks run (setTimeout: 2)."));
        list.add(new Question("JS_H_02", cat, "Hard",
                "What is the output order of this code?\n```js\nsetTimeout(() => console.log('A'), 0);\nPromise.resolve().then(() => {\n  console.log('B');\n  Promise.resolve().then(() => console.log('C'));\n});\nconsole.log('D');\n```",
                Arrays.asList("D, B, C, A", "D, A, B, C", "D, B, A, C", "B, C, D, A"),
                "D, B, C, A",
                "Sync code prints D. The microtask queue processes 'B', which queues microtask 'C'. Microtasks drain completely before Macrotask 'A'."));
        list.add(new Question("JS_H_03", cat, "Hard",
                "What is the output of the following code?\n```js\nfor (var i = 0; i < 3; i++) {\n  setTimeout(() => console.log(i), 100);\n}\n```",
                Arrays.asList("3, 3, 3", "0, 1, 2", "undefined, undefined, undefined", "0, 0, 0"),
                "3, 3, 3",
                "Because 'var' is function-scoped, all three timer callbacks close over the same shared variable 'i' which equals 3 post-loop."));
        list.add(new Question("JS_H_04", cat, "Hard",
                "What is the output when changing `var` to `let` in the loop?\n```js\nfor (let i = 0; i < 3; i++) {\n  setTimeout(() => console.log(i), 100);\n}\n```",
                Arrays.asList("0, 1, 2", "3, 3, 3", "2, 1, 0", "0, 0, 0"),
                "0, 1, 2",
                "Each iteration of a 'for' loop with 'let' creates a new lexical block binding, capturing current iteration value (0, 1, 2)."));
        list.add(new Question("JS_H_05", cat, "Hard",
                "What is the output of this code?\n```js\nconst obj = {\n  num: 42,\n  getNum: function() {\n    return this.num;\n  }\n};\nconst f = obj.getNum;\nconsole.log(f());\n``` in non-strict browser mode.",
                Arrays.asList("undefined", "42", "TypeError", "null"),
                "undefined",
                "Detaching method `obj.getNum` to `f` invokes `f()` as a plain function where `this` refers to global object, where `num` is undefined."));
        list.add(new Question("JS_H_06", cat, "Hard",
                "What is the output of this code?\n```js\nconst obj = {\n  num: 42,\n  getNum: () => {\n    return this.num;\n  }\n};\nconsole.log(obj.getNum());\n``` in global module scope where globalThis.num is undefined.",
                Arrays.asList("undefined", "42", "TypeError", "ReferenceError"),
                "undefined",
                "Arrow functions capture `this` from enclosing scope (global), ignoring object invocation caller `obj`."));
        list.add(new Question("JS_H_07", cat, "Hard",
                "What is the result of `[] + {}` in JavaScript?",
                Arrays.asList("\"[object Object]\"", "NaN", "0", "TypeError"),
                "\"[object Object]\"",
                "Array [] converts to empty string ''; object {} converts to '[object Object]'; string concatenation yields '[object Object]'."));
        list.add(new Question("JS_H_08", cat, "Hard",
                "What is the result of `{}` in statement context followed by `+ []` -> `{} + []` evaluated as expression in JS console?",
                Arrays.asList("0", "\"[object Object]\"", "NaN", "undefined"),
                "0",
                "In statement context, `{}` is parsed as an empty block statement; `+ []` coerces empty array to number 0."));
        list.add(new Question("JS_H_09", cat, "Hard",
                "What does `true + false` evaluate to?",
                Arrays.asList("1", "truefalse", "NaN", "0"),
                "1",
                "Numeric addition coerces boolean true -> 1 and false -> 0, yielding 1 + 0 = 1."));
        list.add(new Question("JS_H_10", cat, "Hard",
                "What is the result of `NaN === NaN` in JavaScript?",
                Arrays.asList("false", "true", "TypeError", "undefined"),
                "false",
                "In JavaScript, IEEE 754 standard defines NaN as non-equal to everything, including itself (NaN === NaN is false)."));
        list.add(new Question("JS_H_11", cat, "Hard",
                "How can you accurately check if a variable `x` is strictly `NaN`?",
                Arrays.asList("Number.isNaN(x)", "x === NaN", "typeof x === 'NaN'", "isNaN(x) for all strings"),
                "Number.isNaN(x)",
                "Number.isNaN(x) checks if x is type Number and value NaN without false positives from global isNaN coercion."));
        list.add(new Question("JS_H_12", cat, "Hard",
                "What is the output of the following code?\n```js\nfunction Person() {}\nPerson.prototype.age = 30;\nconst p1 = new Person();\nPerson.prototype = { age: 40 };\nconst p2 = new Person();\nconsole.log(p1.age, p2.age);\n```",
                Arrays.asList("30 40", "40 40", "30 30", "undefined 40"),
                "30 40",
                "p1 retains pointer reference to original prototype object (age: 30); p2 gets assigned newly replaced prototype object (age: 40)."));
        list.add(new Question("JS_H_13", cat, "Hard",
                "What happens when accessing a property on an object that exists neither on the object nor anywhere on its prototype chain?",
                Arrays.asList("Returns undefined", "Throws ReferenceError", "Throws TypeError", "Returns null"),
                "Returns undefined",
                "Traversing prototype chain up to Object.prototype.__proto__ (null) returns undefined for missing properties."));
        list.add(new Question("JS_H_14", cat, "Hard",
                "What is the output of this code?\n```js\nasync function foo() {\n  console.log(1);\n  await null;\n  console.log(2);\n}\nconsole.log(3);\nfoo();\nconsole.log(4);\n```",
                Arrays.asList("3, 1, 4, 2", "1, 3, 4, 2", "3, 1, 2, 4", "1, 2, 3, 4"),
                "3, 1, 4, 2",
                "prints 3; foo() starts synchronously printing 1; `await null` pauses foo() queuing microtask; prints 4; microtask executes printing 2."));
        list.add(new Question("JS_H_15", cat, "Hard",
                "What is the output of this code?\n```js\nPromise.resolve(1)\n  .then(x => x + 1)\n  .then(x => { throw new Error('My Error'); })\n  .catch(() => 100)\n  .then(x => console.log(x));\n```",
                Arrays.asList("100", "2", "Error printed to console", "undefined"),
                "100",
                "The thrown error bypasses subsequent thens and hits `.catch()`, which returns resolved 100 passed to next `.then()`."));
        list.add(new Question("JS_H_16", cat, "Hard",
                "What is the output of this generator invocation?\n```js\nfunction* gen() {\n  const x = yield 10;\n  yield x + 5;\n}\nconst g = gen();\nconsole.log(g.next().value);\nconsole.log(g.next(20).value);\n```",
                Arrays.asList("10 then 25", "10 then 15", "10 then undefined", "20 then 25"),
                "10 then 25",
                "First `next()` yields 10. Second `next(20)` passes 20 as return value of `yield 10` expression, so `x` becomes 20 -> `yield 25`."));
        list.add(new Question("JS_H_17", cat, "Hard",
                "What happens when modifying `obj.a = 2` when created via `Object.defineProperty(obj, 'a', { value: 1, writable: false });` in strict mode?",
                Arrays.asList("Throws TypeError", "Silently updates value to 2", "Silently ignores edit", "Deletes property a"),
                "Throws TypeError",
                "Attempting to write to a non-writable property in Strict Mode throws a TypeError."));
        list.add(new Question("JS_H_18", cat, "Hard",
                "What is the output of this code?\n```js\nconst obj = {\n  log: ['a', 'b'],\n  get latest() {\n    return this.log[this.log.length - 1];\n  }\n};\nconsole.log(obj.latest);\n```",
                Arrays.asList("'b'", "['a', 'b']", "undefined", "Function latest"),
                "'b'",
                "Getter `latest` executes automatically as property access without parenthesis, returning last item 'b'."));
        list.add(new Question("JS_H_19", cat, "Hard",
                "Which technique optimizes recursive calls in supporting engines to prevent call stack growth?",
                Arrays.asList("Proper Tail Call (PTC) optimization", "Memoization", "Debouncing", "Currying"),
                "Proper Tail Call (PTC) optimization",
                "Tail Call Optimization reuses current stack frame if recursive call is in tail position."));
        list.add(new Question("JS_H_20", cat, "Hard",
                "What is function currying in JavaScript?",
                Arrays.asList("Transforming a function with multiple arguments into a sequence of functions each taking a single argument", "Converting sync functions to async", "Binding this context", "Memoizing return values"),
                "Transforming a function with multiple arguments into a sequence of functions each taking a single argument",
                "Currying translates `f(a, b, c)` into callable chain `f(a)(b)(c)`."));
        list.add(new Question("JS_H_21", cat, "Hard",
                "Why are keys in a `WeakMap` NOT enumerable via methods like `Object.keys()`?",
                Arrays.asList("Non-enumerability prevents non-deterministic behavior caused by unpredictable garbage collector runs", "Because keys are strings", "WeakMap is asynchronous", "Engine limitation"),
                "Non-enumerability prevents non-deterministic behavior caused by unpredictable garbage collector runs",
                "Exposing WeakMap keys would introduce non-determinism based on when GC sweeps collect unreferenced objects."));
        list.add(new Question("JS_H_22", cat, "Hard",
                "Are exported variables in ES Modules live bindings or static value copies?",
                Arrays.asList("Live bindings (importers see real-time value updates made inside exporting module)", "Static copies", "Clones created on import", "Read-only constants"),
                "Live bindings (importers see real-time value updates made inside exporting module)",
                "ES module exports are live bindings; mutations inside the source module are reflected across all importing modules."));
        list.add(new Question("JS_H_23", cat, "Hard",
                "Which prefix syntax designates a private class field/method in modern ES2022 JavaScript?",
                Arrays.asList("# (hash prefix e.g. #privateField)", "_ (underscore prefix)", "private keyword", "protected keyword"),
                "# (hash prefix e.g. #privateField)",
                "The `#` prefix creates hard private class fields inaccessible outside the class body."));
        list.add(new Question("JS_H_24", cat, "Hard",
                "Which native modern JavaScript method creates a deep clone of a complex object containing nested objects, dates, and arrays?",
                Arrays.asList("structuredClone(obj)", "Object.assign({}, obj)", "JSON.parse(JSON.stringify(obj)) for functions", "obj.clone()"),
                "structuredClone(obj)",
                "structuredClone() creates deep copies of structured data including cyclic references, ArrayBuffers, Dates, and Maps."));
        list.add(new Question("JS_H_25", cat, "Hard",
                "Which type of value CANNOT be cloned using `structuredClone()`?",
                Arrays.asList("Functions and DOM elements", "Dates and RegExp", "Maps and Sets", "ArrayBuffers"),
                "Functions and DOM elements",
                "structuredClone() throws DataCloneError if attempting to clone Functions or DOM nodes."));
        list.add(new Question("JS_H_26", cat, "Hard",
                "When an object has `[Symbol.toPrimitive](hint)` defined, what hints can JavaScript pass to this method during coercion?",
                Arrays.asList("'number', 'string', or 'default'", "'boolean', 'object', or 'function'", "'float', 'int', or 'text'", "'primitive' or 'reference'"),
                "'number', 'string', or 'default'",
                "The JS coercion engine passes string hints 'number', 'string', or 'default'."));
        list.add(new Question("JS_H_27", cat, "Hard",
                "What is the key difference between `Promise.any()` and `Promise.race()`?",
                Arrays.asList("`Promise.any()` ignores rejections and resolves with first FULFILLED promise; `Promise.race()` settles on first promise to settle (fulfill OR reject)", "`Promise.race()` ignores rejections", "`Promise.any()` requires all to fulfill", "They perform identical functions"),
                "`Promise.any()` ignores rejections and resolves with first FULFILLED promise; `Promise.race()` settles on first promise to settle (fulfill OR reject)",
                "Promise.any fulfills on first fulfillment (rejecting with AggregateError if all reject); Promise.race settles on first settled item."));
        list.add(new Question("JS_H_28", cat, "Hard",
                "When does `Promise.any()` reject with an `AggregateError`?",
                Arrays.asList("When ALL promises in the input iterable reject", "When the first promise rejects", "When given an empty array", "When promise times out"),
                "When ALL promises in the input iterable reject",
                "Promise.any() throws AggregateError wrapping individual rejection reasons when every input promise fails."));
        list.add(new Question("JS_H_29", cat, "Hard",
                "In node/browser environments, what happens if a microtask recursively queues another microtask infinitely?",
                Arrays.asList("The microtask queue starves the Macrotask queue, freezing I/O and UI rendering indefinitely", "The event loop skips microtasks and runs Macrotasks", "Engine throws Stack Overflow error instantly", "Web Worker handles it"),
                "The microtask queue starves the Macrotask queue, freezing I/O and UI rendering indefinitely",
                "Microtask queue must drain completely before event loop moves on; recursive microtasks block rendering and macrotask execution."));
        list.add(new Question("JS_H_30", cat, "Hard",
                "What is a primary difference between JavaScript `Set` and `Map`/`Object`?",
                Arrays.asList("`Set` stores unique values of any type with no key-value pairing", "`Set` key lookup is O(N)", "`Set` accepts duplicate primitive values", "`Set` keys must be strings"),
                "`Set` stores unique values of any type with no key-value pairing",
                "Set is a collection of unique values without distinct keys."));
        list.add(new Question("JS_H_31", cat, "Hard",
                "What occurs when executing `class MyArray extends Array {}` and calling `new MyArray().slice()` in ES6?",
                Arrays.asList("Returns an instance of `MyArray` (using Symbol.species)", "Returns standard Array instance", "Throws TypeError", "Returns null"),
                "Returns an instance of `MyArray` (using Symbol.species)",
                "Built-in array methods like slice use `[Symbol.species]` to instantiate derived class `MyArray` objects."));
        list.add(new Question("JS_H_32", cat, "Hard",
                "What is `globalThis` in modern ECMAScript?",
                Arrays.asList("A standardized universal global object reference available across browser window, Web Workers, and Node.js environments", "A replacement for local this", "An alias for strict mode", "A DOM element pointer"),
                "A standardized universal global object reference available across browser window, Web Workers, and Node.js environments",
                "globalThis provides a unified standard property for accessing global scope across any JavaScript execution platform."));
        list.add(new Question("JS_H_33", cat, "Hard",
                "How do you attach an underlying cause error when re-throwing an error in ES2022?",
                Arrays.asList("throw new Error('Failed operation', { cause: originalError });", "throw new Error('Failed', originalError);", "throw new Error('Failed').cause(originalError);", "throw Error.withCause(msg, err);"),
                "throw new Error('Failed operation', { cause: originalError });",
                "ES2022 introduced options object `{ cause: err }` parameter to Error constructors for chained error diagnostics."));
        list.add(new Question("JS_H_34", cat, "Hard",
                "What does `[10, 20, 30].at(-1)` return in modern JavaScript?",
                Arrays.asList("30", "undefined", "10", "SyntaxError"),
                "30",
                ".at(index) accepts negative integers to count back from the last item (-1 returns last item 30)."));
        list.add(new Question("JS_H_35", cat, "Hard",
                "Where is top-level `await` allowed without wrapping inside an `async` function in modern JS?",
                Arrays.asList("At the top level of ES Modules (.mjs / type=\"module\")", "Inside traditional CommonJS scripts", "Inside standard HTML inline event handlers", "Inside synchronous constructors"),
                "At the top level of ES Modules (.mjs / type=\"module\")",
                "Top-level await is valid at top level of ES modules."));
        list.add(new Question("JS_H_36", cat, "Hard",
                "What is the result of `Object.is(-0, +0)` compared to `-0 === +0`?",
                Arrays.asList("`Object.is(-0, +0)` is false; `-0 === +0` is true", "Both are true", "Both are false", "`Object.is(-0, +0)` is true"),
                "`Object.is(-0, +0)` is false; `-0 === +0` is true",
                "Object.is differentiates -0 and +0 (returns false), whereas strict equality === treats them as equal (returns true)."));
        list.add(new Question("JS_H_37", cat, "Hard",
                "What is a 'trap' in JavaScript Proxy objects?",
                Arrays.asList("A method that intercepts and customizes internal object operations (e.g., get, set, deleteProperty)", "An unhandled runtime error", "A private property guard", "A memory leak"),
                "A method that intercepts and customizes internal object operations (e.g., get, set, deleteProperty)",
                "Proxy traps intercept low-level object target operations."));
        list.add(new Question("JS_H_38", cat, "Hard",
                "How do you create a Proxy that can be turned off/disabled later?",
                Arrays.asList("Proxy.revocable(target, handler)", "new Proxy(target, handler).revoke()", "Object.freeze(proxy)", "Proxy.disable(proxy)"),
                "Proxy.revocable(target, handler)",
                "Proxy.revocable returns object `{ proxy, revoke }` allowing invocation of `revoke()` to disable proxy access."));
        list.add(new Question("JS_H_39", cat, "Hard",
                "What is the purpose of the `Atomics` object in multi-threaded JavaScript (Web Workers)?",
                Arrays.asList("Provides atomic operations for shared memory across threads to prevent race conditions", "Creates atomic DOM elements", "Handles JSON parsing", "Executes garbage collection"),
                "Provides atomic operations for shared memory across threads to prevent race conditions",
                "Atomics ensures memory operations on SharedArrayBuffer instances occur predictably without thread race collisions."));
        list.add(new Question("JS_H_40", cat, "Hard",
                "What does `.toString()` return on a function in modern ES2019+?",
                Arrays.asList("Exact source code text representation including comments and whitespace", "Stripped code without comments", "[object Function]", "Compiled bytecode"),
                "Exact source code text representation including comments and whitespace",
                "ES2019 updated `Function.prototype.toString()` to return exact source code slice including white-space and comments."));
        list.add(new Question("JS_H_41", cat, "Hard",
                "What is the result of `'5'.padStart(3, '0')`?",
                Arrays.asList("'005'", "'500'", "'05'", "'50'"),
                "'005'",
                "padStart(targetLength, padString) pads current string from start until target length 3 is met ('005')."));
        list.add(new Question("JS_H_42", cat, "Hard",
                "How do you declare a `BigInt` primitive literal representing arbitrary precision integers?",
                Arrays.asList("12345678901234567890n (with trailing 'n')", "BigInt('123')i", "12345678901234567890L", "#12345678901234567890"),
                "12345678901234567890n (with trailing 'n')",
                "Appending trailing `n` to an integer literal constructs a BigInt primitive."));
        list.add(new Question("JS_H_43", cat, "Hard",
                "What happens when performing `10n + 5` (mixing BigInt and Number)?",
                Arrays.asList("Throws TypeError", "Returns 15n", "Returns 15", "Coerces to String"),
                "Throws TypeError",
                "JavaScript forbids mixing BigInt and Number types implicitly in arithmetic operations, throwing TypeError."));
        list.add(new Question("JS_H_44", cat, "Hard",
                "What does `x ||= y` do in ES2021?",
                Arrays.asList("Assigns `y` to `x` ONLY IF `x` is falsy (`x || (x = y)`)", "Assigns y to x only if x is nullish", "Assigns y to x always", "Compares x and y"),
                "Assigns `y` to `x` ONLY IF `x` is falsy (`x || (x = y)`)",
                "Logical OR assignment `x ||= y` assigns y to x if x evaluates to falsy."));
        list.add(new Question("JS_H_45", cat, "Hard",
                "What does `x ??= y` do in ES2021?",
                Arrays.asList("Assigns `y` to `x` ONLY IF `x` is nullish (null or undefined)", "Assigns y to x if x is false", "Assigns y to x if x is 0", "Throws SyntaxError"),
                "Assigns `y` to `x` ONLY IF `x` is nullish (null or undefined)",
                "Nullish logical assignment `x ??= y` assigns y to x only if x is null or undefined."));
        list.add(new Question("JS_H_46", cat, "Hard",
                "What is the purpose of `WeakRef` introduced in ES2021?",
                Arrays.asList("Holds a weak reference to a target object without preventing that target object from being garbage collected", "Creates hard clones of objects", "Improves array sort speed", "Prevents memory leaks in strings"),
                "Holds a weak reference to a target object without preventing that target object from being garbage collected",
                "WeakRef lets developers hold weak object references that don't protect target objects from GC removal."));
        list.add(new Question("JS_H_47", cat, "Hard",
                "What is the purpose of `FinalizationRegistry` in ES2021?",
                Arrays.asList("Allows registering a cleanup callback triggered after a target object has been garbage collected", "Clears localStorage automatically", "Halts thread execution on exit", "Registers DOM custom elements"),
                "Allows registering a cleanup callback triggered after a target object has been garbage collected",
                "FinalizationRegistry provides callbacks notifying when registered objects get swept by garbage collector."));
        list.add(new Question("JS_H_48", cat, "Hard",
                "What does `Object.groupBy(array, callback)` return in modern ES2024 JavaScript?",
                Arrays.asList("An object with null-prototype containing properties grouping array items by callback string return keys", "A Set of grouped arrays", "A nested Array", "A Map object"),
                "An object with null-prototype containing properties grouping array items by callback string return keys",
                "Object.groupBy groups items into an object whose keys are returned from the group criteria callback."));
        list.add(new Question("JS_H_49", cat, "Hard",
                "What feature does the RegExp `v` flag (UnicodeSets) enable in modern JS?",
                Arrays.asList("Enables set operations (intersection, subtraction) inside character classes in regular expressions", "Validates JSON strings", "Enables verbose logging", "Disables backtracking"),
                "Enables set operations (intersection, subtraction) inside character classes in regular expressions",
                "The `v` flag extends regex character classes to support set difference, intersection, and nested classes."));
        list.add(new Question("JS_H_50", cat, "Hard",
                "Why is the modern `Temporal` API replacing legacy `Date` object in JavaScript?",
                Arrays.asList("Provides immutable date-time objects, handles timezones explicitly, and eliminates zero-based month bugs", "Runs on GPU", "Date object is deprecated in Node", "Temporal supports 64-bit strings"),
                "Provides immutable date-time objects, handles timezones explicitly, and eliminates zero-based month bugs",
                "Temporal provides a robust modern specification for date/time computations, overcoming Date's mutability and timezone pitfalls."));
    }
}
