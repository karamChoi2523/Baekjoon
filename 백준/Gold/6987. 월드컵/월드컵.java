import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Country{
		int win, mm, lose;
		
		public Country(int win, int mm, int lose) {
			this.win = win;
			this.mm = mm;
			this.lose = lose;
		}
	}
	static ArrayList<Country> countries;
	static int maxCnt = 5*6/2;
	static int[][] match = new int[maxCnt][2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
				
		int index = 0;
		for(int i=0;i<5;i++)
			for(int j=i+1;j<6;j++) {
				match[index][0] = i;
				match[index][1] = j;
				index++;
			}
		
		StringBuilder sb = new StringBuilder();
		for(int game=0;game<4;game++) {
			countries = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			isAvailable = true;
			
			while(st.hasMoreTokens()) {
				int win = Integer.parseInt(st.nextToken());
				int mm = Integer.parseInt(st.nextToken());
				int lose = Integer.parseInt(st.nextToken());
				
				if(win+mm+lose != 5) {
					isAvailable = false;
					break;
				}
				countries.add(new Country(win, mm, lose));
			}
			if(!isAvailable) {
				sb.append("0 ");
				continue;
			}
			
			isAvailable = false;
			sol(0);
			
			sb.append((isAvailable?1:0)+" ");
		}
		System.out.println(sb);
	}
	static boolean isAvailable = false;
	static void sol(int idx) {
		if(idx==maxCnt) {
			isAvailable = true;
			return;
		}
		
		Country a = countries.get(match[idx][0]);
		Country b = countries.get(match[idx][1]);
		
		if(a.win>0 && b.lose>0) {
			a.win--;
			b.lose--;
			sol(idx+1);
			a.win++;
			b.lose++;
		}
		
		if(a.mm>0 && b.mm>0) {
			a.mm--;
			b.mm--;
			sol(idx+1);
			a.mm++;
			b.mm++;
		}
		
		if(a.lose>0 && b.win>0) {
			a.lose--;
			b.win--;
			sol(idx+1);
			a.lose++;
			b.win++;
		}
	}
}