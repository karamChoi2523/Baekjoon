class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int total = brown+yellow;
        
        int x=0, y=0;
        
        for(x=3;x<=Math.sqrt(total);x++){
            if(total%x!=0) continue;
            
            y = total/x;
            
            if((x-2)*(y-2)==yellow){
                answer = new int[]{y,x};
                break;
            }
        }
        
        return answer;
    }
}