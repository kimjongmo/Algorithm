import java.util.Scanner;

public class Exam2003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();

		int count=0;
		for(int i=0;i<n;i++) {
			int sum = 0;
			for(int j=i;j<n;j++) {
				sum+=arr[j];
				if(sum >m) {
					break;
				}else if(sum == m) {
					count++;
					break;
				}
			}
		}
		
		
		System.out.println(count);
	}
}
