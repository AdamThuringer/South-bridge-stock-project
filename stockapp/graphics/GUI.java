/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockapp.graphics;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import stockapp.GraphicsController;
import stockapp.Logic;

public class GUI {
	private Stage stage;
	
	public GUI(Stage stage, Logic logic) throws Exception{
		this.stage = stage;
		initMainWindow(logic);
	}
	
	public void openModule(Parent root) {
		stage.setScene(new Scene(root));
	}
	
	private void initMainWindow(Logic logic) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
		Parent root = (Parent) loader.load();
		GraphicsController controller = (GraphicsController) loader.getController();
		controller.setLogicHandler(logic);
		
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
	}
}
