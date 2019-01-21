package git_Algorithm;

import java.util.ArrayList;
import java.util.List;

public class LIS_Algorithm {
	static List<Integer> answer = new ArrayList<>();
	static int[] cache;
	public static void main(String[] args) {

	}

	static int lis(List<Integer> list) {
		if (list.size() == 0)
			return 0;
		int ret = 0;
		int len = list.size();
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (list.get(i) < list.get(j)) {
					answer.add(list.get(j));
				}
			}
			ret = Math.max(ret, 1 + lis(answer));
		}
		return ret;
	}
}
