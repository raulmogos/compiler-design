package automata;

import automata.states.State;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FiniteAutomata {

    private List<State<String>> states;
    private State<String> initialState;
    private List<State<String>> finalStates;
    private Set<String> transitionSet;
    private List<Transition<String, String>> transitionsFunctions;

    public FiniteAutomata(String path) {
        this.states = new ArrayList<>();
        this.finalStates = new ArrayList<>();
        this.transitionSet = new HashSet<>();
        this.transitionsFunctions = new ArrayList<>();
        try {
            this.load(path);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void load(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = "";

        // read states
        line = bufferedReader.readLine();
        String[] stringStates = line.split(",");
        for (var s: stringStates) {
            states.add(new State<>(s));
        }

        // read transitions
        line = bufferedReader.readLine();
        String[] transitionsStrings = line.split(",");
        transitionSet.addAll(Arrays.asList(transitionsStrings));

        // read initial state
        line = bufferedReader.readLine();
        initialState = new State<>(line, true, false);

        // read finale states
        line = bufferedReader.readLine();
        String[] stringFinalStates = line.split(",");
        for (var s: stringFinalStates) {
            finalStates.add(new State<>(s, false, true));
        }


        line = bufferedReader.readLine();

        // read all transition function
        while ((line = bufferedReader.readLine()) != null) {
            String[] items = line.split(",");
            String stString1 = items[0];
            String stString2 = items[1];
            String transitionString = items[2];
            State<String> state1 = null, state2 = null;
            for (var st: states) {
                if (st.getContent().equals(stString1)) {
                    state1 = st;
                }
                if (st.getContent().equals(stString2)) {
                    state2 = st;
                }
            }
//            System.out.println(state1.toString() + state2.toString() + transitionString);
            if (state1 != null && state2 != null && transitionSet.contains(transitionString)) {
                transitionsFunctions.add(new Transition<>(state1, state2, transitionString));
            }
        }
    }

    public void runMenu() {
        while(true) {

            System.out.println("\n\nmenu:");
            System.out.println("0 exit:");
            System.out.println("1 states:");
            System.out.println("2 transition set:");
            System.out.println("3 initial state:");
            System.out.println("4 final states:");
            System.out.println("5 transition function");
            System.out.println("");
            Scanner scanner = new Scanner(System.in);
            String x = scanner.nextLine();
            System.out.println("\n your command: " + x + "\n");

            int cmd = Integer.parseInt(x);

            if (cmd == 1) {
                System.out.println("\nstates:");
                for (var st : states) {
                    System.out.println(st);
                }
            }

            else if (cmd == 2) {
                System.out.println("\ntransition set:");
                for (var tr : transitionSet) {
                    System.out.println(tr);
                }
            }

            else if (cmd == 3) {
                System.out.println("\ninitial state:");
                System.out.println(initialState);
            }

            else if (cmd == 4) {
                System.out.println("\nfinal states:");
                for (var st : finalStates) {
                    System.out.println(st);
                }
            }

            else if (cmd == 5) {

                System.out.println("\ntransition function:");
                for (var tf : transitionsFunctions) {
                    System.out.println(tf);
                }
            } else {
                return;
            }

        }

    }

}
