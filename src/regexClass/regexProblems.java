package regexClass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

import java.io.*;
import java.util.regex.*;

public class regexProblems {
	public static void main(String[] args) throws IOException {
        BufferedReader readFile = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter writeFile = new BufferedWriter(new FileWriter("output.txt"));

        String sentence;
        while ((sentence = readFile.readLine()) != null) {
            if (sentence.equals("end")) {
                writeFile.write("x\n");
                continue;
            }

            int numProp = Integer.parseInt(sentence);
            switch (numProp) {
                case 1:
                    problem1Emails(readFile, writeFile);
                    break;
                case 2:
                    problem2PhoneNumbers(readFile, writeFile);
                    break;
                case 3:
                    problem3dates(readFile, writeFile);
                    break;   
                case 4:
                    problem4IPaddress(readFile, writeFile);
                    break;
                case 5:
                    problem5CVariables(readFile, writeFile);
                    break;
                case 6:
                	problem6Strings(readFile, writeFile);
                    break;
                case 7:
                	problem7substrings(readFile, writeFile);
                    break;
                case 8:
                	problem8multiple(readFile, writeFile);
                    break;
                case 9:
                	 solveProb09(writeFile, readFile.readLine());
                    break;
                case 10:
                    problem10MathExp(readFile, writeFile);
                    break;
            }
        }

        readFile.close();
        writeFile.close();
    }
//Username: \\w+
	//\\w+ matches one or more word characters.
	//\\w matches any word character (alphanumeric character or underscore).
//Domain name:
	//[a-zA-Z_]+ matches one or more lowercase or uppercase letters or underscores.
	//\\. matches a dot (.) character literally.
	//[a-zA-Z]{2,3}	[a-zA-Z] matches any lowercase or uppercase letter.
	
    private static void problem1Emails(BufferedReader reader, BufferedWriter writer) throws IOException {
        String regularEmail = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
        String email;
        StringBuilder output = new StringBuilder("1\n");
        while (!(email = reader.readLine()).equals("end")) {
            if (email.matches(regularEmail)) {
                output.append("valid email\n");
            } else {
                output.append("invalid email\n");
            }
        }
        output.append("x\n");
        writer.write(output.toString());
    }
    
//Optional opening parenthesis: \\(?
    		//\\(? matches an optional opening parenthesis.
    		//\\( matches a literal opening parenthesis.
    		//Three digits: (\\d{3})
    		//Optional separator: [-.]?
    		//[-.]? matches an optional hyphen - or period ..

    private static void problem2PhoneNumbers(BufferedReader reader, BufferedWriter writer) throws IOException {
    	 // String regularPhoneNum = "^(\\d{10}|\\d{3}-\\d{3}-\\d{4}|\\(\\d{3}\\)-\\d{3}-\\d{4}|\\d{3}\\.\\d{3}\\.\\d{4})$";
    	String regularPhoneNum = "^\\(?(\\d{3})\\)?[-.]?(\\d{3})[-.]?(\\d{4})$";
        String phoneNumber;
        StringBuilder output = new StringBuilder("2\n");
        while (!(phoneNumber = reader.readLine()).equals("end")) {
            if (phoneNumber.matches(regularPhoneNum)) {
                output.append("valid phone number\n");
            } else {
                output.append("invalid phone number\n");
            }
        }
        output.append("x\n");
        writer.write(output.toString());
    }
    
    /* 
    YYYY/MM/DD = "^\\d{4}/\\d{2}/\\d{2}$";
    YYYY-MM-DD = "^\\d{4}-\\d{2}-\\d{2}$";
    DD/MM/YYY  = "^\\d{2}/\\d{2}/\\d{4}$";
    DD-MM-YYYY = "^\\d{2}-\\d{2}-\\d{4}$";
    DD-M-YYYY  = "^\\d{2}/\\d{1}/\\d{4}$";
    DD/M/YYYY  = "^\\d{2}-\\d{1}-\\d{4}$";
    D/MM/YYYY  = "^\\d{1}-\\d{2}-\\d{4}$";
    D-MM-YYYY  = "^\\d{1}/\\d{2}/\\d{4}$";
    
    ******************************************
    
    YYYY-MM-DD , YYYY/MM/DD  = DATE_FORMAT1 
    DD-MM-YYYY , DD/MM/YYYY  = DATE_FORMAT2 
    DD-M-YYYY  , DD/M/YYYY   = DATE_FORMAT3 
    D/MM/YYYY  , D-MM-YYYY   = DATE_FORMAT4

 */
 

    
    private static void problem3dates(BufferedReader reader, BufferedWriter writer) throws IOException {
    	  final String DATE_FORMAT1 = "^(\\d{4})[/-]\\d{2}[/-]\\d{2}$";
    	    final String DATE_FORMAT2 = "^(\\d{2})[/-]\\d{2}[/-]\\d{4}$";
    	    final String DATE_FORMAT3 = "^(\\d{2})[/-]\\d{1}[/-]\\d{4}$";
    	    final String DATE_FORMAT4 = "^(\\d{1})[/-]\\d{2}[/-]\\d{4}$";
    	String problem3dates = DATE_FORMAT1 + "|" + DATE_FORMAT2 + "|" + DATE_FORMAT3 + "|" + DATE_FORMAT4;
        String problem3;
        StringBuilder output = new StringBuilder("3\n");
        while (!(problem3 = reader.readLine()).equals("end")) {
            if (problem3.matches(problem3dates)) {
                output.append("valid date\n");
            } else {
                output.append("invalid date\n");
            }
        }
        output.append("x\n");
        writer.write(output.toString());
    }
    /*
        A valid IP address:
        ● Must contain numbers between 0 and 255
        ● There must be exactly 3 dots separating the 4 numbers
    */
      private static void problem4IPaddress(BufferedReader reader, BufferedWriter writer) throws IOException {
          
             // Regular expression pattern to match IP addresses
            String problem4IPaddress ="^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
            
            // Variable to hold each input line
            String problem4;
            
            // StringBuilder to construct the output string
            StringBuilder output = new StringBuilder("4\n");
            
            // Loop until "end" is entered
              while (!(problem4 = reader.readLine()).equals("end")) {
                
                 // Check if the input matches the IP address pattern
                if (problem4.matches(problem4IPaddress)) {
                    output.append("valid IP address\n");
                } else {
                    output.append("invalid IP address\n");
                }
            }
            // Append "x" to signify end of input
            output.append("x\n");
            writer.write(output.toString());
        }
    
    
  //[a-zA-Z_]
    //Matches any uppercase or lowercase letter or underscore.
 //[a-zA-Z0-9_]*
   // Matches zero or more occurrences of:
    //Uppercase or lowercase letters.
    //Digits (0-9).
    //Underscores.
    private static void problem5CVariables(BufferedReader reader, BufferedWriter writer) throws IOException {
        String regularCVariale = "^[a-zA-Z_][a-zA-Z0-9_]*$";
        String Cvariable;
        StringBuilder output = new StringBuilder("5\n");
        while (!(Cvariable = reader.readLine()).equals("end")) {
            if (Cvariable.matches(regularCVariale)) {
                output.append("valid C++ variable name\n");
            } else {
                output.append("invalid C++ variable name\n");
            }
        }
        output.append("x\n");
        writer.write(output.toString());
    }
    
    private static void problem6Strings(BufferedReader reader, BufferedWriter writer) throws IOException {
    	String problem6regex = "^(?!.*[bB]{3})[a-zA-Z0-9]*$";
        String problem6;
        StringBuilder output = new StringBuilder("6\n");
        while (!(problem6 = reader.readLine()).equals("end")) {
            if (problem6.matches(problem6regex)) {
                output.append("valid string\n");
            } else {
                output.append("invalid string, has 3 consecutive b’s\n");
            }
        }
        output.append("x\n");
        writer.write(output.toString());
    }
    
    private static void problem7substrings(BufferedReader reader, BufferedWriter writer) throws IOException {
        String problem7regex = "(aa)*b(aa)*a|a(bb)*b";
        String sentence;
        StringBuilder output = new StringBuilder("7\n");

        while (!(sentence = reader.readLine()).equals("end")) {
            output.append("*").append(sentence).append("*").append("\n");
            Matcher matcher = Pattern.compile(problem7regex).matcher(sentence);
            int count = 0;
            while (matcher.find()) {
                count++;
            }
            output.append("number of matched substrings: ").append(count).append("\n");
            matcher.reset();
            while (matcher.find()) {
                output.append("matched substring: ").append(matcher.group()).append("\n");
                output.append("start index: ").append(matcher.start()).append(", end index: ").append(matcher.end()).append("\n");
            }
        }
        output.append("x\n");
        writer.write(output.toString());
    }
    
    private static void problem8multiple(BufferedReader reader, BufferedWriter writer) throws IOException {
        String problem8regex = "\\b\\w{3}(?:\\w{3})*\\b";
        String sentence;
        StringBuilder output = new StringBuilder("8\n");

        while (!(sentence = reader.readLine()).equals("end")) {
            output.append("*").append(sentence).append("*\n");

            Matcher matcher = Pattern.compile(problem8regex).matcher(sentence);
            int count = 0;
            while (matcher.find()) {
                count++;
            }

            if (count > 0) {
                output.append("number of matched words: ").append(count).append("\n");
                matcher.reset();
                while (matcher.find()) {
                    output.append("matched word: ").append(matcher.group()).append("\n");
                    output.append("start index: ").append(matcher.start()).append(", end index: ").append(matcher.end()).append("\n");
                }
            } else {
                output.append("No word matches\n");
            }
        }
        output.append("x\n");
        writer.write(output.toString());
    }



    

    private static int getLineNumber(String text, int index) {
        int lineNumber = 1;
        for (int i = 0; i < index; i++) {
            if (text.charAt(i) == '\n') {
                lineNumber++;
            }
        }
        return lineNumber;
    }

   /* private static int getLineStartIndex(String text, int index) {
        int startIndex = index;
        while (startIndex > 0 && text.charAt(startIndex) != '\n') {
            startIndex--;
        }
        return startIndex;
    }*/
    private static int getLineStartIndex(String text, int index) {
    int startIndex = index;
    while (startIndex > 0 && text.charAt(startIndex - 1) != '\n') {
        startIndex--;
    }
    return startIndex;
    }
    private static void solveProb09(BufferedWriter writer, String filePath) {
        // Regular expression to match URLs
    	String c="[a-zA-Z0-9@:%._\\+~#=]";
		String regex = "https:\\/{2}"+c+"+\\.[a-z]{2,6}\\b(/"+c+"*)*";


        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder output = new StringBuilder("9\n");
            output.append("*").append(filePath).append("*\n");

            // Read the target text from the input file
            StringBuilder targetText = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                targetText.append(line).append("\n");
            }

            // Create a Pattern object
            Pattern pattern = Pattern.compile(regex);

            // Create a Matcher object
            Matcher matcher = pattern.matcher(targetText.toString());
        
            

            // Find all the matches
            int count = 0;
            while (matcher.find()) {
                count++;
                String url = matcher.group();

                // Get the line number
                int lineNumber = getLineNumber(targetText.toString(), matcher.start());

                 // Get the start and end indices
                int startIndex = getLineStartIndex(targetText.toString(), matcher.start());
            
                // Account for the newline character when calculating relative index
                int relativeStartIndex = matcher.start() - startIndex; 
                int relativeEndIndex = (relativeStartIndex + url.length());


                // Output the match information
                output.append("URL: ").append(url).append("\n");
                output.append("Line: ").append(lineNumber).append("\n");
                output.append("start index: ").append(relativeStartIndex).append(", end index: ").append(relativeEndIndex).append("\n");
            }

            // Write the number of URLs found
            output.append("Number of URLs: ").append(count).append("\n");
            //output.append("x\n");

            // Write the output to the file
            writer.write(output.toString());
            System.out.println("Output written to output.txt");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }



	//\\d*: Matches zero or more digits.
    //[\\w.]*: Matches zero or more word characters (letters, digits, or underscores) or dots (.).
    //[-+*/]*: Matches zero or more arithmetic operators (+, -, *, /).
    //[\\w.]+: Matches one or more word characters or dots. This represents the left-hand side (LHS) of the equation.
    private static void problem10MathExp(BufferedReader reader, BufferedWriter writer) throws IOException {
        String regularMathExp = "^(\\d*[\\w.]*[-+*/]*)*[\\w.]+=[\\w.+-/*]+\\d*$";
        String mathExpression;
        StringBuilder output = new StringBuilder("10\n");
        while ((mathExpression = reader.readLine()) != null && !mathExpression.equals("end")) {
            if (mathExpression.matches(regularMathExp)) {
                output.append("valid mathematical expression\n");
            } else {
                output.append("invalid mathematical expression\n");
            }
        }
        output.append("x\n");
        writer.write(output.toString());
    }

}