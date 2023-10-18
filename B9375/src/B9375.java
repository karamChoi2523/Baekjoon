import java.util.HashMap;
import java.util.Scanner;

public class B9375 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int idx=0;idx<t;idx++) {
			int n = sc.nextInt();
			sc.nextLine();
			
			HashMap<String, Integer> hMap = new HashMap<>();
			for(int i=0;i<n;i++) {
				sc.next();
				String type = sc.next();
				if(hMap.containsKey(type)!=true)
					hMap.put(type, 1);
				else
					hMap.put(type, hMap.get(type)+1);
			}
			
			int cnt=1;
			for(String key : hMap.keySet()) {
				cnt*=hMap.get(key)+1;
			}
			System.out.println(cnt-1);
			
		}
	}

}
