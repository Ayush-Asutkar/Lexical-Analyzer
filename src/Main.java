import model.Lexeme;

import java.util.Scanner;

public class Main {
    private static String readInputString() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Provide the input line: ");
        String input = sc.nextLine();
        input += "\0";

        System.out.println("\nThe read input is: " + input);

        sc.close();
        return input;
    }

    private static String readMultipleInputLine() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Print the input line (Once you are done press enter for empty string)");
        StringBuilder stringBuilder = new StringBuilder();
        String tempInput;

        do {
            tempInput = sc.nextLine();
            stringBuilder.append(tempInput + '\0');
        } while (tempInput.length() != 0);

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
//        String input = readInputString();

        String input = readMultipleInputLine();

        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
        int check = lexicalAnalyzer.analyseLine(input);
        if (check == -1) {
            //analyzer worked correctly
            for (Lexeme lexeme: lexicalAnalyzer.getResult()) {
                System.out.println(lexeme);
            }
        } else {
            System.out.println("Error parsing at " + check + " index: '" + input.charAt(check) + "'");
        }
    }
}