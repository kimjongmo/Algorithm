import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Exam1934 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int T = Integer.parseInt(br.readLine());
		String[] answer = new String[T];
		int i=0;
		while(T-->0) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			answer[i++] = String.valueOf((a*b)/gcd(a,b));
		}
		
		for(String s : answer) {
			pw.println(s);
			pw.flush();
		}
	}
	
	static int gcd(int a, int b) {
		if(b==0) return a;
		return gcd(b,a%b);
	}
}
