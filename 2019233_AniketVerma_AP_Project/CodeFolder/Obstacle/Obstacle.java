package Obstacle;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class Obstacle {
	private static transient int id = 0;
	private final int OBSTACLEID = id+1;
	public static transient ArrayList<Color> listofDistinctColor = new ArrayList<Color>(Arrays.asList(Color.PINK, Color.SKYBLUE, Color.YELLOW,Color.PURPLE));
	public boolean allowBall(Circle ball)
	{
		return false;
	}
}
