import java.util.*;

class Solution {
    static String[] userIds;
    static String[] bannedIds;
    static boolean[] visited;
    static Set<HashSet<String>> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        userIds = user_id;
        bannedIds = banned_id;
        visited = new boolean[userIds.length];
        
        dfs(new HashSet<>(), 0);
        answer = result.size();
        return answer;
    }
    
    static private void dfs(HashSet<String> set, int depth){
        if(depth==bannedIds.length){
            result.add(set);
            return;
        }
        
        for(int i=0;i<userIds.length;i++){
            if(set.contains(userIds[i])) continue;
            
            if(check(userIds[i], bannedIds[depth])){
                set.add(userIds[i]);
                dfs(new HashSet<>(set), depth+1);
                set.remove(userIds[i]);
            }
        }
    }
    static private boolean check(String userId, String bannedId){
        if(userId.length()!=bannedId.length())
            return false;
        
        for(int i=0;i<userId.length();i++){
            if(bannedId.charAt(i)!='*' && bannedId.charAt(i)!=userId.charAt(i)) return false;
        }
        
        return true;
    }
}