import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        PriorityQueue<Integer> pqA = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqB = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<A.length;i++){
            pqA.add(A[i]);
            pqB.add(B[i]);
        }
        
        for(int i=0;i<A.length;i++){            
            if(pqA.peek() < pqB.peek()){
                pqA.poll();
                pqB.poll();
                answer++;
            }else{
                pqA.poll();
            }
        }
        
        return answer;
    }
}