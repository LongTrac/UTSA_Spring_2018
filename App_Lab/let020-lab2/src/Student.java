
public class Student {

	private String studentName;
	private int year;
	private String houseName;
	
	/**
	 * The constructor that take 3 parameters: student's name, year and house's name
	 * @param studentName - the name of the student
	 * @param year - the year of which a student is enroll in
	 * @param houseName - the house which a student belongs to
	 */
	public Student(String studentName, int year, String houseName) {
		this.studentName = studentName;
		this.year = year;
		this.houseName = houseName;
	}
	
	/**
	 * toString Method that take nothing and return a string representation
	 * @return String - string representation of the student
	 */
	public String toString() {
		return (studentName+" (Year: "+year+ ") - "+ houseName);
	}
	
	
	
	
	//////////////Getters and Setters/////////////////////////
	/**
	 * getStudentName method return a a student's name 
	 * @return studentName - a string that contain student's name
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * setStudentName method set the value for studentName
	 * @param studentName - a string that contain student's name
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	/**
	 * getYear method return the year of enrollment
	 * @return year - the year of enrollment
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * setYear method set the value for student's enrollment year
	 * @param year - student enrollment's year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * getHouseName method return the house's name that the student belongs to
	 * @return houseName - the name of the house that a student is currently in
	 */
	public String getHouseName() {
		return houseName;
	}
	
	/**
	 * setHouseName method set the house's name of a student
	 * @param houseName - student's house
	 */
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	
}
