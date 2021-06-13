package HitBallScreen;

import java.io.Serializable;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class hitBallScreen extends Application implements Serializable{

	public Stage stage = new Stage();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setX(50);
		stage.setY(50);
		stage.setWidth(600);
		stage.setHeight(600);
		// TODO Auto-generated method stub
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("hitBallScreen.fxml"));
	        Parent root = loader.load();
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
