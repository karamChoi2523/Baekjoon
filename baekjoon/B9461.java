import java.util.Scanner;

public class B9461 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		long[] p = new long[100];
		
		p[0]=1;
		p[1]=1;
		p[2]=1;
		p[3]=2;
		p[4] =2;
		
		for(int idx=0;idx<t;idx++) {
			int n=sc.nextInt();
			
			for(int i=5;i<n;i++) {
				p[i] = p[i-1]+p[i-5];
			}
			System.out.println(p[n-1]);
		}
		
		
	}

}
