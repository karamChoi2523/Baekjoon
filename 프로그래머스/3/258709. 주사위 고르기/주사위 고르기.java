import java.util.*;

class Solution {

    static int n;
	static int[] answer = {};
	static List<Integer> arrA, arrB, choice;
	static int[][] dices;
	static int max = Integer.MIN_VALUE;
    
    public int[] solution(int[][] dice) {
        n = dice.length;
        dices = dice;
        choice = new ArrayList<>();        
        answer = new int[n/2];
        
        choiceDice(0,0);
                
        return answer;
    }
    
    public static void choiceDice(int depth, int s) {
		if(depth == n/2) {
			int winning = calculateWinningPercent();
			if(max < winning) {
				max = winning;
				for(int i=0;i<choice.size();i++)
					answer[i] = choice.get(i)+1;
			}
			return;
		}
		
		for(int i=s;i<n;i++) {
			choice.add(i);
			choiceDice(depth+1, i+1);
			choice.remove(choice.size()-1);
		}
	}
    private static int calculateWinningPercent() {
		int count = 0;
		
		makeArrAB();
		
		Collections.sort(arrB);
		
		
		for(int i=0;i<arrA.size();i++) {	//number보다 작은 수의 개수ㅁ
			int number = arrA.get(i);
			
			int start = 0, end = arrB.size()-1;
			
			int index = Integer.MIN_VALUE;
			
			while(start<=end) {
				int mid = (start+end)/2;
				
				if(arrB.get(mid)<number) {
					start = mid+1;
					index = Math.max(index,  mid);
				}else
					end = mid-1;
			}
			
			if(index != Integer.MIN_VALUE)
				count += index+1;
		}
		
		return count;
	}

	private static void makeArrAB() {
		arrA = new ArrayList<>();
		arrB = new ArrayList<>();
		
		int[][] diceA = new int[n/2][6];
		int[][] diceB = new int[n/2][6];
		
		int a=0,b=0;
		
		for(int i=0;i<n;i++) {
			if(choice.contains(i)) {
				diceA[a++] = dices[i];
			}else {
				diceB[b++] = dices[i];
			}
		}
		
		makeArr(0, diceA, 0, arrA);
		makeArr(0, diceB, 0, arrB);
	}
	
	public static void makeArr(int depth, int[][] dice, int sum, List<Integer> arr) {
		if(depth == n/2) {
			arr.add(sum);
			return;
		}
		
		for(int i=0;i<6;i++) {
			int newSum = sum+dice[depth][i];
			makeArr(depth+1, dice, newSum, arr);
		}
	}
}