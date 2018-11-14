package space.harbour.java.class8;

public class StateContext {
    private State state;

    public StateContext(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void print(char letter) {
        state.print(this, letter);
    }
}
