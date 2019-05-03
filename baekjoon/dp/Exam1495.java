package dp;

import java.util.Arrays;
import java.util.Scanner;

public class Exam1495 {
	/* N = ����Ʈ�� ����. S = ���� ����. M = �ִ� ���� ��ġ. */
	static int N, S, M; // 1<= <=M
	static int[] volume;
	static int[][] cache;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();
		M = sc.nextInt();

		volume = new int[N];
		for (int i = 0; i < N; i++) {
			volume[i] = sc.nextInt();
		}
		
		cache = new int[M+1][N];
		for(int i=0;i<=M;i++) {
			Arrays.fill(cache[i], -2);
		}
		

		System.out.println(control(S,0));
		sc.close();
	}
	
	/*
	 * nowVol = ���� ����
	 * order = �� ��° ��������
	 * */
	static int control(int nowVol, int order) {
		if(order==N) {
			return nowVol;
		}
		
		if(cache[nowVol][order]!=-2)
			return cache[nowVol][order];
		
		int ret = -1;
		
		if(nowVol+volume[order]<=M) {
			ret = Math.max(ret, control(nowVol+volume[order], order+1));
		}
		
		if(nowVol-volume[order]>=0) {
			ret = Math.max(ret, control(nowVol-volume[order], order+1));
		}
		
		cache[nowVol][order] = ret;
		
		return ret;
	}
}
