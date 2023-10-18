//누적합
public class p6_2022 {
	static class Solution {
	    public int solution(int[][] board, int[][] skill) {
	        int answer = 0;
	        int n = board.length;
	        int m = board[0].length;
	        
    		int[][] sub = new int[n+1][m+1];
    			        
	        for(int i=0;i<skill.length;i++) {
	        	int type = skill[i][0];
	        	int r1 = skill[i][1];
	        	int c1 = skill[i][2];
	        	int r2 = skill[i][3];
	        	int c2 = skill[i][4];
	        	int degree = skill[i][5];
        		
        		if(type==1)
        			degree *= (-1);
        		
	        	sub[r1][c1] += degree;
	        	sub[r2+1][c1] += (-1)*degree;
	        	sub[r1][c2+1] += (-1)*degree;
	        	sub[r2+1][c2+1] += degree;
	        }
	        //누적합1
        	for(int j=1;j<n;j++)
        		for(int k=0;k<m;k++)
        			sub[j][k]+=sub[j-1][k];

        	//누적합2
			for(int k=1;k<m;k++)
				for(int j=0;j<n;j++)
        			sub[j][k]+=sub[j][k-1];
	        
	        for(int i=0;i<n;i++)
	        	for(int j=0;j<m;j++)
	        		if(board[i][j] + sub[i][j] > 0)
	        			answer += 1;
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[][] board = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] skill = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};

		int res = new Solution().solution(board, skill);
		System.out.println(res);
	}

}
