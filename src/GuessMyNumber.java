import java.util.Scanner;

public class GuessMyNumber {
	public static void main(String []args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		//choose array size
		int maxNum = -1;
		do {
			System.out.print("Pick a maximum integer: ");
			String maxInput = input.nextLine();
			maxNum = Integer.parseInt(maxInput);
		} while(maxNum <= 0);
		
		//make array of every number
		int[] intArray = new int[maxNum+1];
		for (int i=0; i<intArray.length; i++) {
			intArray[i] = i;
		}
		
		
		//guess - first guess is maxNum/2
		int guess = (int) (Math.floor(maxNum/2));
		System.out.println(guess);
		boolean correct = false;
		String r = "H";
		do {
			System.out.println("is your number " + guess + "?");
			System.out.println("Please enter (C)orrect, too (H)igh, or too (L)ow");
			r = input.nextLine(); 
			
			//if number correct, exit the loop
			if (r.equals("C")) {
				correct = true;
				break;
			}			
			//if number correct, exit the loop
			if (r.equals("H")) {
				System.out.println("inside of r.equals(H)");
				//regenerate 
				for (int i=0; i<(int)Math.ceil(intArray.length/2); i++) {
					intArray[i] = i;
				}
			}
			//if number correct, exit the loop
			if (r.equals("L")) {
				System.out.println("inside of r.equals(L)");
				//regenerate intArray
				int[] guessArray = new int[(int)Math.ceil(intArray.length/2)];
				for (int i=0; i<guessArray.length; i++) {
					guessArray[i] = i;
				}
				intArray = guessArray;
			}
		} while (!correct);
		System.out.print("Your number is "+guess+"!");
	}
}
