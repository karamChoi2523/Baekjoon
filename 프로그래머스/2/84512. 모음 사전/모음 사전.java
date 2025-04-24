import java.util.*;

class Solution {
    static String[] arr = {"A", "E", "I", "O", "U"};
    static ArrayList<String> total = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        
        dfs("", 0);
        return answer = total.indexOf(word);
    }
    
    static private void dfs(String curr, int step){
        if(step>5) return;
        
        total.add(curr);
        
        for(int i=0;i<arr.length;i++){
            dfs(curr+arr[i], step+1);
        }
    }
}