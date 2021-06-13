package Star;
import java.lang.*;
import java.io.*;
import java.util.*;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import movable.*;
import java.net.URL;
import java.sql.Time;

public class starController {
	
	public Map<String, Object> fxmlNamespace2;
	
	@FXML
	private Polygon star;
	private Shape STAR;
	private double positionX;
	private double positionY;
	
	public Shape getShape()
	{
		this.star = (Polygon)(this.fxmlNamespace2.get("star"));
		return (Polygon)this.star;
	}
	
	public double[] getPosition()
	{
		this.positionX = this.star.getLayoutX();
		this.positionY = this.star.getLayoutY(); 
		return new double[] {this.positionX,this.positionY};
	}
	
	public void move()
	{
		RotateTransition rt = new RotateTransition();
		rt.setAxis(Rotate.Z_AXIS);  
		rt.setByAngle(360);
		rt.setCycleCount(1000);
		rt.setDuration(Duration.millis(1000));
		rt.setNode(star);
		rt.play();
	}
	
	public void pushdown(Polygon star)
	{
		star.setLayoutY(star.getLayoutY()+10);
	}
}
