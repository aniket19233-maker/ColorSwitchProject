package GameMenuScreen;

import java.io.Serializable;

import Game.game;
import Player.player;
import UserButton.userButton;

public class GameMenuScreenController implements Serializable{
	public userButton NewGameButton;
	
	public userButton ResumeGameButton;
	
	public userButton BackButton;
	
	private player currentPlayer;
	
	private game currentGame;
	
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
