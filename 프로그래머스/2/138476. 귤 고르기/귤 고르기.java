import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> hMap = new HashMap<>();
        
        for(int e : tangerine) hMap.put(e, hMap.getOrDefault(e, 0)+1);
        
        ArrayList<Integer> list = new ArrayList<>(hMap.keySet());
        
        Collections.sort(list, (o1, o2)->hMap.get(o2)-hMap.get(o1));
        
        int index=0;
        while(k>0){
            k-=hMap.get(list.get(index++));
            answer++;
        }
        
        return answer;
    }
}