package CircularObstacle;
import java.util.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.*;
import java.lang.*;

public class circularObstacle extends Application implements Serializable{

	
	public Scene scene;
	
	public circularObstacleController cobc;
	
	public circularObstacle()
	{
		try {
			this.start(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("circularObstacle.fxml"));
	        Parent root = loader.load();
	        Map<String,Object> fxmlnamespace = loader.getNamespace();
	        this.cobc = new circularObstacleController();
	        this.cobc.fxmlNamespace2 = fxmlnamespace;
	        this.cobc.setShape(null);
//	        Scene scene = new Scene(root);
//	        stage.setScene(scene);
//	        stage.show();
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
