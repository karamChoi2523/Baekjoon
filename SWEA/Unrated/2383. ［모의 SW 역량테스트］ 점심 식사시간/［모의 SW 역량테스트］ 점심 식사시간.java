import java.util.*;
import java.io.*;

public class Solution {
	static int N, min, cnt;
	static int[][] sList;	//계단 - 사이즈가 고정적일 땐 배열을 쓰는 게 빠르다!!!!!!!
	static ArrayList<Person> pList;	//사람
	static int[] select;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());

			pList = new ArrayList<>();
			sList = new int[2][];	//계단 무조건 2개
			min = Integer.MAX_VALUE;

			//k는 계단수
			for(int i=0,k=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					int temp = Integer.parseInt(st.nextToken());

					if(temp==0) continue;
					if(temp==1)
						pList.add(new Person(i,j));
					else
						sList[k++] = new int[]{i,j,temp};
				}
			}
			//각 사람이 어느 계단을 이용할지에 대해 완탐
			//최악의 시간 복잡도 계산 : 계단 선택 시간 + 계단 대기 시간
			//(계단 선택)최대 맨하탄 거리 == 20 (N이 최대 10)
			//계단 대기 최악의 시간 == 계단 길이*사람수 == 10 * 10 == 100
			//최악의 경우가 100+20, 즉 120이므로 1분씩 흘러가는 구현을 해도
			//120분을 넘지 않는 방식이고 이런 테케가 1000개 정도임
			//120 * 1000 ==> 약 10만

			//1. 부분집합으로 계단을 배정하고
			//2. 계단 시간에 따라 처리하며 내려가는 시뮬레이션으로 구현
			//단, step2는 도착시간 기준으로 정렬 필요

			cnt = pList.size();
			select = new int[cnt];
			divide(0);

			System.out.printf("#%d %d\n",tc, min);
		}
	}
	private static void divide(int idx) {
		if(idx==cnt) {
			makeList();
			return;
		}

		select[idx] = 0;
		divide(idx+1);

		select[idx] = 1;
		divide(idx+1);
	}
	private static void makeList() {
		//계단 0을 내려가는 리스트, 계단 1을 내려가는 리스트 각각 필요
		ArrayList<Person>[] list = new ArrayList[2];
		for(int i=0;i<2;i++)
			list[i] = new ArrayList<>();

		for(int i=0;i<cnt;i++) {
			Person p = pList.get(i);
			p.init();	//초기화
			int no = select[i];	//계단 번호

			p.arrivalTime = Math.abs(p.calTime(sList[no][0],sList[no][1]));
			list[no].add(p);
		}

		//각각의 계단의 사람 리스트들을 이용해 내려가기 구현
		int timeA = processDown(list[0], sList[0][2]);
		int timeB = processDown(list[1], sList[1][2]);
		int res = Math.max(timeA, timeB);

		min = Math.min(min, res);
	}
	private static int processDown(ArrayList<Person> list, int k) {
		if(list.size()==0)
			return 0;

		Collections.sort(list);	//도착순 정렬

		int time = list.get(0).arrivalTime;
		int size = list.size();	//계단 이용자수
		int ingCnt=0, cCnt=0;	//내려가는 중, 완료된 사람수

		while(true) {	//매분마다 사람들의 상태를 업데이트
			for(int i=0;i<size;i++) {
				Person p = list.get(i);
				if(p.status==C) continue;
				if(p.arrivalTime == time)
					p.status = W;
				else if(p.status==W && ingCnt<3) {
					p.status = D;
					p.downCnt = 1;
					ingCnt++;
				}else if(p.status==D) {
					if(p.downCnt < k)
						p.downCnt++;
					else {
						p.status = C;
						ingCnt--;
						cCnt++;
					}
				}
			}
			if(cCnt == size) break;
			time++;
		}
		return time;
	}
	static final int M=1,W=2,D=3,C=4;	//이동, 대기, 내려가는 중, 완료
	static class Person implements Comparable<Person>{
		int x, y, status, arrivalTime, downCnt;	//내려간 계단 수

		public Person(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int calTime(int x, int y) {
			return Math.abs(this.x-x)+Math.abs(this.y-y);
		}
		void init() {
			arrivalTime = downCnt = 0;
			status = M;
		}

		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.arrivalTime, o.arrivalTime);
		}
	}
}
