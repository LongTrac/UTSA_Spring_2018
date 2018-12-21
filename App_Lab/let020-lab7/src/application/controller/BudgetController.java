package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.Budget;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.AnchorPane;

public class BudgetController implements  EventHandler<ActionEvent>, Initializable {
	@FXML 
	private PieChart pChart;
	
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
	 * in this case make the pie chart ready
	 * @param location - The location used to resolve relative paths for the root object, or null if the location is not known.
	 * @param resources - resources - The resources used to localize the root object, or null if the root object was not localized.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		double [] arr = Budget.calculatePercent();

		ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
			new PieChart.Data("Expenses", arr[1]),
			new PieChart.Data("Remaining", arr[2]),
			new PieChart.Data("Income", arr[0]));
		
		pChart.setData(pieData);
	}
}
