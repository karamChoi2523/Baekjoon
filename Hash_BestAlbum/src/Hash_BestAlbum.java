import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Hash_BestAlbum {
	static class Solution {
	    public int[] solution(String[] genres, int[] plays) {
	        int[] answer = {};	//각 장르 두 개씩
	        
	        HashMap<String, Integer> hMap = new HashMap<>();	//장르, 횟수
	        HashMap<Integer, Integer> mMap = new HashMap<>();	//노래id, 횟수
	        ArrayList<String> list = new ArrayList<>();	//장르list
	        
	        for(int i=0;i<genres.length;i++) {
	        	if(!list.contains(genres[i]))
	        		list.add(genres[i]);
	        	
	        	mMap.put(i, plays[i]);
	        	
	        	if(hMap.containsKey(genres[i]))
	        		hMap.put(genres[i], hMap.get(genres[i])+plays[i]);
	        	else
	        		hMap.put(genres[i], plays[i]);
	        }	//장르별 총 재생 횟수
	        
	        Collections.sort(list, new Comparator<String>(){
				@Override
				public int compare(String o1, String o2) {
					System.out.println("o1 o2 "+o1+" "+o2+" "+hMap.get(o1)+" "+hMap.get(o2));
					return hMap.get(o2) - hMap.get(o1);
				}
	        });	//총 재생횟수가 많은 순으로 장르 정렬
	        
	        ArrayList<Integer> ansList = new ArrayList<>();
	        
	        for(int k=0;k<list.size();k++){
	        	String target = list.get(k);
	        	ArrayList<Integer> alist = new ArrayList<>();
	        	//장르별 각 곡 저장
	        	for(int i=0;i<genres.length;i++)
	        		if(target.equals(genres[i]))
	        			alist.add(i);
	        	
	        	Collections.sort(alist, new Comparator<Integer>() {
	        		@Override
	        		public int compare(Integer o1, Integer o2) {
	        			return mMap.get(o2)-mMap.get(o1);
	        		}
	        	});
	        	
	        	System.out.println(target);
	        	for(int i=0;i<alist.size();i++)
	        		System.out.println(alist.get(i));
	        	
	        	for(int i=0;i<alist.size();i++){
	        		if(i<2)
	        			ansList.add(alist.get(i));
	        		else
	        			break;
	        	}
	        }
	        answer = new int[ansList.size()];
	        int index=0;
	        for(Integer e : ansList)
	        	answer[index++]=e;
	        
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] genres = {"classic", "classic", "classic","pop"};
		int[] plays = {800,600,800,2200};
		
		int[] answer = new Solution().solution(genres, plays);
		
		System.out.println("answer");
		for(int i=0;i<answer.length;i++)
			System.out.println(answer[i]);
	}

}
