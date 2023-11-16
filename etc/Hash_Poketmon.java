import java.util.TreeSet;
import java.util.HashMap;

public class Hash_Poketmon {
	static class Solution {
	    public int solution(int[] nums) {
	    	/*
	        int answer = 0;
	        TreeSet<Integer> ts = new TreeSet<>();
	        
	        int cnt = nums.length/2;	//고를 수 있는 포켓몬 수
	        //가장 많은 종류를 골라야 함
	        for(int i=0;i<nums.length;i++)
	        	ts.add(nums[i]);
	        
	        if(ts.size() > cnt)
	        	answer = cnt;
	        else
	        	answer = ts.size();
	        
	        return answer;
	        */
	    	
	    	HashMap<Integer, Integer> hMap = new HashMap<>();
	    	
	    	for(int i=0;i<nums.length;i++)
	    		hMap.put(nums[i], 1);
	    	
	    	return hMap.size()>nums.length/2? nums.length/2 : hMap.size();
	    }
	}
	public static void main(String[] args) {
		int[] nums = {3,1,2,3};
		int res = new Solution().solution(nums);
		
		System.out.println(res);
	}

}
