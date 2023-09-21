import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TransactionsTest {
    Transactions transactions = new Transactions(new Account("Terry", new City("New York", "New York"), 'm'), LocalDate.now(),'D', 2.0);

    @Test
    public void compareTo() {
    }

    @Test
    public void testToString() {
    }

    @Test
    public void getTrsNo() {
        assertEquals(1,transactions.getTrsNo(),0.0);
    }

    @Test
    public void getAcc() {
    }

    @Test
    public void getDate() {
    }

    @Test
    public void getOperation() {
    }

    @Test
    public void getAmount() {
    }
}