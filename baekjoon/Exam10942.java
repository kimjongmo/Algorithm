import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Exam10942 {

	static int N, M;
	static int[] arr;
	static int[][] cache;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		String[] strs = br.readLine().split(" ");

		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(strs[i-1]);

		M = Integer.parseInt(br.readLine());
		cache = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++)
			Arrays.fill(cache[i], -1);
		answer = new int[M];
		int i=0;
		while (M-- > 0) {
			String[] question = br.readLine().split(" ");
			int S = Integer.parseInt(question[0]);
			int E = Integer.parseInt(question[1]);

			int ans = isPalindrome(S, E);
			answer[i++] = ans;
		}
		
		for(int ans : answer)
			pw.println(ans);
		pw.flush();
		
	}

	static int isPalindrome(int S, int E) {
		if (cache[S][E] != -1)
			return cache[S][E];

		int ret;
		
		if(arr[S]==arr[E])
			ret=1;
		else
			ret=0;

		if (S+1 < E-1) {
			ret *= isPalindrome(S+1, E-1);	//1=> ret = arr[S][E], 0-> ret =0; 
		}

		cache[S][E] = ret;
		return ret;

	}
}
