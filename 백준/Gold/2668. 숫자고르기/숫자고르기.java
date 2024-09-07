import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int[] num;
	static boolean[] visited;
	static int n;
	static ArrayList<Integer> ans = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		
		num = new int[n+1];
		visited = new boolean[n+1];
		
		for(int i=1;i<n+1;i++)
			num[i] = Integer.valueOf(br.readLine());
		
		for(int i=1;i<n+1;i++) {
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}
		
		Collections.sort(ans);
		
		System.out.println(ans.size());
		for(int e : ans)
			System.out.println(e);
	}
	private static void dfs(int start, int target) {
		if(!visited[num[start]]) {
			visited[num[start]] = true;
			dfs(num[start], target);
			visited[num[start]] = false;
		}
		
		if(num[start]==target)
			ans.add(target);
	}
	
}
