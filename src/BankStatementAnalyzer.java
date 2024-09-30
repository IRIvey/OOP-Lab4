import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class BankStatementAnalyzer {

    private TransactionParser parser;

    public BankStatementAnalyzer(TransactionParser parser) {
        this.parser = parser;
    }


    public double calculateTotalProfitLoss(List<Transaction> transactions) {
        return transactions.stream().mapToDouble(Transaction::getAmount).sum();
    }


    public int countTransactionsInMonth(List<Transaction> transactions, int month, int year) {
        return (int) transactions.stream()
                .filter(t -> t.getDate().getMonthValue() == month && t.getDate().getYear() == year)
                .count();
    }


    public List<Transaction> getTop10Expenses(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .sorted(Comparator.comparingDouble(Transaction::getAmount))
                .limit(10)
                .collect(Collectors.toList());
    }

    public String getCategoryWithHighestSpend(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0);


    }

    public static void main(String[] args) {
        try {
            TransactionParser parser = new CSVTransactionParser();
            BankStatementAnalyzer analyzer = new BankStatementAnalyzer(parser);


            List<Transaction> transactions = parser.parse("path.csv");


            System.out.println("Total Profit/Loss: " + analyzer.calculateTotalProfitLoss(transactions));
            System.out.println("Transactions in January 2017: " + analyzer.countTransactionsInMonth(transactions, 1, 2017));
            System.out.println("Top 10 Expenses: " + analyzer.getTop10Expenses(transactions));
            System.out.println("Category with Highest Spend: " + analyzer.getCategoryWithHighestSpend(transactions));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
