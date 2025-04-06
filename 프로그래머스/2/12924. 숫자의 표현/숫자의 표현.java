class Solution {
    public int solution(int n) {
        int answer = 0;
        
        //주어진 수의 홀수 약수의 개수와 같음
        for(int i=1;i<=n;i+=2){
            if(n%i==0) answer++;
        }
        
        return answer;
    }
}