import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<String> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(c=='('){
                stack.push(String.valueOf(c));
            }else{
                boolean check = false;
                while(true){
                    if(stack.isEmpty()) break;
                    String pre = stack.pop();
                    
                    if(pre.equals("(")){
                        check = true;
                        break;
                    }
                }
                if(!check) return false;
            }
        }
        
        if(!stack.isEmpty()) return false;

        return answer;
    }
}