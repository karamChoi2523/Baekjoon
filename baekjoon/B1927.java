import java.util.PriorityQueue;
import java.util.Scanner;

public class B1927 {
	//우선순위 큐 - 최소 힙
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		PriorityQueue<Integer> minQ = new PriorityQueue<>();
		//최대힙 : new PriorityQueue<>(Collections.reverseOrder());
		//new comparator
		/*
		PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
 
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(1) < o2.charAt(1)) {
                    return -1;
                }else if(o1.charAt(1) > o2.charAt(1)) {
                    return 1;
                }else {
                    return 0;
                }
                //return o1.compareTo(o2);            //전체 오름 차순
                //return o2.compareTo(o1);            //전체 내림차순
            }
        });
		*/
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			
			if(x==0) {
				if(minQ.isEmpty())
					System.out.println(0);
				else
					System.out.println(minQ.poll());	
				//비어있는 경우
				//반환+제거)poll-null, remove-예외
				//only 반환) peek-null, element-예외
			}else {
				minQ.add(x);
			}
		}
	}

}
