package PauseGameScreen;

import java.io.Serializable;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class pauseGameScreenController implements Serializable{
	@FXML
	private Button Cont,qtmm;
	
	public void Continue(Stage stage)
	{
		stage.close();
	}
}
