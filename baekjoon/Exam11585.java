import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam11585 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String pattern = br.readLine();
		String s = br.readLine();
		int count = kmp(s+" "+s,pattern);
		int t = gcd(N,count);
		N = N/t;
		count = count/t;
		System.out.println(count+"/"+N);
	}
	
	static int[] getPi(String str) {
		int len = str.length();
		char[] s = str.toCharArray();
		int[] pi = new int[len];
		int j=0;
		
		for(int i=1;i<len;i++) {
			while(j>0 && s[i]!=s[j])
				j = pi[j-1];
			if(s[i]==s[j])
				pi[i] = ++j;
		}
		return pi;
	}
	
	static int gcd(int p, int q) {
		if(q==0) return p;
		return gcd(q,p%q);
	}
	
	static int kmp(String s, String pattern) {
		int count =0;
		int[] pi = getPi(pattern);

		int mLen = pattern.length();
		int sLen = s.length();

		char[] t = s.toCharArray();
		char[] p = pattern.toCharArray();
		
		int j = 0;
		for (int i = 0; i < sLen-1; i++) {
			while (j > 0 && t[i] != p[j]) {
				j = pi[j - 1];
			}
			if (t[i] == p[j]) {
				if (j == mLen - 1) {
					count++;
					j = pi[j];
				} else {
					j++;
				}
			}
		}
		return count;
	}
}
