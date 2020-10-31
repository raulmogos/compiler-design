import java.util.HashMap;
import java.util.List;

public class Lexic {

    // operators
    // + - * / ^ = == -= += > < <= >= != ?
    public static final HashMap<String, Integer> operators = new HashMap<>();
    static {
        operators.put("+", 1);
        operators.put("-", 2);
        operators.put("*", 3);
        operators.put("/", 4);
        operators.put("^", 5);
        operators.put("=", 6);
        operators.put(":", 7);
        operators.put(">", 8);
        operators.put("<", 9);
        operators.put("?", 10);

        operators.put("==", 7);
        operators.put("-=", 8);
        operators.put("+=", 9);

        operators.put(">=", 12);
        operators.put("<=", 13);
        operators.put("!=", 14);
    }

    // separators
    // [ ] { }  : ; space . newLine
    public static final HashMap<String, Integer> separators = new HashMap<>();
    static {
        separators.put("\\n", 16);
        separators.put("]", 17);
        separators.put("[", 18);
        separators.put("}", 19);
        separators.put("{", 20);
        separators.put(")", 20);
        separators.put("(", 20);
        separators.put("\"", 20);
        separators.put(" ", 20);
        separators.put(",", 20);
    }

    // - reserved words:
    //	io:		print, input
    //	types:		const, char, int, string, (and double/float)
    //	conditionals:	else, if, elif
    //	loops:		for, while, in
    public static final HashMap<String, Integer> reservedWords = new HashMap<>();
    static {
        reservedWords.put("print", 21);
        reservedWords.put("input", 22);
        reservedWords.put("const", 23);
        reservedWords.put("char", 24);
        reservedWords.put("int", 25);
        reservedWords.put("if", 25);
        reservedWords.put("else", 26);
        reservedWords.put("elif", 27);
        reservedWords.put("for", 28);
        reservedWords.put("while", 29);
        reservedWords.put("in", 30);
        reservedWords.put("and", 31);
        reservedWords.put("or", 32);
    }
}
