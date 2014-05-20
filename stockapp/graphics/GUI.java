package stockapp.graphics;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import stockapp.GraphicsController;
import stockapp.Logic;

public class GUI {
	private Stage stage;
	@FXML private BorderPane base;
	
	public GUI(Stage stage, Logic logic) throws Exception{
		this.stage = stage;
		initBackground();
	}
	
	public void openModule(Parent root) {
		base.setCenter(root);
	}
	
	private void initBackground() throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Background.fxml"));
		base = (BorderPane) loader.load();
		//base.setPrefSize(800, 600);
		Scene scene = new Scene(base);
		stage.setScene(scene);
		stage.show();
	}
}
