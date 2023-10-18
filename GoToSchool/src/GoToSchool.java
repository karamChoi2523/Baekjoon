
public class GoToSchool {
	public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n][m];
        
        for(int i=0;i<puddles.length;i++) {
        	int x = puddles[i][1];
        	int y = puddles[i][0];
        	
        	dp[x-1][y-1] = -1;
        }
        
        dp[0][0]=1;
        
        for(int i=0;i<n;i++) {
        	for(int j=0;j<m;j++) {
        		if(dp[i][j]==-1) {
        			dp[i][j]=0;
        			continue;
        		}
        		if(i==0 && j==0)
        			continue;
        		int up=0;
        		int left=0;
        		
        		if(i-1>=0)
        			up = dp[i-1][j];
        		
        		if(j-1>=0)
        			left = dp[i][j-1];
        		
        		dp[i][j] = (up+left)%1000000007;
        	}
        }
        answer = dp[n-1][m-1];
        
        return answer;
    }
	
	public static void main(String[] args) {
		int m = 5;
		int n = 3;
		int[][] puddles = {{4,2}};
		
		System.out.println(solution(m,n,puddles));
	}
}
