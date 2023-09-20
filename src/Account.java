import java.util.Date;

public class Account implements Comparable{
    //confirm why gender is required in this account

    //Attributes
    static int nextAccountNumber = 10;
    int accountNumber;
    String owner;
    City city;
    //Remove gender
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

    public double setBalance(double balance) {
        this.balance = balance > 0.0 ? balance:0.0;
        return this.balance;
    }

    @Override
    public String toString() {
        return  accountNumber + " " + " " + owner + " " + city + " " + gender + " " + balance + " " + openDate ;
    }

    @Override
    public int compareTo(Object o) {
        return this.owner.compareTo(((Account) o) .owner);
    }

    public void deposit(double amount){
        if (amount > 0){
            setBalance(balance + amount);
        }
    }

    public double withdraw(double amount){
        if (amount > 0){
            if(amount < balance){
                setBalance(balance - amount);
            }
            else {
                setBalance(0.0);
            }
            return balance;
        }
        return 0.0;
    }
}
