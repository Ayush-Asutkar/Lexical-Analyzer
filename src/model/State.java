package model;

public class State {
    public enum StatesAttribute {
        NON_ACCEPTING_STATE,
        ACCEPTING_AND_NON_RETRACTING_STATE,
        ACCEPTING_AND_RETRACTING_STATE,
        INVALID_STATE
    }

    private int currStateNumber;
    private StatesAttribute currStateAttribute;

    public State (int currStateNumber, StatesAttribute currStateAttribute) {
        this.currStateNumber = currStateNumber;
        this.currStateAttribute = currStateAttribute;
    }

    public int getCurrStateNumber() {
        return currStateNumber;
    }

    public StatesAttribute getCurrStateAttribute() {
        return currStateAttribute;
    }
}
