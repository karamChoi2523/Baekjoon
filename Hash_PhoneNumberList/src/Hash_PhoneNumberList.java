import java.util.Arrays;
import java.util.Comparator;

public class Hash_PhoneNumberList {
	static class Solution {
	    public boolean solution(String[] phone_book) {
	    	boolean answer = true;
	        
	        Arrays.sort(phone_book);
	        
	        for(String s : phone_book)
	        	System.out.println(s);
	        
		    for(int i=0;i<phone_book.length-1;i++) {
		        if(phone_book[i+1].indexOf(phone_book[i])==0)
		        	return false;
		    }
		        
		    return answer;
	    }
	}
	public static void main(String[] args) {
		String[] phone_book = {"119", "219", "97674223", "1195524421"};
		boolean res = new Solution().solution(phone_book);
		System.out.println(res);
	}

}
