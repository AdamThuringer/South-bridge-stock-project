/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockapp.graphics;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import stockapp.Logic;

public class GUI {
	private Stage stage;
	@FXML private StackPane base;
	
	public GUI(Stage stage, Logic logic) throws Exception{
		this.stage = stage;
		initBackground();
	}
	
	public void openModule(Parent root) {
		base.getChildren().clear();
		base.getChildren().add(root);
		//stage.setScene(new Scene(root));
	}
	
	private void initBackground() throws Exception{
		base = new StackPane();
		base.setPrefSize(800, 600);
		Scene scene = new Scene(base);
		stage.setScene(scene);
		stage.show();
	}
}
