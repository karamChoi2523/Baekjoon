import java.io.*;
import java.util.*;


public class Main {
	static int n,m;
	static ArrayList<Integer>[] graph;
	static int[] indegree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		
		graph = new ArrayList[n+1];
		indegree = new int[n+1];
		
		for(int i=0;i<n+1;i++)
			graph[i] = new ArrayList<>();
	
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
		
			graph[a].add(b);	//a가 먼저
			indegree[b]++;
		}
		
		bfs();
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<n+1;i++) {
			if(indegree[i]==0)
				q.add(i);
		}
				
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			System.out.print(curr+" ");
			
			for(int i=0;i<graph[curr].size();i++) {
				int t = graph[curr].get(i);
				
				indegree[t]--;
				if(indegree[t]==0)
					q.add(t);
			}
		}
	}
}
