import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam12015 {
	static int n;
	static int[] arr;
	static int[] cache;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		cache = new int[n];
		String[] str = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		cache[0] = arr[0];
		int lastIndex = 0;
		for(int i=1;i<n;i++) {
			if(cache[lastIndex]<arr[i]) {
				cache[++lastIndex] = arr[i];
			}else {
				cache[lowerBound(lastIndex,arr[i])] = arr[i];
			}
		}
		
		System.out.println(lastIndex+1);
	}
	
	
	static int lowerBound(int end,int target) {
		int start = 0;
		
		while(start<end) {
			int mid = (start+end)/2;
			
			if(cache[mid]>=target) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
		
		return end;
	}
	
}
