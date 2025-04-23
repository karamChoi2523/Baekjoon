import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Queue<String> pq = new LinkedList<>();
        
        if(cacheSize==0){
            return cities.length*5;
        }
        
        for(String e : cities){
            e = e.toLowerCase();
            if(pq.contains(e)){
                pq.remove(e);
                answer+=1;
            }else{
                if(pq.size()>=cacheSize)
                    pq.poll();
                answer+=5;
            }
            pq.add(e);
        }
        
        return answer;
    }
}