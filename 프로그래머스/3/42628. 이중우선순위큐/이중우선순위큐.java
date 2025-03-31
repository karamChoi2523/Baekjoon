import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        answer = new int[]{0,0};
        
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        
        for(int i=0;i<operations.length;i++){
            String[] str = operations[i].split(" ");
            
            if(str[0].equals("I")){
                maxQ.add(Integer.parseInt(str[1]));
                minQ.add(Integer.parseInt(str[1]));
            }
            
            else{
                if(str[1].equals("1") && !maxQ.isEmpty())
                    minQ.remove(maxQ.poll());
                else if(str[1].equals("-1") && !minQ.isEmpty())
                    maxQ.remove(minQ.poll());
            }
        }
        
        if(minQ.isEmpty() || maxQ.isEmpty()) return answer;
        
        else answer = new int[]{maxQ.poll(), minQ.poll()};
        
        return answer;
    }
}