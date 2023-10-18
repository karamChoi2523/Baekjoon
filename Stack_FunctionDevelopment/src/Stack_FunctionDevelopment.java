import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

public class Stack_FunctionDevelopment {
	
	public static class Solution {
	    public int[] solution(int[] progresses, int[] speeds) {
	        int[] answer = {};
	        ArrayList<Integer> list = new ArrayList<>();
	        
	        Stack<Integer> stack = new Stack<>();
	        
	        for(int i=0;i<progresses.length;i++) {
	        	stack.push(progresses[progresses.length-1-i]);
	        }
	        
	        int cnt=0;
	        while(!stack.empty()) {
	        	if(stack.empty())
	        		break;
	        	while(!stack.empty() && stack.peek()>=100) {
	        		cnt+=1;
	        		stack.pop();
	        	}
	        	if(cnt!=0) {
	        		list.add(cnt);
	        		cnt=0;
	        	}
	        	
	        	for(int i=0;i<stack.size();i++)
	        		stack.set(i, stack.get(i)+speeds[speeds.length-1-i]);
	        }
	        answer = new int[list.size()];
	        for(int i=0;i<list.size();i++)
	        	answer[i] = list.get(i);
	        
	        return answer;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		
		int[] ans = new Solution().solution(progresses, speeds);

	}

}
