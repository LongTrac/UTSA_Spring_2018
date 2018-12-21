package application.controller;

import java.io.IOException;

import application.Main;
import application.model.UserProfile;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController implements EventHandler<ActionEvent> {

	@FXML
	private PasswordField pass = new PasswordField();
	@FXML
	private TextField uName = new TextField();

	UserProfile user;
	
	/**
	 * the handle method checking username and password when you click thew login button
	 * @param event - an action event that happen when you click on the login button
	 */
	@Override
	public void handle(ActionEvent event) {	
		
		// authentication helps to identify if user is in the list
		user = UserProfile.authenticate(uName.getText(), pass.getText());
		
		//if the user is null meaning that wrong input 
		if(user == null){
				try {

					FXMLLoader loader = new FXMLLoader();
					loader.setLocation( LoginController.class.getResource("../../Restricted.fxml") );
					
					AnchorPane layout = (AnchorPane) loader.load();				
					Scene scene = new Scene( layout );
					
					Main.stage.setScene(scene);						//set the restricted scene for the main stage because we use the same stage
					Main.stage.show();
					
				} catch(IOException e) {
					e.printStackTrace();
				}
			
		}else{	
			try {

				FXMLLoader loader = new FXMLLoader();
				loader.setLocation( LoginController.class.getResource("../../Recipe.fxml") );
				
				AnchorPane layout = (AnchorPane) loader.load();				
				Scene scene = new Scene( layout );
				
				Main.stage.setScene(scene);							//set the recipe scene for the main stage because we use the same stage
				Main.stage.show();
				
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * the returnLogin method handle when button is clicked to return to login screen
	 * @param event - an action event that happen when you click on the return button
	 */
	public void returnLogin (ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( LoginController.class.getResource("../../Login.fxml") );
			
			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );
			
			Main.stage.setScene(scene);						//set the restricted scene for the main stage because we use the same stage
			Main.stage.show();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
