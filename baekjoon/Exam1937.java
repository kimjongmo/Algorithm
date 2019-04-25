import java.util.Scanner;

public class Exam1937 {

	static int n;
	static int[][] map;
	static int[][] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		map = new int[n][n];
		cache = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				cache[i][j] = -1;
			}
		}

		
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, travel(i, j));
			}
		}
		
		System.out.println(max);
		sc.close();
	}

	static int travel(int x, int y) {
		if (cache[x][y] != -1)
			return cache[x][y];

		int alive = 1;

		// ╩С
		if (x - 1 >= 0 && map[x][y] < map[x - 1][y]) {
			alive = Math.max(alive, travel(x - 1, y) + 1);
		}

		// го
		if (x + 1 < n && map[x][y] < map[x + 1][y]) {
			alive = Math.max(alive, travel(x + 1, y) + 1);
		}

		// аб
		if (y - 1 >= 0 && map[x][y] < map[x][y - 1]) {
			alive = Math.max(alive, travel(x, y - 1) + 1);
		}

		// ©Л
		if (y + 1 < n && map[x][y] < map[x][y + 1]) {
			alive = Math.max(alive, travel(x, y + 1) + 1);
		}
		
		cache[x][y]=alive;
		
		return alive;

	}
}
