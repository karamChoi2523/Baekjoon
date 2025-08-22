import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	static class Node{
		int age, count;
		Node next, prev;

		Node(int age, int count){
			this.age = age;
			this.count = count;
		}
	}
	static class Tree{
		Node head;

		Tree(){
			head = new Node(0,0);
		}

		void addFirst(Node n) {
			n.prev = head;
			if(head.next!=null) {
				n.next = head.next;
				head.next.prev = n;
			}
			head.next = n;
		}

		void remove(Node n) {
			n.prev.next = null;
		}
	}
	static int N,M,K;
	static Tree[][] trees;
	static int[][] A;
	static int[][] soil;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		initialize(br);

		while(K-->0) {
			//봄 : 나이만큼 양분을 먹고 age+1(어린 나무부터)
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++) {
					Node dead = null;
					boolean alive = true;
					Node curr = trees[i][j].head.next;
					while(curr!=null) {
						if(alive) {
							int need = curr.age * curr.count;
							if(soil[i][j]>=need) {
								soil[i][j]-=need;
								curr.age++;
							}else {
								int aliveCnt = soil[i][j]/curr.age;
								soil[i][j] -= curr.age * aliveCnt;
								soil[i][j] += (curr.count-aliveCnt)*(curr.age/2);
								
								if(aliveCnt > 0) {
									curr.count = aliveCnt;
									curr.age++;
									dead = curr.next;
								}else
									dead = curr;
								alive = false;
							}
						}else
							soil[i][j] += curr.count*(curr.age/2);
						curr = curr.next;
					}
					
					if(dead != null)
						trees[i][j].remove(dead);
				}

			//가을 : 번식. 나이가 5배수인 나무만. 인접한 8개 칸에 나이가 1인 나무들 추가
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++) {
					soil[i][j] += A[i][j];
					Node curr = trees[i][j].head.next;
					while(curr!=null) {
						if(curr.age%5==0) {
							for(int d=0;d<8;d++) {
								int nx = i+dx[d];
								int ny = j+dy[d];
								if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
								addNode(nx, ny, curr.count);
							}
						}
						curr = curr.next;
					}
				}
		}

		System.out.println(count());
	}
	static int count() {
		int total = 0;
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++) {
				Node curr = trees[i][j].head.next;
				while(curr!=null) {
					total += curr.count;
					curr = curr.next;
				}
			}
		
		return total;
	}
	static void addNode(int x, int y, int cnt) {
		Node existing = trees[x][y].head.next;
		if(existing!=null && existing.age==1)
			existing.count += cnt;
		else
			trees[x][y].addFirst(new Node(1,cnt));
	}
	static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		trees = new Tree[N][N];
		A = new int[N][N];
		soil = new int[N][N];

		for (int i=0;i<N;i++)
            Arrays.fill(soil[i], 5);
        
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				trees[i][j] = new Tree();
			}
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());

			trees[x][y].addFirst(new Node(z,1));
		}

	}
}
