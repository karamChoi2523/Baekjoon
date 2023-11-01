import java.util.ArrayList;

public class p1 {
	static class Solution {
	    public int[] solution(String today, String[] terms, String[] privacies) {
	        int[] answer = {};
	        
	        //모든 달은 28일까지
	        //오늘날짜
	        //약관 기간
	        //가입일 약관
	        //answer : 파기되어야 할 개인정보 번호
	        
	        ArrayList<Integer> result = new ArrayList<>();
	        
	        String[] tDay = today.split("\\.");	//오늘 날짜
	        int tY = Integer.parseInt(tDay[0]);
	        int tM = Integer.parseInt(tDay[1]);
	        int tD = Integer.parseInt(tDay[2]);
	 
	        for(int i=0;i<privacies.length;i++) {	//각 개인정보
	        	String[] data = privacies[i].split(" ");	//개인정보별 정보 : 가입일, 약관
		        String[] date = data[0].split("\\.");	//가입일

		        int sY = Integer.parseInt(date[0]);
		        int sM = Integer.parseInt(date[1]);
		        int sD = Integer.parseInt(date[2]);
		        

		        //System.out.println("tY tM tD "+tY+" "+tM+" "+tD);
		        //System.out.println("sY sM sD "+sY+" "+sM+" "+sD);
		        
		        if(sD-1 > 0) sD-=1;
		        else {
		        	sM-=1;
		        	sD = 28;
		        }
		        
		        
		        String targetCase = data[1];	//가입 약관
		        int period=0;	//유효기간(m)
		        int j=0;
		        for(;j<terms.length;j++) {
		        	String[] fCase = terms[j].split(" ");
		        	
		        	if(targetCase.equals(fCase[0])){
		        		period = Integer.parseInt(fCase[1]);
		        		break;
		        	}
		        }
		        //if(j==terms.length) continue;
		        
		        sY+=period/12;
		        sM+=period%12;
		        
		        if(sM > 12) {
		        	sM-=12;
		        	sY+=1;
		        }
		        
		        //System.out.println("targetCase period "+targetCase+" "+period);
		        //System.out.println("sY sM sD "+sY+" "+sM+" "+sD+"\n");
	        	
		        if((sY<tY)||(sY==tY && sM<tM)||(sY==tY && sM==tM && sD < tD)) {
		        	result.add(i+1);
		        }
		        else continue;
	        }

        	
	        answer = new int[result.size()];

	        int index=0;
	        for(int i : result)
	        	answer[index++] = i;
	        
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		
		String today = "2020.01.01";
		String[] terms = {"Z 3", "D 5"};
		String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
		
		Solution s = new Solution();
		int[] ans = s.solution(today, terms, privacies);
		
		for(int i=0;i<ans.length;i++)
			System.out.println(ans[i]);
	}
	
}
