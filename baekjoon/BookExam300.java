import java.util.Scanner;

public class BookExam300 {
	static int N;
	static int K;
	static int M = 2000000000;
	static int[] arr;
	static int[] cache;
	static int[] cacheCnt;
	static int[] answer;
	static int idx = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N];
		cache = new int[N];
		cacheCnt = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			cache[i] = -1;
			cacheCnt[i] = -1;
		}
		sc.close();
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, lis(i));
		}
		System.out.println(max);

		for (int i = 0; i < N; i++) {
			if (count(i) > K) {
				answer = new int[lis(i)];
				construct(i);
				break;
			} else {
				K -= count(i);
			}
		}

		for (int i : answer)
			System.out.print(i + " ");
	}

	// start에서 시작하는 최대 증가 부분 수열의 길이
	static int lis(int start) {
		if (start == N - 1) {
			return 1;
		}
		if (cache[start] != -1) {
			return cache[start];
		}
		int ret = 1;
		for (int next = start + 1; next < N; next++) {
			if (arr[start] < arr[next]) {
				ret = Math.max(ret, lis(next) + 1);
			}
		}
		cache[start] = ret;
		return ret;
	}

	// start의 최대 증가 부분 수열의 갯수 반환.
	static int count(int start) {
		if (lis(start) == 1)
			return 1;
		if (cacheCnt[start] != -1)
			return cacheCnt[start];

		int ret = 0;
		for (int next = start + 1; next < N; next++) {
			if (arr[start] < arr[next] && lis(start) == lis(next) + 1) {
				ret = Math.min(M, ret + count(next));
			}
		}
		cacheCnt[start] = ret;
		return ret;
	}

	static void construct(int start) {
		answer[++idx] = arr[start];

		if (K <= 0) {
			return;
		}

		for (int next = start + 1; next < N; next++) {
			if (arr[start] < arr[next] && lis(start) - 1 == lis(next)) {
				if (K > count(next)) {
					K -= count(next);
					continue;
				} else {
					construct(next);
				}
			}
		}
	}

}
