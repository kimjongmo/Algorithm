import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exam1654 {
	static int K;
	static int N;
	static int[] line;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		K = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		line = new int[K];

		for (int i = 0; i < K; i++) {
			line[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(line);

		System.out.println(binarySearch());
	}

	static long binarySearch() {
		long start = 1;
		long end = line[K - 1];
		long mid;
		while (start < end) {
			if(getLine(start)<N)
				return start-1;
			
			mid = (start + end) / 2;
			long count = getLine(mid);
			if (count == N) {
				start = mid + 1;
			} else if (count > N) {
				start = mid+1;
			} else {
				end = mid - 1;
			}

		}
		return start;
	}

	static long getLine(long len) {
		long total = 0;
		for (int length : line) {
			total += length / len;
		}
		return total;
	}
}
