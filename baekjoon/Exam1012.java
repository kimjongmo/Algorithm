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
				
				//M N K  : ����  ���� ���߰���
				String[] lines = br.readLine().split(" ");
				int M = Integer.parseInt(lines[0]);
				int N = Integer.parseInt(lines[1]);
				
				
				//�迭 ���� �� �ʱ�ȭ
				cabbage = new int[M][N];
				
				//���� ��ġ �ʱ�ȭ
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
	//i-1,j �� --> i-1�� ���̳ʽ��� ���� �ʴ���
	//i+1,j �Ʒ� --> i+1�� cabbage.length �� �Ѿ�� �ʴ���
	//i,j-1 ����  --> j-1�� ���̳ʽ��� ���� �ʴ���
	//i,j+1 ������  --> j+1�� cabbage[0].length�� �Ѿ�� �ʴ���
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

