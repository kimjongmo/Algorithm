
public class BookExam337 {
	
	static int[] cache = new int[19683];
	public static void main(String[] args) {
		
	}
	static boolean isFinished(String board, char turn) {
		return false;
	}
	static int bijection(String board) {
		int ret = 0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				int idx = 3*i + j;
				char ch = board.charAt(idx);
				if(ch == 'o') {
					ret+= Math.pow(3, idx);
				}else if(ch == 'x')
					ret+= 2*Math.pow(3, idx);
			}
		}
		
		return ret;
	}
	
	static int canWin(String board, char turn) {
		StringBuilder builder;
		char opTurn = turn=='o'?'x':'o';
		if(isFinished(board,opTurn))
			return -1;
		
		if(cache[bijection(board)]!=-2)
			return cache[bijection(board)];
		
		int minValue = 2;
		for(int y=0;y<3;y++) {
			for(int x=0;x<3;x++){
				int idx = 3*y + x;
				char ch = board.charAt(idx);
				if(ch=='.') {
					builder = new StringBuilder(board);
					builder.replace(idx, idx+1,turn+"");
					board = builder.toString();
					minValue = Math.min(minValue, canWin(board, opTurn));
					builder.replace(idx, idx+1,".");
				}
			}
		}
		
		if(minValue == 2 || minValue == 0 ) return cache[bijection(board)]=0;
		
		return cache[bijection(board)] = -minValue;
	}
}
