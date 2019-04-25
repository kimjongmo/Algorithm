import java.util.Scanner;

public class Exam11403 {

	static int n;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n][n];
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					dfs(i, j);
				}
			}
		}
		sc.close();
		print();
		
		
	}
	static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void dfs(int p, int q) {
		if(visit[p][q]) return;
		visit[p][q]=true;
		for (int i = 0; i < n; i++) {
			if(map[q][i]==1) {
				map[p][i]=1;
				dfs(p,i);
			}
		}
	}

}
