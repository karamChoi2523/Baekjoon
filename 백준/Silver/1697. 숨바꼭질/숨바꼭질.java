import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static boolean[] visited = new boolean[100001];
	static int countArr[] = new int[100001];
    
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		bfs(n);

		System.out.println(countArr[k]-1);
	}
	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited[n] = true;
		countArr[n]=1;

		while(!q.isEmpty()) {
			int x = q.poll();	//현 위치

			if(x==k) {
				return;
			}
			
			if(x-1>=0 && !visited[x-1]) {
				visited[x-1]=true;
				countArr[x-1] = countArr[x]+1;
				q.add(x-1);
			}
			if(x+1<=100000 && !visited[x+1]) {
				visited[x+1]=true;
				countArr[x+1] = countArr[x]+1;
				q.add(x+1);
			}
			if(x*2<=100000 && !visited[x*2]) {
				visited[x*2]=true;
				countArr[x*2] = countArr[x]+1;
				q.add(x*2);
			}
		}
	}
}