/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockapp.modules.nativegraph;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import stockapp.GraphicsController;
import stockapp.Logic;
import stockapp.Equity;

/**
 * FXML Controller class
 *
 * @author Patryk
 */
public class NativeGraphController extends GraphicsController {
    
    @FXML private LineChart LineChart;
    
    @FXML private void handleLineChart() {
        LineChart.setTitle("Stock Monitoring, 2010");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));
        series.getData().add(new XYChart.Data(6, 36));
        series.getData().add(new XYChart.Data(7, 22));
        series.getData().add(new XYChart.Data(8, 45));
        series.getData().add(new XYChart.Data(9, 43));
        Scene scene = new Scene(LineChart,800,600);
        LineChart.getData().add(series);        
    }
	
	@FXML private void handleOptionsButton(ActionEvent event) {
		
	}
		
	@FXML private void requestOMX(ActionEvent event) {
		checkLogic();
		Logic logic = getLogic();
		logic.getEquity("name-of-stock"); //The format of the stock identification will be decided later
	}
	
	@FXML private void requestNASDAQ(ActionEvent event) {
		
	}
	
	@FXML private void requestYahoo(ActionEvent event) {
		checkLogic();
		Equity eq = getLogic().getEquity("YHOO");
		for(String s : eq.keySet()) {
			System.out.println("-> " + s);
		}
	}
}
