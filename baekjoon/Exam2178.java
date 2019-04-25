import java.util.Scanner;

public class Exam2178 {

	static int N, M;
	static char[][] map;
	static boolean[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new char[N][M];
		visit = new boolean[N][M];
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			map[i]=sc.nextLine().toCharArray();
		}

		System.out.println(travel(0, 0)+1);
		
		sc.close();
	}
	
	static int travel(int x, int y) {
		System.out.println("x="+x+",y="+y);
		if(x==N-1 && y==M-1)
			return 0;
		
		visit[x][y]=true;
		
		int ret = 100001;
		
		//╩С
		if(x-1>=0 && map[x-1][y]=='1' && !visit[x-1][y]) {
			ret = Math.min(ret, travel(x-1, y)+1);
		}
		//го
		if(x+1<N && map[x+1][y]=='1' && !visit[x+1][y]) {
			ret = Math.min(ret, travel(x+1, y)+1);
		}
		//аб
		if(y-1>=0 && map[x][y-1]=='1'&& !visit[x][y-1]) {
			ret = Math.min(ret, travel(x, y-1)+1);
		}
		//©Л
		if(y+1<M && map[x][y+1]=='1'&& !visit[x][y+1]) {
			ret = Math.min(ret, travel(x, y+1)+1);
		}
		
		return ret;
	}
}
