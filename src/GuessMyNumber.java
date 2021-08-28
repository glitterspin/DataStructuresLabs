import java.util.Scanner;

public class GuessMyNumber {

	//make an array
	public static int[] arrayGen(int start, int end){
		int delta = end - start;
		int[] newArray = new int[delta];
		for (int i=start; i<newArray.length; i++) {
			newArray[i] = i;
		}
		return newArray;
	}

	//return a guess
	public static int midpoint(int low, int high) {
		return (int) (Math.ceil((high + low)/2));
	}
	
	public static void main(String []args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		//choose max number
		int maxNum = -1;
		do {
			System.out.print("Pick a maximum integer: ");
			String maxInput = input.nextLine();
			maxNum = Integer.parseInt(maxInput);
		} while(maxNum <= 0);
		
		boolean correct = false;
		String r = "H";
		//first guess will be halfway between zero and the array's length
		int lowEnd = 0;
		int highEnd = maxNum+1;

		//guess - first guess is maxNum/2
		int guess = midpoint(lowEnd, highEnd);;

		do {
			
			System.out.println("is your number " + guess + "?");
			System.out.println("Please enter (C)orrect, too (H)igh, or too (L)ow");
			r = input.nextLine(); 
			
			//if number correct, exit the loop
			if (r.equals("C")) {
				correct = true;
				break;
			}			
			//if number too high, reduce scope, ending with 1 below old guess
			if (r.equals("H")) {
				highEnd = guess -1;
				guess = midpoint(lowEnd,highEnd);
			}
			//if number too low, reduce scope, starting with 1 above old guess
			if (r.equals("L")) {
				lowEnd = guess +1;
				guess = midpoint(lowEnd,highEnd);
			}
		} while (!correct);
		System.out.print("Your number is "+guess+"!");
	}
}
