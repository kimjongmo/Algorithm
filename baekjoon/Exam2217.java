import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exam2217 {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int N = Integer.parseInt(br.readLine());
			Integer[] lope = new Integer[N];
			
			for(int i=0;i<N;i++) {
				lope[i]= Integer.parseInt(br.readLine());
			}
			
			//Arrays.sort(lope);
			List<Integer> list = Arrays.asList(lope);
			
			Collections.sort(list);
			Collections.reverse(list);
			
			int max= list.get(0);
			for(int i=1;i<N;i++) {
				max = Math.max(max, list.get(i)*(i+1));
			}
			
			System.out.println(max);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
