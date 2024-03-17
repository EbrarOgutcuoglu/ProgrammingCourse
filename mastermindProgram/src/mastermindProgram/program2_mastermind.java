package mastermindProgram;

import java.util.Random;
import java.util.Scanner;

public class program2_mastermind {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please keep a four-digit number and press enter by typing OK");
		String answer = scanner.nextLine();
		
		if (answer.equals("OK") || answer.equals("ok")) {
			boolean[] validNumbers = new boolean[8854];
			int number, unitDigit, tensDigit, hundredsDigit, thousandsDigit;
			for (int i = 1023; i <= 9876; i++) {
				number = i;
				unitDigit = number % 10;
				number /= 10;
				tensDigit = number % 10;
				number /= 10;
				hundredsDigit = number % 10;
				thousandsDigit = number / 10;
				if (unitDigit != tensDigit && unitDigit != hundredsDigit && unitDigit != thousandsDigit
						&& tensDigit != hundredsDigit && tensDigit != thousandsDigit
						&& hundredsDigit != thousandsDigit) {
					validNumbers[i - 1023] = true;
				}

			}
			String input = "";
			int randomnumber;
			int i = 1;
			do {

				do {
					randomnumber = random.nextInt(validNumbers.length);

				} while (!(validNumbers[randomnumber]));
				if (i==1) {
					System.out.println("My " + i + "st Prediction : " + (randomnumber + 1023));
					
				} else if(i==2){
					System.out.println("My " + i + "nd Prediction : " + (randomnumber + 1023));

				}else if (i==3) {
					System.out.println("My " + i + "rd Prediction : " + (randomnumber + 1023));
					
				}else {
					System.out.println("My " + i + "th Prediction : " + (randomnumber + 1023));
					
				}
				
				input = scanner.nextLine();
				if (input.equals("+4")) {
					System.out.println("I found " + i + " predictions");
				} else {

					String info = "";
					for (int j = 0; j < validNumbers.length; j++) {
						if (validNumbers[j]) {
							info = findMatching((j + 1023), (randomnumber + 1023));
							if (!(info.equals(input))) {
								validNumbers[j] = false;

							}
						}
					}
				}
				i++;

			} while (!(input.equals("+4")));
		} else {
			System.out.println("Please keep a four-digit number and press enter by typing OK");
		}

	}

	public static String findMatching(int number, int guess) {
		int[] digits = { number % 10, (number / 10) % 10, (number / 100) % 10, number / 1000 };
		int[] guesses = { guess % 10, (guess / 10) % 10, (guess / 100) % 10, guess / 1000 };

		int matchingCount = 0, notMatchingCount = 0;
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] == guesses[i]) {
				matchingCount++;
			}
		}

		if (digits[0] == guesses[1] || digits[0] == guesses[2] || digits[0] == guesses[3]) {
			notMatchingCount++;
		}
		if (digits[1] == guesses[0] || digits[1] == guesses[2] || digits[1] == guesses[3]) {
			notMatchingCount++;
		}
		if (digits[2] == guesses[0] || digits[2] == guesses[1] || digits[2] == guesses[3]) {
			notMatchingCount++;
		}
		if (digits[3] == guesses[0] || digits[3] == guesses[1] || digits[3] == guesses[2]) {
			notMatchingCount++;
		}

		if (matchingCount == 0 && notMatchingCount == 0) {
			return String.valueOf(notMatchingCount);
		} else if (matchingCount == 0) {
			return "-" + String.valueOf(notMatchingCount);
		} else if (notMatchingCount == 0) {
			return "+" + String.valueOf(matchingCount);
		} else {

			return "+" + String.valueOf(matchingCount) + " -" + String.valueOf(notMatchingCount);
		}

	}


}
