import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//int T = 10;
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			parents = new int[N+1];
			for(int i=1;i<N+1;i++)
				parents[i] = i;

			StringBuilder sb = new StringBuilder();
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int d = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				if(d==0) union(from, to);
				else {
					if(findParent(from)==findParent(to))
						sb.append(1);
					else 
						sb.append(0);
				}
			}

			System.out.printf("#%d %s\n",tc,sb.toString());
		}
	}
	static void union(int x, int y) {
		int px = findParent(x);
		int py = findParent(y);
		
		if(py<px) parents[px] = py;
		else parents[py] = px;
	}
	static int findParent(int x) {
		while(x!=parents[x]) {
			parents[x] = parents[parents[x]];
			x = parents[x];
		}
		return x;
	}
}
