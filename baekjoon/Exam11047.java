import java.util.Scanner;

public class Exam11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] coin = new int[N];
		
		for(int i=1;i<=N;i++) {
			coin[N-i] = sc.nextInt();
		}
		
		sc.close();
		
		
		int idx = 0;
		int totalCount = 0;
		while(K!=0) {
			if(coin[idx]>K) {
				idx++;
				continue;
			}else {
				int count = K/coin[idx];
				totalCount += count;
				K %= coin[idx];
			}
		}
		System.out.println(totalCount);
	}
}
