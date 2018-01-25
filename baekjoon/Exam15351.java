import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Exam15351 {
  public static void main(String[] args) {
    BufferedReader br ;
    int count=0;
    String[] str=null;
    try {
      br = new BufferedReader(new InputStreamReader(System.in));
      count = Integer.parseInt(br.readLine());//횟수 입력
      str = new String[count];        //배열 생성
       
      for(int i=0;i<count;i++) {
        str[i] = br.readLine();       //문자 입력받기
      }
      br.close();
    }catch(IOException e) {
      e.printStackTrace();
    }
     
    for(int i=0;i<count;i++) {
      int sum =0;
      for(int j=0;j<str[i].length();j++) {
        if(str[i].charAt(j)!=' ')     //공백이 아닌 글자 일때
        sum+=(int)str[i].charAt(j)-64;    //대문자만 준다길레..
      }
      if(sum == 100)
        System.out.println("PERFECT LIFE");
      else
        System.out.println(sum);
    }
     
  }
}