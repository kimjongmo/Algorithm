import java.util.Scanner;

public class Exam1929 {
	public static void main(String[] args) {
		boolean[] number = new boolean[1000001];
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		sc.close();
		for(int i=2;i<=N;i++) {
			number[i]=true;
		}
		
		int end = (int)Math.sqrt(N);
		
		for(int i=2;i<=end;i++) {
			if(number[i]) {
				for(int j=i*i;j<=N;j+=i) {
					number[j]=false;
				}
			}
		}
		
		
		for(int i=M;i<=N;i++) {
			if(number[i])
				System.out.println(i);
		}
	}
}
