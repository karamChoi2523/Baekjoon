import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Integer>[] adj;
	static int[] person;
	static int total;
	static boolean[] visited;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];
		for(int i=1;i<N+1;i++)
			adj[i] = new ArrayList<>();
		person = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<N+1;i++) {
			person[i] = Integer.parseInt(st.nextToken());
			total += person[i];
		}
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());

			while(st.hasMoreTokens()) {
				int node = Integer.parseInt(st.nextToken());
				adj[i].add(node);
			}
		}

		visited = new boolean[N+1];
		min = total;
		pick(1);

		System.out.println(min==total?-1:min);
	}	
	static void pick(int idx) {
		if(idx==N+1) {
			int cnt = 0;
			for(int i=1;i<N+1;i++)
				if(visited[i])
					cnt++;
			
			if(cnt>0 && cnt<N)
				if(checkGroup('A') && checkGroup('B'))
					min = Math.min(min, calDiff());
			return;
		}
		
		visited[idx] = true;
		pick(idx+1);
		
		visited[idx] = false;
		pick(idx+1);
	}
	
	static boolean checkGroup(char c) {
		ArrayList<Integer> list = new ArrayList<>();
		
		boolean target = false;
		if(c=='A')
			target = true;
		
		for(int i=1;i<N+1;i++)
			if(visited[i]==target)
				list.add(i);
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[N+1];
		q.add(list.get(0));
		visit[list.get(0)] = true;
		
		int idx = 0;
		int cnt = 1;
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int e : adj[curr]) {
				if(!visit[e] && list.contains(e)) {
					visit[e] = true;
					q.add(e);
					cnt++;
				}
			}
		}
		return cnt==list.size();
	}
	static int calDiff() {
		int areaA = 0;

		for(int i=1;i<N+1;i++)
			if(visited[i])
				areaA+=person[i];
		return Math.abs(total-areaA*2);
	}
}