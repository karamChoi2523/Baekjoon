import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<numbers.length;i++){
            while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]){
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty())
            answer[stack.pop()] = -1;
        
        return answer;
    }
}