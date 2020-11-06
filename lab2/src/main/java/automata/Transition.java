package automata;

import automata.states.State;

public class Transition<T, P> {

    protected State<T> state1;
    protected State<T> state2;
    protected P transition;

    public Transition(State<T> state1, State<T> state2, P transition) {
        this.state1 = state1;
        this.state2 = state2;
        this.transition = transition;
    }

    public State<T> getState1() {
        return state1;
    }

    public void setState1(State<T> state1) {
        this.state1 = state1;
    }

    public State<T> getState2() {
        return state2;
    }

    public void setState2(State<T> state2) {
        this.state2 = state2;
    }

    public P getTransition() {
        return transition;
    }

    public void setTransition(P transition) {
        this.transition = transition;
    }

    @Override
    public String toString() {
        return "st1: " + state1 + "  + tr: " + transition + " ->  st " + state2 + " ";
    }
}
