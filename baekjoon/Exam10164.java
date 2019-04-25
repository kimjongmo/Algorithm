import java.util.Arrays;
import java.util.Scanner;

public class Exam10164 {

	static int[][] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		cache = new int[N + 1][M + 1];
		for(int i=1;i<=N;i++) {
			Arrays.fill(cache[i], -1);
		}

		int K = sc.nextInt();
		if(K!=0) {
			int y = (K % M==0)?M:(K%M); // y��ǥ
			int x = (y!=M)?(K/M)+1:(K/M); // x��ǥ
			
			int a1 = search(1, 1, x, y);
			int a2 = search(x, y, N, M);
			System.out.println(a1*a2);
		}else {
			System.out.println(search(1,1,N,M));
		}

		sc.close();
	}

	// (startX,startY)->(endX,endY)
	static int search(int startX, int startY, int endX, int endY) {

		if (cache[startX][startY] != -1)
			return cache[startX][startY];

		if(startX==endX && startY==endY) {
			return 1;
		}
		
		int ret=0;
		
		if (startX + 1 <= endX) {
			ret += search(startX+1, startY, endX, endY);
		}
		
		if(startY + 1 <= endY) {
			ret += search(startX, startY+1, endX, endY);
		}
		
		cache[startX][startY] = ret;
		return ret;
	}
}
