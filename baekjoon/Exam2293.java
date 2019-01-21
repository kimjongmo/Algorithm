import java.util.Scanner;

public class Exam2293 {
	static int n;
	static int k;
	static int[] coin;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt();
		coin = new int[n];
		dp = new int[k+1];
		
		for (int i = 0; i < n; i++) {
			coin[i] = sc.nextInt();
		}
		sc.close();
		
		dp[0]=1;
		for(int i=0;i<n;i++) {
			for(int j=1;j<k+1;j++) {
				if(j>=coin[i]) {
					dp[j] += dp[j-coin[i]];
				}
			}
		}
		System.out.println(dp[k]);
	}



}
/*
 * 3 1 1 2 5
 */

//2 1
