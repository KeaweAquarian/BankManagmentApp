import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {
    Account account = new Account("Terry", new City("New York", "New York"), 'm');


    @Test
    public void testSetBalancePositiveValue() {
        assertEquals(5.5, account.setBalance(5.5), 0.0);
    }
    @Test
    public void testSetBalanceNegativeValue() {
        assertEquals(0.0, account.setBalance(-1.0), 0.0);
    }

    @Test
    public void testToString() {
    }

    @Test
    public void compareTo() {
    }

    @Test
    public void deposit() {
        assertEquals(5.5, account.setBalance(5.5), 0.0);
    }

    @Test
    public void withdraw() {
    }
}