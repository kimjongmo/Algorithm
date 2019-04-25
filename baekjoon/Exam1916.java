import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class Exam1916 {
	static int N;
	static int M;
	static int INF = 1000000001;
	static int[][] distance;
	static boolean[] visit;
	static PriorityQueue<Element> queue = new PriorityQueue<>();
	static int start;
	static int end;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		distance = new int[N+1][N+1];
		
		for(int i=1;i<N+1;i++) {
			visit[i] = false;
			for (int j = 1; j < N+1; j++) {
				if(i==j) distance[i][j]=0;
				else distance[i][j]=INF;
			}
		}
		for(int i=0;i<M;i++) {
			String[] temp = br.readLine().split(" ");
			int u = Integer.parseInt(temp[0]);
			int v = Integer.parseInt(temp[1]);
			int w = Integer.parseInt(temp[2]);
			distance[u][v] = Math.min(distance[u][v], w);
		}
		String[] temp = br.readLine().split(" ");
		start = Integer.parseInt(temp[0]);
		end = Integer.parseInt(temp[1]);
		
		for(int i=1;i<=N;i++) {
			queue.add(new Element(i, distance[start][i]));
		}
		visit[start]=true;
		dijkstart();
		System.out.println(distance[start][end]);
	}
	
	static void dijkstart() {
		while(!queue.isEmpty()) {
			Element e = queue.poll();
			if(visit[e.index]) {
				continue;
			}else {
				visit[e.index]=true;
			}
			
			for(int i=1;i<=N;i++) {
				distance[start][i] = Math.min(distance[start][i],distance[e.index][i]+distance[start][e.index]);
				queue.add(new Element(i, distance[start][i]));
			}
		}
	}
	
	static class Element implements Comparable<Element>{
		int index;
		int distance;
		public Element(int index,int distance) {
			this.index=index;
			this.distance=distance;
		}
		@Override
		public int compareTo(Element o) {
			return distance-o.distance;
		}
		
	}
}
