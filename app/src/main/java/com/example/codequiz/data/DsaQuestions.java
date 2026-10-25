package com.example.codequiz.data;

import com.example.codequiz.model.Question;
import com.example.codequiz.util.AppConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DsaQuestions {

    public static List<Question> get() {
        List<Question> list = new ArrayList<>();
        String cat = AppConstants.CAT_DSA;

        // --- EASY (17) ---
        list.add(new Question("DSA_01", cat, "Easy",
                "Which data structure operates on a Last-In, First-Out (LIFO) basis?",
                Arrays.asList("Stack", "Queue", "Array", "Linked List"),
                "Stack", "A Stack adheres to the Last-In, First-Out (LIFO) principle (e.g. call stack, undo operations)."));

        list.add(new Question("DSA_02", cat, "Easy",
                "Which data structure operates on a First-In, First-Out (FIFO) basis?",
                Arrays.asList("Queue", "Stack", "Binary Tree", "Heap"),
                "Queue", "A Queue processes elements in First-In, First-Out (FIFO) order (e.g. printer spooler, task queues)."));

        list.add(new Question("DSA_03", cat, "Easy",
                "What is the average time complexity of accessing an element in an array by its index?",
                Arrays.asList("O(1)", "O(n)", "O(log n)", "O(n^2)"),
                "O(1)", "Direct indexing in contiguous memory calculates the exact element address in constant time O(1)."));

        list.add(new Question("DSA_04", cat, "Easy",
                "What is the time complexity of searching an element in an unsorted array of size n?",
                Arrays.asList("O(n)", "O(1)", "O(log n)", "O(n log n)"),
                "O(n)", "Linear search in an unsorted array must inspect up to n elements in the worst case."));

        list.add(new Question("DSA_05", cat, "Easy",
                "What is the best-case time complexity of Binary Search on a sorted array?",
                Arrays.asList("O(1)", "O(log n)", "O(n)", "O(n log n)"),
                "O(1)", "In the best case, the target element is located at the exact middle index on the first comparison."));

        list.add(new Question("DSA_06", cat, "Easy",
                "What is the worst-case time complexity of Binary Search on a sorted array of size n?",
                Arrays.asList("O(log n)", "O(n)", "O(n log n)", "O(1)"),
                "O(log n)", "Binary search halves the search range with each step, yielding logarithmic O(log n) time."));

        list.add(new Question("DSA_07", cat, "Easy",
                "In a singly linked list, what does each node contain?",
                Arrays.asList("Data and a reference/pointer to the next node", "Data only", "Pointers to parent and child", "Indices of all elements"),
                "Data and a reference/pointer to the next node", "Each singly linked list node encapsulates a data payload and a pointer to the subsequent node."));

        list.add(new Question("DSA_08", cat, "Easy",
                "What is the maximum number of children a node can have in a Binary Tree?",
                Arrays.asList("2", "1", "3", "Unlimited"),
                "2", "By definition, nodes in a binary tree can have at most two children (left and right)."));

        list.add(new Question("DSA_09", cat, "Easy",
                "What is the term for a node in a tree that has no children?",
                Arrays.asList("Leaf node", "Root node", "Internal node", "Sibling node"),
                "Leaf node", "A leaf (or external) node is any node in a tree that has no child nodes."));

        list.add(new Question("DSA_10", cat, "Easy",
                "Which operation inserts an element onto the top of a stack?",
                Arrays.asList("push", "pop", "enqueue", "dequeue"),
                "push", "The push operation inserts a new item onto the top of the stack."));

        list.add(new Question("DSA_11", cat, "Easy",
                "Which operation removes and returns the top element of a stack?",
                Arrays.asList("pop", "push", "peek", "poll"),
                "pop", "The pop operation removes and returns the most recently pushed element."));

        list.add(new Question("DSA_12", cat, "Easy",
                "Which operation adds an item to the rear of a queue?",
                Arrays.asList("enqueue", "dequeue", "push", "pop"),
                "enqueue", "Enqueue inserts a new item at the tail (back) of the queue."));

        list.add(new Question("DSA_13", cat, "Easy",
                "What is the worst-case time complexity of Bubble Sort?",
                Arrays.asList("O(n^2)", "O(n log n)", "O(n)", "O(log n)"),
                "O(n^2)", "Bubble sort compares all adjacent pairs iteratively, resulting in O(n^2) comparisons."));

        list.add(new Question("DSA_14", cat, "Easy",
                "What is the top-most node of a tree hierarchy called?",
                Arrays.asList("Root", "Stem", "Head", "Peak"),
                "Root", "The root is the starting ancestor node from which all other nodes descend."));

        list.add(new Question("DSA_15", cat, "Easy",
                "Which of the following is a non-linear data structure?",
                Arrays.asList("Tree", "Array", "Linked List", "Queue"),
                "Tree", "Trees and Graphs are non-linear data structures because elements are arranged hierarchically or interconnectedly."));

        list.add(new Question("DSA_16", cat, "Easy",
                "What does 'FIFO' stand for in computer science?",
                Arrays.asList("First-In, First-Out", "Fast Input, Fast Output", "File Input, File Output", "First Index, Final Output"),
                "First-In, First-Out", "FIFO stands for First-In, First-Out, characteristic of queue structures."));

        list.add(new Question("DSA_17", cat, "Easy",
                "What is the space complexity of an iterative linear search algorithm?",
                Arrays.asList("O(1)", "O(n)", "O(log n)", "O(n^2)"),
                "O(1)", "Iterative linear search requires only a few index variables, using auxiliary space O(1)."));

        // --- MEDIUM (17) ---
        list.add(new Question("DSA_18", cat, "Medium",
                "What is the average and worst-case time complexity of Merge Sort?",
                Arrays.asList("O(n log n) in all cases", "O(n log n) average, O(n^2) worst", "O(n) average, O(n log n) worst", "O(log n) in all cases"),
                "O(n log n) in all cases", "Merge Sort consistently divides the array in half and merges sorted halves in O(n log n) time."));

        list.add(new Question("DSA_19", cat, "Medium",
                "What is the worst-case time complexity of Quick Sort and when does it occur?",
                Arrays.asList("O(n^2), when the chosen pivot is consistently the smallest or largest element", "O(n log n), when elements are identical", "O(n^3), on empty arrays", "O(log n), on sorted arrays"),
                "O(n^2), when the chosen pivot is consistently the smallest or largest element", "Unbalanced partitions (e.g. sorting an already sorted array with the first element as pivot) degrade Quick Sort to O(n^2)."));

        list.add(new Question("DSA_20", cat, "Medium",
                "What property distinguishes a Binary Search Tree (BST)?",
                Arrays.asList("Left subtree keys are less than node key; right subtree keys are greater", "Every node must have exactly two children", "All leaves must be on same level", "Parent nodes are smaller than both children"),
                "Left subtree keys are less than node key; right subtree keys are greater", "In a BST, all keys in the left subtree are smaller than the node, and all in the right subtree are greater."));

        list.add(new Question("DSA_21", cat, "Medium",
                "Which graph traversal algorithm uses a Queue and visits nodes level by level?",
                Arrays.asList("Breadth-First Search (BFS)", "Depth-First Search (DFS)", "Dijkstra's Algorithm", "Kruskal's Algorithm"),
                "Breadth-First Search (BFS)", "BFS explores nodes layer by layer using a FIFO queue to hold discovered neighbors."));

        list.add(new Question("DSA_22", cat, "Medium",
                "Which graph traversal algorithm uses a Stack (or recursion) to explore as deep as possible?",
                Arrays.asList("Depth-First Search (DFS)", "Breadth-First Search (BFS)", "Prim's Algorithm", "Topological Sort"),
                "Depth-First Search (DFS)", "DFS progresses along each path as far as possible before backtracking using a LIFO stack."));

        list.add(new Question("DSA_23", cat, "Medium",
                "What tree traversal visits nodes in the order: Left Subtree, Root, Right Subtree?",
                Arrays.asList("In-order traversal", "Pre-order traversal", "Post-order traversal", "Level-order traversal"),
                "In-order traversal", "In-order traversal (Left, Root, Right) processes keys in ascending order on a Binary Search Tree."));

        list.add(new Question("DSA_24", cat, "Medium",
                "What is a Min-Heap binary tree property?",
                Arrays.asList("The key of each node is less than or equal to the keys of its children; root is minimum", "The root is maximum", "All left nodes are greater than right nodes", "Height is always 0"),
                "The key of each node is less than or equal to the keys of its children; root is minimum", "In a min-heap, every parent is smaller than or equal to its children, placing the smallest item at the root."));

        list.add(new Question("DSA_25", cat, "Medium",
                "What is the average time complexity of lookup, insert, and delete in a Hash Table?",
                Arrays.asList("O(1)", "O(n)", "O(log n)", "O(n log n)"),
                "O(1)", "With a good hash function and reasonable load factor, hash table operations average O(1) constant time."));

        list.add(new Question("DSA_26", cat, "Medium",
                "What is the two-pointer technique frequently used for in algorithmic problems?",
                Arrays.asList("Traversing arrays or strings simultaneously from different directions or speeds (e.g. palindrome check, cycle detection)", "Allocating 2D arrays on heap", "Doubling array capacity", "Resolving hash collisions"),
                "Traversing arrays or strings simultaneously from different directions or speeds (e.g. palindrome check, cycle detection)", "Two pointers (opposite ends or fast/slow runner) reduce time complexity from O(n^2) to O(n) for many array problems."));

        list.add(new Question("DSA_27", cat, "Medium",
                "What algorithm detects a cycle in a linked list using slow and fast pointers?",
                Arrays.asList("Floyd's Tortoise and Hare Cycle-Finding Algorithm", "Dijkstra's Algorithm", "Bellman-Ford Algorithm", "Kadane's Algorithm"),
                "Floyd's Tortoise and Hare Cycle-Finding Algorithm", "Floyd's cycle detection moves one pointer at 1x speed and another at 2x speed; if they meet, a cycle exists."));

        list.add(new Question("DSA_28", cat, "Medium",
                "What is the purpose of Kadane's Algorithm?",
                Arrays.asList("Finding the maximum subarray sum in O(n) linear time", "Sorting numbers in O(n) time", "Finding the shortest path in a graph", "Inverting a binary tree"),
                "Finding the maximum subarray sum in O(n) linear time", "Kadane's algorithm computes the contiguous subarray with the largest sum in a single pass O(n)."));

        list.add(new Question("DSA_29", cat, "Medium",
                "What is an AVL Tree in data structures?",
                Arrays.asList("A self-balancing Binary Search Tree where the heights of the two child subtrees differ by at most 1", "An array-based heap", "A tree with at most 3 children", "A trie used for spell-checking"),
                "A self-balancing Binary Search Tree where the heights of the two child subtrees differ by at most 1", "AVL trees maintain balance factors (-1, 0, +1) using tree rotations, guaranteeing O(log n) worst-case lookups."));

        list.add(new Question("DSA_30", cat, "Medium",
                "What is the time complexity of Dijkstra's algorithm implemented with a binary min-heap?",
                Arrays.asList("O((V + E) log V)", "O(V^3)", "O(E log E)", "O(V^2)"),
                "O((V + E) log V)", "With an adjacency list and min-heap priority queue, Dijkstra's single-source shortest path runs in O((V + E) log V)."));

        list.add(new Question("DSA_31", cat, "Medium",
                "What is Dynamic Programming (DP) and what two key attributes must a problem possess to apply DP?",
                Arrays.asList("Optimal Substructure and Overlapping Subproblems", "Sorted data and balanced trees", "Greedy choice and recursion only", "Linear arrays and prime numbers"),
                "Optimal Substructure and Overlapping Subproblems", "Dynamic Programming breaks problems down into overlapping subproblems, memoizing or tabulating optimal solutions."));

        list.add(new Question("DSA_32", cat, "Medium",
                "What is the difference between Memoization (Top-Down) and Tabulation (Bottom-Up) in DP?",
                Arrays.asList("Memoization caches recursive call results; Tabulation iteratively fills an array starting from base cases", "Memoization is iterative; Tabulation is recursive", "Tabulation requires more memory always", "They are identical"),
                "Memoization caches recursive call results; Tabulation iteratively fills an array starting from base cases", "Top-down memoization stores results of recursive invocations, whereas bottom-up tabulation builds solutions iteratively."));

        list.add(new Question("DSA_33", cat, "Medium",
                "What is a Trie (Prefix Tree) data structure most efficiently used for?",
                Arrays.asList("Fast string retrieval, prefix matching, and autocomplete search dictionaries", "Sorting integers in descending order", "Balancing binary trees", "Graph shortest path calculations"),
                "Fast string retrieval, prefix matching, and autocomplete search dictionaries", "Tries store keys along tree paths where edges represent characters, allowing O(L) prefix queries where L is string length."));

        list.add(new Question("DSA_34", cat, "Medium",
                "What is the time complexity to insert an element into an existing Binary Heap of size n?",
                Arrays.asList("O(log n)", "O(1)", "O(n)", "O(n log n)"),
                "O(log n)", "Inserting into a binary heap places the element at the leaf and bubbles it up (heapify-up) at most the height of the tree: O(log n)."));

        // --- HARD (16) ---
        list.add(new Question("DSA_35", cat, "Hard",
                "What are the 5 invariant properties of a Red-Black Tree?",
                Arrays.asList("Nodes are Red/Black; Root is Black; Leaves (NIL) are Black; Red nodes have Black children; Equal Black-height on all paths", "All nodes are red; leaves are black", "Left nodes are black; right nodes are red", "No node can have black children"),
                "Nodes are Red/Black; Root is Black; Leaves (NIL) are Black; Red nodes have Black children; Equal Black-height on all paths", "Red-black trees maintain balanced O(log n) height using these 5 color invariants and rotational restructuring."));

        list.add(new Question("DSA_36", cat, "Hard",
                "What is the Disjoint Set Union (DSU / Union-Find) algorithm with path compression and rank optimization time complexity?",
                Arrays.asList("Nearly O(1) amortized: O(α(n)) where α is the Inverse Ackermann function", "O(log n)", "O(n)", "O(n log n)"),
                "Nearly O(1) amortized: O(α(n)) where α is the Inverse Ackermann function", "Union-Find with path compression and union by rank runs in O(α(n)) time per operation, which is effectively constant for all practical n."));

        list.add(new Question("DSA_37", cat, "Hard",
                "What does the Knuth-Morris-Pratt (KMP) string matching algorithm achieve?",
                Arrays.asList("Searches for occurrences of a pattern in text in O(n + m) time using a Longest Prefix Suffix (LPS) array", "Sorts strings in O(n) time", "Compresses strings with Huffman coding", "Reverses text without extra space"),
                "Searches for occurrences of a pattern in text in O(n + m) time using a Longest Prefix Suffix (LPS) array", "KMP avoids backtracking in the text string by precomputing failure shifts in the pattern's LPS array."));

        list.add(new Question("DSA_38", cat, "Hard",
                "What algorithm finds Strongly Connected Components (SCCs) in a directed graph in linear O(V + E) time?",
                Arrays.asList("Tarjan's or Kosaraju's Algorithm", "Kruskal's Algorithm", "Prim's Algorithm", "Floyd-Warshall Algorithm"),
                "Tarjan's or Kosaraju's Algorithm", "Tarjan's algorithm uses DFS with node low-link values and a stack to find all SCCs in a single pass O(V + E)."));

        list.add(new Question("DSA_39", cat, "Hard",
                "What is a Segment Tree and what operations does it perform in O(log n) time?",
                Arrays.asList("Range queries (sum, min, max) and point updates over an array in O(log n) time", "Sorting an array", "Reversing a linked list", "Finding all pairs shortest path"),
                "Range queries (sum, min, max) and point updates over an array in O(log n) time", "Segment trees represent intervals, allowing dynamic range queries and point/range updates in logarithmic time."));

        list.add(new Question("DSA_40", cat, "Hard",
                "What is the difference between Kruskal's and Prim's algorithms for finding a Minimum Spanning Tree (MST)?",
                Arrays.asList("Kruskal's grows the MST by adding lowest-weight edges using DSU; Prim's grows a single tree vertex by vertex", "Prim's finds shortest paths, Kruskal's finds cycles", "Kruskal's only works on directed graphs", "Prim's does not find a minimum spanning tree"),
                "Kruskal's grows the MST by adding lowest-weight edges using DSU; Prim's grows a single tree vertex by vertex", "Kruskal's sorts all edges globally and uses Union-Find; Prim's starts from a root node and greedily expands using a priority queue."));

        list.add(new Question("DSA_41", cat, "Hard",
                "What is the time complexity of the Floyd-Warshall algorithm for All-Pairs Shortest Paths?",
                Arrays.asList("O(V^3)", "O(V^2 log V)", "O(V * E)", "O(V + E)"),
                "O(V^3)", "Floyd-Warshall solves all-pairs shortest paths on dense graphs using triple nested dynamic programming loops in O(V^3) time."));

        list.add(new Question("DSA_42", cat, "Hard",
                "What is a Fenwick Tree (Binary Indexed Tree / BIT)?",
                Arrays.asList("A compact array-based data structure that computes prefix sums and updates elements in O(log n) time", "A binary search tree with red and black nodes", "A graph representation matrix", "A heap with 4 children"),
                "A compact array-based data structure that computes prefix sums and updates elements in O(log n) time", "A Fenwick tree uses bitwise manipulation of least significant bits (x & -x) to store prefix sums in O(n) space."));

        list.add(new Question("DSA_43", cat, "Hard",
                "What is the Bellman-Ford algorithm used for that Dijkstra's algorithm cannot handle?",
                Arrays.asList("Finding shortest paths on graphs with negative edge weights and detecting negative weight cycles", "Running faster on positive graphs", "Finding maximum spanning tree", "Topological sorting"),
                "Finding shortest paths on graphs with negative edge weights and detecting negative weight cycles", "Bellman-Ford relaxes all edges V-1 times and detects negative cycles, which cause Dijkstra to fail."));

        list.add(new Question("DSA_44", cat, "Hard",
                "What is the purpose of Topological Sort on a graph and on what type of graphs does it work?",
                Arrays.asList("Linear ordering of vertices such that for every directed edge u -> v, u comes before v; requires a DAG", "Ordering tree nodes by height", "Sorting undirected cyclic graphs", "Balancing AVL trees"),
                "Linear ordering of vertices such that for every directed edge u -> v, u comes before v; requires a DAG", "Topological sort orders tasks with dependencies and is valid only on Directed Acyclic Graphs (DAGs)."));

        list.add(new Question("DSA_45", cat, "Hard",
                "What is A* (A-Star) Search Algorithm and how does its heuristic function h(n) guide search?",
                Arrays.asList("Combines cost from start g(n) with admissible heuristic estimate to goal h(n): f(n) = g(n) + h(n)", "Ignores edge costs and explores purely greedy", "Uses genetic algorithms", "Runs random walks"),
                "Combines cost from start g(n) with admissible heuristic estimate to goal h(n): f(n) = g(n) + h(n)", "A* prioritizes nodes with lowest f(n) = g(n) + h(n); if h(n) is admissible (never overestimates), optimality is guaranteed."));

        list.add(new Question("DSA_46", cat, "Hard",
                "What is the Ford-Fulkerson (Edmonds-Karp) algorithm used for in network flow?",
                Arrays.asList("Computing the Maximum Flow from source to sink in a flow network", "Finding the minimum spanning tree", "Sorting vertices in flow order", "Balancing network packets"),
                "Computing the Maximum Flow from source to sink in a flow network", "The Max-Flow Min-Cut theorem powers Edmonds-Karp, finding augmenting paths using BFS in O(V * E^2) time."));

        list.add(new Question("DSA_47", cat, "Hard",
                "What is a Suffix Automaton / Suffix Tree in advanced string processing?",
                Arrays.asList("A compact representation of all suffixes of a string, allowing sub-string queries and distinct substring counts in O(n) time", "A parser for HTML tags", "A compression tool for binary files", "A spelling checker only"),
                "A compact representation of all suffixes of a string, allowing sub-string queries and distinct substring counts in O(n) time", "Ukkonen's algorithm constructs Suffix Trees in linear O(n) time and space for sophisticated string processing."));

        list.add(new Question("DSA_48", cat, "Hard",
                "What is Master Theorem used for in algorithm analysis?",
                Arrays.asList("Solving divide-and-conquer recurrence relations of the form T(n) = a*T(n/b) + f(n)", "Proving NP-completeness", "Calculating amortized stack bounds", "Measuring cache miss rates"),
                "Solving divide-and-conquer recurrence relations of the form T(n) = a*T(n/b) + f(n)", "The Master Theorem provides asymptotic time bounds by comparing f(n) to n^(log_b a)."));

        list.add(new Question("DSA_49", cat, "Hard",
                "What is the difference between NP, NP-Complete, and NP-Hard problems in computational complexity?",
                Arrays.asList("NP problems have solutions verifiable in polynomial time; NP-Complete is both in NP and at least as hard as all NP; NP-Hard may not be in NP", "NP means non-polynomial execution only", "NP-Complete problems are solved in O(n)", "There is no formal difference"),
                "NP problems have solutions verifiable in polynomial time; NP-Complete is both in NP and at least as hard as all NP; NP-Hard may not be in NP", "Cook-Levin theorem established that any NP problem can be reduced in polynomial time to an NP-complete problem."));

        list.add(new Question("DSA_50", cat, "Hard",
                "What is Monotonic Stack/Queue and what classic problems does it solve in O(n) time?",
                Arrays.asList("Maintains elements in strictly increasing or decreasing order; solves Next Greater Element and Sliding Window Maximum", "A queue that cannot pop items", "A stack stored on external hard drives", "A tree balance algorithm"),
                "Maintains elements in strictly increasing or decreasing order; solves Next Greater Element and Sliding Window Maximum", "Monotonic stacks prune irrelevant elements to resolve nearest larger/smaller neighbor queries in linear time."));

        return list;
    }
}
