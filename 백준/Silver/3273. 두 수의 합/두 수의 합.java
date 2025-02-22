import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(br.readLine());
		
		
		int[] list = new int[n];
		
		for(int i=0;i<n;i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list);
		
		int ans = 0;
		int sum = 0;
		int lt = 0;
		int rt = n-1;
		
		while(lt<rt) {
			sum = list[lt]+list[rt];
			
			if(sum==x) ans++;
			
			if(sum<x) lt++;
			else
				rt--;
		}	
		
		
		System.out.println(ans);
	}
}
