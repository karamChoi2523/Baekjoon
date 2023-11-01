import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B9019 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int idx=0;idx<t;idx++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			bfs(a,b);
		}
	}

	private static void bfs(int a, int b) {
		String[] str = new String[10000];
		Arrays.fill(str, "");
		boolean[] visited = new boolean[10000];
		
		Queue<Integer> q = new LinkedList<>();
		visited[a] = true;
		q.add(a);
		
		while(!q.isEmpty()) {
			int pre = q.poll();
			
			int d = (pre*2)%10000;
			int s = pre==0?9999:pre-1;
			int l = (pre%1000)*10 + pre/1000;
			int r = (pre%10)*1000+pre/10;
			
			if(!visited[d]) {
				q.add(d);
				visited[d]=true;
				str[d] = str[pre]+"D";
			}
			if(!visited[s]) {
				q.add(s);
				visited[s]=true;
				str[s] = str[pre]+"S";
			}
			if(!visited[l]) {
				q.add(l);
				visited[l]=true;
				str[l] = str[pre]+"L";
			}
			if(!visited[r]) {
				q.add(r);
				visited[r]=true;
				str[r] = str[pre]+"R";
			}
			
		}
		System.out.println(str[b]);
	}

}
