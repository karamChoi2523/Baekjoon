import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static ArrayList<Integer> ktMembers;
	static int[] parent;
	static ArrayList<Integer>[] party;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		
		ktMembers = new ArrayList<>();
		party = new ArrayList[M];
		parent = new int[N+1];
		for(int i=0;i<N+1;i++)
			parent[i] = i;
		
		st = new StringTokenizer(br.readLine());
		int knowTruth = Integer.valueOf(st.nextToken());
		if(knowTruth==0) {
			System.out.println(M);
			return;
		}
		
		for(int i=0;i<knowTruth;i++)
			ktMembers.add(Integer.valueOf(st.nextToken()));
				
		for(int i=0;i<M;i++) {
			party[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int num = Integer.valueOf(st.nextToken());
			
			int t = Integer.parseInt(st.nextToken());
			party[i].add(t);
			for(int j=1;j<num;j++) {
				int t2 = Integer.valueOf(st.nextToken());
				party[i].add(t2);
				unionParent(t, t2);
			}
		}
		
		int answer=0;
		for(int i=0;i<M;i++) {
			boolean check = true;
			for(int j=0;j<party[i].size();j++) {
				if(ktMembers.contains(findParent(parent[party[i].get(j)]))) {
					check = false;
					break;
				}
			}
			if(check) answer++;
		}
		System.out.println(answer);
	}
	
	static private void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(ktMembers.contains(b)){
			int temp = a;
			a = b;
			b = temp;
		}
		parent[b] = a;
	}
	static private int findParent(int x) {
		if(parent[x] == x) return x;
		
		return findParent(parent[x]);
	}
}
