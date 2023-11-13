import java.util.Scanner;

public class Resignation {
	static class Counsel{
		int t;
		int p;
		
		public Counsel(int t, int p) {
			this.t = t;
			this.p = p;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Counsel[] list = new Counsel[n+1];
		
		for(int i=1;i<n+1;i++)
			list[i] = new Counsel(sc.nextInt(), sc.nextInt());
		
		int[] dp = new int[n+5];
		
		for(int i=n;i>0;i--) {
			int next = i+list[i].t;
			
			if(next > n+1)
				dp[i] = dp[i+1];
			else {
				dp[i] = Math.max(dp[i+1], list[i].p+dp[next]);
			}
		}
		System.out.println(dp[1]);
	}
//?????
}
