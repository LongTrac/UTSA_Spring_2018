package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import bank.Account;

public class AccountTest {
	private Account user1, user2, user3 ;
	private String userName;
	private int accountNum;
	private double balance;
	
	@Before
	/**
	 * The method set up variable, inititalize them for later use
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		
		userName = "Long";
		accountNum = 2323;
		balance = 40.0;
		user1 = new Account(userName, accountNum, balance);
	}

	@Test
	/**
	 * This method tests the 2 constuctors that we have  
	 */
	public void testInit() {
		user2 = new Account(userName, accountNum, balance);
		assertEquals("Error in checking constructor (with balance)."  ,40.0	,user2.getBalance() , .001);
		assertEquals("Error in checking constructor (with balance)."  ,"Long",user2.getName()); 
		assertEquals("Error in checking constructor (with balance)."  ,2323,user2.getAccNumber()); 
		
		user3 = new Account(userName, accountNum);
		assertEquals("Error in checking constructor (without balance).",0.0	,user3.getBalance() , .001);
		assertEquals("Error in checking constructor (with balance)."  ,"Long",user3.getName()); 
		assertEquals("Error in checking constructor (with balance)."  ,2323,user2.getAccNumber()); 
	}
	
	@Test
	/**
	 * This method tests method deposit with a positive input
	 */
	public void testDepositPositive() {
		
		user1.deposit(100);
		assertEquals("Error in checking deposit with positive input.",140.0	,user1.getBalance() , .001);
	
	}
	
	@Test 
	/**
	 * This method tests method deposit with a negative input
	 */
	public void testDepositNegative() {
		
		user1.deposit(-1023.3);
		assertEquals("Error in checking deposit with positive input.",40.0	,user1.getBalance() , .001);
	}
	
	@Test
	/**
	 * This method tests withdraw method with a positive input
	 */
	public void testWithdrawPositive() {
		
		user1.withdraw(10.5);
		assertEquals("Error in checking withdraw with positive input.",29.5	,user1.getBalance() , .001);
	}

	@Test
	/**
	 * This method tests withdraw method with a negative input
	 */
	public void testWithdrawNegative() {
		
		user1.withdraw(-10.5);
		assertEquals("Error in checking withdraw with negative input.",40.0	,user1.getBalance() , .001);
	}
	
	@Test
	/**
	 * This method tests withdraw method with an overdraft input
	 */
	public void testWithdrawOverdraft() {
		
		user1.withdraw(120.5);
		assertEquals("Error in checking withdraw with overdrafted input.",40.0	,user1.getBalance() , .001);
	}
	
	@After
	/**
	 * Tear down method
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
	}

}
