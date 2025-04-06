class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int num = sol(n);
        
        while(true){
            if(sol(++n)==num) break;
        }
        answer = n;
        return answer;
    }
    
    static private int sol(int n){
        int ans = 0;
        
        while(n>0){
            if(n%2==1) ans++;
            n/=2;
        }
        
        return ans;
    }
}