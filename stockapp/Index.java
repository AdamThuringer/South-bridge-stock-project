package stockapp;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Index {
	private HashMap<String, String> stocks = new HashMap<>();
	private String indexSymbol;
	
	public Index(String index) {
		indexSymbol = index;
	}
	
	public void putEquity(String symbol, String name) {
		stocks.put(symbol, name);
	}
	
	public String getIndexSymbol() {
		return indexSymbol;
	}
	
	public Set<Entry<String, String>> getEntrySet() {
		return stocks.entrySet();
	}
}
