import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] A, cal;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.valueOf(br.readLine());
		
		A = new int[n];
		cal = new int[n];
		visited = new boolean[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			int temp = Integer.parseInt(st.nextToken());
			A[i] = temp;		
		}
		
		solution(0);
		
		System.out.println(max);
	}
	
	private static void solution(int depth) {
		if(depth==n) {
			int sum = 0;
			
			for(int i=0;i<n-1;i++)
				sum+=Math.abs(cal[i]-cal[i+1]);
			
			max = Math.max(max, sum);
			return;
		}
		
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i] = true;
				cal[depth] = A[i];
				solution(depth+1);
				visited[i] = false;
			}
		}
	}
}
