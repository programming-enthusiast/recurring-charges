import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class StatementApi {
    public static List<HashMap<String, String>> getCharges() {
        List<HashMap<String, String>> statementCharges = new ArrayList<HashMap<String, String>>();
        
        HashMap<String, String> firstStatementCharge = new HashMap<String, String>();
        firstStatementCharge.put("name", "Spotify");
        firstStatementCharge.put("date", "1/1/2019");
        firstStatementCharge.put("amount", "9.99");
        statementCharges.add(firstStatementCharge);

        // HashMap<String, String> secondStatementCharge = new HashMap<String, String>();
        // secondStatementCharge.put("name", "Spotify");
        // secondStatementCharge.put("date", "2/1/2019");
        // secondStatementCharge.put("amount", "9.99");
        // statementCharges.add(secondStatementCharge);

        return statementCharges;
    }
}
