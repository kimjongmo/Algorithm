import java.util.Scanner;

public class Exam2096 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] board = new int[n][3];
		int[][] dpMax = new int[n][3];
		int[][] dpMin = new int[n][3];

		for (int i = 0; i < n; i++) {
			board[i][0] = sc.nextInt();
			board[i][1] = sc.nextInt();
			board[i][2] = sc.nextInt();
		}

		sc.close();

		dpMax[0][0] = board[0][0];
		dpMax[0][1] = board[0][1];
		dpMax[0][2] = board[0][2];

		dpMin[0][0] = board[0][0];
		dpMin[0][1] = board[0][1];
		dpMin[0][2] = board[0][2];

		for (int i = 1; i < n; i++) {
			dpMax[i][0] = Math.max(dpMax[i - 1][0], dpMax[i - 1][1]) + board[i][0];
			dpMax[i][1] = Math.max(dpMax[i - 1][2], Math.max(dpMax[i - 1][0], dpMax[i - 1][1])) + board[i][1];
			dpMax[i][2] = Math.max(dpMax[i - 1][1], dpMax[i - 1][2]) + board[i][2];

			dpMin[i][0] = Math.min(dpMin[i - 1][0], dpMin[i - 1][1]) + board[i][0];
			dpMin[i][1] = Math.min(dpMin[i - 1][2], Math.min(dpMin[i - 1][0], dpMin[i - 1][1])) + board[i][1];
			dpMin[i][2] = Math.min(dpMin[i - 1][1], dpMin[i - 1][2]) + board[i][2];
		}

		int max = Math.max(dpMax[n - 1][0], Math.max(dpMax[n - 1][1], dpMax[n - 1][2]));
		int min = Math.min(dpMin[n - 1][0], Math.min(dpMin[n - 1][1], dpMin[n - 1][2]));
		System.out.println(max + " " + min);
	}
}
