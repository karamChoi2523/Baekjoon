import java.util.ArrayList;
import java.util.Scanner;

public class B10431 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//같은 키x, 20명
		int p = sc.nextInt();
		
		for(int idx=0;idx<p;idx++) {
			int t = sc.nextInt();
			int[] list = new int[20];
			
			for(int i=0;i<20;i++)
				list[i]=sc.nextInt();
			
			System.out.println(t+" "+solution(list));
		}
	}

	private static int solution(int[] list) {
		int cnt=0;
		
		for(int i=1;i<20;i++) {
			for(int j=i-1;j>=0;j--) {
				if(list[j]>list[i])
					cnt++;
			}
		}
		return cnt;
	}

}
