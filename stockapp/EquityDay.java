/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockapp;

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
	
	public EquityDay() {
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
	
	public void setOpen(double o) {
		open = o;
	}
	
	public void setClose(double c) {
		close = c;
	}
	
	public void setHigh(double h) {
		high = h;
	}
	
	public void setLow(double l) {
		low = l;
	}
	
	public void setVolume(long v) {
		volume = v;
	}
}
