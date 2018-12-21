package bank;

public class Account {

	private String name;
	private int accNumber;
	private double balance;
	
	/**
	 * Overloaded Account constructor
	 * @param name - the user name
	 * @param accNumber - the bank account number
	 * @param balance- the balance for the bank account
	 */
	public Account(String name, int accNumber, double balance){
		this.name = name;
		this.accNumber = accNumber;
		this.balance = balance;
	}

	/**
	 * Overloaded Account constructor
	 * @param name - the user name
	 * @param accNumber - the bank account number
	 */
	public Account(String name, int accNumber){
		this.name = name;
		this.accNumber = accNumber;
		this.balance = 0.0;
	}
	
	/**
	 * deposit method that take a positive number and add to the current bank balance
	 * @param inMoney - the amount of money that user want to deposit
	 * @return the new account balance
	 */
	public double deposit(double inMoney){
		if(inMoney >0)
			this.balance += inMoney;
		
		return this.balance;
	}
	
	/**
	 * withdraw method that take a positive number of money that is smaller than the current balance to withdraw
	 * @param outMoney - the amount of money that user wants to withdraw
	 * @return the new account balance
	 */
	public double withdraw (double outMoney){
		//only when the amount withdraw is smaller than the total balance
		if(outMoney< this.balance && outMoney >0)
				this.balance -= outMoney;
			
		return this.balance;
	}
	
	////////////////////////////////////////////////G&S////////////////////////////////////
	/**
	 * getName method that return the user name of the account
	 * @return - the user name of the account
	 */
	public String getName() {
		return name;
	}
	/**
	 * setName method that set the user name for the account
	 * @param name - the user name of the account
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * getAccNumber method that return the user Account Number of the account
	 * @return - the account number of the user
	 */
	public int getAccNumber() {
		return accNumber;
	}

	/**
	 * setAccNumber method that set the user Account number for the account
	 * @param - the account number of the user 
	 */
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	/**
	 * getBalance method that return the user Balance of the account
	 * @return - the account balance of the user
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * setBalance method that set the balance for the account
	 * @param 
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
