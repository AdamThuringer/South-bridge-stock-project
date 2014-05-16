package stockapp.modules.nativegraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import stockapp.GraphicsController;
import stockapp.Equity;
import stockapp.EquityDay;

public class NativeGraphController extends GraphicsController {
	@FXML private Label stockPrice;
	@FXML private Label stockName;
	@FXML private LineChart<Number, Number> chart;
	@FXML private TextField searchField;
	
    private String symbol;
	
	@FXML private void returnToMain(ActionEvent event) {
		checkLogic();
		getLogic().showModule("com.southbridge.mainwindow");
	}
	
	@FXML private void searchStock(ActionEvent event) {
		String search = searchField.getText();
		if(getLogic().getEquity(search, "2014-01-01", "2014-01-02") != null) {
			symbol = search;
			refresh();
		}
	}
	
	@Override
	public void refresh() {
		checkLogic();
		clear();
		Equity eq = getLogic().getEquity(symbol, "2014-01-01", "2014-05-15");
		stockName.setText(eq.getVariable("Name"));
		stockPrice.setText(eq.getVariable("BidRealtime"));
		
		XYChart.Series<Number, Number> series = new XYChart.Series();
        series.setName("Equity Value");
		
		ArrayList<Entry<String, EquityDay>> historical = sortDates(eq.historicalEntrySet());
		
		Iterator<Entry<String, EquityDay>> it = historical.iterator();
		
		while(it.hasNext()) {
			Entry<String, EquityDay> entry = it.next();
			series.getData().add(new XYChart.Data(entry.getKey(), entry.getValue().getClose()));
		}

        chart.getData().add(series);
	}
	
	private void clear() {
		chart.getData().clear();
	}
	
	private ArrayList<Entry<String, EquityDay>> sortDates(Set<Entry<String, EquityDay>> set) {
		ArrayList<Entry<String, EquityDay>> list = new ArrayList<>(set);
		Comparator<Entry<String, EquityDay>> dateComparator = new Comparator<Entry<String, EquityDay>>() {
			@Override
			public int compare(Entry<String, EquityDay> e1, Entry<String, EquityDay> e2) {
				return e1.getKey().compareTo(e2.getKey());
			}
		};
		
		Collections.sort(list, dateComparator);
		return list;
	}
}
