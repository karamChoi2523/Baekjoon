import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        if(n==0) return 0;
        
        int curr = n;
        while(curr>0){
            if(curr%2==0)
                curr/=2;
            else{
                curr--;
                ans++;
            }
        }
        
        return ans;
    }
}