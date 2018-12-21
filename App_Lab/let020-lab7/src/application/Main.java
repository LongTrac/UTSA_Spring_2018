/**
 * @author Long-Trac let020
 * This program will helps you with your budget as it shows the overview in the image of a pie chart 
 * and a table listing all transactions that you have in the month
 */

package application;
	
import application.model.Budget;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public static Stage stage;
	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		Budget.readFile();
		try {	
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("../Main.fxml") );
			
			// Load the layout from the FXML and add it to the scene
			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );
			
			primaryStage.setTitle("My Personal Budget");
			// Set the scene to stage and show the stage to the user
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
