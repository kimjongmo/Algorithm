import java.util.Scanner;

public class Exam12865 {
	static int N;
	static int K;
	static int[] volume;
	static int[] value;
	static int[][] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		volume = new int[N];
		value = new int[N];
		cache = new int[K + 1][N];

		for (int j = 0; j < N; j++) {
			volume[j] = sc.nextInt();
			value[j] = sc.nextInt();
			for(int i=0;i<K+1;i++) {
				cache[i][j]=-1;
			}
		}
		
		System.out.println(pack(K,0));
		
		

		sc.close();
	}
	
	static int pack(int capacity, int item) {
		if(item==N) {
			return 0;
		}
		if(cache[capacity][item]!=-1) {
			return cache[capacity][item];
		}
		
		int unPack = pack(capacity,item+1);
		int ret = unPack;
		if(capacity >= volume[item]) {
			int packing = pack(capacity-volume[item],item+1)+value[item];
			ret = Math.max(ret,packing);
		}
		cache[capacity][item]= ret;
		return ret;
	}
}
