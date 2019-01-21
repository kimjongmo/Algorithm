import java.util.Scanner;

public class Exam1149 {
	static int n;
	static int[][] house;
	static int MAX = 1000000;
	static int[][] cache;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		house = new int[n][3];
		cache = new int[n][3];
		
		for(int i=0;i<n;i++) {
			house[i][0]=sc.nextInt();
			house[i][1]=sc.nextInt();
			house[i][2]=sc.nextInt();
		}
		cache[0][0] = house[0][0];
		cache[0][1] = house[0][1];
		cache[0][2] = house[0][2];
		for(int i=1;i<n;i++) {
			cache[i][0] = Math.min(cache[i-1][1],cache[i-1][2])+house[i][0];
			cache[i][1] = Math.min(cache[i-1][0],cache[i-1][2])+house[i][1];
			cache[i][2] = Math.min(cache[i-1][0],cache[i-1][1])+house[i][2];
		}
		System.out.println(Math.min(Math.min(cache[n-1][0], cache[n-1][1]), cache[n-1][2]));
		
		
		sc.close();
	}
	
}

