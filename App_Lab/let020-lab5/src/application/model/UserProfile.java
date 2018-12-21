package application.model;
import java.io.*;
import java.util.*;

public class UserProfile {
	private String username;
	private String password;
	
	/**
	 * This is a constructor for UserProfile that initialize username and password
	 * @param username - the username
	 * @param password - the password
	 */
	public UserProfile(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	/**
	 * This toString method return the string representation of the UserProfile
	 * @return String - string representation of the UserProfile
	 */
	public String toString(){
		String r = "";
		r += this.username + " ...... "+this.password;
		return r;
	}
	
	/**
	 * This method authenticate if the username and the password input 
	 * is one of the pair inside of the users.txt file
	 * 
	 * @param username - the username that the user input
	 * @param password - the password that the user input
	 * @return UserProfile - if the username and password entered correctly according to the file the method will return a UserProfile obj
	 */
	public static UserProfile authenticate (String username, String password){
		try{
			Scanner scan = new Scanner( new File("users.txt"));
			
			while(scan.hasNextLine()){
				String[] s = scan.nextLine().split(",");
				
				if(s[0].equals(username) && s[1].equals(password)){
					UserProfile user = new UserProfile(username, password);
					return user;
				}
				
			}
						
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;		
	}
	
	///////////////////////////////////////getters and setters///////////////////////////////////////////
	/**
	 * this getter method return the username of the user
	 * @return username - the username of the user
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * this setter method set the username of the user
	 * @param username - the username of the user
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * this getter method return the password of the user
	 * @return password - the password of the user
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * this setter method set the password of the user
	 * @param username - the password of the user
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
