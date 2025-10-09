class Solution {
	static final int max = (int)1e6+1;
    public int[] solution(int[][] edges) {
        int[] answer = {};	//정점 번호, 도넛, 막대, 8자
        answer = new int[4];
        
        int size = edges.length;
        int[] ingoing = new int[max];
        int[] outgoing = new int[max];
        
        for(int[] edge : edges) {
        	outgoing[edge[0]]++;
        	ingoing[edge[1]]++;
        }
        
        for(int i=1;i<max;i++) {
        	if(outgoing[i]>=2) {
        		if(ingoing[i]==0) answer[0] = i;
        		else answer[3]++;
        	}else {
        		if(outgoing[i]==0 && ingoing[i]>=1)
        			answer[2]++;
        	}
        }
        
        answer[1] = outgoing[answer[0]]-(answer[2]+answer[3]);
        
        
        return answer;
    }
}