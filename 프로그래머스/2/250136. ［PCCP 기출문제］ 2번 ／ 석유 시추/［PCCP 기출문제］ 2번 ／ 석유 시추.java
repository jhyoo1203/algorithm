import java.util.*;

class Solution {
    
    int[] totalOil;
    int n, m;
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        
        totalOil = new int[m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1) {
                    bfs(land, new int[]{i, j});                
                }
            }
        }
        
        int maxOil = 0;
        for (int i = 0; i < m; i++) {
            if (totalOil[i] > maxOil) {
                maxOil = totalOil[i];
            }
        }

        return maxOil;
    }
    
    private void bfs(int[][] land, int[] startPos) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(startPos);
        land[startPos[0]][startPos[1]] = -1;
        
        Set<Integer> visitedCols = new HashSet<>();
        int cnt = 1;
        visitedCols.add(startPos[1]);
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                
                if (land[nr][nc] == 1) {
                    land[nr][nc] = -1;
                    cnt++;
                    visitedCols.add(nc);
                    queue.offer(new int[] {nr, nc});
                }
            }
        }
        
        for (int col : visitedCols) {
            totalOil[col] += cnt;
        }
    }
}