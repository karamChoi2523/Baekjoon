import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2)->o1[1]-o2[1]);
        
        int preEnd = -30001;
        
        for(int i=0;i<routes.length;i++)
            if(preEnd < routes[i][0]){
                preEnd = routes[i][1];
                answer++;
            }
        
        return answer;
    }
}