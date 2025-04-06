import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] sArr = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(String e : sArr){
            int t = Integer.parseInt(e);
            
            min = Math.min(min, t);
            max = Math.max(max, t);
        }
        
        answer = min+" "+max;
        
        return answer;
    }
}