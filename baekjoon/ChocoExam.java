import java.util.Scanner;

public class ChocoExam {
	static int N,M;
	static int[][] cache;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		cache = new int[N+1][M+1];
		for (int i = 0; i < N+1; i++) {
			for (int j = 0; j < M+1; j++) {
				cache[i][j]=-1;
			}
		}
		System.out.println(split(N, M));
		sc.close();
	}
	
	// n*m ÃÊÄÝ¸´À» ºÐÇØ È½¼ö.
	static int split(int n, int m) {
		if(cache[n][m]!=-1)
			return cache[n][m];
		if(n==1) {
			return m-1; 
		}
		//ºÐ¸® °¡´ÉÇÑ È½¼ö
		int ret = 1;
		
		int mid = n/2;
		ret += split(mid, m) + split(n-mid,m);
	
		cache[n][m] = ret;
		
		return ret;
	}
}
