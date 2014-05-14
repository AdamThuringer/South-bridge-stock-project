/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockapp.modules.nativegraph;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import stockapp.GraphicsController;
import stockapp.Logic;
import stockapp.Equity;

/**
 * FXML Controller class
 *
 * @author Patryk
 */
public class NativeGraphController extends GraphicsController {
	private Logic log;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		log = getLogic();
	}
	
	@FXML private void handleOptionsButton(ActionEvent event) {
		
	}
		
	@FXML private void requestOMX(ActionEvent event) {
		checkLogic();
		Logic logic = getLogic();
		logic.getStock("name-of-stock"); //The format of the stock identification will be decided later
	}
	
	@FXML private void requestNASDAQ(ActionEvent event) {
		
	}
	
	@FXML private void requestYahoo(ActionEvent event) {
		checkLogic();
		Equity eq = log.getStock("YHOO");
	}
}
