import java.util.Arrays;
import java.util.Scanner;

public class BookExam320 {
	static String e, digits;
	static int n, m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		e = sc.next();
		m = sc.nextInt();
		n = e.length();
		boolean[] taken = new boolean[n];
		sc.close();
	
		char[] arr = e.toCharArray();
		Arrays.sort(arr);
		digits = String.valueOf(arr);
		System.out.println("digits:"+digits);
		
		generate("",taken);
	}
	
	static void generate(String price, boolean[] taken) {
		if(price.length()==n) {
			if(price.compareTo(e)<0) {
				System.out.println(price);
			}
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!taken[i] && (i==0 || digits.charAt(i-1)!=digits.charAt(i)|| taken[i-1])) {
				taken[i]=true;
				generate(price+digits.charAt(i), taken);
				taken[i]=false;
			}
		}
		
	}
}
