import java.util.*;

class Solution {
    static class Friend{
		int a;
		int b;
		int c;
		
		public Friend(int a,int b,int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
     
        int[][] board = new int[friends.length][friends.length];
        int[] ans = new int[friends.length];
        
        for(String record : gifts) {
        	String[] rr = record.split(" ");
        	
        	int a=-1, b=-1;
        	
        	for(int i=0;i<friends.length;i++) {
        		if(friends[i].equals(rr[0]))
        			a = i;
        		else if(friends[i].equals(rr[1]))
        			b = i;
        		
        		if(a!=-1 && b!=-1)
        			break;
        	}
        	
        	board[a][b]++;
        }
        
        ArrayList<Friend> list = new ArrayList<>();
        for(int i=0;i<friends.length;i++) {
        	int[] arr = findRecord(board, i);
        	list.add(new Friend(arr[0],arr[1],arr[2]));
        }
        
        for(int i=0;i<friends.length;i++) {
        	for(int j=0;j<friends.length;j++) {
        		if(i!=j) {
        			int a = board[i][j];
        			int b = board[j][i];
        			
        			
        			if(a>b)
        				ans[i]++;
        			else if(a<b)
        				ans[j]++;
        			else {
        				int ta = list.get(i).c;
        				int tb = list.get(j).c;
        				
        				if(ta>tb)
        					ans[i]++;
        				else if(ta<tb)
        					ans[j]++;
        			}
        		}
        	}
        }
        
        for(int i=0;i<ans.length;i++)
        	answer = Math.max(answer, ans[i]);
        
        
        return answer/2;
    }
    private static int[] findRecord(int[][] board, int f) {	//선물 지수 반환
		int a = 0;	//받은
		int b = 0;	//준
		for(int i=0;i<board[f].length;i++) {
			b+=board[f][i];
		}
		
		for(int i=0;i<board.length;i++)
			a+=board[i][f];

		return new int[] {b, a, b-a};
	}
	
}