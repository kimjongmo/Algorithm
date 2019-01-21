import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exam1260 {
	
	static int[][] line=null;
	static int[] visit = null;
	static int N;
	static int V;
	static int start;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static void dfs(int start) {
		visit[start]=1;
		System.out.print(start+ " ");
		for(int i=1;i<=N;i++) {
			if(start==i) continue;
			if(line[start][i]==1&&visit[i]==0) {
				dfs(i);
			}
		}

	}
	static void bfs(int start) {
		if(visit[start]==0) {
			visit[start]=1;
			System.out.print(start+ " ");
		}
		for(int i=1;i<=N;i++) {
			if(i==start) continue;
			if(line[start][i]==1&&visit[i]==0) {
				queue.add(i);
				visit[i]=1;
				System.out.print(i+" ");
			}
		}
		if(!queue.isEmpty())
			bfs(queue.poll());
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		V = sc.nextInt();
		start = sc.nextInt();
		line = new int[N+1][N+1];
		visit = new int[N+1];
		for(int i=0;i<V;i++) {
			int n1= sc.nextInt();
			int n2= sc.nextInt();
			line[n1][n2]=1;
			line[n2][n1]=1;
		}

		
		dfs(start);
		visit = new int[N+1];
		System.out.println();
		bfs(start);
		
		sc.close();
	}
}
//4 5 1 1 2 1 3 1 4 2 4 3 4
