import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B1535 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] L = new int[n];
		int[] J = new int[n];
		
		for(int i=0;i<n;i++)
			L[i] = sc.nextInt();
		
		for(int i=0;i<n;i++)
			J[i] = sc.nextInt();
		
		int[] dp = new int[100];
		
		for(int i=0;i<n;i++) {
			for(int j=99;j>=L[i];j--) {
				dp[j] = Math.max(dp[j-L[i]]+J[i],  dp[j]);
			}
		}
		System.out.println(dp[99]);
	}

}
