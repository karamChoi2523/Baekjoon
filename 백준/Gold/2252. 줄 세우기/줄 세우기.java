import java.io.*;
import java.util.*;

import com.sun.corba.se.impl.orbutil.graph.Graph;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] graph;
	static int[] indegree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		indegree = new int[N+1];
		graph = new ArrayList[N+1];
		
		for(int i=1;i<N+1;i++)
			graph[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph[A].add(B);
			indegree[B]++;
		}
		
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<N+1;i++)
			if(indegree[i]==0)
				q.add(i);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			sb.append(curr+" ");
			
			for(int next : graph[curr]) {
				indegree[next]--;
				if(indegree[next]==0)
					q.add(next);
			}
		}
		System.out.println(sb);
	}
}
