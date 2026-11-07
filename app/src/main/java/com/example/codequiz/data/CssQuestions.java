package com.example.codequiz.data;

import com.example.codequiz.model.Question;
import com.example.codequiz.util.AppConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CssQuestions {

    public static List<Question> get() {
        List<Question> list = new ArrayList<>();
        String cat = AppConstants.CAT_CSS;
        loadEasy(list, cat);
        loadMedium(list, cat);
        loadHard(list, cat);
        return list;
    }

    private static void loadEasy(List<Question> list, String cat) {
        list.add(new Question("CSS_E_01", cat, "Easy",
                "What does CSS stand for?",
                Arrays.asList("Cascading Style Sheets", "Computer Style Sheets", "Creative Style System", "Colorful Style Sheets"),
                "Cascading Style Sheets",
                "CSS stands for Cascading Style Sheets, used to style and lay out HTML elements."));
        list.add(new Question("CSS_E_02", cat, "Easy",
                "Which HTML tag is used to embed internal CSS styles within an HTML document?",
                Arrays.asList("<css>", "<style>", "<script>", "<link>"),
                "<style>",
                "The <style> element is used to define internal CSS rules in HTML."));
        list.add(new Question("CSS_E_03", cat, "Easy",
                "Which HTML tag is used to link an external CSS stylesheet file?",
                Arrays.asList("<style>", "<link>", "<css>", "<stylesheet>"),
                "<link>",
                "<link rel=\"stylesheet\" href=\"styles.css\"> is used to attach an external stylesheet."));
        list.add(new Question("CSS_E_04", cat, "Easy",
                "Which CSS property is used to change the background color of an element?",
                Arrays.asList("color", "background-color", "bgcolor", "background-image"),
                "background-color",
                "The background-color property sets the background color of an element."));
        list.add(new Question("CSS_E_05", cat, "Easy",
                "Which property changes the text color of an HTML element in CSS?",
                Arrays.asList("text-color", "font-color", "color", "text-style"),
                "color",
                "The color property sets the foreground/text color of an element."));
        list.add(new Question("CSS_E_06", cat, "Easy",
                "Which CSS property specifies the font family/typeface of text?",
                Arrays.asList("font-style", "font-family", "font-weight", "font-type"),
                "font-family",
                "font-family specifies a prioritized list of font family names for the selected element."));
        list.add(new Question("CSS_E_07", cat, "Easy",
                "Which CSS property changes the font size of text?",
                Arrays.asList("text-size", "font-size", "font-height", "text-style"),
                "font-size",
                "The font-size property sets the size of the font."));
        list.add(new Question("CSS_E_08", cat, "Easy",
                "Which CSS property makes text bold?",
                Arrays.asList("font-weight: bold;", "text-style: bold;", "font-style: bold;", "text-weight: bold;"),
                "font-weight: bold;",
                "font-weight: bold; (or numeric values like 700) sets the thickness of characters."));
        list.add(new Question("CSS_E_09", cat, "Easy",
                "Which CSS property renders text in italics?",
                Arrays.asList("font-weight: italic;", "font-style: italic;", "text-decoration: italic;", "font-italic: true;"),
                "font-style: italic;",
                "font-style: italic; sets font glyphs to italic style."));
        list.add(new Question("CSS_E_10", cat, "Easy",
                "Which CSS property adds an underline or strikethrough to text?",
                Arrays.asList("text-decoration", "text-style", "font-line", "text-align"),
                "text-decoration",
                "text-decoration (e.g., text-decoration: underline;) decorates text with lines."));
        list.add(new Question("CSS_E_11", cat, "Easy",
                "Which property controls the space INSIDE an element's border?",
                Arrays.asList("margin", "padding", "border", "spacing"),
                "padding",
                "Padding generates space around an element's content inside any defined borders."));
        list.add(new Question("CSS_E_12", cat, "Easy",
                "Which property controls the space OUTSIDE an element's border?",
                Arrays.asList("padding", "margin", "outline", "border-spacing"),
                "margin",
                "Margin creates space around elements, outside of any defined borders."));
        list.add(new Question("CSS_E_13", cat, "Easy",
                "What is the correct syntax to define a solid red border of 2px width?",
                Arrays.asList("border: 2px solid red;", "border-style: 2px red solid;", "border: solid 2px line red;", "border-color: 2px red;"),
                "border: 2px solid red;",
                "The shorthand 'border: 2px solid red;' sets border-width, border-style, and border-color."));
        list.add(new Question("CSS_E_14", cat, "Easy",
                "Which CSS property rounded corners of an element's border?",
                Arrays.asList("corner-radius", "border-radius", "border-corner", "box-radius"),
                "border-radius",
                "border-radius rounds the corners of an element's outer border edge."));
        list.add(new Question("CSS_E_15", cat, "Easy",
                "How do you select an element with `id=\"header\"` in CSS?",
                Arrays.asList(".header", "#header", "*header", "header"),
                "#header",
                "The hash sign # is used as the ID selector in CSS."));
        list.add(new Question("CSS_E_16", cat, "Easy",
                "How do you select all elements with `class=\"card\"` in CSS?",
                Arrays.asList("#card", ".card", "*card", "card"),
                ".card",
                "The period . is used as the class selector in CSS."));
        list.add(new Question("CSS_E_17", cat, "Easy",
                "Which selector matches ALL elements on a webpage?",
                Arrays.asList("#", ".", "*", "all"),
                "*",
                "The universal selector * matches all elements of any type."));
        list.add(new Question("CSS_E_18", cat, "Easy",
                "How do you add a comment in a CSS stylesheet?",
                Arrays.asList("// This is a comment", "<!-- This is a comment -->", "/* This is a comment */", "' This is a comment"),
                "/* This is a comment */",
                "CSS comments start with /* and end with */."));
        list.add(new Question("CSS_E_19", cat, "Easy",
                "Which property sets text horizontal alignment (left, right, center, justify)?",
                Arrays.asList("align-text", "text-align", "horizontal-align", "text-position"),
                "text-align",
                "text-align sets horizontal alignment of inline/text content within block elements."));
        list.add(new Question("CSS_E_20", cat, "Easy",
                "Which display value causes an element NOT to be displayed and removes it from layout flow?",
                Arrays.asList("display: hidden;", "display: none;", "visibility: hidden;", "display: invisible;"),
                "display: none;",
                "display: none; hides an element completely and removes its layout space."));
        list.add(new Question("CSS_E_21", cat, "Easy",
                "What is the key difference between `display: none;` and `visibility: hidden;`?",
                Arrays.asList("display: none; hides element but keeps space; visibility: hidden; removes space", "display: none; removes element from document flow entirely; visibility: hidden; hides element visually but leaves layout space", "There is no difference", "visibility: hidden; only works on images"),
                "display: none; removes element from document flow entirely; visibility: hidden; hides element visually but leaves layout space",
                "display: none removes the box from layout; visibility: hidden hides the element visually while reserving its space."));
        list.add(new Question("CSS_E_22", cat, "Easy",
                "Which CSS unit represents a percentage of the viewport width?",
                Arrays.asList("vh", "vw", "rem", "em"),
                "vw",
                "1vw equals 1% of the total viewport width."));
        list.add(new Question("CSS_E_23", cat, "Easy",
                "Which CSS unit represents a percentage of the viewport height?",
                Arrays.asList("vw", "vh", "vh%", "px"),
                "vh",
                "1vh equals 1% of the total viewport height."));
        list.add(new Question("CSS_E_24", cat, "Easy",
                "What does 'rem' unit stand for in CSS?",
                Arrays.asList("Relative Element Margin", "Root EM (relative to root <html> font-size)", "Real Element Size", "Responsive EM"),
                "Root EM (relative to root <html> font-size)",
                "rem units are calculated relative to the font-size of the root <html> element."));
        list.add(new Question("CSS_E_25", cat, "Easy",
                "What is the shorthand order for four margin values: `margin: 10px 20px 30px 40px;`?",
                Arrays.asList("Top, Right, Bottom, Left", "Top, Left, Bottom, Right", "Left, Right, Top, Bottom", "Top, Bottom, Left, Right"),
                "Top, Right, Bottom, Left",
                "Shorthand box values follow clockwise order: Top, Right, Bottom, Left (TRBL)."));
        list.add(new Question("CSS_E_26", cat, "Easy",
                "What does `margin: 10px 20px;` specify?",
                Arrays.asList("Top/Bottom 10px, Right/Left 20px", "Top/Right 10px, Bottom/Left 20px", "Top 10px, Right 20px, Bottom 10px, Left 20px", "Left/Right 10px, Top/Bottom 20px"),
                "Top/Bottom 10px, Right/Left 20px",
                "Two-value shorthand specifies vertical (Top/Bottom) then horizontal (Left/Right) margins."));
        list.add(new Question("CSS_E_27", cat, "Easy",
                "Which property specifies how the total width and height of an element are calculated (content-box vs border-box)?",
                Arrays.asList("box-model", "box-sizing", "box-layout", "sizing-mode"),
                "box-sizing",
                "box-sizing defines whether padding and border are included in element width/height."));
        list.add(new Question("CSS_E_28", cat, "Easy",
                "What is the default value of the `box-sizing` property in standard CSS?",
                Arrays.asList("border-box", "content-box", "padding-box", "margin-box"),
                "content-box",
                "The default value is content-box, where width/height apply only to content."));
        list.add(new Question("CSS_E_29", cat, "Easy",
                "Which color format allows defining opacity/transparency along with RGB in CSS?",
                Arrays.asList("rgb()", "rgba()", "hex", "hsl()"),
                "rgba()",
                "rgba() accepts Red, Green, Blue, and an Alpha value (0.0 to 1.0) for transparency."));
        list.add(new Question("CSS_E_30", cat, "Easy",
                "Which property specifies an image to be used as a background?",
                Arrays.asList("background-src", "background-image", "bg-img", "background-file"),
                "background-image",
                "background-image specifies image sources (e.g., background-image: url('pic.png');)."));
        list.add(new Question("CSS_E_31", cat, "Easy",
                "What is the default `position` property value for HTML elements?",
                Arrays.asList("relative", "static", "absolute", "fixed"),
                "static",
                "Elements are positioned static by default, following normal document flow."));
        list.add(new Question("CSS_E_32", cat, "Easy",
                "Which position value positions an element relative to its normal position in document flow?",
                Arrays.asList("static", "relative", "absolute", "fixed"),
                "relative",
                "position: relative offsets an element relative to where it would normally be placed."));
        list.add(new Question("CSS_E_33", cat, "Easy",
                "Which position value locks an element relative to the browser viewport so it stays fixed during scrolling?",
                Arrays.asList("absolute", "fixed", "sticky", "relative"),
                "fixed",
                "position: fixed anchors an element relative to the viewport window."));
        list.add(new Question("CSS_E_34", cat, "Easy",
                "Which CSS property controls letter capitalization (uppercase, lowercase, capitalize)?",
                Arrays.asList("text-transform", "text-style", "font-case", "text-case"),
                "text-transform",
                "text-transform controls capitalization of text (e.g., uppercase, capitalize)."));
        list.add(new Question("CSS_E_35", cat, "Easy",
                "Which display property value initializes a flexible flex container layout in CSS?",
                Arrays.asList("display: flex;", "display: flexbox;", "display: flexible;", "box-layout: flex;"),
                "display: flex;",
                "display: flex activates the Flexbox layout context for an element's children."));
        list.add(new Question("CSS_E_36", cat, "Easy",
                "Which flex property specifies the direction of flex items along the main axis (row vs column)?",
                Arrays.asList("flex-direction", "flex-wrap", "flex-flow", "justify-content"),
                "flex-direction",
                "flex-direction establishes main axis direction (row, row-reverse, column, column-reverse)."));
        list.add(new Question("CSS_E_37", cat, "Easy",
                "Which property aligns flex items along the MAIN axis of a flex container?",
                Arrays.asList("align-items", "justify-content", "align-content", "flex-align"),
                "justify-content",
                "justify-content aligns items along the main axis of a flex container."));
        list.add(new Question("CSS_E_38", cat, "Easy",
                "Which property aligns flex items along the CROSS axis in a single-line flex container?",
                Arrays.asList("justify-content", "align-items", "text-align", "align-self"),
                "align-items",
                "align-items aligns items along the cross axis perpendicular to main axis."));
        list.add(new Question("CSS_E_39", cat, "Easy",
                "Which display property value initializes a CSS Grid container?",
                Arrays.asList("display: grid;", "display: css-grid;", "grid-layout: true;", "display: table-grid;"),
                "display: grid;",
                "display: grid initializes a grid formatting context."));
        list.add(new Question("CSS_E_40", cat, "Easy",
                "Which CSS Grid property defines the column track sizes in a grid container?",
                Arrays.asList("grid-template-columns", "grid-columns-size", "grid-track-columns", "grid-width"),
                "grid-template-columns",
                "grid-template-columns defines column line names and track sizing functions."));
        list.add(new Question("CSS_E_41", cat, "Easy",
                "Which CSS Grid unit represents a fraction of free available space in grid containers?",
                Arrays.asList("fr", "frx", "%", "flex"),
                "fr",
                "The fr unit represents a fraction of available free space in grid layouts."));
        list.add(new Question("CSS_E_42", cat, "Easy",
                "Which pseudo-class applies styles when a user hovers over an element with a pointer?",
                Arrays.asList(":active", ":hover", ":focus", ":visited"),
                ":hover",
                "The :hover pseudo-class matches when the user interacts with an element with a pointing device."));
        list.add(new Question("CSS_E_43", cat, "Easy",
                "Which pseudo-class targets links that have already been clicked/visited by the user?",
                Arrays.asList(":active", ":visited", ":hover", ":link"),
                ":visited",
                "The :visited pseudo-class selects links that the user has previously navigated to."));
        list.add(new Question("CSS_E_44", cat, "Easy",
                "Which pseudo-class targets an element when it receives keyboard or click focus (e.g., input field)?",
                Arrays.asList(":focus", ":active", ":target", ":hover"),
                ":focus",
                "The :focus pseudo-class applies when an element receives focus (e.g. form fields)."));
        list.add(new Question("CSS_E_45", cat, "Easy",
                "Which CSS property controls smooth property changes over a specified duration?",
                Arrays.asList("animation", "transition", "transform", "keyframe"),
                "transition",
                "transition allows property changes in CSS values to occur smoothly over time."));
        list.add(new Question("CSS_E_46", cat, "Easy",
                "Which transform function moves an element horizontally and/or vertically on screen?",
                Arrays.asList("rotate()", "translate()", "scale()", "skew()"),
                "translate()",
                "translate(x, y) repositions an element on the 2D plane."));
        list.add(new Question("CSS_E_47", cat, "Easy",
                "Which CSS rule is used to apply different styles conditionally based on media device features like screen width?",
                Arrays.asList("@media", "@responsive", "@device", "@screen"),
                "@media",
                "@media queries apply CSS rules based on media type and feature conditions (e.g. screen width)."));
        list.add(new Question("CSS_E_48", cat, "Easy",
                "How are custom properties (CSS variables) defined in CSS?",
                Arrays.asList("$var-name: value;", "--var-name: value;", "@var-name: value;", "var-name = value;"),
                "--var-name: value;",
                "Custom properties are declared with a double hyphen prefix `--custom-name: value;`."));
        list.add(new Question("CSS_E_49", cat, "Easy",
                "How do you access the value of a custom property `--main-color` in CSS?",
                Arrays.asList("get(--main-color)", "var(--main-color)", "$--main-color", "val(--main-color)"),
                "var(--main-color)",
                "The `var(--property-name)` function inserts the custom property value."));
        list.add(new Question("CSS_E_50", cat, "Easy",
                "Which property specifies line height/spacing between lines of text?",
                Arrays.asList("line-height", "letter-spacing", "word-spacing", "text-indent"),
                "line-height",
                "line-height sets the vertical distance between lines of text."));
    }

    private static void loadMedium(List<Question> list, String cat) {
        list.add(new Question("CSS_M_01", cat, "Medium",
                "Which selector has the HIGHEST specificity weight among the following?",
                Arrays.asList("Element selector (`p`)", "Class selector (`.highlight`)", "ID selector (`#header`)", "Universal selector (`*`)"),
                "ID selector (`#header`)",
                "ID selectors (#id) have specificity weight (1,0,0), higher than classes (0,1,0) or elements (0,0,1)."));
        list.add(new Question("CSS_M_02", cat, "Medium",
                "What is the specificity calculation tuple (Inline, ID, Class, Element) for `.nav ul li.active a`?",
                Arrays.asList("(0, 0, 2, 3)", "(0, 1, 1, 2)", "(0, 0, 3, 2)", "(0, 2, 0, 3)"),
                "(0, 0, 2, 3)",
                "Two classes (`.nav`, `.active`) and three elements (`ul`, `li`, `a`) yield specificity (0, 0, 2, 3)."));
        list.add(new Question("CSS_M_03", cat, "Medium",
                "What does the `!important` keyword do when added to a CSS declaration?",
                Arrays.asList("Makes property read-only", "Overrides standard cascade specificity rules for that declaration", "Applies property to all child elements", "Causes animation compile error"),
                "Overrides standard cascade specificity rules for that declaration",
                "!important overrides normal declaration cascade rules regardless of selector specificity."));
        list.add(new Question("CSS_M_04", cat, "Medium",
                "If an element has `width: 200px; padding: 20px; border: 5px solid black; box-sizing: content-box;`, what is its total rendered physical width?",
                Arrays.asList("200px", "250px", "240px", "220px"),
                "250px",
                "With content-box: Total width = width (200) + left/right padding (40) + left/right border (10) = 250px."));
        list.add(new Question("CSS_M_05", cat, "Medium",
                "If an element has `width: 200px; padding: 20px; border: 5px solid black; box-sizing: border-box;`, what is its total rendered physical width?",
                Arrays.asList("200px", "250px", "240px", "150px"),
                "200px",
                "With border-box: Total width is fixed to 200px; padding and border are absorbed inside the 200px width."));
        list.add(new Question("CSS_M_06", cat, "Medium",
                "What is margin collapsing in CSS?",
                Arrays.asList("Margins of adjacent block elements collapse into a single margin equal to the largest margin size", "Margins disappear on small screens", "Padding and margin merge together", "Negative margins cancel out positive margins"),
                "Margins of adjacent block elements collapse into a single margin equal to the largest margin size",
                "Top and bottom margins of adjacent block boxes combine into a single margin equal to max(margin1, margin2)."));
        list.add(new Question("CSS_M_07", cat, "Medium",
                "Which property specifies the z-order/stacking order of overlapping positioned elements?",
                Arrays.asList("z-index", "layer-order", "stack-level", "depth-index"),
                "z-index",
                "z-index sets the z-order axis position for positioned elements (position != static)."));
        list.add(new Question("CSS_M_08", cat, "Medium",
                "How does `position: sticky;` behave during scrolling?",
                Arrays.asList("Remains static until a scroll threshold relative to container/viewport is met, then behaves as fixed", "Always stays fixed", "Behaves like absolute position", "Remains hidden until hover"),
                "Remains static until a scroll threshold relative to container/viewport is met, then behaves as fixed",
                "position: sticky toggles between relative and fixed depending on scroll offset relative to viewport/container bounds."));
        list.add(new Question("CSS_M_09", cat, "Medium",
                "Which flex property determines if flex items wrap onto multiple lines when space runs out?",
                Arrays.asList("flex-wrap", "flex-flow", "flex-shrink", "flex-grow"),
                "flex-wrap",
                "flex-wrap (values: nowrap, wrap, wrap-reverse) controls whether flex container wraps items."));
        list.add(new Question("CSS_M_10", cat, "Medium",
                "What is the shorthand `flex: 1;` equivalent to?",
                Arrays.asList("flex-grow: 1; flex-shrink: 1; flex-basis: 0%;", "flex-grow: 1; flex-shrink: 0; flex-basis: auto;", "flex-direction: row;", "flex-width: 1px;"),
                "flex-grow: 1; flex-shrink: 1; flex-basis: 0%;",
                "Single number unitless value `flex: 1;` expands to `flex-grow: 1; flex-shrink: 1; flex-basis: 0%;`."));
        list.add(new Question("CSS_M_11", cat, "Medium",
                "Which flex item property defines the initial size of an item before remaining space is distributed?",
                Arrays.asList("flex-basis", "flex-grow", "flex-shrink", "flex-start"),
                "flex-basis",
                "flex-basis sets initial default sizing of a flex item before free space distribution."));
        list.add(new Question("CSS_M_12", cat, "Medium",
                "Which property sets grid row and column gaps simultaneously in modern CSS?",
                Arrays.asList("gap", "grid-spacing", "grid-margin", "track-gap"),
                "grid-spacing",
                "The shorthand `gap` property (formerly grid-gap) sets gutters between rows and columns."));
        list.add(new Question("CSS_M_13", cat, "Medium",
                "What does `grid-template-columns: repeat(3, 1fr);` create?",
                Arrays.asList("3 equal-width flexible columns spanning total available grid width", "3 rows of 1px height", "1 column repeated 3 times", "3 columns of fixed 100px width"),
                "3 equal-width flexible columns spanning total available grid width",
                "repeat(3, 1fr) creates three tracks each taking an equal fraction (1fr) of free space."));
        list.add(new Question("CSS_M_14", cat, "Medium",
                "Which property specifies explicit named areas in a grid container layout?",
                Arrays.asList("grid-template-areas", "grid-area-names", "grid-regions", "grid-named-layout"),
                "grid-template-areas",
                "grid-template-areas defines named grid cell layout areas using string templates."));
        list.add(new Question("CSS_M_15", cat, "Medium",
                "What is the key difference between pseudo-classes (`:hover`) and pseudo-elements (`::before`) in CSS syntax?",
                Arrays.asList("Pseudo-classes select state/condition of existing elements; pseudo-elements style dynamic sub-parts or injected content", "Pseudo-classes use double colons; pseudo-elements single", "Pseudo-elements apply only to links", "There is no difference"),
                "Pseudo-classes select state/condition of existing elements; pseudo-elements style dynamic sub-parts or injected content",
                "Pseudo-classes (single colon) target states; pseudo-elements (double colon) style dynamic structural parts/content."));
        list.add(new Question("CSS_M_16", cat, "Medium",
                "Which pseudo-element requires the `content: \"\";` property to render inserted content before an element?",
                Arrays.asList("::before", "::first-letter", "::selection", "::marker"),
                "::before",
                "::before (and ::after) pseudo-elements require content property to generate rendering boxes."));
        list.add(new Question("CSS_M_17", cat, "Medium",
                "Which pseudo-class targets every element that is the N-th child of its parent?",
                Arrays.asList(":nth-child(n)", ":nth-of-type(n)", ":child(n)", ":eq(n)"),
                ":nth-child(n)",
                ":nth-child(n) matches elements based on their numeric position index in parent children list."));
        list.add(new Question("CSS_M_18", cat, "Medium",
                "What is the difference between `:nth-child(2)` and `:nth-of-type(2)`?",
                Arrays.asList(":nth-child(2) selects second child regardless of tag type; :nth-of-type(2) selects second child matching that specific tag type", ":nth-of-type(2) counts backwards", ":nth-child applies to classes only", "They are identical"),
                ":nth-child(2) selects second child regardless of tag type; :nth-of-type(2) selects second child matching that specific tag type",
                ":nth-child counts all sibling elements; :nth-of-type counts only siblings matching element tag filter."));
        list.add(new Question("CSS_M_19", cat, "Medium",
                "What does `width: calc(100% - 50px);` calculate in CSS?",
                Arrays.asList("Subtracts 50px from 100% parent container width dynamically at runtime", "Sets width to 50px always", "Sets width to 50%", "Causes invalid syntax error"),
                "Subtracts 50px from 100% parent container width dynamically at runtime",
                "calc() performs runtime mathematical calculations mixing different CSS length units."));
        list.add(new Question("CSS_M_20", cat, "Medium",
                "How does `font-size: clamp(1rem, 2.5vw, 2rem);` restrict font sizing?",
                Arrays.asList("Sets font-size to preferred 2.5vw, clamped between minimum 1rem and maximum 2rem bounds", "Sets font size to 2.5vw always", "Sets font-size randomly between 1rem and 2rem", "Disables font scaling"),
                "Sets font-size to preferred 2.5vw, clamped between minimum 1rem and maximum 2rem bounds",
                "clamp(MIN, VAL, MAX) clamps a value between lower and upper defined threshold limits."));
        list.add(new Question("CSS_M_21", cat, "Medium",
                "Which CSS attribute selector targets elements whose `href` attribute ENDS with `.pdf`?",
                Arrays.asList("a[href$=\".pdf\"]", "a[href^=\".pdf\"]", "a[href*=\".pdf\"]", "a[href~=\".pdf\"]"),
                "a[href$=\".pdf\"]",
                "The $= attribute selector matches string endings."));
        list.add(new Question("CSS_M_22", cat, "Medium",
                "Which attribute selector matches elements whose `href` attribute STARTS with `https`?",
                Arrays.asList("a[href^=\"https\"]", "a[href$=\"https\"]", "a[href*=\"https\"]", "a[href|=\"https\"]"),
                "a[href^=\"https\"]",
                "The ^= attribute selector matches string prefix beginnings."));
        list.add(new Question("CSS_M_23", cat, "Medium",
                "Which attribute selector matches elements whose attribute contains a substring anywhere inside it?",
                Arrays.asList("[attr*=\"val\"]", "[attr^=\"val\"]", "[attr$=\"val\"]", "[attr~=\"val\"]"),
                "[attr*=\"val\"]",
                "The *= attribute selector matches substring occurrences anywhere within the value."));
        list.add(new Question("CSS_M_24", cat, "Medium",
                "What does the direct child combinator selector `div > p` select?",
                Arrays.asList("Paragraphs that are immediate direct children of a div", "All paragraphs inside a div regardless of nesting depth", "Paragraphs placed directly after a div sibling", "Divs containing a paragraph"),
                "Paragraphs that are immediate direct children of a div",
                "The > combinator selects elements that are direct immediate children of the specified parent."));
        list.add(new Question("CSS_M_25", cat, "Medium",
                "What does the adjacent sibling combinator `h1 + p` select?",
                Arrays.asList("The paragraph immediately following the h1 element at same parent level", "All paragraphs following an h1", "Paragraphs inside an h1", "h1 elements containing paragraphs"),
                "The paragraph immediately following the h1 element at same parent level",
                "The + combinator selects the single sibling element immediately following the first element."));
        list.add(new Question("CSS_M_26", cat, "Medium",
                "What does general sibling combinator `h1 ~ p` select?",
                Arrays.asList("All paragraph siblings following an h1 at same parent depth", "Only immediate sibling paragraph", "Paragraphs nested inside h1", "Child paragraphs"),
                "All paragraph siblings following an h1 at same parent depth",
                "The ~ combinator matches all sibling elements following the initial element sharing parent."));
        list.add(new Question("CSS_M_27", cat, "Medium",
                "What screen width orientation does `@media (min-width: 768px)` target?",
                Arrays.asList("Screens with width of 768px or wider (desktops/tablets)", "Screens narrower than 768px", "Screens strictly equal to 768px", "Print media only"),
                "Screens with width of 768px or wider (desktops/tablets)",
                "min-width: 768px applies styles when viewport width is greater than or equal to 768px (mobile-first)."));
        list.add(new Question("CSS_M_28", cat, "Medium",
                "Which transform property specifies the pivot point for element rotation or scaling?",
                Arrays.asList("transform-origin", "transform-center", "pivot-point", "transform-anchor"),
                "transform-origin",
                "transform-origin sets the origin location for an element's transformations (default: 50% 50%)."));
        list.add(new Question("CSS_M_29", cat, "Medium",
                "Which @-rule is used to define keyframe steps for CSS animations?",
                Arrays.asList("@keyframes", "@animation", "@frames", "@transition"),
                "@keyframes",
                "The @keyframes at-rule defines animation sequence keyframe stages."));
        list.add(new Question("CSS_M_30", cat, "Medium",
                "Which property makes a CSS animation repeat indefinitely?",
                Arrays.asList("animation-iteration-count: infinite;", "animation-repeat: true;", "animation-loop: infinite;", "animation-cycle: endless;"),
                "animation-iteration-count: infinite;",
                "animation-iteration-count: infinite specifies non-stopping animation loop cycles."));
        list.add(new Question("CSS_M_31", cat, "Medium",
                "Which `animation-fill-mode` value retains styles applied by the last keyframe after animation ends?",
                Arrays.asList("forwards", "backwards", "both", "retain"),
                "forwards",
                "forwards retains computed values from the final keyframe after animation completion."));
        list.add(new Question("CSS_M_32", cat, "Medium",
                "Which property specifies how to handle content that overflows an element's box bounds horizontally and vertically?",
                Arrays.asList("overflow", "scroll-behavior", "clip-bounds", "wrap-content"),
                "overflow",
                "overflow (values: visible, hidden, scroll, auto) controls clipped or scrollable container overflow."));
        list.add(new Question("CSS_M_33", cat, "Medium",
                "Which CSS property enables smooth scrolling animations when navigating via internal anchor links?",
                Arrays.asList("scroll-behavior: smooth;", "smooth-scroll: enabled;", "scroll-animation: linear;", "transition: scroll;"),
                "scroll-behavior: smooth;",
                "scroll-behavior: smooth enables smooth animated scrolling behavior for viewport scrolling."));
        list.add(new Question("CSS_M_34", cat, "Medium",
                "Which property ensures an `<img>` fills its container box while preserving aspect ratio by clipping excess?",
                Arrays.asList("object-fit: cover;", "object-fit: contain;", "image-size: cover;", "aspect-ratio: fill;"),
                "object-fit: cover;",
                "object-fit: cover scales image to maintain aspect ratio while filling container box, clipping if necessary."));
        list.add(new Question("CSS_M_35", cat, "Medium",
                "Which property scales an image to fit entirely inside its container without clipping, preserving aspect ratio?",
                Arrays.asList("object-fit: contain;", "object-fit: cover;", "object-fit: fill;", "image-scale: contain;"),
                "object-fit: contain;",
                "object-fit: contain letterboxes/scales image so entire asset is visible without cropping."));
        list.add(new Question("CSS_M_36", cat, "Medium",
                "Which CSS keyword explicitly forces an element to inherit a property value from its parent element?",
                Arrays.asList("inherit", "initial", "unset", "revert"),
                "inherit",
                "The `inherit` keyword causes element to adopt computed property value of parent."));
        list.add(new Question("CSS_M_37", cat, "Medium",
                "Which CSS keyword resets a property to its default initial browser specification value?",
                Arrays.asList("initial", "inherit", "unset", "default"),
                "initial",
                "The `initial` keyword sets property to official CSS specification default value."));
        list.add(new Question("CSS_M_38", cat, "Medium",
                "What does BEM stand for in CSS methodology naming conventions?",
                Arrays.asList("Block Element Modifier", "Base Element Module", "Browser Element Model", "Build Extension Management"),
                "Block Element Modifier",
                "BEM (Block Element Modifier) is a component-based class naming methodology for clean CSS."));
        list.add(new Question("CSS_M_39", cat, "Medium",
                "Which media query detects if user requested OS-level reduced motion/animation settings?",
                Arrays.asList("@media (prefers-reduced-motion: reduce)", "@media (motion: disabled)", "@media (animation: false)", "@media (reduced-animation: true)"),
                "@media (prefers-reduced-motion: reduce)",
                "prefers-reduced-motion detects system preferences for minimizing unnecessary non-essential animations."));
        list.add(new Question("CSS_M_40", cat, "Medium",
                "How does `display: inline-block;` differ from standard `display: inline;`?",
                Arrays.asList("inline-block respects width, height, top/bottom padding and margins while flowing inline with text", "inline-block forces line break", "inline-block hides element", "There is no difference"),
                "inline-block respects width, height, top/bottom padding and margins while flowing inline with text",
                "inline-block behaves inline in document flow but allows width/height and block box dimensions."));
        list.add(new Question("CSS_M_41", cat, "Medium",
                "What establishes an absolute positioning reference container for an element with `position: absolute;`?",
                Arrays.asList("The nearest ancestor element with position other than static", "The body tag always", "Direct parent div only", "Viewport window always"),
                "The nearest ancestor element with position other than static",
                "position: absolute positions relative to nearest ancestor whose position is relative, absolute, fixed, or sticky."));
        list.add(new Question("CSS_M_42", cat, "Medium",
                "Which flex property controls individual child item alignment overriding container `align-items`?",
                Arrays.asList("align-self", "justify-self", "flex-align", "item-align"),
                "align-self",
                "align-self allows individual flex items to override container align-items alignment."));
        list.add(new Question("CSS_M_43", cat, "Medium",
                "What is the shorthand property for setting both `grid-row-start` and `grid-row-end`?",
                Arrays.asList("grid-row", "grid-span-row", "grid-row-template", "row-range"),
                "grid-row",
                "grid-row (e.g., `grid-row: 1 / 3;`) sets grid item starting and ending track lines."));
        list.add(new Question("CSS_M_44", cat, "Medium",
                "Which property creates CSS linear gradient backgrounds?",
                Arrays.asList("background-image: linear-gradient(...);", "color-gradient: linear(...);", "background-color: gradient(...);", "border-gradient: linear(...);"),
                "background-image: linear-gradient(...);",
                "linear-gradient() function is applied as a value on background-image property."));
        list.add(new Question("CSS_M_45", cat, "Medium",
                "Which CSS property alters character horizontal letter spacing?",
                Arrays.asList("letter-spacing", "word-spacing", "character-spacing", "text-indent"),
                "letter-spacing",
                "letter-spacing controls tracking/space between individual text characters."));
        list.add(new Question("CSS_M_46", cat, "Medium",
                "What is a Reflow (Layout phase) in browser rendering pipeline?",
                Arrays.asList("Browser process calculating geometry and position layout coordinates for DOM elements", "Painting pixels onto screen", "Downloading CSS files", "Parsing JS scripts"),
                "Browser process calculating geometry and position layout coordinates for DOM elements",
                "Reflow computes layout positions and geometry for elements when structural dimensions change."));
        list.add(new Question("CSS_M_47", cat, "Medium",
                "What is Repaint in browser rendering?",
                Arrays.asList("Redrawing pixels on screen when visual elements change (like color) without affecting geometry layout dimensions", "Rebuilding DOM tree", "Calculating container widths", "Executing keyframe loops"),
                "Redrawing pixels on screen when visual elements change (like color) without affecting geometry layout dimensions",
                "Repaint occurs when visual appearances (e.g., color, outline) change without altering box dimensions/layout."));
        list.add(new Question("CSS_M_48", cat, "Medium",
                "How do you fix element overflow causing unexpected horizontal scrollbars on mobile viewports?",
                Arrays.asList("Apply `max-width: 100%;` on images/containers and check bounds", "Add width: 2000px;", "Set display: flex on body", "Remove doctype"),
                "Apply `max-width: 100%;` on images/containers and check bounds",
                "Preventing fixed-pixel widths and setting max-width: 100% on media prevents viewport overflow."));
        list.add(new Question("CSS_M_49", cat, "Medium",
                "What does `justify-content: space-between;` do in a flex container?",
                Arrays.asList("Distributes items evenly; first item at start edge, last item at end edge", "Centers items together", "Puts equal space around all items including ends", "Pushes all items right"),
                "Distributes items evenly; first item at start edge, last item at end edge",
                "space-between places equal gaps between items, locking edge items flush against container boundaries."));
        list.add(new Question("CSS_M_50", cat, "Medium",
                "What does `justify-content: space-around;` do?",
                Arrays.asList("Distributes items evenly with equal space on both sides of every item (half-size spaces at ends)", "Puts zero space on ends", "Centers items flush", "Stacks items vertically"),
                "Distributes items evenly with equal space on both sides of every item (half-size spaces at ends)",
                "space-around surrounds items with equal padding space, producing half-size gaps at outer edges."));
    }

    private static void loadHard(List<Question> list, String cat) {
        list.add(new Question("CSS_H_01", cat, "Hard",
                "Which combination of CSS properties creates a NEW Stacking Context for descendant z-index positioning?",
                Arrays.asList("opacity less than 1, transform not none, or filter not none", "margin: auto", "display: block", "border-radius: 50%"),
                "opacity less than 1, transform not none, or filter not none",
                "Non-1 opacity, 2D/3D transforms, filters, containment, or isolation properties create new stacking contexts."));
        list.add(new Question("CSS_H_02", cat, "Hard",
                "If element A has `z-index: 9999;` inside stacking context X (which has `z-index: 1;`), and element B has `z-index: 2;` inside root context, which renders on top?",
                Arrays.asList("Element B, because parent context X (z-index 1) is lower than B's parent context (z-index 2)", "Element A, because 9999 > 2", "Both blend equally", "Depends on font-size"),
                "Element B, because parent context X (z-index 1) is lower than B's parent context (z-index 2)",
                "Child z-indexes are local to their parent stacking context; parent context comparison overrides child values."));
        list.add(new Question("CSS_H_03", cat, "Hard",
                "What is the specificity weight of the `:is(h1, .title, #header)` pseudo-class selector?",
                Arrays.asList("Takes specificity of its most specific argument (`#header` -> 1, 0, 0)", "Zero specificity", "Sums all arguments together", "Fixed class weight (0,1,0)"),
                "Takes specificity of its most specific argument (`#header` -> 1, 0, 0)",
                "The `:is()` pseudo-class takes the specificity of its single most specific argument inside the parameter list."));
        list.add(new Question("CSS_H_04", cat, "Hard",
                "What is the specificity weight of the `:where(h1, .title, #header)` pseudo-class selector?",
                Arrays.asList("Always exactly (0, 0, 0)", "Takes weight of #header", "Sums all arguments", "Class weight (0,1,0)"),
                "Always exactly (0, 0, 0)",
                "Unlike `:is()`, `:where()` replaced specificity is always strictly zero (0, 0, 0)."));
        list.add(new Question("CSS_H_05", cat, "Hard",
                "What does `grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));` do?",
                Arrays.asList("Creates responsive grid columns that collapse empty tracks and stretch filled columns to fit container", "Limits grid to exactly 200px columns", "Fails if container is under 200px", "Generates fixed 1fr columns"),
                "Creates responsive grid columns that collapse empty tracks and stretch filled columns to fit container",
                "auto-fit drops empty tracks and stretches filled tracks; minmax guarantees column responsiveness without media queries."));
        list.add(new Question("CSS_H_06", cat, "Hard",
                "What is the difference between `auto-fill` and `auto-fit` in CSS Grid `minmax()` track repeaters?",
                Arrays.asList("`auto-fill` keeps empty track gaps in layout; `auto-fit` collapses empty tracks to 0px allowing filled tracks to expand", "`auto-fit` keeps empty gaps", "`auto-fill` only works on rows", "There is no difference"),
                "`auto-fill` keeps empty track gaps in layout; `auto-fit` collapses empty tracks to 0px allowing filled tracks to expand",
                "auto-fill retains empty tracks taking space; auto-fit collapses empty tracks so remaining items stretch across container."));
        list.add(new Question("CSS_H_07", cat, "Hard",
                "In Flexbox, what does `flex-shrink: 0;` prevent a flex item from doing when container overflows?",
                Arrays.asList("Prevents the flex item from shrinking below its flex-basis size", "Prevents the flex item from growing", "Prevents item from wrapping", "Hides the flex item"),
                "Prevents the flex item from shrinking below its flex-basis size",
                "flex-shrink: 0 disables item compression, enforcing item initial basis dimensions."));
        list.add(new Question("CSS_H_08", cat, "Hard",
                "How is extra remaining free space distributed among flex items with `flex-grow: 1` and `flex-grow: 2`?",
                Arrays.asList("Item with flex-grow: 2 gets twice as much OF THE REMAINING FREE SPACE as item with flex-grow: 1", "Item 2 is twice as wide total as Item 1", "Item 1 gets no space", "Space is split 50/50"),
                "Item with flex-grow: 2 gets twice as much OF THE REMAINING FREE SPACE as item with flex-grow: 1",
                "flex-grow ratio dictates proportion distribution of remaining free container space, not total absolute width."));
        list.add(new Question("CSS_H_09", cat, "Hard",
                "Can CSS custom properties (variables) be inherited down the DOM tree?",
                Arrays.asList("Yes, custom properties inherit by default like font-family or color", "No, variables are scoped strictly to declaring selector", "Only if marked !important", "Only in root element"),
                "Yes, custom properties inherit by default like font-family or color",
                "CSS custom properties are standard cascading inherited properties."));
        list.add(new Question("CSS_H_10", cat, "Hard",
                "What is the fallback mechanism syntax for `var()` if a custom property is undefined?",
                Arrays.asList("var(--main-color, #333)", "var(--main-color || #333)", "var(--main-color default #333)", "var(--main-color): #333"),
                "var(--main-color, #333)",
                "The second parameter in var(--name, fallback) serves as fallback value if custom property is invalid/undefined."));
        list.add(new Question("CSS_H_11", cat, "Hard",
                "Which CSS property controls container query styling based on ancestor box size instead of viewport size?",
                Arrays.asList("container-type: inline-size;", "element-query: true;", "box-query: width;", "container: viewport;"),
                "container-type: inline-size;",
                "container-type: inline-size (or normal/size) establishes a container context for `@container` media queries."));
        list.add(new Question("CSS_H_12", cat, "Hard",
                "What happens if mathematical expression inside `calc()` lacks spaces around `+` or `-` operators (e.g. `calc(100%-10px)`)?",
                Arrays.asList("Expression is invalid and property declaration is ignored", "Evaluates normally", "Treats -10px as negative number", "Renders black background"),
                "Expression is invalid and property declaration is ignored",
                "CSS calc() strictly requires whitespace around `+` and `-` operators to differentiate from signed unit tokens."));
        list.add(new Question("CSS_H_13", cat, "Hard",
                "Which modern pseudo-class matches parent elements that contain specific descendant elements?",
                Arrays.asList(":has()", ":contains()", ":parent-of()", ":matches()"),
                ":has()",
                "The `:has()` relational pseudo-class tests if parent contains descendants matching selector parameter."));
        list.add(new Question("CSS_H_14", cat, "Hard",
                "What does `p:not(.featured)` select?",
                Arrays.asList("All paragraph elements that do NOT have the class 'featured'", "All elements inside .featured", "Paragraphs with class .featured", "Non-paragraph elements"),
                "All paragraph elements that do NOT have the class 'featured'",
                "The `:not()` negation pseudo-class selects elements that fail to match parameter selector."));
        list.add(new Question("CSS_H_15", cat, "Hard",
                "Which CSS property prevents unwanted flickers and enforces hardware GPU acceleration layer creation during 3D transforms?",
                Arrays.asList("will-change: transform;", "gpu-accelerate: true;", "render-layer: hardware;", "transform-speed: fast;"),
                "will-change: transform;",
                "will-change hints browser ahead of time to allocate dedicated GPU compositor layers."));
        list.add(new Question("CSS_H_16", cat, "Hard",
                "What does `backface-visibility: hidden;` do during 3D card flipping transforms?",
                Arrays.asList("Hides reverse mirror side of element box when rotated away from viewer facing", "Hides background color", "Removes box shadow", "Hides element borders"),
                "Hides reverse mirror side of element box when rotated away from viewer facing",
                "backface-visibility: hidden prevents displaying reverse side mirror image when element is rotated in 3D space."));
        list.add(new Question("CSS_H_17", cat, "Hard",
                "What happens when `animation-direction: alternate;` is applied to an repeating keyframe animation?",
                Arrays.asList("Animation cycles forward on odd iterations and reverses backward on even iterations", "Animation plays backwards always", "Animation jumps randomly", "Animation pauses at end"),
                "Animation cycles forward on odd iterations and reverses backward on even iterations",
                "alternate reverses playback direction every subsequent cycle iteration."));
        list.add(new Question("CSS_H_18", cat, "Hard",
                "Which CSS property enforces smooth snap points when scrolling through horizontal card carousels?",
                Arrays.asList("scroll-snap-type: x mandatory;", "scroll-lock: horizontal;", "carousel-snap: true;", "scroll-behavior: snap;"),
                "scroll-snap-type: x mandatory;",
                "scroll-snap-type (on container) and scroll-snap-align (on children) enforce touch carousel scroll snapping."));
        list.add(new Question("CSS_H_19", cat, "Hard",
                "Which property visually hides content on screen while keeping it accessible to screen reader voice synthesisers?",
                Arrays.asList("Clip-path / sr-only CSS pattern (position: absolute; width: 1px; height: 1px; overflow: hidden; clip: rect(0,0,0,0);)", "display: none;", "visibility: hidden;", "opacity: 0; pointer-events: none;"),
                "Clip-path / sr-only CSS pattern (position: absolute; width: 1px; height: 1px; overflow: hidden; clip: rect(0,0,0,0);)",
                "The sr-only/visually-hidden utility pattern clips rendering bounds without removing node from accessibility tree."));
        list.add(new Question("CSS_H_20", cat, "Hard",
                "What is the CSS `subgrid` feature in CSS Grid layout level 2?",
                Arrays.asList("Allows nested grid items to inherit track definition lines and alignment directly from parent grid", "Creates a sub-element inside flexbox", "Compiles grid to table", "Generates 3D grid layout"),
                "Allows nested grid items to inherit track definition lines and alignment directly from parent grid",
                "grid-template-columns: subgrid allows nested child grids to participate in parent track alignment."));
        list.add(new Question("CSS_H_21", cat, "Hard",
                "What does `:focus-within` match?",
                Arrays.asList("An element if the element itself or ANY of its descendants currently has focus", "Element with mouse hover", "Active link", "Element inside iframe"),
                "An element if the element itself or ANY of its descendants currently has focus",
                ":focus-within matches container elements whenever any nested child element receives focus."));
        list.add(new Question("CSS_H_22", cat, "Hard",
                "What does `:focus-visible` match compared to standard `:focus`?",
                Arrays.asList("Matches focus indicator state ONLY when browser heuristics determine focus should be visibly indicated (e.g., keyboard tab navigation)", "Matches all mouse clicks", "Matches hidden inputs", "Matches hover states"),
                "Matches focus indicator state ONLY when browser heuristics determine focus should be visibly indicated (e.g., keyboard tab navigation)",
                ":focus-visible avoids drawing focus rings on mouse clicks while displaying them for keyboard tab users."));
        list.add(new Question("CSS_H_23", cat, "Hard",
                "Which CSS declaration forces an element onto its own hardware-accelerated GPU Compositor layer?",
                Arrays.asList("transform: translateZ(0);", "position: absolute;", "display: flex;", "border: 1px solid transparent;"),
                "transform: translateZ(0);",
                "translateZ(0) or translate3d(0,0,0) triggers GPU layer promotion in browser rendering engine."));
        list.add(new Question("CSS_H_24", cat, "Hard",
                "How do you prevent flex items from shrinking smaller than their inner content size?",
                Arrays.asList("Set `min-width: 0;` or `flex-shrink: 0;` depending on desired container behavior", "Add margin: auto", "Set display: block", "Use word-break: keep-all"),
                "Set `min-width: 0;` or `flex-shrink: 0;` depending on desired container behavior",
                "Flex items have `min-width: auto` default; setting min-width: 0 allows flex shrinking below content size when clipping."));
        list.add(new Question("CSS_H_25", cat, "Hard",
                "What is the difference between `ch` and `ex` units in CSS?",
                Arrays.asList("`ch` is width of character '0'; `ex` is x-height of current font font-size", "`ch` is column height; `ex` is exact pixels", "They are identical", "`ex` is extra large"),
                "`ch` is width of character '0'; `ex` is x-height of current font font-size",
                "ch equals width of character '0', ex equals x-height of lowercase 'x' in active font."));
        list.add(new Question("CSS_H_26", cat, "Hard",
                "What is the result of `margin-top` applied on an inline element like `<span>` without altering display property?",
                Arrays.asList("Top and bottom margins have NO effect on inline non-replaced elements", "Pushes content down by margin height", "Causes line break", "Hides text"),
                "Top and bottom margins have NO effect on inline non-replaced elements",
                "Vertical margins (top/bottom) have no layout effect on non-replaced inline elements."));
        list.add(new Question("CSS_H_27", cat, "Hard",
                "What does `isolation: isolate;` do in CSS?",
                Arrays.asList("Creates a new stacking context explicitly without requiring transforms or opacity changes", "Hides element from DOM", "Prevents CSS inheritance", "Isolates element from grid"),
                "Creates a new stacking context explicitly without requiring transforms or opacity changes",
                "isolation: isolate creates a new stacking context safely without visual side effects."));
        list.add(new Question("CSS_H_28", cat, "Hard",
                "What does `align-content` do in Flexbox?",
                Arrays.asList("Aligns multi-line flex tracks along cross axis when extra space exists", "Aligns single items inside flex row", "Aligns text horizontally", "Sets flex row height"),
                "Aligns multi-line flex tracks along cross axis when extra space exists",
                "align-content controls spacing between multiple line tracks in wrapped flex containers."));
        list.add(new Question("CSS_H_29", cat, "Hard",
                "What is the effect of `grid-auto-flow: dense;` in a grid layout?",
                Arrays.asList("Attempts to fill in visual grid gaps earlier in layout if smaller items fit later", "Increases font density", "Disables grid gaps", "Forces single column"),
                "Attempts to fill in visual grid gaps earlier in layout if smaller items fit later",
                "dense packing algorithm backfills empty grid gaps with smaller out-of-order items."));
        list.add(new Question("CSS_H_30", cat, "Hard",
                "Which CSS property controls how background image colors mix with element background colors?",
                Arrays.asList("background-blend-mode", "mix-blend-mode", "color-interpolation", "filter-blend"),
                "background-blend-mode",
                "background-blend-mode blends background images and colors of a single element box."));
        list.add(new Question("CSS_H_31", cat, "Hard",
                "Which property controls how an element's content blends with layers behind it across DOM elements?",
                Arrays.asList("mix-blend-mode", "background-blend-mode", "composite-mode", "opacity-blend"),
                "mix-blend-mode",
                "mix-blend-mode defines blending between an element and its underlying parent DOM elements."));
        list.add(new Question("CSS_H_32", cat, "Hard",
                "What is cubic-bezier timing function `transition-timing-function: cubic-bezier(0.25, 0.1, 0.25, 1);`?",
                Arrays.asList("Mathematical Bézier curve defining transition velocity speed rate acceleration profile over time", "3D rotation matrix", "Color interpolation formula", "Keyframe loop step"),
                "Mathematical Bézier curve defining transition velocity speed rate acceleration profile over time",
                "cubic-bezier defines custom acceleration easing curves for transitions/animations."));
        list.add(new Question("CSS_H_33", cat, "Hard",
                "What is the aspect-ratio property introduced in modern CSS?",
                Arrays.asList("Explicitly sets preferred width-to-height ratio for box sizing (`aspect-ratio: 16 / 9;`)", "Scales viewport width", "Resizes screen resolution", "Rotates images"),
                "Explicitly sets preferred width-to-height ratio for box sizing (`aspect-ratio: 16 / 9;`)",
                "aspect-ratio sets a target dimensional aspect ratio for box sizing calculations."));
        list.add(new Question("CSS_H_34", cat, "Hard",
                "What does `@property` at-rule in modern CSS allow developers to do?",
                Arrays.asList("Explicitly define custom property types, initial values, and inheritance behavior for CSS variable animation", "Create new HTML attributes", "Define JavaScript object types", "Override browser settings"),
                "Explicitly define custom property types, initial values, and inheritance behavior for CSS variable animation",
                "@property registers CSS custom properties with strict type syntax checking and animatable data types."));
        list.add(new Question("CSS_H_35", cat, "Hard",
                "What does `all: unset;` do on an element?",
                Arrays.asList("Resets all CSS properties to inherited values if inherited, or initial values if non-inherited", "Deletes element", "Hides text content", "Removes CSS class"),
                "Resets all CSS properties to inherited values if inherited, or initial values if non-inherited",
                "all: unset resets all element CSS declarations to inherit/initial default behavior."));
        list.add(new Question("CSS_H_36", cat, "Hard",
                "What does `all: revert;` do?",
                Arrays.asList("Rolls back all property values to default browser user-agent stylesheet origin values", "Reverses animation order", "Undoes last JS mutation", "Resets to initial spec"),
                "Rolls back all property values to default browser user-agent stylesheet origin values",
                "revert rolls back properties to user-agent default browser styles."));
        list.add(new Question("CSS_H_37", cat, "Hard",
                "What causes Layout Thrashing in JavaScript DOM interactions?",
                Arrays.asList("Interleaving repetitive DOM writes followed immediately by synchronous DOM layout reads forcing recalculations", "Downloading large images", "Using flexbox", "Executing keyframe loops"),
                "Interleaving repetitive DOM writes followed immediately by synchronous DOM layout reads forcing recalculations",
                "Repeated write-then-read cycles force browsers to perform forced synchronous layout recalculations."));
        list.add(new Question("CSS_H_38", cat, "Hard",
                "How do you prevent text wrapping on line breaks inside a flex or block container?",
                Arrays.asList("white-space: nowrap;", "text-wrap: no-break;", "overflow: fixed;", "word-break: stop;"),
                "white-space: nowrap;",
                "white-space: nowrap prevents text content from wrapping onto new lines."));
        list.add(new Question("CSS_H_39", cat, "Hard",
                "What does `::marker` pseudo-element style?",
                Arrays.asList("The bullet point or number indicator box of list items (`<li>`)", "Text selections", "First letter", "Form input highlight"),
                "The bullet point or number indicator box of list items (`<li>`)",
                "::marker targets bullet points or numbers of list items."));
        list.add(new Question("CSS_H_40", cat, "Hard",
                "What does `::selection` style?",
                Arrays.asList("The visual portion of document highlighted/selected by user pointer cursor", "Selected dropdown option", "Focused input", "Active button"),
                "The visual portion of document highlighted/selected by user pointer cursor",
                "::selection customizes background and color of text selected by user pointer."));
        list.add(new Question("CSS_H_41", cat, "Hard",
                "Which value of `animation-play-state` pauses an ongoing CSS keyframe animation?",
                Arrays.asList("animation-play-state: paused;", "animation-state: stop;", "animation-status: frozen;", "animation-loop: pause;"),
                "animation-play-state: paused;",
                "animation-play-state: paused halts animation keyframe execution at current timestamp."));
        list.add(new Question("CSS_H_42", cat, "Hard",
                "Which property specifies alignment of ENTIRE grid columns tracks within container along inline axis?",
                Arrays.asList("justify-content", "align-items", "justify-items", "align-self"),
                "justify-content",
                "justify-content aligns entire grid track layout within grid container horizontally."));
        list.add(new Question("CSS_H_43", cat, "Hard",
                "Which property specifies alignment of content INSIDE individual grid cells horizontally?",
                Arrays.asList("justify-items", "justify-content", "align-content", "grid-align"),
                "justify-items",
                "justify-items aligns item elements inside their assigned grid area cells along inline axis."));
        list.add(new Question("CSS_H_44", cat, "Hard",
                "What does `overscroll-behavior: contain;` prevent?",
                Arrays.asList("Prevents scroll chaining overflow from passing to parent body scroll container when edge is reached", "Disables scrolling", "Hides scrollbars", "Locks horizontal scrolling"),
                "Prevents scroll chaining overflow from passing to parent body scroll container when edge is reached",
                "overscroll-behavior: contain prevents scroll boundary propagation (scroll chaining) to parent scrollports."));
        list.add(new Question("CSS_H_45", cat, "Hard",
                "Which CSS property controls optical kerning and ligatures in advanced font rendering?",
                Arrays.asList("font-feature-settings", "font-kerning", "both font-feature-settings and font-kerning", "text-rendering"),
                "both font-feature-settings and font-kerning",
                "font-feature-settings and font-kerning configure OpenType font ligatures and kerning features."));
        list.add(new Question("CSS_H_46", cat, "Hard",
                "Which value of `font-display` minimizes Flash of Unstyled Text (FOUT) by rendering invisible text briefly during web font load?",
                Arrays.asList("font-display: swap;", "font-display: block;", "font-display: fallback;", "font-display: auto;"),
                "font-display: swap;",
                "font-display: swap uses fallback system font immediately, swapping custom font when loaded."));
        list.add(new Question("CSS_H_47", cat, "Hard",
                "What happens when two CSS selectors have IDENTICAL specificity weight and apply to same element?",
                Arrays.asList("The selector declared LATER in CSS document order wins and applies styles", "The first selector wins", "Neither applies", "Styles merge randomly"),
                "The selector declared LATER in CSS document order wins and applies styles",
                "When specificity is tied, the rule appearing last in document source order takes precedence."));
        list.add(new Question("CSS_H_48", cat, "Hard",
                "What does `min(50vw, 500px)` return for element width?",
                Arrays.asList("Returns whichever value is SMALLER between 50vw and 500px", "Returns 50vw always", "Returns 500px always", "Returns average"),
                "Returns whichever value is SMALLER between 50vw and 500px",
                "min() selects the minimum calculated value among parameters."));
        list.add(new Question("CSS_H_49", cat, "Hard",
                "What does `max(10vw, 300px)` return for element width?",
                Arrays.asList("Returns whichever value is LARGER between 10vw and 300px", "Returns 10vw always", "Returns 300px always", "Returns sum"),
                "Returns whichever value is LARGER between 10vw and 300px",
                "max() selects the maximum calculated value among parameters."));
        list.add(new Question("CSS_H_50", cat, "Hard",
                "What does `writing-mode: vertical-rl;` do to text flow layout?",
                Arrays.asList("Changes inline text flow orientation to vertical running top-to-bottom, right-to-left", "Rotates text 180 degrees", "Flips text upside down", "Renders text backwards"),
                "Changes inline text flow orientation to vertical running top-to-bottom, right-to-left",
                "writing-mode configures text line orientation (e.g. vertical-rl for East Asian layout)."));
    }
}
