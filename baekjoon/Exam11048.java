import java.util.Scanner;

public class Exam11048 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		int[][] cache = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		cache[0][0] = map[0][0];
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				cache[i][j] = map[i][j] + Math.max(cache[i-1][j], Math.max(cache[i][j-1], cache[i-1][j-1]));
			}
		}
		
		System.out.println(cache[n-1][m-1]);
		
		sc.close();
	}}
