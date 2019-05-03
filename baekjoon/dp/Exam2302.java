package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam2302 {
	static int N;
	static int[] cache; // �¼��� �ִ� ���� 40
	static List<Integer> q = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		cache = new int[N+1];

		int M = sc.nextInt();

		int start = 1;
		int end;
		for (int i = 0; i < M; i++) {
			end = sc.nextInt();
			q.add(end - start);
			start = end+1;
		}
		end = N+1;
		q.add(end - start);

		cache[0]=1;
		cache[1]=1;
		for(int i=2;i<=N;i++) {
			cache[i] = cache[i-1] + cache[i-2];
		}
		
		int all = 1;
		for(int a : q) {
			all*=cache[a];
		}
		System.out.println(all);
		
		sc.close();
	}

}
