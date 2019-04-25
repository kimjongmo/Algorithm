import java.util.Scanner;

public class Exam6359 {

	static int T, N;
	static boolean[] arr;
	static int[] answer;
	static int[] cache;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		answer = new int[T];
		int idx = 0;
		while (T-- > 0) {
			N = sc.nextInt();
			arr = new boolean[N + 1];
			cache = new int[N+1];
			for (int i = 1; i <= N; i++) {
				for (int j = i; j <= N; j += i) {
					arr[j] = !arr[j];
				}
			}
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if (arr[i])
					count++;
			}
			
			answer[idx++]=count;
		}
		sc.close();
		
		for(int a : answer) {
			System.out.println(a);
		}
	}
}
