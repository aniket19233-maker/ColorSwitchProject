package HomePageScreen;

import java.io.Serializable;
import java.util.Map;

import Player.player;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class homePageScreen extends Application implements Serializable{

	public int score=0;
	public player CurrentPlayer;
	
	public homePageScreenController hpsc;
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		try { 
			System.out.println("i main "+CurrentPlayer);
			hpsc = new homePageScreenController();
			hpsc.hps = this;
			hpsc.currentPlayer = CurrentPlayer; 
			System.out.println(hpsc.currentPlayer);
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("homePageScreen.fxml"));
	        Parent root = loader.load();
	        
	        Map<String ,Object> fxmlNamespace = loader.getNamespace();
	        Button b =(Button)fxmlNamespace.get("inf");
	        Label l = (Label)fxmlNamespace.get("hs");
	        System.out.println(l);
	        l.setText("BEST SCORE : "+score);
	        hpsc.highScore = CurrentPlayer.highScore;
	        b.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
	        	
	        	@Override
	        	public void handle(MouseEvent t)
	        	{
	        		stage.close();
	        		hpsc.SelectGame();
	        	}
			});
	        Button a = (Button)fxmlNamespace.get("play");
	        a.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
	        	
	        	@Override
	        	public void handle(MouseEvent t)
	        	{
	        		stage.close();
	        		System.out.println("hello");
	        		System.out.println("playgame "+hpsc.currentPlayer);
	        		hpsc.playGame(CurrentPlayer);
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
