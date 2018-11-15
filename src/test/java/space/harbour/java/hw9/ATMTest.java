package space.harbour.java.hw9;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ATMTest extends TestCase {

    ArrayList<Integer> denom;
    ATM atm;
    BankDepartment bankDepartment;

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
        atm.id = 999;
        List<ATM> atms = new ArrayList<>();
        atms.add(atm);
        bankDepartment = new BankDepartment(atms);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testEmptyNotif() {
        atm.withdraw(10000);
        assertEquals(bankDepartment.lastEmptied, atm.id);
    }

    @Test
    public void testEmptyNotifNotCalled() {
        atm.withdraw(100);
        assertEquals(bankDepartment.lastEmptied, -1);
    }

    @Test
    public void testGetBalance() {
        int initialBalance = atm.getBalance();
        atm.withdraw(470);

        assertEquals(atm.getBalance(), initialBalance - 470);
    }
}