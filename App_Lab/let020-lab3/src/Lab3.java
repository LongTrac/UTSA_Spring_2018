/**
 * @author - Long Trac let020
 */
import java.io.*;
import java.util.*;

public class Lab3 {
	public static void main (String[] args) {
		
		File file;
		Scanner scan;
		ArrayList<Flight> flightList= new ArrayList<Flight>();  
		ArrayList<Reservation> reserveList= new ArrayList<Reservation>();

		
		//read the flight schedule
		try{
			//opening file
			file = new File("flight-schedule.txt");
			scan = new Scanner (file);
			
			while (scan.hasNextLine()){
				String temp = scan.nextLine();
				
				flightList.add(Flight.parseFlightInformation(temp));
			}
		}catch(FileNotFoundException e){
			System.out.println("File can not be openned");
		}catch(IOException e) {
			System.out.println("There is a problem while reading");
			e.printStackTrace();
		}
		
		//read the reservations
		try{
			//opening file
			file = new File("reservations.txt");
			scan = new Scanner (file);
			
			while (scan.hasNextLine()){
				String temp = scan.nextLine();
				
				reserveList.add(Reservation.parseReservationIformation(temp));
			}
		}catch(FileNotFoundException e){
			System.out.println("File can not be openned");
		}catch(IOException e) {
			System.out.println("There is a problem while reading");
			e.printStackTrace();
		}
		
		//sort the list according to the lab requirement
		Collections.sort(reserveList);
		Collections.sort(flightList);
		
		//nested for loop to add reservation to the right flight			
		for (Flight f: flightList) {
			for(Reservation r: reserveList){
				if(r.getFlightNum()== f.getFlightNum())
				{
					f.addReserve(r);
				}
			}
		}
		
		//output
		System.out.println("-----------------------------------------------------------------------");
		for(Flight f: flightList) {
			System.out.println(f);
		}
		System.out.println("-----------------------------------------------------------------------");
			System.out.println(flightList.get(2).showList());
	}
}
