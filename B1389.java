import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1389 {
	static ArrayList<Integer>[] list;
	static int[] visited;	//가중치 저장
	
	//각 유저를 모두 출발점으로 삼아 bfs로 탐색 후 가장 낮은 유저의 값 정답으로 선택
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		visited = new int[n+1];
		list = new ArrayList[n+1];
		
		for(int i=0;i<n+1;i++)
			list[i] = new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(bf.readLine());
			int a  = Integer.parseInt(st.nextToken());
			int b  = Integer.parseInt(st.nextToken());
		
			list[a].add(b);
			list[b].add(a);
		}
		
		int min=Integer.MAX_VALUE;
		int minIndex=0;
		
		for(int i=1;i<n+1;i++) {
			int cnt = bfs(i);
			
			if(min > cnt) {
				min = cnt;
				minIndex = i;
			}
		}
		
		System.out.println(minIndex);
	}
	
	public static int bfs(int start) {
		Arrays.fill(visited, -1);
		
		int cnt=0;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start]++;
		
		while(!q.isEmpty()) {
			int a = q.poll();
			
			for(int e : list[a]) {
				if(visited[e] != -1)
					continue;
				
				visited[e] = visited[a]+1;
				cnt += visited[e];
				q.add(e);
			}
		}
		
		return cnt;
	}
}
