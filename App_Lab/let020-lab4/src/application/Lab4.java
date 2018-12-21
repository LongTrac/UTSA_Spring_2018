package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Memory Game
 * 	This application is a basic memory game. The user is shown a 2x4 grid of gray squares.
 * 	A square is "revealed" when the user clicks on it - the color of the square is then shown.
 *  Squares are gray when "hidden", and can be red, green, blue, or yellow when shown.
 *  
 *  The user begins by revealing 2 squares. If both squares are the same color, the squares 
 *  remain shown, otherwise the squares are hidden again (and turn gray). 
 *  
 *  The game ends when the user has matched all of the squares (all colors are shown).
 * 
 * UTSA CS 3443 - Lab 4 - Spring 2018
 * @author Amanda Fernandez
 */
public class Lab4 extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Load the FXML file for the game board
			Parent root = FXMLLoader.load(getClass().getResource("/board.fxml"));
			
			// Set the scene onto the stage
			primaryStage.setScene(new Scene(root, 800, 400));
			
			// Display the board to the user
			primaryStage.show();
						
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// Launches the application (calls start method in the process)
		launch(args);
	}
}