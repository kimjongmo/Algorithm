import java.util.Scanner;

public class Exam14501 {
	static int N;
	static int[] time;
	static int[] price;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		time = new int[N+1];
		price = new int[N+1];
		dp = new int[N+1];
		for(int i=1;i<=N;i++) {
			time[i] = sc.nextInt();
			price[i] = sc.nextInt();
		}
		
		sc.close();
		dp[0] = 0;
		for(int i=1;i<N+1;i++) {
			dp[i] = Math.max(dp[i], dp[i-1]);
			if(i+time[i]-1<=N) {
				dp[i+time[i]-1]=Math.max(dp[i+time[i]-1], price[i]+dp[i-1]);
				
			}
		}
		int max = 0;
		for(int i=1;i<=N;i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
	}
	
}
