package stockapp.modules.bidask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import stockapp.Equity;
import stockapp.GraphicsController;

public class BidAskController extends GraphicsController {
    @FXML private Button goButton;
    @FXML private TextField searchBar;
    @FXML private Label latestBid, bid, latestAsk, ask;
    
    @FXML private void handleGoButton(ActionEvent event) {
		checkLogic();
        Equity eq = getLogic().getEquity(searchBar.getCharacters().toString(), "2014-01-01", "2014-01-02");
        bid.setText(eq.getVariable("Bid"));
        ask.setText(eq.getVariable("Ask"));
    }
    
	@FXML private void returnToMain(ActionEvent event) {
		checkLogic();
		getLogic().showModule("com.southbridge.mainwindow");
	}
	
    @Override 
    public void refresh() {
    }
	
}
 