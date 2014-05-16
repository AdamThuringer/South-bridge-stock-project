package stockapp.modules.mainwindow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.SplitMenuButton;
import stockapp.GraphicsController;

public class MainWindowController extends GraphicsController {
    @FXML private Menu menu;
    @FXML private Label label;
    @FXML private SplitMenuButton moduleBrowser;
	
	@FXML private void module1(ActionEvent event) {
		checkLogic();
		getLogic().showModule("com.southbridge.nativegraph");
	}
        
    @FXML private void exitButton(ActionEvent event) throws Exception{
		System.exit(0);
	}

	@Override
	public void refresh() {
		
	}
}
