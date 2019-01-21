
public class BookExam294 {
	static int skip = 3;
	static int[][] bino = new int[201][201];
	static int count=0;
	public static void main(String[] args) {
		for(int i=0;i<201;i++) {
			bino[i][0] = bino[i][i] = 1;
			for(int j=1;j<i;j++) {
				bino[i][j] = Math.min(1000000000, bino[i-1][j-1]+bino[i-1][j]);
			}
		}
		generate(2, 2, "");
		System.out.println(count);
	}

	static void generate(int n, int m, String s) {
		count++;
		if (skip < 0)
			return;

		if (n == 0 && m == 0) {
			if (skip == 0)
				System.out.println(s);
			--skip;
			return;
		}
		if(bino[n+m][n] <= skip) {
			skip-=bino[n+m][n];
			return;
		}
		if (n > 0)
			generate(n - 1, m, s + "-");
		if (m > 0)
			generate(n, m - 1, s + "o");
	}

}
