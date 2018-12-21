package application.controller;

import application.model.Board;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController implements EventHandler<ActionEvent>{

	@FXML
	Button zero0, zero1, zero2, zero3, one0, one1, one2, one3;
	
	private Board gameBoard = new Board();
	private Button previousSelected;

	/**
	 * The handle method takes care of the physical changing of the color square and check if the game is done
	 * This method print to the console about what square user click on and the whole gameBoard to show which one the user choose
	 * it checks for the following case:
	 * when 2 clicks match - reveal and disable squares to prevent future click
	 * when not matching - hide both squares by calling sleep method
	 * 
	 * @param event -an ActionEvent object which is when the mouse is click
	 */
	@Override
	public void handle(ActionEvent event) {
		Button selected = (Button) event.getSource();
		
		System.out.println();
		System.out.println("User selected square: " + selected.toString());
		
		String color = gameBoard.reveal(selected.getId());
		if( color!=null )
			selected.setStyle("-fx-background-color: #" + color );
		
		//if match then disable the button to prevent future clicks
		if(	gameBoard.matchFound()){
				selected.setDisable(true);
				previousSelected.setDisable(true);
		}
			
		// save the previous click button
		if( gameBoard.getClick()== 1){
			previousSelected = selected;
		}
		
		// if it is not match and at the second click then we are going to hide both of them
		if(gameBoard.matchFound() == false && gameBoard.getClick()== 0){
			gameBoard.hideBoth();			
			sleep( selected, 1);
			sleep( previousSelected,1);
		}
		
		System.out.println( gameBoard );
		
		//check if the game has won to display the message
		if(gameBoard.isGameWon()){
			System.out.println("\nYOU HAVE WON THE GAME!");
		}
	}
	
	
	
	/**
	 * Sleep method handles waiting for some period of time before changing
	 *  the color of the given Button back to default (light gray color).
	 * 
	 * @param selected Button clicked by the user
	 * @param seconds Integer value of number of seconds to sleep
	 */
	public void sleep( Button selected, int seconds ) {
		Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(seconds*1000);
                } catch (InterruptedException e) {
                		e.printStackTrace();
                }
                return null;
            }
        };
        
        EventHandler<WorkerStateEvent> e = new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent event) {
				selected.setStyle("");
			}
        };
        
        sleeper.setOnSucceeded( e );
        new Thread(sleeper).start();
	}
}