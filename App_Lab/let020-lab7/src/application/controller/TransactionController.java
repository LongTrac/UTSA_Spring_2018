package application.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import application.Main;
import application.model.Budget;
//import application.model.Transaction;
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

public class TransactionController implements EventHandler<ActionEvent>,  Initializable {
	@FXML
	private TableView<Budget> table ;
	@FXML
	private TableColumn date;
	@FXML
	private TableColumn name;
	@FXML
	private TableColumn price;
	
	/**
	 * This method takes care of when the user click the home button which will take them back to the main menu
	 * @param event - an action event that happen when user click the home button
	 */
	@Override
	public void handle(ActionEvent event) {
		System.out.println("button clicked");
		 
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( MainController.class.getResource("../../Main.fxml") );
			
			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );
			
			Main.stage.setTitle("My Personal Budget");
			Main.stage.setScene(scene);						
			Main.stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method take care of initialize the scene when it is called so everything is ready to show
	 * in this case make the table view
	 * @param location - The location used to resolve relative paths for the root object, or null if the location is not known.
	 * @param resources - resources - The resources used to localize the root object, or null if the root object was not localized.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		date.setCellValueFactory(new PropertyValueFactory("date"));
		name.setCellValueFactory(new PropertyValueFactory("name"));
		price.setCellValueFactory(new PropertyValueFactory("price"));
		
		table.setItems(getBudget());
	}	
	
	/**
	 * This method populates the data of the observable list from the input data
	 * @return list- an observable list
	 */
	public ObservableList<Budget> getBudget(){
		ObservableList<Budget> list =FXCollections.observableArrayList();
		
		
		for(Budget b: Budget.getbList())
		{
			list.add(new Budget(b.getDate(),b.getName(),("$"+b.getPrice())));
			
		}
	
		System.out.println(list);
		return list;
		
	}
}
