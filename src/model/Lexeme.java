package model;

public class Lexeme {
    private Token token;
    private String value;

    public Lexeme(Token token, String value) {
        this.token = token;
        this.value = value;
    }

    public Token getToken() {
        return token;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Lexeme: {" +
                "value='" + value + '\'' +
                ", token=" + token +
                "}";
    }
}
