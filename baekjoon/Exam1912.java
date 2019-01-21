import java.util.Scanner;

public class Exam1912 {
	static int n;
	static int[] array;
	static int[] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		array = new int[n];
		cache = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		
		
		cache[0]=array[0];
		for(int i=1;i<n;i++) {
			if(cache[i-1]+array[i]>array[i]) {
				cache[i]=cache[i-1]+array[i];
			}else {
				cache[i]=array[i];
			}
		}
		
		int max = -100000000;
		for(int i=0;i<n;i++)
			max = Math.max(cache[i], max);
		
		System.out.println(max);
		
	}
}
