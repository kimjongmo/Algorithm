import java.util.Scanner;

public class Exam1753 {
	static final int INFINITY = 1000000;	
	static int[][] distance;	//최소 거리
	static boolean[] visit;		//방문 여부
	static int[][] weight;		//각 정점 간의 가중치
	
	//해당 정점과 이어진 간선 중 최소의 간선을 고른다. 우선순위큐 이용하기
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		///////////////////////////////입력 부분
		
		int V = sc.nextInt();	//정점의 갯수
		int E = sc.nextInt();	//간선의 갯수
		int startV = sc.nextInt();	//시작점
		
		distance = new int[V][V];//최소거리
		visit = new boolean[V];//방문 여부
		weight = new int[V][V];//간선 값
		
		for(int i=0;i<E;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			weight[u-1][v-1]=w;//****weigh[1][2] 정점 2에서 3까지의 간선
		}
		
		/////////////////////////////입력 부분
		
		
		////////////////////////////
		for(int u=0;u<V;u++) {
			for(int v=0;v<V;v++) {
				if(u==v) {
					weight[u][v] = 0;
				}else if(weight[u][v]==0) {
					weight[u][v]= INFINITY;	
				}
			}
		}
		////////////////////////////
		/*간선이 없는 부분 = 무한대, 자신과의 길이는 =0 */
		
	}
	
	
}

//5 6 1 5 1 1 1 2 2 1 3 3 2 3 4 2 4 5 3 4 6