import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        
        for(int i=0;i<citations.length;i++){
            int h = citations[i];
            int cnt = citations.length-i;
            
            if(h>=cnt) return cnt;
            
        }
        
        return answer;
    }
}