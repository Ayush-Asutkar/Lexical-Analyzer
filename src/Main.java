import model.Lexeme;

import java.util.Scanner;

public class Main {
    private static String readInputString() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        return input;
    }

    public static void main(String[] args) {
        System.out.print("Provide the input line: ");
        String input = readInputString();
        System.out.println("The read input is: " + input);

        input += " ";

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