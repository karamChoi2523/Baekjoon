import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {};
        
        if(s<n) return new int[]{-1};
        
        answer = new int[n];
        
        for(int i=0;i<n;i++)
            answer[i] = s/n;
        
        int index = n-1;
        for(int i=0;i<s%n;i++)
            answer[index--]++;
        
        return answer;
    }
}