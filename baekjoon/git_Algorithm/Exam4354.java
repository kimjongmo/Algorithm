package git_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exam4354 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		String s;
		while(!(s=br.readLine()).equals(".")) {
			int len = s.length();
			int[] pi = getPi(s);
			int answer = len-pi[len-1];
			if(len%answer!=0) {
				list.add(1);
			}else {
				list.add(len/answer);
			}
		}
		
		for(int answer : list)
			System.out.println(answer);
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
}
