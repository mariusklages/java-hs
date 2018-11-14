package space.harbour.java.hw8;
import java.util.*;
import java.util.function.Consumer;

public class CurrencyDispenser implements DispenseChain {
    private DispenseChain chain = null;

    String currency;
    int value;
    int billsLeft;

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
