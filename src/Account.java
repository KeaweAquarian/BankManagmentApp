import java.util.Date;

public class Account implements Comparable{

    //Attributes
    static int nextAccountNumber = 10;
    int accountNumber;
    String owner;
    City city;
    char gender;
    double balance;
    Date openDate;

    public Account(String owner, City city, char gender) {
        accountNumber = nextAccountNumber;
        nextAccountNumber +=10;
        this.owner = owner;
        this.city = city;
        this.gender = gender;

        balance = 0.0;
        openDate = null; //System.currentDate()
    }

    public Account(int accountNumber, String owner, City city, char gender, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.city = city;
        this.gender = gender;
        setBalance(balance);

    }

    public void setBalance(double balance) {
        this.balance = balance > 0.0 ? balance:0.0;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", owner='" + owner + '\'' +
                ", city=" + city +
                ", gender=" + gender +
                ", balance=" + balance +
                ", openDate=" + openDate +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.owner.compareTo(((Account) o) .owner);
    }
}
