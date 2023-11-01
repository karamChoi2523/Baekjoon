import java.util.ArrayList;
import java.util.Scanner;

public class B4781{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int n = sc.nextInt();
			int m = (int) Math.round(100*sc.nextDouble());
			
			if(n==0 && m==0)
				break;
			
			int[] cal = new int[n];
			int[] price = new int[n];
			
			for(int i=0;i<n;i++) {
				cal[i]=sc.nextInt();
				price[i]=(int) Math.round(100*sc.nextDouble());
			}
			
			int[] dp = new int[m+1];	//남은 금액에 따른 최대 칼로리
			
			for(int i=0;i<m+1;i++) {
				for(int j=0;j<n;j++)
					if(i-price[j]>=0)
						dp[i]=Math.max(dp[i], dp[i-price[j]]+cal[j]);
			}
			
			sb.append(dp[m]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
