package TriangularObstacle;

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

public class triangularObstacleController extends Obstacle implements Serializable,Movable{
	
	@FXML
	private Shape line1,line2,line3;
	
	private Shape line;
	
	private double PositionX;
	
	private double PositionY;
	
	private double speed;
	
	public void setSpeed(double speed )
	{
		this.speed = speed;
	}
	
	public void setShape(Shape circle)
	{
		this.line = new Line();
	}
	
	public Shape getShape()
	{
		return new Line();
	}
	
	public double[] getPosition()
	{
		return new double[] {this.PositionX,this.PositionY};
	}
	
	@FXML
	public void move()
	{
		revolveNode(line1,307,258);//307,258
		revolveNode(line2,319,318.5);//319,318.5
		revolveNode(line3,253,323);//253,323
	}
	
    private void revolveNode(Shape arc,double x,double y) {
		Circle c = new Circle(x,y,100);
		PathTransition t = new PathTransition();
		t.setNode(arc);
		t.setDuration(Duration.seconds(1));
		t.setPath(c);
		t.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		t.setCycleCount(Animation.INDEFINITE);
		t.play(); 
    }

}
