import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
		answer = new int[prices.length];
		
        for(int i=0;i<prices.length;i++){
            int j=i+1;
            for(;j<prices.length;j++){
                if(prices[j]<prices[i]){
                    answer[i] = j-i;
                    break;
                }
            }
            if(j==prices.length)
                answer[i] = j-i-1;
        }
        return answer;
    }
}