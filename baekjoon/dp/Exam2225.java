package dp;

import java.util.Scanner;

public class Exam2225 {
	static int N, K;
	static int[][] cache;
	static final int M = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		sc.close();

		cache = new int[N + 1][K];
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < K; j++) {
				cache[i][j] = -1;
			}
		}

		int sum = 0;
		for (int i = 0; i <= N; i++) {
			sum += next(i, 0);
			sum %= M;
		}
		System.out.println(sum);

	}

	// ���� ��,���ݱ��� ī��Ʈ
	static long next(int now, int count) {

		if (count == K - 1) {
			return (now == N) ? 1 : 0;
		}

		if (cache[now][count] != -1)
			return cache[now][count];
		int ret = 0;

		for (int i = 0; i <= N; i++) {
			if (now + i <= N) {
				ret += next(now + i, count + 1);
				ret %= M;
			}
		}

		cache[now][count] = ret;

		return ret;
	}
}
