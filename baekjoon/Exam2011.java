import java.util.Scanner;

public class Exam2011 {
	static String pw;
	static int[] cache;
	static int MOD = 1000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		pw = sc.nextLine();
		cache = new int[pw.length()];
		for (int i = 0; i < cache.length; i++)
			cache[i] = -1;

		if(pw.charAt(0)=='0') {
			System.out.println(0);
			sc.close();
			return;
		}
		System.out.println(getAll(0));
		
		for (int i = 0; i < cache.length; i++)
			System.out.println(cache[i]);
		sc.close();
	}

	static int getAll(int start) {
		
		if (start == pw.length() - 1) {
			cache[start] = 1;
			return 1;
		}
		if (cache[start] != -1)
			return cache[start];
		
		int number = Integer.parseInt(pw.substring(start, start + 2));
		if(start == pw.length() - 2) {
			if(0 < number && number <= 26) {
				cache[start] = (1+getAll(start+1))%MOD;
			}else {
				cache[start] = getAll(start+1)%MOD;
			}
			return cache[start];
		}
		int ch = pw.charAt(start)-'0';
		int ch1 = pw.charAt(start + 1)-'0';
		int ch2 = pw.charAt(start + 2)-'0';
		if(ch1==0 && ch2==0 || ch1==0 && ch>2||ch2==0 && ch1>2) {
			System.out.println(0);
			System.exit(1);
		}
		if (ch1 == 0) {
			cache[start] = getAll(start + 2)%MOD;
		} else if (ch2 == 0) {
			cache[start] = getAll(start + 1)%MOD;
		} else if (0 < number && number <= 26) {
			cache[start] = getAll(start + 2)%MOD + getAll(start + 1)%MOD;
			cache[start]%=MOD;
		} else {
			cache[start] = getAll(start + 1)%MOD;
		}
		return cache[start];
	}

}
