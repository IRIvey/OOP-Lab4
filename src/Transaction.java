
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private LocalDate date;
    private double amount;
    private String description;

    public Transaction(String date, double amount, String description) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.date = LocalDate.parse(date, formatter);
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
