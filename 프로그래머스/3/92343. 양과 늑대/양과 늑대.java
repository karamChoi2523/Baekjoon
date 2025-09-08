class Solution {
    static int answer = 0;
    
	public int solution(int[] info, int[][] edges) {
        dfs(0, new boolean[info.length], 0,0, info, edges);
        
        return answer;
    }

    static void dfs(int idx, boolean[] visited, int sheep, int wolf, int[] info, int[][] edges) {
    	visited[idx] = true;

        if(info[idx]==0) {
        	sheep += 1;
        	answer = Math.max(sheep, answer);
        }else
        	wolf+=1;
        
        if(sheep<=wolf) return;
        
        for(int[] edge : edges) {
        	if(visited[edge[0]] && !visited[edge[1]]) {
        		boolean[] visit = visited.clone();
        		dfs(edge[1], visit, sheep, wolf, info, edges);
        	}
        }
    }
}