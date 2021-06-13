package InfinityObstacle;
import java.util.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.*;
import java.lang.*;

import movable.Movable;

public class infinityObstacle extends Application implements Serializable{

	public Scene scene;
	public infinityObstacleController inf;
	public infinityObstacle()
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
	        loader.setLocation(getClass().getResource("infinityObstacle.fxml"));
	        try {
				loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        Map<String,Object> fxmlnamespace = loader.getNamespace();
	        this.inf  = new  infinityObstacleController();
	        this.inf.fxmlNamespace2=fxmlnamespace;
	        
	        this.inf.setShape1(null);
	        this.inf.setShape2(null);
//	        scene = new Scene(root);       
//   	    stage.setScene(scene);
//  	    stage.show();
//				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
