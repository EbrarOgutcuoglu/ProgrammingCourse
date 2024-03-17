import java.util.Random;

public class ExamEvaluationSystem {

	public static void main(String[] args) {
		Random random = new Random();
		char[] keys = new char[50];
		for (int i = 0; i < keys.length; i++) {
			keys[i] = (char) (Math.random() * 4 + 'A');
		}

		char[][] answers = new char[100][50];

		for (int i = 0; i < answers.length; i++) {
			for (int j = 0; j < answers[0].length; j++) {
				int number = random.nextInt(5);
				switch (number) {
				case 0: {

					answers[i][j] = 'A';
					break;
				}
				case 1: {

					answers[i][j] = 'B';
					break;
				}
				case 2: {

					answers[i][j] = 'C';
					break;
				}
				case 3: {

					answers[i][j] = 'D';
					break;
				}
				case 4: {
					answers[i][j] = ' ';
					break;
				}

				}
			}

		}

		double[] grades = new double[100];
		for (int i = 0; i < answers.length; i++) {
			int correctCount = 0, incorrectCount = 0, empytCount = 0;
			for (int j = 0; j < answers[0].length; j++) {

				if (answers[i][j] == keys[j]) {
					correctCount++;
				} else if (answers[i][j] == ' ') {
					empytCount++;
				} else {
					incorrectCount++;
				}
			}
			double answer = answerGenerator(correctCount, incorrectCount);
			grades[i] = answer;
			System.out.print("Student " + (i + 1) + ": " + correctCount + " Correct, " + incorrectCount + " Incorrect, "
					+ empytCount + " Empty");
			System.out.printf("  Answer=%.2f", answer);
			System.out.println(" points");

		}
		System.out.printf("Max grade: %.2f\n", maxGrade(grades));
		System.out.printf("Min grade: %.2f\n", minGrade(grades));
		System.out.printf("Average grade: %.2f\n", averageGrade(grades));

	}

	public static double answerGenerator(int correctCount, int incorrectCount) {

		if (correctCount <= (incorrectCount / 3)) {
			return 0;
		}
		int result = (correctCount - (incorrectCount / 3)) * 2 - 1;
		if (incorrectCount % 3 == 0) {
			return result + 1;
		} else {
			double remain = (3 - (incorrectCount % 3)) * 0.33;
			return result + remain;

		}

	}

	public static double maxGrade(double[] grades) {
		double max = 0;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] > max) {
				max = grades[i];
			}
		}
		return max;

	}

	public static double minGrade(double[] grades) {
		double min = grades[0];
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] < min) {
				min = grades[i];
			}
		}
		return min;
	}

	public static double averageGrade(double[] grades) {
		double sum = 0;
		for (int i = 0; i < grades.length; i++) {
			sum += grades[i];
		}
		if (sum / 100 > 0)
			return sum / 100;
		else
			return 0;

	}

}
