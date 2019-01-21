package git_Algorithm;

import java.util.Scanner;

public class Exam1003 {
	static int[] n;
	static int[][] cache;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int max = 0;
		n = new int[count];
		for(int i=0;i<count;i++) {
			n[i]=sc.nextInt();
			max = Math.max(max, n[i]);
		}
		
		
		cache = new int[max + 1][2];

		cache[1][1] = cache[0][0] = 1;
		cache[1][0] = cache[0][1] = 0;

		for (int i = 2; i < max + 1; i++) {
			cache[i][0] = cache[i - 1][0] + cache[i - 2][0];
			cache[i][1] = cache[i - 1][1] + cache[i - 2][1];
		}

		
		for(int i=0;i<count;i++) {
			System.out.println(cache[n[i]][0]+" "+cache[n[i]][1]);
		}
		
		
		sc.close();
	}

}
