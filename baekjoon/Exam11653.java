import java.util.Scanner;

public class Exam11653 {
	public static void main(String[] args) {
		int MAX = 10000001;
		int[] num = new int[MAX];
		
		num[0]=num[1]=-1;
		for(int i=0;i<MAX;i++) {
			num[i]=i;
		}
		
		int end = (int)Math.sqrt(MAX);
		for(int i=2;i<=end;i++) {
			if(num[i]==i)
				for(int j=i*i;j<MAX;j+=i) {
					if(num[j]==j) {
						num[j]=i;
					}
				}
		}
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		while(N>1) {
			System.out.println(num[N]);
			N/=num[N];
		}
	}
}
