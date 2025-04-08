class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(true){
            answer++;
            
            a = getNextNum(a);
            b = getNextNum(b);
            
            if(a==b) break;
        }

        return answer;
    }
    
    static private int getNextNum(int n){
        int ans = n/2;
        
        if(n%2!=0) ans++;
        
        return ans;
    }
}