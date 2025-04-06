import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
        int a = 0;
        for(int i=0;i<A.length;i++){
            a += A[i]*B[A.length-1-i];
        }
        
        answer = a;

        return answer;
    }
}