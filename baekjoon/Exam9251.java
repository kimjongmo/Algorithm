import java.util.Scanner;
import java.util.Stack;

public class Exam9251 {

	static int[][] cache;
	static String str1;
	static String str2;
	static Stack<Character> stack = new Stack<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		str1 ="0" + sc.nextLine();
		str2 ="0" + sc.nextLine();
		
		cache= new int[str1.length()][str2.length()];

		for(int i=1;i<str1.length();i++) {
			for(int j=1;j<str2.length();j++) {
				if(str1.charAt(i)==str2.charAt(j)) {
					cache[i][j]=cache[i-1][j-1]+1;
				}else {
					cache[i][j] = Math.max(cache[i-1][j], cache[i][j-1]);
				}
			}
		}
		
		System.out.println(cache[str1.length()-1][str2.length()-1]);

		sc.close();
		int x = str1.length()-1;
		int y = str2.length()-1;
		
		while(cache[x][y]!=0) {
			if(cache[x][y]==cache[x-1][y])
				x--;
			else if(cache[x][y]==cache[x][y-1]) {
				y--;
			}else if(cache[x][y]-1==cache[x-1][y-1]) {
				stack.push(str1.charAt(x));
				x--;
				y--;
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		
	}
	
	
	

	
}
