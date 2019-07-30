import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class StatementApi {
    public List<HashMap<String, String>> getCharges() {
        List<HashMap<String, String>> statementCharges = new ArrayList<HashMap<String, String>>();
        
        HashMap<String, String> firstStatementCharge = new HashMap<String, String>();
        firstStatementCharge.put("name", "Spotify");
        firstStatementCharge.put("date", "1/1/2019");
        firstStatementCharge.put("amount", "9.99");
        statementCharges.add(firstStatementCharge);

        return statementCharges;
    }
}
