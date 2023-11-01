import java.util.ArrayDeque;
import java.util.Queue;

//방문체크를 거리로 하는 bfs!!!
public class p6 {
	static class Solution {
	    public int[] dx = {1, 0, 0, -1};
	    public int[] dy = {0, -1, 1, 0};

	    public class Point {
	        public int x, y;
	        public StringBuilder sb;

	        public Point(int x, int y, StringBuilder sb) {
	            this.x = x;
	            this.y = y;
	            this.sb = sb;
	        }
	    }

	    public char convertDir(int d) {
	        if (d == 0) return 'd';
	        if (d == 1) return 'l';
	        if (d == 2) return 'r';
	        if (d == 3) return 'u';
	        return '0';
	    }

	    public String solution(int n, int m, int x, int y, int r, int c, int k) {
	        boolean[][][] chk = new boolean[n][m][k+1];
	        Queue<Point> q = new ArrayDeque<>();
	        q.add(new Point(x-1, y-1, new StringBuilder()));
	        chk[x-1][y-1][0] = true;

	        while(!q.isEmpty()) {
	            Point cur = q.poll();
	            if (cur.x == r-1 && cur.y == c-1) {
	                if (cur.sb.toString().length() == k)
	                    return cur.sb.toString();
	            }
	            if (cur.sb.toString().length() == k)
	                continue;

	            for (int d = 0; d < 4; d++) {
	                int X = cur.x + dx[d];
	                int Y = cur.y + dy[d];
	                if (X < 0 || Y < 0 || X >= n || Y >= m || chk[X][Y][cur.sb.toString().length() + 1])
	                    continue;
	                chk[X][Y][cur.sb.toString().length() + 1] = true;
	                q.add(new Point(X, Y, new StringBuilder(cur.sb).append(convertDir(d))));
	            }
	        }
	        return "impossible";
	    }
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		String ans = s.solution(3, 4, 2, 3, 3, 1, 5);
		System.out.println(ans);
	}

}
