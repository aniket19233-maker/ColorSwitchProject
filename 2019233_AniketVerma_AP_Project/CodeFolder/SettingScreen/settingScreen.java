package SettingScreen;

import java.io.Serializable;
import java.util.Map;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class settingScreen extends Application implements Serializable{

	public Stage stage;
	
	public settingScreenController ssc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("settingScreen.fxml"));
	        Parent root = loader.load();
	        Map<String, Object> nsp = loader.getNamespace();
	        Button b =(Button)nsp.get("back");
	        b.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					ssc.closeWindow();
					
				}
			});
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
