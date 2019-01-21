import java.util.Scanner;

public class Exam1049 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int minSet= 1001;
		int minSingle = 1001;
		for(int i=0;i<M;i++) {
			minSet = Math.min(minSet, sc.nextInt());
			minSingle = Math.min(minSingle, sc.nextInt());
		}
		
		int setCount = N/6;
		int singleCount = N%6;
		
		int total = 0;
		if(minSet >= minSingle*6)
			total = N * minSingle;
		else if(minSet < singleCount*minSingle) {
			total = (setCount+1) * minSet;
		}else {
			total = setCount*minSet+singleCount*minSingle;
		}
		System.out.println(total);
		
		sc.close();
	}
}
