package AccountManagementMenuScreen;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.plaf.basic.BasicListUI.ListSelectionHandler;

import AccountSelectionListScreen.accountSelectionListScreen;
import ListScreenHandler.listScreenHandler;
import Player.player;
import UserButton.userButton;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;
import javafx.util.Duration;

public class accountManagementMenuScreenController implements Serializable{
	
	ObservableMap<String, Object> fxmlnamespace;
	
	@FXML
	private Arc OYarc,OParc,OPUarc,OSBarc;
	
	private userButton NewAccountButton;

	private userButton ExistingAccountButton;
	
	private userButton FastPlayModeButton;
	
	private player Player;
	
	public player getPlayer()
	{
		return this.Player;
	}
	
	public void setPlayer(player p)
	{
		this.Player = p;
	}
	
	@FXML
	public void move()
	{
		this.OYarc = (Arc)fxmlnamespace.get("OYarc");
		this.OParc = (Arc)fxmlnamespace.get("OParc");
		this.OPUarc = (Arc)fxmlnamespace.get("OPUarc");
        this.OSBarc = (Arc)fxmlnamespace.get("OSBarc");
		revolveNode(OYarc,true);
		revolveNode(OParc,true);
		revolveNode(OPUarc,true);
		revolveNode(OSBarc,true);
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
    
    public void serialize(listScreenHandler<player> st) throws IOException
    {
    	listScreenHandler<player> s=st;
    	FileOutputStream fos = new FileOutputStream("savedGame.txt");
    	 ObjectOutputStream oos = new ObjectOutputStream(fos);
    	 oos.writeObject(s);
    	 oos.close();
    }
    
    
}
