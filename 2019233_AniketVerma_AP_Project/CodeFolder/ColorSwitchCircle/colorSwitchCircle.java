package ColorSwitchCircle;
import java.util.*;

import CircularObstacle.circularObstacleController;
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

public class colorSwitchCircle extends Application implements Serializable{

	public Scene scene;
	
	public colorSwitchCircleController cscc;
	
	public  colorSwitchCircle()
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
	        loader.setLocation(getClass().getResource("colorSwitchCircle.fxml"));
	        Parent root = loader.load();
	        Map<String,Object> fxmlnamespace = loader.getNamespace();
	        cscc = new colorSwitchCircleController();
	        this.cscc.fxmlNamespace2 = fxmlnamespace;
	        this.cscc.setShape(null);
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
