import java.io.*;
import java.util.*;

public class B2805 {
	static long[] trees;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long m = sc.nextLong();
		
		trees = new long[(int) n];
		for(int i=0;i<n;i++)
			trees[i] = sc.nextLong();
		
		Arrays.sort(trees);
		
		long res = binarySearch(m);
		
		System.out.println(res);
	}

	private static long binarySearch(long m) {
		long mid;
		long low = 0;
		long high = trees[trees.length-1];
		
		while(low<=high) {
			mid = (low+high)/2;
			
			if(calculate(mid)>=m)
				low = mid+1;
			else
				high = mid-1;
		}
		
		return high;
	}

	private static long calculate(long mid) {
		long sum=0;
		
		for(long e : trees) {
			if(e > mid)
				sum+= e-mid;
		}
		return sum;
	}
	
	
}
