import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
		boolean answer = true;

		int[] out = new int[n];
		List<Integer>[] graph = new ArrayList[n];
		for(int i=0;i<n;i++)
			graph[i] = new ArrayList<Integer>();

		for(int i=0;i<path.length;i++) {
			int from = path[i][0];
			int to = path[i][1];

			graph[from].add(to);
			graph[to].add(from);
		}

		int[] orders = new int[n];
		for(int i=0;i<order.length;i++) {
			orders[order[i][0]] = order[i][1];
			out[order[i][1]]++;
		}
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited=  new boolean[n];
		q.add(0);
		visited[0] = true;

        Set<Integer> set = new HashSet<>();
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			if(out[curr]>0) continue;
			
			int next = orders[curr];
			out[next]--;
			
			if(!visited[next] && out[next]==0 && set.contains(next)) {
				q.add(next);
				visited[next] = true;
			}
			for(int e : graph[curr]) {
				if(visited[e]) continue;
				if(out[e]>0) {
					set.add(e);
					continue;
				}
				q.add(e);
				visited[e] = true;
			}
		}

		for(int i=0;i<n;i++)
			if(!visited[i]) return false;

		return answer;
	}
}