import java.util.Scanner;

public class Exam1120 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		String s1 = sc.next();
		String s2 = sc.next();
		
		int min = 50;
		for(int i=0;i<s2.length()-s1.length()+1;i++) {
			int count =0;
			for(int j=0;j<s1.length();j++) {
				if(s1.charAt(j)!=s2.charAt(j+i)) {
					count++;
				}
			}
			min = Math.min(min, count);
		}
		System.out.println(min);
		sc.close();
		
		
		
		
	}

}
