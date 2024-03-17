package passwordGenerator;

import java.util.Scanner;

public class program7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numberOfChar,upperCount,lowerCaseCount,symbolsCount,digitsCount;
		do {
			System.out.println("How many characters will the password be?");
			numberOfChar = input.nextInt();
			System.out.println("what is the minimum number of capital letters in the password?");
			upperCount = input.nextInt();
			System.out.println("How many lowercase letters will be at least in the password?");
			lowerCaseCount = input.nextInt();
			System.out.println("How many symbols will be at least in the password?");
			symbolsCount = input.nextInt();
			System.out.println("What is the minimum number of digits in the password?");
			digitsCount = input.nextInt();
			if (numberOfChar<(upperCount+lowerCaseCount+symbolsCount+digitsCount)) {
				System.out.println("Invalid input.");
				System.out.println("The total number of characters in the password must be greater to "
						+ "the sum of the minimum counts for each type.");
			}
		} while (numberOfChar<(upperCount+lowerCaseCount+symbolsCount+digitsCount));
		
			
		String[] passwords = new String[100];
			for (int i = 0; i < passwords.length; i++) {
				String password = generatePassword(numberOfChar,upperCount,lowerCaseCount,symbolsCount,digitsCount);
				while (!isUnique(passwords, password)) {
					password = generatePassword(numberOfChar,upperCount,lowerCaseCount,symbolsCount,digitsCount);
				}
				passwords[i] = password;
			}
			
			for (int i = 0; i < passwords.length; i++) {
				System.out.println("Password " + (i + 1) + " : " + passwords[i]);
			}
		}
		


	public static String generatePassword(int numberOfChar, int upperCount, int lowerCaseCount, int symbolsCount, int digitsCount) {
		String[] password = new String[numberOfChar];
		String passwordd = "";
		int upperCase = upperCount, lowerCase = lowerCaseCount, specialChar = symbolsCount, digit = digitsCount;
		String upperCases = "", lowerCases = "", digits = "", specialChars = "";
		int num = numberOfChar - (upperCount+lowerCaseCount + symbolsCount+ digitsCount);

		for (int i = 0; i < num; i++) {

			int type = (int) (Math.random() * 4);
			switch (type) {
			case 0:
				password[i] = RandomGenerateCase();
				upperCases += password[i] + ",";
				upperCase++;
				break;

			case 1:
				password[i] = RandomGenerateLowerCase();
				lowerCases += password[i] + ",";
				lowerCase++;
				break;

			case 2:
				password[i] = GenerateRandomDigits();
				digits += password[i] + ",";

				digit++;

				break;

			case 3:

				password[i] = GenerateRandomSymbol();
				specialChars += password[i] + ",";
				specialChar++;
				break;
			}

		}
		if(upperCount>0) {
			for (int i = num; i < num + upperCount; i++) {
				password[i] = RandomGenerateCase();
				upperCases += password[i] + ",";
			}
			
		}
		if(lowerCaseCount>0) {
			
			for (int i = num+upperCount ; i < num+upperCount+lowerCaseCount; i++) {
				password[i] = RandomGenerateLowerCase();
				lowerCases += password[i] + ",";
			}
		}
		if(digitsCount>0) {
			
			for (int i = num+upperCount+lowerCaseCount; i <num+upperCount+lowerCaseCount+digitsCount; i++) {
				password[i] = GenerateRandomDigits();
				digits += password[i] + ",";
			}
		}
		if(symbolsCount>0) {
			for (int i = num+upperCount+lowerCaseCount+digitsCount; i < numberOfChar; i++) {
				password[i] = GenerateRandomSymbol();
				specialChars += password[i] + ",";
			}
			
		}


		for (int i = 0; i < password.length - 1; i++) {
			int j = (int) (Math.random() * password.length);
			String temp = password[i];
			password[i] = password[j];
			password[j] = temp;
		}
		for (int i = 0; i < password.length; i++) {
			passwordd += password[i];
		}
		if (upperCases.length() > 0) {
		   upperCases= upperCases.substring(0, upperCases.length() - 1);
		}
		if (lowerCases.length() > 0) {
			lowerCases= lowerCases.substring(0, lowerCases.length() - 1);
		}
		if (digits.length() > 0) {
			digits= digits.substring(0, digits.length() - 1);
		}
		if (specialChars.length() > 0) {
			specialChars= specialChars.substring(0, specialChars.length() - 1);
		}


		return passwordd + "   " + upperCase + "(" + upperCases + ") - "
				+ lowerCase + "(" +lowerCases + ") - " + digit + "("
				+digits + ") - " + specialChar + "("
				+ specialChars + ")";

	}

	public static String RandomGenerateCase() {

		char randomchar = (char) (Math.random() * 26 + 'A');
		return String.valueOf(randomchar);

	}

	public static String RandomGenerateLowerCase() {

		char randomchar = (char) (Math.random() * 26 + 'a');
		return String.valueOf(randomchar);

	}

	public static String GenerateRandomDigits() {

		int randomchar = (int) (Math.random() * 10);
		return String.valueOf(randomchar);

	}

	public static String GenerateRandomSymbol() {

		char randomchar = (char) (Math.random() * 94 + 33);
		while (randomchar >= 'A' && randomchar <= 'Z' || randomchar >= 'a' && randomchar <= 'z'
				|| randomchar >= '0' && randomchar <= '9') {
			randomchar = (char) (Math.random() * 94 + 33);
		}
		return String.valueOf(randomchar);

	}

	public static boolean isUnique(String[] passwords, String password) {
		for (int i = 0; i < passwords.length; i++) {
			if (passwords[i] != null && passwords[i].equals(password)) {
				return false;
			}
		}
		return true;
	}


}
