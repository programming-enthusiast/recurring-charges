import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

// You can run individual tests using the following command:
// `gradle test --tests UnsubscribeServiceTest.testDoesNotIncludeChargesThatOnlyOccurOnce`
public class UnsubscribeServiceTest {
    @Test
    public void testDoesNotIncludeChargesThatOnlyOccurOnce() {
        UnsubscribeService service = new UnsubscribeService();

        assertFalse(service.displayRecurringCharges().containsKey("Spotify"));
    }

    @Test
    public void testSumsTheChargesThatOccurMoreThanOnce() {
        UnsubscribeService service = new UnsubscribeService();

        assertTrue(2 == service.displayRecurringCharges().get("Spotify"));
    }
}
