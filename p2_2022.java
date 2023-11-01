import java.util.ArrayList;

public class p2_2022 {
	static class Solution {
		public ArrayList<Long> changeK(long n, long k) {
			ArrayList<Long> res = new ArrayList<>();
			
			while(n!=0) {
				res.add(n%k);
				n/=k;
			}
			
			return res;
		}
		public boolean isPrime(long n) {
			if(n<2)
				return false;
			
			for(long i=2;i*i<=n;i++) {
				if(n%i==0) return false;
			}
			return true;
		}
	    public long solution(long n, long k) {
	        long answer = -1;
	        answer = 0;
	        ArrayList<Long> cn = changeK(n, k);	//변환결과
	        	        
	        long test=0;
	        long line=1;
	        for(int i=0;i<cn.size();i++) {
	        	if(cn.get(i)!=0) {
	        		test += line * cn.get(i);
	        		line *= 10;
	        	}else {
	        		if(isPrime(test))
	        			answer +=1;
	        		test=0;
	        		line=1;
	        	}
	        }
	        if(isPrime(test))
	        	answer += 1;
	        return answer;
	    }
	}
	public static void main(String[] args) {
		long n=437674;
		long k=3;
		
		long res = new Solution().solution(n, k);
		System.out.println(res);
	}

}
