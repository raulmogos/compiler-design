package automata.states;

public class State<T> {

    private T content;

    private boolean isStart;
    private boolean isFinal;

    public State(T content) {
        this.content = content;
        this.isStart = false;
        this.isFinal = false;
    }

    public State(T content, boolean isStart, boolean isEnd) {
        this.content = content;
        this.isStart = isStart;
        this.isFinal = isEnd;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }

    @Override
    public String toString() {
        return content + " ";
    }
}
