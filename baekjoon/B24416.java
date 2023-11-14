import java.util.Scanner;

public class B24416 {
	static int cnt=0;
	static int cnt2=0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] dp = new int[41];
		int[] dp2 = new int[41];
		fib(n);
		fibonacci(n);
		System.out.println(cnt+" "+cnt2);
	}
	
	static int fib(int n) {
	    if (n == 1 || n == 2) {
	    	cnt++;
	        return 1;
	    }
	    else return (fib(n - 1) + fib(n - 2));
	 }
	static int fibonacci(int n) {
		int[] f = new int[n+1];
	    f[1] = f[2] = 1;
	    cnt2=1;
	    for( int i=3;i<n;i++) {
	    	cnt2++;
	        f[i] = f[i - 1] + f[i - 2];
	    }
	    return f[n];
	}
}
