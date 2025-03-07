import java.io.*;
import java.util.*;

public class Main {
	static class Meterial{
		int S;
		int B;
		
		public Meterial(int s, int b) {
			S = s;
			B = b;
		}
	}
	
	static int N;
	static Meterial[] list;
	static boolean[] visited;
	static long min = Long.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		list = new Meterial[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int S = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[i] = new Meterial(S,B);
		}
		
		for(int i=1;i<N+1;i++) {//개수
			visited = new boolean[N];
			solution(i, 0);
		}
		
		System.out.println(min);
	}
	
	static void solution(int target, int step) {
		if(target == step) {
			int s=1, b=0;
			for(int i=0;i<N;i++)
				if(visited[i]) {
					s*=list[i].S;
					b+=list[i].B;
				}
			
			min = Math.min(min, Math.abs(s-b));
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				solution(target, step+1);
				visited[i] = false;
			}
		}
		
	}
}
