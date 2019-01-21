

import java.util.ArrayList;
import java.util.List;

public class ImprovedEuclidAlgorithm {
	static List<Integer> s = new ArrayList<>();
	static List<Integer> t = new ArrayList<>();
	static List<Integer> r = new ArrayList<>();
	static List<Integer> q = new ArrayList<>();
	static int i = 2;
	
	public static void main(String[] args) {
		
		int a=26;
		int b=8;
		
		s.add(1);
		s.add(0);
		t.add(0);
		t.add(1);
		r.add(a);
		r.add(b);
		q.add(null);
		q.add(Math.floorDiv(a,b));
		
		igcd();
		System.out.println(gcd(a,b));
		System.out.println(a+"*"+s.get(i-1)+"+"+b+"*"+t.get(i-1)+"="+r.get(i-1));
	}
	
	static void igcd() {
		if(r.get(i-2)-r.get(i-1)*q.get(i-1)==0) {
			return;
		}
		
		s.add(s.get(i-2)-s.get(i-1)*q.get(i-1));
		t.add(t.get(i-2)-t.get(i-1)*q.get(i-1));
		r.add(r.get(i-2)-r.get(i-1)*q.get(i-1));
		q.add(Math.floorDiv(r.get(i-1), r.get(i)));
		i++;
		
		igcd();
	}
	static int gcd(int a, int b) {
		if(b==0) return a;
		return gcd(b,a%b);
	}
}
