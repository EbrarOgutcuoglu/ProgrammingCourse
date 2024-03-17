package mastermindProgram;

import java.util.Random;
import java.util.Scanner;

public class program1_mastermind {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int randomnumber, temp, unitDigits, tensDigits, hundredDigits, thousandsDigits;
		do {
			randomnumber = random.nextInt(8854) + 1023;
			temp = randomnumber;
			unitDigits = temp % 10;
			temp = temp / 10;
			tensDigits = temp % 10;
			temp = temp / 10;
			hundredDigits = temp % 10;
			thousandsDigits = temp / 10;

		} while ((unitDigits == tensDigits || unitDigits == hundredDigits || unitDigits == thousandsDigits
				|| tensDigits == hundredDigits || tensDigits == thousandsDigits || hundredDigits == thousandsDigits));
		String result;
		int i = 1;

		System.out.println("I kept a four-digit number Please try to find it");
		do {
			if(i==1) {
				
				System.out.print("Your "+ i + "st Prediction:");
			}else if (i==2) {
				System.out.print("Your "+ i + "nd Prediction:");
				
			}else if (i==3) {
				System.out.print("Your "+ i + "rd Prediction:");
				
			}else {
				System.out.print("Your "+ i + "th Prediction:");
				
			}
			int data = scanner.nextInt();
			result = findMatching(data, randomnumber);
			if (result.equals("+4")) {
				if(i==1) {
					
					System.out.println("CONGRATULATIONS!!! YOU WIN ON YOUR  " + i + "ST PREDICTION");
				}else if (i==2) {
					
					System.out.println("CONGRATULATIONS!!! YOU WIN ON YOUR  " + i + "ND PREDICTION");
				}else if (i==3) {
					System.out.println("CONGRATULATIONS!!! YOU WIN ON YOUR  " + i + "RD PREDICTION");
					
				}else {
					
					System.out.println("CONGRATULATIONS!!! YOU WIN ON YOUR  " + i + "TH PREDICTION");
				}

			} else {

				System.out.println(result);
			}
			if (result.equals("Enter a valid Number")) {
				i--;
			}
			i++;
		} while (!(result.equals("+4")));

	}

	public static String findMatching(int data, int number) {
		int temp, unitDigits, tensDigits, hundredDigits, thousandsDigits;

		temp = number;
		unitDigits = temp % 10;
		temp = temp / 10;
		tensDigits = temp % 10;
		temp = temp / 10;
		hundredDigits = temp % 10;
		thousandsDigits = temp / 10;

		int temp2, units, tens, hundreds, thousands;
		int matchingCount = 0, notMatchingCount = 0;
		temp2 = data;
		units = temp2 % 10;
		temp2 = temp2 / 10;
		tens = temp2 % 10;
		temp2 = temp2 / 10;
		hundreds = temp2 % 10;
		thousands = temp2 / 10;
		if (thousands>10|| thousands==0|| units == tens ||units == hundreds || units == thousands || tens == hundreds || tens == thousands
				|| hundreds == thousands) {
			String result = "Enter a valid Number";
			return result;
		} else

		if (unitDigits == units) {
			matchingCount++;
		} else if (unitDigits == hundreds || unitDigits == thousands || unitDigits == tens) {
			notMatchingCount--;
		}
		if (tensDigits == tens) {
			matchingCount++;
		} else if (tensDigits == units || tensDigits == hundreds || tensDigits == thousands) {
			notMatchingCount--;
		}
		if (hundredDigits == hundreds) {
			matchingCount++;
		} else if (hundredDigits == units || hundredDigits == tens || hundredDigits == thousands) {
			notMatchingCount--;
		}
		if (thousandsDigits == thousands) {
			matchingCount++;
		} else if (thousandsDigits == units || thousandsDigits == tens || thousandsDigits == hundreds) {
			notMatchingCount--;
		}
		if (matchingCount == 0) {
			return String.valueOf(notMatchingCount);
		} else if (notMatchingCount == 0) {
			return "+" + String.valueOf(matchingCount);
		} else {

			return "+" + String.valueOf(matchingCount) + " " + String.valueOf(notMatchingCount);
		}

	}


}
