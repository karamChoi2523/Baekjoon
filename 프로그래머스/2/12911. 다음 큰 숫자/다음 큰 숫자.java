class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int num = Integer.bitCount(n);
        
        while(true){
            if(Integer.bitCount(++n)==num) break;
        }
        answer = n;
        return answer;
    }
}