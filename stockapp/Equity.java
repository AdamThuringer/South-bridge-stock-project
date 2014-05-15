package stockapp;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;

public class Equity {
	private HashMap<String, String> variables = new HashMap<>();
	private HashMap<Calendar, EquityDay> historical = new HashMap<>();
	
	public void putVariable(String k, String v) {
		variables.put(k, v);
	}
	
	public String getVariable(String key) {
		return variables.get(key);
	}
	
	public Set<String> variableKeySet() {
		return variables.keySet();
	}
	
	public void putHistorical(Calendar d, EquityDay eq) {
		historical.put(d, eq);
	}
	
	public EquityDay getHistorical(Calendar d) {
		return historical.get(d);
	}
	
	public Set<Calendar> historicalKeySet() {
		return historical.keySet();
	}
}
