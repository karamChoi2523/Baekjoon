import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        String[] str = s.split(" ");
        
        for(String t : str) {
            int temp = Integer.parseInt(t);
            max = Math.max(max, temp);
            min = Math.min(min, temp);
        }
        
        answer = min+" "+max;
        return answer;
    }
}