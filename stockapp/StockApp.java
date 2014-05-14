/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockapp;

import javafx.application.Application;
import javafx.stage.Stage;
import stockapp.stockreader.YQLGetter;

/**
 *
 * @author Patryk Przybysz
 */
public class StockApp extends Application {
	
	Logic logic;
	@Override
	public void start(Stage stage) throws Exception {
		logic = new Logic(stage);
		new YQLGetter().test();
		/*Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		FXMLLoader loader = new FXMLLoader();
		
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();*/
	}

	/**
	 * The main() method is ignored in correctly deployed JavaFX application.
	 * main() serves only as fallback in case the application can not be
	 * launched through deployment artifacts, e.g., in IDEs with limited FX
	 * support. NetBeans ignores main().
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
