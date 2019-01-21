import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Exam6588 {
	
	public static void main(String[] args) throws IOException {
		int MAX = 1000001;
		boolean[] number = new boolean[MAX];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out); 
		
		for(int i=2;i<MAX;i++) {
			number[i]=true;
		}
		int end = (int)Math.sqrt(MAX);
		for(int i=2;i<=end;i++) {
			if(number[i]) {
				for(int j=i*i;j<MAX;j+=i)
					number[j]=false;
			}
		}
		
		int test; 
		while ((test= Integer.parseInt(br.readLine())) != 0) {
			for(int i=2;i<MAX;i++) {
				if(i>test-i) {
					pw.println("Goldbach's conjecture is wrong.");
					pw.flush();
				}
				if(number[i] && number[test-i]) {
					pw.println(test+" = "+i+" + "+(test-i));
					pw.flush();
					break;
				}
			}
		}
	}
}
