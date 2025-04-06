import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(stack.size()>0 && c==stack.peek())
                stack.pop();
            else
                stack.push(c);
        }
        
        if(!stack.isEmpty()) return 0;
        
        return answer;
    }
}