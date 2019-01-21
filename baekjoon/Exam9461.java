import java.util.Scanner;

public class Exam9461 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] answer = new long[T];
		
		for(int i=0;i<T;i++) {
			int N = sc.nextInt();
			long[] dp = new long[N];
			if(N<3) {
				answer[i] = 1;
				continue;
			}
			
			dp[0]=dp[1]=dp[2]=1;
			
			for(int j=3;j<N;j++) {
				dp[j] = dp[j-2]+dp[j-3];
			}
			answer[i] = dp[N-1];
		}
		sc.close();
		
		for(long a : answer)
			System.out.println(a);
	}
}
