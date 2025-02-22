import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] visited;
	static int max=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		solution(0);
		System.out.println(max);
	}

	private static void solution(int depth) {
		if(depth == 3) {
			int sum = 0;
			for(int i=0;i<N;i++)
				if(visited[i]) sum+=arr[i];
			
			if(sum>M) return;
			
			max = Math.max(sum, max);
			return;
		}
		
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				solution(depth+1);
				visited[i] = false;
			}
		}
	}

}
