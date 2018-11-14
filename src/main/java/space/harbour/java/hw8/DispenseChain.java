package space.harbour.java.hw8;

public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);
    DispenseChain nextChain();
    void dispense(int remainder);
}
