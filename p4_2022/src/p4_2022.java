import java.util.ArrayList;
import java.util.Collections;

public class p4_2022 {
	static int[] tc = new int[11];//라이언이 맞춘
	static int[] res = new int[11];//결과
	static Integer max = Integer.MIN_VALUE;
	
	static class Solution {		
		public void dfs(int[] info, int cnt, int n) {
			if(cnt == n) {
				int ta=0;	//라이언
				int tb=0;	//어피치
				
				for(int i=0;i<11;i++) {
					if(info[i]!=0 || tc[i]!=0) {
						if(tc[i]>info[i])
							ta+= (10-i);
						else
							tb+=(10-i);
					}
				}
				if(ta>tb && ta-tb >= max) {
					for(int j=0;j<11;j++)
						res[j] = tc[j];
					max = ta-tb;
				}
				return;
			}
			for(int i=0;i<11 && tc[i]<=info[i];i++) {
				tc[i]++;
				dfs(info, cnt+1, n);
				tc[i]--;
			}
		}
	    public int[] solution(int n, int[] info) {
	        int[] answer = {};
	        answer = new int[11];
	        for(int i=0;i<11;i++)
	        	res[i] = -1;
	        
	        dfs(info, 0, n);
	        
	        if(res[0]==-1) {
	        	answer = new int[1];
	        	answer[0]=-1;
	        	return answer;
	        }
	        
	        for(int i=0;i<11;i++)
	        	answer[i] = res[i];
	        
	        return answer;
	    }
	}

	public static void main(String[] args) {
		int n=9;
		int[] info= {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
		//10 9 8 7 6 5 4 3 2 1 0
		//점수 : 10-index
		int[] ans = new Solution().solution(n, info);
		
		for(int e : ans) {
			System.out.print(e);
		}
	}

}
