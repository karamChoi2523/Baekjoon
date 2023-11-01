import java.util.Scanner;

public class B9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int[] memo = new int[11];
		memo[0]=0;
		memo[1]=1;
		memo[2]=2;
		memo[3]=4;
		
		for(int idx=0;idx<t;idx++) {
			int n = sc.nextInt();
			
			for(int i=4;i<=n;i++)
				memo[i] = memo[i-1]+memo[i-2]+memo[i-3];
			System.out.println(memo[n]);
		}
	}
	
}
