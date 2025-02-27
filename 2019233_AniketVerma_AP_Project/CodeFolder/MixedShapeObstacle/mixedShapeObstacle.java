package MixedShapeObstacle;
import java.util.*;

import InfinityObstacle.infinityObstacleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.*;
import java.lang.*;

import movable.Movable;
import java.io.*;
import java.util.*;

public class mixedShapeObstacle extends Application implements Serializable{

	public Scene scene;
	
	public mixedShapeController msc; 
	
	public mixedShapeObstacle()
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
	        loader.setLocation(getClass().getResource("mixedShapeObstacle.fxml"));
	        loader.load();

	        Map<String,Object> fxmlnamespace = loader.getNamespace();
	        this.msc = new mixedShapeController();
	        this.msc.fxmlNamespace2 = fxmlnamespace;
	        this.msc.setShape1(null);
	        this.msc.setShape2(null);
//	        Scene scene = new Scene(root);
//	        stage.setScene(scene);
//	        stage.show();
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
