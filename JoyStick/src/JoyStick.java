
public class JoyStick {
	public static  int solution(String name) {
        int answer = 0;
        
        //커서 이동 처리
        //answer += name.length()-1;
        int front = 0;
        int end=front;
        
        while(end < name.length() && name.charAt(end)=='A')
        	end++;
        
        int min=0;
        while(end<name.length()) {
        	int backward = name.length()-end;
        	int sum = front + backward;
        	
        	if(front < backward)
        		sum += front;
        	else
        		sum += backward;
        	
        	if(min==0)
        		min = sum;
        	else if(min > sum)
        		min = sum;
        	
        	front = end;
        	end++;
        	while(end<name.length() && name.charAt(end)=='A')
        		end++;
        }
        
        if(front < min)
        	min = front;
        
        answer += min;
        
        //알파벳 값 처리
        for(int i=0;i<name.length();i++) {
        	int diff = name.charAt(i)-'A';
        	
        	if(diff > 13)
        		diff = 26-diff;
        	answer += diff;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		String name = "JAN";
		
		System.out.println(solution(name));
	}

}
