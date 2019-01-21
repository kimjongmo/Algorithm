import java.util.Scanner;

public class Exam13241 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long ab = gcd(a,b);
		System.out.println(ab);
		System.out.println(a*b/ab);
		sc.close();
	}
	
	static long gcd(long a, long b) {
		if(b==0) return a;
		return gcd(b,a%b);
	}
}
