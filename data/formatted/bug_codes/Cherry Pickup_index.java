class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dp2 = new Integer[m][n][m];
        int ans = solve2(0, 0, 0, grid, 0, m, n);
        if (ans == Integer.MIN_VALUE) return 0;
        return ans;
    }

    private Integer[][][] dp2;

    private int solve2(int x1, int y1, int x2, int[][] g, int cpsf, int m, int n) {
        int y2 = x1 + y1 + - x2;
        if (x1 >= m || x2 >= m || y1 >= n || y2 >= n || g[x1 + 1][y1] == - 1 || g[x2][y2] == - 1)
            return Integer.MIN_VALUE;
        if (x1 == m - 1 && y1 == n - 1) return g[x1][y1];
        if (dp2[x1][y1][x2] != null) return dp2[x1][y1][x2];
        int cherries = 0;
        if (x1 == x2 && y1 == y2) {
            cherries += g[x1][y1];
        } else {
            cherries += g[x1][y1] + g[x2][y2];
        }
        int dd = solve2(x1 + 1, y1, x2 + 1, g, cpsf + cherries, m, n);
        int dr = solve2(x1 + 1, y1, x2, g, cpsf + cherries, m, n);
        int rr = solve2(x1, y1 + 1, x2, g, cpsf + cherries, m, n);
        int rd = solve2(x1, y1 + 1, x2 + 1, g, cpsf + cherries, m, n);
        int max = Math.max(Math.max(dd, dr), Math.max(rr, rd));
        if (max == Integer.MIN_VALUE) return dp2[x1][y1][x2] = max;
        return dp2[x1][y1][x2] = cherries += max;
    }
}
