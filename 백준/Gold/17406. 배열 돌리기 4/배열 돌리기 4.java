import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] board;
    static int[][] order;
    static boolean[] visited;
    static int[][] select;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        order = new int[K][3];
        visited = new boolean[K];
        select = new int[K][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            order[i][0] = Integer.parseInt(st.nextToken());
            order[i][1] = Integer.parseInt(st.nextToken());
            order[i][2] = Integer.parseInt(st.nextToken());
        }

        pick(0);
        System.out.println(answer);
    }

    static void pick(int depth) {
        if (depth == K) {
            int[][] copy = copyBoard(board);
            for (int[] op : select) {
                rotate(copy, op[0], op[1], op[2]);
            }
            answer = Math.min(answer, findA(copy));
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                select[depth] = order[i];
                pick(depth + 1);
                visited[i] = false;
            }
        }
    }

    static int[][] copyBoard(int[][] src) {
        int[][] dest = new int[N][M];
        for (int i = 0; i < N; i++)
            System.arraycopy(src[i], 0, dest[i], 0, M);
        return dest;
    }

    static void rotate(int[][] map, int r, int c, int s) {
        r--; c--; // 0-indexed

        for (int layer = 1; layer <= s; layer++) {
            int top = r - layer;
            int left = c - layer;
            int bottom = r + layer;
            int right = c + layer;

            int prev = map[top][left];

            // top row
            for (int j = left + 1; j <= right; j++) {
                int temp = map[top][j];
                map[top][j] = prev;
                prev = temp;
            }

            // right col
            for (int i = top + 1; i <= bottom; i++) {
                int temp = map[i][right];
                map[i][right] = prev;
                prev = temp;
            }

            // bottom row
            for (int j = right - 1; j >= left; j--) {
                int temp = map[bottom][j];
                map[bottom][j] = prev;
                prev = temp;
            }

            // left col
            for (int i = bottom - 1; i >= top; i--) {
                int temp = map[i][left];
                map[i][left] = prev;
                prev = temp;
            }
        }
    }

    static int findA(int[][] map) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++)
                sum += map[i][j];
            min = Math.min(min, sum);
        }
        return min;
    }
}
