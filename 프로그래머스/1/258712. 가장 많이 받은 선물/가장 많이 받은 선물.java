import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        	        int answer = 0;
	        
	        int size = friends.length;
	        int[][] graph = new int[size][size];
	        Map<String, Integer> map = new HashMap<>();
	        
	        for(int i=0;i<friends.length;i++)
	        	map.put(friends[i], i);
	        
	        for(String temp : gifts) {
	        	String[] t = temp.split(" ");
	        	
	        	int a = map.get(t[0]);
	        	int b = map.get(t[1]);
	        	
	        	graph[a][b]++;	//a가 b에게
	        }
	        
	        int[] nextMonth = new int[size];
        int[] score = new int[size];
        
        for(int i=0;i<size;i++)
        	score[i] = calScore(graph, i, size);
	        
	        for(int i=0;i<size;i++) {
	        	for(int j=i+1;j<size;j++) {
	        		if(graph[i][j]!=graph[j][i]) {
	        			if(graph[i][j]>graph[j][i]) nextMonth[i]++;
	        			else nextMonth[j]++;
	        		}else {
                        int a = score[i];
                        int b = score[j];
	        			
	        			if(a>b) nextMonth[i]++;
	        			else if(a<b) nextMonth[j]++;
	        		}
	        	}
	        }
	        
	        for(int i=0;i<size;i++)
	        	answer = Math.max(answer, nextMonth[i]);
	        
	        return answer;
    }

		static private int calScore(int[][] graph, int target, int size) {
			int give = 0, get = 0;
			
			for(int i=0;i<size;i++) {
				if(i==target) continue;
				
				give += graph[target][i];
				get += graph[i][target];
			}
			return give-get;
		}
}