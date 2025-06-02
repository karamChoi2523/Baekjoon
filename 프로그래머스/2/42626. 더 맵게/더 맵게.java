import java.util.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		for(int e : scoville) pq.add((long)e);
		
		Arrays.sort(scoville);
		
		while(pq.size()>=2 && pq.peek()<K) {
			long a = pq.poll();
			long b = pq.poll();
			
			long mix = a+b*2;
			pq.add(mix);
			answer++;
		}
		
        return answer = pq.peek()>=K? answer : -1;
    }
}