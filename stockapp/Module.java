/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockapp;

import javafx.scene.Parent;

/**
 *
 * @author Patryk
 */
public interface Module {
	public Response request(Request r);
	
	public String getName();
	public String getAuthor();
	public String getPath();
	
	public Parent getRoot();
}
