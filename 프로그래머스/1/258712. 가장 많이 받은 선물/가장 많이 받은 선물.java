import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<friends.length;i++)
        	map.put(friends[i], i);
     
        int[][] board = new int[friends.length][friends.length];
        int[] index = new int[friends.length];	//선물지수
        
        for(String record : gifts) {
        	String[] rr = record.split(" ");
        	
        	index[map.get(rr[0])]++;
        	index[map.get(rr[1])]--;
        	board[map.get(rr[0])][map.get(rr[1])]++;
        }
        
        for(int i=0;i<friends.length;i++) {
        	int cnt = 0;
        	for(int j=0;j<friends.length;j++) {
        		if(i!=j) {
        			int a = board[i][j];
        			int b = board[j][i];
        			
        			
        			if(a>b)
        				cnt++;
        			else if(board[i][j]==board[j][i] && index[i]>index[j])
        				cnt++;
        		}
        		answer = Math.max(answer, cnt);
        	}
        }
        
        
        return answer;
    }
}