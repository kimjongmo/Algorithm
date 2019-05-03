package dp;

import java.util.Scanner;

public class Exam2631 {
	static int N;
	static int[] arr;
	static int[] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N];
		cache = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]= sc.nextInt();
		}
		
		int idx = 0;
		cache[idx] = arr[0];
		
		for(int i=1;i<N;i++) {
			if(cache[idx]<arr[i]) {
				cache[++idx]=arr[i];
			}else {
				cache[binarySearch(0,idx,arr[i])]=arr[i];
			}
		}
		
		System.out.println(N-(idx+1));
		
		sc.close();
	}


	
	static int binarySearch(int start, int end, int search) {
		int mid;
		while(start<end) {
			mid = (start+end)/2;
			if(search<=cache[mid]) {
				end = mid;
			}else {
				start=mid+1;
			}
		}
		return end;
	}

}
