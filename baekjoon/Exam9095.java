import java.util.Scanner;

public class Exam9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		int[] cache = new int[test];
		
		for(int i=0;i<test;i++)
			cache[i]=sc.nextInt();
		
		for(int a : cache)
			System.out.println(count(a,0));
		sc.close();
	}
	
	static int count(int target,int sum) {
		if(sum==target) {
			return 1;
		}
		if(sum>target) {
			return 0;
		}
		int count=0;
		
		for(int i=1;i<=3;i++) {
			sum+=i;
			count+=count(target,sum);
			sum-=i;
		}
		
		return count;
	}
}
