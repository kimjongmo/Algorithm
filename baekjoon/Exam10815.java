import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exam10815 {
	static int[] array;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		array = new int[n];
		
		String[] str = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			array[i] = Integer.parseInt(str[i]);
		}
		
		Arrays.sort(array);
		
		int m = Integer.parseInt(br.readLine());
		
		int[] answer = new int[m];
		
		str = br.readLine().split(" ");
		for(int i=0;i<m;i++) {
			answer[i] = Integer.parseInt(str[i]);
		}
		
		for(int i=0;i<m;i++) {
			answer[i]=find(0,n-1,answer[i]);
		}
		
		
		for(int number : answer)
			System.out.println(number);
	}
	
	static int find(int start, int end,int num) {
		
		
		if(array[start]==num)
			return 1;
		if(array[end]==num)
			return 1;
		if(start==end || end-start==1)
			return 0;
		int middle = (start+end)/2;
		if(num>array[middle]) {
			return find(middle,end,num);
		}else {
			return find(start,middle,num);
		}
	}
}
