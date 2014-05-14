package stockapp.stockreader;

import stockapp.Equity;

public class StockReader {
	
	public Equity getEquity(String symbol) {
		YQLQuery query = new YQLQuery();
		query.setStatement("select");
		query.setDataTable("yahoo.finance.quotes");
		query.addRequestedField("*");
		query.addFieldCondition("symbol", symbol);
		try {
			String result = YQLGetter.sendQuery(query);
			Equity eq = XMLFormatter.format(result);
			return eq;
		} catch(Exception ex) {}
		return null
		
	}
	
	private void getSymbols() {
		
	}
	
}
