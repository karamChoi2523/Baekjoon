import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Nation implements Comparable<Nation>{
	int num;
	int gold;
	int silver;
	int bronze;
	
	public Nation(int n, int g, int s, int b) {
		num = n;
		gold = g;
		silver = s;
		bronze = b;
	}

	@Override
	public int compareTo(Nation o) {
		if(this.gold==o.gold) {
			if(this.silver == o.silver)
				return o.bronze-this.bronze;
			else
				return o.silver-this.silver;
		}else
			return o.gold-this.gold;
	}
	
	
}
public class B8979 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Nation> nList = new ArrayList<>();
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			nList.add(new Nation(num,g,s,b));
		}
		
		Collections.sort(nList);
		
		int rate = 1;
        int cnt = 1;

        if (nList.get(0).num == m) {
            System.out.println(1);
            return;
        }

        for (int i = 1; i < n; i++) {

            Nation pre = nList.get(i-1);
            Nation cur = nList.get(i);

            if ((pre.gold != cur.gold) || (pre.silver != cur.silver) || (pre.bronze != cur.bronze)) {
                rate += cnt;
                cnt = 1;
            }
            else
                cnt++;

            if (cur.num == m) {
                System.out.println(rate);
                break;
            }
        }
    }
}
