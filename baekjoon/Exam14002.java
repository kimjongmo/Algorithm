import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam14002 {
	static int n;
	static int[] arr;
	static int[] cache;
	static int[] answer;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		cache = new int[n];
		answer = new int[n];
		String[] str = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(str[i]);
			cache[i]=-1;
		}
		
		int max = 0;
		int maxE = -1;
		for(int i=0;i<n;i++) {
			if(max<lis(i)) {
				max = lis(i);
				maxE = i;
			}
		}
		System.out.println(max);
		
		System.out.print(arr[maxE]+" ");
		while(true) {
			
			int nextE = answer[maxE];
			if(nextE==-1) break;
			System.out.print(arr[nextE]+" ");
			maxE = nextE; 
		}
	}

	static int lis(int start) {
		if (cache[start] != -1) {
			return cache[start];
		}

		int ret = 1;
		int nextE = -1;
		for (int next = start + 1; next < n; next++) {
			if (arr[start] < arr[next]) {
				if (ret < lis(next) + 1) {
					nextE = next;
					ret = lis(next) + 1;
				}
			}
		}
		answer[start] = nextE;
		cache[start] = ret;

		return ret;
	}

}
