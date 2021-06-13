package Game;

import java.io.Serializable;
import java.util.ArrayList;

import Ball.ball;
import CircularObstacle.circularObstacle;
import ColorSwitchCircle.colorSwitchCircle;
import InfinityObstacle.infinityObstacle;
import MixedShapeObstacle.mixedShapeObstacle;
import Star.star;
import TriangularObstacle.triangularObstacle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class game implements Serializable{
	
	public Shape[] ms1,ms2,is1,is2,cs1,csc;
	
	public Polygon p;
	
	public triangularObstacle tob;
	
	public mixedShapeObstacle msob;
	
	public infinityObstacle ifo;
	
	public circularObstacle cob;
	
	public colorSwitchCircle csco;
	
	public star st;
	
	private static long serialVersionUID = 42L;
	
	private static transient int id = 0;
	
	private final int GAMEID = id + 1;
	
	private int obstacleToBeIndex = 0;
	
	private int gameInstanceHighScore;
	
	private ball Ball;
	
	private ArrayList<Object> listOfObstacles;
	
	private String[] listOfDistinctObstacleNames;
	
	private int numberOfAttempts=0;
	
	public boolean collisionChecker() 
	{
		return false;
	}
	
	public void incrementAttempts()
	{
		
	}
	
	public int getAttempts()
	{
		return this.numberOfAttempts;
	}
	public void setDefault()
	{
		
	}
	
	public int gameInstanceHighScore()
	{
		return this.gameInstanceHighScore;
	}
	
	public void randomItemGenerator()
	{
		
	}
	
	public ball getBall()
	{
		return this.Ball;
		
	}
	
	public game()
	{
		this.listOfDistinctObstacleNames = new String[]{"co","st","mso","to","csc","ifo"};
		this.listOfObstacles = new ArrayList<Object>();
		this.listOfObstacles.add(new circularObstacle());
		this.listOfObstacles.add(new star());
		this.listOfObstacles.add(new mixedShapeObstacle());
		this.listOfObstacles.add(new triangularObstacle());
		this.listOfObstacles.add(new colorSwitchCircle());
		this.listOfObstacles.add(new infinityObstacle());
		this.Ball = new ball();
		try {
			this.Ball.start(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		tob = (triangularObstacle) this.listOfObstacles.get(this.searchIndex("to"));
        
        msob = (mixedShapeObstacle) this.listOfObstacles.get(this.searchIndex("mso"));
        
        cob = (circularObstacle) this.listOfObstacles.get(this.searchIndex("co"));
        
        this.st = ((star)this.listOfObstacles.get(searchIndex("st")));
        
        this.csco = ((colorSwitchCircle)this.listOfObstacles.get(searchIndex("csc")));
        
        this.ms1 = msob.msc.getShape1();
        this.ms2 = msob.msc.getShape2();
        
        ifo = (infinityObstacle) this.listOfObstacles.get(this.searchIndex("ifo"));
        this.is1 = ifo.inf.getShape1();
        this.is2 = ifo.inf.getShape2();
        
        this.cs1 = cob.cobc.getShape();
        
        this.csc = csco.cscc.getShape();
        
        for(int i=0;i<4;i++)
        {
        	csc[i].setLayoutX(csc[i].getLayoutX()+310);
        	csc[i].setLayoutY(0);
        	csc[i].setVisible(false);
        }
        for(int i=0;i<4;i++)
        {
        	is1[i].setLayoutX(is1[i].getLayoutX()+310);
        	is2[i].setLayoutX(is2[i].getLayoutX()+340);
        }
        
        for(int i=0;i<4;i++)
        {
        	ms1[i].setLayoutX(ms1[i].getLayoutX()+310);
        	ms1[i].setLayoutY(0);
        	ms1[i].setVisible(false);
        }
        
        for(int i=0;i<2;i++)
        {
        	ms2[i].setLayoutX(ms2[i].getLayoutX()+310);
        	ms2[i].setLayoutY(0);
        	ms2[i].setVisible(false);
        }
        
        for(int i=0;i<4;i++)
        {
        	cs1[i].setLayoutX(cs1[i].getLayoutX()+325);
        	cs1[i].setLayoutY(0);
        	cs1[i].setVisible(false);
        }
        
//        try {
//			((star)this.listOfObstacles.get(searchIndex("st"))).start(null);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
        this.p = (Polygon) ((star) this.listOfObstacles.get(searchIndex("st"))).sc.getShape();
        p.setLayoutX(p.getLayoutX()+300);
    	p.setLayoutY(0);
    	p.setVisible(false);
        
	}
	
	private int searchIndex(String str){
		for(int i=0;i<this.listOfDistinctObstacleNames.length;i++)
		{
			if(this.listOfDistinctObstacleNames[i].equals(str))
			{
				return i;
			}
		}
		return -1;
	}

}
