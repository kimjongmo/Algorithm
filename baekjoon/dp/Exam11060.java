package dp;

import java.util.Scanner;

public class Exam11060 {

	static int N;
	static int[] map;
	static int[] cache;
	static int IMPOSSIBLE = 1001;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N];
		cache = new int[N];

		for (int i = 0; i < N; i++) {
			map[i] = sc.nextInt();
			cache[i] = -1;
		}

		System.out.println(move(0) == IMPOSSIBLE ? -1 : move(0));

		sc.close();
	}

	
	//start�κ��� �����ؼ� ������ ������ ������� ���� �ִ���.
	static int move(int start) {
		if(start>=N-1)
			return 0;
		
		if (cache[start] != -1)
			return cache[start];

		int ret = 1001;
		for (int jump = 1; jump <= map[start]; jump++) {
			ret = Math.min(ret, move(start + jump)+1);
		}

		cache[start] = ret;

		return ret;

	}
}
