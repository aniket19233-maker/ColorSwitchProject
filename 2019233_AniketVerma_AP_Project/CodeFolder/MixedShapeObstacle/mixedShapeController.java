package MixedShapeObstacle;
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
import javafx.animation.TranslateTransition;
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

public class mixedShapeController extends Obstacle implements Serializable,Movable{
	
	public Map<String, Object> fxmlNamespace2;
	
	@FXML 
	private Arc OYarc1,OParc1,OPUarc1,OSBarc1;
	
	@FXML
	private Line line1,line3;
	private Shape triangle,circle;
	
	private double PositionX1,PositionX2;
	
	private double PositionY1,PositionY2;
	
	private double speed1,speed2;
	
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
		this.circle = circle;
	}
	public void setShape2(Shape circle)
	{
		this.line1 = (Line)fxmlNamespace2.get("line1");
		this.line3 = (Line)fxmlNamespace2.get("line3");
		this.circle = circle;
	}
	public Shape[] getShape1()
	{
		return new Shape[] {this.OYarc1,this.OParc1,this.OPUarc1,this.OSBarc1};
	}
	public Shape[] getShape2()
	{
		return new Shape[] {this.line1,this.line3};
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
		moveLine(line1);
		moveLine(line3);
		revolveCircle(OYarc1,true);
		revolveCircle(OParc1,true);//true for clockwise;
		revolveCircle(OPUarc1,true);
		revolveCircle(OSBarc1,true);
	}
	
    private void revolveCircle(Arc arc,boolean CorA) {
    	if(CorA) {
        Timeline animation = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(arc.startAngleProperty(), arc.getStartAngle(), Interpolator.LINEAR)),
            new KeyFrame(Duration.seconds(5), new KeyValue(arc.startAngleProperty(), arc.getStartAngle() + 360, Interpolator.LINEAR))
        );
        animation.setCycleCount(1000);
        animation.play();
    	}
    }
    
    private void moveLine(Line line)
    {
    	TranslateTransition translate = new TranslateTransition();   
    	if(line.getId().equals("line1"))
    		translate.setByX(-300);  
    	else
    		translate.setByX(300);
        translate.setDuration(Duration.millis(1000));  
        translate.setCycleCount(500);    
        translate.setAutoReverse(true);   
        translate.setNode(line);  
        translate.play();  
    }
	
    public void pushDownArc(Arc arc)
    {
    	arc.setLayoutY(arc.getLayoutY()+60);
    }
    
    public void pushDownLine(Line line)
    {
    	line.setLayoutY(line.getLayoutY()+60);
    }
}
