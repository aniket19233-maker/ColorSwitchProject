package UserScreen;

import java.io.Serializable;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class userScreen extends Application implements Serializable{

	private String Name;
	
	private Scene screen;
	
	public String ShowMenuName() 
	{
		return this.Name;
	}
	
	public Scene getScreen()
	{
		return this.screen;
	}
	
	public void setName(String name)
	{
		this.Name = name;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
