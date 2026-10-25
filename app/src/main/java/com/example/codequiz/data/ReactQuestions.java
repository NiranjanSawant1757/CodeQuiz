package com.example.codequiz.data;

import com.example.codequiz.model.Question;
import com.example.codequiz.util.AppConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReactQuestions {

    public static List<Question> get() {
        List<Question> list = new ArrayList<>();
        String cat = AppConstants.CAT_REACT;

        // --- EASY (17) ---
        list.add(new Question("REACT_01", cat, "Easy",
                "What is React primarily categorized as?",
                Arrays.asList("A JavaScript library for building user interfaces", "A full-stack backend framework", "A relational database management system", "A CSS preprocessor"),
                "A JavaScript library for building user interfaces", "React is an open-source, component-based frontend JavaScript library developed by Meta."));

        list.add(new Question("REACT_02", cat, "Easy",
                "What syntax extension to JavaScript is commonly used with React to write HTML-like markup?",
                Arrays.asList("JSX", "XML", "HTML5", "TypeScript"),
                "JSX", "JSX (JavaScript XML) is a syntax extension that allows writing HTML-like markup inside JavaScript."));

        list.add(new Question("REACT_03", cat, "Easy",
                "Which React hook is used to declare and manage state in functional components?",
                Arrays.asList("useState", "useEffect", "useReducer", "useRef"),
                "useState", "The useState hook adds state variables to React functional components."));

        list.add(new Question("REACT_04", cat, "Easy",
                "What are 'props' in React?",
                Arrays.asList("Inputs passed from parent components to child components", "Internal mutable component state", "CSS styles applied to components", "Database connection objects"),
                "Inputs passed from parent components to child components", "Props (short for properties) are read-only inputs passed down the component tree."));

        list.add(new Question("REACT_05", cat, "Easy",
                "Are React 'props' mutable or immutable inside the receiving child component?",
                Arrays.asList("Immutable (read-only)", "Mutable directly", "Mutable only with let", "Mutable if component is class"),
                "Immutable (read-only)", "React components must act like pure functions with respect to their props; props cannot be modified directly."));

        list.add(new Question("REACT_06", cat, "Easy",
                "What must be the casing of custom React component names?",
                Arrays.asList("PascalCase (Capitalized first letter)", "camelCase", "snake_case", "kebab-case"),
                "PascalCase (Capitalized first letter)", "React treats lowercase tags as built-in DOM elements (<div>, <p>) and capitalized names as custom components (<MyComponent />)."));

        list.add(new Question("REACT_07", cat, "Easy",
                "Which command creates a new React application using the standard Vite template?",
                Arrays.asList("npm create vite@latest", "npm start react", "react new app", "git clone react"),
                "npm create vite@latest", "Vite is the modern, recommended tool for scaffolding fast React frontend projects."));

        list.add(new Question("REACT_08", cat, "Easy",
                "What is a React Fragment ('<></>' or '<React.Fragment>') used for?",
                Arrays.asList("Grouping multiple elements without adding an extra node to the DOM", "Splitting code into multiple chunks", "Creating animated transitions", "Connecting to a database"),
                "Grouping multiple elements without adding an extra node to the DOM", "Fragments let you return multiple adjacent JSX elements without wrapping them in an extra <div>."));

        list.add(new Question("REACT_09", cat, "Easy",
                "Which hook performs side effects (such as data fetching or subscriptions) in functional components?",
                Arrays.asList("useEffect", "useState", "useContext", "useMemo"),
                "useEffect", "useEffect handles side effects after rendering, replacing lifecycle methods like componentDidMount and componentDidUpdate."));

        list.add(new Question("REACT_10", cat, "Easy",
                "What attribute must be provided to list items rendered via '.map()' to help React identify changes?",
                Arrays.asList("key", "id", "index", "ref"),
                "key", "A unique 'key' prop helps React identify which items have changed, been added, or been removed."));

        list.add(new Question("REACT_11", cat, "Easy",
                "How do you pass a string prop 'title' with value 'Dashboard' to a component in JSX?",
                Arrays.asList("<Header title=\"Dashboard\" />", "<Header title={Dashboard} />", "<Header [title]=\"Dashboard\" />", "<Header (title)=\"Dashboard\" />"),
                "<Header title=\"Dashboard\" />", "String literal props can be passed directly inside double quotes in JSX."));

        list.add(new Question("REACT_12", cat, "Easy",
                "What is the Virtual DOM in React?",
                Arrays.asList("A lightweight in-memory representation of the real DOM tree", "A 3D graphics rendering engine", "A virtual machine running React bytecode", "A browser extension"),
                "A lightweight in-memory representation of the real DOM tree", "The Virtual DOM is an in-memory tree of JS objects synced with the real DOM via reconciliation."));

        list.add(new Question("REACT_13", cat, "Easy",
                "Which lifecycle stage occurs when a component is first inserted into the DOM tree?",
                Arrays.asList("Mounting", "Updating", "Unmounting", "Hydration"),
                "Mounting", "Mounting is the phase where a component instance is created and inserted into the DOM."));

        list.add(new Question("REACT_14", cat, "Easy",
                "What hook is used to access React Context values without passing props down manually?",
                Arrays.asList("useContext", "useProvider", "useConsumer", "useState"),
                "useContext", "useContext accepts a context object created by React.createContext and returns the current context value."));

        list.add(new Question("REACT_15", cat, "Easy",
                "In JSX, which attribute replaces the standard HTML 'class' attribute?",
                Arrays.asList("className", "classList", "classId", "cssClass"),
                "className", "Because 'class' is a reserved keyword in JavaScript, JSX uses 'className'."));

        list.add(new Question("REACT_16", cat, "Easy",
                "How do you pass inline CSS styles to a JSX element?",
                Arrays.asList("style={{ color: 'red', fontSize: '16px' }}", "style=\"color: red; font-size: 16px;\"", "css=\"color: red\"", "styles={color: 'red'}"),
                "style={{ color: 'red', fontSize: '16px' }}", "Inline styles in JSX require a JavaScript object with camelCased property names passed inside double curly braces."));

        list.add(new Question("REACT_17", cat, "Easy",
                "What is the purpose of React Developer Tools browser extension?",
                Arrays.asList("Inspect component hierarchy, state, props, and performance profiling", "Edit database queries", "Compile React to WebAssembly", "Simulate mobile screen sizes"),
                "Inspect component hierarchy, state, props, and performance profiling", "React DevTools allows developers to inspect React component trees, props, hooks, and re-renders."));

        // --- MEDIUM (17) ---
        list.add(new Question("REACT_18", cat, "Medium",
                "What does an empty dependency array '[]' in 'useEffect(callback, [])' signify?",
                Arrays.asList("The effect runs only once after the initial render (mount)", "The effect runs on every render", "The effect never runs", "The effect only runs on unmount"),
                "The effect runs only once after the initial render (mount)", "Passing [] tells React that your effect doesn’t depend on any values from props or state, so it executes once on mount."));

        list.add(new Question("REACT_19", cat, "Medium",
                "How do you execute a cleanup function in 'useEffect' (e.g., removing event listeners)?",
                Arrays.asList("Return a function from inside the useEffect callback", "Call useEffectCleanup()", "Pass null as second argument", "Use window.onbeforeunload"),
                "Return a function from inside the useEffect callback", "React runs the returned cleanup function before the component unmounts and before re-running the effect on dependency change."));

        list.add(new Question("REACT_20", cat, "Medium",
                "What is a Controlled Component in React form handling?",
                Arrays.asList("A form element whose value is controlled and driven by React state", "A component wrapped in an error boundary", "A read-only input component", "A component rendered on the server"),
                "A form element whose value is controlled and driven by React state", "An input whose value is bound to state and updated via an onChange handler is a controlled component."));

        list.add(new Question("REACT_21", cat, "Medium",
                "What does 'useRef' return and how does mutating '.current' differ from 'useState'?",
                Arrays.asList("Returns a mutable ref object whose '.current' mutation does NOT trigger a re-render", "Returns a state value that forces an immediate re-render", "Returns a DOM selector query", "Returns a frozen immutable copy"),
                "Returns a mutable ref object whose '.current' mutation does NOT trigger a re-render", "useRef persists values across renders without causing component re-renders when modified, and is also used to reference DOM elements."));

        list.add(new Question("REACT_22", cat, "Medium",
                "What is the primary purpose of 'useMemo' hook?",
                Arrays.asList("Memoize expensive calculation results and recompute only when specified dependencies change", "Cache API responses in IndexedDB", "Store session tokens in cookies", "Prevent component unmounting"),
                "Memoize expensive calculation results and recompute only when specified dependencies change", "useMemo caches the result of a calculation between renders until dependencies update."));

        list.add(new Question("REACT_23", cat, "Medium",
                "What does 'useCallback' memoize compared to 'useMemo'?",
                Arrays.asList("useCallback memoizes the callback function instance itself; useMemo memoizes the computed return value", "useCallback memoizes DOM nodes", "useCallback is for async functions only", "There is no difference"),
                "useCallback memoizes the callback function instance itself; useMemo memoizes the computed return value", "useCallback(fn, deps) is equivalent to useMemo(() => fn, deps), preserving function references to avoid child re-renders."));

        list.add(new Question("REACT_24", cat, "Medium",
                "What is Prop Drilling in React applications?",
                Arrays.asList("Passing props through multiple intermediate components that do not need them just to reach a deeply nested child", "Drilling down into the DOM directly", "Validating props with TypeScript", "Converting props into local state"),
                "Passing props through multiple intermediate components that do not need them just to reach a deeply nested child", "Prop drilling can make code hard to maintain, solved with Context API, composition, or state management libraries."));

        list.add(new Question("REACT_25", cat, "Medium",
                "What is the purpose of 'React.memo' Higher-Order Component?",
                Arrays.asList("Prevents a component from re-rendering if its props have not changed (shallow comparison)", "Memoizes state updates", "Converts functional components to class components", "Caches HTTP requests"),
                "Prevents a component from re-rendering if its props have not changed (shallow comparison)", "React.memo skips rendering the component if its props are equal to previous props."));

        list.add(new Question("REACT_26", cat, "Medium",
                "What is the Reconciliation algorithm in React?",
                Arrays.asList("The diffing process React uses to compare the new Virtual DOM tree with the previous one and compute minimal DOM mutations", "Matching database records", "Resolving merge conflicts in Git", "Binding events to window"),
                "The diffing process React uses to compare the new Virtual DOM tree with the previous one and compute minimal DOM mutations", "Reconciliation calculates the minimum number of changes required to update the actual browser DOM efficiently."));

        list.add(new Question("REACT_27", cat, "Medium",
                "What is an Error Boundary in React?",
                Arrays.asList("A class component implementing componentDidCatch / getDerivedStateFromError to catch JavaScript errors anywhere in its child tree", "A try/catch block inside JSX", "A network interceptor", "A form validation hook"),
                "A class component implementing componentDidCatch / getDerivedStateFromError to catch JavaScript errors anywhere in its child tree", "Error boundaries catch render errors in their child component tree, log them, and display a fallback UI instead of crashing the whole app."));

        list.add(new Question("REACT_28", cat, "Medium",
                "Why should you never call React Hooks inside loops, conditions, or nested functions?",
                Arrays.asList("React relies on the call order of hooks remaining strictly identical on every render", "It causes syntax errors in JavaScript", "Loops delete the component state", "Hooks only work inside async functions"),
                "React relies on the call order of hooks remaining strictly identical on every render", "The Rules of Hooks ensure that hooks are called in the exact same sequence on each render, allowing React to correctly pair state with hooks."));

        list.add(new Question("REACT_29", cat, "Medium",
                "What is 'useReducer' and when is it preferred over 'useState'?",
                Arrays.asList("A hook for complex state logic involving multiple sub-values or when the next state depends on the previous one", "A hook for reducing bundle size", "A hook for deleting database records", "A hook for optimizing images"),
                "A hook for complex state logic involving multiple sub-values or when the next state depends on the previous one", "useReducer follows the Redux reducer pattern ((state, action) => newState), ideal for intricate state transitions."));

        list.add(new Question("REACT_30", cat, "Medium",
                "What does 'React.lazy' combined with 'Suspense' achieve?",
                Arrays.asList("Enables dynamic code-splitting by rendering components lazily on demand with fallback loading UI", "Runs React in web workers", "Suspends user input events", "Delays app initial load"),
                "Enables dynamic code-splitting by rendering components lazily on demand with fallback loading UI", "React.lazy lets you define a component that is loaded dynamically, deferring loading until first rendered with <Suspense fallback={...}>."));

        list.add(new Question("REACT_31", cat, "Medium",
                "What is a Custom Hook in React?",
                Arrays.asList("A JavaScript function starting with 'use' that can call other built-in React hooks to extract reusable component logic", "A third-party npm package only", "A hook for server-side APIs", "A CSS styling preprocessor"),
                "A JavaScript function starting with 'use' that can call other built-in React hooks to extract reusable component logic", "Custom hooks share stateful logic across multiple components without duplicating code."));

        list.add(new Question("REACT_32", cat, "Medium",
                "What is the difference between an Uncontrolled Component and a Controlled Component?",
                Arrays.asList("Uncontrolled components store their own state in the DOM using refs; controlled components store state in React state", "Uncontrolled components cannot have buttons", "Controlled components do not support validation", "They are identical"),
                "Uncontrolled components store their own state in the DOM using refs; controlled components store state in React state", "In uncontrolled components, form data is handled by the DOM itself via useRef rather than by state handlers."));

        list.add(new Question("REACT_33", cat, "Medium",
                "Why should array indices generally be avoided as 'key' props if items can be reordered, inserted, or deleted?",
                Arrays.asList("It causes component state mismatches and visual bugs during reordering", "It throws a compilation error", "Index keys make the page freeze", "React cannot render arrays with number keys"),
                "It causes component state mismatches and visual bugs during reordering", "When list items reorder or are inserted at the beginning, index-based keys confuse React's diffing, associating state with the wrong items."));

        list.add(new Question("REACT_34", cat, "Medium",
                "What is React Portal ('ReactDOM.createPortal') used for?",
                Arrays.asList("Rendering children into a DOM node that exists outside the DOM hierarchy of the parent component (e.g. modals)", "Routing between pages", "Establishing WebRTC socket connections", "Encrypting cookies"),
                "Rendering children into a DOM node that exists outside the DOM hierarchy of the parent component (e.g. modals)", "Portals provide a first-class way to render children into an alternate DOM subtree (like document.body for modals and tooltips)."));

        // --- HARD (16) ---
        list.add(new Question("REACT_35", cat, "Hard",
                "What is the React Fiber architecture introduced in React 16?",
                Arrays.asList("A complete rewrite of React's core reconciliation algorithm enabling incremental rendering, pausing, and prioritizing work", "A CSS-in-JS framework", "A high-speed fiber-optic network driver", "A replacement for JSX"),
                "A complete rewrite of React's core reconciliation algorithm enabling incremental rendering, pausing, and prioritizing work", "Fiber broke render work into units of work that can be paused, aborted, or prioritized, paving the way for Concurrent React."));

        list.add(new Question("REACT_36", cat, "Hard",
                "What is Concurrent Mode / Concurrent Rendering in React 18?",
                Arrays.asList("React can interrupt, pause, or resume rendering in the background without blocking the main browser thread", "Running multiple React apps on different threads", "Multi-process server clusters", "Automated database migrations"),
                "React can interrupt, pause, or resume rendering in the background without blocking the main browser thread", "Concurrent React enables non-blocking rendering, prioritizing urgent updates (user typing) over non-urgent transitions (search results)."));

        list.add(new Question("REACT_37", cat, "Hard",
                "What does 'useTransition' hook provide in React 18?",
                Arrays.asList("Allows marking certain state updates as non-urgent transitions so urgent interactions remain responsive", "Animates CSS opacity transitions", "Transfers state across browser tabs", "Translates UI strings to other languages"),
                "Allows marking certain state updates as non-urgent transitions so urgent interactions remain responsive", "startTransition lets you designate slower updates (like filtering lists) as transitions, keeping inputs responsive."));

        list.add(new Question("REACT_38", cat, "Hard",
                "What does 'useDeferredValue' do in React 18?",
                Arrays.asList("Defers updating a value so that more urgent render updates can finish first, showing stale value until ready", "Creates a setTimeout delay", "Cancels state updates", "Saves values to local storage"),
                "Defers updating a value so that more urgent render updates can finish first, showing stale value until ready", "useDeferredValue accepts a value and returns a deferred copy of that value that lags behind during urgent updates."));

        list.add(new Question("REACT_39", cat, "Hard",
                "What is Server-Side Rendering (SSR) vs Static Site Generation (SSG) in React frameworks like Next.js?",
                Arrays.asList("SSR generates HTML on each client request; SSG generates static HTML once at build time", "SSR is on client; SSG is on server", "SSG cannot contain JavaScript", "There is no functional difference"),
                "SSR generates HTML on each client request; SSG generates static HTML once at build time", "SSR renders HTML per-request on the server, while SSG pre-renders pages at build time for high CDN caching speed."));

        list.add(new Question("REACT_40", cat, "Hard",
                "What is Hydration in React SSR?",
                Arrays.asList("Attaching event listeners and React runtime state to pre-rendered server HTML in the browser DOM", "Injecting CSS into the header", "Loading images progressively", "Clearing browser cache"),
                "Attaching event listeners and React runtime state to pre-rendered server HTML in the browser DOM", "Hydration transforms static server-rendered HTML into an interactive React application by attaching handlers."));

        list.add(new Question("REACT_41", cat, "Hard",
                "What is the role of 'useId' hook introduced in React 18?",
                Arrays.asList("Generating unique, accessible IDs that are guaranteed stable between server and client rendering to prevent hydration mismatches", "Generating UUIDs for database rows", "Retrieving user login ID", "Encrypting session tokens"),
                "Generating unique, accessible IDs that are guaranteed stable between server and client rendering to prevent hydration mismatches", "useId generates unique IDs for accessibility attributes (aria-describedby) without causing SSR hydration mismatches."));

        list.add(new Question("REACT_42", cat, "Hard",
                "What is Automatic Batching in React 18?",
                Arrays.asList("Grouping all state updates inside promises, timeouts, and native event handlers into a single re-render automatically", "Compiling components together in webpack", "Batching API calls over HTTP/2", "Packaging CSS files"),
                "Grouping all state updates inside promises, timeouts, and native event handlers into a single re-render automatically", "Before React 18, only React events were batched. React 18 batches state updates across async callbacks by default."));

        list.add(new Question("REACT_43", cat, "Hard",
                "What is 'useImperativeHandle' hook and when is it paired with 'forwardRef'?",
                Arrays.asList("Customizes the instance value and methods exposed to a parent component when using a ref", "Forces an immediate synchronous state update", "Overrides component props", "Accesses global window variables"),
                "Customizes the instance value and methods exposed to a parent component when using a ref", "useImperativeHandle lets child components expose a restricted set of methods (e.g., focus(), scroll()) to parent refs."));

        list.add(new Question("REACT_44", cat, "Hard",
                "What is 'useLayoutEffect' and how does its timing differ from 'useEffect'?",
                Arrays.asList("Fires synchronously after all DOM mutations but BEFORE the browser paints the screen to measure layout", "Fires after screen paint", "Runs only on server", "Runs in a separate web worker"),
                "Fires synchronously after all DOM mutations but BEFORE the browser paints the screen to measure layout", "useLayoutEffect blocks the browser from painting until it finishes, preventing visual layout flickers when reading layout."));

        list.add(new Question("REACT_45", cat, "Hard",
                "What are React Server Components (RSC)?",
                Arrays.asList("Components that execute exclusively on the server, have zero client bundle impact, and can access backend resources directly", "Components running inside Node.js Express routes", "Components written in C++", "Microservices for web sockets"),
                "Components that execute exclusively on the server, have zero client bundle impact, and can access backend resources directly", "RSC render only on the server, returning a lightweight serialized representation rather than JS bundles."));

        list.add(new Question("REACT_46", cat, "Hard",
                "What does 'useSyncExternalStore' hook do in React 18?",
                Arrays.asList("Allows state management libraries to subscribe to external stores in a way compatible with concurrent rendering, preventing tearing", "Syncs data to Google Drive", "Syncs cookies across subdomains", "Syncs client time with NTP servers"),
                "Allows state management libraries to subscribe to external stores in a way compatible with concurrent rendering, preventing tearing", "useSyncExternalStore prevents visual tearing (inconsistent UI state) when reading non-React external stores concurrently."));

        list.add(new Question("REACT_47", cat, "Hard",
                "What is the function of 'flushSync' in React?",
                Arrays.asList("Forces React to flush pending updates synchronously and update the DOM immediately, opting out of batching", "Clears the browser cache", "Deletes unmounted components", "Flushes indexedDB storage"),
                "Forces React to flush pending updates synchronously and update the DOM immediately, opting out of batching", "flushSync forces synchronous re-renders, useful when immediate DOM measurements are required right after a state update."));

        list.add(new Question("REACT_48", cat, "Hard",
                "What is 'Strict Mode' in React and why does it invoke certain lifecycles/effects twice in development?",
                Arrays.asList("Highlights potential side-effect bugs and missing cleanups by intentionally mounting and remounting components in development", "Enforces TypeScript type safety", "Disallows inline styling", "Minifies code in development"),
                "Highlights potential side-effect bugs and missing cleanups by intentionally mounting and remounting components in development", "React Strict Mode runs setup+cleanup cycles twice in development to find improper side effects and memory leaks."));

        list.add(new Question("REACT_49", cat, "Hard",
                "What is the difference between Shallow Routing and Full Navigation in React single-page apps?",
                Arrays.asList("Shallow routing updates the URL without re-running data fetching methods or remounting page components", "Shallow routing reloads the entire browser window", "Full navigation only works in development", "There is no difference"),
                "Shallow routing updates the URL without re-running data fetching methods or remounting page components", "Shallow routing updates window history and path without triggering heavy full page data re-fetching."));

        list.add(new Question("REACT_50", cat, "Hard",
                "How does React's synthetic event system differ from native browser events?",
                Arrays.asList("Wraps native events in a cross-browser wrapper with consistent properties and delegates them to the root container", "Synthetic events do not support stopPropagation", "Synthetic events only work in Chrome", "Native events cannot be accessed"),
                "Wraps native events in a cross-browser wrapper with consistent properties and delegates them to the root container", "React delegates synthetic events at the root node for performance and standardizes behavior across diverse browsers."));

        return list;
    }
}
