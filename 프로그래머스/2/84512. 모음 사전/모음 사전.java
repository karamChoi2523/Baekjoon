import java.util.*;

class Solution {
    static String[] arr = new String[]{"A","E","I","O","U"};
    static ArrayList<String> total = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        
        for(int i=1;i<=5;i++){
            dfs(i, 0, "");
        }
        
        Collections.sort(total);
        
        return answer = total.indexOf(word)+1;
    }
    
    static private void dfs(int target, int step, String str){
        if(target==step){
            total.add(str);
            return;
        }
        
        for(int i=0;i<arr.length;i++){
            dfs(target, step+1, str+arr[i]);
        }
    }
}