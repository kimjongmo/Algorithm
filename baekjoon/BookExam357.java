import java.util.Scanner;

public class BookExam357 {
	static int n;
	static int m;
	static int[] price;
	static int[] priority;
	static int[] cache;

	public static void main(String[] args) {
		int mb = 1024 * 1024;
		Runtime runtime = Runtime.getRuntime();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		price = new int[n];
		priority = new int[n];
		cache = new int[m + 1];

		for (int i = 0; i < n; i++) {
			price[i] = sc.nextInt();
			priority[i] = sc.nextInt();
		}

		for(int i=0;i<=m;i++) {
			cache[i]=-1;
		}
//		for(int i=0;i<=m;i++) {
//			cache[i] = 0;
//			for(int j=0;j<n;j++) {
//				if(i>=price[j])
//					cache[i] = Math.max(cache[i], cache[i-price[j]]+priority[j]);
//			}
//		}
		
		System.out.println(sushi(m));
		System.out.println("Total Memory : " + runtime.totalMemory());
		System.out.println("Free Memory : " + runtime.freeMemory());
		System.out.println("Used Memory :" + (runtime.totalMemory() - runtime.freeMemory()) + "bit");
		sc.close();
	}

	static int sushi(int budget) {
		if (cache[budget] != -1) {
			return cache[budget];
		}
		
		int ret = 0;
		for (int dish = 0; dish < n; dish++) {
			if(budget < price[dish]) {
				continue;
			}else
				ret = Math.max(ret, sushi(budget-price[dish])+priority[dish]);
		}
		cache[budget] = ret;
		return ret;
	}
}

/*
 * 6 10000 2500 7 3000 9 4000 10 5000 12 10000 20 15000 1 Total Memory :
 * 128974848 Free Memory : 126930024 Used Memory :2044824bit
 */
