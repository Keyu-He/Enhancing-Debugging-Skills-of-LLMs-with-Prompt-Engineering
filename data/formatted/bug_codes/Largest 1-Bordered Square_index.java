class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] rows = new int[m][n];
        int[][] cols = new int[m][n];
        int res = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    rows[r][c] = 0;
                    cols[r][c] = 0;
                } else {
                    rows[r][c] = c == 0 ? 1 : rows[r][c - 1] + 1;
                    cols[r][c] = r == 0 ? 1 : cols[r - 1][c] + 1;
                    if (res >= rows[r][c] || res >= cols[r][c]) {
                        continue;
                    }
                    res = Math.max(res, getD(rows, cols, r, c));
                }
            }
        }
        return res * res;
    }

    private int getD(int[][] rows, int[][] cols, int row, int col) {
        int len = Math.min(rows[row][col], cols[row][col]);
        for (int i = len - 1; i >= 0; i--) {
            if (rows[row - i][col] > i && cols[row][col - i] > i) {
                return i + 1;
            }
        }
        return 1;
    }
}
