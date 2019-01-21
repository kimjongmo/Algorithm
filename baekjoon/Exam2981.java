import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam2981 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		
		for(int i=0;i<N;i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		//소팅
		Arrays.sort(array);
		
		//M은 최대값을 넘어가지 않을것이다.
		int max = array[N-1];
		
		int min = array[0];
		
		List<Integer> answer = new ArrayList<>();
		
		for(int i=2;i<max;i++) {
			boolean flag = true;
			int val = min%i;
			for (int j = 1; j < array.length; j++) {
				if(array[j]%i!=val)
					flag = false;
			}
			if(flag)
				answer.add(i);
		}
		
		for(int i : answer)
			bw.write(i+" ");
		
		bw.flush();
		
		
	}
}
