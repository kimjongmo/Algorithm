import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TestExam1012 {

	static int T, M, N, K; // 테스트 수, 세로, 가로, 배추의 개수
	static int[][] cabbage;
	static boolean[][] visit;
	static int bug=0;
	static Queue<Point> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		while ((T--) > 0) {
			
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			
			cabbage = new int[M][N];
			visit = new boolean[M][N];
			
			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				cabbage[x][y] = 1;
			}

			// traveling
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(cabbage[i][j]==1 && !visit[i][j]) {
						traveling(i,j);
						bug++;
					}
				}
			}

		}

		sc.close();
	}
	
	static void traveling(int x, int y) {
		if(visit[x][y])
			return;
		
		visit[x][y] = true;
		
		
		
	}
}
