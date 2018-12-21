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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class CartController implements Initializable{
	@FXML
	private TableView<Item> table = new TableView();
	@FXML
	private TableColumn<Item,String> iName;
	@FXML
	private TableColumn<Item,Integer>  iQuantity;
	@FXML
	private TableColumn<Item,Double>  iPrice;
	@FXML
	private Text totalAmount;
	
	//keep tract of how many time the button is clicked
	public static int count =0;
	
	public static ObservableList<Item> list =FXCollections.observableArrayList();
	public static double Total;
	
	public void goMarket (ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( MarketController.class.getResource("../../Market.fxml") );
			
			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );
			
			Main.stage.setTitle("Market");
			Main.stage.setScene(scene);						
			Main.stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void goConfirm (ActionEvent event) {
		try {
			count++;
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( MarketController.class.getResource("../../Confirmation.fxml") );
			
			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );
			
			Main.stage.setTitle("Confirmation");
			Main.stage.setScene(scene);						
			Main.stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		list.removeAll(list);										//remove the stale data in the list to update with new ones
	
		//link the column to the list
		iName.setCellValueFactory(new PropertyValueFactory("iName"));
		iQuantity.setCellValueFactory(new PropertyValueFactory("iQuantity"));
		iPrice.setCellValueFactory(new PropertyValueFactory("iPrice"));
		
		//add items
		System.out.println();
		for(Item i: Main.myCart.getMap().keySet()) {
			
			if (Main.myCart.getMap().get(i) != 0) {		
				list.add( new Item(i.getIName(),Main.myCart.totalForItem(i,Main.myCart.getMap().get(i)),Main.myCart.getMap().get(i)));
			}
		}

		//format output
		DecimalFormat df = new DecimalFormat(".00");
		Total = Main.myCart.calculateTotal();
		totalAmount.setText("$ "+df.format(Total));
		
		System.out.println(list);
		table.setItems(list);					
	}


}
