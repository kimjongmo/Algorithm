package dp;

import java.util.Arrays;
import java.util.Scanner;

public class Exam5557 {

	static int N;
	static int[] arr;
	static long[][] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		arr = new int[N];
		cache = new long[21][N];

		for (int i = 0; i < 21; i++) {
			Arrays.fill(cache[i], -1);
		}

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(next(arr[0],1));
		sc.close();
	}

	static long next(int number, int now) {
		if (cache[number][now] != -1)
			return cache[number][now];
		if (now == N - 1) {
			return (number == arr[now]) ? 1 : 0;
		}

		long ret = 0;

		if (number + arr[now] < 21)
			ret += next(number + arr[now], now + 1);

		if (number - arr[now] >= 0)
			ret += next(number - arr[now], now + 1);

		cache[number][now] = ret;
		return ret;
	}
}
