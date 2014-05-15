/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockapp.stockreader;

import stockapp.Equity;

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
}
