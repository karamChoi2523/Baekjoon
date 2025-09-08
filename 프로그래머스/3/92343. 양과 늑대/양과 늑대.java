import java.util.*;

class Solution {
    static int N, answer;
    static int[] infoArr;
    static List<Integer>[] graph;
    static boolean[] visited;

    public int solution(int[] info, int[][] edges) {
    	N = info.length;
    	infoArr = info.clone();
        graph = new ArrayList[N];
        
        for (int i = 0; i < N; i++)
        	graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        answer = 0;
        visited = new boolean[N];

        visited[0] = true;
        ArrayList<Integer> cand = new ArrayList<>();
        for (int v : graph[0])
        	cand.add(v);

        dfs(info[0]==0?1:0, info[0]==1?1:0, cand);
        return answer;
    }
    static void dfs(int sheep, int wolf, ArrayList<Integer> cand) {
        answer = Math.max(answer, sheep);

        for (int i = 0; i < cand.size(); i++) {
            int v = cand.get(i);
            if (visited[v]) continue;

            int ns = sheep + (infoArr[v] == 0 ? 1 : 0);
            int nw = wolf  + (infoArr[v] == 1 ? 1 : 0);
            if (ns <= nw) continue;

            visited[v] = true;

            ArrayList<Integer> nextCand = new ArrayList<>(cand);
            nextCand.remove(i);
            for (int next : graph[v]) {
                if (!visited[next])
                	nextCand.add(next);
            }

            dfs(ns, nw, nextCand);

            visited[v] = false;
        }
    }

}