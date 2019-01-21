import java.util.Scanner;

public class Exam1081 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();
		int U = sc.nextInt();
		sc.close();
		long sum = 0;
		long sum2 = 0;

		if (L != 0) {

			String strL = String.valueOf(L - 1);

			int len = strL.length();

			for (int digit = 0; digit < len; digit++) {
				int front;
				int back = 0;
				if (digit > 0)
					back = Integer.parseInt(strL.substring(len - digit, len)) + 1;
				if (digit + 1 == len)
					front = 0;
				else
					front = Integer.parseInt(strL.substring(0, len - (digit + 1)));
				if (digit == 0)
					sum += (solve(9, digit, front) + solve(strL.charAt(len - (digit + 1)) - '0', digit, 1));
				else
					sum += (solve(9, digit, front) + solve(strL.charAt(len - (digit + 1)) - '1', digit, 1)
							+ (strL.charAt(len - (digit + 1)) - '0') * back);
			}
		}

		if (U != 0) {
			String strU = String.valueOf(U);

			int len2 = strU.length();

			for (int digit = 0; digit < len2; digit++) {
				int front;
				int back = 0;
				if (digit > 0)
					back = Integer.parseInt(strU.substring(len2 - digit, len2)) + 1;
				if (digit + 1 == len2)
					front = 0;
				else
					front = Integer.parseInt(strU.substring(0, len2 - (digit + 1)));
				if (digit == 0)
					sum2 += (solve(9, digit, front) + solve(strU.charAt(len2 - (digit + 1)) - '0', digit, 1));
				else
					sum2 += (solve(9, digit, front) + solve(strU.charAt(len2 - (digit + 1)) - '1', digit, 1)
							+ (strU.charAt(len2 - (digit + 1)) - '0') * back);
			}
		}
		System.out.println(sum2 - sum);

	}

	static long solve(int end, int len, int c) {
		if (c == 0)
			return 0;
		int mul = (int) Math.pow(10, len);// if(len==0) mul = 1;
		long sum = 0;
		for (int i = 0; i <= end; i++) {
			sum += (i * mul);
		}
		return sum * c;
	}
}
