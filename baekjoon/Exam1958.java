import java.util.Scanner;

public class Exam1958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = "0" + sc.nextLine();
		String s2 = "0" + sc.nextLine();
		String s3 = "0" + sc.nextLine();
		int[][][] cache = new int[s1.length()][s2.length()][s3.length()];
		for (int x = 1; x < s1.length(); x++) {
			for (int y = 1; y < s2.length(); y++) {
				for (int z = 1; z < s3.length(); z++) {
					char c1 = s1.charAt(x);
					char c2 = s2.charAt(y);
					char c3 = s3.charAt(z);
					if(c1==c2 && c2==c3) {
						cache[x][y][z] = cache[x-1][y-1][z-1]+1;
					}else {
						cache[x][y][z] = Math.max(cache[x][y-1][z], cache[x-1][y][z]);
						cache[x][y][z] = Math.max(cache[x][y][z],cache[x][y][z-1]);
					}
						
				}
			}
		}
		sc.close();
		System.out.println(cache[s1.length()-1][s2.length()-1][s3.length()-1]);
	}
}
