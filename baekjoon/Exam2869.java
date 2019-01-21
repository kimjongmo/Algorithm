import java.util.Scanner;

public class Exam2869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A=0;
		int B=0;
		int V=0;
			
		A = sc.nextInt(); 
		B = sc.nextInt(); 
		V = sc.nextInt(); 
			
		sc.close();
		
		//System.out.println(Integer.MAX_VALUE); 1.000.000.000은 넘는다...
		
		System.out.println((V-A-1)/(A-B)+2);
	}
}
