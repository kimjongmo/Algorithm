import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Exam1261 {

	static int INF = 1000;
	static int V, E;
	static int[][] input;
	static int[] answer;
	static PriorityQueue<Element> q = new PriorityQueue<>();
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		E = Integer.parseInt(str[0]);// 가로
		V = Integer.parseInt(str[1]);// 세로
		input = new int[V][E];
		visit = new boolean[V*E];
		answer = new int[V*E];
		Arrays.fill(answer, INF);
		Arrays.fill(visit, false);
		for(int i=0;i<V;i++) {
			String s = sc.nextLine();
			for(int j=0;j<E;j++) {
				input[i][j] =s.charAt(j)-'0';
			}
		}
		sc.close();
		visit[0]=true;
		if(E>=2) {
			q.add(new Element(0,1, input[0][1]));
			answer[1] = input[0][1];
		}
		if(V>=2) {
			q.add(new Element(1,0, input[1][0]));
			answer[E] = input[1][0];
		}
		dijkstart();
		
		System.out.println(answer[V*E-1]==INF?input[0][0]:answer[V*E-1]);
	}
	
	static void dijkstart() {
		while(!q.isEmpty()) {
			Element e = q.poll();
			
			if(visit[(e.x*E)+e.y])
				continue;
			visit[e.x*E+e.y]=true;
			//Up
			if(e.x-1>=0) {
				answer[(e.x-1)*E+(e.y)] = Math.min(answer[(e.x-1)*E+(e.y)],input[e.x-1][e.y]+e.distance);
				q.add(new Element(e.x-1, e.y, answer[(e.x-1)*E+e.y]));
			}
			//Down
			if(e.x+1<=V-1) {
				answer[(e.x+1)*E+(e.y)] = Math.min(answer[(e.x+1)*E+(e.y)],input[e.x+1][e.y]+e.distance);
				q.add(new Element(e.x+1, e.y, answer[(e.x+1)*E+(e.y)]));
			}
			//Left
			if(e.y-1>=0) {
				answer[(e.x)*E+(e.y-1)] = Math.min(answer[(e.x)*E+(e.y-1)],input[e.x][e.y-1]+e.distance);
				q.add(new Element(e.x, e.y-1, answer[(e.x)*E+(e.y-1)]));
			}
			//Right
			if(e.y+1<=E-1) {
				answer[(e.x)*E+(e.y+1)] = Math.min(answer[(e.x)*E+(e.y+1)],input[e.x][e.y+1]+e.distance);
				q.add(new Element(e.x, e.y+1, answer[(e.x)*E+(e.y+1)]));
			}
			
		}
	}

	static class Element implements Comparable<Element> {
		int x,y;
		int distance;

		public Element(int x, int y,int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		@Override
		public int compareTo(Element o) {
			return this.distance - o.distance;
		}
	}
}
