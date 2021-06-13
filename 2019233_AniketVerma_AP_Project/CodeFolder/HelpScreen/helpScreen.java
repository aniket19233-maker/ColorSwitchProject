package HelpScreen;

import java.io.Serializable;
import java.util.Map;

import UserButton.userButton;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class helpScreen extends Application implements Serializable{

	public Stage stage;
	
	public userButton BackButton;
	
	public void showHelpMessage()
	{
		System.out.println("HELP HELP HELP!!!!!");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		this.stage = stage;
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("helpScreen.fxml"));
	        Parent root = loader.load();
	        Map<String, Object> nsp = loader.getNamespace();
	        Button b =(Button)nsp.get("back");
	        b.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					closeWindow();
					
				}
			});
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void closeWindow()
	{
		this.stage.close();
	}

}
