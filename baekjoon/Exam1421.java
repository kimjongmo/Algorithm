import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam1421 {
	static int N =0;
	static int C =0;
	static int W =0;
	static int[] trees = null;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);// 1,000보다 작거나 같은 자연수
		C = Integer.parseInt(str[1]);// 10,000 보다 작거나 같은 자연수
		W = Integer.parseInt(str[2]);// 10,000 보다 작거나 같은 자연수
		
		trees = new int[N];
		int maxLegnth=0;
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(br.readLine());
			if(trees[i]>maxLegnth) {
				maxLegnth = trees[i];
			}
		}
		
		int maxValue = 0;
		for(int i=1;i<=maxLegnth;i++) {
			maxValue = Math.max(maxValue, cut(i));
		}
		System.out.println(maxValue);
	
	}
	
	static int cut(int length) {
		int allAmount=0;	//전체 양
		int allCuttingCost=0;//전체 들어가는 커팅 비용
		
		for(int i=0;i<N;i++) {
			int tree = trees[i];
			if(tree>=length) {
				//커팅 횟수
				int cuttingCount;
				// 갯수
				int amount;
				if(tree%length==0) {
					amount = tree/length;
					cuttingCount = amount-1;
				}else {
					amount = tree/length;
					cuttingCount = amount;
				}
				// 커팅 비용
				int cuttingCost = cuttingCount*C;		
				//자르면 손해인 나무
				if((amount*length*W)-cuttingCost<0) {
					continue;
				}else {
					allAmount+=amount;
					allCuttingCost +=cuttingCost;
				}
			}
		}
		
		return allAmount*W*length-allCuttingCost;
	}
	
	

}
/*
 * 
N C W
3 1 10
26
103
59
*/
