import java.util.*;

public class MakeBigNum {
	public static String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        sb.append(number);
         
        int i=0;
		while(i<sb.length()-1 && k>0) {
        	
        	if(sb.charAt(i)< sb.charAt(i+1)) {
        		sb = sb.deleteCharAt(i);
        		k--;
        		
        		if(i>0)
        			i-=2;
        		else i--;
        	}
        	i++;
        }
        
        if(k>0)
        	sb.setLength(sb.length()-k);
        
        answer = sb.toString();
        return answer;
    }
	public static void main(String[] args) {
		String number  = "4177252841";
		int k = 4;
		
		System.out.println(solution(number, k));
	}

}
