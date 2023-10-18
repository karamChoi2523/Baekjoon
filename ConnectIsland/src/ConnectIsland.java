import java.util.Arrays;

public class ConnectIsland {
	public static int[] parent;
	
	public static int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        for(int i=0;i<n;i++)
        	parent[i]=i;
        
        Arrays.sort(costs, (o1, o2)->o1[2]-o2[2]);
        for(int i=0;i<costs.length;i++) {
        	int n1 = costs[i][0];
        	int n2 = costs[i][1];
        	int edge = costs[i][2];
        	
        	if(find(n1) != find(n2)) {
        		union(n1, n2);
        		answer += edge;
        	}
        }
        
       
        
        return answer;
    }
	//부모 찾기
	private static int find(int node) {
		if(parent[node] == node)
			return node;
		return parent[node] = find(parent[node]);
	}
	
	private static void union(int n1, int n2) {
		n1 = find(n1);
		n2 = find(n2);
		
		parent[n2] = n1;
	}

	public static void main(String[] args) {
		int n=4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		
		System.out.println(solution(4, costs));
	}
}
