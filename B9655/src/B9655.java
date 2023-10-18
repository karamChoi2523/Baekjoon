import java.util.Scanner;

public class B9655 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//sk=0, cy=1
		int[] dp = new int[1000];
		
		dp[0] = 0;
		dp[1] = 0;	//1
		dp[2] = 1;	//2
		dp[3] = 0;	//1
		dp[4] = 1;	//2
		dp[5] = 0;	//3
		dp[6] = 1;	//2
		//È¦¼ö¹øÂ° ÅÏ¿¡ ³¡³ª¸é sk ½Â
		
		int cnt=0;
		while(n>0) {
			if(n>=3)
				n-=3;
			else
				n-=1;
			cnt++;
		}
		if(cnt%2!=0)
			System.out.println("SK");
		else
			System.out.println("CY");
			
	}

}
