import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[] parents;
	static int n, x;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		
		parents = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> ans = new HashSet<>();
		for(int i=0;i<n;i++) {
			parents[i] = Integer.valueOf(st.nextToken());
			ans.add(i);
		}
		x = Integer.valueOf(br.readLine());
		
		parents[x] = -2;
		ans.remove(x);
		
		for(int i=0;i<n;i++)
			if(parents[i] == x) {
				parents[i] = -2;
				dfs(i);
			}
		
		for(int i=0;i<n;i++)
			if(ans.contains(parents[i]))
				ans.remove(parents[i]);
			else if(parents[i]==-2)
				ans.remove(i);
		
		
		System.out.println(ans.size());
	}

	private static void dfs(int x) {
		for(int i=0;i<n;i++)
			if(parents[i]==x) {
				parents[i] = -2;
				dfs(i);
			}
	}

}
