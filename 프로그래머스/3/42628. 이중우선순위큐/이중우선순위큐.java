import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        answer = new int[]{0,0};
        
        PriorityQueue<Integer> minq = new PriorityQueue<>();
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String s : operations){
            String[] str = s.split(" ");
            
            if(str[0].equals("I")){
                minq.add(Integer.parseInt(str[1]));
                maxq.add(Integer.parseInt(str[1]));
            }else{
                if(str[1].equals("1") && !maxq.isEmpty())
                    minq.remove(maxq.poll());
                else if(str[1].equals("-1") && !minq.isEmpty())
                    maxq.remove(minq.poll());
            }
        }
        
        if(minq.isEmpty() || maxq.isEmpty()) return answer;
        
        answer = new int[]{maxq.poll(), minq.poll()};
        
        return answer;
    }
}