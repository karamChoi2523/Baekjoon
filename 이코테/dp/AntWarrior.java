import java.util.Scanner;

public class AntWarrior {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] list = new int[n];
		int[] dp = new int[n];
		//n��° �ķ�â���� ��������
		//n-1��° �и� x
		//n-2��° �и� O
		
		for(int i=0;i<n;i++)
			list[i] = sc.nextInt();
		
		dp[0] = list[0];
		dp[1] = Math.max(list[0], list[1]);
		
		for(int i=2;i<n;i++) {
			dp[i] = Math.max(list[i]+dp[i-2], dp[i-1]);
		}
		
		System.out.println(dp[n-1]);
	}

}
