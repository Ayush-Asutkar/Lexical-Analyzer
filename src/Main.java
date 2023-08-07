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

        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
        lexicalAnalyzer.analyseLine(input);
    }
}