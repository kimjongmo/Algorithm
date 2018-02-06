import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;
 
 
//최소값 , 시작-종료
public class Exam1931 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt(); //미팅 갯수
    Vector<Meet> meets = new Vector<Meet>(num);
    //Meet = (시작시간, 끝나는 시간)
     
    for(int i=0;i <num;i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      meets.add(new Meet(start,end));
    }
     
    Collections.sort(meets);//이용시간이 짧은 순간순으로 앞으로 소팅
     
     
    int count = 0;
    int end = 0;
    for(int i=0;i <num;i++) {
      Meet meet = meets.get(i);
      if(meet.getStart()>=end) {
        count++;
        end = meet.getEnd();
      }
    }
    System.out.println(count);
     
     
    sc.close();
  }
   
}
class Meet implements Comparable<Meet> {
  private int start;
  private int end;
  public Meet(int start,int end) {
    this.start = start;
    this.end = end;
  }
  public int getStart() {
    return start;
  }
  public int getEnd() {
    return end;
  }
  @Override
  public int compareTo(Meet meet) {//(a).compareTo(b)
    // TODO Auto-generated method stub
    if(this.end < meet.getEnd())
        return -1;//a<b 음수값 리턴
    else if(this.end == meet.getEnd()) {
      if(this.start<meet.getStart())
        return -1;
      else if(this.start==meet.getStart())
        return 0;
      else
        return 1;
    }
    else
      return 1;   //a>b 양수값 리턴
  }
}