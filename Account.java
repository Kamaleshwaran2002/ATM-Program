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
				System.out.println("\ncurrent account balance: "+moneyFormat.format(checkingBalance));
				System.out.println("\namount you want to withdrawn from current account: ");
				double amount = input.nextDouble();
				
				if((checkingBalance - amount) >=0 && amount >= 0) {
					calCheckingWithdraw(amount);
					System.out.println("\ncurrent account balance: "+moneyFormat.format(checkingBalance));
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
				System.out.println("\ncurrent account balance: "+moneyFormat.format(checkingBalance));
				System.out.println("\namount you want to deposit from current account: ");
				double amount = input.nextDouble();
				if((checkingBalance + amount) >= 0 && amount >= 0) {
					calCheckingDeposit(amount);
					System.out.println("\ncurrent account balance: "+moneyFormat.format(checkingBalance));
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
				System.out.println("\nsavings account balance: "+moneyFormat.format(savingBalance));
				System.out.println("\namount you want to withdrawn from saving account: ");
				double amount = input.nextDouble();
				
				if((savingBalance - amount) >=0 && amount >= 0) {
					calSavingWithdraw(amount);
					System.out.println("\nsavings account balance: "+moneyFormat.format(savingBalance));
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
				System.out.println("\nsavings account balance: "+moneyFormat.format(savingBalance));
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

	public double calSavingWithdraw(double amount) {
			// TODO Auto-generated method stub
			savingBalance = (savingBalance-amount);
			return savingBalance;
	}
	
	public double calSavingDeposit(double amount) {
		// TODO Auto-generated method stub
		savingBalance = (savingBalance+amount);
		return savingBalance;
	}
	
	public void getTransferInput(String accType) {
		// TODO Auto-generated method stub
		boolean end = false;
		while(!end) {
			try {
				if(accType.equals("checkings")) {
				System.out.println("\nselect an account you wish to transfer funds to: ");
				System.out.println("1. savings");
				System.out.println("2. exit");
				System.out.print("\nchoice:");
				int choice = input.nextInt();
				
				switch(choice) {
				case 1:
					System.out.println("\ncurrent account balance: "+moneyFormat.format(checkingBalance));
					System.out.print("\namount you want to deposit into your saving account: ");
					double amount = input.nextDouble();
					
					if((savingBalance+amount) >=0 && (checkingBalance-amount)>=0 && amount >=0) {
						calcCheckTransfer(amount);
						System.out.println("\nsavings account balance: "+moneyFormat.format(savingBalance));
						System.out.println("\ncurrent account balance: "+moneyFormat.format(checkingBalance));
						end = true;
					}
					else {
						System.out.println("balance cannot be a negative");
					}
					break;
					
				case 2:
					return ;
					
				default:
					System.out.println("\ninvalid choice.");
				}
				
				}
				
				else if(accType.equals("savings")) {
					System.out.println("\nselect an account you wish to transfer funds to: ");
					System.out.println("1. current");
					System.out.println("2. exit");
					System.out.print("\nchoice:");
					int choice = input.nextInt();
					
					switch(choice) {
					case 1:
						System.out.println("\nsavings account balance: "+moneyFormat.format(savingBalance));
						System.out.print("\namount you want to deposit into your current account: ");
						double amount = input.nextDouble();
						
						if((savingBalance+amount) >=0 && (checkingBalance-amount)>=0 && amount >=0) {
							calcSavingTransfer(amount);
							System.out.println("\ncurrent account balance: "+moneyFormat.format(checkingBalance));
							System.out.println("\savings account balance: "+moneyFormat.format(savingBalance));
							end = true;
						}
						else {
							System.out.println("balance cannot be a negative");
						}
						break;
						
					case 2:
						return ;
						
					default:
						System.out.println("\ninvalid choice.");
					}
					
					}
			}
			catch(InputMismatchException e) {
				System.out.println("\ninvalid choice.");
				input.next();
			}
		}
		
	}

	public void calcCheckTransfer(double amount) {
		// TODO Auto-generated method stub
		checkingBalance = checkingBalance - amount;
		savingBalance = savingBalance + amount;
	}
	
	public void calcSavingTransfer(double amount) {
		// TODO Auto-generated method stub
		savingBalance = savingBalance - amount;
		checkingBalance = checkingBalance + amount;
	}

}
