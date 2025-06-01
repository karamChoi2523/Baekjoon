import java.util.*;

class Solution {
	static ArrayList<Integer> ans;
	static int index;
    public int[] solution(String msg) {
        int[] answer = {};
        
		HashMap<String, Integer> dict = new HashMap<>();
		
		int idx = 1;
		for(char c='A';c<='Z';c++)
			dict.put(String.valueOf(c), idx++);
		
		ans = new ArrayList<>();
		for(int i=0;i<msg.length();i++) {
			String key = makeStr(i, msg, dict);
			if(index!=0) {
				i = index-1;
				index = 0;
			}
			dict.put(key, idx++);
		}
		
		answer = new int[ans.size()];
		for(int i=0;i<ans.size();i++)
			answer[i] = ans.get(i);
        
        return answer;
    }
    private static String makeStr(int start, String msg, HashMap<String, Integer> dict) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=start;i<msg.length();i++) {
			sb.append(msg.charAt(i));
			
			String temp = sb.toString();
			if(!dict.containsKey(temp)) {
				ans.add(dict.get(msg.substring(start, i)));
				//System.out.println(dict.get(msg.substring(start, i)));
				if(i>=start+2)
					index = i;
				return temp;
			}
		}
		ans.add(dict.get(sb.toString()));
		//System.out.println(dict.get(sb.toString()));
		index = msg.length();
		return sb.toString();
	}
}