package ColorSwitchCircle;
import java.lang.*;
import java.io.*;
import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Shape;

public class colorSwitchCircleController implements Serializable{
	public Map<String,Object> fxmlNamespace2;
	@FXML
	private Arc arc1,arc2,arc3,arc4;
	
	private Shape circle;
	
	private double PositionX;
	
	private double PositionY;
	
	public static transient ArrayList<Color> COLORLIST = new ArrayList<Color>(Arrays.asList(Color.PINK, Color.SKYBLUE, Color.YELLOW,Color.PURPLE));
	
	public void setShape(Shape circle)
	{
		this.arc1 = (Arc)fxmlNamespace2.get("arc1");
		this.arc2 = (Arc)fxmlNamespace2.get("arc2");
		this.arc3 = (Arc)fxmlNamespace2.get("arc3");
        this.arc4 = (Arc)fxmlNamespace2.get("arc4");
		this.circle = circle;
	}
	
	public Shape[] getShape()
	{
		return new Shape[] {this.arc1,this.arc2,this.arc3,this.arc4};
	}
	
	public Color getColorForBall()
	{
		Random rand = new Random();
		return COLORLIST.get(rand.nextInt(4));
	}
	
	public double[] getPosition()
	{
		return new double[] {this.PositionX,this.PositionY};
	}
	
	public void move()
	{
		((Arc)this.arc1).setLayoutY(((Arc)this.arc1).getLayoutY()+10);
		((Arc)this.arc2).setLayoutY(((Arc)this.arc2).getLayoutY()+10);
		((Arc)this.arc3).setLayoutY(((Arc)this.arc3).getLayoutY()+10);
		((Arc)this.arc4).setLayoutY(((Arc)this.arc4).getLayoutY()+10);
		
	}
}
