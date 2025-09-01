import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] person;
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		person = new int[N+1];
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<N+1;i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}
		
		
		adj = new ArrayList[N+1];
		for(int i=1;i<N+1;i++)
			adj[i] = new ArrayList<>();
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0;j<cnt;j++)
				adj[i].add(Integer.parseInt(st.nextToken()));
		}
		
		min = Integer.MAX_VALUE;
		visited = new boolean[N+1];
		subset(1);
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	static void subset(int idx) {
		if(idx==N+1) {
			if(checkConnection(true) && checkConnection(false)) {
				int sumA = 0;
				int sumB = 0;
				
				for(int i=1;i<N+1;i++)
					if(visited[i]) sumA+=person[i];
					else sumB+=person[i];
				
				min = Math.min(min, Math.abs(sumA-sumB));
			}
			return;
		}
		
		visited[idx] = true;
		subset(idx+1);
		visited[idx] = false;
		subset(idx+1);
		
	}
	static boolean checkConnection(boolean target) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] v = new boolean[N+1];
		
		int start = -1;
		for(int i=1;i<N+1;i++) {
			if(visited[i]==target) {
				start = i;
				break;
			}
		}
		
		if(start==-1) return false;
		
		q.add(start);
		v[start] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int e : adj[curr]) {
				if(visited[e]==target && !v[e]) {
					v[e] = true;
					q.add(e);
				}
			}
		}
		
		
		for(int i=1;i<N+1;i++) {
			if(visited[i]==target && !v[i])
				return false;
		}
		return true;
	}
}
