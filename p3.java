import java.util.ArrayList;
import java.util.Collections;

public class p3 {
	
	static class Solution {
		static int[] discount = {10,20,30,40};
		ArrayList<int[]> list = new ArrayList<>();
	    public int[] solution(int[][] users, int[] emoticons) {
	        int[] answer = {};
	        
	        dfs(users, emoticons, new int[emoticons.length], 0);
	        
	        Collections.sort(list, (a,b)->{
	        	if(b[0] != a[0]) return b[0]-a[0];
	        	else return b[1]-a[1];
	        });
	        answer = list.get(0);
	        return answer;
	    }
	    
	    public void dfs(int[][] users, int[] emo, int[] discountR, int level) {
	    	if(emo.length == level) {
	    		int cnt=0;
	    		int total = 0;
	    		
	    		for(int i=0;i<users.length;i++) {
	    			int sum=0;
	    			for(int j=0;j<emo.length;j++) {
	    				if(discountR[j] >= users[i][0])
	    					sum+=emo[j]/100*(100-discountR[j]);
	    			}
	    			if(sum >= users[i][1])
	    				cnt++;
	    			else
	    				total += sum;
	    		}
	    		int[] res = {cnt, total};
	    		list.add(res);
	    		
	    		return;	    		
	    	}else {
	    		for(int i=0;i<4;i++) {
	    			discountR[level] = discount[i];
	    			dfs(users, emo, discountR, level+1);
	    		}
	    	}
	    }
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] users = {{40, 10000}, {25,10000}};
		int[] emo = {7000,9000};
		
		int[] answ = s.solution(users, emo);
		System.out.println(answ[0]+" "+answ[1]);
	}

}
