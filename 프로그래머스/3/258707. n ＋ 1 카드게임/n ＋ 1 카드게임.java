import java.util.*;

class Solution {
    static Set<Integer> original, additional;
	public int solution(int coin, int[] cards) {
        int answer = 0;
        
        int n = cards.length;
        
        original = new HashSet<>();
        additional = new HashSet<>();
        
        int index = 0;
        for(int i=0;i<n/3;i++) {
        	original.add(cards[i]);
        	index++;
        }
        while(true){
        	answer++;
        	
        	if(index>=n)
        		break;
        	
        	additional.add(cards[index++]);
        	additional.add(cards[index++]);
        	
        	boolean flag = false;
        	
        	//코인을 최대한 사용하지 않는다
        	for(int e : original) {
        		if(original.contains(n+1-e)) {
        			original.remove(e);
        			original.remove(n+1-e);
        			flag = true;
        			break;
        		}
        	}
        	
        	if(!flag) {
        		if(coin>0) {
        			for(int e : original) {
        				if(additional.contains(n+1-e)) {
        					original.remove(e);
        					additional.remove(n+1-e);
        					coin--;
        					flag = true;
        					break;
        				}
        			}
        		}
        	}
        	
        	if(!flag) {
        		if(coin>=2) {
        			for(int e : additional) {
        				if(additional.contains(n+1-e)) {
        					additional.remove(e);
        					additional.remove(n+1-e);
        					coin-=2;
        					flag = true;
        					break;
        				}
        			}
        		}
        	}
        	
        	if(!flag)
        		break;
        }
        
        return answer;
    }
}