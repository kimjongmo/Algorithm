import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import com.sun.prism.impl.ps.CachingEllipseRep;

public class LRUAlgorithm {

	static Queue<String> cache = new LinkedList<>();
	static int OP_TIME = 0;
	static String[] request;
	static int cacheSize = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cacheSize = Integer.parseInt(br.readLine());
		int citySize = Integer.parseInt(br.readLine());

		request = new String[citySize];

		for (int i = 0; i < citySize; i++) {
			request[i] = br.readLine();

			cacheInput(request[i]);
		}

		System.out.println(OP_TIME);
	}

	static void cacheInput(String s) {
		
		//캐시 적중
		if(cache.contains(s)) {
			cache.remove(s);
			cache.add(s);
			OP_TIME+=1;
			return;
		}
		
		//캐시 비적중
		if (cache.size() == cacheSize) {
			cache.poll();
		}
		
		cache.add(s);
		OP_TIME += 5;
	}

}
