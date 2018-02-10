import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Exam1753_2 {
	public static final int INF = 200001;
	static Scanner sc = new Scanner(System.in);
	static Map<Integer, Line[]> map = new HashMap<>(); // 해당 간선의 리스트
	static int totalV = 0;// 전체 정점의 갯수
	static int totalE = 0;// 전체 간선의 갯수
	static int start = 0;// 시작 정점
	static PriorityQueue<Line> queue = null;

	//큐 초기화
	static PriorityQueue<Line> getQueue() {
		queue = new PriorityQueue<>();
		
		Line[] lines = map.get(start);
		
		for(int i=1;i<=totalV;i++) {
			queue.add(lines[i]);
		}
		
		return queue;
	}

	static void updateDistance() {	//다익스트라..
		
		queue = getQueue();//우선순위 큐 초기화
		
		boolean[] visit = new boolean[totalV+1];	//방문 여부.
		visit[start] = true;	//자기 자신 방문 완료
		
		while(!queue.isEmpty()) {//큐에 더이상 값이 없을 때 까지 반복한다.
			
			int minV = queue.poll().v;	//거리가 가장 가까운 정점
			
			if(visit[minV]==true) {	//방문한 적이 있는 점이라면 패스
				continue;
			}else {						//방문한 적 없다면 방문을 한다.
				visit[minV]= true;
			}
			
			Line[] v1 = map.get(start);
			Line[] v2 = map.get(minV);
			
			for(int i=1;i<totalV;i++) {
				if(i==minV) continue;	//minV라인에서 minV는 0이므로 0으로 되버림.
				if(v1[i].w > v1[minV].w+v2[i].w ) {
					v1[i].w = v1[minV].w+v2[i].w;
					queue.remove(new Line(i));
					queue.add(new Line(i,v1[i].w));
				}
			}
			
			
			
		}
		
		
	}
	public static void main(String[] args) {

		try {
			totalV = sc.nextInt();

			totalE = sc.nextInt();
			start = sc.nextInt();
			
			for (int i = 1; i <= totalV; i++) {
				Line[] lines = new Line[totalV+1];
				for(int j=1;j<=totalV;j++) {
					lines[j]=new Line(j);
				}
				lines[i]=new Line(i,0);
				map.put(i, lines);
			}

			for (int i = 1; i <= totalE; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int w = sc.nextInt();

				Line[] lines = map.get(u);
				lines[v] = new Line(v,w);
			}

			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//show();
		
		updateDistance();
		
		answer();

	}

	static void show() {
		for (int i = 1; i <= totalV; i++) {
			Line[] lines = map.get(i);
			System.out.print(i + "\t");
			for (int j = 1; j <= totalV; j++) {
				if (lines[j].w==Exam1753_2.INF) {
					System.out.print("INF\t");
				} else {
					System.out.print(lines[j].w + "\t");
				}
			}
			System.out.println();
		}
	}
	static void answer() {
		Line[] line = map.get(start);
		for(int i=1;i<=totalV;i++) {
			if(line[i].w==Exam1753_2.INF) 
				System.out.println("INF");
			else
				System.out.println(line[i].w);
		}
	}
}

class Line implements Comparable<Line> {
	int v; // 정점
	int w = Exam1753_2.INF; // 간선 가중치 , 최대값 10*20,000를 넘지 못한다. 따라서 200001은 무한대를 의미함.

	public Line(int v) {
		this.v = v;
	}

	public Line(int v, int w) {
		this.v = v;
		this.w = w;
	}
	
	public boolean equals(Line line) {
		if(line.v == this.v) {
			return true;
		}else {
			return false;
		}
	}
	public int compareTo(Line line) {
		if (this.w == line.w) {
			return 0;
		} else if (this.w > line.w) {
			return 1;
		} else {
			return -1;
		}
	}
}
// 5 6 1 5 1 1 1 2 2 1 3 3 2 3 4 2 4 5 3 4 6
// 6 9 1 1 6 14 1 2 7 1 3 9 2 3 10 2 4 15 3 6 2 3 4 11 6 5 9 4 5 6