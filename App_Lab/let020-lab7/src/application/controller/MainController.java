package application.controller;

import java.io.IOException;

import application.Main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class MainController implements  EventHandler<ActionEvent> {

	/**
	 * This method handle event when the user click on the Budget Overview button
	 * event - an action event that happen when the user click on budget Overview Button
	 */
	@Override
	public void handle(ActionEvent event) {
		System.out.println("button clicked");
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( MainController.class.getResource("../../Budget.fxml") );
			
			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );
			
			Main.stage.setTitle("Budget Overview");
			Main.stage.setScene(scene);						
			Main.stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method handle event when the user click on the Transaction button
	 * event - an action event that happen when the user click on Transaction Button
	 */
	public void transactionHandle(ActionEvent event) {
		System.out.println("transaction button clicked");
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( MainController.class.getResource("../../Transaction.fxml") );
			
			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );
			
			Main.stage.setTitle("Transaction");
			Main.stage.setScene(scene);						
			Main.stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
