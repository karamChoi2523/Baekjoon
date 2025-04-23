import java.util.*;

class Solution {
    private static int max = Integer.MIN_VALUE;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
                
        dfs(dungeons, k, new boolean[dungeons.length], 0, 0);
        
        answer = max;
        return answer;
    }
    private static void dfs(int[][] dungeons, int k, boolean[] visited, int index, int cnt){
        if(index == dungeons.length){
            max = Math.max(max, cnt);
            return;
        }
        
        for(int i=0;i<dungeons.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            
            if(dungeons[i][0]<=k){
                dfs(dungeons, k-dungeons[i][1], visited, index+1, cnt+1);
            }else
                dfs(dungeons, k, visited, index+1, cnt);
            
            visited[i] = false;
        }

        
        
    }
}