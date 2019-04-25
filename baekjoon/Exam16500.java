import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam16500 {
	static char[] s;
	static String[] a;
	static int A;
	static int[][] cache;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine().toCharArray();
		A = Integer.parseInt(br.readLine());
		a = new String[A];
		cache = new int[s.length][A];
		for(int i=0;i<A;i++) {
			a[i] = br.readLine();
		}
		
		int result = search(0);
		System.out.println(result);
	}
	
	static int search(int index) {
		
		int ret = 0;
		for(int i=0;i<A;i++) {
			if(isEquals(index,i)==1) {
				int result = search(index+a[i].length());
				if(result==1)
					return 1;
			}
		}
		return ret;
	}
	
	static int isEquals(int index, int n) {
		if(cache[index][n]!=-1)
			return cache[index][n];
		char[] ch = a[n].toCharArray();
		int k = ch.length;
		
		int len = s.length;
		
		if(index+k>len)
			return 0;
		
		int ret = 1;
		for(int i=0;i<k;i++) {
			if(s[index++]!=ch[i]) {
				ret = 0;
				break;
			}
		}
		
		return ret;
	}
}
