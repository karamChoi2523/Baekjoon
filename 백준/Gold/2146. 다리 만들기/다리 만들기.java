import java.io.*;
import java.util.*;

public class Main {
    static int N, min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[] dR = {1, -1, 0, 0};
    static int[] dC = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j<N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int type = 1;
        visited = new boolean[N][N];
        //섬 별로 나누기
        for(int i =0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(map[i][j] == 0)
                    continue;
                if(visited[i][j])
                    continue;

                typeCheck(i, j, type);
                type++;
            }
        }

        //가장 가까운 거리의 섬 탐색
        visited = new boolean[N][N];
        for(int i =0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(map[i][j] == 0)
                    continue;
                if(visited[i][j])
                    continue;

                bfs(i, j, map[i][j]);
            }
        }

        System.out.println(min);
    }

    static void typeCheck(int row, int col, int type){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(row, col));
        visited[row][col] = true;
        map[row][col] = type;

        while(!q.isEmpty()){
            Node vertex = q.poll();

            for(int i = 0; i<4; i++){
                int dr = vertex.row + dR[i];
                int dc = vertex.col + dC[i];

                if(dr<0||dc<0||dr>=N||dc>=N)
                    continue;
                if(map[dr][dc] == 0)
                    continue;
                if(visited[dr][dc])
                    continue;

                visited[dr][dc] = true;
                map[dr][dc] = type;
                q.offer(new Node(dr, dc));
            }
        }
    }

    static void bfs(int row, int col, int type){
        visited[row][col] = true;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(row, col, 0));

        boolean[][] isVisited = new boolean[N][N];
        isVisited[row][col] = true;

        while(!q.isEmpty()){
            Node vertex = q.poll();

            for(int i = 0; i<4; i++){
                int dr = vertex.row + dR[i];
                int dc = vertex.col + dC[i];

                if(dr<0||dc<0||dr>=N||dc>=N)
                    continue;
                if(map[dr][dc] == type) {
                    visited[dr][dc] = true;
                    continue;
                }
                if(isVisited[dr][dc])
                    continue;

                if(map[dr][dc] == 0) {
                    q.offer(new Node(dr, dc, vertex.len+1));
                    isVisited[dr][dc] = true;
                }
                else if(map[dr][dc] != type){
                    min = Math.min(min, vertex.len);
                    return;
                }
            }
        }
    }
}
class Node{
    int row, col, len;

    Node(int row, int col){
        this.row = row;
        this.col = col;
    }
    Node(int row, int col, int len){
        this.row = row;
        this.col = col;
        this.len = len;
    }
}