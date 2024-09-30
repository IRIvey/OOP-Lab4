import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.util.List;

public class XMLTransactionParser implements TransactionParser {
    @Override
    public List<Transaction> parse(String filePath) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(new File(filePath), new TypeReference<List<Transaction>>() {});
    }
}
