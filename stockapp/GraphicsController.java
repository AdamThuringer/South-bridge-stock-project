package stockapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public abstract class GraphicsController implements Initializable {
	private Logic logic;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
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
