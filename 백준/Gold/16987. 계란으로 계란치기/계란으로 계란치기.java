import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Egg{
		int sorneh;  //내구도가 0 이하가 되는 순간
		int weight;
		boolean isBroken;
		
		public Egg(int s, int w) {
			sorneh = s;
			weight = w;
			isBroken = false;
		}
	}
	static int N;
	static int max = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		ArrayList<Egg> eggs = new ArrayList<>();
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			eggs.add(new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		dfs(0, eggs, 0);
		
		System.out.println(max);
	}
	static void dfs(int idx, ArrayList<Egg> eggs, int cnt) {
		if(idx>=eggs.size()) {
			max = Math.max(max, cnt);
			return;
		}
		Egg curr = eggs.get(idx);
		if(curr.isBroken) {
			dfs(idx+1, eggs, cnt);
			return;
		}
		
		boolean did = false;
		for(int i=0;i<eggs.size();i++) {
			if(i==idx) continue;
			
			Egg next = eggs.get(i);
			if(!next.isBroken) {
				did = true;
				int res = attack(curr, next);
				dfs(idx+1,eggs,cnt+res);
				beforeAttack(curr, next);
			}
		}
		
		if(!did) dfs(idx+1, eggs, cnt);
	}
	static int attack(Egg f, Egg s) {
		int cnt = 0;
		f.sorneh -= s.weight;
		s.sorneh -= f.weight;
		
		if(f.sorneh<=0) {
			f.isBroken = true;
			cnt++;
		}
		if(s.sorneh<=0) {
			s.isBroken = true;
			cnt++;
		}
		
		return cnt;
	}
	static void beforeAttack(Egg f, Egg s) {
		f.sorneh += s.weight;
		s.sorneh += f.weight;
		
		if(f.sorneh>0) f.isBroken = false;
		if(s.sorneh>0) s.isBroken = false;
	}
}