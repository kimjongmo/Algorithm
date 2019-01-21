import java.util.Scanner;

public class Exam2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] stairs = new int[n+1];
		int[] cache = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			stairs[i] = sc.nextInt();
		}
		stairs[0]=0;
		
		cache[0]=stairs[0];
		cache[1]=stairs[1];// 1번째 계단을 밟았을 경우
		cache[2]=stairs[1]+stairs[2]; //2번째 계단을 밟았을 경우
		
		for(int i=3;i<=n;i++) {
			//3번째 전에 계단을 밟고 바로 전 계단을 밟은 경우.
			//2번째 전 계단을 밟은 경우.
			cache[i] =  Math.max(cache[i-3]+stairs[i-1],cache[i-2])+stairs[i];
		}
		System.out.println(cache[n]);
		sc.close();
		
		
	}
	
}
