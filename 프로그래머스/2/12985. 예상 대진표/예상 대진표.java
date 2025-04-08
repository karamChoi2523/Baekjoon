class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(a!=b){
            answer++;
            
            a = getNextNum(a);
            b = getNextNum(b);
        }

        return answer;
    }
    
    static private int getNextNum(int n){
        return n/2+n%2;
    }
}