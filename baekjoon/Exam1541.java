import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Exam1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		br.close();
		if (s.contains("-")) {
			StringTokenizer token = new StringTokenizer(s,"-");
			
			int total = Integer.parseInt(token.nextToken());

			while(token.hasMoreTokens()) {
				String str = token.nextToken();
				if(str.contains("+")) {
					total -=cal(str);
				}else {
					total -= Integer.parseInt(str);
				}
			}
			System.out.println(total);
		}else {
			System.out.println(cal(s));
		}
	}

	static int cal(String s) {
		StringTokenizer token = new StringTokenizer(s, "+");

		int ret = 0;
		while (token.hasMoreTokens()) {
			ret += Integer.parseInt(token.nextToken());
		}
		return ret;
	}
}
