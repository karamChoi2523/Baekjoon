import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        int total = Arrays.stream(works).sum();
        if(total <= n) return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int w : works){
            pq.add(w);
        }
        while(n>0){
            int w = pq.poll();
            
            if(w==0) break;
            
            w-=1;
            pq.offer(w);
            n-=1;
        }
        
        for(int w : pq){
            answer += w*w;
        }
        return answer;
    }
}