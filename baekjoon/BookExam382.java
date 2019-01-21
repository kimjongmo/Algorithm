import java.util.PriorityQueue;
import java.util.Scanner;

public class BookExam382 {
	static PriorityQueue<Integer> queue = new PriorityQueue<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			queue.add(sc.nextInt());
		}

		int sum = 0;
		while (queue.size()>=2) {
			int len1 = queue.poll();
			int len2 = queue.poll();
			queue.add(len1+len2);
			sum+= len1+len2;
		}
		
		System.out.println(sum);
		sc.close();

	}
}
