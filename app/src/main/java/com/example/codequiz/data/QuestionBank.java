package com.example.codequiz.data;

import com.example.codequiz.R;
import com.example.codequiz.model.Question;
import com.example.codequiz.model.QuizCategory;
import com.example.codequiz.util.AppConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionBank {

    private static final Map<String, List<Question>> questionsMap = new HashMap<>();

    static {
        questionsMap.put(AppConstants.CAT_JAVA, JavaQuestions.get());
        questionsMap.put(AppConstants.CAT_PYTHON, PythonQuestions.get());
        questionsMap.put(AppConstants.CAT_C, CQuestions.get());
        questionsMap.put(AppConstants.CAT_CPP, CppQuestions.get());
        questionsMap.put(AppConstants.CAT_JAVASCRIPT, JavaScriptQuestions.get());
        questionsMap.put(AppConstants.CAT_REACT, ReactQuestions.get());
        questionsMap.put(AppConstants.CAT_HTML, HtmlQuestions.get());
        questionsMap.put(AppConstants.CAT_CSS, CssQuestions.get());
        questionsMap.put(AppConstants.CAT_SQL, SqlQuestions.get());
        questionsMap.put(AppConstants.CAT_DSA, DsaQuestions.get());
    }

    public static List<QuizCategory> getCategories() {
        List<QuizCategory> categories = new ArrayList<>();

        categories.add(new QuizCategory("cat_java", AppConstants.CAT_JAVA,
                "OOP principles, JVM architecture, Collections, Multithreading, and Modern Java features.",
                R.drawable.ic_cat_java, getCount(AppConstants.CAT_JAVA)));

        categories.add(new QuizCategory("cat_python", AppConstants.CAT_PYTHON,
                "Syntax, data structures, generators, decorators, OOP, and Python internals.",
                R.drawable.ic_cat_python, getCount(AppConstants.CAT_PYTHON)));

        categories.add(new QuizCategory("cat_c", AppConstants.CAT_C,
                "Pointers, manual memory management, preprocessors, structures, and low-level C semantics.",
                R.drawable.ic_cat_c, getCount(AppConstants.CAT_C)));

        categories.add(new QuizCategory("cat_cpp", AppConstants.CAT_CPP,
                "Modern C++, templates, RAII, move semantics, smart pointers, and STL containers.",
                R.drawable.ic_cat_cpp, getCount(AppConstants.CAT_CPP)));

        categories.add(new QuizCategory("cat_javascript", AppConstants.CAT_JAVASCRIPT,
                "ES6+, closures, event loop, promises, async/await, prototypes, and DOM APIs.",
                R.drawable.ic_cat_javascript, getCount(AppConstants.CAT_JAVASCRIPT)));

        categories.add(new QuizCategory("cat_react", AppConstants.CAT_REACT,
                "Components, JSX, Hooks, state management, reconciliation, and React 18 features.",
                R.drawable.ic_cat_react, getCount(AppConstants.CAT_REACT)));

        categories.add(new QuizCategory("cat_html", AppConstants.CAT_HTML,
                "Semantic elements, HTML5 APIs, forms, accessibility, SEO, and document structure.",
                R.drawable.ic_cat_html, getCount(AppConstants.CAT_HTML)));

        categories.add(new QuizCategory("cat_css", AppConstants.CAT_CSS,
                "Box model, Flexbox, Grid, animations, specificity, media queries, and responsive design.",
                R.drawable.ic_cat_css, getCount(AppConstants.CAT_CSS)));

        categories.add(new QuizCategory("cat_sql", AppConstants.CAT_SQL,
                "Queries, joins, indexing, transactions, ACID, window functions, and database design.",
                R.drawable.ic_cat_sql, getCount(AppConstants.CAT_SQL)));

        categories.add(new QuizCategory("cat_dsa", AppConstants.CAT_DSA,
                "Arrays, linked lists, trees, graphs, sorting, searching, DP, and algorithmic complexity.",
                R.drawable.ic_cat_dsa, getCount(AppConstants.CAT_DSA)));

        return categories;
    }

    public static int getCount(String category) {
        List<Question> list = questionsMap.get(category);
        return list != null ? list.size() : 0;
    }

    public static int getAvailableCount(String category, String difficulty) {
        List<Question> all = questionsMap.get(category);
        if (all == null) return 0;

        if (difficulty == null || difficulty.equalsIgnoreCase(AppConstants.DIFFICULTY_MIXED)) {
            return all.size();
        }

        String targetDiff = normalizeDifficulty(difficulty);
        int count = 0;
        for (Question q : all) {
            if (normalizeDifficulty(q.getDifficulty()).equalsIgnoreCase(targetDiff)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Normalizes difficulty string across aliases (Beginner <-> Easy, Intermediate <-> Medium, Advanced <-> Hard).
     */
    public static String normalizeDifficulty(String diff) {
        if (diff == null) return "";
        if (diff.equalsIgnoreCase(AppConstants.DIFFICULTY_BEGINNER) || diff.equalsIgnoreCase(AppConstants.DIFFICULTY_EASY)) {
            return AppConstants.DIFFICULTY_EASY;
        }
        if (diff.equalsIgnoreCase(AppConstants.DIFFICULTY_INTERMEDIATE) || diff.equalsIgnoreCase(AppConstants.DIFFICULTY_MEDIUM)) {
            return AppConstants.DIFFICULTY_MEDIUM;
        }
        if (diff.equalsIgnoreCase(AppConstants.DIFFICULTY_ADVANCED) || diff.equalsIgnoreCase(AppConstants.DIFFICULTY_HARD)) {
            return AppConstants.DIFFICULTY_HARD;
        }
        return diff;
    }

    /**
     * Retrieves randomized, cloned questions for a quiz attempt.
     * Keeps correct-answer mapping intact while shuffling options.
     */
    public static List<Question> getQuizQuestions(String category, String difficulty, int requestedCount) {
        List<Question> source = questionsMap.get(category);
        if (source == null) return new ArrayList<>();

        List<Question> pool = new ArrayList<>();
        boolean isMixed = difficulty == null || difficulty.equalsIgnoreCase(AppConstants.DIFFICULTY_MIXED);
        String targetDiff = normalizeDifficulty(difficulty);

        for (Question q : source) {
            if (isMixed || normalizeDifficulty(q.getDifficulty()).equalsIgnoreCase(targetDiff)) {
                pool.add(q);
            }
        }

        // Randomize questions order without duplicates
        Collections.shuffle(pool);

        int countToTake = Math.min(requestedCount, pool.size());
        List<Question> selected = new ArrayList<>();

        for (int i = 0; i < countToTake; i++) {
            Question orig = pool.get(i);

            // Deep clone options so shuffling options does not mutate original static question bank
            List<String> shuffledOptions = new ArrayList<>(orig.getOptions());
            Collections.shuffle(shuffledOptions);

            Question qCopy = new Question(
                    orig.getId(),
                    orig.getCategory(),
                    orig.getDifficulty(),
                    orig.getQuestionText(),
                    shuffledOptions,
                    orig.getCorrectAnswer(), // Correct answer string remains identical!
                    orig.getExplanation()
            );
            selected.add(qCopy);
        }

        return selected;
    }
}
