import java.util.Arrays;
import java.util.Scanner;

public class Exam16678 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();

		}

		sc.close();

		Arrays.sort(arr);

		int count = 1;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] - count != 0) {
				sum += arr[i] - count;
			}
			count++;
		}

		System.out.println(sum);
	}
}
