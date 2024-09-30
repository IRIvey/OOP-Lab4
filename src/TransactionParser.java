import java.util.List;

public interface TransactionParser {
    List<Transaction> parse(String filePath) throws Exception;
}
