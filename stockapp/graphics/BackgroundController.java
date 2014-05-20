package stockapp.graphics;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class BackgroundController implements Initializable {

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}	
	
	@FXML private void exitButton(ActionEvent event) {
		System.exit(1);
	}
}
