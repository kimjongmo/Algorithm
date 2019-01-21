import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam7682 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> question = new ArrayList<>();
		while(true) {
			String q = sc.nextLine();
			
			if(!q.equals("end")) {
				question.add(q);
			}else {
				break;
			}
		}
		for(String s : question)
			System.out.println(check(s));
		sc.close();
	}
	
	static boolean isFinished(String board,char ox) {
		char[] arr = board.toCharArray();
		boolean result = false;
		if(arr[0]==ox && arr[0] == arr[3] && arr[3] == arr[6])
			result  = true;
		if(arr[1]==ox &&arr[1] == arr[4] && arr[4] == arr[7])
			result  = true;
		if(arr[2]==ox &&arr[2] == arr[5] && arr[5] == arr[8])
			result  = true;
		if(arr[0]==ox &&arr[0] == arr[1] && arr[1] == arr[2])
			result  = true;
		if(arr[3]==ox &&arr[3] == arr[4] && arr[4] == arr[5])
			result  = true;
		if(arr[6]==ox &&arr[6] == arr[7] && arr[7] == arr[8])
			result  = true;
		if(arr[2]==ox &&arr[2] == arr[4] && arr[4] == arr[6])
			result  = true;
		if(arr[0]==ox &&arr[0] == arr[4] && arr[4] == arr[8])
			result  = true;
		return result;
	}
	
	static String check(String board) {
		char[] arr = board.toCharArray();
		
		int count_o = 0;
		int count_x = 0;
		for(char ch : arr) {
			if(ch=='O')
				count_o++;
			else if(ch=='X')
				count_x++;
		}
		
		if(count_x-count_o!=1)
			return "invalid";
		else {
			if(count_x+count_o==9) {
				boolean result_x = isFinished(board, 'X');
				boolean result_o = isFinished(board, 'O');
				if(result_x==true && result_o==false 
						|| result_x==false && result_o==false) {
					return "valid";
				}else
					return "invalid";
				
			}else {
				boolean result_x = isFinished(board, 'X');
				boolean result_o = isFinished(board, 'O');
				if(result_x==true && result_o ==false)
					return "valid";
				else
					return "invalid";
			}
		}
		
	}
}
