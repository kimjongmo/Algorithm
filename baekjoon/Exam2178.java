import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exam2178 {

	static int N, M;
	static char[][] map;
	static boolean[][] visit;
	static Queue<CustomPoint> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new char[N][M];
		visit = new boolean[N][M];

		sc.nextLine();
		for (int i = 0; i < N; i++) {
			map[i] = sc.nextLine().toCharArray();
			Arrays.fill(visit[i], false);
		}
		
		System.out.println(travel(0,0,0)+1);
		
		sc.close();
	}
	static int travel(int x, int y,int cnt) {
		if(x==N-1 && y==M-1)
			return cnt;
		
		int ret= 1000001;
		visit[x][y] = true;
		
		if(x-1>=0 && map[x-1][y]=='1' && !visit[x-1][y]) {
			queue.add(new CustomPoint(new Point(x-1, y), cnt+1) );
		}
		if(x+1<N && map[x+1][y]=='1' && !visit[x+1][y]) {
			queue.add(new CustomPoint(new Point(x+1, y), cnt+1));
		}
		if(y-1>=0 && map[x][y-1]=='1' && !visit[x][y-1]) {
			queue.add(new CustomPoint(new Point(x, y-1), cnt+1));
		}
		if(y+1<M && map[x][y+1]=='1' && !visit[x][y+1]) {
			queue.add(new CustomPoint(new Point(x, y+1), cnt+1));
		}
		
		while(!queue.isEmpty()) {
			CustomPoint next = queue.poll();
			if(!visit[next.p.x][next.p.y]) {
				int result = travel(next.p.x,next.p.y,next.cnt);
				if(result!=1000001) {
					return result;
				}
			}
		}
		
		return ret;
	}
}
class CustomPoint{
	Point p;
	int cnt;
	public CustomPoint(Point p , int cnt) {
		this.p = p;
		this.cnt = cnt;
	}
}

