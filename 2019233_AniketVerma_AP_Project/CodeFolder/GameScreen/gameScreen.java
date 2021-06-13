package GameScreen;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Map;
import java.util.Random;

import Game.game;
import HitBallScreen.hitBallScreen;
import HomePageScreen.homePageScreen;
import UserButton.userButton;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.*;
import CircularObstacle.circularObstacle;
import CircularObstacle.circularObstacleController;
import Ball.ball;
import Ball.BallController;
import InfinityObstacle.infinityObstacle;
import InfinityObstacle.infinityObstacleController;
import MixedShapeObstacle.mixedShapeObstacle;
import PauseGameScreen.pauseGameScreen;
import Player.player;
import TriangularObstacle.triangularObstacle;

public class gameScreen extends Application implements Serializable{
	
	public homePageScreen hps;
	
	public player currPlayer;
	
	private gameScreenController gsc = new gameScreenController();
	
	private Label lab;
	
	private hitBallScreen hbs = new hitBallScreen();
	
	private pauseGameScreen pgs = new pauseGameScreen();
	
	@FXML
	private Arc OYarc,OParc,OPUarc,OSBarc,OYarc1,OParc1,OPUarc1,OSBarc1;
	
	@FXML 
	private AnchorPane acp;
	
	private int CollectedStars;
	
	public int highScore;
	
	private game CurrentGame;
	
	public userButton PauseButton;
	
	public int getCollectedStars()
	{
		return this.CollectedStars;
	}
	
	public game getCurrentGame()
	{
		return this.CurrentGame;
	}
	
	public void setCurrentGame(game g)
	{
		this.CurrentGame = g;
	}
	
	public void setGameInstanceHighScore()
	{
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public Random rand = new Random();
	
	@Override
	public void start(Stage stage) throws Exception {
		try {
			
			this.CollectedStars=0;
			this.CurrentGame = new game();
			ball b = this.CurrentGame.getBall();
			
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("gameScreen.fxml"));
	        Parent root = loader.load();
	        
	        Map<String, Object> fxmlNamespace2 = loader.getNamespace();
	        AnchorPane pane = (AnchorPane)fxmlNamespace2.get("acp");
	        
	        lab = (Label)fxmlNamespace2.get("score");
	        
	        Button pause = (Button)fxmlNamespace2.get("pause");
	        
	        Circle circle[] = new Circle[9];
			for(int j=1;j<=8;j++)
			{
				circle[j]=(Circle)fxmlNamespace2.get("b"+String.valueOf(j));
			}
			
			this.allowBall(pane,b,circle);
	        
	        this.OYarc1 = (Arc)fxmlNamespace2.get("OYarc1");
	        this.OYarc = (Arc)fxmlNamespace2.get("OYarc");
	        this.OParc1 = (Arc)fxmlNamespace2.get("OParc1");
	        this.OParc = (Arc)fxmlNamespace2.get("OParc");
	        this.OPUarc1 = (Arc)fxmlNamespace2.get("OPUarc1");
	        this.OPUarc = (Arc)fxmlNamespace2.get("OPUarc");
	        this.OSBarc1 = (Arc)fxmlNamespace2.get("OSBarc1");
	        this.OSBarc = (Arc)fxmlNamespace2.get("OSBarc");
	        
	        pane.getChildren().add(b.BC.ball);
	        
//	        b.BC.ball.setLayoutY(500);
	        for(int i=0;i<4;i++)
	        {
	        	pane.getChildren().add(CurrentGame.is1[i]);
	        	pane.getChildren().add(CurrentGame.is2[i]);
	        	pane.getChildren().add(CurrentGame.ms1[i]);
	        	pane.getChildren().add(CurrentGame.cs1[i]);
	        	pane.getChildren().add(CurrentGame.csc[i]);
	        }
	        
	        for(int i=0;i<2;i++)
	        {
	        	pane.getChildren().add(CurrentGame.ms2[i]);
	        }
	        
	        
	        pane.getChildren().add(CurrentGame.p);
	        
	        CurrentGame.p.setLayoutX(615);
	        CurrentGame.p.setLayoutY(-11);
	        
	        move();
	        
	        CurrentGame.ifo.inf.move();
	        
	        this.handleIOMovement(pane);
	        
	        this.handleMSOMovement(pane);
	        
	        this.handleCOMovement(pane);
	        
	        this.handleStarMovement(pane);
	        
	        this.handleColorSwitchCircleMovement(pane);
	        
	        this.setPauseButton(stage, pause);
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void Pathtrans(Circle c)
	{
		Line line = new Line();
		line.setStartX(c.getLayoutX());
		line.setStartY(c.getLayoutY());
		line.setEndX(rand.nextInt(500)+100.0);
		line.setEndY(rand.nextInt(200)-100.0);
		PathTransition path = new PathTransition();
		path.setNode(c);
		path.setPath(line);
		path.setDuration(Duration.millis(3000));
		path.setCycleCount(1);  
		path.play();
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
	
    private void revolveNode(Arc arc,boolean CorA) {
    	if(CorA) {
        Timeline animation = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(arc.startAngleProperty(), arc.getStartAngle(), Interpolator.EASE_BOTH)),
            new KeyFrame(Duration.seconds(1), new KeyValue(arc.startAngleProperty(), arc.getStartAngle() - 360, Interpolator.EASE_BOTH))
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
    	}
    	else
    	{
    		Timeline animation = new Timeline(
    	            new KeyFrame(Duration.ZERO, new KeyValue(arc.startAngleProperty(), arc.getStartAngle(), Interpolator.EASE_BOTH)),
    	            new KeyFrame(Duration.seconds(1), new KeyValue(arc.startAngleProperty(), arc.getStartAngle() + 360, Interpolator.EASE_BOTH))
    	        );
    	        animation.setCycleCount(Animation.INDEFINITE);
    	        animation.play();
    	}
    }
   
    public void handleMSOMovement(AnchorPane pane)
    {
    	pane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() 
        {
        	@Override
        	public void handle(MouseEvent t)
        	{
        		if(((Arc)CurrentGame.ms1[0]).isVisible())
        		{

	        		for(int i=0;i<4;i++)
	        		{
	        			CurrentGame.msob.msc.pushDownArc((Arc)CurrentGame.ms1[i]);
	        		}
	        		for(int i=0;i<2;i++)
	        		{
	        			CurrentGame.msob.msc.pushDownLine((Line)CurrentGame.ms2[i]);
	        		}
	        		for(int i=0;i<4;i++)
	        		{
	        			if(((Arc)CurrentGame.ms1[i]).getLayoutY()>=800)
	        			{
	        				for(int j=0;j<4;j++)
	        				{
	        					((Arc)CurrentGame.ms1[j]).setVisible(false);
	        				}
	        				for(int j=0;j<2;j++)
	        				{
	        					((Line)CurrentGame.ms2[j]).setVisible(false);
	        				}
	        				int x = rand.nextInt(3);
	        				System.out.println("x" +x);
	        				if(x==1)
	        				{
//	        					System.out.println("why");
	        					for(int j=0;j<4;j++) {
		        					((Arc)CurrentGame.cs1[j]).setVisible(true);
//		        					System.out.println(((Arc)CurrentGame.cs1[j]).isVisible());
		        					((Arc)CurrentGame.cs1[j]).setLayoutY(0);
	        					}
	        					
	        					CurrentGame.cob.cobc.move();
	        					break;
	        				}
	        				else if(x==0)
	        				{
	        					for(int j=0;j<4;j++) {
		        					((Arc)CurrentGame.is2[j]).setVisible(true);
		        					((Arc)CurrentGame.is1[j]).setVisible(true);
		        					((Arc)CurrentGame.is2[j]).setLayoutY(0);
		        					((Arc)CurrentGame.is1[j]).setLayoutY(0);
	        					}
	        					CurrentGame.ifo.inf.move();
	        					break;
	        				}
	        				else if(x==2)
	        				{
	        					((Polygon)CurrentGame.p).setVisible(true);
	        					((Polygon)CurrentGame.p).setLayoutY(0);
	        					break;
	        				}
	        			}
	        		}
        		}
        	}
		});
    }
    
    public void handleIOMovement(AnchorPane pane)
    {
    	pane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() 
        {
        	@Override
        	public void handle(MouseEvent t)
        	{
        		if(((Arc)CurrentGame.is1[0]).isVisible()) 
        		{
	        		for(int i=0;i<4;i++)
	        		{
	        			CurrentGame.ifo.inf.pushNodeDown((Arc)CurrentGame.is1[i]);
	        			CurrentGame.ifo.inf.pushNodeDown((Arc)CurrentGame.is2[i]);
	        		}
	        		for(int i=0;i<4;i++)
	        		{
	        			if(((Arc)CurrentGame.is1[i]).getLayoutY()>=800)
	        			{
	        				for(int j=0;j<4;j++)
	        				{
	        					((Arc)CurrentGame.is1[j]).setVisible(false);
	        					((Arc)CurrentGame.is2[j]).setVisible(false);
//	        					((Arc)CurrentGame.ms1[j]).setVisible(true);
	        				}
	        				
//	        				for(int j=0;j<2;j++)
//	        				{
//	        					((Line)CurrentGame.ms2[j]).setVisible(true);
//	        				}
	        				
	        				int x = rand.nextInt(3);
	        				System.out.println("x" +x);
	        				if(x==1)
	        				{
//	        					System.out.println("why");
	        					for(int j=0;j<4;j++) {
		        					((Arc)CurrentGame.ms1[j]).setVisible(true);
//		        					System.out.println(((Arc)CurrentGame.cs1[j]).isVisible());
		        					((Arc)CurrentGame.ms1[j]).setLayoutY(0);
	        					}
	        						for(int j=0;j<2;j++)
	    	        				{
	    	        					((Line)CurrentGame.ms2[j]).setVisible(true);
	        						    ((Line)CurrentGame.ms2[j]).setLayoutY(0);
	    	        				}
	        					CurrentGame.msob.msc.move();
	        					break;
	        				}
	        				else if(x==0)
	        				{
	        					for(int j=0;j<4;j++) {
	        						//color switch circle
	        						
	        						////////unchecked
		        					((Arc)CurrentGame.is2[j]).setVisible(true);
		        					((Arc)CurrentGame.is1[j]).setVisible(true);
		        					((Arc)CurrentGame.is2[j]).setLayoutY(0);
		        					((Arc)CurrentGame.is1[j]).setLayoutY(0);
	        					}
	        					CurrentGame.ifo.inf.move();
	        					break;
	        				}
	        				else if(x==2)
	        				{
	        					((Polygon)CurrentGame.p).setVisible(true);
	        					((Polygon)CurrentGame.p).setLayoutY(0);
	        					break;
	        				}
//	        				CurrentGame.msob.msc.move();
	        				break;
	        			}
	        		}
        	   }
        	}
		});
    }
    
    public void handleCOMovement(AnchorPane pane)
    {
    	pane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() 
        {
        	@Override
        	public void handle(MouseEvent t)
        	{
        		if(((Arc)CurrentGame.cs1[0]).isVisible()) 
        		{
//        			System.out.println("kkkkkk");
	        		for(int i=0;i<4;i++)
	        		{
	        			CurrentGame.cob.cobc.pushNodeDown((Arc)CurrentGame.cs1[i]);
	        		}
	        		for(int i=0;i<4;i++)
	        		{
	        			if(((Arc)CurrentGame.cs1[i]).getLayoutY()>=800)
	        			{
	        				for(int j=0;j<4;j++)
	        				{
	        					((Arc)CurrentGame.cs1[j]).setVisible(false);
//	        					((Arc)CurrentGame.is2[j]).setVisible(false);
//	        					((Arc)CurrentGame.ms1[j]).setVisible(true);
	        				}
	        				
//	        				for(int j=0;j<2;j++)
//	        				{
//	        					((Line)CurrentGame.ms2[j]).setVisible(true);
//	        				}
//	        				
//	        				CurrentGame.msob.msc.move();
	        				int x = rand.nextInt(3);
	        				System.out.println("x" +x);
	        				if(x==1)
	        				{
//	        					System.out.println("why");
	        					for(int j=0;j<4;j++) {
		        					((Arc)CurrentGame.ms1[j]).setVisible(true);
		        					((Arc)CurrentGame.ms1[j]).setLayoutY(0);
	        					}
	        						for(int j=0;j<2;j++)
	    	        				{
	    	        					((Line)CurrentGame.ms2[j]).setVisible(true);
	        						    ((Line)CurrentGame.ms2[j]).setLayoutY(0);
	    	        				}
	        					CurrentGame.msob.msc.move();
	        					break;
	        				}
	        				else if(x==0)
	        				{
	        					for(int j=0;j<4;j++) {
	        						//color switch circle
	        						
	        						////////unchecked
		        					((Arc)CurrentGame.is2[j]).setVisible(true);
		        					((Arc)CurrentGame.is1[j]).setVisible(true);
		        					((Arc)CurrentGame.is2[j]).setLayoutY(0);
		        					((Arc)CurrentGame.is1[j]).setLayoutY(0);
	        					}
	        					CurrentGame.ifo.inf.move();
	        					break;
	        				}
	        				else if(x==2)
	        				{
	        					((Polygon)CurrentGame.p).setVisible(true);
	        					((Polygon)CurrentGame.p).setLayoutY(0);
	        					break;
	        				}
	        				break;
	        			}
	        		}
        	   }
        	}
		});
    }
    
    public void allowBall(AnchorPane pane,ball b,Circle []circle)
    {
    	pane.setOnMouseClicked(e->{
	        for(int i=0;i<100;i++)
	        {
	        	b.BC.ball.setLayoutY(b.BC.ball.getLayoutY()-50);
	        }
	        b.BC.move();
			int maxi=-1;
			if(((Arc)CurrentGame.is2[0]).isVisible()) {
				for(int i=0;i<4;i++)
				{
					if(Shape.intersect((Arc)CurrentGame.is1[i], b.BC.ball) != null)
					{
						System.out.println("found");
					}
					if(((Arc)CurrentGame.is2[i]).getStartAngle()<=29.0 && 
							((Arc)CurrentGame.is2[i]).getStartAngle()>=-90.0&&
							b.BC.ball.getFill().equals(((Arc)CurrentGame.is2[i]).getFill())==false&&
							((Arc)CurrentGame.is1[i]).getLayoutY()<=450&&
							((Arc)CurrentGame.is1[i]).getLayoutY()>=70)
					{
						maxi=i;
						b.BC.ball.setVisible(false);
						for(int j=1;j<9;j++)
						{
							circle[j].setLayoutX(b.BC.ball.getLayoutX());
							circle[j].setLayoutY(b.BC.ball.getLayoutY());
							circle[j].setFill(Color.rgb(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
							this.Pathtrans(circle[j]);
							currPlayer.highScore = (CollectedStars>currPlayer.highScore?CollectedStars:currPlayer.highScore);
						}
						
						break;
					}
				}
			}
			
			else if(((Arc)CurrentGame.ms1[0]).isVisible())
			{
				System.out.println("hello "+b.BC.ball.getLayoutY());
				
				for(int i=0;i<4;i++)
				{

					if(Shape.intersect((Arc)CurrentGame.ms1[i], b.BC.ball) != null)
					{
						System.out.println("found");
					}
					System.out.println(((Arc)CurrentGame.ms1[i]).getId()+" "+((Arc)CurrentGame.ms1[i]).getLayoutY()+" "+((Arc)CurrentGame.ms1[i]).getStartAngle());
					if(((((Arc)CurrentGame.ms1[i]).getStartAngle()<=240 && ((Arc)CurrentGame.ms1[i]).getStartAngle()>=200.0)
							||(((Arc)CurrentGame.ms1[i]).getStartAngle()<=45 && ((Arc)CurrentGame.ms1[i]).getStartAngle()>=40.0))&&
//							&&
							b.BC.ball.getFill().equals(((Arc)CurrentGame.ms1[i]).getFill())==false&&
							((Arc)CurrentGame.ms1[i]).getLayoutY()<=450&&
							((Arc)CurrentGame.ms1[i]).getLayoutY()>=70)
					{
						System.out.println(((Arc)CurrentGame.ms1[i]).getStartAngle()+" "+((Arc)CurrentGame.ms1[i]).getFill());
						maxi=i;
						b.BC.ball.setVisible(false);
						for(int j=1;j<9;j++)
						{
							circle[j].setLayoutX(b.BC.ball.getLayoutX());
							circle[j].setLayoutY(b.BC.ball.getLayoutY());
							circle[j].setFill(Color.rgb(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
							this.Pathtrans(circle[j]);
							currPlayer.highScore = (CollectedStars>currPlayer.highScore?CollectedStars:currPlayer.highScore);
						}
						
						break;
					}
				}
			}
			
			else if(((Arc)CurrentGame.cs1[0]).isVisible())
			{
				System.out.println("hello "+b.BC.ball.getLayoutY());
				for(int i=0;i<4;i++)
				{
					
					if(Shape.intersect((Arc)CurrentGame.cs1[i], b.BC.ball) != null)
					{
						System.out.println("found");
					}
					System.out.println(((Arc)CurrentGame.cs1[i]).getId()+" "+((Arc)CurrentGame.cs1[i]).getLayoutY()+" "+((Arc)CurrentGame.cs1[i]).getStartAngle());
					if(((((Arc)CurrentGame.cs1[i]).getStartAngle()<=250 && ((Arc)CurrentGame.cs1[i]).getStartAngle()>=240.0)
							||(((Arc)CurrentGame.cs1[i]).getStartAngle()<=45 && ((Arc)CurrentGame.cs1[i]).getStartAngle()>=-31.0))&&
//							&&
							b.BC.ball.getFill().equals(((Arc)CurrentGame.cs1[i]).getFill())==false&&
							((Arc)CurrentGame.cs1[i]).getLayoutY()<=450&&
							((Arc)CurrentGame.cs1[i]).getLayoutY()>=70)
					{
						System.out.println(((Arc)CurrentGame.cs1[i]).getStartAngle()+" "+((Arc)CurrentGame.cs1[i]).getFill());
						maxi=i;
						b.BC.ball.setVisible(false);
						for(int j=1;j<9;j++)
						{
							circle[j].setLayoutX(b.BC.ball.getLayoutX());
							circle[j].setLayoutY(b.BC.ball.getLayoutY());
							circle[j].setFill(Color.rgb(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
							this.Pathtrans(circle[j]);
							currPlayer.highScore = (CollectedStars>currPlayer.highScore?CollectedStars:currPlayer.highScore);
						}
						
						
						break;
					}
				}
			}
			
			else if(((Polygon)CurrentGame.p).isVisible())
			{
//				
				if(b.BC.ball.getLayoutY()>=((Polygon)CurrentGame.p).getLayoutY())
				{
					CollectedStars++;
					lab.setText(String.valueOf(CollectedStars));
					CurrentGame.p.setVisible(false);
					int x = rand.nextInt(3);
    				System.out.println("x" +x);
    				if(x==1)
    				{
//    					System.out.println("why");
    					for(int j=0;j<4;j++) {
        					((Arc)CurrentGame.ms1[j]).setVisible(true);
        					((Arc)CurrentGame.ms1[j]).setLayoutY(0);
    					}
    						for(int j=0;j<2;j++)
	        				{
	        					((Line)CurrentGame.ms2[j]).setVisible(true);
    						    ((Line)CurrentGame.ms2[j]).setLayoutY(0);
	        				}
    					CurrentGame.msob.msc.move();
//    					break;
    				}
    				else if(x==0)
    				{
    					for(int j=0;j<4;j++) {
    						//color switch circle
    						
    						////////unchecked
        					((Arc)CurrentGame.is2[j]).setVisible(true);
        					((Arc)CurrentGame.is1[j]).setVisible(true);
        					((Arc)CurrentGame.is2[j]).setLayoutY(0);
        					((Arc)CurrentGame.is1[j]).setLayoutY(0);
    					}
    					CurrentGame.ifo.inf.move();
//    					break;
    				}
    				else if(x==2)
    				{
    					((Polygon)CurrentGame.p).setVisible(true);
    					((Polygon)CurrentGame.p).setLayoutY(0);
//    					break;
    				}
				}
			}
			else if(((Arc)CurrentGame.csc[0]).isVisible())
			{
				if(b.BC.ball.getLayoutY()>=((Arc)CurrentGame.csc[0]).getLayoutY())
				{
					for(int i=0;i<4;i++) {
					((Arc)CurrentGame.csc[i]).setVisible(true);
					((Arc)CurrentGame.csc[i]).setLayoutY(0);
					Color[] col =new Color[] {Color.YELLOW,Color.PINK,Color.SKYBLUE,Color.PURPLE};
					b.BC.ball.setFill(col[rand.nextInt(col.length)]);
					}
				}
			}
			
			if(maxi!=-1)
			{
				try {
					hbs.start(hbs.stage);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
        });
    }
    
    public void handleStarMovement(AnchorPane pane)
    {
    	pane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() 
        {
        	@Override
        	public void handle(MouseEvent t)
        	{
        		if(((Polygon)CurrentGame.p).isVisible())
        		{
        			CurrentGame.st.sc.move();
//        			CurrentGame.p.setVisible(true);
        			CurrentGame.st.sc.pushdown(CurrentGame.p);
        			if(((Polygon)CurrentGame.p).getLayoutY()>=800)
            		{
            			CurrentGame.p.setVisible(false);
            			CurrentGame.p.setLayoutY(0);
            		}
        			int x = rand.nextInt(3);
    				System.out.println("x" +x);
    				if(x==1&&((Arc)CurrentGame.ms1[0]).isVisible()==false&&!((Polygon)CurrentGame.p).isVisible())
    				{
//    					System.out.println("why");
    					for(int j=0;j<4;j++) {
        					((Arc)CurrentGame.ms1[j]).setVisible(true);
        					((Arc)CurrentGame.ms1[j]).setLayoutY(0);
    					}
    						for(int j=0;j<2;j++)
	        				{
	        					((Line)CurrentGame.ms2[j]).setVisible(true);
    						    ((Line)CurrentGame.ms2[j]).setLayoutY(0);
	        				}
    					CurrentGame.msob.msc.move();
//    					break;
//    					return;
    				}
    				else if(x==0&&(((Arc)CurrentGame.csc[0]).isVisible()==false&&!((Polygon)CurrentGame.p).isVisible()))
    				{
    					for(int j=0;j<4;j++) {
    						//color switch circle
    						
    						////////unchecked
    						((Arc)CurrentGame.csc[j]).setVisible(true);
    						((Arc)CurrentGame.csc[j]).setLayoutY(0);
    					}
    					CurrentGame.cob.cobc.move();
    				}
        	}
        	}
        });
    }
    
    public void handleColorSwitchCircleMovement(AnchorPane pane)
    {
    	if(((Arc)CurrentGame.csc[0]).isVisible())
		{
//    		for(int i=0;i<4;i++) {
    			CurrentGame.csco.cscc.move();
//    		}
			if(((Arc)CurrentGame.csc[0]).getLayoutY()>=800)
    		{
				for(int i=0;i<4;i++) {
				((Arc)CurrentGame.csc[i]).setVisible(false);
				((Arc)CurrentGame.csc[i]).setLayoutY(0);
				}
    		}
			int x = rand.nextInt(3);
			System.out.println("x" +x);
			if(x==1&&((Arc)CurrentGame.ms1[0]).isVisible()==false&&!((Arc)CurrentGame.csc[0]).isVisible())
			{
//				System.out.println("why");
				for(int j=0;j<4;j++) {
					((Arc)CurrentGame.ms1[j]).setVisible(true);
					((Arc)CurrentGame.ms1[j]).setLayoutY(0);
				}
					for(int j=0;j<2;j++)
    				{
    					((Line)CurrentGame.ms2[j]).setVisible(true);
					    ((Line)CurrentGame.ms2[j]).setLayoutY(0);
    				}
				CurrentGame.msob.msc.move();
//				break;
//				return;
			}
			else if(x==0&&((Arc)CurrentGame.cs1[0]).isVisible()==false&&!((Arc)CurrentGame.csc[0]).isVisible())
			{
				for(int j=0;j<4;j++) {
					//color switch circle
					
					////////unchecked
					((Arc)CurrentGame.cs1[j]).setVisible(true);
					((Arc)CurrentGame.cs1[j]).setLayoutY(0);
				}
				CurrentGame.cob.cobc.move();
			}
	}
    }
    
    public void setPauseButton(Stage stage,Button pause)
    {
    	pause.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
        {
        	@Override 
        	public void handle(MouseEvent t)
        	{
        		try {
        			pgs.hps = hps;
        			pgs.gameStage=stage;
					pgs.start(pgs.stage);
        			pgs.gsc=gsc;
        			pgs.gsc.CurrentPlayer = currPlayer;
        			pgs.highScore = (pgs.highScore>highScore?pgs.highScore:highScore);
        			System.out.println("current player "+pgs.gsc.CurrentPlayer);
        			System.out.println("pgs "+pgs.gsc);
        			pgs.gsc.serialize(OYarc, OParc, OPUarc, OSBarc, OYarc1, OParc1, OPUarc1, OSBarc1, CollectedStars, CurrentGame.getBall(), CurrentGame.cs1, CurrentGame.ms1, CurrentGame.ms2, CurrentGame.is1, CurrentGame.is2,CurrentGame.p ,currPlayer);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        });
    }
    
    public void start2(Stage stage) throws Exception
    {
    	FileInputStream fileIn = new FileInputStream("Game"+currPlayer.getID()+".txt");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        try {
			gameScreenController g = (gameScreenController)in.readObject();
			gsc = g;
			if(g!=null)
	        {
				this.CurrentGame = new game();
				ball b = this.CurrentGame.getBall();
				
				FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(getClass().getResource("gameScreen.fxml"));
		        Parent root = loader.load();
		        
		        Map<String, Object> fxmlNamespace2 = loader.getNamespace();
		        AnchorPane pane = (AnchorPane)fxmlNamespace2.get("acp");
		        
		        lab = (Label)fxmlNamespace2.get("score");
		        
		        Button pause = (Button)fxmlNamespace2.get("pause");
		        this.setPauseButton(stage, pause);
		        
		        Circle circle[] = new Circle[9];
				for(int j=1;j<=8;j++)
				{
					circle[j]=(Circle)fxmlNamespace2.get("b"+String.valueOf(j));
				}
				
				this.allowBall(pane,b,circle);
		        
		        this.OYarc1 = (Arc)fxmlNamespace2.get("OYarc1");
		        this.OYarc = (Arc)fxmlNamespace2.get("OYarc");
		        this.OParc1 = (Arc)fxmlNamespace2.get("OParc1");
		        this.OParc = (Arc)fxmlNamespace2.get("OParc");
		        this.OPUarc1 = (Arc)fxmlNamespace2.get("OPUarc1");
		        this.OPUarc = (Arc)fxmlNamespace2.get("OPUarc");
		        this.OSBarc1 = (Arc)fxmlNamespace2.get("OSBarc1");
		        this.OSBarc = (Arc)fxmlNamespace2.get("OSBarc");
		        
		        pane.getChildren().add(b.BC.ball);
		        
//		        b.BC.ball.setLayoutY(500);
		        for(int i=0;i<4;i++)
		        {
		        	pane.getChildren().add(CurrentGame.is1[i]);
		        	pane.getChildren().add(CurrentGame.is2[i]);
		        	pane.getChildren().add(CurrentGame.ms1[i]);
		        	pane.getChildren().add(CurrentGame.cs1[i]);
		        }
		        
		        for(int i=0;i<2;i++)
		        {
		        	pane.getChildren().add(CurrentGame.ms2[i]);
		        }
		        
		        
		        pane.getChildren().add(CurrentGame.p);
		        
		        CurrentGame.p.setLayoutX(615);
		        CurrentGame.p.setLayoutY(-11);
		        
		        move();
		        
		        CurrentGame.ifo.inf.move();
		        
		        this.handleIOMovement(pane);
		        
		        this.handleMSOMovement(pane);
		        
		        this.handleCOMovement(pane);
		        
		        this.handleStarMovement(pane);
		        
		        this.handleColorSwitchCircleMovement(pane);
		        
		        Scene scene = new Scene(root);
		        stage.setScene(scene);
				gsc.deserialize(OYarc, OParc, OPUarc, OSBarc, OYarc1, OParc1, OPUarc1, OSBarc1, CollectedStars, CurrentGame.getBall(), CurrentGame.cs1, CurrentGame.ms1, CurrentGame.ms2, CurrentGame.is1, CurrentGame.is2, CurrentGame.p, currPlayer);
		        stage.show();
	        }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
