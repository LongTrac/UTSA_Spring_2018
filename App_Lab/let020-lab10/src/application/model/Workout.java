package application.model;

import java.util.ArrayList;
import javafx.scene.image.Image;

public class Workout {
	private String[] exercise;
	private ArrayList<Image> imageSet1 = new ArrayList<Image>();
	private ArrayList<Image> imageSet2 = new ArrayList<Image>();
	private int exercises;
	private Image image1; //= new Image("File:jumpingjack1.png");
	private Image image2;
	private Image image3;
	private Image image4;
	private Image image5;
	private Image image6;
	private Image image7;
	private Image image8;
	private Image image9;
	private Image image10;
	
	/**
	 * class constructor
	 */
	public Workout() {
		exercise = new String[5];
		exercise[0] = "Jumping Jack";
		exercise[1] = "Push Up";
		exercise[2] = "Sit Up";
		exercise[3] = "Superman";
		exercise[4] = "Toe Touch";
		exercises = 5;
		image1 = new Image("File:jumpingjack1.png");
		image2 = new Image("File:jumpingjack2.png");
		image3 = new Image("File:pushup1.png");
		image4 = new Image("File:pushup2.png");
		image5 = new Image("File:situp1.png");
		image6 = new Image("File:situp2.png");
		image7 = new Image("File:superman1.png");
		image8 = new Image("File:superman2.png");
		image9 = new Image("File:toetouch1.png");
		image10= new Image("File:toetouch2.png");
		
		//first set of image from each exercise
		imageSet1.add(image1);
		imageSet1.add(image3);
		imageSet1.add(image5);
		imageSet1.add(image7);
		imageSet1.add(image9);
		
		//2nd set
		imageSet2.add(image2);
		imageSet2.add(image4);
		imageSet2.add(image6);
		imageSet2.add(image8);
		imageSet2.add(image10);
	}
	
	/**
	 * This return the image from the first set of each exercise
	 * @param i- the index of what picture to use
	 * @return Image - an image that match with each exercise
	 */
	public Image getImage1(int i) {
		return imageSet1.get(i);
	}
	
	/**
	 * This return the image from the second set of each exercise
	 * @param i- the index of what picture to use
	 * @return Image - an image that match with each exercise
	 */
	public Image getImage2(int i) {
		return imageSet2.get(i);
	}
	/**
	 * This method return the correct String of each exercise
	 * @param i the index of where the string located inside the array
	 * @return - the string of each exercise
	 */
	public String getExercise(int i) {
		return exercise[i];
	}

	/**
	 * this method return the exercise count 
	 * @return the exercise count
	 */
	public int getExerciseCount() {
		return exercises;
	}
}