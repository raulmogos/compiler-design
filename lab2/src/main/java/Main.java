import automata.FiniteAutomata;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

//        System.out.println(Lexic.operators);
//        System.out.println(Lexic.separators);
//        System.out.println(Lexic.reservedWords);
//        System.out.println("\n\n");
//
//        new Scanner().scan("src/main/java/io/p1.txt");
//        new Scanner().scan("src/main/java/io/p2.txt");
//        new Scanner().scan("src/main/java/io/p3.txt");
//        new Scanner().scan("src/main/java/io/pe.txt");

        FiniteAutomata finiteAutomata = new FiniteAutomata("src/main/java/automata/const_number.txt");
        System.out.println(finiteAutomata.check("1246746"));
    }
}
