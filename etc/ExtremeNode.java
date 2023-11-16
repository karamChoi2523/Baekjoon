import java.util.*;
//어렵다..
public class ExtremeNode {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
	public static int solution(int n, int[][] edge) {
        int answer = 0;
        
        //인접리스트 - 그래프 저장
        for(int i=0;i<=n;i++)
        	graph.add(new ArrayList<>());
        
        for(int[] e : edge) {
        	int v = e[0];
        	int w = e[1];
        	
        	graph.get(v).add(w);
        	graph.get(w).add(v);
        }
        
        answer = bfs(graph, n);       
        
        return answer;
    }
	
	private static int bfs(ArrayList<ArrayList<Integer>> graph, int n) {
		boolean[] visited = new boolean[n+1];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {1,0});	//{노드번호, 거리}
		visited[1] = true;
		
		int answer = 0;
		int maxDepth = 0;
		
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int v = arr[0];
			int depth = arr[1];
			
			if(maxDepth == depth)
				answer++;
			else if(maxDepth < depth) {
				maxDepth = depth;
				answer = 1;
			}
			
			for(int i=0;i<graph.get(v).size();i++) {
				int w = graph.get(v).get(i);	//인접한 정점
				
				if(!visited[w]) {
					q.add(new int[] {w, depth+1});
					visited[w] = true;
				}
			}
		}
        
		return answer;
	}

	public static void main(String[] args) {
		int n = 6;
		
		int[][]vertex = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		
		System.out.println(solution(n, vertex));
	}

}
