import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

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
        assertEquals(10,transactions.getAcc().accountNumber,0.0);
    }

    @Test
    public void getDate() {
        assertEquals(LocalDate.now(), transactions.getDate());
    }

    @Test
    public void getOperation() {
        assertEquals('D', transactions.getOperation());
    }

    @Test
    public void getAmount() {
        assertEquals(2.0, transactions.getAmount(), 0.0);
    }
}