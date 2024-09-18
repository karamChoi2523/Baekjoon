import java.util.Scanner;

//피보나치
public class Main {
	static int memo[][] = new int[41][2];	//실제 값
	
	static int[] fibonacci(int n) {
	    if(memo[n][0] == -1 || memo[n][1] == -1) {
	        memo[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
	        memo[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
	    }
	    return memo[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=0;i<41;i++)
			for(int j=0;j<2;j++)
				memo[i][j] = -1;
		
		memo[0][0] = 1;
		memo[0][1] = 0;
		memo[1][0]=0;
		memo[1][1]=1;
		
		for(int i=0;i<t;i++) {
			int res[] = fibonacci(sc.nextInt());
			System.out.println(res[0]+" "+res[1]);
		}
	}

}