import java.util.*;

public class Ranking {
	public static int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] graph = new int[n+1][n+1];
        //이기거나 진 경우가 총 n-1개이면 순위 결정
        for(int[] e : results) {
        	int win = e[0];
        	int lose = e[1];
        	
        	graph[win][lose] = 1;
        }
        
        for(int i=1;i<=n;i++) {
        	for(int j=1;j<=n;j++) {
        		for(int k=1;k<=n;k++) {
        			if(graph[i][k]==1 && graph[j][i]==1)
        				graph[j][k]=1;
        		}
        	}
        }
        
        for(int i=1;i<=n;i++) {
            int sum=0;
            for(int j=1;j<=n;j++)
            	if(graph[i][j]==1 || graph[j][i]==1)
            		sum += 1;
            if(sum == n-1)
            	answer++;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int n=5;
		int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};
		
		System.out.println(solution(n, results));
	}

}
