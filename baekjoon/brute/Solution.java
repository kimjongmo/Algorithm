package brute;

public class Solution {

    int n;
    int[] times;
    int timesLength;
    long answer = Long.MAX_VALUE;

    public long solution(int n, int[] times) {
        this.n = n;
        this.times = times;
        timesLength = times.length;
        binarySearch(0,Long.MAX_VALUE);
        return answer;
    }

    public void binarySearch(long start, long end) {
        if (end <= start) {
            return;
        }
        long mid = (start + end) / 2;

        long pass = 0;

        for (int i = 0; i < timesLength; i++) {
            if(pass < this.n)
                pass += (mid / times[i]);
        }
        // 정해진 시간에 n의 승객을 처리했으나 더 빠른 방법이 있는지 찾는다.
        if (pass >= this.n) {
            answer = Math.min(mid, answer);
            binarySearch(start, mid);
        }
        //정해진 시간에 n의 승객을 모두 처리 못함.
        else {
            binarySearch(mid + 1, end);
        }
    }
}
