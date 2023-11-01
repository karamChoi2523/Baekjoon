import java.util.*;

public class LifeBoat {
	public static int solution(int[] people, int limit) {
        int answer = 0;
     
        Arrays.sort(people);
        
        int size = people.length;
        int first=0;
        
        while(size!=first) {	//남은 요소 없는 경우(50,50,70,80)
        	if(size-1==first) {	//남은 요소가 하나(30,40,70,70,80)
        		answer++;
        		break;
        	}
        	int a = people[first];
        	int b = people[size-1];
        	
        	if(a+b > limit) {
        		answer++;
        		size--;
        	}else {
        		answer++;
        		size--;
        		first++;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] people = {30, 40, 70, 70,80};
		int limit = 100;
		
		System.out.println(solution(people, limit));
	}

}
