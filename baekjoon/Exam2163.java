import java.util.Scanner;

public class Exam2163 {
	static int[][] cache;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		cache = new int[n+1][m+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<m+1;j++)
				cache[i][j]=-1;
		}
		
		sc.close();
		
		System.out.println(split(n, m));
	}

	static int split(int n, int m) {
		if(n==1 && m ==1) {
			return 0;
		}
		if(cache[n][m]!=-1) {
			return cache[n][m];
		}
		int count = 0;
		if(n>=2) {
			count = split(n/2, m)+split(n-n/2, m)+1;
			cache[n][m] = count;
			return count;
		}else if(n==1 && m>=2) {
			cache[n][m] = m-1;
			return m-1;
		}
		
		return -1;
		
	}
}

