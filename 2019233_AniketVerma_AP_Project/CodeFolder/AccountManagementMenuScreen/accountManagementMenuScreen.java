package AccountManagementMenuScreen;

import java.io.IOException;
import java.io.Serializable;

import com.sun.javafx.collections.MappingChange.Map;

import AccountSelectionListScreen.accountSelectionListScreen;
import Player.player;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class accountManagementMenuScreen extends Application implements Serializable{

	private static accountSelectionListScreen aslc = new accountSelectionListScreen();
	
	private  accountManagementMenuScreenController ammsc = new accountManagementMenuScreenController();
	
	private Button b = new Button("Save");  
    private Stage st;
    private TextField tf1 = new TextField();
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		st = new Stage();
		try {
			this.aslc.amsSt  = stage;
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("accountManagementMenuScreen.fxml"));
	        Parent root = loader.load();
	        ObservableMap<String, Object> fxmlnamespace = loader.getNamespace();
	        this.ammsc.fxmlnamespace = fxmlnamespace;
	        Button cna = (Button) fxmlnamespace.get("cna");
	        Button cea = (Button) fxmlnamespace.get("cea");
	        cea.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
	        {
	        		@Override
	        		public void handle(ActionEvent t)
	        		{
	        				try {
	        					stage.close();
								aslc.start(aslc.stage);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	       			}
	        });
	        b.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
	        	
	        	@Override
	        	public void handle(MouseEvent t)
	        	{
	        		 player p = new player();
	        		 p.setUserName(tf1.getText());
	        		 aslc.getAccountList().savedList.add(p);
	        		 st.close();
	        		 stage.close();
	        		 try {
						aslc.start(st);
						ammsc.serialize(aslc.getAccountList());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	}
			});
	        cna.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
	        	
	        	@Override
	        	public void handle(ActionEvent t)
	        	{
	        		Label user_id=new Label("WELCOME NEW PLAYER!!!!!!");   
	        	    tf1 = new TextField();  
	        	    GridPane root = new GridPane();  
	        	    root.addRow(0, user_id, tf1);   
	        	    root.addRow(2, b);  
	        	    Scene scene=new Scene(root,800,200);  
	        	    st.setScene(scene);  
	        	    st.setTitle("ENTER NAME");  
	        	    st.show(); 
	        	}
			});
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        openScreen(stage);
	        ammsc.move();
	        
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void openScreen(Stage st)
	{
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("open.fxml"));
        try {
			Parent root = loader.load();
			ObservableMap<String, Object> fxmlnamespace = loader.getNamespace();
	        Circle c = (Circle) fxmlnamespace.get("ball");
	        PathTransition p= new PathTransition();
	        Line line = new Line();
	        line.setStartX(25);
	        line.setStartY(-100);
	        line.setEndX(25);
	        line.setEndY(-450);
	        p.setPath(line);
	        p.setNode(c);
	        p.setCycleCount(1);
	        p.setDuration(Duration.seconds(3));
	        Scene scene = new Scene(root,600,600);
	        stage.setScene(scene);
	        stage.show();
	        p.play();
	        AnchorPane acp = (AnchorPane)fxmlnamespace.get("acp");
	        acp.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
	        	
	        	@Override
	        	public void handle(MouseEvent t)
	        	{
	        		stage.close();
	        		st.show();
	        	}
			});
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
