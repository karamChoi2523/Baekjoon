import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        int total = Arrays.stream(works).sum();
        
        if(total <= n) return 0;
        
        PriorityQueue<Integer> work = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int e : works){
            work.add(e);
        }
        
        while(n-->0){
            int w = work.poll();
            
            if(w-1>0)
                work.add(w-1);
        }
        
        for(int e : work){
            answer += e*e;
        }
        
        return answer;
    }
}