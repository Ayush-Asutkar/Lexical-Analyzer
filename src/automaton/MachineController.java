package automaton;

import helper.CharacterIdentifier;
import model.State;

public class MachineController {
    public static State getNextState(State currState, char ch, Machine machine) {
        switch (machine) {
            case KEYWORD_MACHINE:
                return keyword_machine(currState, ch);

            case RELOP_MACHINE:
                return relop_machine(currState, ch);

            case IDENTIFIER_MACHINE:
                return identifier_machine(currState, ch);

            case NUMBER_MACHINE:
                return number_machine(currState, ch);

            case DELIM_MACHINE:
                return delim_machine(currState, ch);

            default:
                return new State(-1, State.StatesAttribute.INVALID_STATE);
        }
    }

    // Final States:
    // Retracting: 5
    private static State keyword_machine(State currState, char ch) {
        int currStateNumber = currState.getCurrStateNumber();

        switch (currStateNumber) {
            case 0:
                if (ch == 'e') {
                    return new State(7, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                if (ch == 't') {
                    return new State(1, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                if (ch == 'i') {
                    return new State(6, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                break;

            case 1:
                if (ch == 'h') {
                    return new State(2, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                break;

            case 2:
                if (ch == 'e') {
                    return new State(3, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                break;

            case 3:
                if (ch == 'n') {
                    return new State(4, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                break;

            case 4:
                if (!CharacterIdentifier.isDigit(ch)  &&  !CharacterIdentifier.isLetter(ch)) {
                    return new State(5, State.StatesAttribute.ACCEPTING_AND_RETRACTING_STATE);
                }
                break;

            case 6:
                if (ch == 'f') {
                    return new State(4, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                break;

            case 7:
                if (ch == 'l') {
                    return new State(8, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                break;

            case 8:
                if (ch == 's') {
                    return new State(9, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                break;

            case 9:
                if (ch == 'e') {
                    return new State(4, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                break;
        }

        return new State(-1, State.StatesAttribute.INVALID_STATE);
    }

    // Final States:
    // Retracting: 4, 8
    // Non-retracting: 2, 3, 5, 7
    private static State relop_machine(State currState, char ch) {
        int currStateNumber = currState.getCurrStateNumber();
        switch (currStateNumber) {
            case 0:
                if (ch == '<') {
                    return new State(1, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                if (ch == '=') {
                    return new State(5, State.StatesAttribute.ACCEPTING_AND_NON_RETRACTING_STATE);
                }
                if (ch == '>') {
                    return new State(6, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                break;

            case 1:
                if (ch == '=') {
                    return new State(2, State.StatesAttribute.ACCEPTING_AND_NON_RETRACTING_STATE);
                }
                if (ch == '>') {
                    return new State(3, State.StatesAttribute.ACCEPTING_AND_NON_RETRACTING_STATE);
                }
                return new State(4, State.StatesAttribute.ACCEPTING_AND_RETRACTING_STATE);

            case 6:
                if (ch == '=') {
                    return new State(7, State.StatesAttribute.ACCEPTING_AND_NON_RETRACTING_STATE);
                }
                return new State(8, State.StatesAttribute.ACCEPTING_AND_RETRACTING_STATE);
        }

        return new State(-1, State.StatesAttribute.INVALID_STATE);
    }

    // Final States:
    // Retracting: 2
    private static State identifier_machine(State currState, char ch) {
        int currStateNumber = currState.getCurrStateNumber();
        switch (currStateNumber) {
            case 0:
                if (CharacterIdentifier.isLetter(ch)) {
                    return new State(1, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                break;

            case 1:
                if (CharacterIdentifier.isLetter(ch)  ||  CharacterIdentifier.isDigit(ch)) {
                    return new State(1, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                return new State(2, State.StatesAttribute.ACCEPTING_AND_RETRACTING_STATE);
        }

        return new State(-1, State.StatesAttribute.INVALID_STATE);
    }

    // Final States:
    // Retracting: 7, 8, 9
    private static State number_machine(State currState, char ch) {
        int currStateNumber = currState.getCurrStateNumber();
        switch (currStateNumber) {
            case 0:
                if (CharacterIdentifier.isDigit(ch)) {
                    return new State(1, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                break;

            case 1:
                if (CharacterIdentifier.isDigit(ch)) {
                    return new State(1, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                if (ch == 'E') {
                    return new State(4, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                if (ch == '.') {
                    return new State(2, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                return new State(8, State.StatesAttribute.ACCEPTING_AND_RETRACTING_STATE);

            case 2:
                if (CharacterIdentifier.isDigit(ch)) {
                    return new State(3, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                break;

            case 3:
                if (CharacterIdentifier.isDigit(ch)) {
                    return new State(3, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                if (ch == 'E') {
                    return new State(4, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                return new State(9, State.StatesAttribute.ACCEPTING_AND_RETRACTING_STATE);

            case 4:
                if (CharacterIdentifier.isDigit(ch)) {
                    return new State(6, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                if ((ch == '+')  ||  (ch == '-')) {
                    return new State(5, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                break;

            case 5:
                if (CharacterIdentifier.isDigit(ch)) {
                    return new State(6, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                break;

            case 6:
                if (CharacterIdentifier.isDigit(ch)) {
                    return new State(6, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                return new State(7, State.StatesAttribute.ACCEPTING_AND_RETRACTING_STATE);
        }

        return new State(-1, State.StatesAttribute.INVALID_STATE);
    }

    // Final States:
    // Non-retracting: 1
    private static State delim_machine(State currState, char ch) {
        int currStateNumber = currState.getCurrStateNumber();
        switch (currStateNumber) {
            case 0:
                if (CharacterIdentifier.isDelim(ch)) {
                    return new State(1, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                break;

            case 1:
                if (CharacterIdentifier.isDelim(ch)) {
                    return new State(1, State.StatesAttribute.NON_ACCEPTING_STATE);
                }
                return new State(2, State.StatesAttribute.ACCEPTING_AND_RETRACTING_STATE);
        }

        return new State(-1, State.StatesAttribute.INVALID_STATE);
    }
}
