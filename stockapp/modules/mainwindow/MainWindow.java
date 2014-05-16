/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockapp.modules.mainwindow;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import stockapp.GraphicsController;
import stockapp.Logic;
import stockapp.Module;

public class MainWindow implements Module {
	private Parent root;
	private GraphicsController controller;
	
	public MainWindow(Logic logic) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
		root = (Parent) loader.load();
		controller = (GraphicsController) loader.getController();
		controller.setLogicHandler(logic);
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
		return "com.southbridge.mainwindow";
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
