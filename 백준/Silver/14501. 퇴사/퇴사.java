import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static class Counsel{
		int time;
		int pay;
		
		public Counsel(int time, int pay) {
			this.time = time;
			this.pay = pay;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		ArrayList<Counsel> list = new ArrayList<>();
		
		int[] dp = new int[n+1];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
		
			list.add(new Counsel(a, b));
		}
				
		for(int i=0;i<n;i++) {
			Counsel curr = list.get(i);
			
			if(i+curr.time<=n)
				dp[i+curr.time] = Math.max(dp[i+curr.time], dp[i]+curr.pay);
			
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		
		System.out.println(dp[n]);
	}

}
