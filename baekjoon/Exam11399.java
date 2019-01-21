import java.util.PriorityQueue;
import java.util.Scanner;

public class Exam11399 {
	static PriorityQueue<Integer> queue = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			queue.add(sc.nextInt());
		}
		sc.close();
		
		
		int time=0;//대기시간
		int sum =0;
		while(!queue.isEmpty()) {
			int using = queue.poll();
			time += using;
			sum += time;
		}
		
		System.out.println(sum);
	}
}
