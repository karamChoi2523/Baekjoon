import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697 {
	static int n, k;
	//static int min = Integer.MAX_VALUE;
	static boolean[] visited = new boolean[100001];
	static int countArr[] = new int[100001];
	
	//dfs가 아닌 bfs를 써야 함!!
	//이전에 있던 위치를 체크+count

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		//dfs(n, 0);
		bfs(n);

		//System.out.println(min);
		
		//0초일 때 1로 하므로 마지막에 1을 빼준다.
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
	/*
	public static void dfs(int n, int sec) {
		if(sec>min || n<0 || n>100000)
			return;
		if(n==k) {
			if(sec<min)
				min=sec;
			return;
		}

		if(n!= 0 && Math.abs(n*2 - k) < Math.abs(n-k))
			dfs(n*2, sec+1);
		if(n<k) dfs(n+1, sec+1);
		dfs(n-1, sec+1);
	}
	 */
}
