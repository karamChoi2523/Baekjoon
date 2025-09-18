import java.io.*;
import java.util.*;

public class Main {
	//NWSE
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static int A,B,N,M;
	static Robot[] robots;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		robots = new Robot[N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String d = st.nextToken();
			
			int dir = 0;
			if(d.equals("N")) dir = 0;
			if(d.equals("W")) dir = 1;
			if(d.equals("S")) dir = 2;
			if(d.equals("E")) dir = 3;
			
			robots[i] = new Robot(i, x, y, dir);
		}
		
		boolean gameOver = false;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(st.nextToken());
			char order = st.nextToken().charAt(0);
			int cnt = Integer.parseInt(st.nextToken());
			
			while(cnt-->0) {
				String res = mandate(order, robots[id]);
				if(!res.equals("OK")) {
					gameOver = true;
					System.out.println(res);
					break;
				}
			}
			if(gameOver) break;
		}
        if(!gameOver) System.out.println("OK");
	}
	static String mandate(char c, Robot robot) {
		int dir = robot.dir;
		if(c=='L')
			robot.dir = (dir+1)%4;
		else if(c=='R')
			robot.dir = (dir+3)%4;
		else {
			int nx = robot.x+dx[dir];
			int ny = robot.y+dy[dir];
			
			if(!checkNext(nx, ny)) {
				return "Robot "+String.valueOf(robot.id)+" crashes into the wall";
			}
			Robot checked = checkBoard(nx, ny);
			if(checked!=null) {
				return "Robot "+robot.id+" crashes into robot "+checked.id;
			}
			robot.x = nx;
			robot.y = ny;
		}
		return "OK";
	}
	private static Robot checkBoard(int x, int y) {
		for(int i=1;i<=N;i++) {
			Robot r = robots[i];
			if(r.x==x && r.y==y) return r;
		}
		return null;
	}
	static boolean checkNext(int x, int y) {
		if(x<1 || x>A || y<1 || y>B) return false;
		return true;
	}
	static class Robot{
		int id, x, y, dir;

		public Robot(int id, int x, int y, int dir) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
}
