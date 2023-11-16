import java.util.*;

public class GymSuit {
	
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        ArrayList<String> lostList = new ArrayList<>();
        ArrayList<String> reserveList = new ArrayList<>();
        for(int e : lost)
        	lostList.add(String.valueOf(e));
        for(int e : reserve)
        	reserveList.add(String.valueOf(e));
        
        //여유분은 없지만 잃어버리지 않은 학생들
        Set<Integer> list = new HashSet<>();
        
        for(int e : lost)
        	list.add(e);
        for(int e : reserve)
        	list.add(e);
        answer = n - list.size();
        
        //여유분이 있는 애들
        answer += reserve.length;
        
        //여유분이 있던 애가 도난당한 경우
        for(int i=0;i<lostList.size();i++)
        	if(reserveList.contains(lostList.get(i))) {
        		reserveList.remove(lostList.get(i));
        		lostList.set(i, "");
        		lost[i] = -3;
        	}
        
        //도난 당한 애들이 체육복 지급 받은 경우
        for(int i=0;i<lostList.size();i++) {
        	String pre = String.valueOf(lost[i]-1);
        	String next = String.valueOf(lost[i]+1);
        	if(reserveList.contains(pre)) {
        		reserveList.remove(String.valueOf(lost[i]-1));
        		answer++;
        	}else if(reserveList.contains(next)) {
        		reserveList.remove(String.valueOf(lost[i]+1));
        		answer++;
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		int n = 5;
		int[] lost = {1,2,3};
		int[] reserve = {2,3,4};
		
		System.out.println(solution(n, lost, reserve));
	
	}

}
