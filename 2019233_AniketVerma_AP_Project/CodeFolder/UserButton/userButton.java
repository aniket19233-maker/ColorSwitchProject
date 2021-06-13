package UserButton;
import java.io.*;
import java.util.*;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import movable.*;
import java.net.URL;
import java.sql.Time;

public class userButton {
	private Button userButton;
	private boolean isShowing = false;
	public userButton()
	{
		this.userButton = new Button();
		this.setButton(this.userButton);
	}
	public Button getButton()
	{
		return this.userButton;
	}
	public void setButton(Button btn)
	{
		this.userButton = btn;
	}
	public boolean getIsShowing()
	{
		return this.isShowing;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
