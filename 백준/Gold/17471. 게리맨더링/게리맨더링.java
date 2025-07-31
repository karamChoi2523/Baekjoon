import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] person;
	static ArrayList<Integer>[] adj;
	static int min;
	static int total = 0;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		person = new int[N+1];
		adj = new ArrayList[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<N+1;i++) {
			adj[i] = new ArrayList<>();
			person[i] = Integer.parseInt(st.nextToken());
			total += person[i];
		}
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<cnt;j++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		visited = new boolean[N+1];
		min = total;
		pick(1);
		
		System.out.println(min==total?-1:min);
	}
	public static void pick(int idx) {
		if(idx==N+1) {
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
		boolean target = false;
		if(c=='A')
			target = true;
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1;i<N+1;i++)
			if(visited[i]==target)
				list.add(i);
        
        if(list.size()==0||list.size()==N)
            return false;
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] check = new boolean[N+1];
		q.add(list.get(0));
		check[list.get(0)] = true;
		
		int cnt=1;
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int next : adj[curr]) {
				if(!check[next] && list.contains(next)) {
					check[next] = true;
					q.add(next);
					cnt++;
				}
			}
		}
		
		return cnt==list.size();
	}
	static int calDiff() {
		int sum = 0;
		for(int i=1;i<N+1;i++)
			if(visited[i])
				sum+=person[i];
		
		return Math.abs(total-sum*2);
	}
}
