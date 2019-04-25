import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Exam15955 {
//
//	static long MAX = 4000000000L;
//	static int N;			//체크 포인트 갯수
//	static int Q;			//질의문 갯수
//	static Point[] points;	//체크 포인트
//	static boolean[] visit; //방문
//	static long[][] possible;
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter pw = new PrintWriter(System.out);
//
//		String[] str = br.readLine().split(" ");
//		N = Integer.parseInt(str[0]);
//		Q = Integer.parseInt(str[1]);
//
//		points = new Point[N + 1];
//		visit = new boolean[N + 1];
//		possible = new long[N+1][N+1];
//		for (int i = 1; i < N + 1; i++) {
//			visit[i] = false;
//			for(int j=1;j<N+1;j++) {
//				possible[i][j] = MAX;
//			}
//		}
//
//		for (int i = 1; i <= N; i++) {
//			String[] t = br.readLine().split(" ");
//			int x = Integer.parseInt(t[0]);
//			int y = Integer.parseInt(t[1]);
//			points[i] = new Point(x, y);
//		}
//
//		for (int testNum = 0; testNum < Q; testNum++) {
//			String[] t = br.readLine().split(" ");
//			int start =Integer.parseInt(t[0]);
//			int end = Integer.parseInt(t[1]);
//			int max_hp = Integer.parseInt(t[2]);
//			int cur_hp = max_hp;
//		}
//
//	}
//	
//	static void init(){
//		for(int i=1;i<N+1;i++) {
//			Point p1 = points[i];
//			for(int j=i+1;j<N+1;j++) {
//				Point p2 = points[j];
//				if(p1.x == p2.x || p1.y == p2.y)
//					possible[i][j] = possible[j][i] = 0;
//				else {
//					long distanceX = p1.x-p2.x;
//					possible[i][j] = possible[j][i] = Math.min(a, b);
//				}
//					
//			}
//		}
//	}
//	static boolean isPossible(int start, int end) {
//		if(possible[start][end])
//			return true;
//		
//		visit[start]=true;
//		
//		boolean ret = false;
//		for(int i=0;i<N+1;i++) {
//			if(possible[start][i] && visit[i]==false) {
//				if(isPossible(i, end)) {
//					possible[start][end] = ret = true;
//					break;
//				}
//			}
//		}
//		return ret;
//	}
	
}
