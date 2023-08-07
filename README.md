# Compiler Design Lab

---

## Implementing a lexical Analyzer
## Following are my details for assignment submission:
<p>Name: &nbsp;&nbsp;&nbsp;&nbsp;Ayush Vinayak Asutkar</p>
<p>Roll No.: &nbsp;20CS01057</p>
<p>Semester: &nbsp;7th</p>
<p>Year of study: &nbsp;4th year</p>
<p>Subject: &nbsp;&nbsp;Compiler Design Laboratory</p>
<p>Assignment: &nbsp;Assignment - 2</p>

---


### Problem Statement
<p>Implement a lexical analyzer using any programming language. Your program should take a statement as input
and return the sequence of tokens as output.</p>

<p>For more details check the pdf: <a href="Question.pdf">"Question.pdf"</a></p>

### How to run
1. Clone the repository: https://github.com/Ayush-Asutkar/Regular-Expression-To-NFA-DFA.git
2. Open in your favourite editor. (The editor used while making this project was Intellij IDEA)
3. Run the complete project by running the Main.java in src folder. Write input in a particular line on the console. Pressing enter will execute the program.
<p>Example input:</p>
<p>if input<10 then output1=100 else output2>=100</p>
<p>else if then then2 else3 ifthen if3</p>
<p>The output will be printed as list of lexemes</p>

### Patterns:
<p>The patterns for the tokens in the language are described below:</p>
<img src="Images/Pattern.png" alt="Pattern">

### Transition Diagrams for the tokens:
<p>These transition diagrams were used to identify tokens in the string of the input program. 
These machines run sequentially, and in the preference order of keywords, relational operators, identifiers, numbers and delimiters.</p>

#### Keywords Machine:
<p><img src="Images/Machine_Images/Keyword_Machine.jpg" alt="Keyword Machine"></p>

#### Relational Operator Machine:
<p><img src="Images/Machine_Images/Relop_Machine.jpg" alt="Relational operator Machine"></p>

#### Identifiers Machine:
<p><img src="Images/Machine_Images/Identifier_Machine.jpg" alt="Identifiers Machine"></p>

#### Numbers Machine:
<p><img src="Images/Machine_Images/Number_Machine.jpg" alt="Numbers Machine"></p>

#### Delim Machine:
<p><img src="Images/Machine_Images/Delim_Machine.jpg" alt="Delim Machine"></p>