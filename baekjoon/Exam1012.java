import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam1012 {
	static int[][] cabbage;
	static int[] result;
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int T = Integer.parseInt(br.readLine());
			result = new int[T];
			for(int i=0;i<T;i++) {
				
				//M N K  : 가로  세로 배추갯수
				String[] lines = br.readLine().split(" ");
				int M = Integer.parseInt(lines[0]);
				int N = Integer.parseInt(lines[1]);
				
				
				//배열 생성 및 초기화
				cabbage = new int[M][N];
				
				//배추 위치 초기화
				int len = Integer.parseInt(lines[2]);
				for (int j = 0; j < len; j++) {
					String[] location = br.readLine().split(" ");
					int x = Integer.parseInt(location[0]);
					int y = Integer.parseInt(location[1]);
					cabbage[x][y]=1;
				}
				
				result[i]=DFS();
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		for(int a : result) {
			System.out.println(a);
		}
	}
	
	static int DFS() {
		int worm = 0;
		for(int i=0;i<cabbage.length;i++) {
			for (int j = 0; j < cabbage[0].length; j++) {
				if(cabbage[i][j]==0)
					continue;
				else{
					find(i,j);
					worm++;
				}
			}
		}
		
		return worm;
	}
	//i-1,j 위 --> i-1이 마이너스가 되지 않는지
	//i+1,j 아래 --> i+1이 cabbage.length 를 넘어가지 않는지
	//i,j-1 왼쪽  --> j-1이 마이너스가 되지 않는지
	//i,j+1 오른쪽  --> j+1이 cabbage[0].length를 넘어가지 않는지
	static void find(int i, int j) {
		//i-1,j
		if(i!=0 && cabbage[i-1][j]==1) {
			cabbage[i-1][j]=0;
			find(i-1,j);
		}
		if(i+1<cabbage.length && cabbage[i+1][j]==1) {
			cabbage[i+1][j]=0;
			find(i+1,j);
		}
		if(j!=0 && cabbage[i][j-1]==1) {
			cabbage[i][j-1]=0;
			find(i,j-1);
		}
		if(j+1<cabbage[0].length && cabbage[i][j+1]==1) {
			cabbage[i][j+1]=0;
			find(i,j+1);
		}
	}
}

