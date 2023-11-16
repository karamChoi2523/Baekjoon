
public class p2 {
	static class Solution {
		
	    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
	    	long answer = -1;
	    	int i;
	        int num1=0, num2=0;
	        int cnt=0;
	        for(i=n-1;i>=0;i--) {
		        if(deliveries[i]!=0 || pickups[i]!=0) {
		        	cnt=0;
		        	while(num1 < deliveries[i] || num2 < pickups[i]) {
		        		cnt+=1;
		        		num1 += cap;
		        		num2 += cap;
		        	}
		        	num1 -= deliveries[i];
		        	num2 -= pickups[i];
		        	answer += 2*cnt*(i+1);
		        }
	        }
	        answer += 1;
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		
		int n=5;	//Áý °³¼ö
		int cap = 4;
		int[] deliveries = {1, 0, 3, 1, 2};
		int[] pickups = {0, 3, 0, 4, 0};
		
		Solution s= new Solution();
		long ans = s.solution(cap, n, deliveries, pickups);
		
		System.out.println(ans);
	}

}
