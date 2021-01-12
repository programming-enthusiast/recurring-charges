package com.nextcapital.recruiting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnsubscribeService {
	private StatementApi statementApi;

	public UnsubscribeService(StatementApi statementApi) {
		this.statementApi = statementApi;
		
	}
	
   public Map<String, Integer> displayRecurringCharges() {
		Map<String, Integer> billStatement = new HashMap<>();
		Map<String, Integer> recurringCharges = new HashMap<>();

		List<Map<String, String>> charges = statementApi.getCharges();

		for (Map<String, String> charge : charges) {
            String name = charge.get("name");
            int chargeCount = billStatement.getOrDefault(name, 0) + 1;
            billStatement.put(name, chargeCount);
        }

        for (Map.Entry<String, Integer> chargeEntry : billStatement.entrySet()) {
            if (chargeEntry.getValue() >= 1) {
                recurringCharges.put(chargeEntry.getKey(), chargeEntry.getValue());
            }
        }

        return recurringCharges;
    }
}
