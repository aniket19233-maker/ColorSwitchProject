package Ball;
import java.lang.*;
import java.io.*;
import java.util.*;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import movable.*;
import Ball.BallController;


public class ball extends Application implements Serializable {
	
	public BallController BC = new BallController();
	
	public Scene scene;
	
	public ball()
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
	        loader.setLocation(getClass().getResource("Ball.fxml"));
			try {
				loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        Map<String, Object> fxmlNamespace = loader.getNamespace();
	        BC.setBall((Circle) fxmlNamespace.get("ball")); 
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
