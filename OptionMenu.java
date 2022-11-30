package Projects.AtmMachine;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu {
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'	###,##0.00");
	HashMap<Integer, Account> data = new HashMap<Integer, Account>();
	
	public void mainMenu() throws IOException{
		data.put(987650, new Account(987650,000,1000,5000));
		data.put(987651, new Account(987650,000,1000,5000));
		boolean end = false;
		
		while(!end) {
			try {
				System.out.println("\n type-1 - log	in");
				System.out.println("\n type-2 create account");
				System.out.print("\nchoice: ");
				
				int choice = menuInput.nextInt();
				
				switch(choice) {
				case 1:
					getLogin();
					end = true;
					break;
					
				case 2:
					createAccount();
					end = true;
					break;
					
				default:
					System.out.println("\ninvalid choice");
				}
			}
			
			catch(InputMismatchException e) {
				System.out.println("\ninvalid choice");
				menuInput.next();
			}
		}
		System.out.println("\n thank you for using thi ATM\n");
		menuInput.close();
		System.exit(0);
	}
	
	public void  getLogin() throws IOException {
		boolean end = false;
		int customerNumber = 0;
		int pinNumber = 0;
		
		while(!end) {
			try {
				System.out.print("\nenter you customer number:");
				customerNumber = menuInput.nextInt();
				System.out.print("\nenter your pin number: ");
				pinNumber = menuInput.nextInt();
				Iterator it = data.entrySet().iterator();
				
				while(it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					Account acc = (Account) pair.getValue();
					if(data.containsKey(customerNumber) && pinNumber == acc.getPinNumber()) {
						getAccountType(acc);
						end = true;
						break;
					}
				}
				if(!end) {
					System.out.println("\nWrong customer Number or Pin Number");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("\ninvalid character(s). Only Numbers.");
			}
		}
	}

	public void getAccountType(Account acc) throws IOException {
		boolean end = false;
		while(!end) {
			try {
				System.out.println("\nselect the account you want to access: ");
				System.out.println("Type 1 - checking account");
				System.out.println("Type 2 - savings account");
				System.out.print("\nchoice:");
				
				int selection = menuInput.nextInt();
				
				switch(selection) {
				case 1:
					getChecking(acc);
					break;	
				case 2:
					getSaving(acc);
					break;
				case 3:
					end = true;
					break;
				default:
					System.out.println("/ninvalid choice.");
				}
			}
			catch(InputMismatchException e){
				System.out.println("\ninvlaid choice.");
				menuInput.next();
			}
			
		}
	}
	
	public void getChecking(Account acc){
		boolean end = false;
		while(!end) {
			try {
				System.out.println("\nchecking account");
				System.out.println("Type 1 - view balance");
				System.out.println("Type 2 - withdraw funds");
				System.out.println("Type 3 - deposit funds");
				System.out.println("Type 4 - transfer funds");
				System.out.println("Type 5 - exits");
				System.out.println("/nchoice: ");
				
				int selection = menuInput.nextInt();
				
				switch(selection) {
				case 1:
					System.out.println("/nchecking account balance: "+moneyFormat.format(acc.getCheckingBalance()));
					break;
				case 2:
					acc.getCheckingWithdrawInput();
					break;
				case 3: 
					acc.getCheckingDepositInput();
					break;
				case 4:
					acc.getTransferInput("checking");
					break;
				case 5:
					end = true;
					break;
				default:
					System.out.println("\ninvalid choice.");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("/ninvalid choice");
				menuInput.close();
			}
		}
	}
	
	public void getSaving(Account acc) {
		boolean end = false;
		while(!end) {
			try {
				System.out.println("\nchecking account");
				System.out.println("Type 1 - view balance");
				System.out.println("Type 2 - withdraw funds");
				System.out.println("Type 3 - deposit funds");
				System.out.println("Type 4 - transfer funds");
				System.out.println("Type 5 - exits");
				System.out.println("/nchoice: ");
				
				int selection = menuInput.nextInt();
				
				switch(selection) {
				case 1:
					System.out.println("\nsavings account balance: "+moneyFormat.format(acc.getSavingBalance()));
					break;
				case 2:
					acc.getSavingWithdrawInput();
					break;
				case 3:
					acc.getSavingDepositInput();
					break;
				case 4:
					acc.getTransferInput("savings");
					break;
				case 5:
					end = true;
					break;
				default:
					System.out.println("\ninvlaid choice.");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("\ninvalid choice.");
			}
		}
	}
	

	public void createAccount() throws IOException{
		int cst_no = 0;
		boolean end = false;
		while(!end) {
			try {
				System.out.println("enter your customer number");
				cst_no = menuInput.nextInt();
				Iterator it = data.entrySet().iterator();
				
				while(it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					
					if(!data.containsKey(cst_no)) {
						end = true;
					}
				}
				if(!end) {
					System.out.println("\n this customer num is already register");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("\ninvalid choice.");
				menuInput.next();
			}
		}
		
		System.out.println("\nenter pin to be registered");
		int pin = menuInput.nextInt();
		data.put(cst_no, new Account(cst_no,pin));
		System.out.println("\nyour new accountt has been succesfully registered");
		System.out.println("redirecting to login.....");
		getLogin();
	}

}

	