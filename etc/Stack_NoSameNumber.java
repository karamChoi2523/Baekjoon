import java.util.*;

public class Stack_NoSameNumber {
	public static class Solution {
	    public int[] solution(int []arr) {
	        int[] answer = {};
	        ArrayList<Integer> ans = new ArrayList<>();
	        
	        Stack<Integer> stack = new Stack<>();
	        
	        for(int i=0;i<arr.length;i++)
	        	stack.push(arr[i]);
	        
	        int target = stack.pop();
	        ans.add(target);
	        for(int i=0;i<arr.length;i++) {
	        	if(!stack.empty() && stack.peek()==target)
	        		stack.pop();
	        	else if(!stack.empty()) {
	        		target = stack.pop();
	        		ans.add(target);
	        	}
	        }
	        
	        Collections.reverse(ans);
	        
	        answer = new int[ans.size()];
	        for(int i=0;i<ans.size();i++)
                answer[i] = ans.get(i);
	        
	        
	        
	        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
	        //System.out.println("Hello Java");

	        return answer;
	    }
	}

	public static void main(String[] args) {
		int[] arr = {1,1,3,3,0,1,1};
		int[] answer = new Solution().solution(arr);
	}

}
