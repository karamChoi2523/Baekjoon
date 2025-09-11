import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[][] graph;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			graph = new int[N+1][N+1];
			
			//1. 메모 안 된 상태로 초기화
			for(int i=1;i<N+1;i++)
				graph[i][0] = -1;
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
			
				graph[a][b] = 1;	//a보다 b가 크다
			}
			
			//탐색 여부 memo
			// counting만 하는 게 아니라 graph에 저장
			//i의 0열 체크 - 나보다 큰 학생 저장
			//i의 행 체크 - 나보다 작은 학생 저장
			
			//모든 학생에 대해 자신보다 키가 큰 학생 탐색
			//이 과정에서 간접관계를 직접 관계로 경로 압축
			for(int i=1;i<N+1;i++) {
				if(graph[i][0] == -1)	//-1이면(memo가 안 되어있으면) 탐색
					gtDFS(i);
			}
			
			//자신보다 작은 학생 탐색
			for(int i=1;i<N+1;i++) {
				for(int j=1;j<N+1;j++)
					graph[0][i] += graph[j][i];
			}
			
			int answer = 0;
			for(int i=1;i<N+1;i++)
				if(graph[i][0]+graph[0][i]==N-1)
					answer++;
			
			
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
	static void gtDFS(int curr) {
		for(int i=1;i<N+1;i++)
			if(graph[curr][i]==1) {	//curr<i라면
				if(graph[i][0]==-1)	//i가 탐색 전이면 탐색
					gtDFS(i);
				//i가 탐색을 이미 했거나 아님 탐색을 마쳐서 이 위치로 옴
				//관계를 curr에 반영
				if(graph[i][0]>0){ //i보다 큰 학생이 있다면 => curr<i<j => curr<j로 표현
					for(int j=1;j<N+1;j++)
						if(graph[i][j]==1)	//i<j인 학생j를 찾아 curr<j로 표현
							graph[curr][j] = 1;
				}
			}
		//자신보다 큰 학생들 후 카운팅 후 memo
		//처음에 graph[i][0]만 -1로 초기화했으므로
		//graph[0][i]는 0
		int cnt = 0;
		for(int i=1;i<N+1;i++) {
			if(graph[curr][i]>0)
				++cnt;
		}
		graph[curr][0] = cnt;
	}
}
