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
	
	public Set<String> keySet() {
		return variables.keySet();
	}
	
	public void putHistorical(Calendar d, EquityDay eq) {
		historical.put(d, eq);
	}
	
	public EquityDay getHistorical(Calendar d) {
		return historical.get(d);
	}
	
	public class EquityDay {
		private double open, high, low, close;
		private long volume;
		
		public EquityDay(double open, double close, double high, double low, long volume) {
			this.open = open;
			this.high = high;
			this.low = low;
			this.close = close;
			this.volume = volume;
		}
		
		public double getOpen() {
			return open;
		}
		
		public double getClose() {
			return close;
		}
		
		public double getHigh() {
			return high;
		}
		
		public double getLow() {
			return low;
		}
		
		public long getVolume() {
			return volume;
		}
	}
}
