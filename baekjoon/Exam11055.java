import java.util.Scanner;

public class Exam11055 {
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
			return arr[start];
		
		if(cache[start]!=-1)
			return cache[start];
		
		int max = arr[start];
		for (int j = start+1; j < n; j++) {
			if(arr[start]<arr[j]) {
				max = Math.max(max,blis(j)+arr[start]);
			}
		}
		cache[start]=max;
		return max; 
	}
}
