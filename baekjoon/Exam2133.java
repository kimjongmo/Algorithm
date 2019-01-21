import java.util.Scanner;

public class Exam2133 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		if(N%2==1) {
			System.out.println(0);
			return;
		}

		int[] dp = new int[N + 1];
		dp[0] = 1;
		dp[2] = 3;

		for (int i = 4; i <= N; i+=2) {
			dp[i] = dp[i - 2] * 3;
			for(int j=4;j<=i;j+=2)
				dp[i]+=2*dp[i-j];
			
		}
		System.out.println(dp[N]);

	}
}
