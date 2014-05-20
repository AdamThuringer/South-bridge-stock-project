package stockapp.modules.bidask;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import stockapp.GraphicsController;
import stockapp.Logic;
import stockapp.Module;


public class BidAsk implements Module {
    private Parent root;
	private GraphicsController controller;
	
	public BidAsk(Logic logic) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("BidAsk.fxml"));
		root = (Parent) loader.load();
		controller = (GraphicsController) loader.getController();
		controller.setLogicHandler(logic);
	}
        
    @Override
	public String getName() {
		return "Bid/Ask Comparator";
	}

	@Override
	public String getAuthor() {
		return "Southbridge";
	}

	@Override
	public String getPath() {
		return "com.southbridge.bidask";
	}

	@Override
	public Parent getRoot() {
		return root;
	}

	@Override
	public void refresh() {
		controller.refresh();
	}

	@Override
	public boolean isInternal() {
		return false;
	}
}
