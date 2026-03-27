import java.util.*;
import java.io.*;

public class Main {
    static int R, C;
    static char[][] grid;
    static boolean[] alphabetVisited = new boolean[26];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        alphabetVisited[grid[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(maxCount);
    }

    static void dfs(int r, int c, int count) {
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                int alphabetIdx = grid[nr][nc] - 'A';
                
                if (!alphabetVisited[alphabetIdx]) {
                    alphabetVisited[alphabetIdx] = true;
                    dfs(nr, nc, count + 1);
                    alphabetVisited[alphabetIdx] = false;
                }
            }
        }
    }
}