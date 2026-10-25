package com.example.codequiz.data;

import com.example.codequiz.model.Question;
import com.example.codequiz.util.AppConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SqlQuestions {

    public static List<Question> get() {
        List<Question> list = new ArrayList<>();
        String cat = AppConstants.CAT_SQL;

        // --- EASY (17) ---
        list.add(new Question("SQL_01", cat, "Easy",
                "What does the acronym SQL stand for?",
                Arrays.asList("Structured Query Language", "Simple Question Language", "Standard Query Level", "Sequential Query Language"),
                "Structured Query Language", "SQL stands for Structured Query Language, the standard language for relational databases."));

        list.add(new Question("SQL_02", cat, "Easy",
                "Which SQL statement is used to retrieve data from a database table?",
                Arrays.asList("SELECT", "GET", "FETCH", "OPEN"),
                "SELECT", "The SELECT statement retrieves rows and columns from one or more database tables."));

        list.add(new Question("SQL_03", cat, "Easy",
                "Which SQL clause is used to filter records based on specified conditions?",
                Arrays.asList("WHERE", "FILTER", "HAVING", "LIMIT"),
                "WHERE", "The WHERE clause filters rows meeting given criteria before grouping or returning results."));

        list.add(new Question("SQL_04", cat, "Easy",
                "Which SQL command is used to insert new rows into a table?",
                Arrays.asList("INSERT INTO", "ADD ROW", "NEW ENTRY", "UPDATE"),
                "INSERT INTO", "INSERT INTO table_name (cols) VALUES (vals) adds new rows to a table."));

        list.add(new Question("SQL_05", cat, "Easy",
                "Which SQL command modifies existing data within a table?",
                Arrays.asList("UPDATE", "MODIFY", "SAVE", "CHANGE"),
                "UPDATE", "The UPDATE statement modifies values in existing table rows."));

        list.add(new Question("SQL_06", cat, "Easy",
                "Which SQL command deletes rows from a table?",
                Arrays.asList("DELETE FROM", "REMOVE", "DROP", "TRUNCATE TABLE"),
                "DELETE FROM", "DELETE FROM table WHERE condition removes rows matching the condition."));

        list.add(new Question("SQL_07", cat, "Easy",
                "Which clause is used to sort the result-set in ascending or descending order?",
                Arrays.asList("ORDER BY", "SORT BY", "GROUP BY", "ARRANGE"),
                "ORDER BY", "ORDER BY sorts the result-set by one or more columns ascending (ASC) or descending (DESC)."));

        list.add(new Question("SQL_08", cat, "Easy",
                "What is the default sort order of an ORDER BY clause if unspecified?",
                Arrays.asList("ASC (Ascending)", "DESC (Descending)", "Random", "By primary key"),
                "ASC (Ascending)", "ORDER BY defaults to ascending (ASC) order."));

        list.add(new Question("SQL_09", cat, "Easy",
                "Which keyword is used to return only unique (distinct) values in a SELECT statement?",
                Arrays.asList("DISTINCT", "UNIQUE", "DIFFERENT", "SINGLE"),
                "DISTINCT", "SELECT DISTINCT removes duplicate rows from the resulting query."));

        list.add(new Question("SQL_10", cat, "Easy",
                "What is a PRIMARY KEY in a relational database table?",
                Arrays.asList("A column or set of columns that uniquely identifies each row in a table", "A password to open the database", "The first column in every table", "A foreign key to another table"),
                "A column or set of columns that uniquely identifies each row in a table", "A primary key enforces uniqueness and must not contain NULL values."));

        list.add(new Question("SQL_11", cat, "Easy",
                "Which aggregate function counts the total number of rows matching a query?",
                Arrays.asList("COUNT()", "SUM()", "TOTAL()", "NUMBER()"),
                "COUNT()", "COUNT() returns the number of rows matching the query criteria."));

        list.add(new Question("SQL_12", cat, "Easy",
                "Which aggregate function calculates the average value of a numeric column?",
                Arrays.asList("AVG()", "MEAN()", "AVERAGE()", "CALC()"),
                "AVG()", "AVG() calculates the arithmetic average of a numeric column."));

        list.add(new Question("SQL_13", cat, "Easy",
                "Which operator is used to search for a specified pattern in a column?",
                Arrays.asList("LIKE", "MATCH", "REGEX", "IN"),
                "LIKE", "The LIKE operator is used in a WHERE clause with wildcards (% and _) to search for patterns."));

        list.add(new Question("SQL_14", cat, "Easy",
                "Which wildcard in SQL represents zero, one, or multiple characters?",
                Arrays.asList("% (percent)", "_ (underscore)", "* (asterisk)", "? (question mark)"),
                "% (percent)", "% matches any sequence of zero or more characters in LIKE patterns."));

        list.add(new Question("SQL_15", cat, "Easy",
                "Which wildcard in SQL represents exactly one single character?",
                Arrays.asList("_ (underscore)", "% (percent)", ". (dot)", "# (hash)"),
                "_ (underscore)", "_ matches exactly one single character in standard SQL LIKE queries."));

        list.add(new Question("SQL_16", cat, "Easy",
                "Which constraint ensures that a column cannot have a NULL value?",
                Arrays.asList("NOT NULL", "NON NULL", "REQUIRED", "UNIQUE"),
                "NOT NULL", "The NOT NULL constraint enforces that a column will always accept a non-null value."));

        list.add(new Question("SQL_17", cat, "Easy",
                "Which command completely removes an entire table definition and its data from the database?",
                Arrays.asList("DROP TABLE", "DELETE TABLE", "TRUNCATE", "CLEAR TABLE"),
                "DROP TABLE", "DROP TABLE deletes the table schema, indexes, and all rows permanently."));

        // --- MEDIUM (17) ---
        list.add(new Question("SQL_18", cat, "Medium",
                "What is the difference between WHERE and HAVING clauses in SQL?",
                Arrays.asList("WHERE filters individual rows before grouping; HAVING filters aggregated groups after GROUP BY", "HAVING filters rows before grouping; WHERE after", "They are completely interchangeable", "HAVING is only for JOINs"),
                "WHERE filters individual rows before grouping; HAVING filters aggregated groups after GROUP BY", "WHERE filters source rows before aggregation; HAVING filters group rows based on aggregate functions like COUNT or SUM."));

        list.add(new Question("SQL_19", cat, "Medium",
                "What is the difference between INNER JOIN and LEFT (OUTER) JOIN?",
                Arrays.asList("INNER JOIN returns rows with matches in both tables; LEFT JOIN returns all rows from left table plus matching rows from right", "INNER JOIN returns all rows from both tables", "LEFT JOIN only returns unmatched rows", "There is no difference"),
                "INNER JOIN returns rows with matches in both tables; LEFT JOIN returns all rows from left table plus matching rows from right", "LEFT JOIN guarantees every row from the left table is returned, with NULLs for missing right table matches."));

        list.add(new Question("SQL_20", cat, "Medium",
                "What does the GROUP BY clause do in SQL?",
                Arrays.asList("Groups rows that have the same values in specified columns into summary rows", "Sorts table rows ascending", "Creates a temporary index", "Locks tables for reading"),
                "Groups rows that have the same values in specified columns into summary rows", "GROUP BY collates data into groups often used alongside aggregate functions (COUNT, MAX, MIN, AVG, SUM)."));

        list.add(new Question("SQL_21", cat, "Medium",
                "What is a FOREIGN KEY constraint?",
                Arrays.asList("A field in one table that uniquely identifies a row of another table, enforcing referential integrity", "A key for encrypting SQL databases", "An external database connection string", "A backup primary key"),
                "A field in one table that uniquely identifies a row of another table, enforcing referential integrity", "Foreign keys prevent actions that would destroy links between tables, enforcing referential integrity."));

        list.add(new Question("SQL_22", cat, "Medium",
                "What is the difference between TRUNCATE and DELETE in SQL?",
                Arrays.asList("TRUNCATE is a DDL command that deallocates pages and cannot be filtered with WHERE; DELETE is DML and removes row-by-row", "TRUNCATE is slower than DELETE", "DELETE resets auto-increment; TRUNCATE does not", "TRUNCATE deletes the table structure"),
                "TRUNCATE is a DDL command that deallocates pages and cannot be filtered with WHERE; DELETE is DML and removes row-by-row", "TRUNCATE quickly wipes all table data with minimal logging without firing row-level triggers, while DELETE deletes individual rows."));

        list.add(new Question("SQL_23", cat, "Medium",
                "What are the ACID properties in database management systems?",
                Arrays.asList("Atomicity, Consistency, Isolation, Durability", "Accuracy, Concurrency, Integrity, Durability", "Authentication, Consistency, Identity, Distribution", "Array, Cursor, Index, Data"),
                "Atomicity, Consistency, Isolation, Durability", "ACID guarantees that database transactions are processed reliably even in events of failures or crashes."));

        list.add(new Question("SQL_24", cat, "Medium",
                "What does the 'UNION' operator do compared to 'UNION ALL'?",
                Arrays.asList("UNION combines results removing duplicate rows; UNION ALL combines all rows including duplicates", "UNION ALL removes duplicates; UNION keeps them", "UNION operates only on one table", "UNION is faster than UNION ALL"),
                "UNION combines results removing duplicate rows; UNION ALL combines all rows including duplicates", "UNION incurs a distinct sorting step to eliminate duplicates, making UNION ALL faster when duplicates are acceptable or absent."));

        list.add(new Question("SQL_25", cat, "Medium",
                "What is a Database Index and what is its main trade-off?",
                Arrays.asList("A data structure (e.g. B-tree) that speeds up SELECT queries at the cost of additional storage and slower INSERT/UPDATE writes", "An automatic backup file", "A table primary key generator", "A network cache"),
                "A data structure (e.g. B-tree) that speeds up SELECT queries at the cost of additional storage and slower INSERT/UPDATE writes", "Indexes dramatically accelerate lookups but incur maintenance overhead on every write operation."));

        list.add(new Question("SQL_26", cat, "Medium",
                "What does the 'COALESCE()' function return in SQL?",
                Arrays.asList("The first non-null expression in its argument list", "The sum of all arguments", "The maximum number in a column", "A formatted string"),
                "The first non-null expression in its argument list", "COALESCE(val1, val2, ..., valN) evaluates the arguments in order and returns the first non-null value encountered."));

        list.add(new Question("SQL_27", cat, "Medium",
                "What is a Subquery (Nested Query) in SQL?",
                Arrays.asList("A query nested inside another SELECT, INSERT, UPDATE, or DELETE statement", "A stored procedure in database", "A query executed on a different server", "A database trigger"),
                "A query nested inside another SELECT, INSERT, UPDATE, or DELETE statement", "Subqueries provide dynamic intermediate values or record sets consumed by an outer query."));

        list.add(new Question("SQL_28", cat, "Medium",
                "What is the difference between CHAR and VARCHAR data types?",
                Arrays.asList("CHAR is fixed-length (padded with spaces); VARCHAR is variable-length up to the maximum specified size", "CHAR is variable; VARCHAR is fixed", "CHAR stores numbers only", "VARCHAR cannot store spaces"),
                "CHAR is fixed-length (padded with spaces); VARCHAR is variable-length up to the maximum specified size", "CHAR(10) always occupies 10 characters in storage; VARCHAR(10) uses only as many characters as entered plus length prefix."));

        list.add(new Question("SQL_29", cat, "Medium",
                "What does the 'EXISTS' operator test in a SQL subquery?",
                Arrays.asList("Tests whether the subquery returns any rows (evaluates to true or false)", "Checks if a table exists in database", "Counts rows in a table", "Verifies column data types"),
                "Tests whether the subquery returns any rows (evaluates to true or false)", "EXISTS returns true as soon as the inner query produces at least one matching record (short-circuiting)."));

        list.add(new Question("SQL_30", cat, "Medium",
                "What does the 'BETWEEN' operator include in SQL range queries?",
                Arrays.asList("Values within a range inclusive of both endpoints (start AND end)", "Values strictly between endpoints (exclusive)", "Only positive numbers", "Only date timestamps"),
                "Values within a range inclusive of both endpoints (start AND end)", "col BETWEEN a AND b is equivalent to col >= a AND col <= b."));

        list.add(new Question("SQL_31", cat, "Medium",
                "What is a Database View?",
                Arrays.asList("A virtual table based on the result-set of a stored SQL SELECT statement", "A graphical UI dashboard in database client", "A physical copy of a table on disk", "A read-only backup file"),
                "A virtual table based on the result-set of a stored SQL SELECT statement", "Views encapsulate complex queries into virtual tables without duplicating physical table data on disk."));

        list.add(new Question("SQL_32", cat, "Medium",
                "What is the purpose of the 'LIMIT' (or 'TOP') clause?",
                Arrays.asList("Constrains the maximum number of rows returned in the result set", "Sets a memory limit on query", "Caps the number of columns", "Restricts user query permissions"),
                "Constrains the maximum number of rows returned in the result set", "LIMIT n restricts the output to the first n rows matching query criteria (often paired with OFFSET for pagination)."));

        list.add(new Question("SQL_33", cat, "Medium",
                "What does 'ON DELETE CASCADE' do on a Foreign Key definition?",
                Arrays.asList("Automatically deletes child rows when the referenced parent row is deleted", "Prevents deletion of parent row", "Sets child foreign keys to NULL", "Rolls back the transaction"),
                "Automatically deletes child rows when the referenced parent row is deleted", "CASCADE propagates row deletions from parent table to all referencing child records automatically."));

        list.add(new Question("SQL_34", cat, "Medium",
                "What is a Database Trigger?",
                Arrays.asList("A procedural block of SQL code automatically executed in response to table events (INSERT, UPDATE, DELETE)", "A scheduled backup job", "A hardware interrupt", "A command line query runner"),
                "A procedural block of SQL code automatically executed in response to table events (INSERT, UPDATE, DELETE)", "Triggers fire automatically before or after DML operations to enforce business rules or maintain audit logs."));

        // --- HARD (16) ---
        list.add(new Question("SQL_35", cat, "Hard",
                "What is a Common Table Expression (CTE) defined with the 'WITH' clause?",
                Arrays.asList("A temporary named result set defined within the execution scope of a single SELECT, INSERT, UPDATE, or DELETE", "A permanent database table", "A stored procedure", "An index optimization"),
                "A temporary named result set defined within the execution scope of a single SELECT, INSERT, UPDATE, or DELETE", "CTEs improve query readability and can be recursive for hierarchical data structures like org charts."));

        list.add(new Question("SQL_36", cat, "Hard",
                "What is the difference between 'RANK()' and 'DENSE_RANK()' window functions?",
                Arrays.asList("RANK() skips subsequent rank numbers after ties (1, 1, 3); DENSE_RANK() does not skip numbers (1, 1, 2)", "DENSE_RANK() skips numbers; RANK() does not", "RANK() works only on strings", "They are identical"),
                "RANK() skips subsequent rank numbers after ties (1, 1, 3); DENSE_RANK() does not skip numbers (1, 1, 2)", "When ties occur, RANK leaves gaps in the ranking sequence, whereas DENSE_RANK produces contiguous rank numbers."));

        list.add(new Question("SQL_37", cat, "Hard",
                "What are Window Functions in SQL and how do they differ from GROUP BY?",
                Arrays.asList("Perform calculations across a set of rows related to the current row without collapsing rows into a single summary output", "They filter data before query execution", "They only operate on database views", "They delete duplicate rows"),
                "Perform calculations across a set of rows related to the current row without collapsing rows into a single summary output", "Window functions (using OVER ()) calculate aggregates or rankings while retaining individual row identities."));

        list.add(new Question("SQL_38", cat, "Hard",
                "What are the four ANSI SQL Transaction Isolation Levels in increasing order of isolation?",
                Arrays.asList("Read Uncommitted < Read Committed < Repeatable Read < Serializable", "Serializable < Repeatable Read < Read Committed < Read Uncommitted", "Read Only < Read Write < Snapshot < Exclusive", "None < Shared < Exclusive < Locked"),
                "Read Uncommitted < Read Committed < Repeatable Read < Serializable", "Isolation levels balance transaction concurrency against concurrency phenomena (dirty reads, non-repeatable reads, phantom reads)."));

        list.add(new Question("SQL_39", cat, "Hard",
                "What is a 'Dirty Read' in database concurrency?",
                Arrays.asList("A transaction reads uncommitted changes made by another concurrently running transaction that may subsequently roll back", "Reading data from damaged disk sectors", "Reading cached query plans", "Reading expired session tokens"),
                "A transaction reads uncommitted changes made by another concurrently running transaction that may subsequently roll back", "Dirty reads occur under READ UNCOMMITTED when uncommitted, volatile data modifications are read by other transactions."));

        list.add(new Question("SQL_40", cat, "Hard",
                "What is a 'Phantom Read' phenomenon?",
                Arrays.asList("A transaction re-executes a range query and finds new rows inserted/committed by another transaction since the first read", "A transaction reading NULL values", "A deleted row reappearing after reboot", "A crash during commit"),
                "A transaction re-executes a range query and finds new rows inserted/committed by another transaction since the first read", "Phantom reads happen when another transaction commits new rows satisfying the range condition of an in-progress transaction."));

        list.add(new Question("SQL_41", cat, "Hard",
                "What is Database Normalization and what does Third Normal Form (3NF) require?",
                Arrays.asList("Organizing tables to reduce redundancy; 3NF requires being in 2NF and having no transitive functional dependencies", "Encrypting database tables", "Compressing database backups", "Denormalizing for faster reads"),
                "Organizing tables to reduce redundancy; 3NF requires being in 2NF and having no transitive functional dependencies", "3NF dictates that every non-key column must depend on the primary key, the whole primary key, and nothing but the primary key."));

        list.add(new Question("SQL_42", cat, "Hard",
                "What is a Clustered Index vs a Non-Clustered Index?",
                Arrays.asList("Clustered index physically sorts and stores data rows in table order (1 per table); Non-clustered index is a separate structure with pointers", "Non-clustered physically orders rows", "Tables can have 10 clustered indexes", "Clustered indexes are slower for range scans"),
                "Clustered index physically sorts and stores data rows in table order (1 per table); Non-clustered index is a separate structure with pointers", "Because table rows can only be sorted physically in one way, a table can have only one clustered index (usually primary key)."));

        list.add(new Question("SQL_43", cat, "Hard",
                "What is SQL Injection and how can it be completely prevented in application code?",
                Arrays.asList("Malicious SQL inserted into input fields; prevented by using Parameterized Queries (Prepared Statements)", "A database backup virus; prevented by antivirus", "A network DDoS attack; prevented by firewall", "An index corruption; prevented by vacuum"),
                "Malicious SQL inserted into input fields; prevented by using Parameterized Queries (Prepared Statements)", "Parameterized queries treat user input strictly as literal values rather than executable SQL syntax, neutralizing injection attacks."));

        list.add(new Question("SQL_44", cat, "Hard",
                "What does 'EXPLAIN' or 'EXPLAIN QUERY PLAN' command do in SQL engines?",
                Arrays.asList("Displays the execution plan showing how the database optimizer will execute the query (table scans, indexes used, joins)", "Runs query in benchmark mode", "Translates SQL into C++ code", "Checks grammar without compiling"),
                "Displays the execution plan showing how the database optimizer will execute the query (table scans, indexes used, joins)", "EXPLAIN reveals the cost, join algorithms, and index lookups planned by the query optimizer."));

        list.add(new Question("SQL_45", cat, "Hard",
                "What is Write-Ahead Logging (WAL) in database engines like SQLite and PostgreSQL?",
                Arrays.asList("Changes are written sequentially to a separate WAL log before applying to the main database file, enhancing concurrency", "Writing logs to remote cloud servers", "Auditing user logins", "A backup replication protocol"),
                "Changes are written sequentially to a separate WAL log before applying to the main database file, enhancing concurrency", "WAL allows concurrent readers while a writer writes to the log, significantly improving database throughput."));

        list.add(new Question("SQL_46", cat, "Hard",
                "What is a Correlated Subquery?",
                Arrays.asList("A subquery that references columns from the outer query and must be evaluated once for each row processed by the outer query", "A subquery that runs in parallel on GPU", "A query that returns two tables", "A query joined with itself"),
                "A subquery that references columns from the outer query and must be evaluated once for each row processed by the outer query", "Because it depends on values in each row of the outer query, a correlated subquery cannot be executed independently."));

        list.add(new Question("SQL_47", cat, "Hard",
                "What does the window function 'LEAD()' and 'LAG()' allow?",
                Arrays.asList("Accessing data from subsequent (LEAD) or preceding (LAG) rows relative to the current row without self-joins", "Leading database replication nodes", "Delaying query execution", "Sorting rows by date"),
                "Accessing data from subsequent (LEAD) or preceding (LAG) rows relative to the current row without self-joins", "LEAD and LAG provide straightforward access to values in surrounding rows, ideal for calculating period-over-period differences."));

        list.add(new Question("SQL_48", cat, "Hard",
                "What is Deadlock in relational databases and how do DBMS engines resolve it?",
                Arrays.asList("Two or more transactions cyclically hold locks the other needs; DBMS detects cycles and rolls back a victim transaction", "A corrupted database file; resolved by reboot", "A query timeout; resolved by increasing RAM", "An unclosed cursor"),
                "Two or more transactions cyclically hold locks the other needs; DBMS detects cycles and rolls back a victim transaction", "Deadlock detection algorithms identify wait-for graph cycles and abort/rollback one transaction so others can proceed."));

        list.add(new Question("SQL_49", cat, "Hard",
                "What does 'PRAGMA foreign_keys = ON;' do in SQLite?",
                Arrays.asList("Enables enforcement of foreign key constraints (disabled by default in SQLite for backward compatibility)", "Lists all foreign keys in database", "Creates foreign key indexes", "Backs up foreign tables"),
                "Enables enforcement of foreign key constraints (disabled by default in SQLite for backward compatibility)", "SQLite requires explicit runtime activation of foreign key constraints per database connection using this PRAGMA."));

        list.add(new Question("SQL_50", cat, "Hard",
                "What is a Composite Primary Key?",
                Arrays.asList("A primary key composed of two or more columns that together uniquely identify a row", "A primary key with auto-increment and UUID", "A primary key referenced by two tables", "A foreign key acting as primary key"),
                "A primary key composed of two or more columns that together uniquely identify a row", "Composite keys use combinations of multiple columns (e.g., student_id + course_id) to guarantee row uniqueness."));

        return list;
    }
}
