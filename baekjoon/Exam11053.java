import java.util.Scanner;

public class Exam11053 {
	static int n;
	static int[] arr;
	static int[] cache;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		cache = new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		for(int i=0;i<n;i++)
			cache[i]=-1;
		
		int max = 0;
		for(int i=0;i<n;i++)
			max = Math.max(max, lis(i));

		System.out.println(max);
		
		sc.close();
	}
	static int lis(int start) {
		if(cache[start] != -1) {
			return cache[start];
		}
		if(start == n-1) {
			return 1;
		}
		int ret = 1;//
		for(int i=start+1;i<n;i++) {
			if(arr[start]<arr[i]) {
				ret = Math.max(ret, lis(i)+1);
			}
		}
		cache[start] = ret;
		return ret;
	}
	
}
