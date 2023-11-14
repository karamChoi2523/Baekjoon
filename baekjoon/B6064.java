import java.util.Scanner;

public class B6064 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		//m n x y
		
		for(int i=0;i<t;i++) {
			boolean check = false;
			int m = sc.nextInt();
			int n = sc.nextInt();
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			
			int j;
			for(j=x;j<m*n;j+=m) {
				if(j%n==y) {
					System.out.println(j+1);
					check = true;
					break;
				}
			}
			
			if(!check)
				System.out.println(-1);
		}
		
		
	}

}
