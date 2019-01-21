import java.util.Scanner;

public class Exam9465 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] answer = new int[T];
		for(int i=0;i<T;i++) {
			int N = sc.nextInt();
			int[][] arr = new int[2][N];
			int[][] dp = new int[2][N];
			
			for(int j=0;j<N;j++) {
				arr[0][j] = sc.nextInt();
			}
			
			for(int j=0;j<N;j++) {
				arr[1][j] = sc.nextInt();
			}
			
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			dp[0][1] = dp[1][0]+arr[0][1];
			dp[1][1] = dp[0][0]+arr[1][1];
			
			for(int j=2;j<N;j++) {
				dp[0][j] = Math.max(dp[1][j-1],Math.max(dp[0][j-2], dp[1][j-2]))+arr[0][j];
				dp[1][j] = Math.max(dp[0][j-1],Math.max(dp[0][j-2], dp[1][j-2]))+arr[1][j];
			}
			answer[i] = Math.max(dp[0][N-1], dp[1][N-1]);
		}
		sc.close();
		for(int a : answer) {
			System.out.println(a);
		}
	}
}
