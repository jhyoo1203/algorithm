import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] grid;
    static int maxSafeZone = 0;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0);
        System.out.println(maxSafeZone);
    }

    static void solve(int count) {
        if (count == 3) {
            simulate();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    solve(count + 1);
                    grid[i][j] = 0;
                }
            }
        }
    }

    static void simulate() {
        int[][] copyGrid = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyGrid[i] = grid[i].clone();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyGrid[i][j] == 2) {
                    dfs(i, j, copyGrid);
                }
            }
        }

        maxSafeZone = Math.max(maxSafeZone, getSafeCount(copyGrid));
    }

    static void dfs(int r, int c, int[][] map) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (map[nr][nc] == 0) {
                    map[nr][nc] = 2;
                    dfs(nr, nc, map);
                }
            }
        }
    }

    static int getSafeCount(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0)
                    count++;
            }
        }
        return count;
    }
}