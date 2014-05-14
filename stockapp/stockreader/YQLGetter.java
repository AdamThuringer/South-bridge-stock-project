/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockapp.stockreader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * This class uses YQL, provided by Yahoo to access financial quotes from
 * the Yahoo Finance API. The data provided is given in an XML file.
 * 
 * @author Patryk Przybysz
 * @version 2014-05-11
 */
public class YQLGetter {
	private static String urlPath = "http://query.yahooapis.com/v1/public/yql?q=";
	private static String postfix = "&env=store://datatables.org/alltableswithkeys";
	
	public static String sendQuery(YQLQuery query) throws Exception {
		String body = URLEncoder.encode(query.getFullQuery(), "utf-8");
		URL url = new URL(urlPath + body + postfix);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		int responseCode = con.getResponseCode();
		
		/*System.out.println("urlPath + body + postfix");
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);*/
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		return response.toString();
	}
	
	public void test() throws Exception{
		YQLQuery q = new YQLQuery();
		q.setStatement("select");
		q.setDataTable("yahoo.finance.quotes");
		q.addRequestedField("*");
		q.addFieldCondition("symbol", "YHOO");
		q.addFieldCondition("symbol", "GOOG");
		
		System.out.println(sendQuery(q));
		
	}
}
