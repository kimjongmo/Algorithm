import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exam3187 {
	static int R, C;
	static char[][] map;
	static boolean[][] visit;
	static Queue<Point> queue = new LinkedList<>();
	static int allSheep = 0, allWolf = 0;
	static int sheep = 0, wolf = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();

		map = new char[R][C];
		visit = new boolean[R][C]; // false �ʱ�ȭ
		sc.nextLine();
		for (int i = 0; i < R; i++) {
			char[] arr = sc.nextLine().toCharArray();
			map[i] = arr;
		}
		// ��ü ���� ����
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'k') {
					allSheep++;
				} else if (map[i][j] == 'v') {
					allWolf++;
				}
			}
		}


		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visit[i][j] == false && map[i][j] != '#') {
					traveling(i, j);
					if (sheep > wolf) {
						allWolf -= wolf;
					} else {
						allSheep -= sheep;
					}
					sheep = wolf = 0;
				}
			}
		}

		System.out.println(allSheep + " " + allWolf);

		sc.close();
	}

	static void traveling(int x, int y) {

		// �湮 Ȯ��
		if (visit[x][y] == true)
			return;

		visit[x][y] = true;
		if(map[x][y]=='k')
			sheep++;
		else if(map[x][y]=='v')
			wolf++;
			
		
		// ��
		if (x - 1 >= 0 && map[x - 1][y] != '#'&&!visit[x-1][y]) {
			queue.add(new Point(x - 1, y));
		}
		// �Ʒ�
		if (x + 1 < R && map[x + 1][y] != '#'&&!visit[x+1][y]) {
			queue.add(new Point(x + 1, y));
		}
		// ������
		if (y + 1 < C && map[x][y + 1] != '#'&&!visit[x][y+1]) {
			queue.add(new Point(x, y + 1));
		}
		// ����
		if (y - 1 >= 0 && map[x][y - 1] != '#'&&!visit[x][y-1]) {
			queue.add(new Point(x, y - 1));
		}

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			traveling(p.x, p.y);
		}
	}
}
