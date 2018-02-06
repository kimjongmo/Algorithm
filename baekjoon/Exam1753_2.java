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
	static PriorityQueue<Line> queue = new PriorityQueue<>();

	//get queue 만들고 최초 한번만 삽입 하자  19~21라인을 이쪽으로 옮기기
	static int getM() {

		Line[] lines = map.get(start);

		for (int i = 0; i < lines.length; i++) {
			queue.add(lines[i]);
		}
		Line top = queue.poll();
		while (true) {
			if (top.w == 0 || top.w == 200001) {
				top = queue.poll();
			}else {
				break;
			}
		}
		return top.v;
	}

	public static void main(String[] args) {

		try {
			totalV = sc.nextInt();

			totalE = sc.nextInt();
			start = sc.nextInt();

			for (int i = 1; i <= totalV; i++) {
				Line[] lines = new Line[totalV];
				for (int j = 1; j <= totalV; j++) {
					if (i == j) {
						lines[j - 1] = new Line(j, 0);
					} else {
						lines[j - 1] = new Line(j);
					}
				}
				map.put(i, lines);

			}

			for (int i = 1; i <= totalE; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int w = sc.nextInt();

				Line[] lines = map.get(u);
				lines[v - 1].w = w;
			}

			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		show();

		System.out.println("첫번째 최소 정점 = " + getM());
		System.out.println("두번째 최소 정점 = " + getM());

	}

	static void show() {
		for (int i = 1; i <= totalV; i++) {
			Line[] lines = map.get(i);
			System.out.print(i + "\t");
			for (int j = 0; j < lines.length; j++) {
				if (lines[j].w == 200001) {
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