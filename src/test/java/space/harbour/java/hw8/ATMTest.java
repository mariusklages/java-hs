package space.harbour.java.hw8;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ATMTest extends TestCase {

    ArrayList<Integer> denom;
    ATM atm;

    @Before
    public void setUp() throws Exception {
        denom = new ArrayList();
        denom.add(1);
        denom.add(5);
        denom.add(10);
        denom.add(20);
        denom.add(50);
        denom.add(100);
        denom.add(200);
        atm = new ATM(denom, "$", 10);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetBalance() {
        int initialBalance = atm.getBalance();
        atm.withdraw(470);

        assertEquals(atm.getBalance(), initialBalance - 470);
    }
}