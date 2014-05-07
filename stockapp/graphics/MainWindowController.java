/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockapp.graphics;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import stockapp.GraphicsController;

/**
 * FXML Controller class
 *
 * @author Patryk
 */
public class MainWindowController extends GraphicsController {

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}
	
	@FXML private void handleTempButton(ActionEvent event) throws Exception{
		if(getLogic() == null) {
			throw new Exception("No logic handler has been specified.");
		}
		getLogic().showModule("com.southbridge.nativegraph");
		System.out.println("Hello there!");
	}

}
