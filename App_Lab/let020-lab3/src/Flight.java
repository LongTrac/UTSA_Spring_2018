import java.util.*;

public abstract class Flight implements Comparable<Flight> {
	
	private int flightNum;
	private String origin;						//original airport
	private String destination;					//destination airport
	private String departure;					//departure time
	private String arrival;						//arrival time
	private ArrayList<Reservation> reserve; 	//a collection of reservation
	
	/*---------------------------------------------------------------------------------------------*/
	/**
	 * the class constructor that except the parameters below
	 * @param flightNum - the flight number
	 * @param origin - the original airport
	 * @param destination - the destination airport
	 * @param departure - the departure time
	 * @param arrival - the arrival time
	 */
	public Flight(int flightNum, String origin, String destination, String departure, String arrival) {

		this.flightNum = flightNum;
	    this.origin = origin;
	    this.destination = destination;
		this.departure = departure;
		this.arrival = arrival;
		reserve = new ArrayList<Reservation>();
	}
	
	/*---------------------------------------------------------------------------------------------*/
	/**
	 * 
	 * Override method compareTo to compare two flights 
	 * based on their departure time
	 * @param flight - the second instance of the Flight object
	 */
	@Override
	public int compareTo(Flight flight) {
		return this.getDeparture().compareTo(flight.getDeparture());
	}
	
	/*---------------------------------------------------------------------------------------------*/
	/**
	 * This parseFlightInformation take a string of information 
	 * and put the info into different fields of a flight objects
	 * @param flightInfo - a line of String from read from the file
	 * @return Flight - a flight object (either a commercial flight or private flight)
	 */
	public static Flight parseFlightInformation (String flightInfo) {
		String[] temp = flightInfo.split(",");
		
		if (temp[1].equalsIgnoreCase("commercial")) {
			CommercialFlight cFlight = new CommercialFlight(Integer.parseInt(temp[0]),temp[2], temp[3], temp[4], temp[5]);
			return cFlight;
		}else {
			PrivateFlight pFlight = new PrivateFlight(Integer.parseInt(temp[0]),temp[2], temp[3], temp[4], temp[5]);
			return pFlight;
		}
	}
	
	/*---------------------------------------------------------------------------------------------*/
	/**
	 * an abstract method the return a boolean to determine if a flight is commercial
	 * @return a boolean value if the flight is commercial or not
	 */
	public abstract boolean isFlightCommercial();
	
	/*---------------------------------------------------------------------------------------------*/
	/**
	 * toString method return a String representation of each flight
	 * @return String - a string representation of each flight
	 */
	public String toString() {
	       return (this.commercialPrivate()+"   Flight   " + this.getFlightNum() +
	    		   " From   " + this.getOrigin() +
	    		   " To   " + this.getDestination() +
	               "   departs " + this.getDeparture() + 
	               " arrives " + this.getArrival() +
	               " Seats Reserved : "+reserve.size());
	   }
	
	/*---------------------------------------------------------------------------------------------*/
	/**
	 * this helper method will determine if a flight should be printed 
	 * as commercial or private 
	 * @return String - a String representation for commercial and private
	 */
	public String commercialPrivate () {
		if(this.isFlightCommercial() == true)
			return ("Commercial");
		else
			return ("Private   ");
	}
	
	/*---------------------------------------------------------------------------------------------*/
	/**
	 * This method help adding new reservation to the flight
	 * @param r - an instance of Reservation type
	 */
	public void addReserve (Reservation r) {
		this.reserve.add(r);
	}
	
	/*---------------------------------------------------------------------------------------------*/
	/**
	 * this method help to show all reservation in the list
	 * @return String - a string representation for all reservation in an instance of a flight
	 */
	public String showList() {
		String bigList = "\n";
		for(Reservation r: reserve) {
			bigList = bigList+r+"\n";
		}
		return bigList;
	}
	
	////////////////////getters and setters////////////////
	/**
	 * This method return a flight number
	 * @return flightNum - the flight number
	 */
	public int getFlightNum() {
		return flightNum;
	}
	/**
	 * This method set the flight number
	 * @param flightNum - the flight number
	 */
	public void setFlightNum(int flightNum) {
		this.flightNum = flightNum;
	}
	/**
	 * This method return the original airport
	 * @return origin - the original airport
	 */
	public String getOrigin() {
		return origin;
	}
	/**
	 * This method set the original airport
	 * @param origin - the original airport
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	/**
	 * This method return the destination airport
	 * @return destination - the destination airport
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * This method set the destination airport
	 * @param destination- the destination airport
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * This method return the departure time
	 * @return departure - the departure time
	 */
	public String getDeparture() {
		return departure;
	}
	/**
	 * This method set the departure time
	 * @param departure - the departure time
	 */
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	/**
	 * This method return the arrival time
	 * @return arrival - the arrival time
	 */
	public String getArrival() {
		return arrival;
	}
	/**
	 * This method set the arrival time
	 * @param arrival - the arrival time
	 */
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	/**
	 * This method return the reservation list
	 * @return reserve - the reservation list
	 */
	public ArrayList<Reservation> getReserve() {
		return reserve;
	}
	/**
	 * This method set the reservation list
	 * @param reserve - the reservation list
	 */
	public void setReserve(ArrayList<Reservation> reserve) {
		this.reserve = reserve;
	}

	
	
}
