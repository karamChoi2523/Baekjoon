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
			if(index>i) {
				i = index-1;
			}
			dict.put(key, idx++);
		}
		
		return answer = ans.stream().mapToInt(Integer::intValue).toArray();
    }
    private static String makeStr(int start, String msg, HashMap<String, Integer> dict) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=start;i<msg.length();i++) {
			sb.append(msg.charAt(i));
			
			String temp = sb.toString();
			if(!dict.containsKey(temp)) {
				ans.add(dict.get(msg.substring(start, i)));
				if(i>=start+2)
					index = i;
				return temp;
			}
		}
		ans.add(dict.get(sb.toString()));
		index = msg.length();
		return sb.toString();
	}
}