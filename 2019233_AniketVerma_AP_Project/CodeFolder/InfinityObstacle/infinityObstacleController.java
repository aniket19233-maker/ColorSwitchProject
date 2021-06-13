package InfinityObstacle;
import java.lang.*;
import java.io.*;
import java.util.*;

import Ball.ball;
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
import InfinityObstacle.infinityObstacle;

public class infinityObstacleController extends Obstacle implements Serializable,Movable{
	
	public Map<String, Object> fxmlNamespace2;
	
	public Timeline animation;
	@FXML 
	private Arc OYarc,OParc,OPUarc,OSBarc,OYarc1,OParc1,OPUarc1,OSBarc1;
	
	private Shape circle1,circle2;
	
	private double PositionX1,PositionX2;
	
	private double PositionY1,PositionY2;
	
	private double speed1,speed2;
	
	public infinityObstacleController() {
		// TODO Auto-generated constructor stub
	}

	public void setSpeed1(double speed )
	{
		this.speed1 = speed;
	}
	
	public void setSpeed2(double speed )
	{
		this.speed1 = speed;
	}
	public void setShape1(Shape circle)
	{
		this.OYarc1 = (Arc)fxmlNamespace2.get("OYarc1");
        this.OParc1 = (Arc)fxmlNamespace2.get("OParc1");
        this.OPUarc1 = (Arc)fxmlNamespace2.get("OPUarc1");
        this.OSBarc1 = (Arc)fxmlNamespace2.get("OSBarc1");
		this.circle1 = circle;
	}
	public void setShape2(Shape circle)
	{
		this.OYarc = (Arc)fxmlNamespace2.get("OYarc");
		this.OParc = (Arc)fxmlNamespace2.get("OParc");
		this.OPUarc = (Arc)fxmlNamespace2.get("OPUarc");
        this.OSBarc = (Arc)fxmlNamespace2.get("OSBarc");
		this.circle2 = circle;
	}
	public Shape[] getShape1()
	{
		return new Shape[] {this.OYarc1,this.OParc1,this.OPUarc1,this.OSBarc1};
	}
	public Shape[] getShape2()
	{
		return new Shape[] {this.OYarc,this.OParc,this.OPUarc,this.OSBarc};
	}
	public double[] getPosition1()
	{
		return new double[] {this.PositionX1,this.PositionY1};
	}
	public double[] getPosition2()
	{
		return new double[] {this.PositionX2,this.PositionY2};
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
	}
	
    public void revolveNode(Arc arc,boolean CorA) {
    	if(CorA) {
        animation = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(arc.startAngleProperty(), arc.getStartAngle(), Interpolator.LINEAR)),
            new KeyFrame(Duration.seconds(5), new KeyValue(arc.startAngleProperty(), arc.getStartAngle() - 360, Interpolator.LINEAR))
        );
        animation.setCycleCount(1000);
        animation.play();
    	}
    	else
    	{
    		animation = new Timeline(
    	            new KeyFrame(Duration.ZERO, new KeyValue(arc.startAngleProperty(), arc.getStartAngle(), Interpolator.LINEAR)),
    	            new KeyFrame(Duration.seconds(5), new KeyValue(arc.startAngleProperty(), arc.getStartAngle() + 360, Interpolator.LINEAR))
    	        );
    	        animation.setCycleCount(1000);
    	        animation.play();
    	}
    }
    
    public void pushNodeDown(Arc arc)
    {
    	arc.setLayoutY(arc.getLayoutY()+50);
    }
}
