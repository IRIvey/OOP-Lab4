
public class AllTransactionParser {
    public static TransactionParser getParser(String fileType) {
        switch (fileType.toLowerCase()) {
            case "csv":
                return new CSVTransactionParser();
            case "json":
                return new JSONTransactionParser();
            case "xml":
                return new XMLTransactionParser();
            default:
                throw new IllegalArgumentException("Unknown file type");
        }
    }
}
