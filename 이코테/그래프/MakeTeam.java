import java.util.ArrayList;
import java.util.Scanner;

public class MakeTeam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] parent = new int[n+1];
		
		for(int i=0;i<n+1;i++)
			parent[i] = i;
		
		for(int i=0;i<m;i++) {
			int oper = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(oper==0) {
				unionParent(parent, a, b);
			}else {
				if(findParent(parent,a)==findParent(parent, b))
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}
		}
		System.out.println(sb.toString());		
	}
	
	public static int findParent(int[] parent, int x) {
		if(parent[x]!=x)
			parent[x] = findParent(parent, parent[x]);
		
		return parent[x];
	}
	
	public static void unionParent(int[] parent, int a, int b) {
		a = findParent(parent, a);
		b = findParent(parent, b);
		
		if(a<b)
			parent[b] = a;
		else
			parent[a] = b;
	}

}
