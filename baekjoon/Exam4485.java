import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam4485 {
	
	static int[][] list;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if(N==0)
				break;
			
			list= new int[N][N];  //N*N
			
			for (int i = 0; i < N; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					list[i][j]=Integer.parseInt(s[j]);
				}
			}
			
			//무엇인가
				
		}
		br.close();
	}
	
	
}
