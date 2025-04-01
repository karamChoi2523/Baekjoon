class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    static void dfs(int index, int n, int[][] computers){        
        for(int i=0;i<n;i++){
            if(computers[index][i]==1 && !visited[i]){
                visited[i] = true;
                dfs(i, n, computers);
            }
        }
    }
}