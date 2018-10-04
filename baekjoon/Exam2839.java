import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int result=N;
		//N = (5 * a) + (3 * b) 
		
		for(int i=0;i<=(N/5);i++) {
			int temp = N-(5*i);
			if(temp%3==0) {
				result = Math.min(result, i+(temp/3));
			}
		}
		if(result == N) {
			result =-1;
		}
		System.out.println(result);
	}
}
