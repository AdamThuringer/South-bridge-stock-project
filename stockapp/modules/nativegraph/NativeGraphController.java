/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockapp.modules.nativegraph;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
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

/**
 * FXML Controller class
 *
 * @author Patryk
 */
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
	
    @FXML private void handleLineChart(ActionEvent event) {
		checkLogic();
		
        //symbol = searchBar.getCharacters().toString(); 
        
        //Set calendar
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(0);
        c.set(2014, 03, 15);
        
        //get stock information
        Equity eq = getLogic().getEquity("YHOO", "2013-01-01", "2014-05-16");
        
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName(eq.getVariable("Name"));
        
        /*for (int i =0; i < 30; i ++) {
            series.getData().add(new XYChart.Data(30-i, eq.getHistorical(c).getClose()));
            c.add(Calendar.DATE, 1);
        }*/
        c.add(Calendar.DATE, 1);
        
        series.getData().add(new XYChart.Data(1, 2));
        series.getData().add(new XYChart.Data(2, 1));
        series.getData().add(new XYChart.Data(3, 4));
        chart.getData().add(series);
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
		
		//series.getData().add(new XYChart.Data("2014-03-06", 3));
        //series.getData().add(new XYChart.Data("2014-03-04", 1));
        //series.getData().add(new XYChart.Data("2014-03-05", 2));
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
				/*char[] char1 = e1.getKey().toCharArray();
				char[] char2 = e1.getKey().toCharArray();
				int shortestLen = char1.length;
				if(char1.length > char2.length) {
					shortestLen = char2.length;
				}
				int result = 0;
				for(int i = 0; i < shortestLen; i++) {
					result = Character.compare(char1[i], char2[i]);
					if(result != 0) {
						break;
					}
				}
				return result;*/
			}
		};
		
		Collections.sort(list, dateComparator);
		
		/*Arrays.sort(list, dateComparator);
		Arrays.sort
		Set<Entry<char[], EquityDay>> charSet = new HashSet<>();
		for(Entry<String, EquityDay> entry : set) {
			Entry<char[], EquityDay> charEntry = new AbstractMap.SimpleEntry<char[], EquityDay>(entry.getKey().toCharArray(), entry.getValue());
			charSet.add(charEntry);
		}
		Arrays.sort(a);*/
		return list;
	}
}
