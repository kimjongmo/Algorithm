import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exam1753 {
	static int V;
	static int E;
	static int start;
	static final int INFINITY = 2000000;
	static boolean[] visit; // 방문 여부
	static int[] answer; // answer
	static PriorityQueue<Element> queue = new PriorityQueue<>();
	static List<Element>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = null;
		String[] temp = br.readLine().split(" ");
		V = Integer.parseInt(temp[0]);
		E = Integer.parseInt(temp[1]);
		start = Integer.parseInt(br.readLine());
		visit = new boolean[V + 1];
		answer = new int[V + 1];
		list = new ArrayList[V + 1];

		for (int i = 1; i < V + 1; i++) {
			list[i] = new ArrayList<Element>();
			visit[i] = false;
			if (i == start)
				answer[i] = 0;
			else
				answer[i] = INFINITY;
		}

		for (int i = 0; i < E; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			while (token.hasMoreTokens()) {

				int u = Integer.parseInt(token.nextToken());
				int v = Integer.parseInt(token.nextToken());
				int w = Integer.parseInt(token.nextToken());

				list[u].add(new Element(v, w));
			}
		}

		visit[start] = true;
		list[start].stream().forEach(e -> {
			answer[e.idx] = Math.min(answer[e.idx], e.distance);
			queue.add(e);
		});

		dijkstra();
		for (int i=1;i<=V;i++) {
			if (answer[i] >= INFINITY)
				System.out.println("INF");
			else
				System.out.println(answer[i]);

		}

	}

	static void dijkstra() {
		while (!queue.isEmpty()) {
			Element e = queue.poll();

			if (visit[e.idx])
				continue;
			else
				visit[e.idx] = true;
			// e.idx = 2 , {3,4}{4,5}
			list[e.idx].stream().forEach(here -> {
				answer[here.idx] = Math.min(answer[here.idx], here.distance + answer[e.idx]);
				queue.add(new Element(here.idx, answer[here.idx]));
			});
		}
	}

	static class Element implements Comparable<Element> {
		int idx;
		int distance;

		public Element(int idx, int distance) {
			this.idx = idx;
			this.distance = distance;
		}

		@Override
		public int compareTo(Element o) {
			return distance - o.distance;
		}

	}

}
