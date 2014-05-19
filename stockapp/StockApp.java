package stockapp;

import javafx.application.Application;
import javafx.stage.Stage;
import stockapp.stockreader.YQLGetter;

public class StockApp extends Application {
	
	private Logic logic;
	@Override
	public void start(Stage stage) throws Exception {
		logic = new Logic(stage);
		new YQLGetter().test();
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
