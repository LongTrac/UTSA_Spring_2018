package application.controller;

import java.io.IOException;

import application.Main;
import application.model.Cart;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MarketController implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Button button = new Button();
		button = (Button)event.getTarget();
		System.out.println(button.getText());
		
		Main.myCart.addItem(button.getText());
	

	}
	
	public void viewCartHandle (ActionEvent event) {
		try {
	
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation( MarketController.class.getResource("../../Cart.fxml") );
				
				AnchorPane layout = (AnchorPane) loader.load();				
				Scene scene = new Scene( layout );
				
				Main.stage.setTitle("My Cart");
				Main.stage.setScene(scene);						
				Main.stage.show();

		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}


