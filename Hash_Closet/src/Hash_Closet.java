import java.util.ArrayList;
import java.util.HashMap;

public class Hash_Closet {
	static class Solution {
	    public int solution(String[][] clothes) {
	        int answer = 0;
	        
	        HashMap<String, Integer> hMap = new HashMap<>();//종류, 개수
	        ArrayList<String> list = new ArrayList<>();
	        
	        for(String e[]:clothes) {
	        	if(!list.contains(e[1]))
	        		list.add(e[1]);	//종류 저장
	        }
	        
	        for(String e[]: clothes) {
	        	//종류별 개수
	        	if(hMap.containsKey(e[1]))
	        		hMap.replace(e[1], hMap.get(e[1])+1);
	        	else
	        		hMap.put(e[1], 1);
	        }
	        
	        answer = 1;
	        for(int i=0;i<list.size();i++) {
	        	answer *= 1+hMap.get(list.get(i));
	        }
	        answer -=1;
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "headgear"}, {"green_turban", "headgear"}};
		
		int answer = new Solution().solution(clothes);
		System.out.println("main : "+answer);
	}

}
