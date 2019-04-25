import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS {

	static int N, M, V; // N : ������ ����, M : ������ ����, V : ������ġ
	static boolean[][] map;
	static boolean[] visit;
	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		visit = new boolean[N+1]; // �⺻������ false�� �Ǿ��ְ���??
		map = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			map[v1][v2] = map[v2][v1] = true;
		}
		dfs(V);
		Arrays.fill(visit, false);
		sc.close();
	}
	
	//���� ��ġ���� DFS�Ұ���.
	static void dfs(int start) {
		if(visit[start]==true) {
			return;
		}
		System.out.print(start+"\t");
		visit[start] = true;
		
		for(int i=1;i<=N;i++) {
			if(map[start][i]) {
				dfs(i);
			}
		}
	}
	
	//���� ��ġ���� BFS
	static void bfs(int start) {
		if(visit[start]) 
			return;

		System.out.print(start+"\t");
		visit[start] = true;
		
		for (int i = 1; i < N+1; i++) {
			if(map[start][i]) {
				queue.add(i);
			}
		}
		
		if(!queue.isEmpty()) {
			int next = queue.poll();
			bfs(next);
		}
	}
}
