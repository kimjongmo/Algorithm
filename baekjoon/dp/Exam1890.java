package dp;

import java.util.Scanner;

public class Exam1890 {

	static int N;
	static int[][] map;
	static long[][] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		cache = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cache[i][j] = -1;
			}
		}
		System.out.println(move(0, 0));
		sc.close();
	}

	static long move(int x, int y) {
		if (cache[x][y] != -1)
			return cache[x][y];
		if (x == N - 1 && y == N - 1) {
			return 1;
		}

		long ret = 0;

		int distance = map[x][y];
		if(distance==0) {
			return 0;
		}
		// ������
		if (y + distance < N) {
			ret += move(x, y + distance);
		}

		// �Ʒ���
		if (x + distance < N) {
			ret += move(x + distance, y);
		}

		cache[x][y] = ret;

		return ret;
	}
}
