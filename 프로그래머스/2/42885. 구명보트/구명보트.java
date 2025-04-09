import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int i=0,j=people.length-1;
        int cnt=0;
        
        for(;i<j;j--){
            if(people[i]+people[j]<=limit){
                cnt++;
                i++;
            }
        }
        
        answer = people.length;
        return answer-cnt;
    }
}