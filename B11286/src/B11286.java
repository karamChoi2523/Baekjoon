import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B11286 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1)==Math.abs(o2))
					return o1-o2;
				return Math.abs(o1)-Math.abs(o2);
			}
			
		});
		
		for(int i=0;i<n;i++) {
			int x=sc.nextInt();
			
			if(x!=0)
				pq.add(x);
			else
				if(pq.size()!=0)
					System.out.println(pq.poll());
				else
					System.out.println(0);
		}
	}

}
