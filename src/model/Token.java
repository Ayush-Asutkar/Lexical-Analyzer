package model;

import automaton.Machine;

public enum Token {
    KEYWORD, RELOP, ID, NUMBER, DELIM;

    public static Token getTokenFromMachine(Machine machine) {
        switch (machine) {
            case KEYWORD_MACHINE:
                return KEYWORD;

            case RELOP_MACHINE:
                return RELOP;

            case IDENTIFIER_MACHINE:
                return ID;

            case NUMBER_MACHINE:
                return NUMBER;

            case DELIM_MACHINE:
                return DELIM;

            default:
                return null;
        }
    }
}
