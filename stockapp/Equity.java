package stockapp;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Equity {
	private HashMap<String, String> variables = new HashMap<>();
	private HashMap<String, EquityDay> historical = new HashMap<>();
	
	public void putVariable(String k, String v) {
		variables.put(k, v);
	}
	
	public String getVariable(String key) {
		return variables.get(key);
	}
	
	public Set<String> variableKeySet() {
		return variables.keySet();
	}
	
	public void putHistorical(String s, EquityDay eq) {
		historical.put(s, eq);
	}
	
	public EquityDay getHistorical(Calendar d) {
		return historical.get(d);
	}
	
	public Set<String> historicalKeySet() {
		return historical.keySet();
	}
	
	public Set<Entry<String, String>> variableEntrySet() {
		return variables.entrySet();
	}
	
	public Set<Entry<String, EquityDay>> historicalEntrySet() {
		return historical.entrySet();
	}
}
