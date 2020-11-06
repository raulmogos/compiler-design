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

        operators.put("==", 11);
        operators.put("-=", 12);
        operators.put("+=", 13);

        operators.put(">=", 14);
        operators.put("<=", 15);
        operators.put("!=", 16);
    }

    // separators
    // [ ] { }  : ; space . newLine
    public static final HashMap<String, Integer> separators = new HashMap<>();
    static {
        separators.put("\\n", 17);
        separators.put("]", 18);
        separators.put("[", 19);
        separators.put("}", 20);
        separators.put("{", 21);
        separators.put(")", 22);
        separators.put("(", 23);
        separators.put("\"", 24);
        separators.put("'", 25);
        separators.put(" ", 26);
        separators.put(",", 27);
    }

    // - reserved words:
    //	io:		print, input
    //	types:		const, char, int, string, (and double/float)
    //	conditionals:	else, if, elif
    //	loops:		for, while, in
    public static final HashMap<String, Integer> reservedWords = new HashMap<>();
    static {
        reservedWords.put("print", 28);
        reservedWords.put("input", 29);
        reservedWords.put("const", 30);
        reservedWords.put("char", 31);
        reservedWords.put("int", 32);
        reservedWords.put("string", 33);
        reservedWords.put("if", 34);
        reservedWords.put("else", 35);
        reservedWords.put("elif", 36);
        reservedWords.put("for", 37);
        reservedWords.put("while", 38);
        reservedWords.put("in", 39);
        reservedWords.put("and", 40);
        reservedWords.put("or", 41);
    }
}
