import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BookExam376 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Lunch[] arr = new Lunch[N];
		for(int i=0;i<N;i++) {
			arr[i] = new Lunch();
			arr[i].mTime = sc.nextInt();
		}
		
		for(int i=0;i<N;i++) {
			arr[i].eTime = sc.nextInt();
		}

		Arrays.sort(arr, Comparator.comparing(Lunch::geteTime).reversed());
		
		int sum =0;
		
		for(int i=0;i<N-1;i++) {
			sum += arr[i].mTime;
		}
		sum += arr[N-1].mTime+arr[N-1].eTime;
		
		System.out.println(sum);
		
		sc.close();
	}
	
	
	
	static class Lunch{
		
		private int eTime;
		private int mTime;
		
		public int geteTime() {
			return eTime;
		}
		public void seteTime(int eTime) {
			this.eTime = eTime;
		}
		public int getmTime() {
			return mTime;
		}
		public void setmTime(int mTime) {
			this.mTime = mTime;
		}
		
		
	}
}
