import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exam11004 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(tokenizer.nextToken());
		int K = Integer.parseInt(tokenizer.nextToken());
		 
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		tokenizer = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			queue.add(Integer.parseInt(tokenizer.nextToken()));
		}
		
		while(--K > 0) {
			queue.poll();
		};
		System.out.println(queue.poll());
		
		
		
	}
}
