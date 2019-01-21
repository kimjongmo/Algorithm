import java.util.Scanner;

public class Exam1009 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int r, a, b;
		int[] answer = new int[T];
		for (int tc = 0; tc < T; tc++) {
			a = sc.nextInt();
			b = sc.nextInt();
			r = 1;
			for (int i = 0; i < b; i++) {
				r = (r * a) % 10;
			}
			if (r == 0)
				r = 10;
			answer[tc]=r;
		}
		sc.close();
		
		for(int i : answer)
			System.out.println(i);
	}
}
