import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Exam1946 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[] result = new int[T];

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			Employee[] employees = new Employee[N];

			for (int i = 0; i < N; i++) {
				employees[i] = new Employee(sc.nextInt(), sc.nextInt());
			}

			// test1의 성적이 낮은 순으로 정렬
			Arrays.sort(employees, Comparator.comparing(Employee::getTest1));

			int count = N;
			// 뒤에 인원들은 자신보다 이미 test1의 성적이 높기에 test2도 높다면 짤린다.
			int temp = employees[0].getTest2();
			for (int i = 1; i < N; i++) {
				if(temp >= employees[i].getTest2()) {
					temp = employees[i].getTest2();
					continue;
				}
				count--;
			}
			
			result[t] = count;
		}

		sc.close();
		
		for(int r : result) {
			System.out.println(r);
		}
	}

	static class Employee {

		private int test1;
		private int test2;

		public Employee(int test1, int test2) {
			this.test1 = test1;
			this.test2 = test2;
		}

		public int getTest1() {
			return test1;
		}

		public void setTest1(int test1) {
			this.test1 = test1;
		}

		public int getTest2() {
			return test2;
		}

		public void setTest2(int test2) {
			this.test2 = test2;
		}

	}
}
