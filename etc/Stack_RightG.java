import java.util.*;

public class Stack_RightG {
	public static class Solution {
	    boolean solution(String s) {
	    	boolean answer = true;
	        /*
	        Queue<String> queue = new LinkedList<>();
	        
	        for(int i=0;i<s.length();i++) {
	        	char c = s.charAt(i);
	        	queue.add(String.valueOf(c));
	        }
	        */
	        int cnt=0;
	        
	        for(int i=0;i<s.length();i++) {
	        	char c = s.charAt(i);
	        	
	        	if(c=='(') {
	        		cnt++;
	        	}
	        	else {
	        		cnt--;
	        	}
                
                if(cnt < 0)
                    return false;
	        }
	        if(cnt!=0)
	        	answer = false;
	        
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		String s = ")()()(";
		
		boolean ans = new Solution().solution(s);
		System.out.println(ans);
	}

}
