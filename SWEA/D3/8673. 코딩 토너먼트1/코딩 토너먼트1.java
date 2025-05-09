import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			int k = Integer.parseInt(br.readLine());
			String[] power = br.readLine().split(" ");
			
			int answer = 0;
			
			Queue<Integer> q = new LinkedList<>();
			for(String e : power) q.add(Integer.parseInt(e));
			
			while(!q.isEmpty()) {
				if(q.size()==1) break;
				int a = q.poll();
				int b = q.poll();
				
				answer += Math.abs(a-b);
				q.add(Math.max(a, b));
			}
			System.out.println("#"+i+" "+answer);
		}
		br.close();
	}
}
