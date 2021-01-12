package com.nextcapital.recruiting;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class StatementApi {
	public List<Map<String, String>> getCharges() {
		List<Map<String, String>> statementCharges = new ArrayList<>();

		Map<String, String> firstStatementCharge = new HashMap<>();
		firstStatementCharge.put("name", "Spotify");
		firstStatementCharge.put("date", "1/1/2019");
		firstStatementCharge.put("amount", "9.99");
		statementCharges.add(firstStatementCharge);

		return statementCharges;
	}
}
