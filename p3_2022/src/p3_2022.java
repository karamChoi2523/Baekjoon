import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p3_2022 {
	static class Car implements Comparable {
		String num;
		String inTime = null;
		String outTime = null;
		int price=0;
		int total=0;
		
		@Override
		public int compareTo(Object o) {
			Car c = (Car)o;
			if(Integer.valueOf(c.num) < Integer.valueOf(this.num)) return 1;
			else return -1;
		}
		
		public void calculateT() {
			String[] start = this.inTime.split(":");
        	String[] end = this.outTime.split(":");
        	
        	int hs = Integer.valueOf(start[0]);
        	int ms = Integer.valueOf(start[1]);
        	int he = Integer.valueOf(end[0]);
        	int me = Integer.valueOf(end[1]);
        	
        	int time = 0;
        	if(hs <= he)
        		time = (60*he + me) - (60*hs+ms);
        	else
        		time = (60*he+me) + (60*(24-hs)-ms);
        	this.total += time;
		}
		public String print() {
			return num+" "+inTime+" "+outTime;
		}
		
	}
	static class Solution {
	    public int[] solution(int[] fees, String[] records) {
	        int[] answer = {};
	        ArrayList<Car> clist = new ArrayList<>();
	        
	        int lm = fees[0];
	        int lp = fees[1];
	        int mm = fees[2];
	        int mp = fees[3];
	        
	        for(int i=0;i<records.length;i++) {
	    		StringTokenizer st = new StringTokenizer(records[i]);
	    		
	    		String t = st.nextToken();
	    		String cNum = st.nextToken();
	    		String type = st.nextToken();
	    		
	    		int j=0;
	    		for(;j<clist.size();j++) 
	    			if(cNum.equals(clist.get(j).num)) {
	    				if(type.equals("IN"))
	    					clist.get(j).inTime = t;
	    				else {
	    					clist.get(j).outTime = t;
	    					clist.get(j).calculateT();
	    					clist.get(j).inTime = null;
	    					clist.get(j).outTime = null;
	    				}
	    				break;
	    			}
	    		if(j==clist.size()) {
	    			Car c = new Car();
	    			c.num = cNum;
	    			c.inTime = t;
	    			clist.add(c);
	    		}
	        }
	        
	        for(int i=0;i<clist.size();i++)
	        	if(clist.get(i).inTime!=null && clist.get(i).outTime==null) {
	        		clist.get(i).outTime = "23:59";
	        		clist.get(i).calculateT();
	        	}
	        
	        answer = new int[clist.size()];
	        
	        for(int i=0;i<clist.size();i++) {
	        	int t = clist.get(i).total;
	        	int plus=0;
	        	if(t>lm) {
	        		if(t%mm==0)
	        			plus = mp*((t-lm)/mm);
	        		else
	        			plus = mp*(((t-lm)/mm)+1);
	        	}
	        	clist.get(i).price = (plus+lp);
	        }
	        
	        Collections.sort(clist);
	        
	        for(int i=0;i<clist.size();i++)
	        	answer[i] = clist.get(i).price;
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[] fees= {120, 0, 60, 591};
		String[] records= {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
		int[] ans = new Solution().solution(fees, records);
		
		for(int e : ans)
			System.out.println(e);
		
	}

}
