import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static ArrayDeque<Integer> deque;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		
		int t = sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<t;i++) {
			sb = new StringBuilder();
			
			String p = sc.nextLine();
			int n = sc.nextInt();
			sc.nextLine();
			
			st = new StringTokenizer(sc.nextLine(), "[],");
			
			deque = new ArrayDeque<Integer>();
			
			makeDeque(st, n);
			
			solution(p);
			
			System.out.print(sb);
		}
	}

	private static void solution(String p) {
		boolean isOrder = true;
		
		for(char e : p.toCharArray()) {
			if(e=='R') {
				isOrder= !isOrder;
				continue;
			}
			
			if(isOrder) {
				if(deque.pollFirst()==null) {
					sb.append("error\n");
					return;
				}
			}
			else {
				if(deque.pollLast()==null) {
					sb.append("error\n");
					return;
				}
			}
		}
		
		printRes(isOrder);
	}

	private static void printRes(boolean isOrder) {
		sb.append('[');
		
		if(deque.size()>0) {
			if(isOrder) {
				sb.append(deque.pollFirst());
				
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			}else {
				sb.append(deque.pollLast());
				
				while(!deque.isEmpty())
					sb.append(',').append(deque.pollLast());
			}
		}
		
		sb.append(']').append('\n');
	}

	private static void makeDeque(StringTokenizer st, int n) {
		for(int i=0;i<n;i++)
			deque.add(Integer.parseInt(st.nextToken()));
	}
}
