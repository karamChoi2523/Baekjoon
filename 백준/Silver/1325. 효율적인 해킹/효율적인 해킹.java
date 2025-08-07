import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] adj;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		BitSet[] vis = new BitSet[N+1];
		for(int i=1;i<N+1;i++) {
			adj[i] = new ArrayList<>();
			vis[i] = new BitSet(N+1);
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[b].add(a);
		}
		
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		
		int max = -1;
		for(int i=1;i<N+1;i++) {
			dq.add(i);
			vis[i].set(i);
			
			while(!dq.isEmpty()) {
				int curr = dq.poll();
				for(int next : adj[curr]) {
					if(vis[i].get(next)) continue;
					
					if(next<i) {  //메모이제이션
						vis[i].or(vis[next]);
					}else {
						dq.add(next);
						vis[i].set(next);
					}
				}
			}
			max = Math.max(max, vis[i].cardinality());
		}
		
		for(int i=1;i<N+1;i++)
			if(vis[i].cardinality()==max)
				System.out.print(i+" ");
		
	}
}