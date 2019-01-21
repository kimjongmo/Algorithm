import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam1010 {
	static int T;
	static int N;
	static int M;
	static Long[][] cache;
	static Long[] answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		answer = new Long[T];
		for(int i=0;i<T;i++) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
			cache = new Long[N][M];
			for(int n=0;n<N;n++) {
				for(int m=0;m<M;m++) {
					cache[n][m]=-1L;
				}
			}
			answer[i]=dp(N, M);
		}
		
		for(long a : answer) {
			System.out.println(a);
		}
	}
	//왼쪽 남은 사이트, 오른쪽 남은 사이트
	static long dp(int indexA,int indexB) {
		//왼쪽 남은 사이트가 하나일 때의 경우의 수
		if(indexA==1) {
			return indexB;
		}
		//메모라이제이션
		if(cache[indexA-1][indexB-1]!=-1) {
			return cache[indexA-1][indexB-1];
		}
		
		if(indexA==indexB) {
			cache[indexA-1][indexB-1]=1L;
			return 1;
		}
		long sum=0;
		
		for(int i=indexB-1;i>=indexA-1;i--) {
			sum+=dp(indexA-1,i);
		}
		cache[indexA-1][indexB-1]=sum;
		
		return sum;
		
	}
	
	
}
