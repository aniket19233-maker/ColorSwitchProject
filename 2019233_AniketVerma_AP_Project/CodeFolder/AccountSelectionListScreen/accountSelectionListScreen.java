package AccountSelectionListScreen;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Observable;

import javax.swing.plaf.basic.BasicListUI.ListSelectionHandler;

import Game.game;
import HomePageScreen.homePageScreen;
import ListScreenHandler.listScreenHandler;
import Player.player;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class accountSelectionListScreen extends Application implements Serializable{

	public accountSelectionListScreenController aslsc = new accountSelectionListScreenController();
	
	public Stage stage = new Stage();
	
	public Stage amsSt;
	
	private static listScreenHandler<player> PLayerList;
	
	private player currentPlayer;
	
	private game currentGame;
	
	public listScreenHandler<player> getAccountList()
	{
		return this.PLayerList;
	}

	public player getCurrentPlayer()
	{
		return this.currentPlayer;
	}
	
	public void setCurrentPlayer(player p)
	{
		this.currentPlayer = p;
	}
	
	public game getCurrentGame()
	{
		return this.currentGame;
	}
	
	public void setCurrentGame(game g)
	{
		this.currentGame = g;
	}
	
	public accountSelectionListScreen()
	{
		this.PLayerList = new listScreenHandler<player>();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		try {
			stage.setX(50);
			stage.setY(50);
			stage.setWidth(600);
			stage.setHeight(600);
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("accountSelectionListScreen.fxml"));
	        Parent root = loader.load();
	        Map<String, Object> fxmlnamespace = loader.getNamespace();
	        
	        ChoiceBox dropBox = (ChoiceBox)fxmlnamespace.get("dropbox");
	        int i=0;
	        try
	        {
	        	FileInputStream fileIn = new FileInputStream("savedGame.txt");
	            ObjectInputStream in = new ObjectInputStream(fileIn);
	            listScreenHandler<player> l = (listScreenHandler<player>)in.readObject();
	            if(l!=null) {
	            for(i=0;i<l.savedList.size();i++)
	            {
	            		this.PLayerList.savedList.add(l.savedList.get(i));
	            }
	            }
	            in.close();
	            fileIn.close();
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	        Button b = (Button)fxmlnamespace.get("Go");
	        i=0;
	        ObservableList<String> list = dropBox.getItems();
	        for(int j=i;j<this.PLayerList.savedList.size();j++)
	        {
	        	if(list.contains(this.PLayerList.savedList.get(j).getUserName())==false)
	        	list.add(this.PLayerList.savedList.get(j).getUserName());
	        }
	        b.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
	        	
	        	@Override
	        	public void handle(MouseEvent t)
	        	{
	        		if(PLayerList!=null||PLayerList.savedList.size()!=0)
	        		{
	        			stage.close();
	        			homePageScreen h= new homePageScreen();
	        			try {
	        				player temp = currentPlayer;
		        			for(int i=0;i<PLayerList.savedList.size();i++)
		        			{
		        				if(dropBox.getValue().toString().equals(PLayerList.savedList.get(i).getUserName()))
		        				{
		        					temp=PLayerList.savedList.get(i);
		        				}
		        			}
		        			setCurrentPlayer(temp);
		        			System.out.println("aslc "+temp);
		        			h.CurrentPlayer = currentPlayer;
		        			System.out.println(h.CurrentPlayer);
							h.start(new Stage());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        			
	        		}
	        	}
			});
	        
	        Button g = (Button)fxmlnamespace.get("back");
	        g.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
	        	
	        	@Override
	        	public void handle(MouseEvent t)
	        	{
	        		aslsc.goBack(amsSt, stage);
	        	}
			});
	        
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private ObservableList<String> getItems() {
		// TODO Auto-generated method stub
		return null;
	}

}
