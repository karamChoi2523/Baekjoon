class Solution {
    public int solution(int n) {
        int answer = 0;
        
        answer++;
        for(int i=1;i<=n/2+1;i++){
            int sum = i;
            for(int j=i+1;j<n;j++){
                sum+=j;
                if(sum > n) break;
                
                if(sum==n){
                    answer++;
                    break;
                }
            }
        }       
        
        
        return answer;
    }
}