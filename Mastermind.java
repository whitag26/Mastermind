import java.util.Scanner;

public class Mastermind {
	public static void main(String[] args) {
		System.out.println("Welcome to Mastermind (with numbers)!"
				+ "\nThere will be a randomly generated 3 digit number consiting of numbers between 1-5. No number will be repeated."
				+ "\nPlease guess which number is in what position.");

		int num1 = (int) (Math.random() * (5-1 + 1) + 1);
		int num2 = (int) (Math.random() * (5-1 + 1) + 1);
		int num3 = (int) (Math.random() * (5-1 + 1) + 1);

		while(num1 == num2 || num1 == num3 || num2 == num3) {
			if(num1 == num2){
				num2 = (int) (Math.random() * (5-1 + 1) + 1);
			}
			else if(num1 == num3){
				num3 = (int) (Math.random() * (5-1 + 1) + 1);
			}
			else if(num2 == num3) {
				num3 = (int) (Math.random() * (5-1 + 1) + 1);
			}
		}

		//System.out.println(""+num1 + num2 + num3);

		int correctPos = 0;
		int correctNum = 0;

		int guess = 1;

		String playAgain = "Y";

		while(playAgain.equals("Y")) {
			guess = 1;
			while (correctPos <= 3 && correctNum <= 3) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Guess " + guess + ":");
				System.out.println("\tFirst Number: ");
				int guess1 = sc.nextInt();
				System.out.println("\tSecond Number: ");
				int guess2 = sc.nextInt();
				System.out.println("\tThird Number: ");
				int guess3 = sc.nextInt();

				if(guess1 == guess2 || guess1 == guess3 || guess2 == guess3) {
					System.out.println("It appears that you guessed the same number multiple times. Please make all digits different.");
				}
				else {
					if(guess1 == num1) {
						correctPos += 1;
						correctNum += 1;
					}
					if(guess2 == num2) {
						correctPos += 1;
						correctNum += 1;
					}
					if(guess3 == num3){
						correctPos += 1;
						correctNum += 1;
					}
					if(guess1 == num2 || guess1 == num3) {
						correctNum += 1;
					}
					if(guess2 == num1 || guess2 == num3) {
						correctNum += 1;
					}
					if(guess3 == num1 || guess3 == num2) {
						correctNum += 1;
					}
					
					guess += 1;

					System.out.println("You have " + correctPos + " correct position(s) and " + correctNum + " correct number(s)");

					if(correctPos == 3 && correctNum == 3) {
						System.out.println("Congratulations! You guessed the number!" 
								+ "\nWould you like to play again? (Y/N)");
						sc.nextLine();
						playAgain = sc.nextLine();
					
				}


				}
				correctPos = 0;
				correctNum = 0;
			}
		}

	}

}
