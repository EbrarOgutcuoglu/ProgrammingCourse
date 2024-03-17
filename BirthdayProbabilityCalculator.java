
public class BirthdayProbabilityCalculator {

	public static void main(String[] args) {
		int[][][] studentsData = new int[1000][30][2];

		for (int row = 0; row < studentsData.length; row++) {
			for (int column = 0; column < studentsData[0].length; column++) {
				for (int i = 0; i < studentsData[0][0].length; i++) {
					if (i == 0)
						studentsData[row][column][i] = (int) (Math.random() * 30 + 1);

					else
						studentsData[row][column][i] = (int) (Math.random() * 12 + 1);
				}
			}
		}

		int result = sameBithdayClass(studentsData);
		double possible = (double) result / studentsData.length * 100;
		System.out.println(
				"The probability that any two students in a class of 30 students will share the same birthday is "
						+ possible + "%");

	}

	public static int sameBithdayClass(int[][][] studentsData) {
		int classCount = 0;
		for (int row = 0; row < studentsData.length; row++) {
			int same = 0;
			for (int i = 0; i < studentsData[row].length; i++) {
				for (int j = i + 1; j < studentsData[row].length; j++) {
					if (studentsData[row][i][0] == studentsData[row][j][0]
							&& studentsData[row][i][1] == studentsData[row][j][1]) {
						same++;
					}
				}

			}
			if (same > 0) {
				classCount++;
			}
		}
		return classCount;
	}

}
