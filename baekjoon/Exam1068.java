import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Exam1068 {
	public static void main(String[] args) {
		Node root = null;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int N = Integer.parseInt(br.readLine());

			StringTokenizer token = new StringTokenizer(br.readLine(), " ");

			Node[] nodes = new Node[N]; // N���� ����� ������ ��´�.
			int[] parents = new int[N]; // �Է¹��� ����� �θ��� ������ ��´�.

			for (int i = 0; i < N; i++) {
				nodes[i] = new Node(i);// �⺻ �ʱ�ȭ
			}

			for (int i = 0; i < N; i++) {
				int parent = Integer.parseInt(token.nextToken());

				if (parent == -1)// �θ��� ������ -1�̸� ��Ʈ.
					root = nodes[i];
				else {
					parents[i] = parent;
					nodes[parent].nodes.add(nodes[i]);// �θ� ��忡 �ڽ� ��带 �߰��Ѵ�.
				}
			}
			int num = Integer.parseInt(br.readLine());
			nodes[parents[num]].nodes.remove(nodes[num]);// �θ� ��忡�� ����.
			if(num==root.number)
				System.out.println("0");
			else {
				int result = root.find(0); // root�������� ���� ��带 ã�´�.
				System.out.println(result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class Node {

	int number;
	ArrayList<Node> nodes = new ArrayList<>();

	public Node(int number) {
		this.number = number;
	}

	public int find(int count) {
		// �ڽ� ��尡 ���� => ���� ��� ������ 1�߰� �� ����
		if (nodes.size() == 0) {
			// System.out.println("*"+number);
			return count + 1;
		}

		// �ڽ��� �ִٸ� => �� ��忡�� �ٽ� find ȣ��
		else {
			for (Node node : nodes) {
				count = node.find(count);
			}
		}
		return count;
	}
}
/*
 * 12 -1 0 0 0 1 2 2 4 6 6 7 8
 */
