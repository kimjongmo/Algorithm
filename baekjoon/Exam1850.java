

import java.io.PrintWriter;
import java.util.Scanner;

public class Exam1850 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		long a = sc.nextLong();
		long b = sc.nextLong();
		sc.close();
		long answer = gcd(a,b);
		for(int i=0;i<answer;i++) {
			pw.print("1");
		}
		pw.flush();
		
	}
	
	static long gcd(long a, long b) {
		if(b==0) return a;
		return gcd(b,a%b);
		
	}
}
