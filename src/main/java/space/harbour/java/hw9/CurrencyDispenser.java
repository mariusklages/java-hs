package space.harbour.java.hw9;

import java.util.Observable;
import java.util.Observer;

public class CurrencyDispenser extends Observable implements DispenseChain, Cloneable {
    private DispenseChain chain = null;

    String currency;
    int value;
    int billsLeft;
    Observer atm;

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        atm = o;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        CurrencyDispenser clone = (CurrencyDispenser) super.clone();
        clone.currency = currency;
        clone.value = value;
        clone.billsLeft = billsLeft;
        clone.chain = chain;
        return clone;
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
        atm.update(this, null);
    }

    public CurrencyDispenser(String currency, int value, int billsLeft) {
        this.currency = currency;
        this.value = value;
        this.billsLeft = billsLeft;
    }

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }


    @Override
    public DispenseChain nextChain() {
        return chain;
    }

    @Override
    public void dispense(int remainder) {
        if (remainder >= value) {
            int num = remainder / value;
            if (num > billsLeft)
                num = billsLeft;
            remainder -= num * value;
            billsLeft -= num;
            System.out.println("Dispensing " + num + " " + value + currency + " note" + (num > 1 ? "s" : ""));

            if (billsLeft == 0)
                notifyObservers();
        }
        if (remainder > 0) {
            if (nextChain() != null) {
                nextChain().dispense(remainder);
            } else
                System.out.println("Could not dispense the rest " + remainder + currency);
        } else {
            System.out.println("Dispensed Successfully");
        }
    }
}
