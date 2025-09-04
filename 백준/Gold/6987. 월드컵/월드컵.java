import java.util.*;
import java.io.*;

public class Main {
	static int[] winArr;
	static int[] mmArr;
	static int[] loseArr;
	static int[][] pairs = {
			{0,1},{0,2},{0,3},{0,4},{0,5},{1,2},{1,3},{1,4},{1,5},{2,3},{2,4},{2,5},{3,4},{3,5},{4,5}	
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int step=0;step<4;step++) {
			st = new StringTokenizer(br.readLine());
			
			winArr = new int[6];
			mmArr = new int[6];
			loseArr = new int[6];
			int totalWin = 0;
			int totalMM = 0;
			int totalLose = 0;
			boolean check = true;
			for(int i=0;i<6;i++) {
				int win = Integer.parseInt(st.nextToken());
				int mm = Integer.parseInt(st.nextToken());
				int lose = Integer.parseInt(st.nextToken());
				
				if(win+mm+lose!=5) {
					check = false;
					break;
				}
				
				totalWin += win;
				totalMM += mm;
				totalLose += lose;
				
				winArr[i] = win;
				mmArr[i] = mm;
				loseArr[i] = lose;
			}
			if(totalWin != totalLose) check = false;
			if(totalMM%2 != 0) check = false;
			if(totalWin+totalLose+totalMM != 30) check = false;
			
			if(!check) {
				sb.append(0+" ");
				continue;
			}
			
			if(backt(0))
				sb.append(1+" ");
			else
				sb.append(0+" ");
		}
		System.out.println(sb);
	}
	static boolean backt(int idx) {
		if(idx==15) {
			for(int i=0;i<6;i++) {
				if(winArr[i]>0 || loseArr[i]>0 || mmArr[i]>0)
					return false;
			}
			return true;
		}

		int teamA = pairs[idx][0];
		int teamB = pairs[idx][1];
		
		if(winArr[teamA]>0 && loseArr[teamB]>0) {
			winArr[teamA]--;
			loseArr[teamB]--;
			if(backt(idx+1))
				return true;
			winArr[teamA]++;
			loseArr[teamB]++;
		}
		
		if(loseArr[teamA]>0 && winArr[teamB]>0) {
			loseArr[teamA]--;
			winArr[teamB]--;
			if(backt(idx+1))
				return true;
			loseArr[teamA]++;
			winArr[teamB]++;
		}
		
		if(mmArr[teamA]>0 && mmArr[teamB]>0) {
			mmArr[teamA]--;
			mmArr[teamB]--;
			if(backt(idx+1))
				return true;
			mmArr[teamA]++;
			mmArr[teamB]++;
		}
		
		return false;
	}
}
