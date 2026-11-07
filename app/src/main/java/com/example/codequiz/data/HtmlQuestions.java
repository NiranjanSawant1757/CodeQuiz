package com.example.codequiz.data;

import com.example.codequiz.model.Question;
import com.example.codequiz.util.AppConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HtmlQuestions {

    public static List<Question> get() {
        List<Question> list = new ArrayList<>();
        String cat = AppConstants.CAT_HTML;
        loadEasy(list, cat);
        loadMedium(list, cat);
        loadHard(list, cat);
        return list;
    }

    private static void loadEasy(List<Question> list, String cat) {
        list.add(new Question("HTML_E_01", cat, "Easy",
                "What does HTML stand for?",
                Arrays.asList("Hyper Text Markup Language", "High Text Machine Language", "Hyper Transfer Text Language", "Hyper Tool Markup Language"),
                "Hyper Text Markup Language",
                "HTML stands for Hyper Text Markup Language, the standard markup language for documents designed to be displayed in a web browser."));
        list.add(new Question("HTML_E_02", cat, "Easy",
                "Which declaration is mandatory at the top of an HTML5 document?",
                Arrays.asList("<!DOCTYPE html>", "<doctype html5>", "<?xml version=\"1.0\"?>", "<html version=\"5\">"),
                "<!DOCTYPE html>",
                "<!DOCTYPE html> instructs the browser to parse the document using the standard HTML5 rendering engine."));
        list.add(new Question("HTML_E_03", cat, "Easy",
                "Which HTML tag is the root element of an HTML page?",
                Arrays.asList("<head>", "<body>", "<html>", "<main>"),
                "<html>",
                "The <html> element encapsulates all content and sub-elements on an HTML document."));
        list.add(new Question("HTML_E_04", cat, "Easy",
                "Which HTML tag defines the most important or top-level heading?",
                Arrays.asList("<h6>", "<h1>", "<head>", "<heading>"),
                "<h1>",
                "<h1> defines the highest level heading in HTML document hierarchy."));
        list.add(new Question("HTML_E_05", cat, "Easy",
                "Which HTML element is used to define a paragraph?",
                Arrays.asList("<p>", "<para>", "<pg>", "<text>"),
                "<p>",
                "The <p> element represents a paragraph of text."));
        list.add(new Question("HTML_E_06", cat, "Easy",
                "Which element is used to insert a line break without starting a new paragraph?",
                Arrays.asList("<lb>", "<br>", "<break>", "<hr>"),
                "<br>",
                "The <br> element produces a line break in text (an inline newline)."));
        list.add(new Question("HTML_E_07", cat, "Easy",
                "Which attribute specifies the URL of the page the link goes to in an <a> tag?",
                Arrays.asList("src", "href", "link", "target"),
                "href",
                "The 'href' attribute specifies the hyperlink target URL."));
        list.add(new Question("HTML_E_08", cat, "Easy",
                "Which attribute of the <img> tag specifies an alternate text if the image cannot be displayed?",
                Arrays.asList("title", "src", "alt", "desc"),
                "alt",
                "The 'alt' attribute provides alternative text for accessibility and broken image fallback."));
        list.add(new Question("HTML_E_09", cat, "Easy",
                "Which HTML tag is used to create an ordered (numbered) list?",
                Arrays.asList("<ul>", "<ol>", "<li>", "<dl>"),
                "<ol>",
                "The <ol> element creates an ordered list of items."));
        list.add(new Question("HTML_E_10", cat, "Easy",
                "Which HTML tag is used to create an unordered (bulleted) list?",
                Arrays.asList("<ul>", "<ol>", "<list>", "<dl>"),
                "<ul>",
                "The <ul> element creates an unordered list."));
        list.add(new Question("HTML_E_11", cat, "Easy",
                "Which tag defines an individual list item inside <ul> or <ol>?",
                Arrays.asList("<item>", "<li>", "<list>", "<it>"),
                "<li>",
                "The <li> tag represents an individual item inside a list."));
        list.add(new Question("HTML_E_12", cat, "Easy",
                "Which tag is used to define a table row in HTML?",
                Arrays.asList("<td>", "<th>", "<tr>", "<table-row>"),
                "<tr>",
                "The <tr> tag defines a table row containing cells."));
        list.add(new Question("HTML_E_13", cat, "Easy",
                "Which tag defines a standard data cell inside an HTML table row?",
                Arrays.asList("<td>", "<th>", "<tr>", "<cell>"),
                "<td>",
                "The <td> tag defines a standard data cell in a table."));
        list.add(new Question("HTML_E_14", cat, "Easy",
                "Which tag defines a header cell in an HTML table, rendering text bold and centered by default?",
                Arrays.asList("<td>", "<th>", "<head>", "<caption >"),
                "<th>",
                "The <th> tag defines a header cell in a table."));
        list.add(new Question("HTML_E_15", cat, "Easy",
                "Which element is used to create an interactive form for user input?",
                Arrays.asList("<input>", "<form>", "<field>", "<userform>"),
                "<form>",
                "The <form> element wraps form controls and handles submission behavior."));
        list.add(new Question("HTML_E_16", cat, "Easy",
                "What is the default 'type' attribute value for an <input> tag if omitted?",
                Arrays.asList("text", "password", "submit", "button"),
                "text",
                "If type is not specified, an <input> element defaults to type=\"text\"."));
        list.add(new Question("HTML_E_17", cat, "Easy",
                "Which input type allows users to select only ONE option from a group?",
                Arrays.asList("checkbox", "radio", "select", "one"),
                "radio",
                "Radio buttons sharing the same 'name' attribute form a group where only one option can be selected."));
        list.add(new Question("HTML_E_18", cat, "Easy",
                "Which input type creates a clickable button that submits form data to the server?",
                Arrays.asList("type=\"submit\"", "type=\"button\"", "type=\"send\"", "type=\"post\""),
                "type=\"submit\"",
                "An input with type=\"submit\" submits the enclosing form."));
        list.add(new Question("HTML_E_19", cat, "Easy",
                "Which attribute on an <input> field makes it obligatory for the user to fill it before submitting?",
                Arrays.asList("validate", "mandatory", "required", "important"),
                "required",
                "The 'required' boolean attribute prevents form submission if the input field is empty."));
        list.add(new Question("HTML_E_20", cat, "Easy",
                "Which tag is a generic container used to group inline elements and text for styling?",
                Arrays.asList("<div>", "<span>", "<p>", "<section>"),
                "<span>",
                "The <span> tag is a generic inline container that takes up only as much width as necessary."));
        list.add(new Question("HTML_E_21", cat, "Easy",
                "Which tag is a generic block-level container used to structure content sections?",
                Arrays.asList("<span>", "<div>", "<a>", "<b>"),
                "<div>",
                "The <div> tag is a generic block-level container that starts on a new line and spans full width."));
        list.add(new Question("HTML_E_22", cat, "Easy",
                "Where are metadata and script/style declarations usually placed in an HTML file?",
                Arrays.asList("<body>", "<head>", "<footer>", "<meta>"),
                "<head>",
                "The <head> section contains document metadata, titles, styles, and external script links."));
        list.add(new Question("HTML_E_23", cat, "Easy",
                "Which attribute opens a linked document in a new browser tab or window in an <a> tag?",
                Arrays.asList("target=\"_blank\"", "target=\"_new\"", "window=\"new\"", "open=\"blank\""),
                "target=\"_blank\"",
                "target=\"_blank\" forces the browser to open the hyperlink in a new browsing context/tab."));
        list.add(new Question("HTML_E_24", cat, "Easy",
                "Which tag is used to draw a horizontal rule (thematic break) in HTML?",
                Arrays.asList("<line>", "<hr>", "<break>", "<rule>"),
                "<hr>",
                "The <hr> tag represents a thematic break between paragraph-level elements."));
        list.add(new Question("HTML_E_25", cat, "Easy",
                "How do you write a comment in HTML?",
                Arrays.asList("// This is a comment", "<!-- This is a comment -->", "/* This is a comment */", "' This is a comment"),
                "<!-- This is a comment -->",
                "HTML comments start with <!-- and end with -->."));
        list.add(new Question("HTML_E_26", cat, "Easy",
                "Which global attribute provides extra advisory information displayed as a tooltip on hover?",
                Arrays.asList("alt", "title", "tooltip", "hover"),
                "title",
                "The global 'title' attribute shows text as a tooltip when hovering over the element."));
        list.add(new Question("HTML_E_27", cat, "Easy",
                "Which element gives text strong importance, displaying it in bold by default?",
                Arrays.asList("<b>", "<strong>", "<em>", "<mark>"),
                "<strong>",
                "The <strong> tag indicates high importance, seriousness, or urgency, rendered bold."));
        list.add(new Question("HTML_E_28", cat, "Easy",
                "Which element marks text with stress emphasis, displaying it in italics by default?",
                Arrays.asList("<i>", "<em>", "<highlight>", "<mark>"),
                "<em>",
                "The <em> element represents stress emphasis, typically displayed in italics."));
        list.add(new Question("HTML_E_29", cat, "Easy",
                "Which HTML tag is used to link an external CSS stylesheet?",
                Arrays.asList("<style>", "<link>", "<script>", "<css>"),
                "<link>",
                "The <link> element with rel=\"stylesheet\" imports external CSS style files."));
        list.add(new Question("HTML_E_30", cat, "Easy",
                "Which tag is used to embed client-side JavaScript code in an HTML document?",
                Arrays.asList("<script>", "<js>", "<code >", "<javascript>"),
                "<script>",
                "The <script> tag embeds or references executable JavaScript code."));
        list.add(new Question("HTML_E_31", cat, "Easy",
                "Which tag provides a text label for a form control, improving usability and accessibility?",
                Arrays.asList("<label>", "<caption >", "<text>", "<title>"),
                "<label>",
                "The <label> tag associates textual descriptions with form controls using the 'for' attribute."));
        list.add(new Question("HTML_E_32", cat, "Easy",
                "Which attribute in a <label> connects it to the 'id' of its corresponding <input>?",
                Arrays.asList("to", "for", "input", "target"),
                "for",
                "The 'for' attribute on a <label> matches the 'id' attribute of the target input element."));
        list.add(new Question("HTML_E_33", cat, "Easy",
                "Which tag creates a multi-line text input field in a form?",
                Arrays.asList("<input type=\"multiline\">", "<textarea>", "<textfield>", "<input type=\"textarea\">"),
                "<textarea>",
                "The <textarea> tag provides a multi-line plain-text editing control."));
        list.add(new Question("HTML_E_34", cat, "Easy",
                "Which tag creates a drop-down menu in HTML forms?",
                Arrays.asList("<select>", "<dropdown>", "<option>", "<list>"),
                "<select>",
                "The <select> element creates a drop-down list of choices."));
        list.add(new Question("HTML_E_35", cat, "Easy",
                "Which tag defines individual choices inside a <select> drop-down list?",
                Arrays.asList("<choice>", "<option>", "<item>", "<listitem>"),
                "<option>",
                "<option> elements represent individual options in a <select> menu."));
        list.add(new Question("HTML_E_36", cat, "Easy",
                "Which tag defines the title of the document shown in the browser's tab?",
                Arrays.asList("<head>", "<title>", "<meta name=\"title\">", "<header>"),
                "<title>",
                "The <title> tag sets the title of the document in browser tabs and search engine results."));
        list.add(new Question("HTML_E_37", cat, "Easy",
                "Which tag is used to group body content in an HTML table?",
                Arrays.asList("<thead>", "<tbody>", "<tfoot>", "<tablebody>"),
                "<tbody>",
                "The <tbody> tag encapsulates the primary data rows of an HTML table."));
        list.add(new Question("HTML_E_38", cat, "Easy",
                "Which attribute merges multiple adjacent columns in an HTML table cell?",
                Arrays.asList("rowspan", "colspan", "merge", "span"),
                "colspan",
                "The 'colspan' attribute specifies the number of columns a cell should span across."));
        list.add(new Question("HTML_E_39", cat, "Easy",
                "Which attribute merges multiple adjacent rows in an HTML table cell?",
                Arrays.asList("rowspan", "colspan", "merge", "vspan"),
                "rowspan",
                "The 'rowspan' attribute specifies the number of rows a cell should span across."));
        list.add(new Question("HTML_E_40", cat, "Easy",
                "Which HTML entity code represents the copyright symbol (©)?",
                Arrays.asList("&copy;", "&copyright;", "&#c;", "&cp;"),
                "&copy;",
                "The entity &copy; displays the copyright symbol © in HTML."));
        list.add(new Question("HTML_E_41", cat, "Easy",
                "Which HTML entity code represents a non-breaking space?",
                Arrays.asList("&space;", "&nbsp;", "&nbsp", "&break;"),
                "&nbsp;",
                "The &nbsp; entity represents a non-breaking space character."));
        list.add(new Question("HTML_E_42", cat, "Easy",
                "What is the key difference between the 'id' and 'class' attributes?",
                Arrays.asList("'id' must be unique per page, whereas 'class' can be reused across multiple elements", "'class' must be unique, 'id' can be repeated", "'id' is only for CSS, 'class' is for JS", "There is no difference"),
                "'id' must be unique per page, whereas 'class' can be reused across multiple elements",
                "An 'id' must be unique within a document, while a 'class' can be applied to multiple elements."));
        list.add(new Question("HTML_E_43", cat, "Easy",
                "Which HTML5 tag is used to embed video content natively without third-party plugins?",
                Arrays.asList("<media>", "<video>", "<movie>", "<embed>"),
                "<video>",
                "The <video> tag natively embeds video files in HTML pages."));
        list.add(new Question("HTML_E_44", cat, "Easy",
                "Which HTML5 tag is used to embed audio content natively?",
                Arrays.asList("<sound>", "<audio>", "<music>", "<voice>"),
                "<audio>",
                "The <audio> tag natively embeds audio streams or files."));
        list.add(new Question("HTML_E_45", cat, "Easy",
                "Which global attribute makes an HTML element editable directly by the user on the page?",
                Arrays.asList("editable=\"true\"", "contenteditable=\"true\"", "modify=\"true\"", "user-editable"),
                "contenteditable=\"true\"",
                "The 'contenteditable' attribute enables direct user editing of element text."));
        list.add(new Question("HTML_E_46", cat, "Easy",
                "Which <meta> tag setting ensures correct mobile responsive viewport rendering?",
                Arrays.asList("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">", "<meta name=\"screen\" content=\"mobile\">", "<meta name=\"responsive\" content=\"true\">", "<meta name=\"zoom\" content=\"yes\">"),
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">",
                "The viewport meta tag configures dimensions and scaling on mobile devices."));
        list.add(new Question("HTML_E_47", cat, "Easy",
                "Which tag embeds another HTML document inside the current HTML page?",
                Arrays.asList("<embed>", "<iframe>", "<object>", "<frame>"),
                "<iframe>",
                "An <iframe> (inline frame) embeds an external HTML document into the current page."));
        list.add(new Question("HTML_E_48", cat, "Easy",
                "Which semantic tag defines introductory content, headers, or navigation for a page/section?",
                Arrays.asList("<top>", "<header>", "<head>", "<section>"),
                "<header>",
                "The <header> tag contains introductory or navigational elements."));
        list.add(new Question("HTML_E_49", cat, "Easy",
                "Which semantic tag defines footer content like copyright, terms, or contact information?",
                Arrays.asList("<bottom>", "<footer>", "<end>", "<contact>"),
                "<footer>",
                "The <footer> tag contains footer information for a document or section."));
        list.add(new Question("HTML_E_50", cat, "Easy",
                "Which semantic tag represents a section of page content designed for major navigation links?",
                Arrays.asList("<links>", "<nav>", "<menu>", "<navigation>"),
                "<nav>",
                "The <nav> tag encloses major navigation link groups."));
    }

    private static void loadMedium(List<Question> list, String cat) {
        list.add(new Question("HTML_M_01", cat, "Medium",
                "Which semantic HTML5 element represents self-contained, independent composition content like a blog post or news item?",
                Arrays.asList("<section>", "<article>", "<aside>", "<main>"),
                "<article>",
                "An <article> represents an independent, reusable composition meant for standalone distribution."));
        list.add(new Question("HTML_M_02", cat, "Medium",
                "Which semantic HTML5 element represents content indirectly related to main content (like a sidebar)?",
                Arrays.asList("<sidebar>", "<aside>", "<section>", "<nav>"),
                "<aside>",
                "<aside> defines content tangentially related to content around it (e.g., sidebars, callout boxes)."));
        list.add(new Question("HTML_M_03", cat, "Medium",
                "Which HTML5 tag wraps the dominant, central content unique to a specific document (excluding headers/footers)?",
                Arrays.asList("<content>", "<main>", "<body-main>", "<primary>"),
                "<main>",
                "<main> contains the main body of content unique to that document."));
        list.add(new Question("HTML_M_04", cat, "Medium",
                "Which HTML5 input type provides a built-in interactive date picker in supporting browsers?",
                Arrays.asList("type=\"calendar\"", "type=\"date\"", "type=\"time\"", "type=\"datetime\""),
                "type=\"date\"",
                "<input type=\"date\"> creates an input field with a native browser date picker UI."));
        list.add(new Question("HTML_M_05", cat, "Medium",
                "Which input attribute defines a regular expression pattern that the input value must match for validation?",
                Arrays.asList("regex", "pattern", "validate", "match"),
                "pattern",
                "The 'pattern' attribute takes a JavaScript regex that user input is validated against."));
        list.add(new Question("HTML_M_06", cat, "Medium",
                "Which HTML5 tag provides a pre-defined auto-complete list of options for an <input> field using the 'list' attribute?",
                Arrays.asList("<select>", "<datalist>", "<autocomplete>", "<options>"),
                "<datalist>",
                "<datalist> contains <option> tags offering autocomplete choices for linked <input> elements."));
        list.add(new Question("HTML_M_07", cat, "Medium",
                "What is the purpose of ARIA (Accessible Rich Internet Applications) attributes like `role` or `aria-label`?",
                Arrays.asList("To speed up JavaScript execution", "To improve accessibility for users of assistive technologies like screen readers", "To style elements without CSS", "To optimize search engine indexing speed"),
                "To improve accessibility for users of assistive technologies like screen readers",
                "ARIA attributes provide semantic accessibility metadata to assistive technology users."));
        list.add(new Question("HTML_M_08", cat, "Medium",
                "How should decorative images (images that carry no informational value) be marked for accessibility?",
                Arrays.asList("Omit the alt attribute entirely", "Use an empty alt attribute (alt=\"\")", "Use alt=\"decorative image\"", "Use alt=\"none\""),
                "Use an empty alt attribute (alt=\"\")",
                "An empty alt attribute (alt=\"\") signals screen readers to skip purely decorative images."));
        list.add(new Question("HTML_M_09", cat, "Medium",
                "Which attribute in <video> or <audio> tags causes media to play automatically when page loads?",
                Arrays.asList("play", "autoplay", "start", "auto"),
                "autoplay",
                "The 'autoplay' boolean attribute requests instant playback upon media readiness."));
        list.add(new Question("HTML_M_10", cat, "Medium",
                "Which attribute displays browser default playback controls (play, pause, volume) on <video> elements?",
                Arrays.asList("navigation", "controls", "ui", "buttons"),
                "controls",
                "The 'controls' attribute displays standard native media control UI elements."));
        list.add(new Question("HTML_M_11", cat, "Medium",
                "What does the `async` attribute do when executing external `<script src=\"app.js\" async>`?",
                Arrays.asList("Fetches script in parallel and executes it immediately as soon as it downloads, non-blocking parsing", "Defers execution until DOM parsing complete", "Executes script on worker thread", "Loads script synchronously"),
                "Fetches script in parallel and executes it immediately as soon as it downloads, non-blocking parsing",
                "The 'async' attribute downloads the script asynchronously and runs it as soon as available, potentially before DOM completion."));
        list.add(new Question("HTML_M_12", cat, "Medium",
                "What does the `defer` attribute do when loading external `<script src=\"app.js\" defer>`?",
                Arrays.asList("Executes script immediately during parsing", "Downloads script in parallel and executes it after DOM parsing finishes in document order", "Prevents script execution", "Loads script on hover"),
                "Downloads script in parallel and executes it after DOM parsing finishes in document order",
                "The 'defer' attribute downloads script concurrently but delays execution until HTML parsing completes entirely."));
        list.add(new Question("HTML_M_13", cat, "Medium",
                "What is the relationship between the <head> and <body> elements in an HTML document?",
                Arrays.asList("They are sibling elements contained inside <html>", "<head> is a child of <body>", "<body> is a child of <head>", "They are parent and child"),
                "They are sibling elements contained inside <html>",
                "<head> and <body> are sibling children directly under the <html> root element."));
        list.add(new Question("HTML_M_14", cat, "Medium",
                "What is the correct format for creating custom data attributes in HTML5?",
                Arrays.asList("custom-*", "data-*", "attr-*", "user-*"),
                "data-*",
                "Custom metadata attributes in HTML5 must start with the 'data-' prefix (e.g., data-user-id)."));
        list.add(new Question("HTML_M_15", cat, "Medium",
                "In JavaScript, how do you access a custom attribute declared as `data-user-role=\"admin\"` on element `el`?",
                Arrays.asList("el.dataUserRole", "el.dataset.userRole", "el.getAttribute(\"userRole\")", "el.custom.userRole"),
                "el.dataset.userRole",
                "Custom data-* attributes are exposed on an element's DOM `dataset` property in camelCase form (`userRole`)."));
        list.add(new Question("HTML_M_16", cat, "Medium",
                "Which <meta> attribute specifies character encoding for the HTML document?",
                Arrays.asList("<meta charset=\"UTF-8\">", "<meta encoding=\"UTF-8\">", "<meta type=\"utf-8\">", "<meta code=\"utf-8\">"),
                "<meta charset=\"UTF-8\">",
                "<meta charset=\"UTF-8\"> declares the document character encoding as UTF-8."));
        list.add(new Question("HTML_M_17", cat, "Medium",
                "Which meta tag prevents search engine crawlers from indexing a page?",
                Arrays.asList("<meta name=\"robots\" content=\"noindex\">", "<meta name=\"crawler\" content=\"stop\">", "<meta name=\"google\" content=\"no-search\">", "<meta name=\"index\" content=\"false\">"),
                "<meta name=\"robots\" content=\"noindex\">",
                "The meta robots tag with value 'noindex' instructs web crawlers not to index the page."));
        list.add(new Question("HTML_M_18", cat, "Medium",
                "Which HTTP method sends form data embedded in the URL query string?",
                Arrays.asList("POST", "GET", "PUT", "FETCH"),
                "GET",
                "The GET method appends form input field values to the target URL query string."));
        list.add(new Question("HTML_M_19", cat, "Medium",
                "Which form attribute and value must be set to upload files via `<input type=\"file\">`?",
                Arrays.asList("enctype=\"multipart/form-data\"", "enctype=\"text/plain\"", "method=\"FILE\"", "upload=\"true\""),
                "enctype=\"multipart/form-data\"",
                "Uploading binary files requires setting form enctype to \"multipart/form-data\" with method=\"POST\"."));
        list.add(new Question("HTML_M_20", cat, "Medium",
                "Which HTML entity code represents the ampersand symbol (&)?",
                Arrays.asList("&amp;", "&and;", "&per;", "&symbol;"),
                "&amp;",
                "The &amp; entity escapes the ampersand character in HTML."));
        list.add(new Question("HTML_M_21", cat, "Medium",
                "Which HTML entity code represents the less-than symbol (<)?",
                Arrays.asList("&lt;", "&gt;", "&less;", "&sub;"),
                "&lt;",
                "The &lt; entity escapes the less-than symbol < to prevent HTML tag misparsing."));
        list.add(new Question("HTML_M_22", cat, "Medium",
                "Which HTML entity code represents the greater-than symbol (>)?",
                Arrays.asList("&lt;", "&gt;", "&great;", "&plus;"),
                "&gt;",
                "The &gt; entity escapes the greater-than symbol >."));
        list.add(new Question("HTML_M_23", cat, "Medium",
                "Which tag is used to wrap a self-contained figure, diagram, or photo along with its caption?",
                Arrays.asList("<figure> and <figcaption>", "<img > and <caption>", "<media> and <title>", "<picture> and <label>"),
                "<figure> and <figcaption>",
                "<figure> encloses self-contained visual media, while <figcaption> provides its caption."));
        list.add(new Question("HTML_M_24", cat, "Medium",
                "Which element represents a highlighted or marked portion of text for reference purposes?",
                Arrays.asList("<mark>", "<highlight>", "<b>", "<em>"),
                "<mark>",
                "The <mark> element represents text highlighted for reference or notation purposes."));
        list.add(new Question("HTML_M_25", cat, "Medium",
                "Which tag represents machine-readable date/time values using the 'datetime' attribute?",
                Arrays.asList("<time>", "<date>", "<clock>", "<timestamp>"),
                "<time>",
                "The <time> element renders human-readable dates/times with machine-readable `datetime` attributes."));
        list.add(new Question("HTML_M_26", cat, "Medium",
                "Which of the following is an inline element by default?",
                Arrays.asList("<div>", "<p>", "<span>", "<h1>"),
                "<span>",
                "<span> is an inline element, whereas <div>, <p>, and <h1> are block-level elements."));
        list.add(new Question("HTML_M_27", cat, "Medium",
                "Can a block-level element be nested inside an inline element like <span> in standard HTML5?",
                Arrays.asList("Yes, always allowed", "No, inline elements generally should not contain block-level elements", "Only inside forms", "Only with CSS display: block"),
                "No, inline elements generally should not contain block-level elements",
                "In HTML specification, inline elements generally must not contain block-level elements."));
        list.add(new Question("HTML_M_28", cat, "Medium",
                "Which element groups related fields and labels together inside a form with a visible border?",
                Arrays.asList("<fieldset>", "<group>", "<formgroup>", "<border>"),
                "<fieldset>",
                "The <fieldset> tag groups related controls in a form and can take a <legend> as title."));
        list.add(new Question("HTML_M_29", cat, "Medium",
                "Which element defines a caption for the content of a <fieldset>?",
                Arrays.asList("<legend>", "<label>", "<caption>", "<title>"),
                "<legend>",
                "The <legend> tag provides a caption for its parent <fieldset>."));
        list.add(new Question("HTML_M_30", cat, "Medium",
                "Which element allows defining multiple alternative media resources for <video> or <audio> elements?",
                Arrays.asList("<source>", "<media>", "<file>", "<url>"),
                "<source>",
                "The <source> tag specifies alternate video/audio files so browsers can pick supported formats."));
        list.add(new Question("HTML_M_31", cat, "Medium",
                "Which HTML5 element provides responsive images by listing multiple image sources for different screen sizes/resolutions?",
                Arrays.asList("<picture>", "<figure>", "<img-set>", "<responsive>"),
                "<picture>",
                "The <picture> element wraps multiple <source> tags and an <img> fallback for responsive image swapping."));
        list.add(new Question("HTML_M_32", cat, "Medium",
                "Which keyboard attribute defines element tab focus order when navigating with the Tab key?",
                Arrays.asList("tabindex", "focusindex", "keyindex", "order"),
                "tabindex",
                "The 'tabindex' attribute specifies sequential keyboard navigation focus order."));
        list.add(new Question("HTML_M_33", cat, "Medium",
                "What does setting `tabindex=\"0\"` do to a non-interactive element like a <div>?",
                Arrays.asList("Removes it from tab order entirely", "Makes it focusable in natural document tab order", "Focuses it first before all other elements", "Disables element entirely"),
                "Makes it focusable in natural document tab order",
                "tabindex=\"0\" inserts the element into normal document keyboard tab order."));
        list.add(new Question("HTML_M_34", cat, "Medium",
                "What does setting `tabindex=\"-1\"` do to an element?",
                Arrays.asList("Makes element focusable programmatically via JavaScript but removes it from sequential keyboard tabbing", "Focuses element immediately", "Hides element from screen readers", "Deletes element from DOM"),
                "Makes element focusable programmatically via JavaScript but removes it from sequential keyboard tabbing",
                "tabindex=\"-1\" removes element from keyboard tab flow while remaining focusable via JS focus()."));
        list.add(new Question("HTML_M_35", cat, "Medium",
                "Which input type renders a slider control for selecting a number within a specified range?",
                Arrays.asList("type=\"range\"", "type=\"slider\"", "type=\"number\"", "type=\"meter\""),
                "type=\"range\"",
                "<input type=\"range\"> produces a visual slider control for numeric input within bounds."));
        list.add(new Question("HTML_M_36", cat, "Medium",
                "Which tag measures a scalar value within a known range or fractional value (like disk usage)?",
                Arrays.asList("<progress>", "<meter>", "<range>", "<gauge>"),
                "<meter>",
                "<meter> represents a scalar measurement within a known range or fractional value."));
        list.add(new Question("HTML_M_37", cat, "Medium",
                "Which tag represents the completion progress of a task (like file upload)?",
                Arrays.asList("<meter>", "<progress>", "<status>", "<bar>"),
                "<progress>",
                "The <progress> tag displays task execution progress (e.g., loading or file transfer)."));
        list.add(new Question("HTML_M_38", cat, "Medium",
                "Which element specifies expanding/collapsing details that user can view or hide?",
                Arrays.asList("<details> and <summary>", "<accordion> and <header>", "<expand> and <title>", "<toggle> and <content>"),
                "<details> and <summary>",
                "<details> creates an interactive disclosure widget, with <summary> as its visible heading."));
        list.add(new Question("HTML_M_39", cat, "Medium",
                "Which element represents a key-value list of terms and descriptions in HTML?",
                Arrays.asList("<dl>, <dt>, <dd>", "<ul>, <li>, <dd>", "<ol>, <dt>, <li>", "<list>, <term>, <desc>"),
                "<dl>, <dt>, <dd>",
                "<dl> defines a description list, containing terms (<dt>) and descriptions (<dd>)."));
        list.add(new Question("HTML_M_40", cat, "Medium",
                "Which global attribute specifies text direction for element content (e.g., left-to-right vs right-to-left)?",
                Arrays.asList("dir", "direction", "lang", "orient"),
                "dir",
                "The 'dir' attribute specifies text directionality (ltr, rtl, auto)."));
        list.add(new Question("HTML_M_41", cat, "Medium",
                "What happens if you open an <em> tag inside a <b> tag but close them as `<b><em>Text</b></em>`?",
                Arrays.asList("Browser HTML parser auto-corrects overlapping tags in DOM, but it is invalid syntax", "Browser crashes immediately", "Page displays blank screen", "Compilation error occurs"),
                "Browser HTML parser auto-corrects overlapping tags in DOM, but it is invalid syntax",
                "HTML parsers handle malformed overlapping tags via error recovery, but it violates standard syntax rules."));
        list.add(new Question("HTML_M_42", cat, "Medium",
                "Which <link> attribute specifies canonical URL to eliminate duplicate content SEO penalties?",
                Arrays.asList("rel=\"canonical\"", "rel=\"original\"", "rel=\"seo\"", "rel=\"index\""),
                "rel=\"canonical\"",
                "<link rel=\"canonical\" href=\"...\"> indicates preferred master page URL for search indexing."));
        list.add(new Question("HTML_M_43", cat, "Medium",
                "Where does the browser construct the DOM tree from?",
                Arrays.asList("Directly from CSS styles", "From tokenized raw HTML byte streams", "From compiled JavaScript", "From JSON manifests"),
                "From tokenized raw HTML byte streams",
                "Browsers convert raw network bytes -> characters -> tokens -> nodes -> DOM Tree."));
        list.add(new Question("HTML_M_44", cat, "Medium",
                "What is the purpose of the `rel=\"noopener noreferrer\"` attribute on external target=\"_blank\" links?",
                Arrays.asList("Prevents target page from accessing window.opener DOM object and protects against tabnabbing phishing attacks", "Speeds up image downloading", "Encrypts connection to destination site", "Hides anchor text from search engines"),
                "Prevents target page from accessing window.opener DOM object and protects against tabnabbing phishing attacks",
                "rel=\"noopener\" prevents foreign cross-origin target pages from controlling window.opener object."));
        list.add(new Question("HTML_M_45", cat, "Medium",
                "Which attribute on <form> specifies where to send submitted form data?",
                Arrays.asList("action", "method", "target", "href"),
                "action",
                "The 'action' attribute specifies target URI where form data payload is transmitted."));
        list.add(new Question("HTML_M_46", cat, "Medium",
                "What is a `<noscript>` tag used for?",
                Arrays.asList("Defines fallback content displayed to users who have disabled JavaScript or use non-scripting browsers", "Prevents scripts from executing", "Logs script execution errors", "Minifies JavaScript code"),
                "Defines fallback content displayed to users who have disabled JavaScript or use non-scripting browsers",
                "<noscript> renders HTML content when script execution is disabled or unsupported."));
        list.add(new Question("HTML_M_47", cat, "Medium",
                "Which tag defines preformatted text where whitespace, indents, and line breaks are preserved exactly as typed?",
                Arrays.asList("<code>", "<pre>", "<text>", "<samp>"),
                "<pre>",
                "The <pre> tag renders text in monospace font, maintaining all whitespace and line breaks."));
        list.add(new Question("HTML_M_48", cat, "Medium",
                "Which tag represents inline computer code snippet?",
                Arrays.asList("<code>", "<pre>", "<var>", "<kbd>"),
                "<code>",
                "The <code> tag marks up computer source code snippets inline."));
        list.add(new Question("HTML_M_49", cat, "Medium",
                "Which tag represents keyboard key input (e.g. Ctrl + C) in HTML?",
                Arrays.asList("<key>", "<kbd>", "<input>", "<code>"),
                "<kbd>",
                "The <kbd> tag represents keyboard input or user shortcuts."));
        list.add(new Question("HTML_M_50", cat, "Medium",
                "Which ARIA attribute hides an decorative or redundant element completely from accessibility screen readers?",
                Arrays.asList("aria-hidden=\"true\"", "aria-invisible=\"true\"", "aria-skip=\"true\"", "aria-ignore=\"true\""),
                "aria-hidden=\"true\"",
                "aria-hidden=\"true\" removes an element and its children from accessibility tree."));
    }

    private static void loadHard(List<Question> list, String cat) {
        list.add(new Question("HTML_H_01", cat, "Hard",
                "How does an HTML parser handle script tags without `async` or `defer` encountered during parsing?",
                Arrays.asList("Parsing halts completely, script is fetched and executed immediately before HTML parsing resumes", "Script is downloaded in background while HTML parsing continues unaffected", "Script execution is postponed to idle time", "Parser converts script to WebWorker thread"),
                "Parsing halts completely, script is fetched and executed immediately before HTML parsing resumes",
                "Synchronous script tags block the HTML parser completely until the script is downloaded and executed."));
        list.add(new Question("HTML_H_02", cat, "Hard",
                "What is the DOM tree construction result when the parser encounters a missing closing tag like `<p>First <p>Second`?",
                Arrays.asList("The browser automatically closes the first <p> element before opening the second <p> element", "The second <p> is nested inside the first <p>", "Parser throws syntax exception and stops rendering", "Both paragraphs merge into single node"),
                "The browser automatically closes the first <p> element before opening the second <p> element",
                "Under HTML parsing rules, <p> elements cannot contain block-level elements or nested <p> tags; the first <p> implicitly closes."));
        list.add(new Question("HTML_H_03", cat, "Hard",
                "What severe security vulnerability occurs when raw, unsanitized user inputs are injected directly into HTML DOM via `innerHTML`?",
                Arrays.asList("Cross-Site Scripting (XSS)", "Cross-Site Request Forgery (CSRF)", "SQL Injection", "Server-Side Template Injection"),
                "Cross-Site Scripting (XSS)",
                "Inserting unescaped user string payloads into innerHTML allows attackers to inject malicious scripts (XSS)."));
        list.add(new Question("HTML_H_04", cat, "Hard",
                "Which HTTP security header configured in web servers restricts resource origin domains for scripts, styles, and images?",
                Arrays.asList("Content-Security-Policy (CSP)", "X-Frame-Options", "Strict-Transport-Security", "X-Content-Type-Options"),
                "Content-Security-Policy (CSP)",
                "Content-Security-Policy (CSP) headers mitigate XSS and data injection by specifying permitted content origins."));
        list.add(new Question("HTML_H_05", cat, "Hard",
                "Which attribute on `<iframe>` sandboxes and restricts iframe privileges like form submission, script execution, or top-navigation?",
                Arrays.asList("sandbox", "security", "restrict", "policy"),
                "sandbox",
                "The 'sandbox' attribute enforces security restrictions on iframe content (e.g., sandbox=\"allow-scripts\")."));
        list.add(new Question("HTML_H_06", cat, "Hard",
                "What is the difference between `display: none`, `visibility: hidden`, and `aria-hidden=\"true\"` regarding screen readers?",
                Arrays.asList("`display: none` and `visibility: hidden` hide content from both DOM rendering and screen readers; `aria-hidden=\"true\"` hides content only from screen readers while keeping visual rendering intact", "`aria-hidden` visually hides elements from screen", "`visibility: hidden` is read aloud by screen readers", "They perform identical functions"),
                "`display: none` and `visibility: hidden` hide content from both DOM rendering and screen readers; `aria-hidden=\"true\"` hides content only from screen readers while keeping visual rendering intact",
                "display:none/visibility:hidden hide visually and from accessibility tree; aria-hidden=\"true\" hides exclusively from accessibility tree."));
        list.add(new Question("HTML_H_07", cat, "Hard",
                "When an HTML form contains invalid input controls upon user submission, what DOM event is fired on the invalid controls?",
                Arrays.asList("invalid", "error", "validationerror", "abort"),
                "invalid",
                "The 'invalid' event fires on each invalid form element when form constraint validation fails upon submission."));
        list.add(new Question("HTML_H_08", cat, "Hard",
                "Which boolean attribute on <form> disables native browser HTML validation checks during submission?",
                Arrays.asList("novalidate", "bypass", "nocheck", "disable-validation"),
                "novalidate",
                "The 'novalidate' attribute on <form> bypasses standard browser field constraints during submission."));
        list.add(new Question("HTML_H_09", cat, "Hard",
                "Which attribute on a submit button overrides the parent form's `action` attribute when clicked?",
                Arrays.asList("formaction", "targetaction", "override-action", "submit-to"),
                "formaction",
                "'formaction' overrides the default form action URI specifically for that submit button click."));
        list.add(new Question("HTML_H_10", cat, "Hard",
                "Which attribute on a submit button overrides the parent form's `method` attribute?",
                Arrays.asList("formmethod", "methodoverride", "form-type", "httpmethod"),
                "formmethod",
                "'formmethod' overrides the default HTTP submission method (GET/POST) for that specific submit button."));
        list.add(new Question("HTML_H_11", cat, "Hard",
                "What is the content model specification for the HTML5 `<template>` element?",
                Arrays.asList("Its contents are parsed into a DocumentFragment, stored in inert state, and not rendered in DOM until cloned via JavaScript", "Its contents render immediately on screen with opacity 0.5", "It operates as an external iframe", "It compiles to WebAssembly"),
                "Its contents are parsed into a DocumentFragment, stored in inert state, and not rendered in DOM until cloned via JavaScript",
                "<template> holds inert HTML markup parsed into a DocumentFragment that does not execute or render until instantiated by JS."));
        list.add(new Question("HTML_H_12", cat, "Hard",
                "What happens when the browser parser encounters `<script>` inside `<head>` with `type=\"module\"`?",
                Arrays.asList("It automatically behaves as if `defer` were specified, executing after DOM parsing completes", "It blocks parsing synchronously like standard script", "It fails to execute without async attribute", "It executes in parallel with head styling"),
                "It automatically behaves as if `defer` were specified, executing after DOM parsing completes",
                "ES modules (`type=\"module\"`) are automatically deferred by default in modern browsers."));
        list.add(new Question("HTML_H_13", cat, "Hard",
                "What is Quirks Mode in browser HTML rendering?",
                Arrays.asList("A legacy emulation mode triggered by missing or invalid <!DOCTYPE> declarations", "A special developer debugging mode in Chrome", "An experimental HTML6 parsing mode", "A mobile rendering engine flag"),
                "A legacy emulation mode triggered by missing or invalid <!DOCTYPE> declarations",
                "Missing doctype triggers Quirks Mode where browser emulates non-standard legacy browser layout bugs."));
        list.add(new Question("HTML_H_14", cat, "Hard",
                "Which HTML5 tag is used to draw dynamic graphics, charts, or game animations via JavaScript rendering context?",
                Arrays.asList("<canvas>", "<svg>", "<graphic>", "<draw>"),
                "<canvas>",
                "<canvas> provides a bitmap resolution-dependent surface renderable via 2D/WebGL JavaScript contexts."));
        list.add(new Question("HTML_H_15", cat, "Hard",
                "What is the key technical difference between `<canvas>` and `<svg>` elements in HTML?",
                Arrays.asList("<canvas> is raster/bitmap pixel-based drawn via JS; <svg> is vector-based XML tree integrated into DOM", "<canvas> is vector-based; <svg> is pixel-based", "<svg> cannot be styled with CSS", "<canvas> elements scale infinitely without pixelation"),
                "<canvas> is raster/bitmap pixel-based drawn via JS; <svg> is vector-based XML tree integrated into DOM",
                "Canvas is a pixel raster surface (immediate mode), while SVG is a DOM-accessible vector graph (retained mode)."));
        list.add(new Question("HTML_H_16", cat, "Hard",
                "What is the primary function of Open Graph meta tags (e.g., `<meta property=\"og:title\" content=\"...\">`)?",
                Arrays.asList("To specify rich preview cards (title, image, description) when links are shared on social media platforms", "To index site content faster on Google Search", "To configure web graphics rendering", "To handle local language translations"),
                "To specify rich preview cards (title, image, description) when links are shared on social media platforms",
                "Open Graph protocol tags format rich snippets/preview cards for social media link shares."));
        list.add(new Question("HTML_H_17", cat, "Hard",
                "Which ARIA attribute creates a dynamic live region where content updates are announced immediately by screen readers without losing focus?",
                Arrays.asList("aria-live=\"polite\"", "aria-update=\"fast\"", "aria-alert=\"true\"", "aria-announce=\"yes\""),
                "aria-live=\"polite\"",
                "aria-live=\"polite\" or \"assertive\" instructs screen readers to announce dynamic content updates."));
        list.add(new Question("HTML_H_18", cat, "Hard",
                "What is the difference between `aria-live=\"polite\"` and `aria-live=\"assertive\"`?",
                Arrays.asList("`polite` waits until user is idle before announcing; `assertive` interrupts current speech immediately to announce updates", "`polite` plays a sound effect", "`assertive` logs errors to console", "There is no difference"),
                "`polite` waits until user is idle before announcing; `assertive` interrupts current speech immediately to announce updates",
                "'polite' announces updates at natural speech pauses, whereas 'assertive' interrupts ongoing screen reader output immediately."));
        list.add(new Question("HTML_H_19", cat, "Hard",
                "Which HTML attribute provides native drag-and-drop capabilities to HTML elements?",
                Arrays.asList("draggable=\"true\"", "drag=\"enabled\"", "movable=\"true\"", "allow-drag=\"true\""),
                "draggable=\"true\"",
                "The global 'draggable=\"true\"' attribute enables native browser drag-and-drop interactions."));
        list.add(new Question("HTML_H_20", cat, "Hard",
                "What security attribute combination on anchor tag `<a>` prevents target pages from performing reverse tabnabbing attacks when opening external links in new tabs?",
                Arrays.asList("target=\"_blank\" rel=\"noopener noreferrer\"", "target=\"_new\" security=\"high\"", "rel=\"secure\"", "type=\"external\""),
                "target=\"_blank\" rel=\"noopener noreferrer\"",
                "Combining target=\"_blank\" with rel=\"noopener noreferrer\" protects against parent window hijacking."));
        list.add(new Question("HTML_H_21", cat, "Hard",
                "Which iframe attribute value explicitly blocks embedded cross-origin content from executing scripts?",
                Arrays.asList("Omitting 'allow-scripts' from the sandbox attribute list", "sandbox=\"scripts-off\"", "noscript=\"true\"", "script-policy=\"deny\""),
                "Omitting 'allow-scripts' from the sandbox attribute list",
                "If `sandbox` attribute is present on an iframe without 'allow-scripts', script execution is strictly disabled."));
        list.add(new Question("HTML_H_22", cat, "Hard",
                "What does the browser Speculative Preloader do during HTML parsing?",
                Arrays.asList("Scans document ahead for external resources (images, scripts, CSS) and initiates network requests while main parser is blocked", "Pre-renders entire page in background memory", "Executes JavaScript off main thread", "Compiles CSS to native code"),
                "Scans document ahead for external resources (images, scripts, CSS) and initiates network requests while main parser is blocked",
                "Speculative preloaders parse document raw streams ahead to fetch external files concurrently while main thread executes scripts."));
        list.add(new Question("HTML_H_23", cat, "Hard",
                "Why must raw `<`, `>`, and `&` characters be escaped as entities in HTML body text and attributes?",
                Arrays.asList("To prevent browser parser ambiguity between actual markup tags/entities and plain text values", "To decrease network packet size", "To enforce UTF-16 character width", "To allow CSS styling"),
                "To prevent browser parser ambiguity between actual markup tags/entities and plain text values",
                "Unescaped markup syntax characters cause parsing ambiguity or potential security injection bugs."));
        list.add(new Question("HTML_H_24", cat, "Hard",
                "What is the behavior of input attribute `autofocus` on a page with multiple elements having `autofocus`?",
                Arrays.asList("The first element with autofocus in document order receives focus (or behavior is implementation-dependent)", "All elements focus simultaneously", "Throws a JavaScript runtime error", "Page scrolling disables focus"),
                "The first element with autofocus in document order receives focus (or behavior is implementation-dependent)",
                "Only one element gets focus; browsers focus the first element in DOM tree containing the autofocus attribute."));
        list.add(new Question("HTML_H_25", cat, "Hard",
                "Which pseudoclass matches form controls whose values fulfill all validation constraint requirements?",
                Arrays.asList(":valid", ":checked", ":success", ":approved"),
                ":valid",
                "The CSS :valid pseudo-class targets form elements whose current value passes validation."));
        list.add(new Question("HTML_H_26", cat, "Hard",
                "Which pseudoclass matches form controls whose values fail validation constraints?",
                Arrays.asList(":invalid", ":error", ":failed", ":bad-input"),
                ":invalid",
                "The CSS :invalid pseudo-class targets form elements whose values fail constraint checks."));
        list.add(new Question("HTML_H_27", cat, "Hard",
                "What is the consequence of leaving an unclosed `<table>` tag in an HTML document?",
                Arrays.asList("The browser attempts auto-closing at document end, but page layout below table may be corrupted or corrupted inside table tree", "Browser halts rendering instantly", "DOM throws null pointer exception", "Table renders off-screen"),
                "The browser attempts auto-closing at document end, but page layout below table may be corrupted or corrupted inside table tree",
                "Unclosed table tags disrupt browser parent-child tree construction, swallowing subsequent content into table scope."));
        list.add(new Question("HTML_H_28", cat, "Hard",
                "What happens if both `async` and `defer` attributes are placed on a standard non-module `<script async defer src=\"...\">` in modern browsers?",
                Arrays.asList("`async` takes precedence; if browser supports `async`, it acts asynchronously", "`defer` overrides `async`", "Script fails to load", "Script loads twice"),
                "`async` takes precedence; if browser supports `async`, it acts asynchronously",
                "Modern browsers supporting `async` ignore `defer` when both attributes are present on legacy scripts."));
        list.add(new Question("HTML_H_29", cat, "Hard",
                "Which element is used inside `<video>` or `<audio>` to provide subtitle/caption track files (.vtt format)?",
                Arrays.asList("<track>", "<caption >", "<subtitle>", "<text>"),
                "<track>",
                "The <track> tag provides WebVTT timed text tracks for subtitles or captions."));
        list.add(new Question("HTML_H_30", cat, "Hard",
                "Which method on HTML element allows programmatically checking if input satisfies constraints without submitting form?",
                Arrays.asList("checkValidity()", "validate()", "isCorrect()", "verify()"),
                "checkValidity()",
                "checkValidity() returns true if element matches validation constraints, firing 'invalid' event if false."));
        list.add(new Question("HTML_H_31", cat, "Hard",
                "Which method on HTML form control sets a custom validation error message string?",
                Arrays.asList("setCustomValidity(\"message\")", "setErrorMessage(\"message\")", "setError(\"message\")", "customError(\"message\")"),
                "setCustomValidity(\"message\")",
                "setCustomValidity(\"msg\") sets custom validation error text, rendering input invalid if string is non-empty."));
        list.add(new Question("HTML_H_32", cat, "Hard",
                "What ARIA role should be assigned to a custom clickable `<div>` functioning as a button to ensure screen reader accessibility?",
                Arrays.asList("role=\"button\"", "role=\"click\"", "role=\"input\"", "role=\"action\""),
                "role=\"button\"",
                "role=\"button\" informs screen readers that a element acts as an interactive button control."));
        list.add(new Question("HTML_H_33", cat, "Hard",
                "If you assign `role=\"button\"` to a `<div>`, what keyboard interaction must you manually implement via JavaScript?",
                Arrays.asList("Handling Enter and Space keypress events to trigger action", "Arrow key scrolling", "Tab key jumping", "Escape key clearing"),
                "Handling Enter and Space keypress events to trigger action",
                "Native <button> handles Enter/Space keys automatically; ARIA role=\"button\" requires manual keydown event handlers for Space/Enter."));
        list.add(new Question("HTML_H_34", cat, "Hard",
                "Which attribute on `<img>` element allows browsers to defer image loading until user scrolls near it?",
                Arrays.asList("loading=\"lazy\"", "defer=\"true\"", "async=\"true\"", "render=\"scroll\""),
                "loading=\"lazy\"",
                "loading=\"lazy\" defers image downloading until it approaches the visible viewport threshold."));
        list.add(new Question("HTML_H_35", cat, "Hard",
                "Which image attributes `srcset` and `sizes` serve what primary optimization purpose?",
                Arrays.asList("Allowing browser to select optimal image resolution asset based on device pixel ratio and screen width", "Creating CSS image filters", "Lazy loading images", "Rotating images responsive layout"),
                "Allowing browser to select optimal image resolution asset based on device pixel ratio and screen width",
                "srcset and sizes provide resolution switching capabilities for responsive image asset delivery."));
        list.add(new Question("HTML_H_36", cat, "Hard",
                "What is the function of `<meta name=\"theme-color\" content=\"#317EFB\">` tag?",
                Arrays.asList("Sets background accent color of mobile browser toolbar / UI frame", "Sets CSS body background color", "Applies dark mode globally", "Configures web manifest primary font"),
                "Sets background accent color of mobile browser toolbar / UI frame",
                "theme-color sets the surrounding browser interface/toolbar color on mobile OS browsers."));
        list.add(new Question("HTML_H_37", cat, "Hard",
                "Which tag links a Web Application Manifest JSON file to an HTML document for Progressive Web Apps (PWA)?",
                Arrays.asList("<link rel=\"manifest\" href=\"manifest.json\">", "<meta name=\"pwa\" content=\"manifest.json\">", "<script src=\"manifest.json\">", "<app-manifest src=\"manifest.json\">"),
                "<link rel=\"manifest\" href=\"manifest.json\">",
                "<link rel=\"manifest\"> links web app manifests specifying PWA icons, orientation, and launch modes."));
        list.add(new Question("HTML_H_38", cat, "Hard",
                "What is Document Fragment in JavaScript / DOM processing?",
                Arrays.asList("A lightweight, minimal document object that stores DOM nodes off-screen without triggering layout reflows when modified", "A broken HTML tag", "A portion of CSS file", "An unparsed JSON string"),
                "A lightweight, minimal document object that stores DOM nodes off-screen without triggering layout reflows when modified",
                "DocumentFragment holds off-screen DOM nodes, allowing batch mutations without triggering multiple page layout reflows."));
        list.add(new Question("HTML_H_39", cat, "Hard",
                "Which tag is appropriate for wrapping fine print, disclaimer notes, or legal restrictions in HTML5?",
                Arrays.asList("<small>", "<sub>", "<footer>", "<caption >"),
                "<small>",
                "In HTML5, <small> represents side-comments and small print like legal or copyright text."));
        list.add(new Question("HTML_H_40", cat, "Hard",
                "Which tag represents machine-readable variable names or programmatic constants in text?",
                Arrays.asList("<var>", "<code>", "<samp>", "<kbd>"),
                "<var>",
                "The <var> tag defines variable names in mathematical expressions or programming contexts."));
        list.add(new Question("HTML_H_41", cat, "Hard",
                "Which element represents sample output from a computer program or system?",
                Arrays.asList("<samp>", "<code>", "<var>", "<output>"),
                "<samp>",
                "The <samp> tag represents sample output from a computer program or terminal."));
        list.add(new Question("HTML_H_42", cat, "Hard",
                "Which tag represents result calculation output of user form actions in HTML5?",
                Arrays.asList("<output>", "<result>", "<calc>", "<value>"),
                "<output>",
                "The <output> tag represents the result of a calculation or script computation."));
        list.add(new Question("HTML_H_43", cat, "Hard",
                "What is the danger of using `document.write()` in client-side scripts after page parsing has finished?",
                Arrays.asList("It completely overwrites existing document content, destroying current DOM and triggering security warnings", "It throws an uncaught syntax error", "It creates duplicate body elements", "It corrupts CSS styling"),
                "It completely overwrites existing document content, destroying current DOM and triggering security warnings",
                "Calling document.write() post-load completely clears existing document DOM tree."));
        list.add(new Question("HTML_H_44", cat, "Hard",
                "How does Subresource Integrity (SRI) `<script src=\"...\" integrity=\"sha384-...\">` protect websites?",
                Arrays.asList("Verifies that fetched foreign CDN files match cryptographic hash, blocking compromised altered scripts", "Encrypts script transmitted over wire", "Prevents cross-origin script execution", "Minifies script automatic loading"),
                "Verifies that fetched foreign CDN files match cryptographic hash, blocking compromised altered scripts",
                "SRI allows browsers to verify cryptographic hash signatures of CDN files, guarding against tampered resources."));
        list.add(new Question("HTML_H_45", cat, "Hard",
                "Which attribute on form text input disables browser auto-complete history suggestions?",
                Arrays.asList("autocomplete=\"off\"", "autosuggest=\"false\"", "history=\"none\"", "remember=\"false\""),
                "autocomplete=\"off\"",
                "autocomplete=\"off\" instructs browsers not to display previously stored autocomplete suggestions for the field."));
        list.add(new Question("HTML_H_46", cat, "Hard",
                "Which attribute controls spell-checking behavior for input fields or editable elements?",
                Arrays.asList("spellcheck=\"true|false\"", "autocorrect=\"on|off\"", "grammar=\"true|false\"", "check-spelling=\"bool\""),
                "spellcheck=\"true|false\"",
                "The 'spellcheck' attribute enables or disables native browser spell checking on editable elements."));
        list.add(new Question("HTML_H_47", cat, "Hard",
                "What does the global attribute `hidden` do when placed on an HTML element (`<div hidden>`)?",
                Arrays.asList("Indicates element is not yet or no longer relevant, applying CSS display: none by default", "Sets opacity to 0 keeping layout space", "Disables element interactivity only", "Hides element from screen readers only"),
                "Indicates element is not yet or no longer relevant, applying CSS display: none by default",
                "The boolean 'hidden' attribute marks content as irrelevant; browsers hide it visually using display: none rule."));
        list.add(new Question("HTML_H_48", cat, "Hard",
                "What is the effect of placing CSS `<link rel=\"stylesheet\">` inside `<body>` instead of `<head>`?",
                Arrays.asList("Triggers Flash of Unstyled Content (FOUC) and render blocking during parsing", "Causes immediate syntax error", "Styles are completely ignored", "CSS loads faster"),
                "Triggers Flash of Unstyled Content (FOUC) and render blocking during parsing",
                "Stylesheets in <body> block progressive rendering or cause Flash of Unstyled Content (FOUC)."));
        list.add(new Question("HTML_H_49", cat, "Hard",
                "Which ARIA attribute explicitly establishes relationship where one element labels another element?",
                Arrays.asList("aria-labelledby", "aria-label", "aria-describedby", "aria-for"),
                "aria-labelledby",
                "aria-labelledby references element ID(s) containing text that serves as target element label."));
        list.add(new Question("HTML_H_50", cat, "Hard",
                "Which ARIA attribute connects an element to extended descriptive text (e.g. tooltip or help section)?",
                Arrays.asList("aria-describedby", "aria-labelledby", "aria-help", "aria-details"),
                "aria-describedby",
                "aria-describedby references ID(s) of elements offering expanded descriptions or instructions."));
    }
}
