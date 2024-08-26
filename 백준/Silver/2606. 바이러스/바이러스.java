import java.util.*;

//그래프

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		
		int[][] arr = new int[n+1][n+1];
		for(int i=0;i<m;i++) {
			String[] s = sc.nextLine().split(" ");
			int a = Integer.valueOf(s[0]);
			int b = Integer.valueOf(s[1]);
			arr[a][b] = arr[b][a] = 1;
		}
		
		bfs(n, arr);
	}
	public static void bfs(int n, int[][] arr) {
		boolean[] visited = new boolean[n+1];
		visited[1] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		
		int cnt=0;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i=1;i<=n;i++) {
				if(arr[tmp][i]==1 && !visited[i]) {
					q.add(i);
					visited[i]=true;
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}
