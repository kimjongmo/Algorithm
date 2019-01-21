package git_Algorithm;

public class SlidingWindowTech {
	static int n;
	static int[][] tri = new int[100][100];
	static int[][] C = new int[100][100];
	public static void main(String[] args) {
		
	}
	
	int interactive() {
		for(int x=0;x<n;x++)
			C[n-1][x] = tri[n-1][x];
		
		for(int y=n-2;y>=0;y--) {
			for(int x = 0; x<y+1;++x)
				C[y][x] = Math.max(C[y+1][x], C[y+1][x+1])+tri[y][x];
		}
		
		return C[0][0];
			
	}
}
