package com.nextcapital.recruiting;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UnsubscribeServiceTest {

	private List<Map<String, String>> statementCharges;
	private UnsubscribeService service;

	@BeforeEach
	public void beforeFunction() {
		statementCharges = new ArrayList<>();
		StatementApi statementApi = mock(StatementApi.class);
		service = new UnsubscribeService(statementApi);

		when(statementApi.getCharges()).thenReturn(statementCharges);
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
		Map<String, String> statementCharge = new HashMap<>();
		statementCharge.put("name", name);
		statementCharge.put("date", date);
		statementCharge.put("amount", amount);
		statementCharges.add(statementCharge);
	}
}
