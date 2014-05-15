/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockapp.modules.nativegraph;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import stockapp.GraphicsController;
import stockapp.Logic;
import stockapp.Module;
import stockapp.Request;
import stockapp.Response;

public class NativeGraph implements Module{
	
	private Parent root;
	
	public NativeGraph(Logic logic) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("NativeGraph.fxml"));
		root = (Parent) loader.load();
		GraphicsController controller = (GraphicsController) loader.getController();
		controller.setLogicHandler(logic);
	}
	@Override
	public Response request(Request r) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public String getName() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public String getAuthor() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public String getPath() {
		return "com.southbridge.nativegraph";
	}

	@Override
	public Parent getRoot() {
		return root;
	}

}
