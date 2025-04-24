import java.util.*;

class Solution {
    static int[][] board;
    static int min = Integer.MAX_VALUE;
    
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = 0;
        
        board = maps;
        //dfs(0,0, new boolean[board.length][board[0].length], 1);
        bfs();
        
        if(min==Integer.MAX_VALUE) return -1;
        
        answer = min;
        
        return answer;
    }
    
    static private void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            if(curr[0]==board.length-1 && curr[1]==board[0].length-1){
                min = Math.min(min, curr[2]);
                return;
            }
            
            for(int i=0;i<4;i++){
                int nx = curr[0]+dx[i];
                int ny = curr[1]+dy[i];

                if(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length){
                    if(board[nx][ny]==1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, curr[2]+1});
                    }
                }
            }
        }
    }
    
    static private void dfs(int x, int y, boolean[][] visited, int step){
        if(x==board.length-1 && y==board[0].length-1){
            min = Math.min(min, step);
            return;
        }
        
        visited[x][y] = true;
        
        
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            if(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length){
                if(board[nx][ny]==1 && !visited[nx][ny]){
                    dfs(nx, ny, visited, step+1);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}