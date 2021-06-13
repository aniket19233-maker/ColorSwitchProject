package SettingScreen;

import java.io.File;
import java.io.Serializable;

import UserButton.userButton;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.*;

public class settingScreenController implements Serializable{
	
	public Stage stage;
	
	private boolean isMusicPlaying ; 
	
	private String path;
	
	public userButton ToggleMusicButton;
	
	public userButton BackButton;
	
	public userButton setMusicButton;
	
//	public settingScreenController(Stage stage)
//	{
//		this.stage=stage;
//	}
	
	public void setPath(String p)
	{
		this.path = p;
	}
	
	public void PlaySetMusic()
	{
		try {
//        FileChooser chooser = new FileChooser();
			
//Instantiating Media class  
			
//        File file = chooser.showOpenDialog(null);
		
		
		File file = new File(this.path);
		
        Media media = new Media(file.toURI().toString());  
          
        //Instantiating MediaPlayer class   
        MediaPlayer mediaPlayer = new MediaPlayer(media);  
        
        mediaPlayer.setOnEndOfMedia(new Runnable() 
        {
            public void run() 
            {
              mediaPlayer.seek(Duration.seconds(3));
            }
        });
       mediaPlayer.play();
        
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void SoundHandler()
	{
		Stage stage = new Stage();
		stage.setX(500);
		stage.setY(500);
		stage.setWidth(500);
		stage.setHeight(200);
		Label user_id=new Label("SongPath");   
	    TextField tf1=new TextField();  
	    Button b = new Button("Save");  
	    GridPane root = new GridPane();  
	    root.addRow(0, user_id, tf1);   
	    root.addRow(2, b);  
	    Scene scene=new Scene(root,800,200);  
	    stage.setScene(scene);  
	    stage.setTitle("ENTER MUSIC PATH");  
	    stage.show(); 
	    b.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent t)
	    	{
	    		setPath(tf1.getText());
	    		PlaySetMusic();
	    	}
		});
	}
	
	public boolean getIsMusicPlaying()
	{
		return this.isMusicPlaying;
	}
	
	@FXML
	public void setIsMusicPlaying(boolean val)
	{
		this.isMusicPlaying = val;
	}

	@FXML
	public void closeWindow()
	{	
		this.stage.close();
	}
}

///Users/aniketverma/Downloads/02\ Challenge\ Easy.mp3 