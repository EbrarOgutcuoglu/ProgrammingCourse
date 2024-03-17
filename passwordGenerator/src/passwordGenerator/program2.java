package passwordGenerator;

public class program2 {
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
		System.out.println("17576 different passwords can be generated with a 3-random uppercase characters.");
		

	}

	public static String generatePassword() {
	    String password = "";
	    for (int i = 0; i < 3; i++) {
		password += (char) (Math.random() * 26 + 'A');
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
