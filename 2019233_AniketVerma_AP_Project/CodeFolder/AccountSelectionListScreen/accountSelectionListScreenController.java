package AccountSelectionListScreen;

import java.io.Serializable;

import Game.game;
import ListScreenHandler.listScreenHandler;
import Player.player;
import javafx.stage.Stage;

public class accountSelectionListScreenController implements Serializable{
	
	private static listScreenHandler<player> PlayerList;
	
	private player currentPlayer;
	
	private game currentGame;
	
	public void getAccountlist()
	{
		
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
	
	public void goBack(Stage stopen,Stage stClose)
	{
		stopen.show();
		stClose.close();
	}
}
