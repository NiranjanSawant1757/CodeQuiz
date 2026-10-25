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

        // --- EASY (17) ---
        list.add(new Question("CSS_01", cat, "Easy",
                "What does CSS stand for in web development?",
                Arrays.asList("Cascading Style Sheets", "Creative Style System", "Computer Style Sheets", "Colorful Style System"),
                "Cascading Style Sheets", "CSS stands for Cascading Style Sheets, used to style HTML markup."));

        list.add(new Question("CSS_02", cat, "Easy",
                "Which CSS property is used to change the background color of an element?",
                Arrays.asList("background-color", "color", "bgcolor", "canvas-color"),
                "background-color", "'background-color' sets the background color of an element."));

        list.add(new Question("CSS_03", cat, "Easy",
                "Which CSS property controls the text color of an element?",
                Arrays.asList("color", "text-color", "font-color", "foreground"),
                "color", "The 'color' property specifies the foreground color of text."));

        list.add(new Question("CSS_04", cat, "Easy",
                "Which symbol is used to select elements by class name in CSS?",
                Arrays.asList(". (period/dot)", "# (hash)", "* (asterisk)", "@ (at)"),
                ". (period/dot)", "Class selectors begin with a period (e.g. .button)."));

        list.add(new Question("CSS_05", cat, "Easy",
                "Which symbol is used to select an element by its ID in CSS?",
                Arrays.asList("# (hash)", ". (dot)", "$ (dollar)", "& (ampersand)"),
                "# (hash)", "ID selectors are preceded by the hash symbol (e.g. #header)."));

        list.add(new Question("CSS_06", cat, "Easy",
                "Which property controls the size of text in CSS?",
                Arrays.asList("font-size", "text-size", "font-weight", "text-scale"),
                "font-size", "'font-size' sets the size of the font (e.g. 16px, 1.2rem)."));

        list.add(new Question("CSS_07", cat, "Easy",
                "What is the default value of the 'position' property in CSS?",
                Arrays.asList("static", "relative", "absolute", "fixed"),
                "static", "HTML elements are positioned static by default, according to the normal page flow."));

        list.add(new Question("CSS_08", cat, "Easy",
                "Which property is used to create space INSIDE the border of an element?",
                Arrays.asList("padding", "margin", "border-spacing", "outline"),
                "padding", "Padding generates space between the content and the element border."));

        list.add(new Question("CSS_09", cat, "Easy",
                "Which property creates space OUTSIDE the border of an element?",
                Arrays.asList("margin", "padding", "gap", "spacing"),
                "margin", "Margin generates empty space outside an element's border."));

        list.add(new Question("CSS_10", cat, "Easy",
                "Which CSS property is used to make text bold?",
                Arrays.asList("font-weight: bold;", "text-decoration: bold;", "font-style: bold;", "text-transform: uppercase;"),
                "font-weight: bold;", "'font-weight' sets how thick or thin characters in text should be displayed."));

        list.add(new Question("CSS_11", cat, "Easy",
                "Which property removes the underline from hyperlinks?",
                Arrays.asList("text-decoration: none;", "underline: none;", "font-style: plain;", "border: none;"),
                "text-decoration: none;", "Anchor tags by default have text-decoration: underline; setting it to none removes the line."));

        list.add(new Question("CSS_12", cat, "Easy",
                "How do you center text horizontally inside its container in CSS?",
                Arrays.asList("text-align: center;", "align: center;", "margin: center;", "vertical-align: middle;"),
                "text-align: center;", "The 'text-align: center;' property centers inline or text content horizontally."));

        list.add(new Question("CSS_13", cat, "Easy",
                "Which CSS property controls whether an element is visible or hidden without removing it from the layout flow?",
                Arrays.asList("visibility: hidden;", "display: none;", "opacity: 0;", "clear: both;"),
                "visibility: hidden;", "'visibility: hidden' hides the element while retaining its physical space in layout; display: none removes it entirely."));

        list.add(new Question("CSS_14", cat, "Easy",
                "What unit is relative to the font-size of the root ('<html>') element?",
                Arrays.asList("rem", "em", "px", "%"),
                "rem", "'rem' (root em) is relative to the font size of the root HTML element."));

        list.add(new Question("CSS_15", cat, "Easy",
                "Which CSS property rounds the corners of an element's border?",
                Arrays.asList("border-radius", "corner-curve", "border-round", "box-radius"),
                "border-radius", "'border-radius' rounds outer border corners."));

        list.add(new Question("CSS_16", cat, "Easy",
                "How do you write a comment in a CSS file?",
                Arrays.asList("/* This is a comment */", "// This is a comment", "<!-- This is a comment -->", "# This is a comment"),
                "/* This is a comment */", "CSS comments are enclosed inside /* and */."));

        list.add(new Question("CSS_17", cat, "Easy",
                "Which property controls the transparency or opacity level of an element?",
                Arrays.asList("opacity", "transparent", "alpha", "filter"),
                "opacity", "The 'opacity' property specifies the transparency of an element from 0.0 to 1.0."));

        // --- MEDIUM (17) ---
        list.add(new Question("CSS_18", cat, "Medium",
                "What is the CSS Box Model composed of, from the inside out?",
                Arrays.asList("Content -> Padding -> Border -> Margin", "Content -> Margin -> Border -> Padding", "Border -> Padding -> Content -> Margin", "Content -> Outline -> Border -> Margin"),
                "Content -> Padding -> Border -> Margin", "The CSS Box Model consists of content in the center, wrapped by padding, border, and outermost margin."));

        list.add(new Question("CSS_19", cat, "Medium",
                "What is the effect of setting 'box-sizing: border-box;'?",
                Arrays.asList("Padding and border are included in the element's total specified width and height", "Padding is added outside the width", "Borders are hidden", "Margins are calculated automatically"),
                "Padding and border are included in the element's total specified width and height", "'border-box' ensures width and height include padding and border, making responsive sizing intuitive."));

        list.add(new Question("CSS_20", cat, "Medium",
                "What is the difference between 'position: relative;' and 'position: absolute;'?",
                Arrays.asList("Relative offsets from its normal flow position; absolute positions relative to the nearest positioned ancestor", "Absolute is in normal flow; relative is outside flow", "Relative cannot use top/left", "They are identical"),
                "Relative offsets from its normal flow position; absolute positions relative to the nearest positioned ancestor", "Absolute elements are removed from normal flow and positioned relative to the nearest ancestor with position other than static."));

        list.add(new Question("CSS_21", cat, "Medium",
                "What is CSS Flexbox primarily designed for?",
                Arrays.asList("One-dimensional layout along either a row or a column", "Two-dimensional grid layouts", "3D WebGL animations", "Database query styling"),
                "One-dimensional layout along either a row or a column", "Flexbox provides dynamic space distribution and alignment along a single axis (row or column)."));

        list.add(new Question("CSS_22", cat, "Medium",
                "Which Flexbox property aligns flex items along the main axis?",
                Arrays.asList("justify-content", "align-items", "align-content", "flex-direction"),
                "justify-content", "'justify-content' distributes free space along the flex container's main axis."));

        list.add(new Question("CSS_23", cat, "Medium",
                "Which Flexbox property aligns flex items along the cross axis?",
                Arrays.asList("align-items", "justify-content", "flex-wrap", "order"),
                "align-items", "'align-items' specifies alignment of items along the cross axis."));

        list.add(new Question("CSS_24", cat, "Medium",
                "What is CSS Specificity hierarchy order from highest to lowest?",
                Arrays.asList("Inline styles > IDs > Classes/Attributes/Pseudo-classes > Elements/Pseudo-elements", "IDs > Inline styles > Classes > Elements", "Classes > IDs > Elements", "Elements > Classes > IDs"),
                "Inline styles > IDs > Classes/Attributes/Pseudo-classes > Elements/Pseudo-elements", "Specificity determines which CSS rules apply: style=\"\" (1000) > #id (100) > .class (10) > element (1)."));

        list.add(new Question("CSS_25", cat, "Medium",
                "What does '@media (max-width: 768px)' accomplish in responsive web design?",
                Arrays.asList("Applies CSS rules only when the screen viewport width is 768px or narrower", "Scales screen to 768px", "Disables CSS on mobile", "Enforces maximum font size"),
                "Applies CSS rules only when the screen viewport width is 768px or narrower", "Media queries allow conditional CSS rendering based on device characteristics like viewport width."));

        list.add(new Question("CSS_26", cat, "Medium",
                "What is the difference between ':hover' and ':active' pseudo-classes?",
                Arrays.asList("':hover' applies when mouse hovers over an element; ':active' applies while the element is being clicked/pressed", "':active' is for hover; ':hover' is for clicks", "':active' applies only to links", "They are identical"),
                "':hover' applies when mouse hovers over an element; ':active' applies while the element is being clicked/pressed", ":hover activates on cursor hover; :active triggers during mouse-down/activation."));

        list.add(new Question("CSS_27", cat, "Medium",
                "What is CSS Grid Layout primarily designed for?",
                Arrays.asList("Two-dimensional layouts involving rows and columns simultaneously", "One-dimensional inline text", "Styling database tables only", "Vector drawing"),
                "Two-dimensional layouts involving rows and columns simultaneously", "CSS Grid is a 2D layout system designed to manage both rows and columns at once."));

        list.add(new Question("CSS_28", cat, "Medium",
                "What does 'z-index' control in CSS?",
                Arrays.asList("The vertical stacking order of overlapping elements along the z-axis (depth)", "Zoom level of the page", "Font rendering sharpness", "Horizontal positioning"),
                "The vertical stacking order of overlapping elements along the z-axis (depth)", "z-index determines which positioned element sits in front of or behind others."));

        list.add(new Question("CSS_29", cat, "Medium",
                "What does the 'inherit' keyword do when assigned to a CSS property value?",
                Arrays.asList("Forces the property to take the computed value of the parent element", "Resets to browser default", "Deletes the style", "Makes the property global"),
                "Forces the property to take the computed value of the parent element", "'inherit' explicitly inherits the property value from the parent element."));

        list.add(new Question("CSS_30", cat, "Medium",
                "What is a CSS variable (Custom Property) syntax and how is it accessed?",
                Arrays.asList("Declared with '--var-name: value;' and accessed via 'var(--var-name)'", "Declared with '$var' and accessed with '$var'", "Declared with '@var' and accessed with '@var'", "Declared with 'let var'"),
                "Declared with '--var-name: value;' and accessed via 'var(--var-name)'", "Native CSS variables use double hyphens (--primary-color: #2563eb;) accessed via var(--primary-color)."));

        list.add(new Question("CSS_31", cat, "Medium",
                "What does 'overflow: hidden;' do when child elements exceed the boundaries of their parent container?",
                Arrays.asList("Clips the content so that any overflowing parts are invisible outside the container boundaries", "Adds a scrollbar", "Expands parent container dynamically", "Throws a CSS warning"),
                "Clips the content so that any overflowing parts are invisible outside the container boundaries", "'overflow: hidden' prevents content from spilling out, clipping anything outside the box."));

        list.add(new Question("CSS_32", cat, "Medium",
                "What is the difference between 'display: none;' and 'opacity: 0;' regarding user interaction?",
                Arrays.asList("'display: none;' removes the element completely; 'opacity: 0;' keeps it interactive and clickable in layout", "Opacity: 0 removes element from DOM", "Display: none remains clickable", "There is no difference"),
                "'display: none;' removes the element completely; 'opacity: 0;' keeps it interactive and clickable in layout", "An element with opacity: 0 remains in layout, responds to clicks/hovers, and occupies space."));

        list.add(new Question("CSS_33", cat, "Medium",
                "What does the 'transition' property do in CSS?",
                Arrays.asList("Smoothly animates property changes over a specified duration rather than changing instantaneously", "Navigates between URLs", "Transforms HTML into JSX", "Changes language translations"),
                "Smoothly animates property changes over a specified duration rather than changing instantaneously", "Transitions interpolate CSS property values over time on state changes (e.g. hover)."));

        list.add(new Question("CSS_34", cat, "Medium",
                "What does 'cursor: pointer;' do when placed on a button or card?",
                Arrays.asList("Changes the mouse cursor to a pointing hand icon indicating clickability", "Hides the cursor", "Freezes the cursor", "Locks mouse movement"),
                "Changes the mouse cursor to a pointing hand icon indicating clickability", "'cursor: pointer' displays the standard hand indicator for clickable elements."));

        // --- HARD (16) ---
        list.add(new Question("CSS_35", cat, "Hard",
                "What is a Block Formatting Context (BFC) in CSS and what does it achieve?",
                Arrays.asList("An isolated layout rendering region that clears internal floats and prevents margin collapse with outer elements", "A 3D perspective context", "A flexbox container mode", "A print media stylesheet"),
                "An isolated layout rendering region that clears internal floats and prevents margin collapse with outer elements", "A BFC contains floats, prevents adjoining margins from collapsing, and stops elements from overlapping floats."));

        list.add(new Question("CSS_36", cat, "Hard",
                "What is Margin Collapsing and under what conditions does it occur?",
                Arrays.asList("Top and bottom margins of adjoining in-flow block elements merge into a single margin equal to the largest one", "Left and right margins sum together", "Margins become negative automatically", "Margins disappear inside grid cells"),
                "Top and bottom margins of adjoining in-flow block elements merge into a single margin equal to the largest one", "Vertical margins of adjacent block elements collapse into a single margin, unless separated by borders, padding, or BFCs."));

        list.add(new Question("CSS_37", cat, "Hard",
                "What is a Stacking Context in CSS and what properties create one?",
                Arrays.asList("A 3D conceptualization of HTML elements created by properties like opacity < 1, transform != none, or position with z-index", "A vertical flexbox list", "A queue of CSS animations", "A grid track"),
                "A 3D conceptualization of HTML elements created by properties like opacity < 1, transform != none, or position with z-index", "A stacking context isolates internal z-indices, preventing children from escaping the parent's layer order relative to outside elements."));

        list.add(new Question("CSS_38", cat, "Hard",
                "What does the 'will-change' CSS property do and why should it be used sparingly?",
                Arrays.asList("Hints to the browser to promote the element to a separate GPU compositor layer, trading memory for smooth animation", "Forces immediate repaint on CPU", "Changes element tag dynamically", "Validates syntax before load"),
                "Hints to the browser to promote the element to a separate GPU compositor layer, trading memory for smooth animation", "'will-change' prepares GPU resources ahead of time, but overuse consumes excessive device VRAM and harms performance."));

        list.add(new Question("CSS_39", cat, "Hard",
                "What is the difference between CSS Reflow (Layout) and Repaint?",
                Arrays.asList("Reflow recalculates geometry and layout of elements (expensive); Repaint redraws pixels without changing geometry", "Repaint is slower than Reflow", "Reflow only changes colors", "They are identical rendering steps"),
                "Reflow recalculates geometry and layout of elements (expensive); Repaint redraws pixels without changing geometry", "Changing dimensions triggers layout/reflow and subsequent repaint; changing color only triggers repaint."));

        list.add(new Question("CSS_40", cat, "Hard",
                "Which CSS properties can be animated using the GPU compositor without triggering reflow or repaint?",
                Arrays.asList("transform and opacity", "width and height", "margin and padding", "top and left"),
                "transform and opacity", "Modern browsers composite transform and opacity on the GPU thread without triggering main-thread layout or paint."));

        list.add(new Question("CSS_41", cat, "Hard",
                "What does the ':has()' relational pseudo-class ('parent:has(child)') allow in modern CSS?",
                Arrays.asList("Selecting a parent or ancestor element based on the presence of matching descendant elements", "Checking if an element has text", "Validating if CSS is supported", "Adding multiple classes"),
                "Selecting a parent or ancestor element based on the presence of matching descendant elements",
                ":has() acts as a parent selector, applying styles to an element if a specified descendant or sibling condition is met."));

        list.add(new Question("CSS_42", cat, "Hard",
                "What is CSS Container Queries ('@container') compared to Media Queries ('@media')?",
                Arrays.asList("Applies styles based on the dimensions of a parent container rather than the entire browser viewport", "Applies styles inside Docker containers", "Restricts styles to mobile containers", "Queries database servers"),
                "Applies styles based on the dimensions of a parent container rather than the entire browser viewport", "Container queries allow components to adapt modularly according to the size of their containing box."));

        list.add(new Question("CSS_43", cat, "Hard",
                "What are CSS Cascade Layers ('@layer') used for?",
                Arrays.asList("Controlling the precedence order of style declarations regardless of specificity", "Drawing layer masks on images", "Layering z-index stacks", "Managing browser caching layers"),
                "Controlling the precedence order of style declarations regardless of specificity",
                "@layer allows developers to order specificity pools (e.g. reset < framework < utilities) to prevent specificity wars."));

        list.add(new Question("CSS_44", cat, "Hard",
                "What does 'contain: layout paint;' accomplish in CSS Containment?",
                Arrays.asList("Isolates an element's subtree from the rest of the page so browser reflows inside don't propagate outward", "Compresses image memory", "Locks element dimensions", "Hides content from screen readers"),
                "Isolates an element's subtree from the rest of the page so browser reflows inside don't propagate outward", "CSS containment optimizes rendering performance by informing the engine that a subtree is self-contained."));

        list.add(new Question("CSS_45", cat, "Hard",
                "What does 'subgrid' allow in CSS Grid Level 2 ('grid-template-columns: subgrid;')?",
                Arrays.asList("A nested grid item adopts the rows and columns tracks of its parent grid, aligning deeply nested elements", "Creates an independent sub-grid", "Halves grid cell spacing", "Exports grid to SVG"),
                "A nested grid item adopts the rows and columns tracks of its parent grid, aligning deeply nested elements", "Subgrid enables child grids to participate in and align with the parent grid's tracks."));

        list.add(new Question("CSS_46", cat, "Hard",
                "What does the 'accent-color' CSS property do in modern browsers?",
                Arrays.asList("Sets the accent color for native form controls like checkboxes, radio buttons, and range sliders", "Applies a drop-shadow glow", "Sets the text selection highlight", "Changes browser title bar color"),
                "Sets the accent color for native form controls like checkboxes, radio buttons, and range sliders", "'accent-color' customizes native user-interface form controls to match brand palettes with a single rule."));

        list.add(new Question("CSS_47", cat, "Hard",
                "What is the difference between 'em' and 'ch' CSS units?",
                Arrays.asList("'em' is relative to element font-size; 'ch' is equal to the width of the zero character ('0') in the current font", "'ch' is centimeters; 'em' is millimeters", "'em' is for heights; 'ch' is for weights", "There is no difference"),
                "'em' is relative to element font-size; 'ch' is equal to the width of the zero character ('0') in the current font", "1ch equals the advance measure of the glyph '0', making it ideal for sizing paragraph reading widths (e.g. max-width: 65ch)."));

        list.add(new Question("CSS_48", cat, "Hard",
                "What does 'font-display: swap;' do in '@font-face' declarations?",
                Arrays.asList("Displays fallback font immediately until custom webfont finishes loading, preventing Flash of Invisible Text (FOIT)", "Swaps between serif and sans-serif randomly", "Caches fonts in local storage", "Downsamples font file size"),
                "Displays fallback font immediately until custom webfont finishes loading, preventing Flash of Invisible Text (FOIT)", "'font-display: swap' gives the font an extremely small block period and an infinite swap period to eliminate FOIT."));

        list.add(new Question("CSS_49", cat, "Hard",
                "What does the CSS function 'clamp(min, preferred, max)' do?",
                Arrays.asList("Restricts a value between an allowable minimum and maximum while scaling with a preferred expression", "Rounds decimals to nearest integer", "Locks viewport zoom", "Animates values between steps"),
                "Restricts a value between an allowable minimum and maximum while scaling with a preferred expression", "clamp(1rem, 2.5vw, 2rem) enables responsive fluid typography without requiring multiple media queries."));

        list.add(new Question("CSS_50", cat, "Hard",
                "What is the effect of 'backdrop-filter: blur(10px);' in CSS?",
                Arrays.asList("Applies a graphical blur effect to the area behind the element (glassmorphism)", "Blurs the text inside the element", "Hides background image", "Creates a drop-shadow beneath the border"),
                "Applies a graphical blur effect to the area behind the element (glassmorphism)", "backdrop-filter applies filter effects to all content behind translucent or transparent elements."));

        return list;
    }
}
