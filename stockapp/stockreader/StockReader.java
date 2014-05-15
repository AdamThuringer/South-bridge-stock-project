package stockapp.stockreader;

import java.io.IOException;
import stockapp.Equity;

public class StockReader {
	public Equity getEquity(String symbol, String startDate, String endDate) {
		Equity eq = getEquityQuotes(symbol);
		putHistoricalData(eq, startDate, endDate);
		return eq;
	}
	
	public Equity getEquityQuotes(String symbol) {
		YQLQuery query = new YQLQuery();
		query.setStatement("select");
		query.setDataTable("yahoo.finance.quotes");
		query.addRequestedField("*");
		query.addFieldCondition("symbol", symbol);
		try {
			String result = YQLGetter.sendQuery(query);
			Equity eq = XMLFormatter.format(result);
			return eq;
		} catch(IOException ex) {
			System.out.println("1. A problem has arisen.");
		}
		return null;
	}
	
	public void putHistoricalData(Equity eq, String startDate, String endDate) {
		YQLQuery query = new YQLQuery();
		query.setStatement("select");
		query.setDataTable("yahoo.finance.historicaldata");
		query.addRequestedField("*");
		query.addFieldCondition("symbol", eq.getVariable("Symbol"));
		query.addFieldCondition("startDate", startDate);
		query.addFieldCondition("endDate", endDate);
		try {
			String result = YQLGetter.sendQuery(query);
			XMLFormatter.formatHistorical(eq, result);
		} catch(IOException ex) {
			System.out.println("2. A problem has arisen.");
		}
	}
	
	private void getSymbols() {
		
	}
	
}
