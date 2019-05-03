package dp;

import java.util.Arrays;
import java.util.Scanner;

public class Exam9084 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[] answer = new int[T];
		while (T-- > 0) {
			int N = sc.nextInt();
			int[] coin = new int[N];
			for (int i = 0; i < N; i++) {
				coin[i] = sc.nextInt();
			}
			int M = sc.nextInt();
			int[] dp = new int[M + 1];
			Arrays.fill(dp, 0);

			
			dp[0] = 1;
			for (int j = 0; j < N; j++) {
				for(int i=0;i<M;i++) {
					if(dp[i]>0 && i+coin[j]<=M) {
						dp[i+coin[j]]+=dp[i];
					}
				}
			}

			answer[T] = dp[M];
		}

		for (int i = answer.length - 1; i >= 0; i--) {
			System.out.println(answer[i]);
		}

		sc.close();
	}
}
