package stockapp.modules.nativegraph;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import stockapp.GraphicsController;
import stockapp.Logic;
import stockapp.Module;

public class NativeGraph implements Module{
	private Parent root;
	private GraphicsController controller;
	
	public NativeGraph(Logic logic) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("NativeGraph.fxml"));
		root = (Parent) loader.load();
		controller = (GraphicsController) loader.getController();
		controller.setLogicHandler(logic);
	}

	@Override
	public String getName() {
		return "Default Graph";
	}

	@Override
	public String getAuthor() {
		return "Southbridge";
	}

	@Override
	public String getPath() {
		return "com.southbridge.nativegraph";
	}

	@Override
	public Parent getRoot() {
		return root;
	}

	@Override
	public void refresh() {
		controller.refresh();
	}

}
