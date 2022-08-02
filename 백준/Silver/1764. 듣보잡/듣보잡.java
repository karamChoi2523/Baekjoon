import java.util.*;

public class Main {

	public static void main(String[] args) {
		TreeSet<String> hSet = new TreeSet<>();
		TreeSet<String> wSet = new TreeSet<>();
		Scanner sc = new Scanner(System.in);
		int hNum = sc.nextInt();
		int wNum = sc.nextInt();
		
		int i;
		
		sc.nextLine();
		for(i=0;i<hNum;i++)
			hSet.add(sc.nextLine());
		
		for(i=0;i<wNum;i++)
			wSet.add(sc.nextLine());
		
		ArrayList<String> pick = new ArrayList<>();
		
		for(String key:hSet) {
			if(wSet.contains(key)) {
				pick.add(key);
			}
		}
		System.out.println(pick.size());
		for(String obj:pick)
			System.out.println(obj);
	}


}
