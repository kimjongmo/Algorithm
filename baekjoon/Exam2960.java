import java.util.Scanner;

public class Exam2960 {
	public static void main(String[] args) {
		boolean[] number = new boolean[1001];
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
		for (int i = 2; i <= N; i++) {
			number[i] = true;
		}

		int count = 0;
		for (int i = 2; i <= N; i++) {
			for (int j = i; j <= N; j += i) {
				if (number[j]) {
					if (++count == K) {
						System.out.println(j);
						return;
					}
					number[j] = false;
				}
			}

		}
	}
}
