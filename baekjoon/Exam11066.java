import java.util.Arrays;
import java.util.Scanner;

public class Exam11066 {

	static int[] arr;
	static int[][] cache;//합성 비용
	static int[][] s;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t, k;
		t = sc.nextInt();

		while (t-- > 0) {
			k = sc.nextInt();
			arr = new int[k];
			cache = new int[k][k];
			s = new int[k][k];
			
			// 입력
			for (int i = 0; i < k; i++) {
				arr[i] = sc.nextInt();
				Arrays.fill(cache[i], -1);
				Arrays.fill(s[i], -1);
				cache[i][i] = 0;
			}
			
			System.out.println(cost(0,k-1));

		}
		sc.close();
	}

	// start ~ end까지 합성하는데에 필요한 총량
	static int cost(int start, int end) {
		// start == end || 이미 계산된 것
		if (cache[start][end] != -1)
			return cache[start][end];

		int ret = Integer.MAX_VALUE;

		for (int i = start; i < end; i++) {
			ret = Math.min(ret, cost(start, i) + cost(i + 1, end));
		}
		ret += sum(start,end);
		cache[start][end] = ret;

		return ret;
	}

	static int sum(int start, int end) {
		if(s[start][end]!=-1)
			return s[start][end];
		
		int sum = 0;
		
		for (int i = start; i <= end; i++) {
			sum += arr[i];
		}
		
		s[start][end] = sum;
		
		return sum;

	}
}
