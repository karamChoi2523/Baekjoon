import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        
        Stack<Integer> stack = new Stack<>();
        stack.push((int)s.charAt(0));

        for(int i=1;i<s.length();i++){
            if(stack.size()>0 && (int)s.charAt(i)==stack.peek())
                stack.pop();
            else
                stack.push((int)s.charAt(i));
        }
        
        if(!stack.isEmpty()) return 0;
        
        return answer;
    }
}