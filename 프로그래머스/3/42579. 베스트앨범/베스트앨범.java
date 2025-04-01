import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        Map<String, Integer> gMap = new HashMap<>();
        Map<Integer, Integer> musics = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0;i<genres.length;i++){
            if(!list.contains(genres[i]))
                list.add(genres[i]);
            
            musics.put(i, plays[i]);
            
            if(gMap.containsKey(genres[i]))
                gMap.replace(genres[i], gMap.get(genres[i])+plays[i]);
            else
                gMap.put(genres[i], plays[i]);
        }
        
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return gMap.get(o2) - gMap.get(o1);
            }
        });
            
        for(int i=0;i<list.size();i++){
            String key = list.get(i);
            ArrayList<Integer> musicList = new ArrayList<>();
            
            for(int j=0;j<genres.length;j++)
                if(genres[j].equals(key))
                    musicList.add(j);
            
            Collections.sort(musicList, new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2){
                    return musics.get(o2)-musics.get(o1);
                }
            });
            
            for(int j=0;j<musicList.size();j++){
                if(j>=2) break;
                ans.add(musicList.get(j));
            }
        }
        
        answer = new int[ans.size()];
        
        for(int i=0;i<ans.size();i++)
            answer[i] = ans.get(i);
        
        return answer;
    }
}