import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithm {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(System.out);

	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		String pattern = br.readLine();
		kmp(s, pattern);
	}

	public static int[] getPi(String pattern) {
		int m = pattern.length();
		int j = 0;
		char[] p = new char[m];
		int[] pi = new int[m];
		p = pattern.toCharArray();
		for (int i = 1; i < m; i++) {
			while (j > 0 && p[i] != p[j]) {
				j = pi[j - 1];
			}
			if (p[i] == p[j]) {
				pi[i] = ++j;
			}
		}
		return pi;
	}

	static void kmp(String s, String pattern) {
		List<Integer> list = new ArrayList<>();
		int[] pi = getPi(pattern);

		int mLen = pattern.length();
		int sLen = s.length();

		char[] t = s.toCharArray();
		char[] p = pattern.toCharArray();
		
		int j = 0;
		for (int i = 0; i < sLen; i++) {
			while (j > 0 && t[i] != p[j]) {
				j = pi[j - 1];
			}
			if (t[i] == p[j]) {
				if (j == mLen - 1) {
					list.add(i - j + 1);
					j = pi[j];
				} else {
					j++;
				}
			}
		}
		pw.println(list.size());
		for (int idx : list)
			pw.print(idx + " ");
		pw.flush();

	}
}
