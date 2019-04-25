import java.util.Arrays;
import java.util.Scanner;

public class Exam6497 {
	static int N, M;
	static int[] unionFind;
	static Edge[] edges;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			N = sc.nextInt();
			M = sc.nextInt();
			if (N == 0 && M == 0) {
				sc.close();				
				return;
			}
			unionFind = new int[N + 1];
			Arrays.fill(unionFind, -1);
			edges = new Edge[M];

			int all = 0;
			for (int i = 0; i < M; i++) {
				edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
				all += edges[i].weight;
			}

			Arrays.sort(edges);

			int sum = 0;
			for (int i = 0; i < M; i++) {
				Edge e = edges[i];
				if (union(e.start, e.end)) {
					sum += e.weight;
				}
			}

			System.out.println(all - sum);
		}
		
	}

	static int find(int target) {
		if (unionFind[target] < 0)
			return target;
		unionFind[target] = find(unionFind[target]);
		return unionFind[target];
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;
		unionFind[bRoot] = aRoot;
		return true;
	}

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}
}
