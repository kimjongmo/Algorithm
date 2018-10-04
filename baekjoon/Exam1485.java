import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Exam1485 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			Point[] points = new Point[4];
			
			for(int j=0;j<4;j++) {
				String[] str = br.readLine().split(" ");
				points[j] = new Point(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
			}
			
			Arrays.sort(points,new Comparator<Point>() {
				@Override
				public int compare(Point o1, Point o2) {
					if(o1.x<o2.x) {
						return -1;
					}else if(o1.x > o2.x) {
						return 1;
					}else {
						if(o1.y>o2.y) {
							return 1;
						}else if(o1.y==o2.y) {
							return 0;
						}else
							return -1;
					}
				}
			});
			double a = points[0].distance(points[1]);
			double b = points[0].distance(points[2]);
			double c = points[3].distance(points[1]);
			double d = points[3].distance(points[2]);
			double e = points[0].distance(points[3]);
			double f = points[1].distance(points[2]);
			if((a==b&&b==c&&c==d)&&e==f) {
				System.out.println(1);
			}else
				System.out.println(0);
			
		}
	
		
		
		br.close();
	}
}
