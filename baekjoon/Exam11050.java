import java.util.Scanner;

public class Exam11050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int M = 10007;
		int[][] bino = new int[1001][1001];
		for(int i=0;i<1001;i++) {
			bino[i][0] = bino[i][i] = 1;
			for(int j=1;j<i;j++) {
				bino[i][j] = (bino[i-1][j]+bino[i-1][j-1])%M;
			}
		}
		System.out.println(bino[N][K]);
	}
}
