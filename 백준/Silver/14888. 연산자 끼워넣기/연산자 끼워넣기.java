import java.io.*;
import java.util.*;


public class Main {
	static int n;
	static int[] numbers;
	static int[] operators;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		numbers = new int[n];
		
		for(int i=0;i<n;i++)
			numbers[i] = Integer.valueOf(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		operators = new int[4];
		//+ - * /
		
		for(int i=0;i<4;i++)
			operators[i] = Integer.valueOf(st.nextToken());
		
		dfs(numbers[0],1);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	private static void dfs(int num, int idx) {
		if(idx==n) {
			max = Math.max(num, max);
			min = Math.min(num, min);
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(operators[i]>0) {
				operators[i]--;
				
				switch(i) {
				case 0:
					dfs(num+numbers[idx], idx+1);
					break;
				case 1:
					dfs(num-numbers[idx], idx+1);
					break;
				case 2:
					dfs(num*numbers[idx], idx+1);
					break;
				case 3:
					int t = 0;
					if(num<0 && numbers[idx]>0) {
						t = num*(-1)/numbers[idx];
						t*=(-1);
					}else
						t = num/numbers[idx];
					dfs(t, idx+1);
					break;
				}
				
				operators[i]++;
			}
		}

	}
}