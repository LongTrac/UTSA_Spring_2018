
public class PrivateFlight extends Flight {
	/**
	 * constructor of the PrivateFlight class that call the super class
	 * @param flightNum - the flight number
	 * @param origin - the original airport
	 * @param destination - the destination airport
	 * @param departure - the departure time
	 * @param arrival - the arrival time
	 */
	public PrivateFlight(int flightNum, String origin, String destination, String departure, String arrival) {
		super(flightNum, origin, destination, departure, arrival);
	}
	
	/**
	 * a method the return a boolean to determine if a flight is commercial
	 * @return a boolean value if the flight is commercial or not
	 */
	public boolean isFlightCommercial(){
		return false;
	}
	
}
