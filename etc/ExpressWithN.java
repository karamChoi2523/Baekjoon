import java.util.*;

public class ExpressWithN {
	public static int solution(int N, int number) {
        
        ArrayList<Set<Integer>> list = new ArrayList<>();
		//8개보다 많이 쓰면 return-1
		for(int i=1;i<=9;i++)
			list.add(new HashSet<>());
		list.get(1).add(N);
		
		if(number==N)
			return 1;
		
		for(int i=2;i<9;i++) {
			for(int j=1;j<=i/2;j++) {
				unionSet(list.get(i), list.get(j), list.get(i-j));
				unionSet(list.get(i), list.get(i-j), list.get(j));
			}
			//string.repeat(i) -> i번 연속
			
			String n = String.valueOf(N);
			list.get(i).add(Integer.valueOf(n.repeat(i)));
			
			for(int e : list.get(i))
				if(e == number)
					return i;
		}

        return -1;
    }
	private static void unionSet(Set<Integer> res, Set<Integer> a, Set<Integer> b) {
		for(int e1: a) {
			for(int e2: b) {
				res.add(e1+e2);
				res.add(e1-e2);
				res.add(e1*e2);
				
				try {
					res.add(e1/e2);
				}catch(ArithmeticException e) {
					continue;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int number = sc.nextInt();
		
		System.out.println(solution(n, number));
		
	}

}
