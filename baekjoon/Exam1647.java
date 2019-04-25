import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Exam1647 {
	static int N,M;
	static PriorityQueue<Edge> q = new PriorityQueue<>();
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		arr = new int[N+1];
		Arrays.fill(arr,-1);
		
		for(int i=0;i<M;i++) {
			String[] t = br.readLine().split(" ");
			int start = Integer.parseInt(t[0]);
			int end = Integer.parseInt(t[1]);
			int distance = Integer.parseInt(t[2]);
			q.add(new Edge(start,end,distance));
		}
		
		int sum = 0;
		int max = 0;
		for(int i=0;i<M;i++) {
			Edge edge = q.poll();
			if(union(edge.start, edge.end)) {
				sum+=edge.distance;
				max = Math.max(max, edge.distance);
			}
		}
		
		System.out.println(sum-max);
	}
	
	static int find(int a) {
		if(arr[a]<0) return a;
		arr[a] = find(arr[a]);
		return arr[a];
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot)
			return false;
		arr[bRoot] = aRoot;
		return true;
	}
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int distance;
		public Edge(int s,int e, int d) {
			start = s;
			end = e;
			distance = d;
		}
		@Override
		public int compareTo(Edge o) {
			return distance-o.distance;
		}
		
	}
}
