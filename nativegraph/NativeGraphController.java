/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockapp.modules.nativegraph;

import java.util.Calendar;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import stockapp.Equity;
import stockapp.GraphicsController;
import stockapp.Logic;

/**
 * FXML Controller class
 *
 * @author Patryk
 */
public class NativeGraphController extends GraphicsController {

    private Date day;

    public NativeGraphController() {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        this.LineChart = new LineChart<Number, Number>(xAxis, yAxis);

    }

    @FXML
    private void handleOptionsButton(ActionEvent event) {

    }
    @FXML
    private final LineChart<Number, Number> LineChart;

    ;

    @FXML
    private void handleLineChart(ActionEvent event) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(0);
        c.set(2014, 03, 15);
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Yahoo");
        //populating the series with data
        checkLogic();
        Equity eq = getLogic().getEquity("YHOO");
        System.out.println(c + " " + eq.getHistorical(c));
        series.getData().add(new XYChart.Data(1, eq.getHistorical(c)));
        c.add(Calendar.DATE, 1);

        LineChart.getData().add(series);
    }
//        defining a series
//        XYChart.Series series = new XYChart.Series();
//        series.setName("Yahoo");
//        populating the series with data
//        checkLogic();
//        Equity eq = getLogic().getEquity("YHOO");
//        series.getData().add(new XYChart.Data(1, eq.getHistorical(What???))); 
//        series.getData().add(new XYChart.Data(2, 2));

    @FXML
    private void requestOMX(ActionEvent event) {
        checkLogic();
        Logic logic = getLogic();
        logic.getEquity("name-of-stock"); //The format of the stock identification will be decided later
    }

    @FXML
    private void requestNASDAQ(ActionEvent event) {

    }

    @FXML
    private void requestYahoo(ActionEvent event) {
        checkLogic();
        Equity eq = getLogic().getEquity("YHOO");
        for (String s : eq.keySet()) {
            System.out.println("-> " + s);
        }
    }
}
