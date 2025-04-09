import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(isTrue(s)) answer++;
            s = s.substring(1,s.length())+s.substring(0,1);
        }
        
        return answer;
    }
    static private boolean isTrue(String s){
        Stack<Character> stack = new Stack<>();
        
        for(Character c : s.toCharArray()){
            if(stack.isEmpty()) stack.push(c);
            
            else if((stack.peek()=='(' && c==')')
               ||(stack.peek()=='{' && c=='}')
               ||(stack.peek()=='[' && c==']'))
                stack.pop();
            else stack.push(c);
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}