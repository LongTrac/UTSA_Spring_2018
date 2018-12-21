import java.util.*;
import java.io.*;

public class School {

	private Scanner scan;
	private File file;
	
	private String schoolName;
	private int enrollment;
	private ArrayList<Student> studentArrayList ;
	private  String[] houseName; 
	
	/**
	 * Constructor which take 1 parameter: name of the school
	 * @param schoolName - the name of the school
	 */
	public School(String schoolName) {
		this.schoolName = schoolName;
		this.enrollment = 0;
		this.studentArrayList = new ArrayList<Student>();
		houseName = new String[] {"Gryffindor","Hufflepuff","Ravenclaw","Slytherin"};

	}
	
	/**
	 * Method importStudents - 
	 * takes only 1 parameter, the name of the file to be read in. 
	 * Returns nothing, but populates data within the school.
	 * @param fileName - name of the file to be read in
	 */
	public void importStudents (String fileName) {
		
		int year = 0;
		//assign the year
		if(fileName.equals("year1.txt")) {
			year = 1;
		}else if(fileName.equals("year2.txt")) {
			year = 2;
		}else if(fileName.equals("year3.txt")) {
			year = 3;
		}else {
			year = 4;
		}
		
		//file reading process
		try {
			//opening file
			file = new File (fileName);
			scan = new Scanner (file);
			
			//try to see if we have a next line
			while (scan.hasNextLine()) {

				String temp = scan.nextLine();
				String[] split = temp.split(",");		
				
				//read in and put in the arrayList
				studentArrayList.add(new Student(split[0], year, split[1]));
				enrollment++;

			}	
			scan.close();
		
		}catch(FileNotFoundException e){
			System.out.println("File can not be openned");
		}catch(IOException e) {
			System.out.println("There is a problem while reading");
			e.printStackTrace();
		}
	}// END OF IMPORT STUDENT
	
	/**
	 * Method getHouse - takes only 1 parameter, the name of a house, 
	 * and returns an ArrayList of all students in that house.
	 * @param houseName	- each house name will result in a list of different studenta
	 * @return returnList - the list of student in the same house
	 */
	public ArrayList<Student> getHouse(String houseName){
		//create a temporary list that hold all student in the same house and return 
		ArrayList<Student> returnList = new ArrayList<Student>();		
		
		for(int i= 0; i<studentArrayList.size();i++) {
			if (studentArrayList.get(i).getHouseName().equals(houseName))  {
				returnList.add(studentArrayList.get(i));	
			}
		}
		return returnList;	
	}// END OF GETHOUSE
	
	
	/**
	 * toString Method that take nothing and return a string representation
	 * @return String - string representation of the school
	 */
	public String toString() {
		return (this.getSchoolName()+ " \n"
				+ "Enrollment: " + this.getEnrollment()
				+ "\n\nGryffindor:"+ retHouse(houseName[0])
				+ "\nHufflepuff:"  + retHouse(houseName[1])
				+ "\nRavenclaw:"   + retHouse(houseName[2])
				+ "\nSlytherin:"   + retHouse(houseName[3])
				);
	}
	
	/**
	 * setHouse: a helper method for to help with an arrayList representation
	 * @param houseName - name of the house that user want to see all the students in that house
	 * @return String - a string representation of all the students in the house
	 */
	public String retHouse(String houseName) {
		//Use the getHouse method to get a List, 
		//convert every Student into a giant String representation,
		//return that String representation.
		ArrayList<Student> tempList = getHouse(houseName);
		String allStudent= "\n";
		
		for(int i = 0 ; i<tempList.size(); i++) {
			allStudent= allStudent+tempList.get(i)+"\n";
		}
		
		return allStudent;
	}
	
	
	
	///////////////////Getters and Setters////////////////
	/**
	 * getHouseName method that return a string array of house name
	 * @return houseName - an array that contains all the houses' names
	 */
	public String[] getHouseName() {
		return houseName;
	}
	
	/**
	 * setHouse method that populate the array of houseName with input
	 * @param houseName - a name of a house
	 */
	public void setHouseName(String[] houseName) {
		this.houseName = houseName;
	}
	
	/**
	 * getStudentArrayList method return a whole arrayList of all students at the school
	 * @return studentArrayList - the list of all students
	 */
	public ArrayList getStudentArrayList() {
		return studentArrayList;
	}
	
	/**
	 * setStudentArrayList method set an array List
	 * @param studentArrayList - an array List of students
	 */
	public void setStudentArrayList(ArrayList studentArrayList) {
		this.studentArrayList = studentArrayList;
	}
	
	/**
	 * getSchoolName method return the school's name
	 * @return schoolName - the school's name
	 */
	public String getSchoolName() {
		return schoolName;
	}
	
	/**
	 * setSchoolName method set the name of the school
	 * @param schoolName - the school's name
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	/**
	 * getEnrollment method return the number of students in the school
	 * @return enrollment - the number of students in the school
	 */
	public int getEnrollment() {
		return enrollment;
	}
	
	/**
	 * setEnrollment method set the number of student in the school
	 * @param enrollment - the number of students in school
	 */
	public void setEnrollment(int enrollment) {
		this.enrollment = enrollment;
	}
}