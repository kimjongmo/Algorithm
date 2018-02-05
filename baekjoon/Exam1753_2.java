import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Exam1753_2 {
	
	public static void main(String[] args) {
		BufferedReader br=null;
		Map<Integer,Vector<Line>> map = new HashMap<>();	//해당 간선의 리스트
		
		int totalV;//전체 정점의 갯수
		int totalE;//전체 간선의 갯수
		int start;//시작 정점
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			totalV =br.read();
			totalE =br.read();
			start  =br.read();
			
			for(int i=1;i<=totalV;i++) {
				Vector<Line> lines= new Vector<>();
				for(int j=1;j<=totalV;j++) {
					lines.add(new Line(j));
				}
				map.put(i,lines);
			}
			
			for(int i=1;i<=totalE;i++) {
				Vector<Line> lines = map.get(i);
				
			}
			
			
			
			
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
class Line implements Comparable<Line>{
	int v;			//정점
	int w=200001;	//간선 가중치 , 최대값 10*20,000를 넘지 못한다. 따라서 200001은 무한대를 의미함.
	
	public Line(int v) {
		this.v = v;
	}
	public Line(int v, int w) {
		this.v = v;
		this.w = v;
	}

	public int compareTo(Line line) {
		if(this.w==line.w) {
			return 0;
		}else if(this.w>line.w) {
			return 1;
		}else {
			return -1;
		}
	}
}
