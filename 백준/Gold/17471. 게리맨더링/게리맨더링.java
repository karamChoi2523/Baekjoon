import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static int total;
	static int[] person;
	static ArrayList<Integer>[] adj;
	static boolean[] v;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		initialize(br);

		min = total;
		v = new boolean[N+1];
		subset(1);

		//pick을 하고 -> subset
		//a구역과 b구역이 각각 연결이 되어있는지 확인하고
		//연결되어있다면 그때 최솟값 체크

		System.out.println(min>=total?-1:min);
	}
	static boolean check(boolean vVal) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		
		int start = -1;
		for(int i=1;i<N+1;i++) {
			if(v[i]==vVal) {
				start = i;
				break;
			}
		}
		
		if(start==-1) return false;
		
		visited[start] = true;
		q.add(start);

		while(!q.isEmpty()) {
			int curr = q.poll();

			for(int e : adj[curr]) {
				if(v[e]==vVal && !visited[e]) {
					visited[e] = true;
					q.add(e);
				}
			}
		}

		for(int i=1;i<N+1;i++) {
			if(v[i] == vVal && !visited[i]) return false;
		}
		return true;
	}
	static void subset(int idx) {
		if(idx==N+1) {
			if(check(true) && check(false)) {
				int sumA = 0;
				for(int i=1;i<N+1;i++)
					if(v[i]) sumA+=person[i];
				min = Math.min(min, Math.abs(sumA-(total-sumA)));
			}
			return;
		}

		v[idx] = true;
		subset(idx+1);
		v[idx] = false;
		subset(idx+1);
	}
	private static void initialize(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		person = new int[N+1];

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		total = 0;
		for(int i=1;i<N+1;i++) {
			person[i] = Integer.parseInt(st.nextToken());
			total += person[i];
		}

		adj = new ArrayList[N+1];
		for(int i=1;i<N+1;i++)
			adj[i] = new ArrayList<>();
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());

			int cnt = Integer.parseInt(st.nextToken());

			for(int j=0;j<cnt;j++) {
				int node = Integer.parseInt(st.nextToken());
				adj[i].add(node);
			}
		}

	}
}
