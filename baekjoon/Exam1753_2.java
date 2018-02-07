import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Exam1753_2 {
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
			if(lines[i]==null) {//값이 null => 현재 거리가 무한대인 정점을 의미.
				continue;
			}else if(i==start){//자기 자신은 볼 필요가 없음.
				continue;
			}else {				//값을 아는 것만 큐에 넣는다.
				queue.add(lines[i]);
			}
		}
		return queue;
	}

	static void updateDistance() {	//다익스트라..
		
		queue = getQueue();//우선순위 큐 초기화
		
		while(queue.peek()!=null) {//큐에 더이상 값이 없을 때 까지 반복한다.
			
			Line line = queue.poll();	//큐에서 하나를 반환(=거리가 가장 최소).
			
			Line[] lines1 = map.get(line.v);	//해당 정점의 라인들을 불러온다.
			Line[] lines2 = map.get(start);		
			for(int i=1;i<totalV;i++) {
				if(lines1[i]==null) {
					continue;
				}else if(i==line.v) {
					continue;
				}else {
					if(lines2[i]!=null) {
						lines2[i].w = Math.min(lines2[i].w,lines2[line.v].w + lines1[i].w);
						//매번 큐를 업데이트 하자니.. 계속 같은 최소 정점만 나올테고.
						//큐를 한번만 초기화 시키고 계속 쓰자니. 큐를 업데이트하는 것이 복잡하고
						//진퇴양난이로다....
					}
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

		show();



	}

	static void show() {
		for (int i = 1; i <= totalV; i++) {
			Line[] lines = map.get(i);
			System.out.print(i + "\t");
			for (int j = 1; j <= totalV; j++) {
				if (lines[j]==null) {
					System.out.print("INF\t");
				} else {
					System.out.print(lines[j].w + "\t");
				}
			}
			System.out.println();
		}
	}
}

class Line implements Comparable<Line> {
	int v; // 정점
	int w = 200001; // 간선 가중치 , 최대값 10*20,000를 넘지 못한다. 따라서 200001은 무한대를 의미함.

	public Line(int v) {
		this.v = v;
	}

	public Line(int v, int w) {
		this.v = v;
		this.w = w;
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