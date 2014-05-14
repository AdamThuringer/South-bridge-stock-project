/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockapp;

import stockapp.stockreader.StockReader;
import java.util.HashMap;
import javafx.stage.Stage;
import stockapp.graphics.GUI;
import stockapp.modules.nativegraph.NativeGraph;

public class Logic {
	private GUI gui;
	private StockReader reader;
	
	private HashMap<String, Module> modules;
	
	public Logic(Stage stage) {
		modules = new HashMap<>();
		initNativeModules();
		try {
			gui = new GUI(stage, this);
		} catch(Exception ex) {}
		reader = new StockReader();
		
	}
	public void loadModule(Module mod) {
		modules.put(mod.getPath(), mod);
	}
	
	public void showModule(String path) {
		gui.openModule(getModule(path).getRoot());
	}
	
	public Module getModule(String path) {
		Module m = modules.get(path);
		if(m == null) {
			throw new IllegalArgumentException("There is no module with that path.");
		}
		return m;
	}
	
	public Equity getEquity(String symbol) {
		return reader.getEquity(symbol);
	}
	
	private void initNativeModules(){
		try {
			loadModule(new NativeGraph(this));
		} catch(Exception ex) {ex.printStackTrace();}
	}
}
