package stockapp;

import java.util.HashMap;
import java.util.Set;

public class Equity {
	private HashMap<String, String> variables = new HashMap<>();
	
	public void putVariable(String k, String v) {
		variables.put(k, v);
	}
	
	public String getVariable(String key) {
		return variables.get(key);
	}
	
	public Set<String> keySet() {
		return variables.keySet();
	}
}
