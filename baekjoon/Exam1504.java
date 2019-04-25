import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Exam1504 {
	static int INF = 800001;
	static int V,E,a,b;
	static boolean[] visit;
	static int[] answer,a_answer,b_answer;
	static List<Element>[] list; 
	static PriorityQueue<Element> queue;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] str = br.readLine().split(" ");
		V = Integer.parseInt(str[0]);
		E = Integer.parseInt(str[1]);
		list = new ArrayList[V+1];

		for(int i=1;i<=V;i++) {
			list[i] = new ArrayList<>();
		}
		
		
		for(int i=0;i<E;i++) {
			String[] temp = br.readLine().split(" ");
			int n = Integer.parseInt(temp[0]);
			int v = Integer.parseInt(temp[1]);
			int w = Integer.parseInt(temp[2]);
			list[n].add(new Element(v, w));
			list[v].add(new Element(n, w));
		}
		
		String[] temp = br.readLine().split(" ");
		a = Integer.parseInt(temp[0]);
		b = Integer.parseInt(temp[1]);
		answer = new int[V+1];
		a_answer = new int[V+1];
		b_answer = new int[V+1];
		dijkstra(1, answer);
		dijkstra(a, a_answer);
		dijkstra(b, b_answer);
		int sabv = (answer[a]+a_answer[b]+b_answer[V])>INF?-1:answer[a]+a_answer[b]+b_answer[V];
		int sbav = (answer[b]+b_answer[a]+a_answer[V])>INF?-1:answer[b]+b_answer[a]+a_answer[V];
		
		if(sabv>0 && sbav>0)
			System.out.println(Math.min(sabv, sbav));
		else if(sbav>0 && sabv<0)
			System.out.println(sbav);
		else if(sabv>0 && sbav<0)
			System.out.println(sbav);
		else
			System.out.println(-1);
	}
	
	static void dijkstra(int start,int[] answer) {
		visit = new boolean[V+1];
		queue = new PriorityQueue<>();
		
		Arrays.fill(visit, false);
		visit[start]= true;

		Arrays.fill(answer,INF);
		answer[start]=0;
		list[start].stream().forEach(e->answer[e.index]=e.distance);
		
		for(int i=1;i<=V;i++)
			queue.add(new Element(i, answer[i]));
		
		
		while(!queue.isEmpty()) {
			Element e = queue.poll();

			if(visit[e.index])
				continue;
			visit[e.index]=true;
			
			list[e.index].stream().forEach(element->{
				if(answer[element.index]>answer[e.index]+element.distance) {
					answer[element.index] = answer[e.index]+element.distance;
					queue.add(new Element(element.index, answer[element.index]));
				}
			});
		}
		
	}
	
	static class Element implements Comparable<Element>{
		int index;
		int distance;
		public Element(int index,int distance) {
			this.index = index;
			this.distance = distance;
		}
		@Override
		public int compareTo(Element o) {
			return this.distance - o.distance;
		}
		
		
	}
}
