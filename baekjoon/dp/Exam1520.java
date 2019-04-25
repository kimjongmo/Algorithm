package dp;

import java.util.Scanner;

public class Exam1520 {

	static int M, N;
	static int[][] map;
	static int[][] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		cache = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				cache[i][j] = -1;
			}
		}
		System.out.println(travel(0, 0));
		sc.close();
	}

	static int travel(int x, int y) {
		if(cache[x][y]!=-1) {
			return cache[x][y];
		}else if(x==M-1 && y==N-1) {
			return 1;
		}
		
		int ret = 0;
		
		//╩С
		if(x!=0 && map[x][y] > map[x-1][y]) {
			ret += travel(x-1,y);
		}
		//го
		if(x!=M-1 && map[x][y] > map[x+1][y]) {
			ret += travel(x+1,y);
		}
		//аб
		if(y!=0 && map[x][y] > map[x][y-1]) {
			ret += travel(x,y-1);
		}
		//©Л
		if(y!=N-1 && map[x][y] > map[x][y+1]) {
			ret += travel(x,y+1);
		}
		
		cache[x][y]= ret;
		
		return ret;
	}
}

/*
50 45 37 32 30 
55 50 50 50 25 
50 50 55 50 20 
57 54 52 50 10
 */
