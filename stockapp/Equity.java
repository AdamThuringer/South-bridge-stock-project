package stockapp;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class Equity {
	private HashMap<String, String> variables = new HashMap<>();
	private HashMap<Date, EquityDay> historical = new HashMap<>();
	
	public void putVariable(String k, String v) {
		variables.put(k, v);
	}
	
	public String getVariable(String key) {
		return variables.get(key);
	}
	
	public Set<String> keySet() {
		return variables.keySet();
	}
	
	public void putHistorical(Date d, EquityDay eq) {
		historical.put(d, eq);
	}
	
	public EquityDay getHistorical(Date d) {
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
