package application.model;

import javafx.scene.paint.Color;

public class Board {
	private final int horrizon = 4;
	private final int vertical = 2;
	
	private Square[][] squares;
	private int counter = 0;
	private int x1=0, x2=0, y1=0, y2=0;
	
	public Board() {
		this.squares = new Square[vertical][horrizon];
		
		squares[0][0] = new Square(Color.RED);
		squares[0][1] = new Square(Color.BLUE);
		squares[0][2] = new Square(Color.GREEN);
		squares[0][3] = new Square(Color.YELLOW);
		squares[1][0] = new Square(Color.GREEN);
		squares[1][1] = new Square(Color.RED);
		squares[1][2] = new Square(Color.YELLOW);
		squares[1][3] = new Square(Color.BLUE);
	}
	
	
	/**
	 * This method take the position of the square and hide it (back end process)
	 * 
	 * @param x - the x position of the square
	 * @param y - the y position of the square
	 */
	public void hide( int x, int y ) {
		// TODO: Hide the given square
		//		 Hint: call the corresponding method in the Square class to help you hide it.
		
		squares[x][y].hide();	    
	}
	
	/**
	 * This method hide both square at the same time when we found an un-match
	 */
	public void hideBoth() {
		// TODO: Hide both squares - the user's 1st & 2nd choices this round
		//      Hint: this should be called if no match is found
		//		Hint 2: this method should call a hide method twice, one for each square.
		
			hide(x1, y1);
			hide(x2, y2);	
	}
	
	/**
	 * This method check each case 
	 * case1: when it is on the first click
	 * case2: when it is on the second click but the same square
	 * case3: when it is on the second click and it found a match
	 * case4: when it is on the second click and it found an un-match 
	 * 
	 * @return boolean - a value depending on which case
	 */
	public boolean matchFound() {
		// TODO: Check to see if a match is found, and return true if so
		
		//if it is the first click : ignore
		if (this.counter %2 == 1){
			//System.out.println("1st click");
			return false;
		}else{
			
			//if it is the second click but with the same position: ignore
			if((x1==x2)&&(y1==y2)){		
				//System.out.println("same position");
				return false;
			}else{
				
				//compare if they have the same color return true else return false
				if(squares[x1][y1].getColorAsString().equalsIgnoreCase(squares[x2][y2].getColorAsString())){
					//System.out.println("MATCH");
					return true;
				}else{
					//System.out.println("NO");
					return false;
				}
			}	
		}	
	}
	
	/**
	 * this method return a 0 or 1 depending on the counter 
	 * so we can check if it is the first or second click
	 * 
	 * @return int - 0 or 1 depending on 1st click or 2nd click
	 */
	public int getClick(){
		return counter % 2;
	}
	
	/**
	 * This method return a boolean value to see if user win the game
	 * It check for all position's display status
	 * If all was revealed then the game is done and vice versa
	 * 
	 * @return checkAll - a boolean value the turn true when all squares revealed
	 */
	public boolean isGameWon(){
		boolean checkAll = true;
		
		for (int i = 0; i< vertical; i++){
			for(int j = 0; j< horrizon; j++){
				if(squares[i][j].isDisplayed() == false)
					checkAll = false;
			}	
		}
		return checkAll;
	}
	
	/**
	 * This method take in an action ( a button click),
	 * translate it into x y position in the 2 dimensional array
	 * increase the counter to keep track of the click process
	 * save position for 1st and 2nd click
	 * and call the reveal method of in the same class (overloading)
	 * 
	 * @return String - a String that contain what ever the other reveal method return
	 */
	public String reveal( String buttonName ) {
		
		int x = buttonName.startsWith("zero") ? 0 : 1;
		int y;
		
		counter++;
		
		if( buttonName.endsWith("zero") )
			y = 0;
		else if( buttonName.endsWith("one") )
			y = 1;
		else if( buttonName.endsWith("two") )
			y = 2;
		else 
			y = 3;
			
		//store the position
		if(this.counter %2 == 1){		//this is the odd click
			x1 = x;
			y1 = y;
		}else{							// even click
			x2 = x;
			y2 = y;
		}
		return this.reveal(x,y);
	}	
		
	/**
	 * This method takes in the position of the square and return the HEX code of the color
	 * 
	 * @param x - the x position of the square
	 * @param y - the y position if the square
	 * @return a string representation of the color in HEX
	 */
	public String reveal( int x, int y ) {
		squares[x][y].reveal();
		return squares[x][y].getColorAsCode();
	}
	
	/**
	 * ToString method returns a String representation of the current state of the game board.
	 * 
	 * @return String Board colors currently revealed.
	 */
	public String toString() {
		String ret = squares[0][0] + ", " + squares[0][1] + ", ";
		ret += squares[0][2] + ", " + squares[0][3] + "\n";
		ret += squares[1][0] + ", " + squares[1][1] + ", "; 
		ret += squares[1][2] + ", " + squares[1][3];

		return ret;
	}
}