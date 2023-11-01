import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class B2644 {
	static int answer = -1;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		int m = sc.nextInt();
		
		ArrayList<LinkedList<Integer>> list = new ArrayList<>();
		
		for(int i=0;i<n+1;i++) {
			list.add(new LinkedList<>());
		}
		
		for(int i=0;i<m;i++) {
			int x = sc.nextInt();	//y의 부모(부모 한 명)
			int y = sc.nextInt();
			
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		boolean[] visited = new boolean[n+1];
		dfs(list, visited, start, end, 0);
		
		System.out.println(answer);
	}

	private static void dfs(ArrayList<LinkedList<Integer>> list, boolean[] visited, int start, int end, int cnt) {
		if(start == end) {
			answer = cnt;
			return;
		}
		
		visited[start] = true;
		
		for(int i=0;i<list.get(start).size();i++) {
			int next = list.get(start).get(i);
			
			if(!visited[next])
				dfs(list, visited, next, end, cnt+1);
		}
	}

}
