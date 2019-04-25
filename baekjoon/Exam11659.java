import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Exam11659 {
	static int N,M;
	static int[] sum;
	static int[] answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		sum = new int[N+1];
		Arrays.fill(sum, 0);
		
		answer = new int[M];
		
		String[] number = br.readLine().split(" ");
		for(int i=1;i<N+1;i++) {
			sum[i] = sum[i-1]+Integer.parseInt(number[i-1]);
		}
		
		for(int i=0;i<M;i++) {
			
			String[] question = br.readLine().split(" ");
			
			int start = Integer.parseInt(question[0]);
			int end = Integer.parseInt(question[1]);
			
			answer[i] = sum[end]-sum[start-1];
		}
		
		for(int a : answer)
			System.out.println(a);
		
	}
}
