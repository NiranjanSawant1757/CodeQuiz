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

        // --- EASY (17) ---
        list.add(new Question("HTML_01", cat, "Easy",
                "What does the acronym HTML stand for?",
                Arrays.asList("HyperText Markup Language", "HighText Machine Language", "Hyperlink and Text Markup Language", "Home Tool Markup Language"),
                "HyperText Markup Language", "HTML stands for HyperText Markup Language, the standard markup language for Web documents."));

        list.add(new Question("HTML_02", cat, "Easy",
                "Which HTML tag is used to create the largest heading?",
                Arrays.asList("<h1>", "<h6>", "<heading>", "<head>"),
                "<h1>", "HTML defines six levels of headings from <h1> (highest importance/largest) to <h6> (lowest)."));

        list.add(new Question("HTML_03", cat, "Easy",
                "Which HTML tag is used to create a hyperlink?",
                Arrays.asList("<a>", "<link>", "<href>", "<url>"),
                "<a>", "The anchor tag <a> with the href attribute defines hyperlinks in HTML."));

        list.add(new Question("HTML_04", cat, "Easy",
                "Which attribute specifies the destination URL of a link in the <a> tag?",
                Arrays.asList("href", "src", "link", "target"),
                "href", "The 'href' (hypertext reference) attribute specifies the URL the link points to."));

        list.add(new Question("HTML_05", cat, "Easy",
                "Which HTML tag inserts a line break without creating a new paragraph?",
                Arrays.asList("<br>", "<lb>", "<break>", "<hr>"),
                "<br>", "<br> inserts a single line break and is a void/self-closing element."));

        list.add(new Question("HTML_06", cat, "Easy",
                "Which tag is used to display an image in an HTML webpage?",
                Arrays.asList("<img>", "<image>", "<picture>", "<src>"),
                "<img>", "The <img> tag embeds an image in an HTML document."));

        list.add(new Question("HTML_07", cat, "Easy",
                "Which attribute provides alternative text for an image if it cannot be displayed?",
                Arrays.asList("alt", "title", "src", "description"),
                "alt", "The 'alt' attribute provides alternative text for screen readers and when images fail to load."));

        list.add(new Question("HTML_08", cat, "Easy",
                "Which tag is used to define an unordered (bulleted) list?",
                Arrays.asList("<ul>", "<ol>", "<li>", "<list>"),
                "<ul>", "<ul> defines an unordered bulleted list, containing <li> list items."));

        list.add(new Question("HTML_09", cat, "Easy",
                "Which tag is used to define an ordered (numbered) list?",
                Arrays.asList("<ol>", "<ul>", "<nl>", "<order>"),
                "<ol>", "<ol> specifies an ordered (numbered) list."));

        list.add(new Question("HTML_10", cat, "Easy",
                "What is the correct HTML doctype declaration for HTML5?",
                Arrays.asList("<!DOCTYPE html>", "<!DOCTYPE HTML5>", "<?xml version=\"1.0\"?>", "<!DOCTYPE html PUBLIC>"),
                "<!DOCTYPE html>", "The simple declaration <!DOCTYPE html> informs the browser to render in standard HTML5 mode."));

        list.add(new Question("HTML_11", cat, "Easy",
                "Which tag contains metadata about the document, such as title, styles, and character set?",
                Arrays.asList("<head>", "<body>", "<meta>", "<header>"),
                "<head>", "The <head> section houses document metadata not directly rendered in the page body."));

        list.add(new Question("HTML_12", cat, "Easy",
                "Which element defines the visible content of an HTML document?",
                Arrays.asList("<body>", "<main>", "<content>", "<section>"),
                "<body>", "The <body> element encapsulates all visible content rendered by the browser."));

        list.add(new Question("HTML_13", cat, "Easy",
                "Which HTML element is used to define tabular data?",
                Arrays.asList("<table>", "<tab>", "<grid>", "<data>"),
                "<table>", "The <table> tag specifies a data table consisting of rows (<tr>) and cells (<td>/<th>)."));

        list.add(new Question("HTML_14", cat, "Easy",
                "Which input type creates a clickable submission button in an HTML form?",
                Arrays.asList("submit", "button", "send", "action"),
                "submit", "<input type=\"submit\"> renders a button that submits the form data to the server."));

        list.add(new Question("HTML_15", cat, "Easy",
                "Which HTML tag is used to create a drop-down list?",
                Arrays.asList("<select>", "<dropdown>", "<list>", "<option>"),
                "<select>", "The <select> element contains <option> tags to render a dropdown menu."));

        list.add(new Question("HTML_16", cat, "Easy",
                "Which tag creates a thematic break or horizontal rule across the page?",
                Arrays.asList("<hr>", "<br>", "<line>", "<rule>"),
                "<hr>", "<hr> creates a horizontal divider separating thematic content."));

        list.add(new Question("HTML_17", cat, "Easy",
                "What character encoding is universally recommended and declared with '<meta charset=\"UTF-8\">'?",
                Arrays.asList("UTF-8", "ASCII", "ISO-8859-1", "UTF-16"),
                "UTF-8", "UTF-8 covers almost all characters and symbols globally and is the web standard."));

        // --- MEDIUM (17) ---
        list.add(new Question("HTML_18", cat, "Medium",
                "What is semantic HTML and why is it important?",
                Arrays.asList("Using tags that convey meaning about their content (like <header>, <article>, <nav>) for accessibility and SEO", "Styling tags without CSS", "Compiling HTML to binary", "Using only <div> and <span>"),
                "Using tags that convey meaning about their content (like <header>, <article>, <nav>) for accessibility and SEO", "Semantic tags clearly describe their role to the browser, search engines, and assistive screen reader technologies."));

        list.add(new Question("HTML_19", cat, "Medium",
                "What is the difference between block-level elements and inline elements?",
                Arrays.asList("Block elements start on a new line and take full width; inline elements take only as much width as necessary", "Inline elements start on a new line", "Block elements cannot contain text", "Inline elements have width and height by default"),
                "Block elements start on a new line and take full width; inline elements take only as much width as necessary", "<div>, <p>, and <h1> are block-level; <span>, <a>, and <strong> are inline by default."));

        list.add(new Question("HTML_20", cat, "Medium",
                "What does the '<canvas>' element in HTML5 provide?",
                Arrays.asList("A scriptable drawable region on the page manipulated via JavaScript for graphics and games", "A container for SVG vector images only", "An audio playback visualizer", "A photo gallery widget"),
                "A scriptable drawable region on the page manipulated via JavaScript for graphics and games", "HTML5 <canvas> provides a 2D/WebGL raster rendering surface controlled via JavaScript APIs."));

        list.add(new Question("HTML_21", cat, "Medium",
                "What is the difference between '<audio>' and '<video>' playback controls in HTML5 vs older plugins?",
                Arrays.asList("They provide native media playback without requiring third-party plugins like Flash", "They require Java applets", "They only work on desktop computers", "They cannot play MP3 or MP4"),
                "They provide native media playback without requiring third-party plugins like Flash", "HTML5 introduced native <video> and <audio> tags supported directly by web browsers."));

        list.add(new Question("HTML_22", cat, "Medium",
                "What does the 'target=\"_blank\"' attribute on an anchor tag do, and what security attribute should accompany it?",
                Arrays.asList("Opens the link in a new tab; should include rel=\"noopener noreferrer\" to prevent tab-napping", "Opens link in same window; rel=\"nofollow\"", "Downloads the file; rel=\"secure\"", "Opens in popup without security risks"),
                "Opens the link in a new tab; should include rel=\"noopener noreferrer\" to prevent tab-napping", "Opening in a new tab without rel=\"noopener noreferrer\" allows the opened page to access window.opener, introducing phishing risks."));

        list.add(new Question("HTML_23", cat, "Medium",
                "What is the difference between '<strong>' and '<b>' in modern HTML?",
                Arrays.asList("'<strong>' conveys strong semantic importance; '<b>' is purely visual bold styling without semantic weight", "'<b>' conveys more importance", "They are identical in semantics", "'<strong>' is deprecated"),
                "'<strong>' conveys strong semantic importance; '<b>' is purely visual bold styling without semantic weight", "<strong> informs assistive screen readers that the text has high priority; <b> merely styles text boldly."));

        list.add(new Question("HTML_24", cat, "Medium",
                "What do custom data attributes ('data-*') in HTML5 accomplish?",
                Arrays.asList("Store custom private data on standard HTML elements accessible via JavaScript dataset API", "Define new database columns", "Encrypt sensitive cookies", "Override CSS style sheets"),
                "Store custom private data on standard HTML elements accessible via JavaScript dataset API", "data-* attributes let developers embed application data directly on HTML nodes accessible with element.dataset."));

        list.add(new Question("HTML_25", cat, "Medium",
                "Which attribute is used to make an input field mandatory before form submission?",
                Arrays.asList("required", "mandatory", "validate", "must"),
                "required", "The boolean 'required' attribute prevents form submission if the field is empty."));

        list.add(new Question("HTML_26", cat, "Medium",
                "What is the difference between 'GET' and 'POST' methods in an HTML form?",
                Arrays.asList("GET appends form data to URL query parameters; POST sends data in the HTTP request body", "POST appends data to URL; GET is hidden", "GET is encrypted; POST is not", "GET cannot send strings"),
                "GET appends form data to URL query parameters; POST sends data in the HTTP request body", "GET forms expose parameters in the browser address bar, whereas POST transfers payloads securely inside the body."));

        list.add(new Question("HTML_27", cat, "Medium",
                "What does '<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">' do?",
                Arrays.asList("Ensures mobile-responsive layout scaling according to the device screen width", "Zoom out the webpage by 10x", "Forces desktop view on mobile", "Disables touch zooming completely"),
                "Ensures mobile-responsive layout scaling according to the device screen width", "The viewport meta tag instructs mobile browsers to match screen width in CSS pixels for responsive designs."));

        list.add(new Question("HTML_28", cat, "Medium",
                "What does the '<datalist>' element provide when linked to an '<input>'?",
                Arrays.asList("A pre-defined autocomplete list of options while still allowing custom text entry", "A mandatory dropdown select box", "A database connection pool", "A table data viewer"),
                "A pre-defined autocomplete list of options while still allowing custom text entry", "<datalist> offers suggestions via <option> children connected to an input via the 'list' attribute."));

        list.add(new Question("HTML_29", cat, "Medium",
                "Which HTML5 element represents self-contained syndicated content (e.g. blog post or news item)?",
                Arrays.asList("<article>", "<section>", "<div>", "<aside>"),
                "<article>", "<article> represents an independent, self-contained composition intended for standalone distribution."));

        list.add(new Question("HTML_30", cat, "Medium",
                "Which HTML5 element represents tangentially related content like sidebars or pull quotes?",
                Arrays.asList("<aside>", "<sidebar>", "<section>", "<nav>"),
                "<aside>", "<aside> denotes auxiliary content related tangentially to surrounding primary content."));

        list.add(new Question("HTML_31", cat, "Medium",
                "What is the difference between '<script async>' and '<script defer>'?",
                Arrays.asList("'async' executes as soon as downloaded without blocking; 'defer' executes in order after the HTML document is fully parsed", "'defer' blocks HTML parsing", "'async' only works for CSS", "They are identical"),
                "'async' executes as soon as downloaded without blocking; 'defer' executes in order after the HTML document is fully parsed", "'defer' scripts download in parallel and run after DOM construction in script declaration order."));

        list.add(new Question("HTML_32", cat, "Medium",
                "What does the 'contenteditable' attribute do when set to 'true'?",
                Arrays.asList("Allows the user to directly edit the text and inner HTML of the element in the browser", "Encrypts element content", "Hides element from search engines", "Enables spelling suggestions only"),
                "Allows the user to directly edit the text and inner HTML of the element in the browser", "contenteditable=\"true\" turns any DOM node into an interactive rich-text editable region."));

        list.add(new Question("HTML_33", cat, "Medium",
                "Which tag specifies a relationship between the current document and an external resource like a stylesheet?",
                Arrays.asList("<link>", "<a>", "<style>", "<import>"),
                "<link>", "<link rel=\"stylesheet\" href=\"styles.css\"> links external resources like stylesheets and favicons."));

        list.add(new Question("HTML_34", cat, "Medium",
                "What does the 'placeholder' attribute do on an '<input>' element?",
                Arrays.asList("Displays a temporary hint inside the input field that disappears when the user types", "Sets the permanent default value", "Validates input with regex", "Locks the input field"),
                "Displays a temporary hint inside the input field that disappears when the user types", "Placeholder text offers a short hint describing the expected input format."));

        // --- HARD (16) ---
        list.add(new Question("HTML_35", cat, "Hard",
                "What are Web Components in modern HTML standards?",
                Arrays.asList("A suite of technologies (Custom Elements, Shadow DOM, and HTML Templates) for building reusable encapsulated widgets", "Third-party plugins compiled to C++", "Pre-built WordPress shortcodes", "Server-side components in Node.js"),
                "A suite of technologies (Custom Elements, Shadow DOM, and HTML Templates) for building reusable encapsulated widgets", "Web Components allow defining custom HTML tags with encapsulated CSS/DOM via Shadow DOM and templates."));

        list.add(new Question("HTML_36", cat, "Hard",
                "What is Shadow DOM and what problem does it solve?",
                Arrays.asList("Encapsulates internal DOM subtrees and CSS styles, preventing outer styles from leaking in and vice-versa", "Renders 3D shadows on canvas", "Hides sensitive passwords from dev tools", "Speeds up GPU rendering"),
                "Encapsulates internal DOM subtrees and CSS styles, preventing outer styles from leaking in and vice-versa", "Shadow DOM provides true DOM and style scoping boundaries for component authors."));

        list.add(new Question("HTML_37", cat, "Hard",
                "What does the HTML '<template>' tag do when placed in a document?",
                Arrays.asList("Holds inert client-side markup that is not rendered on page load but can be cloned and activated via JavaScript", "Replaces CSS stylesheets", "Renders an iframe immediately", "Injects server variables into DOM"),
                "Holds inert client-side markup that is not rendered on page load but can be cloned and activated via JavaScript", "Content inside <template> is parsed but inert; scripts don't run and images don't load until cloned via JS."));

        list.add(new Question("HTML_38", cat, "Hard",
                "What is the function of ARIA (Accessible Rich Internet Applications) attributes (e.g. 'aria-expanded', 'role')?",
                Arrays.asList("Provides semantic accessibility metadata to assistive technologies for dynamic custom UI widgets", "Styles HTML elements for mobile", "Speeds up browser rendering", "Prevents XSS attacks"),
                "Provides semantic accessibility metadata to assistive technologies for dynamic custom UI widgets", "ARIA bridges accessibility gaps for custom controls (tabs, accordions) that lack native semantic HTML elements."));

        list.add(new Question("HTML_39", cat, "Hard",
                "What does 'Subresource Integrity' (SRI) attribute 'integrity=\"sha384-...\"' on a '<script>' tag accomplish?",
                Arrays.asList("Enables browsers to verify that fetched third-party resources have not been tampered with by verifying cryptographic hashes", "Encrypts external scripts in transit", "Compresses JavaScript downloads", "Bypasses CORS restrictions"),
                "Enables browsers to verify that fetched third-party resources have not been tampered with by verifying cryptographic hashes", "SRI protects against compromised CDNs by validating resource checksums before script execution."));

        list.add(new Question("HTML_40", cat, "Hard",
                "What is Content Security Policy (CSP) declared via '<meta http-equiv=\"Content-Security-Policy\" ...>'?",
                Arrays.asList("A security layer restricting resources (scripts, styles, images) that can be loaded to prevent XSS attacks", "A policy regarding GDPR cookies", "A DRM protection for audio", "A password manager constraint"),
                "A security layer restricting resources (scripts, styles, images) that can be loaded to prevent XSS attacks", "CSP restricts allowable content sources, mitigating Cross-Site Scripting (XSS) and data injection vulnerabilities."));

        list.add(new Question("HTML_41", cat, "Hard",
                "What does the '<picture>' element provide compared to a basic '<img>' tag?",
                Arrays.asList("Allows responsive art-direction and multiple media query / image format sources via <source> elements", "Applies 3D filters to images", "Converts raster images to vector SVG", "Plays video streams"),
                "Allows responsive art-direction and multiple media query / image format sources via <source> elements", "<picture> supports serving different crops or next-gen formats (WebP, AVIF) based on screen characteristics."));

        list.add(new Question("HTML_42", cat, "Hard",
                "What is the purpose of the 'rel=\"preload\"' attribute on a '<link>' tag?",
                Arrays.asList("Informs the browser to fetch a critical resource immediately with high priority before parser reaches it", "Delays loading until page unload", "Saves resource permanently in disk cache", "Loads resource on background thread"),
                "Informs the browser to fetch a critical resource immediately with high priority before parser reaches it", "<link rel=\"preload\"> forces early fetching of critical assets (fonts, hero images) to reduce First Contentful Paint."));

        list.add(new Question("HTML_43", cat, "Hard",
                "What does the 'sandbox' attribute on an '<iframe>' element achieve?",
                Arrays.asList("Applies strict security restrictions preventing forms, scripts, popups, and same-origin access unless explicitly granted", "Renders the iframe in gray-scale", "Limits iframe bandwidth", "Encrypts iframe cookies"),
                "Applies strict security restrictions preventing forms, scripts, popups, and same-origin access unless explicitly granted", "The sandbox attribute isolates embedded third-party content in a restricted security environment."));

        list.add(new Question("HTML_44", cat, "Hard",
                "What is the difference between 'localStorage' and 'IndexedDB' in browser storage APIs?",
                Arrays.asList("localStorage is synchronous and limited to ~5MB strings; IndexedDB is asynchronous, transactional, and stores large structured data", "localStorage stores binary blobs; IndexedDB stores text only", "IndexedDB is cleared on every refresh", "They have identical capabilities"),
                "localStorage is synchronous and limited to ~5MB strings; IndexedDB is asynchronous, transactional, and stores large structured data", "IndexedDB provides a full NoSQL database inside the browser for offline-first web applications."));

        list.add(new Question("HTML_45", cat, "Hard",
                "What does the 'draggable' attribute in HTML5 enable?",
                Arrays.asList("Enables native HTML5 drag and drop interaction events (dragstart, dragover, drop) on the element", "Makes the element resizable by mouse", "Moves the element using CSS animations", "Enables touch scrolling"),
                "Enables native HTML5 drag and drop interaction events (dragstart, dragover, drop) on the element", "draggable=\"true\" allows elements to be dragged using standard Drag and Drop API events."));

        list.add(new Question("HTML_46", cat, "Hard",
                "What is the HTML5 Server-Sent Events (SSE) API and which tag/interface implements it?",
                Arrays.asList("Unidirectional real-time text streaming from server to client handled via the EventSource JavaScript interface", "A tag named <event-source>", "Bidirectional socket communication via <socket>", "An email notification service"),
                "Unidirectional real-time text streaming from server to client handled via the EventSource JavaScript interface", "Server-Sent Events allow servers to push data to web clients over a persistent HTTP connection using EventSource."));

        list.add(new Question("HTML_47", cat, "Hard",
                "What is the 'loading=\"lazy\"' attribute on '<img>' and '<iframe>' elements?",
                Arrays.asList("Defers downloading the resource until it is close to entering the browser viewport", "Renders images in low resolution permanently", "Loads resources after 10 seconds delay", "Compresses images with gzip"),
                "Defers downloading the resource until it is close to entering the browser viewport", "Native lazy loading saves bandwidth by waiting to load off-screen media until the user scrolls near it."));

        list.add(new Question("HTML_48", cat, "Hard",
                "What is the purpose of the '<meta name=\"robots\" content=\"noindex, nofollow\">' tag?",
                Arrays.asList("Instructs search engine crawlers not to index the page or follow its hyperlinks", "Blocks all human users from visiting", "Disables JavaScript execution", "Enables automated scraping"),
                "Instructs search engine crawlers not to index the page or follow its hyperlinks", "Robots meta directives control search engine indexing and link evaluation behaviors on specific pages."));

        list.add(new Question("HTML_49", cat, "Hard",
                "What is the Difference between SVG and HTML5 Canvas for rendering web graphics?",
                Arrays.asList("SVG is vector-based (XML nodes in the DOM, scalable without quality loss); Canvas is raster/pixel-based manipulated via JS", "Canvas is vector; SVG is raster", "Canvas cannot draw shapes", "SVG requires WebGL support"),
                "SVG is vector-based (XML nodes in the DOM, scalable without quality loss); Canvas is raster/pixel-based manipulated via JS", "SVG elements are interactive DOM nodes supporting CSS styles; Canvas is a bitmap surface faster for high-frequency rendering."));

        list.add(new Question("HTML_50", cat, "Hard",
                "What does '<dialog>' element represent in HTML5.2, and which method opens it as a modal?",
                Arrays.asList("A native popup/dialog box opened as a modal via dialog.showModal() with built-in backdrop support", "A speech bubble opened with alert()", "A chat window widget", "An audio playback interface"),
                "A native popup/dialog box opened as a modal via dialog.showModal() with built-in backdrop support", "The <dialog> element provides a native modal dialog box with focus trapping, ::backdrop styling, and Esc-key closing."));

        return list;
    }
}
