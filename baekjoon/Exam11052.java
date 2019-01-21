import java.util.Scanner;

public class Exam11052 {
	static int[] card;
	static int n;
	static int[] cache;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		card = new int[n];
		cache = new int[n];
		for(int i=0;i<n;i++) {
			card[i]=sc.nextInt();
			cache[i]=-1;
		}
		System.out.println(dp(n));
		sc.close();
	}	
	
	static int dp(int remain) {
		if(remain==0)
			return 0;
		if(cache[remain-1]!=-1) {
			return cache[remain-1];
		}
		int max = 0;
		for(int i=0;i<remain;i++) {
			max = Math.max(dp(remain-(i+1))+card[i],max);
		}
		cache[remain-1]=max;
		return max;
	}
	
}
