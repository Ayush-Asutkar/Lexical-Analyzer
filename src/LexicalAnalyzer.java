import automaton.Machine;
import automaton.MachineController;
import model.Lexeme;
import model.State;
import model.Token;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LexicalAnalyzer {
    private final List<Lexeme> result;

    public LexicalAnalyzer() {
        this.result = new ArrayList<>();
    }

    public List<Lexeme> getResult() {
        return Collections.unmodifiableList(result);
    }

    public int analyseLine (String line) {
        int index = 0;

        while(index < line.length()) {
            int currIndex = lexer(line, index);
//            System.out.println("currIndex: " + currIndex);

            if (currIndex == -1) {
                return index;
            }
            index = currIndex;
        }

        return -1;
    }

    private int lexer(String line, int index) {
        if (line.charAt(index) == '\0') {
            return index + 1;
        }

        for (Machine machine: Machine.values()) {
//            System.out.println("Executing machine: " + machine);
            int currIndex = index;
            State currState = new State(0, State.StatesAttribute.NON_ACCEPTING_STATE);
            while ((currIndex < line.length())  &&  (currState.getCurrStateAttribute() == State.StatesAttribute.NON_ACCEPTING_STATE)) {
                currState = MachineController.getNextState(currState, line.charAt(currIndex), machine);
//                System.out.println("currState: " + currState);
//                System.out.println("line.charAt(currIndex): " + line.charAt(currIndex));
                currIndex++;
            }

//            System.out.println("index: " + index + ", currIndex: " + currIndex);

            if ((currState.getCurrStateAttribute() == State.StatesAttribute.ACCEPTING_AND_NON_RETRACTING_STATE)  ||
                    (currState.getCurrStateAttribute() == State.StatesAttribute.ACCEPTING_AND_RETRACTING_STATE)) {
                int nextIndex = currState.getCurrStateAttribute() == State.StatesAttribute.ACCEPTING_AND_NON_RETRACTING_STATE? currIndex: currIndex - 1;

                if (machine != Machine.DELIM_MACHINE) {
                    Lexeme lexeme = new Lexeme(Token.getTokenFromMachine(machine), line.substring(index, nextIndex));
//                    System.out.println("Lexeme: " + lexeme);
                    this.result.add(lexeme);
                }

//                System.out.println("nextIndex: " + nextIndex);

                return nextIndex;
            }
        }

        return -1;
    }

    //for testing
    public static void main(String[] args) {
        String input = "if input<10 then output1=100 else output2>=100";
//        String input = "if a >= b thenext = 6 else theold = 4";
        input += " ";

        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
        int check = lexicalAnalyzer.analyseLine(input);

        if (check == -1) {
            //analysis is correct
            System.out.println(lexicalAnalyzer.result);
        }
    }
}
