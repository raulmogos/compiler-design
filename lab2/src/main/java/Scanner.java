import automata.FiniteAutomata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scanner {

    private final Integer NO_POZ = -1;
    private static final String CONST = "const";
    private static final String ID = "id";

    private final List<Token> pif;
    private final SymbolTable symbolTable;
    private FiniteAutomata finiteAutomataNumber;
    private FiniteAutomata finiteAutomataIdentifier;

    public Scanner() {
        this.pif = new ArrayList<>();
        this.symbolTable = new SymbolTable();
        finiteAutomataNumber = new FiniteAutomata("src/main/java/automata/const_number.txt");
        // finiteAutomataIdentifier = new FiniteAutomata("src/main/java/automata/identifier.txt");
    }

    public Scanner(List<Token> pif, SymbolTable symbolTable) {
        this.pif = pif;
        this.symbolTable = symbolTable;
    }

    private List<String> split(String line) {
        if (line.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < line.length(); i ++) {
            if (mightBeOperator(line.charAt(i))) {
                if (start != -1) {
                    result.add(line.substring(start, i));
                    start = -1;
                }
                if ( i + 1 < line.length() && isOperator(line.substring(i ,i + 2))) {
                    result.add(line.substring(i, i + 2));
                    i += 1;
                } else {
                    result.add(line.substring(i, i + 1));
                }
            } else if (i + 1 < line.length() && isSeparator(line.substring(i, i + 2))) {
                if (start != -1) {
                    result.add(line.substring(start, i));
                    start = -1;
                }
                result.add(line.substring(i, i + 2));
                i += 1;
            } else if (isSeparator(line.charAt(i))) {
                if (start != -1) {
                    result.add(line.substring(start, i));
                    start = -1;
                }
                result.add(line.substring(i, i + 1));
            } else {
                if (start == -1) {
                    start = i;
                }
            }
        }
        if (start != -1) {
            result.add(line.substring(start));
        }

        // everything between ""
        // todo: same thing for ''
        List<String> strings = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        start = -1;
        for (int i = 0; i < result.size(); i++) {
            if (start == -1 && result.get(i).equals("\"")) {
                start = i;
            } else if (start != -1 && result.get(i).equals("\"")) {
                StringBuilder sb = new StringBuilder();
                for (int j = start + 1; j < i; j++) {
                    sb.append(result.get(j));
                }
                indexes.add(start);
                indexes.add(i);
                start = -1;
                strings.add("\"" + sb.toString() + "\"");
            }
        }
        if (strings.size() != 0) {
            List<String> newResult = new ArrayList<>();
            int k = 0;
            for (int i = 0; i < result.size(); i++) {
                if (2 * k < indexes.size() && i == indexes.get(2 * k)) {
                    i = indexes.get(2 * k + 1);
                    newResult.add(strings.get(k));
                    k += 1;
                } else {
                    newResult.add(result.get(i));
                }
            }
            result = newResult;
        }
        
        return result;
    }

    boolean mightBeOperator(char c) {
        for ( String op: Lexic.operators.keySet()) {
            if (op.charAt(0) == c) {
                return true;
            }
        }
        return false;
    }

    boolean isOperator(String string) {
        return Lexic.operators.containsKey(string);
    }

    boolean isSeparator(char c) {
        return Lexic.separators.containsKey(String.valueOf(c));
    }

    boolean isSeparator(String string) {
        return Lexic.separators.containsKey(string);
    }

    boolean isReservedWord(String token) {
        return Lexic.reservedWords.containsKey(token);
    }

    private boolean isIdentifier(String token){
//        return finiteAutomataIdentifier.check(token);
        return token.matches("[a-zA-Z]+[0-9]*");
    }

    boolean isConstant(String token) {
        boolean isChar = token.matches("'[a-zA-Z0-9]{1}'");
        boolean isString = token.matches("\"[ a-zA-Z0-9!?-@,.;:+]+\"");
        boolean isNumber = finiteAutomataNumber.check(token);
        // boolean isNumber = token.matches("^[1-9][0-9]{0,10}") || token.matches("[0-9]{1}");
        return  isChar || isString || isNumber;
    }

    public void scan(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = "";
        int i = 0;
        StringBuilder codeStringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            codeStringBuilder.append(line).append(" ");
        }

        List<String> tokens =  split(codeStringBuilder.toString());

        System.out.println(tokens);
        boolean isValid = true;
        String errorToken = "";

        for(var token: tokens) {
            token = token.strip();
            if (!token.equals("") && !token.equals("\\n")) {
                if (isOperator(token)) {
                    pif.add(new Token(token, NO_POZ));
                } else if (isSeparator(token)) {
                    pif.add(new Token(token, NO_POZ));
                } else if (isReservedWord(token)) {
                    pif.add(new Token(token, NO_POZ));
                } else if (isConstant(token)) {
                    int index = symbolTable.add(token);
                    pif.add(new Token(CONST, index));
                } else if (isIdentifier(token)) {
                    // it if identifier
                    int index = symbolTable.add(token);
                    pif.add(new Token(ID, index));
                } else {
                    isValid = false;
                    errorToken = "Cannot classify token: " + token;
                }
            }
        }

        System.out.println("PIF");
        if (!isValid) {
            System.out.println(errorToken);
        }
        pif.forEach(tkn -> {
            System.out.println(tkn.getToken() + "   --   " + tkn.getPosition());
        });
        System.out.println("\n\nsymbolTable");
        System.out.println(symbolTable);
    }

}
