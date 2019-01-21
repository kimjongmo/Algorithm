import java.util.Scanner;

public class Exam11727 {
	
	static int[] cache;
	static int MOD = 10007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		cache = new int[n+1];
		for(int i=0;i<=n;i++)
			cache[i]=-1;
		System.out.println(fibo(n));
		sc.close();
		
	}
	static int fibo(int n) {
		if(n<=1) {
			return 1;
		}
		if(cache[n]!=-1)
			return cache[n];
		
		cache[n]= (2*fibo(n-2)+fibo(n-1))%MOD;
		return cache[n];
	}
	
}
