package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.Workout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class MainController implements EventHandler<ActionEvent>, Initializable {
	
	@FXML
	private RadioButton cardio, strength;
	@FXML
	private Button start;
	
	final ToggleGroup group = new ToggleGroup();
	
	@Override
	/**
	 * This method handle when start button is clicked to see if which radio button is clicked
	 * and get the correct type of exercise for the next stage
	 * @param event - An Action event that happen when the start work out button is clicked
	 */
	public void handle(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( MainController.class.getResource("../../Workout.fxml") );
			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );
				
				if(cardio.isSelected()) {		
					WorkoutController wo = loader.getController();
					wo.setWorkout("Workout: Cardio");
					Main.stage.setTitle("CARDIO");
					
				}else if(strength.isSelected()) {
					WorkoutController wo = loader.getController();
					wo.setWorkout("Workout: Strength");
					Main.stage.setTitle("STRENGTH");
				}
				
			Main.stage.setScene(scene);
			Main.stage.show();
			} catch(IOException e2) {
				e2.printStackTrace();
			}
	}

	@Override
	/**
	 * This method initialized the radio button group
	 * @param location - The location used to resolve relative paths for the root object, or null if the location is not known.
	 * @param resources - resources - The resources used to localize the root object, or null if the root object was not localized.
	 */
	 
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cardio.setToggleGroup(group);
		cardio.setSelected(true);
		strength.setToggleGroup(group);
	}

}
