package ResumeGameListScreen;

import java.io.Serializable;
import Game.game;
import ListScreenHandler.listScreenHandler;
import Player.player;

public class resumeGameListScreenController implements Serializable{
	
	private listScreenHandler<game> GameList;
	
	private player currentPlayer;
	
	private game currentGame;
	
	public void getGameList()
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
}
