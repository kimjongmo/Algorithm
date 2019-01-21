import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BookExam282 {
	static int N; // 물건의 총 갯수
	static int W; // 캐리어의 최대 용량
	static Stuff[] stuffs;
	static int[][] cache;
	static int[] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		W = Integer.parseInt(tokenizer.nextToken());
		
		stuffs = new Stuff[N];
		cache = new int[W+1][N];
		answer = new int[N];
		for(int i=0;i<W+1;i++) {
			for(int j=0;j<N;j++) {
				cache[i][j]=-1;
				answer[j]=-1;
			}
		}
		for(int i=0;i<N;i++) {
			tokenizer = new StringTokenizer(br.readLine(), " ");
			String name = tokenizer.nextToken();
			int v = Integer.parseInt(tokenizer.nextToken());
			int priority = Integer.parseInt(tokenizer.nextToken());
			stuffs[i] = new Stuff(name,v,priority);
		}
		
		System.out.print(pack(W,0)+" ");
		
		int idx=0;
		for(int i=0;i<N-1;i++) {
			if(cache[W][i]!=cache[W][i+1]) {
				answer[idx++] = i;
			}
		}
		System.out.println(idx);
		for(int a : answer) {
			if(a != -1) {
				System.out.println(stuffs[a].name);
			}
		}
		
	}
	
	static int pack(int capacity, int item) {
		if(item == N) 
			return 0;
		if(cache[capacity][item]!=-1)
			return cache[capacity][item];
	
		int packOut = pack(capacity,item+1);
		if(capacity>=stuffs[item].v) {
			int packIn = pack(capacity-stuffs[item].v,item+1)+stuffs[item].priority;
			cache[capacity][item] = Math.max(packOut, packIn);
		}else {
			cache[capacity][item] = packOut;
		}
		
		return cache[capacity][item];
	}
	
	static class Stuff{
		String name;
		int v;
		int priority;
		
		public Stuff(String name, int v, int priority) {
			this.name = name;
			this.v = v;
			this.priority = priority;
		}
		
		
	}
}


/*
6 17
laptop 4 7
camera 2 10
xbox 6 6
grinder 4 7
dumbell 2 5
encyclopedia 10 4
 * */