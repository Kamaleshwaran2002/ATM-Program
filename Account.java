package Projects.AtmMachine;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
	private int customerNumber;
	private int pinNumber;
	private double checkingBalance = 0;
	private double savingBalance = 0;
	
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	
	public Account() {
		
	}
	
	public Account(int customerNumber, int pinNumber) {
		this.customerNumber = customerNumber;
		this.pinNumber = pinNumber;
	}
	
	
	
	public Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance) {
		this.customerNumber = customerNumber;
		this.pinNumber = pinNumber;
		this.checkingBalance = checkingBalance;
		this.savingBalance = savingBalance;
	}
	
	public int getPinNumber() {
		return pinNumber;
	}

	public double getCheckingBalance() {
		// TODO Auto-generated method stub
		return checkingBalance;
	}
	
	public double getSavingBalance() {
		// TODO Auto-generated method stub
		return savingBalance;
	}

	public void getCheckingWithdrawInput() {
		// TODO Auto-generated method stub
		boolean end = false;
		
		while(!end) { 
			try {
				System.out.println("\ncurrent checking account balance: "+moneyFormat.format(checkingBalance));
				System.out.println("\namount you want to withdrawn from checking account: ");
				double amount = input.nextDouble();
				
				if((checkingBalance - amount) >=0 && amount >= 0) {
					calCheckingWithdraw(amount);
					System.out.println("\namount you want to withdrawn from checking account: ");
					end = true;
				}
				else {
					System.out.println("\nbalance cannot be negative");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("\ninvalid choice");
				input.next();
			}
		}
		
	}
	
	public void getCheckingDepositInput() {
		// TODO Auto-generated method stub
		boolean end = false;
		while(!end) {
			try {
				System.out.println("\ncurrent checking account balance: "+moneyFormat.format(checkingBalance));
				System.out.println("\namount you want to deposit from checking account: ");
				double amount = input.nextDouble();
				if((checkingBalance + amount) >= 0 && amount >= 0) {
					calCheckingDeposit(amount);
					System.out.println("\ncurrent checking account balance: "+moneyFormat.format(checkingBalance));
					end = true;
				}else {
					System.out.println("\nbalance cannot be negative");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("\ninvalid choice.");
				input.next();
			}
		}
	}

	public void getSavingWithdrawInput() {
		// TODO Auto-generated method stub
		boolean end = false;
		
		while(!end) { 
			try {
				System.out.println("\ncurrent savings account balance: "+moneyFormat.format(savingBalance));
				System.out.println("\namount you want to withdrawn from saving account: ");
				double amount = input.nextDouble();
				
				if((savingBalance - amount) >=0 && amount >= 0) {
					calSavingWithdraw(amount);
					System.out.println("\namount you want to withdrawn from saving account: ");
					end = true;
				}
				else {
					System.out.println("\nbalance cannot be negative");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("\ninvalid choice");
				input.next();
			}
		}
	}
	
	public void getSavingDepositInput() {
		// TODO Auto-generated method stub
		
		boolean end = false;
		while(!end) {
			try {
				System.out.println("\ncurrent savings account balance: "+moneyFormat.format(savingBalance));
				System.out.println("\namount you want to deposit from saving account: ");
				double amount = input.nextDouble();
				if((savingBalance + amount) >= 0 && amount >= 0) {
					calSavingDeposit(amount);
					System.out.println("\ncurrent saving account balance: "+moneyFormat.format(savingBalance));
					end = true;
				}else {
					System.out.println("\nbalance cannot be negative");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("\ninvalid choice.");
				input.next();
			}
		}
	}
	
	public double calCheckingWithdraw(double amount) {
		// TODO Auto-generated method stub
		checkingBalance = (checkingBalance - amount);
		return checkingBalance;
	}
	
	public double calCheckingDeposit(double amount) {
		// TODO Auto-generated method stub
		checkingBalance = (checkingBalance+amount);
		return checkingBalance;
	}

	public void getTransferInput(String string) {
		// TODO Auto-generated method stub
		
	}

	public double calSavingWithdraw(double amount) {
			// TODO Auto-generated method stub
			savingBalance = (savingBalance-amount);
			return savingBalance;
	}
	
	public double calSavingDeposit(double amount) {
		// TODO Auto-generated method stub
		savingBalance = (savingBalance-amount);
		return savingBalance;
	}

}
