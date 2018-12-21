package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.Main;
import application.model.Workout;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class WorkoutController implements Initializable {
	
	@FXML private Label workout,timeLabel,progressLabel,exercise;
	@FXML private ImageView imageView;
	
	private int time = 10,progress = 1,NumOfWO = 0;
	private Workout workOut = new Workout();

	@Override
	/**
	 * This method initialized the stage and run the thread
	 * @param location - The location used to resolve relative paths for the root object, or null if the location is not known.
	 * @param resources - resources - The resources used to localize the root object, or null if the root object was not localized.
	 */
	public void initialize(URL location, ResourceBundle resources) {

	Thread th = new Thread(new Task<Void>()  {
            @Override
            protected Void call() throws Exception {
                Platform.runLater(() -> timeLabel.setText( String.format("Time Remaining: 00:%02d", time ) ) );
                Platform.runLater(() -> exercise.setText(String.format("Exercise: %s",workOut.getExercise(progress-1))));
                Platform.runLater(() -> progressLabel.setText(String.format("Progress: exercise %d of %d", progress, workOut.getExerciseCount())));
                Platform.runLater(() -> imageView.setImage(workOut.getImage1(NumOfWO)));
                	
                while ( time >= 0 && NumOfWO <=4) {
					time--;
					imageView.setImage(workOut.getImage2(NumOfWO));
					Platform.runLater(() -> timeLabel.setText( String.format("Time Remaining: 00:%02d", time ) ) );
					Platform.runLater(() -> exercise.setText(String.format("Exercise: %s",workOut.getExercise(progress-1))));
					Platform.runLater(() -> progressLabel.setText(String.format("Progress: exercise %d of %d", progress, workOut.getExerciseCount())));
					
					Thread.sleep( 500 );
					imageView.setImage(workOut.getImage1(NumOfWO));
					Thread.sleep( 500 );
					
					if(time == 0) {
						time = 10;
						NumOfWO++;
						progress++;
					}
                }
               Platform.runLater(() -> finish());
                return null;
            }
		});
	
		th.start();
		
	}
	
	/**
	 * This method set the work out type(cardio or strength) to the text
	 * @param Workout
	 */
	public void setWorkout(String Workout) {
		workout.setText(Workout);

	}
	
	/**
	 * This method handle the changing scene when work out is done
	 */
	public void finish() {

		System.out.println("workout completed");
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation( WorkoutController.class.getResource("../../Complete.fxml") );
				AnchorPane layout = (AnchorPane) loader.load();				
				Scene scene = new Scene( layout );
					
				Main.stage.setScene(scene);
				Main.stage.show();
			} catch(IOException e2) {
				e2.printStackTrace();
			}
	}
}
