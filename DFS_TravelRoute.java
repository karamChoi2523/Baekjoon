import java.util.*;

public class DFS_TravelRoute {
	static boolean[] visited;
	static String[] answer;
	
	static class Solution {
	    public String[] solution(String[][] tickets) {
	        answer = new String[0];
	        visited = new boolean[tickets.length];
	        
	        ArrayList<String> curr = new ArrayList<>();
	        curr.add("ICN");
	        
	        dfs(tickets,curr, 0);
	        
	        
	        return answer;
	    }
	    
	    void dfs(String[][] tickets,ArrayList<String> curr, int step) {
	    	if(step == tickets.length) {
	    		answer = new String[curr.size()];
	    		for(int i=0;i<curr.size();i++)
	    			answer[i] = curr.get(i);
	    		return;
	    	}
	    	//¾ËÆÄºª ¼ø
	    	int target=-1;
	    	for(int i=0;i<tickets.length;i++) {
	    		if(tickets[i][0].equals(curr.get(curr.size()-1)) && !visited[i]) {
	    			if(target==-1) target = i;
	    			else {
	    				if(tickets[i][1].compareTo(tickets[target][1])<0)
	    					target = i;
	    			}
	    		}
	    	}
	    	if(target!=-1) {
	    		visited[target] = true;
				curr.add(tickets[target][1]);
				dfs(tickets, curr, step+1);
				visited[target] = false;
	    	}
	    	
	    }
	}
	
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"},{"ATL","SFO"}};
		String[] ans = new Solution().solution(tickets);
		
		for(String e : ans)
			System.out.println(e);
	}

}
