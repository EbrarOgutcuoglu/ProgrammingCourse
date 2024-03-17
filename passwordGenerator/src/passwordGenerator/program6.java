package passwordGenerator;

public class program6 {
	public static void main(String[] args) {
		String[] passwords = new String[100];

		for (int i = 0; i < passwords.length; i++) {
			String password = generatePassword();
			while (!isUnique(passwords, password)) {
				password = generatePassword();
			}
			passwords[i] = password;
		}

		for (int i = 0; i < passwords.length; i++) {
			System.out.println("Password " + (i + 1) + " : " + passwords[i]);
		}
	}

	public static String generatePassword() {
		String[] password = new String[15];
		String passwordd = "";
		int upperCase = 3, lowerCase = 3, specialChar = 3, digit = 3;
		String upperCases = "", lowerCases = "", digits = "", specialChars = "";

		for (int i = 0; i < 3; i++) {

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
		for (int i = 3; i < 6; i++) {
			password[i] = RandomGenerateCase();
			upperCases += password[i] + ",";
		}
		for (int i = 6; i < 9; i++) {
			password[i] = RandomGenerateLowerCase();
			lowerCases += password[i] + ",";
		}
		for (int i = 9; i < 12; i++) {
			password[i] = GenerateRandomDigits();
			digits += password[i] + ",";
		}

		for (int i = 12; i < 15; i++) {
			password[i] = GenerateRandomSymbol();
			specialChars += password[i] + ",";
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

		return passwordd + "\t" + upperCase + "(" + upperCases.substring(0, upperCases.length() - 1) + ") - "
				+ lowerCase + "(" + lowerCases.substring(0, lowerCases.length() - 1) + ") - " + digit + "("
				+ digits.substring(0, digits.length() - 1) + ") - " + specialChar + "("
				+ specialChars.substring(0, specialChars.length() - 1) + ")";

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
