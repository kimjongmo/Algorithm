import java.util.Scanner;

public class Exam1932 {
	static int n;
	static int[][] tri;
	static int[][] cache;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		tri = new int[n][n];
		cache = new int[n][n];
		for(int i=0;i<n;i++) 
			for(int j=0;j<i+1;j++) {
				tri[i][j]=sc.nextInt();
				cache[i][j]=-1;
			}
		System.out.println(dp(0,0));
		
		sc.close();
	}
	
	static int dp(int w,int h) {
		if(h==n-1) {
			return tri[h][w];
		}
		if(cache[h][w]!=-1)
			return cache[h][w];
		
		cache[h][w]=Math.max(dp(w,h+1),dp(w+1,h+1))+tri[h][w];	
		return cache[h][w];
		
	}
	
}
