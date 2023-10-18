import java.util.ArrayList;

public class p7_2022 {
	static int INF = Integer.MAX_VALUE;
	static int[][] map;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	static int n;
	static int m;
	
	static class Solution {
	    public int solution(int[][] board, int[] aloc, int[] bloc) {
	        int answer = -1;
	        n = board.length;
	        m = board[0].length;
	        map = board;
	        int res = dfs(aloc, bloc, true);
	        
	        answer = Math.abs(res);
	        return answer;
	    }
	    
	    public int dfs(int[] aloc, int[] bloc, boolean turn) {
	    	int x, y;
	    	if(turn) {
	    		x = aloc[0];
	    		y = aloc[1];
	    	}else {
	    		x = bloc[0];
	    		y = bloc[1];
	    	}
	    	
	    	ArrayList<Integer> list = new ArrayList<>();
	    	int dx;
	    	int dy;
	    	
	    	for(int i=0;i<4;i++) {
	    		dx = x + dr[i];
		    	dy = y + dc[i];
	    		
	    		if(dx<0 || dx>=n || dy<0 || dy>=m || map[dx][dy]==0)
	    			continue;
	    		
	    		if(aloc[0]==bloc[0] && aloc[1]==bloc[1]) {
	    			list.add(1);
	    			continue;
	    		}
	    		map[x][y]=0;
		    	
	    		int res;
	    		int[] move = {dx, dy};
	    		//턴이 바뀔 땐 다음 결과값 부호 반대로
	    		if(turn)
	    			res = -dfs(move, bloc, !turn);
	    		else
	    			res = -dfs(aloc, move, !turn);
	    		
	    		if(res>=0) res++;
	    		else res--;
	    		list.add(res);
	    		map[x][y]=1;
	    	}
			//승리한 경우가 있으면 그중 가장 짧은 걸 return(양수)
	    	//승리한 경우 없으면 패배 중 가장 긴 걸 return(음수)
	    	//이동 불가능 -> 0 return
	        int pMax = -INF, pMin = INF;	//양의 최대, 양의 최소
	        int mMax = -INF, mMin = INF;	//음의 최대, 음의 최소
	        for (int i = 0; i < list.size(); i++) {
	            int num = list.get(i);
	            if (num > 0) {
	                pMax = Math.max(pMax, num);
	                pMin = Math.min(pMin, num);
	            } else {
	                mMax = Math.max(mMax, num);
	                mMin = Math.min(mMin, num);
	            }
	        }

	        if (pMax == -INF && mMax == -INF) return 0;
	        else if (pMax == -INF) return mMin;
	        else if (pMax != -INF) return pMin;
	        else return 0;	    	
	    	
	    }
	}
	public static void main(String[] args) {
		int[][] board= {{1,1,1},{1,1,1},{1,1,1}};
		int[] aloc= {1,0};
		int[] bloc= {1,2};
		
		int res = new Solution().solution(board, aloc, bloc);
		System.out.println(res);
	}

}
