import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B11279 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			
			if(x>0) {
				pq.add(x);
			}else if(x==0) {
				if(pq.size()!=0)
					System.out.println(pq.poll());
				else
					System.out.println(0);
			}
		}
	}

}
