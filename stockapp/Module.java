package stockapp;

import javafx.scene.Parent;

public interface Module {	
	public String getName();
	public String getAuthor();
	public String getPath();
	public boolean isInternal();
	
	public Parent getRoot();
	
	public void refresh();
}
