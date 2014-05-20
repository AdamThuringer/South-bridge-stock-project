package stockapp.modules.mainwindow;

import java.net.URL;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import stockapp.GraphicsController;
import stockapp.Module;

public class MainWindowController extends GraphicsController {	
	@FXML private ListView<Entry<String, Module>> moduleList;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		moduleList.setCellFactory(new ModuleCallback());
	}
	
	@FXML private void handleOpenModule(ActionEvent event) {
		checkLogic();
		
		String path = moduleList.getSelectionModel().getSelectedItem().getValue().getPath();
		getLogic().showModule(path);
	}

	@Override
	public void refresh() {
		checkLogic();
		
		moduleList.getItems().clear();
		moduleList.getItems().addAll(getLogic().getModuleList());
	}
}
