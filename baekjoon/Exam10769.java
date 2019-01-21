import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam10769 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String happy = ":-)";
		String sad =":-(";
		
		int happyCount = search(s, happy);
		int sadCount = search(s, sad);
		
		if(happyCount==0 && sadCount==0)
			System.out.println("none");
		else if(happyCount == sadCount )
			System.out.println("unsure");
		else if(happyCount > sadCount)
			System.out.println("happy");
		else if(happyCount < sadCount)
			System.out.println("sad");
	}
	
	static int search(String s, String pattern) {
		char[] ch = s.toCharArray();
		char[] p = pattern.toCharArray();
		int chLen = s.length();
		int pLen = pattern.length();
		int count=0;
		int j=0;
		for(int i=0;i<chLen;i++) {
			if(ch[i]==p[j]) {
				if(j==pLen-1) {
					count++;
					j=0;
				}else {
					j++;
				}
			}else {
				j=0;
			}
				
		}
		
		return count;
	}
}
