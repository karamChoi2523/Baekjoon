import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Record{
	int team;
	int time;
	
	public Record(int team, int time) {
		this.team = team;
		this.time = time;
	}
}
public class B2852 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		int[] score = {0,0};
		int[] ans_time = {0,0};
		Record[] records = new Record[n];
		
		for(int i=0;i<n;i++) {			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int win = Integer.parseInt(st.nextToken());
			String[] t = st.nextToken().split(":");
			
			int time = Integer.parseInt(t[0])*60+Integer.parseInt(t[1]);
			
			records[i] = new Record(win, time);
		}
		
		int win_team = records[0].team;
		score[win_team-1]+=1;
		int min_time = records[0].time;
		
		for(int i=1;i<n;i++) {
			int tmp_team = records[i].team;
			int tmp_time = records[i].time;
			
			if(score[0]>score[1])
				ans_time[0]+=(tmp_time-min_time);
			else if(score[0]<score[1])
				ans_time[1] += (tmp_time-min_time);
			
			score[tmp_team-1]+=1;
			
			min_time = tmp_time;
		}
		
		if(score[0]>score[1])
			ans_time[0]+=(48*60-min_time);
		if(score[0]<score[1])
			ans_time[1]+=(48*60-min_time);
		
		for(int i=0;i<2;i++) {
			int h = ans_time[i]/60;
			int m = ans_time[i]%60;
			
			String hour;
			String min;
			
			if(h/10==0)
				hour="0"+String.valueOf(h);
			else
				hour=String.valueOf(h);
			
			if(m/10==0)
				min="0"+String.valueOf(m);
			else
				min=String.valueOf(m);
		
			System.out.println(hour+":"+min);
		}
	        
	}
	
}
