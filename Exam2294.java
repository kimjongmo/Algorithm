import java.util.Scanner;
 
public class Exam2294 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
     
    int n = sc.nextInt();
    int k= sc.nextInt();
    int[] coin = new int[n];//각 동전의 값
    int[] num = new int[k+1];//최소값
     
     
    for(int i=0;i<coin.length;i++) {
      coin[i]=sc.nextInt();
    }
    for(int i=1;i<=k;i++) {
      num[i]=10001; //동전의 최대 갯수는 10000개 10001은 무한대라는 의미..
    }
    num[0]=0;
     
    for(int i=0;i<n;i++) {
      for(int j=coin[i];j<=k;j++) {
          num[j] = Math.min(num[j], num[j-coin[i]]+1); 
          //책에 나오는 공식을 그냥 썻습니다..
      }
    }
     
    if(num[k]>10000)
      System.out.println("-1");
    else
      System.out.println(num[k]);
     
    sc.close();
  }
}