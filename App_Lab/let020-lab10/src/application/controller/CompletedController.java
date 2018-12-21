package application.controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class CompletedController implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Home Button clicked");
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( WorkoutController.class.getResource("../../Start.fxml") );
			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );
			Main.stage.setScene(scene);
			Main.stage.show();
			
		} catch(IOException e2) {
			e2.printStackTrace();
		}
	}

}
