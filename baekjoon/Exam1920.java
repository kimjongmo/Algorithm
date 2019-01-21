import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class Exam1920 {

	static int N;
	static int[] A;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		
		String[] str = br.readLine().split(" ");
		for(int i=0;i<N;i++)
			A[i] = Integer.parseInt(str[i]);
		
		Arrays.sort(A);
		
		int M = Integer.parseInt(br.readLine());
		str = br.readLine().split(" ");
		for(int i=0;i<M;i++) {
			writer.println(binarySearch(Integer.parseInt(str[i])));
		}
		writer.flush();
	}
	
	static int binarySearch(int target) {
		int start = 0;
		int end = N-1;
		int mid;
		if(A[end]<target || A[start]>target)
			return 0;
		while(start<end) {
			if(A[end]==target || A[start]==target)
				return 1;
			mid = (start+end)/2;
			if(target < A[mid]) {
				end = mid;
			}else if(target > A[mid]) {
				start = mid+1;
			}else {
				return 1;
			}
		}
		return 0;
	}
}
