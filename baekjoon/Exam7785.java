import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Exam7785 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<String,Integer> map = new TreeMap<>(Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			if(str[1].equals("leave"))
				map.remove(str[0]);
			else 
				map.put(str[0], 1);
		}

		map.keySet().stream().forEach(n->System.out.println(n));
		
		br.close();
	}
}
