
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exam1463 {
	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			int N = Integer.parseInt(br.readLine());
			int[] result = new int[N+1];
			for(int i=1;i<N+1;i++) {
				if(i==1) {
					result[1]=0;
					continue;
				}
				result[i]=result[i-1]+1;
				
				if(i%2==0) {
					result[i]=Math.min(result[i], result[i/2]+1);
				}
				if(i%3==0) {
					result[i]=Math.min(result[i], result[i/3	]+1);
				}
				
			}
			
			System.out.println(result[N]);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
