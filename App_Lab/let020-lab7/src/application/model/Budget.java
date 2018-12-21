package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Budget {

	private String name;
	private String date;
	private String price;
	private static ArrayList<Budget> bList = new ArrayList<Budget>();
	
	/**
	 * class contructor
	 * @param date - the date of the transaction
	 * @param name - what transaction that is
	 * @param price - how much did it cost or gain
	 */
	public Budget (String date, String name , String price) {
		this.name = name;
		this.date = date;
		this.price = price;
	}
	
	/**
	 * This method just read in a csv file and populate the data in the arrayList
	 */
	public static void readFile() {
		Scanner scan = null;
		try {
			scan = new Scanner(new File ("data.csv"));
			while(scan.hasNextLine()){
				String[] s = scan.nextLine().split(",");
				bList.add(new Budget(dateFormat(s[0]),s[1],s[2]));
			}	
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			if (scan != null)
				scan = null;
		}
	}
	
	/**
	 * This method formats the month base on the file we have
	 * @param s - a string that contain date information in the format mm-dd-yyyy
	 * @return String - an English representation of that string
	 */
	public static String dateFormat (String s) {
		String[] str = s.split("-");
		String month;
		
		switch(str[0]) {
			case "01": {
				month = "January";
				break;
			}case "02": {
				month = "February";
				break;
			}case "03": {
				month = "March";
				break;
			}case "04": {
				month = "April";
				break;
			}case "05": {
				month = "May";
				break;
			}case "06": {
				month = "June";
				break;
			}case "07": {
				month = "July";
				break;
			}case "08": {
				month = "August";
				break;
			}case "09": {
				month = "September";
				break;
			}case "10": {
				month = "October";
				break;
			}case "11": {
				month = "November";
				break;
			}case "12": {
				month = "December";
				break;
			}default: {
				month = null;
			}		
		}
		return (month+" "+str[1]+", "+str[2]);
	}	
	
	/**
	 * This method calculate the percent of each component for the pie chart
	 * where money[0] hold the paycheck, money[1] hold the expense, money[2] hold the remainder
	 * @return money - an array that contains double values
	 */
	public static double[] calculatePercent () {
		//
		double[] money = new double [3];
		double total = 0;
		
		Budget.readFile();
		for(Budget a: bList) {
			total =total+ Double.parseDouble(a.getPrice());					//add all to the total
			if(a.getName().equals("paycheck"))
				money[0] =money[0]+ Double.parseDouble(a.getPrice());			// find incomes
			else
				money[1] =money[1]+ Double.parseDouble(a.getPrice());			//find expense
		}
		money[2] = money[0]-money[1];
		
		//calculate percent
		money[0] = (money[0]/total)*100;
		money[1] = (money[1]/total)*100;
		money[2] = (money[2]/total)*100;
		
		System.out.println(money[0]+" "+money[1]+" "+money[2]);
		return money;
		
	}
	
	///////////////////////////////getters and setters/////////////////////////////////
	/**
	 * This method return the name component of a budget object
	 * @return name - the name of the budget transaction item
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method populate the budget object's name
	 * @param name- the name of the budget transaction item
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * This method return the date component of a budget object
	 * @return date - the date of the budget transaction item
	 */
	public String getDate() {
		return date;
	}
	/**
	 * This method populate the budget object's date
	 * @param date- the date of the budget transaction item
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * This method return the price component of a budget object
	 * @return price - the price of the budget transaction item
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * This method populate the budget object's price
	 * @param price- the price of the budget transaction item
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	
	/**
	 * This method return the list of budget transaction item
	 * @return blist - a list of budget transaction item
	 */
	public static ArrayList<Budget> getbList() {
		return bList;
	}

	/**
	 * This method assign a populated list to bList
	 * @param bList -  a list of budget transaction item
	 */
	public void setbList(ArrayList<Budget> bList) {
		this.bList = bList;
	}
	
}
