import java.util.Arrays;
import java.util.Scanner;

public class Exam11724 {
	static int n, m;
	static int[] unionFind;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		unionFind = new int[n + 1];
		Arrays.fill(unionFind, -1);
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(a, b);
		}

		int count = 0;
		
		for (int i = 1; i <= n; i++) {
			if (unionFind[i] == -1)
				count++;
		}

		System.out.println(count);

		sc.close();
	}

	static int rootFind(int a) {
		if (unionFind[a] == -1)
			return a;
		return rootFind(unionFind[a]);
	}

	static void union(int a, int b) {
		int rootA = rootFind(a);
		int rootB = rootFind(b);
		if (rootA != rootB) {
			unionFind[rootA] = rootB;
		}
	}
}
