package stockapp;

import stockapp.stockreader.StockReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javafx.stage.Stage;
import stockapp.graphics.GUI;
import stockapp.modules.bidask.BidAsk;
import stockapp.modules.mainwindow.MainWindow;
import stockapp.modules.nativegraph.NativeGraph;

public class Logic {
	private GUI gui;
	private StockReader reader;
	
	private HashMap<String, Module> modules;
	private HashMap<String, Index> indices;
	
	public Logic(Stage stage) {
		modules = new HashMap<>();
		indices = new HashMap<>();
		initNativeModules();
		initDefaultIndices();
		try {
			gui = new GUI(stage, this);
			showModule("com.southbridge.mainwindow");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		reader = new StockReader();
		
	}
	
	public void loadModule(Module mod) {
		modules.put(mod.getPath(), mod);
	}
	
	public void showModule(String path) {
		gui.openModule(getModule(path).getRoot());
		getModule(path).refresh();
	}
	
	public Module getModule(String path) {
		Module m = modules.get(path);
		if(m == null) {
			throw new IllegalArgumentException("There is no module with that path.");
		}
		return m;
	}
	
	public Set<Entry<String, Module>> getModuleList() {
		Set<Entry<String, Module>> set = new HashSet<>(modules.entrySet());
		Iterator<Entry<String, Module>> it = set.iterator();
		while(it.hasNext()) {
			Entry<String, Module> entry = it.next();
			if(entry.getValue().isInternal()) {
				it.remove();
			}
		}
		return set;
	}
	
	public Equity getEquity(String symbol, String startDate, String endDate) {
		return reader.getEquity(symbol, startDate, endDate);
	}
	
	public Set<Entry<String, Index>> getIndices() {
		return indices.entrySet();
	}
	
	private void initNativeModules(){
		try {
			loadModule(new MainWindow(this));
			loadModule(new NativeGraph(this));
			loadModule(new BidAsk(this));
		} catch(Exception ex) {ex.printStackTrace();}
	}
	
	private void initDefaultIndices() {
		Index omx = new Index("^OMXS30");
		omx.putEquity("ABB.ST", "ABB Ltd.");
		omx.putEquity("ERIC-B.ST", "Ericsson B");
		omx.putEquity("INVE-B.ST", "Investor B");
		omx.putEquity("LUPE.ST", "Lundin Petroleum");
		omx.putEquity("SAND.ST", "Sandvik");
		omx.putEquity("TLSN.ST", "Telia Sonera");
		indices.put("OMXS30", omx);
		Index fav = new Index("");
		fav.putEquity("NDA-SEK.ST", "Nordea Bank");
		fav.putEquity("AZN.ST", "AstraZeneca");
		indices.put("Favourites", fav);
	}
}
