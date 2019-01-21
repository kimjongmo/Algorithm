import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam1107 {
	static int N;
	static boolean[] pressEnable = new boolean[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < 10; i++)
			pressEnable[i] = true;
		int count = Integer.parseInt(br.readLine());
		if(count!=0) {
			String[] buttons = br.readLine().split(" ");
			for (int i = 0; i < buttons.length; i++) {
				int number = Integer.parseInt(buttons[i]);
				pressEnable[number] = false;
			}
		}
		
		int answer = Math.abs(100-N);
		
		for(int i=0;i<10000000;i++) {
			int len = isPossible(i);
			if(len>0) {
				int press = Math.abs(N-i)+len;
				answer = Math.min(answer, press);
			}
		}
		
		System.out.println(answer);
	}
	
	//해당 숫자가 눌러서 이동가능한지
	public static int isPossible(int channel) {
		int len = 0;
		
		if(channel==0) {
			if(pressEnable[0])
				return 1;
			else
				return -1;
		}
		while(channel!=0) {
			if(!pressEnable[channel%10]) {
				return -1;
			}
			len++;
			channel /= 10; 
		}
		return len;
	}
}

//0 1 2 3 4 5 6 7 8 9 + -