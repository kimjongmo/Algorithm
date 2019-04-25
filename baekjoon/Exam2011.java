import java.util.Arrays;
import java.util.Scanner;

public class Exam2011 {
	static char[] pw;
	static int[] cache;
	static int MOD = 1000000;
	static boolean flag = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		pw = s.toCharArray();
		cache = new int[pw.length];
		Arrays.fill(cache, -1);

		if (pw[0] == '0') {
			System.out.println("0");
			return;
		}

		int answer = dp(0);
		if (flag) {
			System.out.println("0");
		} else {
			System.out.println(answer);
		}

	}

	// start���� �����ؼ� ���κб��� ������ ������
	static int dp(int start) {

		if (start >= pw.length - 1) {
			if (start == pw.length - 1)
				return pw[start] == '0' ? 0 : 1; // �ڿ� ���ڰ� 0�� ��� ��ȿ
			return 1;
		}
		// ĳ��
		if (cache[start] != -1)
			return cache[start];

		int ret = 0;

		int now = pw[start] - '0';
		int next = pw[start + 1] - '0';

		if (now == 0)
			return 0;

		int num = now * 10 + next;
		if (1 <= now && now <= 9) {
			ret += dp(start + 1);
			ret %= MOD;
		}

		if (num <= 26) {
			ret += dp(start + 2);
			ret %= MOD;
		}

		cache[start] = ret;

		return ret;

	}
}