import java.io.*;
import java.util.*;

public class Main {
	static String min = String.valueOf(Long.MAX_VALUE);
	static String max = String.valueOf(Long.MIN_VALUE);
	static int k;
	static boolean[] visited;
	static String[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.valueOf(br.readLine());

		list = br.readLine().split(" ");
		visited = new boolean[10];
		
		for(int i=0;i<10;i++) {
			visited[i] = true;
			solution(0, i, String.valueOf(i));
			visited[i] = false;
		}
		

		System.out.println(max);
		System.out.println(min);
	}
	private static void solution(int depth, int pre, String result) {
		if(depth==list.length) {
			long res = Long.valueOf(result);
			long minTL = Long.parseLong(min);
			long maxTL = Long.parseLong(max);
			
			
			min = minTL>res? result : min;
			max = maxTL<res? result : max;
			return;
		}
		
		for(int i=0;i<10;i++) {
			if(!visited[i]) {
				visited[i] = true;
				if(list[depth].equals("<") && pre<i)
					solution(depth+1, i, result+String.valueOf(i));
				else if(list[depth].equals(">") && pre>i)
					solution(depth+1, i, result+String.valueOf(i));
				visited[i] = false;
				
			}
		}
	}
}
