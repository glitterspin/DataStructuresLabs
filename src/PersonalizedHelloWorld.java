import java.util.Scanner;

public class PersonalizedHelloWorld {
	public static void main(String []args) {
		//create a new Scanner object
		Scanner input = new Scanner(System.in);
		String firstAndLast ="";	
		
		//name loop
		do {
			System.out.print("What is your name?"); //ask for name
			firstAndLast = input.nextLine(); //input name
		} while(firstAndLast == ""); //check if something entered, if not reenter loop until something entered
		
		
		System.out.println("Your name is: " + firstAndLast); 
	}
}

