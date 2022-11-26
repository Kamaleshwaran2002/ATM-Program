package Projects.AtmMachine;

import java.io.IOException;

public class ATM {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		OptionMenu optionmenu = new OptionMenu();
		introduction();
		optionmenu.mainMenu();
	}
	
	public static void introduction() {
		System.out.println("welcome to ATM ");
	}

}
