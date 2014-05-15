/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockapp.stockreader;

import java.util.Calendar;
import stockapp.Equity;
import stockapp.EquityDay;

public class XMLFormatter {	
	public static Equity format(String text) {
		Equity eq = new Equity();
		String results = text.split("<results>")[1].split("</results>")[0];
		String fields = results.split("\">")[1].split("</quote>")[0];
		//System.out.println(fields);
		String[] values = fields.split("<(?!/)", 2)[1].split("<(?!/)");
		for(String s : values) {
			//System.out.println(s);
		}
		for(String v : values) {
			if(v.contains("/>")) {
				continue; //Value is empty, there is nothing to store
			}
			String clear = v.split("</")[0];
			String key = clear.split(">")[0];
			String value = clear.split(">")[1];
			//System.out.println(key + ": " + value);
			eq.putVariable(key, value);
		}
		
		return eq;
	}
	
	public static void formatHistorical(Equity eq, String xml) {
		String results = xml.split("<results>")[1].split("</results>")[0];
		String[] days = results.split("</quote>");
		for(String str1 : days) {
			Calendar cal = Calendar.getInstance();
			EquityDay eqd = new EquityDay();
			
			String fields = str1.split("\">", 2)[1];
			String[] values = fields.split("<(?!/)", 2)[1].split("<(?!/)");
			for(String str2 : values) {
				if(str2.contains("/>")) {
					continue; //Value is empty, there is nothing to store
				}
				String clear = str2.split("</")[0];
				String key = clear.split(">")[0];
				String value = clear.split(">")[1];
				if(key.equals("Date")) {
					String[] dateFormats = value.split("-");
					int year = Integer.parseInt(dateFormats[0]);
					int month = Integer.parseInt(dateFormats[1]);
					int day = Integer.parseInt(dateFormats[2]);
					cal.set(year, month, day);
				} else if(key.equals("Open")) {
					double d = Double.parseDouble(value);
					eqd.setOpen(d);
				} else if(key.equals("Close")) {
					double d = Double.parseDouble(value);
					eqd.setClose(d);
				} else if(key.equals("High")) {
					double d = Double.parseDouble(value);
					eqd.setHigh(d);
				} else if(key.equals("Low")) {
					double d = Double.parseDouble(value);
					eqd.setLow(d);
				} else if(key.equals("Volume")) {
					Long l = Long.parseLong(value);
					eqd.setVolume(l);
				}
			}
			eq.putHistorical(cal, eqd);
		}
	}
}
