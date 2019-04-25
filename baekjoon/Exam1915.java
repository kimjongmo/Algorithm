import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam1915 {

	static int n, m;
	static char[][] arr;
	static int[][] len;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] head = br.readLine().split(" ");
		n = Integer.parseInt(head[0]);
		m = Integer.parseInt(head[1]);
		
		arr = new char[n][m];
		
		for(int i=0;i<n;i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		
	}

	// 가능한 최대 정사각형의 길이
	static int maxLength(int x, int y) {

		int count = 0;

		int i = 0;

		while (x + i < n && y + i < m) {
			if (arr[x + i][y] == '1' && arr[x][y + i] == '1') {
				count++;
				i++;
			} else
				break;
		}

		return count;
	}
}
