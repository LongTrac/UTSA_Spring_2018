package application;
import application.model.Cart;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	public static Stage stage;
	public static Cart myCart;
	
	@Override
	public void start(Stage primaryStage) {
		
		stage = primaryStage;
		myCart = new Cart();
		
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("../Market.fxml") );
			
			// Load the layout from the FXML and add it to the scene
			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );
			
			// Set the scene to stage and show the stage to the user
			primaryStage.setTitle("Market");
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
