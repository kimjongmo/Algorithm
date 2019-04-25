import java.util.Arrays;
import java.util.Scanner;

public class Exam11504 {
	static int n;
	static int[] arr;
	static int[] rlisCache;
	static int[][] lisCache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		arr = new int[n];

		rlisCache = new int[n];
		Arrays.fill(rlisCache, -1);

		lisCache = new int[n][n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			Arrays.fill(lisCache[i], -1);
		}

		int max = 0;
		for (int base = 0; base < n; base++) {
			int max_lis = 0;
			for (int i = 0; i <= base; i++) {
				max_lis = Math.max(max_lis, lis(i, base));
			}
			max = Math.max(max, max_lis + rlis(base) - 1);
		}
		System.out.println(max);
		sc.close();
	}

	// ������ start<= lis() <end
	static int lis(int start, int end) {
		if (lisCache[start][end] != -1)
			return lisCache[start][end];
		if (start == end)
			return 1;

		int ret = 1;

		for (int next = start + 1; next <= end; next++) {
			if (arr[start] < arr[next]) {
				ret = Math.max(ret, lis(next, end) + 1);
			}
		}
		lisCache[start][end] = ret;
		return ret;
	}

	// ��������
	static int rlis(int start) {
		if(rlisCache[start]!=-1) {
			return rlisCache[start];
		}
		if (start == n - 1)
			return 1;

		int ret = 1;

		for (int next = start + 1; next < n; next++) {
			if (arr[start] > arr[next]) {
				ret = Math.max(ret, rlis(next) + 1);
			}
		}
		
		rlisCache[start] = ret;
		
		return ret;
	}
}
