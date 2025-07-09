import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<String, Integer> hMap = new HashMap<>();
        
        int num = 1;
        char c = 'A';
        for(;num<=26;num++)
        	hMap.put(String.valueOf(c++), num);
        
        ans.add(hMap.get(msg.substring(0,1)));
        if(msg.length()>1)
            hMap.put(msg.substring(0,2), num++);
        

        int pre = 1;
        int end = msg.length();
        while(pre<msg.length()) {
        	String curr = msg.substring(pre, end);
        	if(hMap.containsKey(curr)) {
        		ans.add(hMap.get(curr));
                if(end<msg.length())
            		hMap.put(msg.substring(pre,end+1), num++);
        		pre = end;
        		end = msg.length();
        	}else end--;
        }
        
        answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++)
        	answer[i] = ans.get(i);
        
        return answer;
    }
}