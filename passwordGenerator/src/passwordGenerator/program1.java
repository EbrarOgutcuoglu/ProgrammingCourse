package passwordGenerator;

import java.util.Random;

public class program1 {
	public static void main(String[] args) {
		Random random =new Random();
		String[] passwords = new String[100];

		for (int i = 0; i < passwords.length; i++) {
			int randomnumber= random.nextInt(900)+100;
			String password =String.valueOf(randomnumber);
			while (!isUnique(passwords, password)) { 
				randomnumber= random.nextInt(900)+100;
				password = String.valueOf(randomnumber);
			}
			passwords[i] = password;
		}

		for (String password : passwords) {
			System.out.println(password);
		}
		System.out.println("900 different passwords can be generated with a 3-digit number");
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
