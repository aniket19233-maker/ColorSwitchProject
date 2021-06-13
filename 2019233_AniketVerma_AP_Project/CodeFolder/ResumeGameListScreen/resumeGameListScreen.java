package ResumeGameListScreen;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Map;

import Game.game;
import GameScreen.gameScreen;
import GameScreen.gameScreenController;
import ListScreenHandler.listScreenHandler;
import Player.player;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class resumeGameListScreen extends Application implements Serializable {
	
	private gameScreenController gsc;
	
	private listScreenHandler<game> GameList;
	
	private player currentPlayer;
	
	private game currentGame;
	
	public listScreenHandler<game> getGameList()
	{
		return this.GameList;
	}
	
	public player getCurrentPlayer()
	{
		return this.currentPlayer;
	}
	
	public void setCurrentPlayer(player p)
	{
		this.currentPlayer = p;
	}
	
	public game getCurrentGame()
	{
		return this.currentGame;
	}
	
	public void setCurrentGame(game g)
	{
		this.currentGame = g;
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
	        loader.setLocation(getClass().getResource("resumeGameListScreen.fxml"));
	        Parent root = loader.load();
	        
	        Map<String,Object> fxmlNamespace = loader.getNamespace();
	        ChoiceBox dropBox = (ChoiceBox)fxmlNamespace.get("dropBox");
	        ObservableList<String> list = dropBox.getItems();
	        int i=0;
	        try
	        {
	        	System.out.println(currentPlayer.getID());
	        	FileInputStream fileIn = new FileInputStream("Game"+currentPlayer.getID()+".txt");
	            ObjectInputStream in = new ObjectInputStream(fileIn);
	            gsc = (gameScreenController)in.readObject();
	            if(gsc!=null)
	            {
	            	list.add("Game"+currentPlayer.getID()+".txt");
	            }
	            else
	            {
	            	
	            }
	            in.close();
	            fileIn.close();
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	        Button b = (Button)fxmlNamespace.get("play");
	        b.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
	        	
	        	@Override
	        	public void handle(MouseEvent t)
	        	{
	        		gameScreen g = new gameScreen();
	        		g.currPlayer = currentPlayer;
	        		try {
						g.start2(new Stage());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        		stage.close();
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
