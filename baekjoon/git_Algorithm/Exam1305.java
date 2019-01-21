package git_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam1305 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int[] pi = getPi(s);
		System.out.println(n-pi[n-1]);
		
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
				pi[i]=++j;
		}
		return pi;
	}
}
