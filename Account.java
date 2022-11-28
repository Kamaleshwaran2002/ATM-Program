package Projects.AtmMachine;

public class Account {
	private int customerNumber;
	private int pinNumber;
	private double checkingBalance = 0;
	private double savingBalance = 0;
	
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

	public Object getCheckingBalance() {
		// TODO Auto-generated method stub
		return null;
	}

	public void getCheckingWithdrawInput() {
		// TODO Auto-generated method stub
		
	}

	public void getCheckingDepositInput() {
		// TODO Auto-generated method stub
		
	}

	public void getTransferInput(String string) {
		// TODO Auto-generated method stub
		
	}

	public Object getSavingBalance() {
		// TODO Auto-generated method stub
		return null;
	}

	public void getSavingWithdrawInput() {
		// TODO Auto-generated method stub
		
	}

	public void getSavingDepositInput() {
		// TODO Auto-generated method stub
		
	}
}
