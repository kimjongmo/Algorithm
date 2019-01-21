import java.util.Scanner;

public class BookExam308 {
	static int n; // n세대
	static int p; // p번째 글자부터
	static int l; // l개
	static int[] genLen;
	static int MAX = 1000000001;
	static String EXPAND_X = "X+YF";
	static String EXPAND_Y = "FX-Y";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		p = sc.nextInt();
		l = sc.nextInt();
		sc.close();
		genLen = new int[n];
		String seed = "FX";
		curve(seed, n,p);
	}

	static void precalc() {
		genLen[0] = 1;
		for (int i = 1; i < n; i++) {
			genLen[i] = Math.min(MAX, (genLen[i - 1] * 2) + 2);
		}
	}

	static char curve(String seed, int generations, int skip) {
		if (generations == 0) {
			return seed.charAt(skip);
		}

		for (int i = 0; i < seed.length(); i++) {
			if(seed.charAt(i)=='X' || seed.charAt(i)=='Y') {
				if(genLen[generations]<=skip) {
					skip -= genLen[generations];
				}
				else if(seed.charAt(i)=='X')
					return curve(EXPAND_X,generations-1, skip);
				else
					return curve(EXPAND_Y, generations-1, skip);
			}else if(skip>0)
				--skip;
			else
				return seed.charAt(i);
		}
		return '#';
	}
}
