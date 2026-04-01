import java.util.*;

class Solution {
    static int m, n, h, w;
    static int[][] drops;

    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        this.m = m;
        this.n = n;
        this.h = h;
        this.w = w;
        this.drops = drops;

        int lo = 0;
        int hi = drops.length;
        
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (findPosition(mid) != null) lo = mid;
            else hi = mid - 1;
        }

        return findPosition(lo);
    }

    private int[] findPosition(int k) {
        int[][] psum = new int[m + 1][n + 1];
        for (int i = 0; i < k; i++)
            psum[drops[i][0] + 1][drops[i][1] + 1] = 1;

        for (int r = 1; r <= m; r++)
            for (int c = 1; c <= n; c++)
                psum[r][c] += psum[r-1][c] + psum[r][c-1] - psum[r-1][c-1];

        for (int r = 0; r <= m - h; r++)
            for (int c = 0; c <= n - w; c++)
                if (psum[r+h][c+w] - psum[r][c+w] - psum[r+h][c] + psum[r][c] == 0)
                    return new int[]{r, c};

        return null;
    }
}