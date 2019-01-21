import java.util.Scanner;

public class Exam1699 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		
		dp[0]=1;
		dp[1]=1;
		
		for(int i=2;i<=N;i++) {
			double d = Math.sqrt(i);
			if(d == (int)d) {
				dp[i] = 1;
			}else {
				dp[i]=i;
				for(int j=1;j<=(int)d;j++)
					dp[i] = Math.min(dp[i], dp[j*j]+dp[i-j*j]);
			}
		}
		
		System.out.println(dp[N]);
		sc.close();
	}
}
