import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exam2667 {
	static int n;
	static char[][] house;
	static boolean[][] visit;
	static List<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		n = sc.nextInt();
		
		house = new char[n][n];
		visit = new boolean[n][n];
		
		sc.nextLine();
		for(int i=0;i<n;i++) {
			house[i] = sc.nextLine().toCharArray();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(house[i][j]=='1' && !visit[i][j]) {
					list.add(dfs(i,j));
				}
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		for(int a : list) {
			System.out.println(a);
		}
		
		sc.close();
	}
	
	
	static int dfs(int x, int y) {
		visit[x][y]=true;
		int ret=1;
		
		if(x-1>=0 && !visit[x-1][y] && house[x-1][y]=='1') {
			ret += dfs(x-1,y);
		}
		
		if(x+1<n && !visit[x+1][y]&& house[x+1][y]=='1') {
			ret += dfs(x+1,y);
		}
		
		if(y-1>=0 && !visit[x][y-1]&& house[x][y-1]=='1') {
			ret += dfs(x,y-1);
		}
		
		if(y+1<n && !visit[x][y+1]&& house[x][y+1]=='1') {
			ret += dfs(x,y+1);
		}
		
		return ret;
	}
}
