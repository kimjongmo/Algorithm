
public class EuclidAlgorithm {
	public static void main(String[] args) {
		System.out.println(gcd(25,6));
	}
	
	static int gcd(int p, int q) {
		if(q==0) return p;
		return gcd(q,p%q);
	}
}
