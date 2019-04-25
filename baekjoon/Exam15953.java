import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Exam15953 {
	static int MANWON = 10000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		int T = Integer.parseInt(br.readLine());
		int[] answer = new int[T];
		while (--T >= 0) {
			String[] str = br.readLine().split(" ");
			int f1 = Integer.parseInt(str[0]);
			int f2 = Integer.parseInt(str[1]);

			int total = 0;

			if (f1 == 0)
				total += 0;
			else if (f1 <= 1)
				total += 500 * MANWON;
			else if (f1 <= 3)
				total += 300 * MANWON;
			else if (f1 <= 6)
				total += 200 * MANWON;
			else if (f1 <= 10)
				total += 50 * MANWON;
			else if (f1 <= 15)
				total += 30 * MANWON;
			else if (f1 <= 21)
				total += 10 * MANWON;
			
			if (f2 == 0)
				total += 0;
			else if (f2 <= 1)
				total += 512 * MANWON;
			else if (f2 <= 3)
				total += 256 * MANWON;
			else if (f2 <= 7)
				total += 128 * MANWON;
			else if (f2 <= 15)
				total += 64 * MANWON;
			else if (f2 <= 31)
				total += 32 * MANWON;
		
			answer[T]= total;
		}	
		
		for(int i = answer.length-1;i>=0;i--) {
			pw.println(answer[i]);
		}
		pw.flush();
	}
}
