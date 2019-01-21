import java.util.Scanner;

public class Exam2167 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n + 1][m + 1];
		int[][] S = new int[n + 1][m + 1];

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (i > 1 && j > 1)
					S[i][j] = S[i - 1][j] + S[i][j - 1] - S[i - 1][j - 1] + arr[i][j];
				else if (i == 1)
					S[i][j] = S[i][j - 1] + arr[i][j];
				else if (j == 1)
					S[i][j] = S[i - 1][j] + arr[i][j];
			}
		}

		int k = sc.nextInt();
		int[] answer = new int[k];
		for (int t = 0; t < k; t++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			answer[t] = S[x][y] - S[x][j - 1] - S[i - 1][y] + S[i - 1][j - 1];
		}

		for(int a : answer)
			System.out.println(a);
		sc.close();
	}
}
