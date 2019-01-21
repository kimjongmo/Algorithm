import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam1701 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int max = -1;
		int len = s.length();
		for(int i=0;i<len;i++) {
			max = Math.max(max, getPi(s.substring(i)));
		}
		System.out.println(max);
	}

	static int getPi(String s) {
		char[] arr = s.toCharArray();
		int len = s.length();
		int[] pi = new int[len];
		int max = 0;
		int j=0;
		for (int i = 1; i < len; i++) {
			while (j > 0 && arr[i] != arr[j])
				j = pi[j - 1];
			if (arr[i] == arr[j]) {
				pi[i] = ++j;
				if (max < pi[i]) {
					max = pi[i];
				}
			}
		}

		return max;
	}
}
