import java.util.Scanner;

public class Exam5585 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] coin = {500,100,50,10,5,1};
		int en = 1000 - sc.nextInt();
		
		int idx = 0;
		int count = 0;
		while(en!=0) {
			if(en>=coin[idx]) {
				int m = en/coin[idx];
				en = en - (coin[idx]*m);
				count+=m;
			}
			idx++;
		}
		System.out.println(count);
		sc.close();
	}
}


