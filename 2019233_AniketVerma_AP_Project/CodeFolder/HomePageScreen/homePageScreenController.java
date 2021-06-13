package HomePageScreen;

import javafx.scene.control.Button;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import GameScreen.gameScreen;
import HelpScreen.helpScreen;
import Player.player;
import ResumeGameListScreen.resumeGameListScreen;
import SettingScreen.settingScreen;
import SettingScreen.settingScreenController;
import UserButton.userButton;
import UserButton.userButtonController;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;
import javafx.util.Duration;


public class homePageScreenController implements Serializable{
	public homePageScreen hps;
	@FXML 
	private Arc OYarc,OParc,OPUarc,OSBarc,OYarc1,OParc1,OPUarc1,OSBarc1,OYarc2,OParc2,OPUarc2,OSBarc2;
	
	public userButton infintyModeButton;
	
	public userButton HelpButton;
	
	public userButton SettingsButton;
	
	public userButton ExitButton;
	
	public player currentPlayer;
	
	public int highScore;
	
	public player getCurrentPlayer()
	{
		return this.currentPlayer;
	}
	
	public void setCurrentPlayer()
	{
		this.currentPlayer = new player();
	}
	
	public void serialize() throws IOException
	{
		
	}
	
	public void deserialize() throws IOException,ClassNotFoundException
	{
		
	}
	
	@FXML
	public void move()
	{
		
		revolveNode(OYarc,true);
		revolveNode(OParc,true);
		revolveNode(OPUarc,true);
		revolveNode(OSBarc,true);
		revolveNode(OYarc1,false);
		revolveNode(OParc1,false);
		revolveNode(OPUarc1,false);
		revolveNode(OSBarc1,false);
		revolveNode(OYarc2,false);
		revolveNode(OParc2,false);
		revolveNode(OPUarc2,false);
		revolveNode(OSBarc2,false);
	}
	
    private void revolveNode(Arc arc,boolean CorA) {
    	if(CorA) {
        Timeline animation = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(arc.startAngleProperty(), arc.getStartAngle(), Interpolator.EASE_BOTH)),
            new KeyFrame(Duration.seconds(1), new KeyValue(arc.startAngleProperty(), arc.getStartAngle() - 360, Interpolator.EASE_BOTH))
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
    	}
    	else
    	{
    		Timeline animation = new Timeline(
    	            new KeyFrame(Duration.ZERO, new KeyValue(arc.startAngleProperty(), arc.getStartAngle(), Interpolator.EASE_BOTH)),
    	            new KeyFrame(Duration.seconds(1), new KeyValue(arc.startAngleProperty(), arc.getStartAngle() + 360, Interpolator.EASE_BOTH))
    	        );
    	        animation.setCycleCount(Animation.INDEFINITE);
    	        animation.play();
    	}
    }
    
    @FXML
    private void openSettingsScreen()
    {
    	Stage stage = new Stage();
    	stage.setX(50);
    	stage.setY(50);
    	stage.setWidth(600);
    	stage.setHeight(600);
    	settingScreen s = new settingScreen();
    	s.ssc = new settingScreenController();
    	s.stage = stage;
    	s.ssc.stage = stage;
    	try {
			s.start(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    @FXML
    private void openHelpScreen()
    {
    	Stage stage = new Stage();
    	stage.setX(50);
    	stage.setY(50);
    	stage.setWidth(600);
    	stage.setHeight(600);
    	helpScreen h = new helpScreen();
    	try {
			h.start(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void playGame(player p)
    {
    	this.currentPlayer=p;
    	gameScreen g = new gameScreen();
    	g.hps=hps;
    	highScore = p.highScore;
    	g.currPlayer = p;
    	System.out.println("playgame "+g.currPlayer);
    	try {
			g.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void SelectGame()
    {
    	resumeGameListScreen rs = new resumeGameListScreen();
    	System.out.println(currentPlayer);
    	rs.setCurrentPlayer(currentPlayer);
    	try {
			rs.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
