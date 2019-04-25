import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


import javafx.geometry.Point2D;



public class Exam4386 {
	
	static int N;
	static Point2D[] stars = new Point2D[100];
	static int[] uf = new int[100];
	static double[][] distance = new double[100][100];
	static PriorityQueue<Edge> q = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=0;i<N;i++) {
			stars[i] = new Point2D(sc.nextDouble(), sc.nextDouble());
		}
		
		Arrays.fill(uf, -1);
		
		sc.close();
		
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				distance[i][j] = stars[i].distance(stars[j]);
				distance[j][i] = distance[i][j] = Double.valueOf(String.format("%.2f", distance[i][j]));
				q.add(new Edge(i, j, distance[i][j]));
			}
		}
		
		double sum = 0;
		while(!q.isEmpty()) {
			Edge e = q.poll();
			if(union(e.start, e.end)) {
				sum+=e.distance;
			}
		}
		
		System.out.println(sum);
	}
	
	static int find(int a) {
		if(uf[a]<0) return a;
		uf[a] = find(uf[a]);
		return uf[a];
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot)
			return false;
		uf[bRoot] = aRoot;
		return true;
	}
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		double distance;
		
		public Edge(int s, int e, double d) {
			start = s;
			end = e;
			distance = d;
		}

		@Override
		public int compareTo(Edge o) {
			return (int) (distance-o.distance);
		}
		
		
	
	}

	
	
}
