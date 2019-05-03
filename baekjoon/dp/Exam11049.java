package dp;

import java.util.Arrays;
import java.util.Scanner;

public class Exam11049 {
	static int N;
	static int[][] arr;
	static long[][] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N][2];
		cache = new long[N][N];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			Arrays.fill(cache[i],-1);
		}

		sc.close();

		System.out.println(merge(0,N-1));
	}
	
	static long merge(int start, int end) {
		if(cache[start][end]!=-1)
			return cache[start][end];
		
		if(start==end)
			return 0;
		
		long ret = Long.MAX_VALUE;
		
		for(int i=start;i<end;i++) {
			ret = Math.min(ret, merge(start,i)+merge(i+1,end)+arr[start][0]*arr[i][1]*arr[end][1]);
		}
		
		cache[start][end] = ret;
		return ret;
	}

}
