package com.nextcapital.recruiting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnsubscribeService {
   public Map<String, Integer> displayRecurringCharges() {
        Map<String, Integer> billStatement = new HashMap<String, Integer>();
        Map<String, Integer> recurringCharges = new HashMap<String, Integer>();

        for (Map<String, String> charge : getCharges()) {
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

   public List<Map<String, String>> getCharges() {
     StatementApi statementApi = new StatementApi();
     return statementApi.getCharges();
   }
}
