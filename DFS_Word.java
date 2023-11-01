import java.util.*;

public class DFS_Word {
	static boolean[] visited;
	static int answer;
	
	static class Solution {
	    public int solution(String begin, String target, String[] words) {
	        
	        visited = new boolean[words.length];
	        answer = Integer.MAX_VALUE;
	        
	        dfs(begin, target, words, 0);
	        if(answer == Integer.MAX_VALUE)
	        	return 0;
	        return answer;
	    }
	    
		void dfs(String begin, String target, String[] words, int step) {
			if(begin.equals(target)) {
				if(answer > step)
					answer = step;
				return;
			}
			
			for(int i=0;i<words.length;i++) {
				if(visited[i])
					continue;
			
				int same = 0;
				int j=0;
				for(;j<begin.length();j++)
					if(begin.charAt(j) == words[i].charAt(j))
						same++;
				
				if(same == begin.length()-1) {
					visited[i] = true;
					dfs(words[i], target, words, step+1);
					visited[i] = false;
				}
			}
		}
	}
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		int ans = new Solution().solution(begin, target, words);
		System.out.println(ans);
	}

}
