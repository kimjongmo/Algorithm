import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.remove(1);
		list.add(1,5);
		
		
		for(int a : list)
			System.out.print(a+" ");
	} 
}
