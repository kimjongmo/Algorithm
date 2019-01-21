import java.util.Scanner;

public class BookExam342 {

	static int EMPTY = 500001;
	static int n;
	static int[] arr;
	static int[][] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			for(int j=0;j<n;j++) {
				cache[i][j] = EMPTY;
			}
		}
		
		
		sc.close();
	}

	static int play(int left,int right) {
		if(left>right) return 0;
		
		if(cache[left][right]!=EMPTY)
			return cache[left][right];
		
		int ret = Math.max(arr[left]-play(left+1,right), arr[right]-play(left,right-1));
	
		if(right-left+1>=2) {
			ret = Math.max(ret, -play(left+2,right));
			ret = Math.max(ret, -play(left,right-2));
		}
		
		cache[left][right] = ret;
		
		return ret;
			
	}
}
