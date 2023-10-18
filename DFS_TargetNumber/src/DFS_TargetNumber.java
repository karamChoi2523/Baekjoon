import java.util.*;

public class DFS_TargetNumber {
	static int[] dp = {-1, 1};
	
	public static class Solution {
	    public int solution(int[] numbers, int target) {
	        int answer = 0;
	        
	        return answer = dfs(numbers, target, 0, 0);
	    }
	    
	    public int dfs(int[] numbers, int target, int sum, int step) {
	    	int total=0;
	    	
	    	if(step == numbers.length) {
	    		if(sum==target)
		    		return 1;
	    		return 0;
	    	}
	    	
	    	for(int i=0;i<2;i++) {
	    		int dx = dp[i]*numbers[step];
	    		
	    		total += dfs(numbers, target, sum+dx, step+1);
	    	}
	    	
	    	return total;
	    }
	}
	
	public static void main(String[] args) {
		int[] numbers = {4,1,2,1};
		int target = 4;
		
		int ans = new Solution().solution(numbers, target);
		System.out.println(ans);
	}

}
