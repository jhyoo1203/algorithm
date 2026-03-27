import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] board;
    static boolean[][] visited;
    static int[] maxCount = new int[2];

    static int[] dy = { -1, -1 };
    static int[] dx = { -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 검
        dfs(0, 0, 0, 0);
        // 흰
        dfs(0, 1, 1, 0);

        System.out.println(maxCount[0] + maxCount[1]);
    }

    static void dfs(int y, int x, int color, int count) {
        if (x >= n) {
            y++;
            if (y < n) {
                x = (y % 2 == color % 2) ? 0 : 1;
            }
        }

        if (y >= n) {
            maxCount[color] = Math.max(maxCount[color], count);
            return;
        }

        if (board[y][x] == 1 && canPlace(y, x)) {
            visited[y][x] = true;
            dfs(y, x + 2, color, count + 1);
            visited[y][x] = false;
        }

        dfs(y, x + 2, color, count);
    }

    static boolean canPlace(int y, int x) {
        for (int i = 0; i < 2; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            while (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                if (visited[ny][nx]) return false;

                ny += dy[i];
                nx += dx[i];
            }
        }
        return true;
    }
}