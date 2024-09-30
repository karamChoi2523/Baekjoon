import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = {};
		
		int[] ingoing = new int[(int)1e6+1];
        int[] outgoing = new int[(int)1e6+1];
        
        for(int[] edge : edges) {
            outgoing[edge[0]]++;
            ingoing[edge[1]]++;
        }
        
        answer = new int[4];
        
        for(int i=1; i<(int)1e6; i++) {
            if(outgoing[i] >= 2) {
                if(ingoing[i] == 0)
                    answer[0] = i;
                else
                    answer[3]++;
                
            }else if(outgoing[i]==0 && ingoing[i]>=1){
                answer[2]++;
            }
        }
        
        answer[1] = outgoing[answer[0]]-(answer[2]+answer[3]);
        return answer;
    }
}