import java.util.*;

public class DFS_GameMap {
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	static int x;
	static int y;
	static boolean[][] visited;
	static int[][] memo;
	
	public static class Solution {
	    public int solution(int[][] maps) {
	        int answer = 0;
	        
	        x = maps.length;
	        y = maps[0].length;
	        
	        visited = new boolean[x][y];
	        memo = new int[x][y];
	        //dfs(0,0,maps);
	    	bfs(maps);
            if(!visited[x-1][y-1])
	            return -1;
            answer = memo[x-1][y-1];
	        return answer;
	    }

	    private void bfs(int[][] maps) {
	    	Queue<int[]> q = new LinkedList<>();
	    	q.add(new int[] {0,0,1});
	    	visited[0][0] = true;
	    	
	    	while(!q.isEmpty()) {
	    		int[] pos = q.poll();
	    		int r = pos[0];
	    		int c = pos[1];
	    		int step = pos[2];
	    		
	    		memo[r][c] = step;
	    		
	    		for(int i=0;i<4;i++) {
	    			int dx = r+dr[i];
	    			int dy = c+dc[i];
	    			
	    			if(dx>=0 && dy>=0 && dx<x && dy<y) {
						if(visited[dx][dy]==false && maps[dx][dy]==1) {
							visited[dx][dy]= true;
							q.add(new int[] {dx, dy, step+1});
						}
					}
	    		}
	    	}
	    }
	    /*
		private void dfs(int r, int c, int[][] maps) {	//(r,c) : Çö À§Ä¡
			visited[r][c] = true;
			
			
			if(r==x-1 && c==y-1)
				return;
			
			for(int i=0;i<4;i++) {
				if(visited[x-1][y-1])
					return;
				
				int dx = r+dr[i];
				int dy = c+dc[i];
				
				if(dx>=0 && dy>=0 && dx<x && dy<y) {
					if(visited[dx][dy]==false && maps[dx][dy]==1) {
						//step++;
						dfs(dx,dy,maps);
					}
				}
				
			}
		}
		*/
	}
	
	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		
		int ans = new Solution().solution(maps);
		System.out.println(ans);
	}

}
