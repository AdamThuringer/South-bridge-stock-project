/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockapp.stockreader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class YQLQuery {
	private String statement;
	private ArrayList<String> requestedFields = new ArrayList<>();
	private String dataTable;
	private HashMap<String, String> fieldConditions = new HashMap<>();
	
	public String getFullQuery() {
		return statement + " " + getRequestedFields() + " from " + dataTable + " " + getFieldConditions();
	}
	
	public String getRequestedFields() {
		Iterator<String> it = requestedFields.iterator();
		String full = it.next();
		while(it.hasNext()) {
			full += ", " + it.next();
		}
		return full;
	}
	
	public String getFieldConditions() {
		Iterator<Entry<String, String>> it = fieldConditions.entrySet().iterator();
		String conditions = "";
		while(it.hasNext()) {
			Entry<String, String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			conditions += key + "=\"" + value + "\""; 
			if(it.hasNext()) {
				conditions += " and ";
			}
		}
		String full = "";
		if(!conditions.isEmpty()) {
			full += "where ";
		}
		full += conditions;
		return full;
	}
	
	public void setStatement(String s) {
		statement = s;
	}
	
	public void addRequestedField(String s) {
		requestedFields.add(s);
	}
	
	public void setDataTable(String s) {
		dataTable = s;
	}
	
	public void addFieldCondition(String key, String value) {
		fieldConditions.put(key, value);
	}
	
}
