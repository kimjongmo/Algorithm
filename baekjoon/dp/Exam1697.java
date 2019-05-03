package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exam1697 {
	static int N, K; // ����, ����
	static Queue<Time> queue = new LinkedList<>();
	static int time = 0;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		visit = new boolean[2 * K];
		Arrays.fill(visit, false);

		if (N >= K) {
			time = N - K;
			System.out.println(time);
			sc.close();
			return;
		}
		// N < K
		travling(N, 0);
		System.out.println(time);

		sc.close();
	}

	static void travling(int start, int count) {

		// �̹� �湮������ �ִ�
		// = ������ count�� ���� ���¿��� ������ ��ȴٴ� ��. �׷��ٸ� ���ʿ��� �̹� �ּҰ��� ������ ����.
		if (visit[start]) {
			return;
		}
		visit[start] = true;

		// ��
		if ((start + 1) <= 100000 && !(start + 1 > K)) {
			queue.add(new Time(start + 1, count + 1));
		}

		// ��
		if ((start - 1) >= 0) {
			queue.add(new Time(start - 1, count + 1));
		}

		// �����̵�
		if ((2 * start) <= 100000 && !(2 * start > 2 * K)) {
			queue.add(new Time(2 * start, count + 1));
		}

		while (!queue.isEmpty()) {
			Time next = queue.poll();

			if (next.location == K) {
				time = next.cnt;
				while(!queue.isEmpty()) {
					queue.poll();
				}
			}else {
				travling(next.location, next.cnt);
			}
		}
	}

}

class Time {
	int location;
	int cnt;

	public Time(int location, int cnt) {
		this.location = location;
		this.cnt = cnt;
	}
}