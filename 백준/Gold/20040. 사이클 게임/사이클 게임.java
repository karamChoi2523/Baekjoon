import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] parents;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		initialize(br);
		
		System.out.println(answer);
	}
	static void union(int x, int y) {
		int px = findParent(x);
		int py = findParent(y);
		
		if(py>px)
			parents[py] = px;
		else parents[px] = py;
	}
	static int findParent(int x) {
		while(x!=parents[x]) {
			parents[x] = parents[parents[x]];
			x = parents[x];
		}
		return x;
	}

	private static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N];
		for(int i=0;i<N;i++)
			parents[i] = i;
		
		answer = 0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int pa = findParent(a);
			int pb = findParent(b);
			
			if(pa==pb) {
				answer = i+1;
				break;
			}
			union(pa,pb);
		}
	}
}
