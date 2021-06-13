package PauseGameScreen;

import java.io.Serializable;
import java.util.Map;

import Game.game;
import GameScreen.gameScreenController;
import HomePageScreen.homePageScreen;
import UserButton.userButton;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class pauseGameScreen extends Application implements Serializable{
	public homePageScreen hps;
	public int highScore = 0;
	public gameScreenController gsc;
	
	public pauseGameScreenController pgcs = new pauseGameScreenController();
	
	public Stage stage = new Stage();
	
	public Stage gameStage;
	
	public userButton QuitButton;
	
	public userButton ContinueButton;
	
	private game CurrentGame;
	
	public game getCurrentGame()
	{
		return this.CurrentGame;
		
	}
	public void setCurrentGame(game g)
	{
		this.CurrentGame = g;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		try {
			stage.setX(50);
			stage.setY(50);
			stage.setWidth(600);
			stage.setHeight(600);
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("pauseGameScreen.fxml"));
	        Parent root = loader.load();
	        Map<String, Object> fxmlNamespace2 = loader.getNamespace();
	        Button b =(Button)fxmlNamespace2.get("Cont");
	        Button a =(Button)fxmlNamespace2.get("qtmm");
	        b.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
	        	
	        	@Override
	        	public void handle(MouseEvent t)
	        	{
	        		pgcs.Continue(stage);
	        	}
			});
	        a.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
	        	
	        	@Override
	        	public void handle(MouseEvent t)
	        	{
	        		hps.CurrentPlayer.highScore = highScore;
	        		hps.score=highScore;
	        		try {
						hps.start(new Stage());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        		pgcs.Continue(gameStage);
	        		pgcs.Continue(stage);
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
