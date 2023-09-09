import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    @Test
    public void setBalance() {
        Account account = new Account("Terry", new City("New York", "New York"), 'm');
        assertEquals(1.1, account.setBalance(1.1), 0.0);

    }
}