import java.util.Scanner;

public class Exam10844 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int MOD = 1000000000;
		int n = sc.nextInt();
		long[][] digit = new long[n + 1][10];

		for (int i = 1; i <= 9; i++) {
			digit[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			for (int d = 0; d < 10; d++) {
				if (d == 0)
					digit[i][d] = digit[i - 1][d + 1] % MOD;
				else if (d == 9)
					digit[i][d] = digit[i - 1][d - 1] % MOD;
				else
					digit[i][d] = digit[i - 1][d + 1] % MOD + digit[i - 1][d - 1] % MOD;
			}
		}

		long sum = 0;

		for (int i = 0; i < 10; i++) {
			sum = sum % MOD;
			sum += (digit[n][i] % MOD);
		}
		System.out.println(sum % MOD);
		sc.close();
	}

}
