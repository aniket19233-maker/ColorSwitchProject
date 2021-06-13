package Ball;
import java.lang.*;
import java.io.*;
import java.util.*;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
import movable.*;
import java.net.URL;
import java.sql.Time;
public class BallController implements Serializable,Movable{
	
	@FXML
	public AnchorPane acp;
	
//	public Scene scene = acp.getScene();
	
	@FXML
	public Circle ball;
	
	private Shape Ball = ball;	
	
	private double radius; 
	
	private String color; //ball.getFill().toString(); 
	
	private double PositionX ;// ball.getCenterX();
	
	private double PositionY ; //ball.getCenterY();
	
	private static double speed = 0.0;
	
	public void changePosition(double PositionX,double PositionY)
	{
		this.PositionX = PositionX;
		this.PositionY = PositionY;
	}
	
	@FXML
	public void move()
	{
		if(speed==0.0) {
		double deltay = 10.0;
		ball.setCenterX(300);
		ball.setCenterY(0);
		Line line = new Line(ball.getCenterX(),ball.getCenterY(),ball.getCenterX(),ball.getCenterY()-deltay);
		PathTransition trans = new PathTransition();
		trans.setNode(ball);
		trans.setDuration(Duration.seconds(1));
		trans.setPath(line);
		trans.setCycleCount(1);
		trans.play();
		speed++;
		double x = ball.getCenterX();
		double y = ball.getCenterY();
		ball.setCenterX(300);
		ball.setCenterY(0);
		line.setStartX(x);
		line.setStartY(y-deltay);
		line.setEndX(x);
		line.setEndY(y+speed*deltay);
//		trans.setDuration(Duration.seconds(1));
//		trans.setPath(line);
//		trans.setCycleCount(1);
		trans.play();
		ball.setLayoutY(200);
		}
		else {
			double deltay = 50.0;
			Line line = new Line(ball.getCenterX(),ball.getCenterY(),ball.getCenterX(),ball.getCenterY()+deltay);
			PathTransition trans = new PathTransition();
			trans.setNode(ball);
			trans.setDuration(Duration.seconds(1));
			trans.setPath(line);
			trans.setCycleCount(1);
			trans.play();
			speed++;
			ball.setLayoutY(200);
		}
	}
	
	public void changeColor(String color)
	{
		if(color.equals("pink"))
		{
			this.ball.setFill(Color.PINK);
			this.color = ball.getFill().toString();
		}
		else if(color.equals("yellow"))
		{
			this.ball.setFill(Color.YELLOW);
			this.color = ball.getFill().toString();
		}
		else if(color.equals("purple"))
		{
			this.ball.setFill(Color.PURPLE);
			this.color = ball.getFill().toString();
		}
		else if(color.equals("skyblue"))
		{
			this.ball.setFill(Color.SKYBLUE);
			this.color = ball.getFill().toString();
		}
	}
	
	public Circle getBall()
	{
		return this.ball;
	}
	
	public void setBall(Shape ball)
	{
		this.ball = (Circle) ball;
		this.radius = ((Circle) ball).getRadius();
		this.color = ((Circle) ball).getFill().toString();
		this.PositionX =  ((Circle) ball).getCenterX();
		this.PositionY =  ((Circle) ball).getCenterY();
		Circle c=this.getBall();
        c.setCenterX(c.getCenterX()+300);
	}
	
	public double[] getPosition()
	{
		return new double[]{this.PositionX,this.PositionY};
	}

}
