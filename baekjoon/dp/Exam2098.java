package dp;

import java.util.Arrays;
import java.util.Scanner;

public class Exam2098 {
	static int N;
	static int[][] distacne;
	static boolean[] visit;
	static int[][] cache;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		distacne = new int[N][N];
		visit = new boolean[N];
		cache = new int[N][(int) Math.pow(2, N)];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				distacne[i][j] = sc.nextInt();
			}
			visit[i] = false;
			Arrays.fill(cache[i], -1);
		}
		
		
		System.out.println(travel(0));;
		sc.close();
	}

	static int travel(int now) {
		visit[now] = true;

		int c = unpack();
		if (c == Math.pow(2, N)-1) {
			int dis = distacne[now][0];
			return dis==0?32000001:dis;
		}
		if (cache[now][c] != -1)
			return cache[now][c];

		int min = 32000001;
		
		for (int i = 0; i < N; i++) {
			if (!visit[i] && distacne[now][i]!=0) {
				min = Math.min(min, travel(i) + distacne[now][i]);
				visit[i] = false;
			}
		}
		cache[now][c] = min;
		return min;
	}

	static int unpack() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (visit[i]) {
				sum += Math.pow(2, i);
			}
		}
		return sum;
	}
}
