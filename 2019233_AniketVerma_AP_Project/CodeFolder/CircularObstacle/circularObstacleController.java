package CircularObstacle;
import java.lang.*;
import java.io.*;
import java.util.*;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import movable.*;
import java.net.URL;
import java.sql.Time;
import Obstacle.Obstacle;
import Obstacle.Obstacle.*;

public class circularObstacleController extends Obstacle implements Serializable,Movable{
	
	public Map<String, Object> fxmlNamespace2;
	
	@FXML
	public AnchorPane acp;
	
	@FXML
	private Circle OBcircle;
	
	@FXML 
	private Arc OYarc,OParc,OPUarc,OSBarc;
	
	private Shape circle;
	
	private double PositionX;
	
	private double PositionY;
	
	private double speed;
	
	public void setSpeed(double speed )
	{
		this.speed = speed;
		
	}
	
	public void setShape(Shape circle)
	{
		this.OYarc = (Arc)fxmlNamespace2.get("OYarc");
		this.OParc = (Arc)fxmlNamespace2.get("OParc");
		this.OPUarc = (Arc)fxmlNamespace2.get("OPUarc");
        this.OSBarc = (Arc)fxmlNamespace2.get("OSBarc");
		this.circle = circle;
	}
	
	public Shape[] getShape()
	{
		return new Shape[] {this.OYarc,this.OParc,this.OPUarc,this.OSBarc};
	}
	
	public double[] getPosition()
	{
		return new double[] {this.PositionX,this.PositionY};
	}
	
	@FXML
	public void move()
	{
		
		revolveNode(OYarc);
		revolveNode(OParc);
		revolveNode(OPUarc);
		revolveNode(OSBarc);
	}
	
	@FXML
    private void revolveNode(Arc arc) {
        Timeline animation = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(arc.startAngleProperty(), arc.getStartAngle(), Interpolator.LINEAR)),
            new KeyFrame(Duration.seconds(2.5), new KeyValue(arc.startAngleProperty(), arc.getStartAngle() + 360, Interpolator.LINEAR))
        );
        animation.setCycleCount(1000);
        animation.play();
    }

	public void pushNodeDown(Arc arc)
    {
    	arc.setLayoutY(arc.getLayoutY()+50);
    }
}

