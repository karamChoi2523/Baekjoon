import java.io.*;
import java.util.*;

public class Main {
	static int[][] board = new int[101][101];
	static int r,c,k;
	static int xLen, yLen;
	
	static class Stuff implements Comparable<Stuff>{
		int num;
		int count;
		
		public Stuff(int num, int count) {
			this.num = num;
			this.count = count;			
		}
		
		@Override
		public int compareTo(Stuff o) {
			if(this.count == o.count)
				return this.num - o.num;
			return this.count-o.count;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.valueOf(st.nextToken());
		c = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
				
		for(int i=1;i<4;i++) {
			st = new StringTokenizer(br.readLine());

			for(int j=1;j<4;j++)
				board[i][j] = Integer.valueOf(st.nextToken());
		}
	
		xLen = 3;
		yLen = 3;
		int time = 0;
		while(true) {
			if(time>100) {
				System.out.println(-1);
				return;
			}
			if(board[r][c]==k)
				break;
			
			if(xLen>=yLen)
				for(int i=1;i<xLen+1;i++)
					solutionR(i);
			else
				for(int j=1;j<yLen+1;j++)
					solutionC(j);
						
			time++;
		}
		
		System.out.println(time++);
	}

	static public void solutionR(int row) {
		PriorityQueue<Stuff> pq = new PriorityQueue<>();
		Map<Integer, Integer> hMap = new HashMap<>();
		
		for(int i=1;i<yLen+1;i++) {
			if(board[row][i]==0)
				continue;
			hMap.compute(board[row][i], (num, count)->count==null?1:count+1);
		}
		
		hMap.forEach((k,v)->pq.add(new Stuff(k,v)));
		
		int idx=1;
		
		while(!pq.isEmpty()) {
			Stuff curr = pq.poll();
			
			board[row][idx++] = curr.num;
			board[row][idx++] = curr.count;
		}
		
		yLen = Math.max(yLen, idx);
		
		while(idx<100) {
			board[row][idx++] = 0;
			board[row][idx++] = 0;
		}
	}
	
	static public void solutionC(int col) {
		PriorityQueue<Stuff> pq = new PriorityQueue<>();
		Map<Integer, Integer> hMap = new HashMap<>();
		
		for(int i=1;i<xLen+1;i++) {
			if(board[i][col]==0)
				continue;
			hMap.compute(board[i][col], (num, count)->count==null?1:count+1);
		}
		
		hMap.forEach((k,v)->pq.add(new Stuff(k,v)));
		
		int idx=1;
		
		while(!pq.isEmpty()) {
			Stuff curr = pq.poll();
			
			board[idx++][col] = curr.num;
			board[idx++][col] = curr.count;
		}
		
		xLen = Math.max(xLen, idx);
		
		while(idx<100) {
			board[idx++][col] = 0;
			board[idx++][col] = 0;
		}
	}
}
