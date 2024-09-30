import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVTransactionParser implements TransactionParser {
    @Override
    public List<Transaction> parse(String filePath) throws IOException {
        List<Transaction> transactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }


                String[] values = line.split(",");

                if (values.length >= 3) {
                    String date = values[0];
                    double amount = Double.parseDouble(values[1]);
                    String description = values[2];

                    transactions.add(new Transaction(date, amount, description));
                }
            }
        }

        return transactions;
    }
}
