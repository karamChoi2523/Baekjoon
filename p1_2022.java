import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;
//hash 알고리즘으로 다시 풀어보기
public class p1_2022 {
	static class User{
		String name;
		TreeSet<String> slist = new TreeSet<>();	//내가 신고한 사람
		TreeSet<String> wlist = new TreeSet<>();	//나를 신고
		int cnt=0;	//받을 메일 수
		
		public User(String name) {
			this.name = name;
		}
	}
	static class Solution {
		
		public int[] solution(String[] id_list, String[] report, int k) {
	        int[] answer = {};
	        answer = new int[id_list.length];
	        
	        ArrayList<User> ulist = new ArrayList<>();
	        TreeSet<String> ans = new TreeSet<>();
	        
	        for(int i=0;i<id_list.length;i++)
	        	ulist.add(new User(id_list[i]));
	        	
	        for(int i=0;i<report.length;i++) {
	        	StringTokenizer st = new StringTokenizer(report[i]);
	        	String first = st.nextToken();
	        	String second = st.nextToken();
	        	
	        	for(int j=0;j<ulist.size();j++) {
	        		if(first.equals(ulist.get(j).name)) {
	        			ulist.get(j).slist.add(second);
	        		}
	        		if(second.equals(ulist.get(j).name)) {
	        			ulist.get(j).wlist.add(first);
	        			
	        			if(ulist.get(j).wlist.size() >= k)
	        				ans.add(second);
	        		}
	        	}
	        }
	        
	        for(int i=0;i<ulist.size();i++) {
	        	Iterator<String> it1 = ulist.get(i).slist.iterator();
	        	
	        	while(it1.hasNext()) {
	        		String target = it1.next();
	        		Iterator<String> it2 = ans.iterator();
	        		
	        		while(it2.hasNext()) {
	        			if(target.equals(it2.next()))
	        				ulist.get(i).cnt += 1;
	        		}
	        	}
	        }
	        
	        for(int i=0;i<ulist.size();i++)
	        	answer[i] = ulist.get(i).cnt;
	        
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k=2;
		
		Solution s = new Solution();
		int[] ans = s.solution(id_list, report, k);
		
		for(int i=0;i<ans.length;i++)
			System.out.println(ans[i]);
	}

}
