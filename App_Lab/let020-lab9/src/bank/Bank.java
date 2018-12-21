package bank;

import java.util.HashSet;
import java.util.Set;

public class Bank {
	private String name;
	private Set<Account> accSet;
	
	/**
	 * Bank constructor that take in the name of the bank and initialize the list of account to be empty
	 * @param name - the name of the bank
	 */
	public Bank(String name){
		this.name = name;
		accSet = new HashSet<Account>();
	}
	
	/**
	 * Overloaded addAcount that take in the name of the user, an account number and the balance
	 * @param name - the user name 
	 * @param accNum- the account number
	 * @param balance - the balance of the account
	 */
	public void addAccount(String name, int accNum, double balance){
		accSet.add(new Account(name,accNum,balance));
	}

	/**
	 * Overloaded addAcount that take in the name of the user, an account number 
	 * @param name - the user name 
	 * @param accNum- the account number
	 */
	public void addAccount(String name, int accNum) {
		accSet.add(new Account(name,accNum));
	}
}
