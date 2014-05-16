/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Patryk
 */
public abstract class GraphicsController implements Initializable {

	private Logic logic;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}
	
	public void setLogicHandler(Logic l) {
		logic = l;
	}
	
	public void checkLogic() throws RuntimeException {
		if(logic == null) {
			throw new RuntimeException("No logic handler has been specified.");
		}
	}
	
	public Logic getLogic() {
		return logic;
	}
	
	public abstract void refresh();
}
