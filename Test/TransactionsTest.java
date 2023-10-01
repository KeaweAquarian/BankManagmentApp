import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

public class TransactionsTest {
    Transactions transactions = new Transactions(new Account("Terry", new City("New York", "New York"), 'm'), LocalDate.now(),'D', 2.0);
//add differnet class
    //Build a new project.
    //finish testing
    @Test
    public void compareToSameTransaction() {
        assertEquals(0,transactions.compareTo(transactions));
    }

    @Test
    public void compareToDifferentTransaction() {
        Transactions transactions2 = new Transactions(new Account("Terry", new City("New York", "New York"), 'm'), LocalDate.now(),'D', 2.0);
        assertEquals(-1,transactions.compareTo(transactions2));
    }

    @Test
    public void testToString() {
        assertEquals("Transactions{trsNo=1, acc=10  Terry New York-New York m 0.0 null, date=2023-09-26, operation=D, amount=2.0}", transactions.toString());
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