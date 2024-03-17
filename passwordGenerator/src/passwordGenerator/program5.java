package passwordGenerator;

public class program5 {
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
		System.out.println("1,293*10³⁰ different passwords can be generated.");
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
				password[i] = String.valueOf((char) (Math.random() * 26 + 'A'));
				upperCases += password[i] + ",";
				upperCase++;
				break;

			case 1:
				password[i] = String.valueOf((char) (Math.random() * 26 + 'a'));
				lowerCases += password[i] + ",";
				lowerCase++;
				break;

			case 2:
				password[i] = String.valueOf((int) (Math.random() * 10));
				digits += password[i] + ",";

				digit++;

				break;

			case 3:
				char randomchar = (char) (Math.random() * 94 + 33);
				password[i] = String.valueOf(randomchar);
				while (randomchar >= 'A' && randomchar <= 'Z' || randomchar >= 'a' && randomchar <= 'z'
						|| randomchar >= '0' && randomchar <= '9') {
					randomchar = (char) (Math.random() * 94 + 33);
					password[i] = String.valueOf(randomchar);
				}
				specialChars += password[i] + ",";
				specialChar++;
				break;
			}

		}
		for (int i = 3; i < 6; i++) {
			password[i] = String.valueOf((char) (Math.random() * 26 + 'A'));
			upperCases += password[i] + ",";
		}
		for (int i = 6; i < 9; i++) {
			password[i] = String.valueOf((char) (Math.random() * 26 + 'a'));
			lowerCases += password[i] + ",";
		}
		for (int i = 9; i < 12; i++) {
			password[i] = String.valueOf((int) (Math.random() * 10));
			digits += password[i] + ",";
		}

		for (int i = 12; i < 15; i++) {
			char randomchar = (char) (Math.random() * 94 + 33);
			password[i] = String.valueOf(randomchar);
			while (randomchar >= 'A' && randomchar <= 'Z' || randomchar >= 'a' && randomchar <= 'z'
					|| randomchar >= '0' && randomchar <= '9') {
				randomchar = (char) (Math.random() * 94 + 33);
				password[i] = String.valueOf(randomchar);
			}
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

	public static boolean isUnique(String[] passwords, String password) {
		for (int i = 0; i < passwords.length; i++) {
			if (passwords[i] != null && passwords[i].equals(password)) {
				return false;
			}
		}
		return true;
	}
}
