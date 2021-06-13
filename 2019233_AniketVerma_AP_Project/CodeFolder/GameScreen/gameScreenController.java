package GameScreen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import Ball.ball;
import Player.player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class gameScreenController implements Serializable{
	
	public player CurrentPlayer;
	
	public double labx,laby;
	
	public double OYarcx,OYarcy,OParcx,OParcy,OPUarcx,OPUarcy,OSBarcx,OSBarcy,OYarc1x,OYarc1y,
	OParc1x,OParc1y,OPUarc1x,OPUarc1y,OSBarc1x,OSBarc1y;
	
	public int collectedStars;
	
	public double ballx, bally,stx,sty;
	
	public double Cs1[][] = new double[4][2],
			Is1[][] = new double[4][2],Is2[][] = new double[4][2],Ms1[][] = new double[4][2],Ms2[][] = new double[4][2];
	
	public void serialize(Arc OYarc,Arc OParc,Arc OPUarc,
			Arc OSBarc,Arc OYarc1,Arc OParc1,Arc OPUarc1,Arc OSBarc1,
			int collectedStars,ball Ball,Shape []cs1,Shape []ms1,
			Shape ms2[],Shape is1[],Shape is2[],Polygon p,player play) throws IOException
	{
		 this.ballx = Ball.BC.ball.getLayoutX();
		 this.bally = Ball.BC.ball.getLayoutY();
		 
		 this.stx = p.getLayoutX();
		 this.sty = p.getLayoutY();
		 
		 this.OYarc1x = OYarc1.getLayoutX();
		 this.OYarc1y = OYarc1.getLayoutY();
		 this.OParc1x = OParc1.getLayoutX();
		 this.OParc1y = OParc1.getLayoutY();
		 this.OPUarc1x = OPUarc1.getLayoutX();
		 this.OPUarc1y = OPUarc1.getLayoutY();
		 this.OSBarc1x = OSBarc1.getLayoutX();
		 this.OSBarc1y = OSBarc1.getLayoutY();
		 
		 this.OYarcx = OYarc.getLayoutX();
		 this.OYarcy = OYarc.getLayoutY();
		 this.OParcx = OParc.getLayoutX();
		 this.OParcy = OParc.getLayoutY();
		 this.OPUarcx = OPUarc.getLayoutX();
		 this.OPUarcy = OPUarc.getLayoutY();
		 this.OSBarcx = OSBarc.getLayoutX();
		 this.OSBarcy = OSBarc.getLayoutY();
		 
		 for(int i=0;i<4;i++)
		 {
			 this.Cs1[i][0] = cs1[i].getLayoutX();
			 this.Cs1[i][1] = cs1[i].getLayoutY();
			 this.Is1[i][0] = is1[i].getLayoutX();
			 this.Is1[i][1] = is1[i].getLayoutY();
			 this.Is2[i][0] = is2[i].getLayoutX();
			 this.Is2[i][1] = is2[i].getLayoutY();
			 this.Ms1[i][0] = ms1[i].getLayoutX();
			 this.Ms1[i][1] = ms1[i].getLayoutY();
		 }
		 for(int i=0;i<2;i++)
		 {
			 this.Ms2[i][0] = ms2[i].getLayoutX();
			 this.Ms2[i][1] = ms2[i].getLayoutY();
		 }
		 
		 this.collectedStars = collectedStars;
		 
		 this.CurrentPlayer = play;
		 
		 	try {
		 		System.out.println("play "+play);
		 		System.out.println("jhooooo "+this.CurrentPlayer);
		 	FileOutputStream fileOut = new FileOutputStream("Game"+this.CurrentPlayer.getID()+".txt");
		    ObjectOutputStream out = new ObjectOutputStream(fileOut);
		    out.writeObject(this);
		    out.close();
		    fileOut.close();
		 	}catch(Exception e)
		 	{
		 		e.printStackTrace();
		 	}
		 
	}
	
	public void deserialize(Arc OYarc,Arc OParc,Arc OPUarc,
			Arc OSBarc,Arc OYarc1,Arc OParc1,Arc OPUarc1,Arc OSBarc1,
			int collectedStars,ball Ball,Shape []cs1,Shape []ms1,
			Shape ms2[],Shape is1[],Shape is2[],Polygon p,player play) throws IOException
	{
		
		FileInputStream file = new FileInputStream("Game"+CurrentPlayer.getID()+".txt"); 
        ObjectInputStream in = new ObjectInputStream(file); 
          
        gameScreenController g;
		try {
			g = (gameScreenController)in.readObject();
			Ball.BC.ball.setLayoutX(g.ballx);
	        Ball.BC.ball.setLayoutY(g.bally);
	        
	        p.setLayoutX(g.stx);
	        p.setLayoutY(g.sty);
	        
	        
	        OYarc1.setLayoutX(g.OYarc1x);
	        OYarc1.setLayoutY(g.OYarc1y);
	        OParc1.setLayoutX(g.OParc1x);
	        OParc1.setLayoutY(g.OParc1y);
	        OPUarc1.setLayoutX(g.OPUarc1x);
	        OPUarc1.setLayoutY(g.OPUarc1y);  
	        OSBarc1.setLayoutX(g.OSBarc1x);
	        OSBarc1.setLayoutY(g.OSBarc1y);        
	        
	        
	        OYarc.setLayoutX(g.OYarcx);
	        OYarc.setLayoutY(g.OYarcy);
	        OParc.setLayoutX(g.OParcx);
	        OParc.setLayoutY(g.OParcy);        
	        OPUarc.setLayoutX(g.OPUarcx);
	        OPUarc.setLayoutY(g.OPUarcy);
	        OSBarc.setLayoutX(g.OSBarcx);
	        OSBarc.setLayoutY(g.OSBarcy); 
	        
	        for(int i=0;i<4;i++)
	        {
	        	cs1[i].setLayoutX(g.Cs1[i][0]);
	        	cs1[i].setLayoutY(g.Cs1[i][1]);
	        	is1[i].setLayoutX(g.Is1[i][0]);
	        	is1[i].setLayoutY(g.Is1[i][1]);
	        	is2[i].setLayoutX(g.Is2[i][0]);
	        	is2[i].setLayoutY(g.Is2[i][1]);
	        	ms1[i].setLayoutX(g.Ms1[i][0]);
	        	ms1[i].setLayoutY(g.Ms1[i][1]);
	        }
	        
	        for(int i=0;i<2;i++)
	        {
	        	ms2[i].setLayoutX(g.Ms2[i][0]);
	        	ms2[i].setLayoutY(g.Ms2[i][1]);
	        }
	        
	        collectedStars = this.collectedStars;
	        in.close(); 
	        file.close(); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
