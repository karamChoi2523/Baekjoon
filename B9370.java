import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B9370 { //
	static int[][] list;
	static int[] xList;
	static boolean[] checkList;
	static ArrayList<Integer> result;
	
	static int n, m, t, s, g, h;
	
	static final int INF = 10_000_000;
	
	static class Node implements Comparable<Node>{
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tcs = sc.nextInt();	//testcase 개수
		
		for(int r=0;r<tcs;r++) {
			n = sc.nextInt();	//교차로 개수
			m = sc.nextInt();	//도로 개수
			t = sc.nextInt();	//목적지 후보 개수
			
			s = sc.nextInt();	//출발지
			g = sc.nextInt();	//교차로1
			h = sc.nextInt();	//교차로2
			
			list = new int[n+1][n+1];	//[0]과 [1] 사이에 길이가 [2]인 양방향 도로 -> 그래프.[2]는 가중치.
			xList = new int[n+1];	//목적지 후보 리스트 -> 불가능한 경우 제외하고 오름차순 정렬 후 출력
			
			for(int j = 0 ; j < list.length; j++)
                Arrays.fill(list[j], INF);
			Arrays.fill(xList, INF);
			checkList = new boolean[n+1];
			
			
			for(int i=0;i<m;i++) {
				int p1 = sc.nextInt();
				int p2 = sc.nextInt();
				int dist = sc.nextInt();
				
				list[p1][p2] = list[p2][p1] = dist*2;	//짝수
			}	
			list[h][g] = list[g][h] = list[h][g] -1;	//홀수
			result = new ArrayList<>();
			
			for(int i=0;i<t;i++)
				result.add(sc.nextInt());
			
			solution();
			
			Collections.sort(result);
			
			for(int res : result) {
				if(xList[res]%2==1)
					System.out.print(res+" ");
			}
			System.out.println();
		
		}
	}

	private static void solution() {
		
		dijkstra();
	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0));
		xList[s]=0;
		
		while(!pq.isEmpty()) {
			Node pick = pq.poll();
			
			int curr = pick.v;	//현위치
			if(checkList[curr]) continue;	//이미 방문했으면 continue;
			
			checkList[curr] = true;
			
			for(int i=1;i<=n;i++) {
				if(!checkList[i] && xList[i] > xList[curr]+list[curr][i]) {
					xList[i] = xList[curr]+list[curr][i];
					pq.add(new Node(i, xList[i]));
				}
			}
		}
		
	}
}
