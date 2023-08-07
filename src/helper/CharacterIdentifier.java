package helper;

public class CharacterIdentifier {
    public static boolean isLetter (char ch) {
        if ((ch >= 'a')  &&  (ch <= 'z')) {
            return true;
        }
        if ((ch >= 'A')  &&  (ch <= 'Z')) {
            return true;
        }
        return false;
    }

    public static boolean isDigit (char ch) {
        if ((ch >= '0')  &&  (ch <= '9')) {
            return true;
        }
        return false;
    }

    public static boolean isDelim (char ch) {
        if ((ch == ' ')  ||  (ch == '\t')  ||  (ch == '\n')) {
            return true;
        }
        return false;
    }
}
