import java.util.Arrays;
import java.util.Scanner;

public class Exam11066 {

	static int[] arr;
	static int[][] cache;//�ռ� ���
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
			
			// �Է�
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

	// start ~ end���� �ռ��ϴµ��� �ʿ��� �ѷ�
	static int cost(int start, int end) {
		// start == end || �̹� ���� ��
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
