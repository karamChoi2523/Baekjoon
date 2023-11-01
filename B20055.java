import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20055 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
	
		int[][] map = new int[n*2][2];	//내구도, 0 카운트 여부
		boolean[] robot = new boolean[n];
		
		for(int i=0;i<n*2;i++)
			map[i][0] = Integer.parseInt(st.nextToken());
		
		int cnt=0;
		int time=1;
		
		while(true) {
			//벨트 한 칸 회전
			turnAroundMap(map);
			turnAroundRobot(robot);
			
			for(int i=robot.length-1;i>=0;i--) {
				if(robot[i]) {
					int next = i+1;
					if(next==n) {
						robot[i]=false;
						continue;
					}
					if(next < n && !robot[next]) {
						if(map[next][0]>0) {
							robot[next] = true;
							robot[i] = false;
							map[next][0]--;
							
							if(map[next][0]==0 && map[next][1] ==0) {
								cnt++;
								map[next][1] = 1;
							}
						}
					}
				}
			}
			
			if(!robot[0] && map[0][0]>0) {
				map[0][0]--;
				robot[0] = true;
				if(map[0][0]==0 && map[0][1] ==0) {
					cnt++;
					map[0][1]=1;
				}
			}
			if(cnt >= k)
				break;
			time++;
		}
		System.out.println(time);
	}
	private static void turnAroundRobot(boolean[] robot) {
		for(int i=robot.length-1;i>0;i--)
			robot[i] = robot[i-1];
		robot[0] = false;
	}
	static void turnAroundMap(int[][] map) {
		int temp1 = map[map.length-1][0];
		int temp2 = map[map.length-1][1];
		
		for(int i=map.length-1;i>0;i--) {
			map[i][0] = map[i-1][0];
			map[i][1] = map[i-1][1];
		}
		
		map[0][0] = temp1;
		map[0][1] = temp2;
	}
	
}
