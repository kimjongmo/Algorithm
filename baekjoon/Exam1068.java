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

			Node[] nodes = new Node[N]; // N개의 노드의 정보를 담는다.
			int[] parents = new int[N]; // 입력받은 노드의 부모의 정보를 담는다.

			for (int i = 0; i < N; i++) {
				nodes[i] = new Node(i);// 기본 초기화
			}

			for (int i = 0; i < N; i++) {
				int parent = Integer.parseInt(token.nextToken());

				if (parent == -1)// 부모의 정보가 -1이면 루트.
					root = nodes[i];
				else {
					parents[i] = parent;
					nodes[parent].nodes.add(nodes[i]);// 부모 노드에 자식 노드를 추가한다.
				}
			}
			int num = Integer.parseInt(br.readLine());
			nodes[parents[num]].nodes.remove(nodes[num]);// 부모 노드에서 삭제.
			if(num==root.number)
				System.out.println("0");
			else {
				int result = root.find(0); // root에서부터 리프 노드를 찾는다.
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
		// 자식 노드가 없다 => 리프 노드 갯수에 1추가 후 리턴
		if (nodes.size() == 0) {
			// System.out.println("*"+number);
			return count + 1;
		}

		// 자식이 있다면 => 각 노드에서 다시 find 호출
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
