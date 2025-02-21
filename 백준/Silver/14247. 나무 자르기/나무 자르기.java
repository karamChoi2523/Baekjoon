import java.io.*;
import java.util.*;

public class Main {
	static class Tree implements Comparable<Tree>{
		int len;
		int grow;
		
		public Tree(int l, int g) {
			len = l;
			grow = g;
		}
		
		@Override
		public int compareTo(Tree t) {
			if(this.grow == t.grow)
				return this.len - t.len;
			return this.grow-t.grow;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		ArrayList<Tree> trees = new ArrayList<>();
		for(int i=0;i<n;i++) {
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			trees.add(new Tree(a,b));
		}
		
		Collections.sort(trees);
		
		long sum = 0;
		
		for(int i=0;i<n;i++)
			sum += trees.get(i).len+trees.get(i).grow*i;
		
		System.out.println(sum);
	}
}
