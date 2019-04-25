import java.util.Arrays;
import java.util.Scanner;

public class Exam1965 {

	static int n;
	static int[] arr;
	static int[] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		cache = new int[n];
		Arrays.fill(cache, -1);

		int max = 0;
		for(int i=0;i<n;i++) {
			max = Math.max(max, lis(i));
		}
		
		System.out.println(max);
		sc.close();
	}

	static int lis(int start) {
		if (start == n - 1)
			return 1;

		if (cache[start] != -1)
			return cache[start];

		
		int ret = 1;
		
		for (int next = start + 1; next < n; next++) {
			if(arr[start]<arr[next]) {
				ret = Math.max(ret,lis(next)+1);
			}
		}
		
		cache[start] = ret;
		
		return ret;
	}
}
