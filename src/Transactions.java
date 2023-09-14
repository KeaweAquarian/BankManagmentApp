import java.io.Serializable;
import java.time.LocalDate;

public class Transactions implements Comparable<Transactions>, Serializable {

    //Attributes
    private static int next = 1;
    int trsNo;
    Account acc;
    LocalDate date;
    char operation;
    double amount;

    public Transactions( Account acc, LocalDate date, char operation, double amount) {
        this.trsNo = next++;
        this.acc = acc;
        this.date = date;
        this.operation = operation;
        this.amount = amount;
    }

    @Override
    public int compareTo(Transactions o) {
        return this.trsNo - o.trsNo;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "trsNo=" + trsNo +
                ", acc=" + acc +
                ", date=" + date +
                ", operation=" + operation +
                ", amount=" + amount +
                '}';
    }

    public int getTrsNo() {
        return trsNo;
    }

    public Account getAcc() {
        return acc;
    }

    public LocalDate getDate() {
        return date;
    }

    public char getOperation() {
        return operation;
    }

    public double getAmount() {
        return amount;
    }
}
