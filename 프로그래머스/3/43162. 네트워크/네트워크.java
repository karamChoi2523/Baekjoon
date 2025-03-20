import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0;i<n;i++)
            if(!visited[i]){
                dfs(n, visited, computers, i);
                answer++;
            }
        return answer;
    }
    
    static void dfs(int n, boolean[] visited, int[][] computers, int index){
        visited[index] = true;
        
        for(int i=0;i<n;i++)
            if(computers[index][i]==1 && !visited[i])
                dfs(n, visited, computers, i);
    }
}