import java.util.Scanner;

public class Exam11726 {
	static int MOD = 10007;
	static int[] cache;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		cache = new int[n+1];
		for(int i=0;i<n+1;i++)
			cache[i]=-1;
		System.out.println(tile(n));
		sc.close();
	}
	
	static int tile(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		if(n==2) return 2;
		if(cache[n]!=-1)
			return cache[n];
		cache[n]= (tile(n-1)+tile(n-2))%MOD;
		return cache[n];
	}
}
