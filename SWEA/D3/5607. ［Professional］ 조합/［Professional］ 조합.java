import java.io.*;
import java.util.*;

public class Solution {
	static int mod = 1234567891;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		long[] fact = factorials(1000_000);
		
		for(int tc=1;tc<=T;tc++) {
			long res = comb(sc.nextInt(), sc.nextInt(), fact);
			System.out.printf("#%d %d\n",tc,res);
		}
	}
	public static long power(long x, int exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp % 2) == 1) {
                result = result * x % mod;
            }
            x = x * x % mod;
            exp /= 2;
        }
        return result;
    }
	private static long comb(int N, int R, long[] fact) {
		if (R > N) return 0;
        long numerator = fact[N];
        long denominator = fact[R] * fact[N - R] % mod;
        return numerator * power(denominator, mod-2) % mod;
	}
	private static long[] factorials(int N) {
		long[] fact = new long[N + 1];
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i - 1] * i % mod;
        }
        return fact;
	}
}
