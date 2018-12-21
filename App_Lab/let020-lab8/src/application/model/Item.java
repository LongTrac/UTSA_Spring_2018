package application.model;

import java.text.DecimalFormat;

public class Item {
	private String iName;
	private double iPrice;
	private int iQuantity;
	
	
	public Item(String iName, double iPrice) {
		this.iName = iName;
		this.iPrice = iPrice;
		
	}
	
	public Item(String iName, double iPrice, int iQuantity) {
		DecimalFormat df = new DecimalFormat(".00");
		this.iName = iName;
		this.iPrice = Double.parseDouble(df.format(iPrice));
		this.iQuantity = iQuantity;
	}
	
	public String toString() {
		DecimalFormat df = new DecimalFormat(".00");
		return (this.iName+","+this.iQuantity+","+df.format(this.iPrice));
	}
	
	/**
	 * @return the iQuantity
	 */
	public int getIQuantity() {
		return iQuantity;
	}
	/**
	 * @param iQuantity the iQuantity to set
	 */
	public void setiQuantity(int iQuantity) {
		this.iQuantity = iQuantity;
	}
	/**
	 * @return the iName
	 */
	public String getIName() {
		return iName;
	}
	/**
	 * @param iName the iName to set
	 */
	public void setiName(String iName) {
		this.iName = iName;
	}
	/**
	 * @return the iPrice
	 */
	public double getIPrice() {
		return iPrice;
	}
	/**
	 * @param iPrice the iPrice to set
	 */
	public void setiPrice(double iPrice) {
		this.iPrice = iPrice;
	}
	
	
	
	
}
