package application.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import application.Main;
import application.model.Cart;
import application.model.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ConfirmationController implements Initializable {
	@FXML private Text totalAmount;
	@FXML private Text receipt;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat(".00");
		Cart.printReceipt(CartController.list);
		receipt.setText("Receipt"+Integer.toString(CartController.count)+".txt");
		totalAmount.setText(df.format(CartController.Total));		
	} 

	
	public void goMarket (ActionEvent event) {
		try {
			Main.myCart = new Cart();
			//CartController.list = FXCollections.observableArrayList();
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( ConfirmationController.class.getResource("../../Market.fxml") );
			
			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );
			
			Main.stage.setTitle("Market");
			Main.stage.setScene(scene);						
			Main.stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
