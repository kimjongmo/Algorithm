import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam4568 {
	
	static Queue<Character> cache = new LinkedList<>();
	static int cacheSize = 0;
	static StringTokenizer tokenizer = null;
	static int simul=1;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException{
		List<String> answer = new ArrayList<>();
		String read = br.readLine();
		while(!read.startsWith("0")) {
			cache.clear();
			answer.add("Simulation "+simul);
			String[] temp = read.split(" ");
			cacheSize = Integer.parseInt(temp[0]);
			for(int i=0;i<temp[1].length();i++) {
				char ch = temp[1].charAt(i);
				if(ch=='!') {
					String s="";
					Iterator<Character> iterator = cache.iterator();
					while(iterator.hasNext()) {
						s+=iterator.next();
					}
					answer.add(s);
				}else {
					cacheInput(ch);
				}
			}
			simul++;
			read = br.readLine();
		}
		
		for(String s : answer) {
			System.out.println(s);
		}
	}
	static void cacheInput(char ch) {

		// 캐시 적중
		if (cache.contains(ch)) {
			cache.remove(ch);
			cache.add(ch);
			return;
		}

		// 캐시 비적중
		if (cache.size() == cacheSize) {
			cache.poll();
		}
		cache.add(ch);
	}
}
