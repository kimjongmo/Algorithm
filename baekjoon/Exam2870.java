import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
public class Exam2870 {
  public static void main(String[] args) {
 
    BufferedReader br;
    String[] str = null;
    List<BigInteger> list = new ArrayList<BigInteger>();
 
    try {/*입력 부분*/
      br = new BufferedReader(new InputStreamReader(System.in));
 
      int n = Integer.parseInt(br.readLine());
      str = new String[n];
 
      for (int i = 0; i < str.length; i++) {
        str[i] = br.readLine();
      }
       
      br.close();
 
    } catch (IOException e) {
      e.printStackTrace();
    }
    for (int j = 0; j < str.length; j++) {
      for (int i = 0; i < str[j].length(); i++) {
        if (str[j].charAt(i) >= 48 && str[j].charAt(i) <= 57) {//숫자를 발견했을 때 시작
          int start = i;
          int end ;
          while(true) {
            if(i==str[j].length()-1) {//마지막 인덱스일 경우
              end = i+1;
              break;
            }else {//마지막 인덱스가 아닌경우
              i++;
              if(str[j].charAt(i) >= 48 && str[j].charAt(i) <= 57)//숫자
                continue;
              else {//문자
                end = i;
                break;
              }
            }
          }
          list.add(new BigInteger(str[j].substring(start,end)));
        }
      }
    }
     
    Collections.sort(list);//정렬
     
    for (BigInteger b : list) {
      System.out.println(b);
    }
 
  }
}