import java.util.Scanner;

public class Exam11722 {
	static int n;
	static int[] arr;
	static int[] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		arr = new int[n];
		cache = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			cache[i] = -1;
		}
		sc.close();
		
		int max = 0;
		for(int i=0;i<n;i++) {
			max = Math.max(max,blis(i));
		}
		System.out.println(max);
	}

	static int blis(int start) {
		if(start == n-1)
			return 1;
		
		if(cache[start]!=-1)
			return cache[start];
		
		int max = 1;
		for (int j = start+1; j < n; j++) {
			if(arr[start]<arr[j]) {
				max = Math.max(max,blis(j)+1);
			}
		}
		cache[start]=max;
		return max; 
	}
}
