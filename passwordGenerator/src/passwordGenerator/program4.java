package passwordGenerator;

public class program4 {

	public static void main(String[] args) {
		String[] passwords = new String[100];

		for (int i = 0; i < passwords.length; i++) {
			String password = generatePassword();
			while (!isUnique(passwords, password)) {
				password = generatePassword();
			}
			passwords[i] = password;
		}

		for (String password : passwords) {
			System.out.println(password);
		}
	}

	public static String generatePassword() {
		String password = "";
		for (int i = 0; i < 3; i++) {
			password += (char) (Math.random() * 26 + 'A');
		}

		for (int i = 0; i < 3; i++) {
			password += (char) (Math.random() * 26 + 'a');
		}

		for (int i = 0; i < 3; i++) {
			password += (int) (Math.random() * 10);
		}
		for (int i = 0; i < 3; i++) {
	        char randomChar = (char) (Math.random() * 94 + 33);
	        while (randomChar >= 'A' && randomChar <= 'Z' ||
	               randomChar >= 'a' && randomChar <= 'z' ||
	               randomChar >= '0' && randomChar <= '9') {
	            randomChar = (char) (Math.random() * 94 + 33);
	        }
	        password += randomChar;
		}
		return password;
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
