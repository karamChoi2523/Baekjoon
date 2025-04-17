import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        HashMap<String, Integer> hMap = new HashMap<>();
        for(String e[] : clothes){
            hMap.put(e[1], hMap.getOrDefault(e[1], 0)+1);
        }
        
        answer = 1;
        for(String key : hMap.keySet()){
            answer *= (hMap.get(key)+1);
        }
        
        return answer-1;
    }
}