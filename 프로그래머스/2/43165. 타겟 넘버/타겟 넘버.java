class Solution {
    static int ans=0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        dfs(numbers, target, 0, 0);
        return answer = ans;
    }
    
    static private void dfs(int[] numbers, int target, int step, int sum){
        if(step == numbers.length){
            if(target == sum) ans++;
            return;
        }
        
        dfs(numbers, target, step+1, sum+numbers[step]);
        dfs(numbers, target, step+1, sum-numbers[step]);
    }
}