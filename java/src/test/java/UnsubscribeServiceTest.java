import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


public class UnsubscribeServiceTest {

    private List<HashMap<String, String>> statementCharges;
    private UnsubscribeService service;

    @BeforeEach
    public void beforeFunction() {
        service = mock(UnsubscribeService.class);
        statementCharges = new ArrayList<HashMap<String, String>>();

        when(service.displayRecurringCharges()).thenCallRealMethod();
        when(service.getCharges()).thenReturn(statementCharges);
    }

    @Test
    public void testDoesNotIncludeChargesThatOnlyOccurOnce() {
        addCharge("Spotify", "1/1/2019", "9.99");

        assertFalse(service.displayRecurringCharges().containsKey("Spotify"));
    }

    @Test
    public void testSumsTheChargesThatOccurMoreThanOnce() {
        addCharge("Spotify", "1/1/2019", "9.99");
        addCharge("Spotify", "2/1/2019", "9.99");

        assertTrue(2 == service.displayRecurringCharges().get("Spotify"));
    }

    private void addCharge(String name, String date, String amount) {
        HashMap<String, String> statementCharge = new HashMap<String, String>();
        statementCharge.put("name", name);
        statementCharge.put("date", date);
        statementCharge.put("amount", amount);
        statementCharges.add(statementCharge);
    }
}
