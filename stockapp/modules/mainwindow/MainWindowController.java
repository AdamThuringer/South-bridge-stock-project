/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockapp.modules.mainwindow;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.SplitMenuButton;
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
    @FXML private Menu menu;
    @FXML private Label label;
    @FXML private SplitMenuButton moduleBrowser;
    
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}
	
	@FXML private void module1(ActionEvent event) {
		checkLogic();
		getLogic().showModule("com.southbridge.nativegraph");
	}
        
    @FXML private void exitButton(ActionEvent event) throws Exception{
		System.exit(0);
	}

	@Override
	public void refresh() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
