
public class Reservation implements Comparable<Reservation> {
	private String reserveNum;
	private int flightNum;
	private String fname;
	private String lname;
	private int seatNum;
	/*---------------------------------------------------------------------------------------------*/
	/**
	 * Constructor for the reservation class
	 * @param reserveNum - the reserve number( flight number concanate with seat number)
	 * @param flightNum - the flight number
	 * @param fname - the first name of the customer
	 * @param lname - the last name of the customer
	 * @param seatNum - the seat number of the customer
	 */
	public Reservation (String reserveNum, int flightNum, String fname, String lname, int seatNum){
		this.reserveNum = reserveNum;
		this.flightNum = flightNum;
		this.fname = fname;
		this.lname = lname;
		this.seatNum = seatNum;
	}
	
	/*---------------------------------------------------------------------------------------------*/
	/**
	 * Override method compareTo to compare two reservation base on seat number
	 * @param reserve - a reservation object
	 * @return the differences between 2 seat numbers
	 */
	@Override
	public int compareTo(Reservation reserve) {
		
		return this.getSeatNum()-(reserve.getSeatNum());
	}
	
	/*---------------------------------------------------------------------------------------------*/
	/**
	 * This method take a string representation of reservation info 
	 * and populate all the fields in the reservation 
	 * @param resInfo - a string information of reservation
	 * @return r - the newly created instance of reservation
	 */
	public static Reservation parseReservationIformation (String resInfo){
		String[] temp = resInfo.split(",");
		//reserve number that concanate the flight number and seat number
		String resNum = temp[0]+ temp[3];			
		Reservation r = new Reservation (resNum, Integer.parseInt(temp[0]), temp[2], temp[1], Integer.parseInt(temp[3]));
		return r;
	}
	
	/*---------------------------------------------------------------------------------------------*/
	/**
	 * toString method that return a String representation of each Flight
	 * @return String - a string representation of each flight
	 */
	public String toString() {
		return (
				"Flight "+ this.getFlightNum()+" ("+this.getSeatNum()+") "
				+this.getLname()+ ", "+ this.getFname());
	}
	
	
	///////////////////getters and setters/////////////////////
	/**
	 * this method return a reservation number
	 * @return reserveNum - a reservation number
	 */
	public String getReserveNum() {
		return reserveNum;
	}
	/**
	 * This method set the reserve number
	 * @param reserveNum- a reservation number
	 */
	public void setReserveNum(String reserveNum) {
		this.reserveNum = reserveNum;
	}
	/**
	 * this method return a flight number
	 * @return flightNum - a flight number
	 */
	public int getFlightNum() {
		return flightNum;
	}
	/**
	 * This method set the flight number
	 * @param flightNum - a flight number
	 */
	public void setFlightNum(int flightNum) {
		this.flightNum = flightNum;
	}
	/**
	 * this method return the first name of a customer
	 * @return fname - the first name of a customer
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * This method set the first name of a customer
	 * @param fname - the first name of a customer
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * this method return the last name of a customer
	 * @return lname - the last name of a customer
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * This method set the last name of a customer
	 * @param lname - the last name of a customer
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/**
	 * this method return a seat number
	 * @return seatNum - a seat number
	 */
	public int getSeatNum() {
		return seatNum;
	}
	/**
	 * This method set the sdeat number
	 * @param seatNum - a seatnumber
	 */
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	
}
