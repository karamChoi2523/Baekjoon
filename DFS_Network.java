import java.util.*;

public class DFS_Network {
	public static class Solution {
		static boolean[] check;

		public int solution(int n, int[][] computers) {
			int answer = 0;
			check = new boolean[n];
			for(int i=0; i<n; i++) {
				if(check[i] == false) {
					DFS(i, check, computers);
					answer++;
				}
			}
			return answer;
		}
		private static void DFS(int i, boolean[] check, int[][] computers) {
			check[i] = true;
			for(int j=0; j<computers.length; j++) {
				if(i !=j && computers[i][j] == 1 && check[j] == false){
					DFS(j, check, computers);
				}
			}
		}

	}
	public static void main(String[] args) {
		int n=3;
		int[][] computers = {{1,1,0},{1,1,1},{0,1,1}};
		int ans = new Solution().solution(n, computers);
		System.out.println(ans);
	}

}
