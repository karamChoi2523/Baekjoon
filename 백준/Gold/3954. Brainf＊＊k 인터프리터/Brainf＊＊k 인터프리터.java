import java.io.*;
import java.util.*;

public class Main {
	static int curr = 0;	//포인터가 가리키는 인덱스
	static int idx = 0;	//이번에는 무슨 명령어인지
	static int inputIndex = 0; //입력의 인덱스
	static int start = -1, end = -1;
	static int[] pArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while(t-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int sm = Integer.parseInt(st.nextToken());	//배열 크기
			int sc = Integer.parseInt(st.nextToken());	//프로그램 코드 크기
			int si = Integer.parseInt(st.nextToken());	//입력 크기

			char[] bp = br.readLine().toCharArray();	//+-.,
			char[] inputArr = br.readLine().toCharArray();	//qwe

			Stack<Integer> stack = new Stack<>();
			pArr = new int[bp.length];
			for(int i=0;i<bp.length;i++) {
				if(bp[i]=='[') {
					stack.add(i);
				}else if(bp[i]==']') {
					int s = stack.pop();
					pArr[s] = i;
					pArr[i] = s;
				}
			}

			curr = 0;
			idx = 0;
			inputIndex = 0;
			int[] arr = new int[sm];

			int cnt = 0;
			int[] count = new int[sc];
			while(idx<sc && cnt++<50000000) {
				count[idx]++;
				movePointer(arr, bp[idx], inputArr, sc, bp);
			}
			if(idx == bp.length)
				System.out.println("Terminates");
			else {
				start = idx;
				end = idx;
				
				while(cnt-->0) {
					movePointer(arr, bp[idx], inputArr, sc, bp);
					start = Math.min(start, idx-1);
					end = Math.max(end, idx);
				}
				System.out.printf("Loops %d %d\n", start, end);
			}
		}
	}
	private static void movePointer(int[] arr, char c, char[] inputArr, int sc, char[] bp) {
		if(c=='-')
			arr[curr] = arr[curr]-1<0?255:arr[curr]-1;
		else if(c=='+')
			arr[curr] = arr[curr]+1>255?0:arr[curr]+1;
			else if(c=='<') {
				curr--;			
				if(curr<0)
					curr = arr.length-1;
			}else if(c=='>') {
				curr++;
				if(curr>=arr.length)
					curr = 0;
			}else if((c=='[' && arr[curr]==0)||(c==']' && arr[curr]!=0))
				idx = pArr[idx];
			else if(c==',') {
				if(inputIndex == inputArr.length)
					arr[curr] = 255;
				else
					arr[curr] = inputArr[inputIndex++];
			}
		idx++;
		return;
	}
}
