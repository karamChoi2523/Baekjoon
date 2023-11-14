import java.util.ArrayList;
import java.util.Scanner;

public class B12865 {
	static class Stuff{
		int w, v;
		
		public Stuff(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		ArrayList<Stuff> list = new ArrayList<>();
		list.add(new Stuff(0,0));
		
		for(int i=0;i<n;i++) {
			int w = sc.nextInt();
			int v = sc.nextInt();
			
			list.add(new Stuff(w,v));
		}
		
		int[][] dp = new int[n+1][k+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				dp[i][j] = dp[i-1][j];
				
				if(j-list.get(i).w>=0)
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-list.get(i).w]+list.get(i).v);
			}
		}
		System.out.println(dp[n][k]);
	}

}
