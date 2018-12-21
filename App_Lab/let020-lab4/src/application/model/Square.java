package application.model;

import javafx.scene.paint.Color;

public class Square {

	private boolean isDisplayed;
	private Color color;
	
	private static final String BLUE 	= "0000FF";
	private static final String GREEN 	= "00FF00";
	private static final String RED		= "FF0000";
	private static final String YELLOW 	= "FFFF00";
	
	/**
	 * This constructor accept a color type object,
	 * set the current object's color to the color input
	 * set isDisplayed to false
	 * 
	 * @param c - a color
	 */
	public Square( Color c ) {
		this.color = c;
		this.isDisplayed = false;
	}
	
	/**
	 * This method take no parameter and check to see if the color is being display
	 * if true then it return the current color, else return GRAY 
	 * 
	 * * @return - a color depending on if the square is being display
	 */
	public Color getDisplayedColor() {
		if( this.isDisplayed() )
			return this.getColor();
		else
			return Color.GRAY;
	}
	
	/**
	 * getter method that return the object's color
	 * 
	 * @return color - the color of the object
	 */
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * This method functions like a getter method where it returns the isDisplay variable
	 * 
	 * @return isDisplay - the boolean value if the square is being display
	 */
	public boolean isDisplayed() {
		return isDisplayed;
	}
	
	/**
	 * this method set isDisplay to false
	 */
	public void hide() {
		this.isDisplayed = false;
	}
	
	/**
	 * this method set isDisplay to true
	 */
	public void reveal() {
		this.isDisplayed = true;
	}
	
	/**
	 * This method return the color as its Hex code,
	 * it check to see id the square is display or not to call toString if needed
	 * 
	 * @return the hex color representation of the code
	 */
	public String getColorAsCode() {
		if( !isDisplayed() )
			return Color.GRAY.toString();
		
		if( color.equals(Color.RED) )
			return RED;
		else if( color.equals(Color.GREEN) )
			return GREEN;
		else if( color.equals(Color.BLUE) )
			return BLUE;
		else
			return YELLOW;
	}
	
	/**
	 * This method return the correct english spelling equivalancy of each color
	 * base on what the current square object hold
	 * 
	 * @return String - the english spelling of each color
	 */
	public String getColorAsString() {
		if( !isDisplayed() )
			return "GRAY";
		
		if( color.equals(Color.YELLOW) )
			return "YELLOW";
		else if( color.equals(Color.GREEN) )
			return "GREEN";
		else if( color.equals(Color.BLUE) )
			return "BLUE";
		else if( color.equals(Color.RED) )
			return "RED";
		else return "GRAY";
	}
	
	/**
	 * toString method that return a String representation of the square
	 * 
	 * @return String -  a string representation of the square
	 */
	public String toString() {
		return this.getColorAsString();
	}
}
