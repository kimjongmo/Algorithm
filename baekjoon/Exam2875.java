import java.util.Scanner;

public class Exam2875 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int female = sc.nextInt();
		int male = sc.nextInt();
		int intern = sc.nextInt();
		
		while(intern>0) {
			if(female > 2*male) {
				int free = female - 2*male;
				intern -= free;
				female -= free;
			}
			else if(female == 2*male) {
				female-=2;
				male-=1;
				intern -=3;
			}
			else {
				int free = male - female/2;
				intern -= free;
				male -= free;
			}
		}

		int result = female>(2*male)?male:female/2;
		System.out.println(result);
		sc.close();
		
	}
}
