import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static boolean[] visited;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
	
		arr = new int[100001];
		visited = new boolean[100001];
		
		Arrays.fill(arr, 100001);
		
		bfs(n);	//count를 세야 하므로 bfs
		
		System.out.println(arr[k]);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.offer(start);
		arr[start] = 0;
				
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			if(curr-1 >=0 && !visited[curr-1]) {
				q.offer(curr-1);
				visited[curr-1] = true;
				arr[curr-1] = Math.min(arr[curr-1], arr[curr]+1);
			}
			if(curr+1 <= 100000 && !visited[curr+1]) {
				q.offer(curr+1);
				visited[curr+1] = true;
				arr[curr+1] = Math.min(arr[curr+1], arr[curr]+1);
			}
			if(curr*2 <= 100000 && !visited[curr*2]) {
				q.offer(curr*2);
				visited[curr*2] = true;
				arr[curr*2] = Math.min(arr[curr*2], arr[curr]+1);
			}
		}
	}

}
