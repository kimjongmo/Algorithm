import java.util.Scanner;

public class Exam2455 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max=0;
		int now=0;
		for(int i=0;i<4;i++) {
			String[] str = sc.nextLine().split(" ");
			int out = Integer.parseInt(str[0]);
			int in = Integer.parseInt(str[1]);
			now -= out;
			now += in;
			//System.out.println("나간 사람:"+out+",들어온 사람:"+in+",현재 인원:"+now);
			if(max<now) {
				max=now;
			}
		}
		
		max =max>10000?max=10000:max;
		System.out.println(max);
		sc.close();
	}
}
