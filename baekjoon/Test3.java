

public class Test3 {
	public static boolean solution(int[] arr) {
        boolean answer = true;
        boolean[] check = new boolean[100001];
        
        for(int i=0;i<arr.length;i++){
            if(check[arr[i]]==true)
                return false;
            check[arr[i]]=true;
        }
        for(int i=1;i<arr.length+1;i++){
            if(check[i]==false)
                return false;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(Test3.solution(new int[] {4,1,3}));
	}
}
