
import java.util.*;

public class Lab2 {
	public static void main( String[] args ) {
	  	School hogwarts = new School("Hogwarts School of Witchcraft & Wizardry");	

	  	hogwarts.importStudents("year1.txt");	
	  	hogwarts.importStudents("year2.txt");	
	  	hogwarts.importStudents("year3.txt");	
	  	hogwarts.importStudents("year4.txt");	
	  	
	  	System.out.println( hogwarts );	


	}
}
