package space.harbour.java.hw9;

public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);
    DispenseChain nextChain();
    void dispense(int remainder);
}
